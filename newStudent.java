import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class newStudent extends JFrame implements ActionListener {
    // TEXTFIELDS:
    JTextField textFieldName, textFieldFName, textFieldAddress, textFieldPhone, textFieldEmail, textFieldM10,
            textFieldM12, textFieldCNIC;
    JLabel labelEmpIDNum;
    JComboBox<String> comboBoxQual, comboBoxDept;
    JButton buttonSubmit, buttonCancel;

    // DATECHOOSER:
    JDateChooser chooseDOB;

    // RANDOMID:
    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    newStudent() {
        // TITLE:
        JLabel labelTitle = new JLabel("New Student Details");
        labelTitle.setBounds(310, 30, 500, 50);
        labelTitle.setFont(new Font("serif", Font.BOLD, 30));
        add(labelTitle);

        // EMPLOYEEID:
        JLabel labelEmpID = new JLabel("Student ID");
        labelEmpID.setBounds(330, 100, 150, 30);
        labelEmpID.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmpID);

        labelEmpIDNum = new JLabel("2023" + f4);
        labelEmpIDNum.setBounds(500, 100, 200, 30);
        labelEmpIDNum.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmpIDNum);

        // NAME:
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 150, 100, 30);
        labelName.setFont(new Font("serif", Font.BOLD, 20));
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(200, 150, 200, 30);
        add(textFieldName);

        // FATHERNAME:
        JLabel labelFName = new JLabel("Father Name");
        labelFName.setBounds(410, 150, 200, 30);
        labelFName.setFont(new Font("serif", Font.BOLD, 20));
        add(labelFName);

        textFieldFName = new JTextField();
        textFieldFName.setBounds(600, 150, 200, 30);
        add(textFieldFName);

        // CNIC:
        JLabel labelCNIC = new JLabel("CNIC");
        labelCNIC.setBounds(50, 200, 200, 30);
        labelCNIC.setFont(new Font("serif", Font.BOLD, 20));
        add(labelCNIC);

        textFieldCNIC = new JTextField();
        textFieldCNIC.setBounds(200, 200, 200, 30);
        add(textFieldCNIC);

        // DOB:
        JLabel labelDOB = new JLabel("Date Of Birth");
        labelDOB.setBounds(410, 200, 200, 30);
        labelDOB.setFont(new Font("serif", Font.BOLD, 20));
        add(labelDOB);

        chooseDOB = new JDateChooser();
        chooseDOB.setBounds(600, 200, 200, 30);
        add(chooseDOB);

        // EMAIL:
        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 250, 200, 30);
        labelEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(200, 250, 200, 30);
        add(textFieldEmail);

        // PHONE:
        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(410, 250, 200, 30);
        labelPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(labelPhone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(600, 250, 200, 30);
        add(textFieldPhone);

        // MARKS10:
        JLabel labelM10 = new JLabel("Matric Marks");
        labelM10.setBounds(50, 300, 200, 30);
        labelM10.setFont(new Font("serif", Font.BOLD, 20));
        add(labelM10);

        textFieldM10 = new JTextField();
        textFieldM10.setBounds(200, 300, 200, 30);
        add(textFieldM10);

        // MARKS12:
        JLabel labelM12 = new JLabel("Intermediate Marks");
        labelM12.setBounds(410, 300, 200, 30);
        labelM12.setFont(new Font("serif", Font.BOLD, 20));
        add(labelM12);

        textFieldM12 = new JTextField();
        textFieldM12.setBounds(600, 300, 200, 30);
        add(textFieldM12);

        // ADDRESS:
        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(50, 350, 200, 30);
        labelAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(labelAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(200, 350, 400, 30);
        add(textFieldAddress);

        // QUALIFICATION:
        JLabel labelQual = new JLabel("Qualification");
        labelQual.setBounds(50, 400, 200, 30);
        labelQual.setFont(new Font("serif", Font.BOLD, 20));
        add(labelQual);

        String qual[] = {"Matric", "Intermediate", "Bachelor / BS", "Master", "PhD"};
        comboBoxQual = new JComboBox<>(qual);
        comboBoxQual.setBounds(200, 400, 200, 30);
        comboBoxQual.setBackground(Color.WHITE);
        add(comboBoxQual);

        // DEPARTMENT:
        JLabel labelDept = new JLabel("Department");
        labelDept.setBounds(410, 400, 200, 30);
        labelDept.setFont(new Font("serif", Font.BOLD, 20));
        add(labelDept);

        String dept[] = {"BS Artificial Intelligence", "BS Computer Science", "BS Data Science", "BS Electrical Engineering",
                "BS Physics", "BS Chemistry", "BBa"};
        comboBoxDept = new JComboBox<>(dept);
        comboBoxDept.setBounds(600, 400, 200, 30);
        comboBoxDept.setBackground(Color.WHITE);
        add(comboBoxDept);

        // BUTTONS:
        // BUTTONSUBMIT:
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(335, 500, 100, 30);
        buttonSubmit.addActionListener(this);
        add(buttonSubmit);

        // BUTTONCANCEL:
        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(460, 500, 100, 30);
        buttonCancel.addActionListener(this);
        add(buttonCancel);

        // JFRAME:
        getContentPane().setBackground(new Color(166, 164, 252));
        setTitle("Add New Faculty");
        setSize(900, 700);
        setLocation(175, 15);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSubmit) {
            if (validateInputs()) {
                Faculty faculty = new Faculty(
                        textFieldName.getText(),
                        textFieldFName.getText(),
                        textFieldAddress.getText(),
                        textFieldEmail.getText(),
                        ((JTextField) chooseDOB.getDateEditor().getUiComponent()).getText(),
                        labelEmpIDNum.getText(),
                        textFieldPhone.getText(),
                        textFieldM10.getText(),
                        textFieldM12.getText(),
                        (String) comboBoxQual.getSelectedItem(),
                        (String) comboBoxDept.getSelectedItem(),
                        textFieldCNIC.getText()
                );
                saveFacultyData(faculty);
                JOptionPane.showMessageDialog(null, "Details Submitted");
                dispose();
            }
        } else if (e.getSource() == buttonCancel) {
            dispose();
        }
    }

    private boolean validateInputs() {
        if (textFieldName.getText().isEmpty()) {
            showError("Name is required");
            return false;
        }
        if (textFieldFName.getText().isEmpty()) {
            showError("Father's Name is required");
            return false;
        }
        if (textFieldCNIC.getText().isEmpty()) {
            showError("CNIC is required");
            return false;
        }
        if (((JTextField) chooseDOB.getDateEditor().getUiComponent()).getText().isEmpty()) {
            showError("Date of Birth is required");
            return false;
        }
        if (textFieldEmail.getText().isEmpty()) {
            showError("Email is required");
            return false;
        }
        if (textFieldPhone.getText().isEmpty()) {
            showError("Phone is required");
            return false;
        }
        if (textFieldM10.getText().isEmpty()) {
            showError("Matric Marks are required");
            return false;
        }
        if (textFieldM12.getText().isEmpty()) {
            showError("Intermediate Marks are required");
            return false;
        }
        if (textFieldAddress.getText().isEmpty()) {
            showError("Address is required");
            return false;
        }
        return true;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void saveFacultyData(Faculty faculty) {
        List<Faculty> faculties = new ArrayList<>();
        File file = new File("C:/Users/Syed Taha/Desktop/DataBase/student_data.ser");
        if (file.exists()) {
            faculties = readFacultyData();
        }
        faculties.add(faculty);
        writeFacultyData(faculties);
    }

    private List<Faculty> readFacultyData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Users/Syed Taha/Desktop/DataBase/student_data.ser"))) {
            return (List<Faculty>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeFacultyData(List<Faculty> faculties) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/Users/Syed Taha/Desktop/DataBase/student_data.ser"))) {
            out.writeObject(faculties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new newStudent().setVisible(true);
    }
}
