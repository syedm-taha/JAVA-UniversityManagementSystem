import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);
        setVisible(true);
        t = new Thread(this);
        t.start();


        int x = 1;
        for (int i = 2; i <= 600; i += 4, x ++){
            setLocation(550 - ((i + x) / 2), 320 - (i / 2));
            setSize(i + 3 * x, i + x / 2);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    public void run () {
        try {
            Thread.sleep(3700);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        new Splash();
    }
} 