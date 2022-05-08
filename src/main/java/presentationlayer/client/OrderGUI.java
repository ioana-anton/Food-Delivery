package presentationlayer.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderGUI extends JFrame {
    private JPanel mainPanel=new JPanel();

    private JButton submit=new JButton("Submit");

    private JTextField title =new JTextField("Product 1");
    private JTextField rating=new JTextField("Product 2");
    private JTextField calories=new JTextField("Product 3");


    public OrderGUI(){

        JPanel titleP=new JPanel();
        JPanel ratingP=new JPanel();
        JPanel caloriesP=new JPanel();
        JPanel submitP=new JPanel();

        titleP.setPreferredSize(new Dimension(250,20));
        title.setPreferredSize(new Dimension(230,20));

        ratingP.setPreferredSize(new Dimension(250,20));
        rating.setPreferredSize(new Dimension(230,20));

        caloriesP.setPreferredSize(new Dimension(250,20));
        calories.setPreferredSize(new Dimension(230,20));

        submitP.setPreferredSize(new Dimension(120,20));
        submit.setPreferredSize(new Dimension(100,20));

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(300,400));

        titleP.add(title);
        ratingP.add(rating);
        caloriesP.add(calories);
        submitP.add(submit);

        mainPanel.add(titleP);
        mainPanel.add(ratingP);
        mainPanel.add(caloriesP);
        mainPanel.add(submitP);

        // finalizare
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("New Order");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addSubmitOrderListener(ActionListener e){submit.addActionListener(e);}
    public String getProduct1(){return title.getText();}
    public String getProduct2(){return rating.getText();}
    public String getProduct3(){return calories.getText();}
}
