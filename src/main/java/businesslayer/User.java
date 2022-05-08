package businesslayer;

import datalayer.Serializator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class User extends Serializator {
    private int type; // 0-admin,1-employee,2-client
    private int idUser;
    public User(String user, String pass,int type) {
        super(user,pass);
        this.type=type;
        Random rand=new Random();
        this.idUser=rand.nextInt();
    }

    public User() {
        super();
    }

    public String getUser() {
        return getUsername();
    }

    public String getPass() {
        return getPassword();
    }

    public int getType() {
        return type;
    }
    public int getIdUser(){return idUser;}
}
