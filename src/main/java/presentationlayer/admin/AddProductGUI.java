package presentationlayer.admin;

import javax.imageio.plugins.jpeg.JPEGQTable;
import javax.swing.*;
import java.awt.*;

public class AddProductGUI extends JFrame {

    private JPanel mainPanel=new JPanel();

    private JButton submit=new JButton("Submit");

    private JTextField title =new JTextField("Title");
    private JTextField rating=new JTextField("Rating");
    private JTextField calories=new JTextField("Calories");
    private JTextField proteins=new JTextField("Proteins");
    private JTextField fats=new JTextField("Fats");
    private  JTextField sodium=new JTextField("Sodium");
    private JTextField price=new JTextField("Price");

    public AddProductGUI(){

        JPanel titleP=new JPanel();
        JPanel ratingP=new JPanel();
        JPanel caloriesP=new JPanel();
        JPanel proteinsP=new JPanel();
        JPanel fatsP=new JPanel();
        JPanel sodiumP=new JPanel();
        JPanel priceP=new JPanel();
        JPanel submitP=new JPanel();

        titleP.setPreferredSize(new Dimension(250,20));
        title.setPreferredSize(new Dimension(230,20));

        ratingP.setPreferredSize(new Dimension(250,20));
        rating.setPreferredSize(new Dimension(230,20));

        caloriesP.setPreferredSize(new Dimension(250,20));
        calories.setPreferredSize(new Dimension(230,20));

        proteinsP.setPreferredSize(new Dimension(250,20));
        proteins.setPreferredSize(new Dimension(230,20));

        fatsP.setPreferredSize(new Dimension(250,20));
        fats.setPreferredSize(new Dimension(230,20));

        sodiumP.setPreferredSize(new Dimension(250,20));
        sodium.setPreferredSize(new Dimension(230,20));

        priceP.setPreferredSize(new Dimension(250,20));
        price.setPreferredSize(new Dimension(230,20));

        submitP.setPreferredSize(new Dimension(120,20));
        submit.setPreferredSize(new Dimension(100,20));

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(300,400));

        titleP.add(title);
        ratingP.add(rating);
        caloriesP.add(calories);
        proteinsP.add(proteins);
        fatsP.add(fats);
        sodiumP.add(sodium);
        priceP.add(price);
        submitP.add(submit);

        mainPanel.add(titleP);
        mainPanel.add(ratingP);
        mainPanel.add(caloriesP);
        mainPanel.add(proteinsP);
        mainPanel.add(fatsP);
        mainPanel.add(sodiumP);
        mainPanel.add(priceP);
        mainPanel.add(submitP);

        // finalizare
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Add Product GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
