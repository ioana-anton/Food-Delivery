package presentationlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private JPanel mainPanel=new JPanel();

    private JTextField username=new JTextField("Username");
    private JTextField password=new JTextField("Password");

    private JButton confirm=new JButton("Confirm");
    private JButton register=new JButton("Register");

    public HomePage(){
        JPanel usernameP=new JPanel();
        JPanel passwordP=new JPanel();
        JPanel confirmP=new JPanel();
        JPanel registerP=new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        mainPanel.setPreferredSize(new Dimension(400,300));

        username.setPreferredSize(new Dimension(400,50));
        password.setPreferredSize(new Dimension(400,50));
        confirm.setPreferredSize(new Dimension(400,50));
        register.setPreferredSize(new Dimension(400,50));

        usernameP.setPreferredSize(new Dimension(400,50));
        passwordP.setPreferredSize(new Dimension(400,50));
        confirmP.setPreferredSize(new Dimension(400,50));
        registerP.setPreferredSize(new Dimension(400,50));

        usernameP.add(username);
        passwordP.add(password);
        confirmP.add(confirm);
        registerP.add(register);

        mainPanel.add(usernameP);
        mainPanel.add(passwordP);
        mainPanel.add(confirmP);
        mainPanel.add(registerP);

        // finalizare
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Home Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addLoginListener(ActionListener e){confirm.addActionListener(e);}
    public void addRegisterListener(ActionListener e){register.addActionListener(e);}
    public String getUsername(){return username.getText();}
    public String getPassword(){return password.getText();}
}
