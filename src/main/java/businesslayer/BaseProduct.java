package businesslayer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class BaseProduct extends MenuItem {

    private int index;
    private String title;
    private double rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;

    public BaseProduct(int in,String title, double rating, int calories, int proteins, int fats, int sodium, int price) {
        super(price,title);
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
        index=in;
    }

    public BaseProduct() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int computePrice() {
        return price;
    }

    @Override
    public String[] toStringArray() {
        String[] s=new String[8];
        s[0]= String.valueOf(this.getIndex());
        s[1]=title;
        s[2]= String.valueOf(rating);
        s[3]= String.valueOf(calories);
        s[4]= String.valueOf(proteins);
        s[5]= String.valueOf(fats);
        s[6]= String.valueOf(sodium);
        s[7]= String.valueOf(price);
        return s;
    }

    public List<String> getColumnNames(){
        List<String> columnNames=new ArrayList<String>();
        columnNames.add("Index");
        columnNames.add("Title");
        columnNames.add("Rating");
        columnNames.add("Calories");
        columnNames.add("Proteins");
        columnNames.add("Fats");
        columnNames.add("Sodium");
        columnNames.add("Price");
        return columnNames;
    }


}
