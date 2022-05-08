package presentationlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {

    private JPanel mainPanel=new JPanel();

    private JTextField deleteIndex=new JTextField("Delete index");

    private JButton generateProducts = new JButton("Generate MenuItems");
    private JButton addProducts = new JButton("Add New Product");
    private JButton deleteProduct = new JButton("Delete Product");
    private JButton modifyProduct = new JButton("Modify Product");
    private JButton createCompositeProduct = new JButton("Create Daily Menu");
    private JButton generateReport = new JButton("Generate Report");

    public AdminGUI() {

        JPanel gPP=new JPanel();
        JPanel aPP=new JPanel();
        JPanel dPP=new JPanel();
        JPanel mPP=new JPanel();
        JPanel cCPP=new JPanel();
        JPanel gRP= new JPanel();
        JPanel deleteIndexP=new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        mainPanel.setPreferredSize(new Dimension(300,400));

        gPP.add(generateProducts);
        aPP.add(addProducts);
        dPP.add(deleteProduct);
        mPP.add(modifyProduct);
        cCPP.add(createCompositeProduct);
        gRP.add(generateReport);
        deleteIndexP.add(deleteIndex);

        mainPanel.add(gPP);
        mainPanel.add(aPP);
        mainPanel.add(deleteIndexP);
        mainPanel.add(dPP);
        mainPanel.add(mPP);
        mainPanel.add(cCPP);
        mainPanel.add(gRP);

        // finalizare
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Admin GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addAddProductsListener(ActionListener e){
        addProducts.addActionListener(e);
    }
    public void addDeleteProductListener(ActionListener e){
        deleteProduct.addActionListener(e);
    }
    public void addModifyProductListener(ActionListener e){
        modifyProduct.addActionListener(e);
    }
    public void addCreateCompositeListener(ActionListener e){
        createCompositeProduct.addActionListener(e);
    }
    public void addGenerateReportListener(ActionListener e){
        generateReport.addActionListener(e);
    }
    public void addGenerateProductsListener(ActionListener e){
        generateProducts.addActionListener(e);
    }
    public int getDeleteIndex(){return Integer.parseInt(deleteIndex.getText());}
}
