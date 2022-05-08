package presentationlayer;

import businesslayer.BaseProduct;
import businesslayer.DeliveryService;
import businesslayer.MenuItem;
import businesslayer.User;
import presentationlayer.admin.AddProductGUI;
import presentationlayer.admin.ModifyProductGUI;
import presentationlayer.admin.ReportGUI;
import presentationlayer.client.MenuGUI;
import presentationlayer.client.OrderGUI;
import presentationlayer.client.SearchGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    private HomePage homePage;
    private RegisterGUI registerGUI;
    private AdminGUI adminGUI;
    private ClientGUI clientGUI;
    private EmployeeGUI employeeGUI;
    private AddProductGUI addProductGUI;
    private ModifyProductGUI modifyProductGUI;
    private OrderGUI orderGUI;
    private ReportGUI reportGUI;

    private int currentUserId=0;

    private DeliveryService deliveryService=new DeliveryService();

    public Controller(HomePage hp, RegisterGUI r, AdminGUI a, ClientGUI c, EmployeeGUI e, AddProductGUI ad, ModifyProductGUI mp,OrderGUI o,ReportGUI rr) {
        homePage = hp;
        registerGUI = r;
        adminGUI = a;
        clientGUI = c;
        employeeGUI = e;
        addProductGUI = ad;
        modifyProductGUI = mp;
        orderGUI=o;
        reportGUI=rr;

        homePage.addLoginListener(new LoginListener());
        homePage.addRegisterListener(new RegisterListener());

        adminGUI.addGenerateProductsListener(new GenerateProductsListener());
        adminGUI.addAddProductsListener(new AddProductsListener());
        adminGUI.addModifyProductListener(new ModifyProductsListener());
        adminGUI.addDeleteProductListener(new DeleteProductsListener());
        adminGUI.addGenerateReportListener(new GenerateReportListener());

        registerGUI.addRegisterConfirmListener(new ConfirmRegisterListener());

        clientGUI.addCreateOrderListener(new CreateOrderListener());
        clientGUI.addViewMenuListener(new ViewMenuListener());
        clientGUI.addSearchProductListener(new SearchProductsListener());

        orderGUI.addSubmitOrderListener(new CreateOrderSubmitListener());

        reportGUI.addReportSubmitListener(new SubmitGenerateReportListener());


    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<User> users = deliveryService.getUsers();
            String username = homePage.getUsername();
            String password = homePage.getPassword();
            for (User it : users) {
                if (it.getUser().compareToIgnoreCase(username) == 0 && it.getPass().compareToIgnoreCase(password) == 0) {
                    if (it.getType() == 0)
                        adminGUI.setVisible(true);
                    if (it.getType() == 1)
                        employeeGUI.setVisible(true);
                    if (it.getType() == 2)
                        clientGUI.setVisible(true);
                    currentUserId=it.getIdUser();
                }
            }
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerGUI.setVisible(true);
        }
    }

    class SubmitGenerateReportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            deliveryService.createReport(reportGUI.getStartHour(),reportGUI.getEndHour(), reportGUI.getFreqProduct(), reportGUI.getFreqClients(), reportGUI.getMaxPrice(), reportGUI.getDay());

        }
    }

    class ConfirmRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deliveryService.createUser(registerGUI.getUsername(), registerGUI.getPassword(), registerGUI.getUserType());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    class GenerateProductsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.generateProducts();
        }
    }

    class GenerateReportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            reportGUI.setVisible(true);
        }
    }

    class AddProductsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addProductGUI.setVisible(true);
        }
    }

    class ModifyProductsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            modifyProductGUI.setVisible(true);
        }
    }

    class DeleteProductsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.deleteProduct(adminGUI.getDeleteIndex());
        }
    }
    class ViewMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct p=new BaseProduct();
            List<String> columnNames = p.getColumnNames();
            List<BaseProduct> rows = deliveryService.getProducts();
            //System.out.println(rows.size());
            //System.out.println(columnNames.size());
            JFrame frame = new MenuGUI(columnNames, rows);
            frame.setTitle("Menu");
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    class SearchProductsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct p=new BaseProduct();
            List<String> columnNames = p.getColumnNames();
            List<BaseProduct> rows=new ArrayList<>() ;
            rows=deliveryService.getProducts().stream().filter(pro->pro.getTitle().compareToIgnoreCase(clientGUI.getProductName())==0).collect(Collectors.toList());
            JFrame frame = new SearchGUI(columnNames, rows);
            frame.setTitle("Search results");
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    class CreateOrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            orderGUI.setVisible(true);
        }
    }

    class CreateOrderSubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Set<MenuItem> m=new HashSet<>();
            String product1=orderGUI.getProduct1();
            String product2=orderGUI.getProduct2();
            String product3=orderGUI.getProduct3();

            int p1=0;
            int p2=0;
            int p3=0;
            for(BaseProduct it:deliveryService.getProducts()){
                String string1=product1.replace(" ","");
                String string2=it.getTitle().replace(" ","");
                if(string1.compareToIgnoreCase(string2)==0) {
                    m.add(it);
                    p1=it.getPrice();
                }
            }
            for(BaseProduct it:deliveryService.getProducts()){
                String string1=product2.replace(" ","");
                String string2=it.getTitle().replace(" ","");
                if(string1.compareToIgnoreCase(string2)==0) {
                    m.add(it);
                    p2 = it.getPrice();
                }
            }
            for(BaseProduct it:deliveryService.getProducts()){
                String string1=product3.replace(" ","");
                String string2=it.getTitle().replace(" ","");
                if(string1.compareToIgnoreCase(string2)==0) {
                    m.add(it);
                    p3 = it.getPrice();
                }
            }

            Date d=new Date();

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat timeFormat=new SimpleDateFormat("HH");


            //Create Bill in format txt

        PrintStream fileOut;
            fileOut = null;
            try {
            fileOut = new PrintStream("./bill.txt");
            } catch (FileNotFoundException ex) {
             ex.printStackTrace();
             }
             System.setOut(fileOut);

            int suma=p1+p2+p3;
            try {
                deliveryService.createNewOrder(currentUserId,String.valueOf(formatter.format(d)),String.valueOf(timeFormat.format(d)),m,suma);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("Chitanta comanda: "+deliveryService.getNumberOfOrders());
            System.out.println("Data: "+formatter.format(d));
            System.out.println("Ora: "+timeFormat.format(d));
            System.out.println("Produs 1: "+product1+"......"+p1);
            System.out.println("Produs 2: "+product2+"......"+p2);
            System.out.println("Produs 3: "+product3+"......"+p3);
            System.out.println("Pret total: "+suma);


        }
    }

}
