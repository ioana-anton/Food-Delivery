package businesslayer;

import java.io.IOException;
import java.util.Set;

public interface IDeliveryServiceProcessing {

    //operatii admin

    /**
     * @pre true
     * @post se va popula lista de produse
     */
    void generateProducts();

    /**
     *
     * @param title
     * @param rating
     * @param calories
     * @param proteins
     * @param fats
     * @param sodium
     * @param price
     * @pre trebuie sa avem datele din interfata
     * @post se va adauga un nou produs in lista
     */
    void addProduct(String title, double rating, int calories, int proteins, int fats, int sodium, int price);

    /**
     *
     * @param index1
     * @param index2
     * @param index3
     * @pre trebuie sa avem datele din interfata specifica de utilizator
     * @post se va introduce un produs
     */
    void addCompositeProducts(int index1, int index2, int index3);
    void deleteProduct(int index);
    void modifyProduct(int index,String title, double rating, int calories, int proteins, int fats, int sodium, int price);
    void createReport(int startHour, int endHour,int freqProduct, int freqClients, int price, int day);
    //operatii client
    void createNewOrder(int idUser, String date,String time, Set<MenuItem> items,int price) throws IOException;
}
