import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FeeStructure extends JFrame implements ActionListener {
    JTable tableResult;
    FeeStructure() {
        getContentPane().setBackground(Color.WHITE);

//        TITLE:
        JLabel labelTitle = new JLabel("Fee Structure");
        labelTitle.setBounds(400, 10, 400, 30);
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(labelTitle);

        //        JTABLE:
        try {
            File fileData = new File("C:/Users/Syed Taha/Desktop/DataBase/DataBaseFeeStructure.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fileData));
            String[] columnNames = {"Course", "Admission Fee", "Total 1st Pay", "Semester Fee"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("'");
                if (parts.length == columnNames.length) {
                    model.addRow(parts);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
            reader.close();

            tableResult = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(tableResult);
            scrollPane.setBounds(10, 160, 850, 500);
            add(scrollPane);
        }
        catch (Exception A) {
            A.printStackTrace();
        }



//        JFrame:
        setSize(900,700);
        setLocation(250,50);
        setLayout(null);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        new FeeStructure();

    }

}
