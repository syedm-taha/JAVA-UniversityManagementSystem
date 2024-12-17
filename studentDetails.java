import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class studentDetails extends JFrame {
    Choice choiceRollNo;
    JTable table;

    studentDetails() {
        getContentPane().setBackground(new Color(210, 252, 218));

        // TITLE:
        JLabel labelTitle = new JLabel("Search By Reg No");
        labelTitle.setBounds(20, 20, 150, 20);
        add(labelTitle);

        // CHOICE:
        choiceRollNo = new Choice();
        choiceRollNo.setBounds(180, 20, 150, 20);
        add(choiceRollNo);

        // Read faculty data from the serialized file
        List<Faculty> faculties = readFacultyData();

        String[] columnNames = {"Name", "Father Name", "Address", "Email", "DOB", "Phone", "M10", "M12",
                "Qual", "Dept", "CNIC", "Emp ID"};
        String[][] lineWord = new String[faculties.size()][columnNames.length];

        for (int i = 0; i < faculties.size(); i++) {
            Faculty faculty = faculties.get(i);
            lineWord[i][0] = faculty.getName();
            lineWord[i][1] = faculty.getFatherName();
            lineWord[i][2] = faculty.getAddress();
            lineWord[i][3] = faculty.getEmail();
            lineWord[i][4] = faculty.getDob();
            lineWord[i][5] = faculty.getPhone();
            lineWord[i][6] = faculty.getMatricMarks();
            lineWord[i][7] = faculty.getInterMarks();
            lineWord[i][8] = faculty.getQualification();
            lineWord[i][9] = faculty.getDepartment();
            lineWord[i][10] = faculty.getCnic();
            lineWord[i][11] = faculty.getEmpID();
            choiceRollNo.add(faculty.getEmpID());
        }

        DefaultTableModel model = new DefaultTableModel(lineWord, columnNames);
        table = new JTable(model);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String selectedempID = (String) table.getValueAt(selectedRow, columnNames.length - 1);
                    choiceRollNo.select(selectedempID);
                }
            }
        });

        // Set column widths
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(115);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 60, 1380, 580);
        add(scrollPane);

        choiceRollNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedEmpID = choiceRollNo.getSelectedItem();
                if (selectedEmpID != null) {
                    for (int i = 0; i < table.getRowCount(); i++) {
                        String empIDInTable = (String) table.getValueAt(i, columnNames.length - 1);
                        if (selectedEmpID.equals(empIDInTable)) {
                            table.setRowSelectionInterval(i, i);
                        }
                    }
                }
            }
        });

        // JFRAME:
        setLayout(null);
        setSize(1400, 700);
        setLocation(10, 30);
        setTitle("Student Details");
        setVisible(true);
    }

    private List<Faculty> readFacultyData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Users/Syed Taha/Desktop/DataBase/student_data.ser"))) {
            return (List<Faculty>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        new studentDetails();
    }
}
