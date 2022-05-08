package start;

import businesslayer.MenuItem;
import businesslayer.Order;
import presentationlayer.*;
import presentationlayer.admin.AddProductGUI;
import presentationlayer.admin.ModifyProductGUI;
import presentationlayer.admin.ReportGUI;
import presentationlayer.client.OrderGUI;

import java.awt.event.ActionListener;

public class Start {
    public static void main(String[] args) {
        AdminGUI a=new AdminGUI();
        EmployeeGUI e=new EmployeeGUI();
        ClientGUI c=new ClientGUI();
        AddProductGUI ad=new AddProductGUI();
        HomePage hp=new HomePage();
        RegisterGUI r=new RegisterGUI();
        ModifyProductGUI mp=new ModifyProductGUI();
        OrderGUI o=new OrderGUI();
        ReportGUI rr=new ReportGUI();

        Controller con=new Controller(hp,r,a,c,e,ad,mp,o,rr);
       // a.setVisible(true);
       // c.setVisible(true);
        //a.setVisible(true);
       // c.setVisible(true);
        hp.setVisible(true);
    }


}
