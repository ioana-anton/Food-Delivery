package businesslayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Order {
    private int orderID;
    private int clientID;
    private String orderDate;
    private String time;
    private int totalPrice;

    public Order(int orderID, int clientID, String orderDate,String time) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.orderDate = orderDate;
        this.time=time;
    }

    public Order() {
    }

    public int hashCode(){
        int code=0;
        String[]date=orderDate.split("\\.");
        code=orderID+clientID+Integer.parseInt(date[0])+Integer.parseInt(date[1]);
        return code;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getClientID() {
        return clientID;
    }
    public Integer getIntegerClientID(){
        return new Integer(clientID);
    }
    public int getTotalPrice(){return totalPrice;}

    public String getOrderDate() {
        return orderDate;
    }

    public void readObject(ObjectInputStream in ) throws ClassNotFoundException
    {

        try{
            orderID = ( int )in.readObject();
            clientID = ( int )in.readObject();
            orderDate=( String )in.readObject();
            time=( String )in.readObject();
        }
        catch( IOException e ){
            System.out.println(e);
        }
    }

    public void writeObject( ObjectOutputStream out ) throws IOException
    {

        out.writeObject( orderID );
        out.writeObject( clientID );
        out.writeObject( orderDate );
        out.writeObject( time );

    }
    public int getTime(){
        return Integer.parseInt(time);
    }
    public void setTotalPrice(int price){totalPrice=price;}
    public int getDateAsInt(){
        String[]date=orderDate.split("\\.");return Integer.parseInt(date[0]);}

}
