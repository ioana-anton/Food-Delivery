package businesslayer;

import datalayer.Serializator;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing{
  private  Map<Order, Set<MenuItem>> map=new HashMap<>();
  private List<BaseProduct> products=new ArrayList<>();
  private List<CompositeProduct> compositeProducts=new ArrayList<>();
  private ArrayList<User>users=new ArrayList<>();
  private int numberOfOrders=0;

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor){
        Map<Object, Boolean> map=new ConcurrentHashMap<>();
        return t-> map.putIfAbsent(keyExtractor.apply(t),Boolean.TRUE)==null;
    }

    @Override
    public void generateProducts() {
        List<String> stringList=new ArrayList<String>();
        try {
            stringList = Files.lines(Paths.get("C:\\Users\\ioana\\OneDrive - Technical University of Cluj-Napoca\\an2\\sem2\\tp\\laborator\\PT2021_30225_Anton_Ioana_Assignment_4\\products.csv")).collect(Collectors.toList());
        } catch (IOException e){
            e.printStackTrace();
        }
        stringList.remove(0);
        ArrayList<BaseProduct> originalProducts=new ArrayList<>();
        int i=0;
        for(String it: stringList){
            String[] line=it.split(",");
            BaseProduct product=new BaseProduct(i,line[0],Double.parseDouble(line[1]),Integer.parseInt(line[2]),Integer.parseInt(line[3]),Integer.parseInt(line[4]),Integer.parseInt(line[5]),Integer.parseInt(line[6]));
            originalProducts.add(product);
            i++;
        }
        products=originalProducts.stream().filter(distinctByKey(p->p.getTitle())).collect(Collectors.toList());
        System.out.println(products.size());
        System.out.println(originalProducts.size());
    }

    @Override
    public void addProduct(String title, double rating, int calories, int proteins, int fats, int sodium, int price) {
        products.add(new BaseProduct(products.size(), title,rating,calories,proteins,fats,sodium,price));
        products.get(products.size()).setIndex(products.size());
    }

    @Override
    public void addCompositeProducts(int index1, int index2, int index3) {
        int lastIndex=compositeProducts.size();
        compositeProducts.add(new CompositeProduct());
        compositeProducts.get(lastIndex).addProduct(products.get(index1));
        compositeProducts.get(lastIndex).addProduct(products.get(index2));
        compositeProducts.get(lastIndex).addProduct(products.get(index3));
        compositeProducts.get(lastIndex).setIndex(lastIndex);
    }

    @Override
    public void deleteProduct(int index) {
        products.remove(index);
    }

    @Override
    public void modifyProduct(int index, String title, double rating, int calories, int proteins, int fats, int sodium, int price) {
        products.get(index).setTitle(title);
        products.get(index).setRating(rating);
        products.get(index).setCalories(calories);
        products.get(index).setProteins(proteins);
        products.get(index).setFats(fats);
        products.get(index).setSodium(sodium);
        products.get(index).setPrice(price);
    }

    @Override
    public void createReport(int startHour, int endHour,int freqProduct, int freqClients, int price, int day) {
        PrintStream fileOut;
        fileOut = null;
        try {
            fileOut = new PrintStream("./report.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.setOut(fileOut);
        Set<Map.Entry<Order,Set<MenuItem>>> x=map.entrySet();

        // intervalul de timp
        List<Map.Entry<Order,Set<MenuItem>>> result1= x.stream().filter(t->t.getKey().getTime()<endHour&&t.getKey().getTime()>=startHour).collect(Collectors.toList());
        System.out.println("Orders between "+startHour +" and "+endHour);
        for(Map.Entry<Order,Set<MenuItem>> it:result1){
            System.out.println("Order id: "+it.getKey().getOrderID());
        }

        //produse comandate de mai mult de freqProduct

        List<MenuItem> prod=new ArrayList<>();
        for(Map.Entry<Order,Set<MenuItem>> it:x){
            prod.addAll(it.getValue());
        }

        Map<String,Long>result2= prod.stream().collect(Collectors.groupingBy(MenuItem::getTitle,Collectors.counting()));

        Map<String,Long>finalResult2=result2.entrySet().stream().filter(t->t.getValue()>=freqProduct).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println("Produse comandate mai mult de "+ freqProduct);
        System.out.println(finalResult2.toString());

        //clientii care au comandat mai mult de freqClient ori
        List<Order> clients=new ArrayList<>();
        for(Map.Entry<Order,Set<MenuItem>> it:x){
            clients.add(it.getKey());
        }

        Map<Integer,Long>result3= clients.stream().filter(t->t.getTotalPrice()>=price).collect(Collectors.groupingBy(Order::getIntegerClientID,Collectors.counting()));
        Map<Integer,Long>finalResult3=result3.entrySet().stream().filter(t->t.getValue()>=freqClients).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println("Clientii care au comandat mai mult de "+freqClients+" cu o suma mai mare de "+ price);
        System.out.println(finalResult3.toString());

        //the products ordered within a specified day with the number of times they have
        //     * been ordered.

        Map<Integer,Long>result4= clients.stream().filter(t->t.getDateAsInt()==day).collect(Collectors.groupingBy(Order::getDateAsInt,Collectors.counting()));

        Map<Integer,Long>finalResult4=result4.entrySet().stream().filter(t->t.getValue()==day).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println("Comenzi din data de "+day);
        System.out.println(result4.toString());
    }

    /**
     *
     */
    @Override
    public void createNewOrder(int idUser,String date,String time,Set<MenuItem> items,int totalP) throws IOException {
        Order o=new Order(numberOfOrders,idUser,date,time);
        map.put(o,items);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Orders.ser"));

        o.writeObject(out);
        o.setTotalPrice(totalP);
        out.close();
        numberOfOrders++;
    }

    public void createUser(String user, String pass, int type) throws IOException {
        User x=new User(user,pass,type);
        users.add(x);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Accounts.ser"));
        x.writeObject( out );
        out.close();
    }

    public int readUserInfo(String username, String password) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream( new FileInputStream("Account.ser"));
        User b=new User();
        b.readObject(in);
        in.close();
        if(b.getUser().compareToIgnoreCase(username)==0&&b.getPass().compareToIgnoreCase(password)==0)
            return 0;
        return -1;
    }

    public Map<Order, Set<MenuItem>> getMap() {
        return map;
    }

    public List<BaseProduct> getProducts() {
        return products;
    }

    public List<CompositeProduct> getCompositeProducts() {
        return compositeProducts;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
