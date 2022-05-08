package presentationlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private JPanel mainPanel=new JPanel();

    private JTextField searchName=new JTextField("Product Name");

    private JButton viewMenu = new JButton("View Menu Items");
    private JButton searchProducts = new JButton("Search Products");
    private JButton createOrder = new JButton("Make Order");


    public ClientGUI() {

        JPanel gPP=new JPanel();
        JPanel aPP=new JPanel();
        JPanel dPP=new JPanel();
        JPanel searchNameP=new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        mainPanel.setPreferredSize(new Dimension(300,300));

        gPP.add(viewMenu);
        searchNameP.add(searchName);
        aPP.add(searchProducts);
        dPP.add(createOrder);

        mainPanel.add(gPP);
        mainPanel.add(searchNameP);
        mainPanel.add(aPP);
        mainPanel.add(dPP);

        // finalizare
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Client GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addViewMenuListener(ActionListener e){viewMenu.addActionListener(e);}
    public void addSearchProductListener(ActionListener e){searchProducts.addActionListener(e);}
    public void addCreateOrderListener(ActionListener e){createOrder.addActionListener(e);}
    public String getProductName(){return searchName.getText();}
}
