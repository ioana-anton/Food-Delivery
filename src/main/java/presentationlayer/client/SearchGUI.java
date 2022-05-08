package presentationlayer.client;

import businesslayer.BaseProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SearchGUI extends JFrame{
    private DefaultTableModel model=new DefaultTableModel();
    private JTable t;
    private Container cnt = this.getContentPane();
    private java.util.List<String> columnNames; //coloane
    private java.util.List<BaseProduct> rows; //randuri

    public SearchGUI(java.util.List<String> columnNames, List<BaseProduct> rows){
        this.columnNames=columnNames;
        this.rows=rows;

        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));

        for(String s:columnNames)
            model.addColumn(s);

        for(BaseProduct p: rows)
            model.addRow(p.toStringArray());

        t=new JTable(model);

        JScrollPane pg =new JScrollPane(t);
        cnt.add(pg);
        this.pack();

    }
}
