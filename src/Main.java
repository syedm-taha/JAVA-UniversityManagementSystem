import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JMenuItem menuItemFacInfo, menuItemStuInfo, menuItemFacDet, menuItemStuDet, menuItemExRes, menuItemEntMark,
            menuItemFeeStr, menuItemCalc, menuItemNotepad, menuItemExit;
    Main() {
//        MENUBAR:
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

//        MENUNEWINFO:
        JMenu menuInfo = new JMenu("New Information");
        menuBar.add(menuInfo);
//        NewInformation:
        menuItemFacInfo = new JMenuItem("New Faculty Information");
        menuItemStuInfo = new JMenuItem("New Student Information");
        menuItemFacInfo.addActionListener(this);
        menuItemStuInfo.addActionListener(this);
        menuInfo.add(menuItemFacInfo);
        menuInfo.add(menuItemStuInfo);

//        MENUDETAILS:
        JMenu menuDetails = new JMenu("View Details");
        menuBar.add(menuDetails);
//        Details:
        menuItemFacDet = new JMenuItem("View Faculty Details");
        menuItemStuDet = new JMenuItem("View Student Details");
        menuItemFacDet.addActionListener(this);
        menuItemStuDet.addActionListener(this);
        menuDetails.add(menuItemFacDet);
        menuDetails.add(menuItemStuDet);


//        MENUEXAMINATION:
        JMenu menuExam = new JMenu("Examination");
        menuBar.add(menuExam);
//        Exam:
        menuItemExRes = new JMenuItem("Examination Results");
        menuItemEntMark = new JMenuItem("Enter Marks");
        menuItemExRes.addActionListener(this);
        menuItemEntMark.addActionListener(this);
        menuExam.add(menuItemExRes);
        menuExam.add(menuItemEntMark);

//        FEEDETAILS:
        JMenu menuFeeDet = new JMenu("Fee Details");
        menuBar.add(menuFeeDet);
//        FeeDetails:
        menuItemFeeStr = new JMenuItem("Fee Structure");
        menuItemFeeStr.addActionListener(this);
        menuFeeDet.add(menuItemFeeStr);

//        UTILITY:
        JMenu menuUtility = new JMenu("Utility");
        menuBar.add(menuUtility);
//        Utility:
        menuItemCalc = new JMenuItem("Calculator");
        menuItemNotepad = new JMenuItem("NotePad");
        menuItemCalc.addActionListener(this);
        menuItemNotepad.addActionListener(this);
        menuUtility.add(menuItemCalc);
        menuUtility.add(menuItemNotepad);

////        ABOUT:
//        JMenu menuAbout = new JMenu("About");
//        menuBar.add(menuAbout);
////        About:
//        JMenuItem menuItemAbout = new JMenuItem("About");
//        menuAbout.add(menuItemAbout);

        //        Exit:
        JMenu menuExit = new JMenu("Exit");
        menuBar.add(menuExit);
//        Exit:
        menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(this);
        menuExit.add(menuItemExit);



        JButton buttonUniName = new JButton("COMEDY UNIVERSITY");
        buttonUniName.setFont(new Font("Tahoma", Font.BOLD, 40));
        buttonUniName.setBounds(450, 100, 500, 100);
        add(buttonUniName);




//        JFrame:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1411, 900);
        add(img);

//        setSize(1540, 850);
//        setLocation(0, 0);
        setBounds(0, 0, 1540, 850);
        setTitle("COMEDY University");
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemExit){
            System.exit(1122);
        }
        else if (e.getSource() == menuItemCalc) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        }
        else if (e.getSource() == menuItemNotepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        }
        else if (e.getSource() == menuItemFacInfo) {
            new newFaculty();
        }
        else if (e.getSource() == menuItemStuInfo) {
            new newStudent();
        }
        else if (e.getSource() == menuItemStuDet) {
            new studentDetails();
        }
        else if (e.getSource() == menuItemFacDet) {
            new facultyDetails();
        }
        else if (e.getSource() == menuItemExRes) {
            new ExaminationDetails();
        }
        else if (e.getSource() == menuItemEntMark) {
            new EnterStudMarks();
        }
        else if (e.getSource() == menuItemFeeStr) {
            new FeeStructure();
        }
    }

    public static void main(String[] args) {

        new Main();
    }
}