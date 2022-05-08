package presentationlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterGUI extends JFrame {
    private JPanel mainPanel = new JPanel();

    private JTextField username = new JTextField("Username");
    private JTextField password = new JTextField("Password");

    private String[] types = {"Admin", "Employee","Client"};
    private JComboBox type = new JComboBox(types);

    private JButton confirm = new JButton("Confirm");

    public RegisterGUI() {
        JPanel usernameP = new JPanel();
        JPanel passwordP = new JPanel();
        JPanel confirmP = new JPanel();
        JPanel typeP = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.setPreferredSize(new Dimension(400, 300));

        username.setPreferredSize(new Dimension(400, 50));
        password.setPreferredSize(new Dimension(400, 50));
        confirm.setPreferredSize(new Dimension(400, 50));
        type.setPreferredSize(new Dimension(400, 50));

        usernameP.setPreferredSize(new Dimension(400, 50));
        passwordP.setPreferredSize(new Dimension(400, 50));
        confirmP.setPreferredSize(new Dimension(400, 50));
        typeP.setPreferredSize(new Dimension(400, 50));

        usernameP.add(username);
        passwordP.add(password);
        confirmP.add(confirm);
        typeP.add(type);

        mainPanel.add(usernameP);
        mainPanel.add(passwordP);
        mainPanel.add(typeP);
        mainPanel.add(confirmP);

        // finalizare
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Register Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addRegisterConfirmListener(ActionListener e) {
        confirm.addActionListener(e);
    }

    public String getUsername(){return username.getText();}
    public String getPassword(){return password.getText();}
    public int getUserType(){
        return type.getSelectedIndex();
    }

}
