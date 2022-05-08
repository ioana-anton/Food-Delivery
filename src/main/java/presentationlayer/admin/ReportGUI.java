package presentationlayer.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReportGUI extends JFrame {
    //int startHour, int endHour,int freqProduct, int freqClients, int price, int day
    private JPanel mainPanel=new JPanel();

    private JButton submit=new JButton("Generate");

    private JTextField title =new JTextField("Start Hour");
    private JTextField rating=new JTextField("End Hour");
    private JTextField calories=new JTextField("Freq Products");
    private JTextField proteins=new JTextField("Freq Clients");
    private JTextField fats=new JTextField("Price");
    private  JTextField sodium=new JTextField("Day");
   // private JTextField price=new JTextField("Price");

    public ReportGUI(){

        JPanel titleP=new JPanel();
        JPanel ratingP=new JPanel();
        JPanel caloriesP=new JPanel();
        JPanel proteinsP=new JPanel();
        JPanel fatsP=new JPanel();
        JPanel sodiumP=new JPanel();
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
        submitP.add(submit);

        mainPanel.add(titleP);
        mainPanel.add(ratingP);
        mainPanel.add(caloriesP);
        mainPanel.add(proteinsP);
        mainPanel.add(fatsP);
        mainPanel.add(sodiumP);
        mainPanel.add(submitP);

        // finalizare
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Generate Report GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*private JTextField title =new JTextField("Start Hour");
    private JTextField rating=new JTextField("End Hour");
    private JTextField calories=new JTextField("Freq Products");
    private JTextField proteins=new JTextField("Freq Clients");
    private JTextField fats=new JTextField("Price");
    private  JTextField sodium=new JTextField("Day");*/
    public int getStartHour(){return Integer.parseInt(title.getText());}
    public int getEndHour(){return Integer.parseInt(rating.getText());}
    public int getFreqProduct(){return Integer.parseInt(calories.getText());}
    public int getFreqClients(){return Integer.parseInt(proteins.getText());}
    public int getMaxPrice(){return Integer.parseInt(fats.getText());}
    public int getDay(){return Integer.parseInt(sodium.getText());}
    public void addReportSubmitListener(ActionListener e){submit.addActionListener(e);}
}
