import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ExaminationDetails extends JFrame implements ActionListener {
    JTextField textFieldSearch;
    JButton buttonResult, buttonBack;
    JTable tableResult;

    ExaminationDetails() {
        getContentPane().setBackground(new Color(241, 252, 210));

        // TITLE:
        JLabel labelTitle = new JLabel("Check Result");
        labelTitle.setBounds(350, 15, 400, 50);
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(labelTitle);

        // TEXTFIELD:
        textFieldSearch = new JTextField();
        textFieldSearch.setBounds(160, 90, 200, 30);
        textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(textFieldSearch);

        // BUTTONS:
        // Result:
        buttonResult = new JButton("Result");
        buttonResult.setBounds(420, 90, 120, 30);
        buttonResult.addActionListener(this);
        add(buttonResult);

        // Back:
        buttonBack = new JButton("Back");
        buttonBack.setBounds(570, 90, 120, 30);
        buttonBack.addActionListener(this);
        add(buttonBack);

        // JTABLE:
        try {
            File fileData = new File("C:/Users/Syed Taha/Desktop/DataBase/DataBaseStudentMarks.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fileData));
            int lines = 0;
            while (reader.readLine() != null)
                lines++;
            reader.close();
            String[] columnNames = {"Student Reg No.", "Semester", "Subject 1", "Marks Subject 1", "Subject 2",
                    "Marks Subject 2", "Subject 3", "Marks Subject 3", "Subject 4", "Marks Subject 4", "Subject 5",
                    "Marks Subject 5", "Subject 6", "Marks Subject 6"};
            String[][] lineWord = new String[lines][columnNames.length];
            Scanner sc = new Scanner(fileData);

            for (int i = 0; i < lines; i++) {
                String[] line = sc.nextLine().split("`");

                for (int j = 0; j < columnNames.length; j++) {
                    lineWord[i][j] = line[j];
                }
            }
            sc.close();

            DefaultTableModel model = new DefaultTableModel(lineWord, columnNames);
            tableResult = new JTable(model);

            // Set column widths
            tableResult.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            TableColumnModel columnModel = tableResult.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setPreferredWidth(97);
            }

            JScrollPane scrollPane = new JScrollPane(tableResult);
            scrollPane.setBounds(15, 140, 1360, 420);
            add(scrollPane);
        } catch (Exception A) {
            A.printStackTrace();
        }


        // JFRAME:
        setSize(1400, 600);
        setLocation(5, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonResult) {
            String regNoToSearch = textFieldSearch.getText();
            boolean flag = true;
            if (!regNoToSearch.isEmpty()) {
                for (int i = 0; i < tableResult.getRowCount(); i++) {
                    String regNoInTable = (String) tableResult.getValueAt(i, 0);
                    if (regNoToSearch.equals(regNoInTable)) {
                        tableResult.setRowSelectionInterval(i, i);
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    JOptionPane.showMessageDialog(null, "Enter a valid Registration Number.");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Enter a Registration Number.");
            }
        } else if (e.getSource() == buttonBack) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
