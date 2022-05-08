package businesslayer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class MenuItem {
    private int index;
    private int price;
    private String title;
    public abstract int computePrice();
    public abstract String[] toStringArray();
    public MenuItem(int price,String title){
        this.price=price;
        this.title=title;
    }
    public MenuItem(){

    }

    public String getTitle() {
        return title;
    }

    public int getIndex() {
        return index;
    }
    public int getPrice(){return price;}
    public void setIndex(int i){
        index=i;
    }
}
