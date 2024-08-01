import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class EnterStudMarks  extends JFrame implements ActionListener {
    Choice choiceRollNo;
    JComboBox comboBoxSem;
    JTextField textFieldsub1, textFieldsub2, textFieldsub3, textFieldsub4, textFieldsub5, textFieldsub6, textFieldmark1,
            textFieldmark2, textFieldmark3, textFieldmark4, textFieldmark5, textFieldmark6;
    JButton buttonSubmit, buttonCancel;
    EnterStudMarks() {
//        JFRAME:
        getContentPane().setBackground(new Color(252, 245, 210));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500, 40, 400, 300);
        add(img);

//        TITLE:
        JLabel labelTitle = new JLabel("Enter Student Marks");
        labelTitle.setBounds(50, 0, 550, 50);
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelTitle);

//        REGNO:
        JLabel labelRegNo = new JLabel("Select Reg Number");
        labelRegNo.setBounds(50, 70, 150, 25);
        add(labelRegNo);

//        JCHOICEREGNO.:
        choiceRollNo = new Choice();
        choiceRollNo.setBounds(200, 70, 150, 20);
        add(choiceRollNo);
        try {
            File fileData = new File("C:/Users/Syed Taha/Desktop/DataBaseNewStudent.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fileData));
            Scanner sc = new Scanner(fileData);
            int lines = 0;
            while (reader.readLine() != null)
                lines++;
            for (int i = 0; i < lines; i++) {
                String[] line = sc.nextLine().split("`");
                choiceRollNo.add(line[11]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

//        JCOMBOBOXSEM:
        JLabel labelSem = new JLabel("Select Semester");
        labelSem.setBounds(50, 100, 150, 25);
        add(labelSem);

        String sem[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester",
                "7th Semester", "8th Semester",};
        comboBoxSem = new JComboBox(sem);
        comboBoxSem.setBounds(200, 100, 150, 20);
        comboBoxSem.setBackground(Color.WHITE);
        add(comboBoxSem);

//        JLABELSUB/MARKS:
        JLabel labelSub = new JLabel("Subject");
        labelSub.setBounds(100, 150, 200, 40);
        add(labelSub);

        JLabel labelMark = new JLabel("Marks");
        labelMark.setBounds(320, 150, 200, 40);
        add(labelMark);

//        JTEXFIELDSSUB/MARKS:
        textFieldsub1 = new JTextField();
        textFieldsub1.setBounds(50, 200, 200, 20);
        add(textFieldsub1);

        textFieldsub2 = new JTextField();
        textFieldsub2.setBounds(50, 230, 200, 20);
        add(textFieldsub2);

        textFieldsub3 = new JTextField();
        textFieldsub3.setBounds(50, 260, 200, 20);
        add(textFieldsub3);

        textFieldsub4 = new JTextField();
        textFieldsub4.setBounds(50, 290, 200, 20);
        add(textFieldsub4);

        textFieldsub5 = new JTextField();
        textFieldsub5.setBounds(50, 320, 200, 20);
        add(textFieldsub5);

        textFieldsub6 = new JTextField();
        textFieldsub6.setBounds(50, 350, 200, 20);
        add(textFieldsub6);

        textFieldmark1 = new JTextField();
        textFieldmark1.setBounds(250, 200, 200, 20);
        add(textFieldmark1);

        textFieldmark2 = new JTextField();
        textFieldmark2.setBounds(250, 230, 200, 20);
        add(textFieldmark2);

        textFieldmark3 = new JTextField();
        textFieldmark3.setBounds(250, 260, 200, 20);
        add(textFieldmark3);

        textFieldmark4 = new JTextField();
        textFieldmark4.setBounds(250, 290, 200, 20);
        add(textFieldmark4);

        textFieldmark5 = new JTextField();
        textFieldmark5.setBounds(250, 320, 200, 20);
        add(textFieldmark5);

        textFieldmark6 = new JTextField();
        textFieldmark6.setBounds(250, 350, 200, 20);
        add(textFieldmark6);

//        JBUTTONS:
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(70, 390, 150, 25);
        buttonSubmit.addActionListener(this);
        add(buttonSubmit);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(280, 390, 150, 25);
        buttonCancel.addActionListener(this);
        add(buttonCancel);



        setSize(1000, 500);
        setLayout(null);
        setLocation(170, 150);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSubmit) {
            try {
                File fileData = new File("C:/Users/Syed Taha/Desktop/DataBaseStudentMarks.txt");
                BufferedReader reader = new BufferedReader(new FileReader(fileData));
                Scanner scanner = new Scanner(reader);

                byte countMark1 = 0;
                for (int i = 0; i < textFieldmark1.getText().length(); i++) {
                    if (textFieldmark1.getText().charAt(i) >= 48 && textFieldmark1.getText().charAt(i) <= 57)
                        countMark1++;
                }
                if (!textFieldsub1.getText().isEmpty() && !textFieldsub2.getText().isEmpty() &&
                        !textFieldsub3.getText().isEmpty() && !textFieldsub4.getText().isEmpty() &&
                        !textFieldsub5.getText().isEmpty() && !textFieldsub6.getText().isEmpty() &&
                        !textFieldmark1.getText().isEmpty() && !textFieldmark2.getText().isEmpty() &&
                        !textFieldmark3.getText().isEmpty() && !textFieldmark4.getText().isEmpty() &&
                        !textFieldmark5.getText().isEmpty() && !textFieldmark6.getText().isEmpty() &&
                        textFieldmark1.getText().matches("[0-9]+") && textFieldmark2.getText().matches("[0-9]+")
                        && textFieldmark3.getText().matches("[0-9]+")&& textFieldmark4.getText().matches("[0-9]+")&&
                        textFieldmark5.getText().matches("[0-9]+")&& textFieldmark6.getText().matches("[0-9]+")) {
                    String stringData = choiceRollNo.getSelectedItem() + "`" + comboBoxSem.getSelectedItem() + "`" +
                            textFieldsub1.getText() + "`" + textFieldmark1.getText() + "`" + textFieldsub2.getText()
                            + "`" + textFieldmark2.getText() + "`" + textFieldsub3.getText() + "`" + textFieldmark3.getText()
                            + "`" + textFieldsub4.getText() + "`" + textFieldmark4.getText()+ "`" + textFieldsub5.getText()
                            + "`" + textFieldmark5.getText()+ "`" + textFieldsub6.getText() + "`" +textFieldmark6.getText();
                    PrintWriter printWriterData = new PrintWriter(new FileOutputStream(fileData, true));
                    printWriterData.append("\n" + stringData);
                    printWriterData.close();
                    JOptionPane.showMessageDialog(null, "Details Submitted");
                }
                else
                    JOptionPane.showMessageDialog(null, "All fields must be filled and Marks should have only Numeral value");
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        }
        else
            dispose();
    }

    public static void main(String[] args) {
        new EnterStudMarks();
    }
}
