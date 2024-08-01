import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    About() {
        ImageIcon i1 = new ImageIcon((ClassLoader.getSystemResource("icons/About.png")));
        Image i2 = i1.getImage().getScaledInstance(987, 567, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 987, 567);
        add(img);

//        JFRAME:
        setSize(989, 569);
        setLocation(250, 130);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
