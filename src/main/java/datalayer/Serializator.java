package datalayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializator implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Serializator(String username, String password ){
        this.username = username;
        this.password = password;
    }

    public Serializator(){


    }
    public void readObject( ObjectInputStream in ) throws ClassNotFoundException
    {

        try{
            username = ( String )in.readObject();
            password = ( String )in.readObject();
        }
        catch( IOException e ){
            System.out.println(e);
        }
    }

    public void writeObject( ObjectOutputStream out ) throws IOException
    {

        out.writeObject( username );
        out.writeObject( password );

    }
}
