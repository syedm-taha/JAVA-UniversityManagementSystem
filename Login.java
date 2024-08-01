import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener{
    JTextField textFieldUserName;
    JPasswordField passwordFieldPass;
    JButton buttonLogin, buttonBack;
    Login() {
        JLabel labelUserName = new JLabel("User Name");
        labelUserName.setBounds(40, 20, 100, 20);
        add(labelUserName);

        JLabel labelPass = new JLabel("Password");
        labelPass.setBounds(40, 50, 100, 20);
        add(labelPass);

        textFieldUserName = new JTextField();
        textFieldUserName.setBounds(160, 20, 100, 20);
        add(textFieldUserName);

        passwordFieldPass = new JPasswordField();
        passwordFieldPass.setBounds(160, 50, 100, 20);
        add(passwordFieldPass);

        buttonLogin = new JButton("Login");
        buttonLogin.setBackground(Color.GRAY);
        buttonLogin.setForeground(Color.CYAN);
        buttonLogin.setBounds(40, 100, 120, 30);
        buttonLogin.addActionListener(this);
        add(buttonLogin);

        buttonBack = new JButton("Back");
        buttonBack.setBackground(Color.GRAY);
        buttonBack.setForeground(Color.CYAN);
        buttonBack.setBounds(180, 100, 120, 30);
        buttonBack.addActionListener(this);
        add(buttonBack);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/loginback.png"));
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 600, 300);
        add(image);



        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            String stringUserName = textFieldUserName.getText();
            String stringPass = passwordFieldPass.getText();
            String stringAllData = stringUserName + stringPass;

            File fileData = new File("C:/Users/Syed Taha/Desktop/DataBase/DataBaseLogin.txt");
            try {
                FileReader fileReader = new FileReader(fileData);
                Scanner sc = new Scanner(fileReader);
                boolean check = true;
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (stringAllData.equals(line)) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        check = false;
                        setVisible(false);
                        new Main();
                        break;
                    }
                }
                if (check){
                    JOptionPane.showMessageDialog(null, "Invalid username or Password");
                }
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        }
        else
            setVisible(false);
    }

    public static void main(String[] args) {
        new Login();
    }

}