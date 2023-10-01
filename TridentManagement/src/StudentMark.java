import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentMark extends JFrame implements ActionListener {

    String username;

    JButton submit,cancel;

    Choice crollno;

    JComboBox semesterch;

    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
    public StudentMark(String username){

        this.username=username;

        setBounds(200,100,900,480);
        setLayout(null);
        getContentPane().setBackground(new Color(255,255,102));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480,20,400,400);
        add(image);

        JLabel heading = new JLabel( "Enter Mark of Student");
        heading.setBounds(100,30,390,30);
        heading.setFont(new Font("Raleway",Font.BOLD,24));
        add(heading);

        JLabel selectroll = new JLabel( "Select Roll Number");
        selectroll.setBounds(30,65,190,30);
        selectroll.setFont(new Font("Raleway",Font.BOLD,17));
        add(selectroll);

        crollno = new Choice();
        crollno.setBounds(220,69,190,30);
        crollno.setBackground(new Color(255,255,102));
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from addstudent");
            while (rs.next()){
                crollno.add(rs.getString("Roll"));
            }
        }catch (Exception e){
            System.out.println(e);
        }


        JLabel selectsem = new JLabel( "Select Semester");
        selectsem.setBounds(30,108,190,30);
        selectsem.setFont(new Font("Raleway",Font.BOLD,19));
        add(selectsem);

        String sem[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        semesterch = new JComboBox<>(sem);
        semesterch.setBackground(new Color(255,254,102));
        semesterch.setBounds(220,108,190,26);
        add(semesterch);

        JLabel entsub = new JLabel( "Enter  Subject");
        entsub.setBounds(50,165,190,30);
        entsub.setFont(new Font("Raleway",Font.BOLD,16));
        add(entsub);

        JLabel entmark = new JLabel( "Enter Mark");
        entmark.setBounds(250,165,190,30);
        entmark.setFont(new Font("Raleway",Font.BOLD,16));
        add(entmark);

        tf1= new JTextField();
        tf1.setBounds(30,200,200,24);
        tf1.setBackground(new Color(255,255,103));
        add(tf1);

        tf2= new JTextField();
        tf2.setBounds(240,200,200,24);
        tf2.setBackground(new Color(255,255,103));
        add(tf2);


        tf3= new JTextField();
        tf3.setBounds(30,225,200,24);
        tf3.setBackground(new Color(255,255,103));
        add(tf3);

        tf4= new JTextField();
        tf4.setBounds(240,225,200,24);
        tf4.setBackground(new Color(255,255,103));
        add(tf4);

        tf5= new JTextField();
        tf5.setBounds(30,250,200,24);
        tf5.setBackground(new Color(255,255,103));
        add(tf5);

        tf6= new JTextField();
        tf6.setBounds(240,250,200,24);
        tf6.setBackground(new Color(255,255,103));
        add(tf6);

        tf7= new JTextField();
        tf7.setBounds(30,275,200,24);
        tf7.setBackground(new Color(255,255,103));
        add(tf7);

        tf8= new JTextField();
        tf8.setBounds(240,275,200,24);
        tf8.setBackground(new Color(255,255,103));
        add(tf8);

        tf9= new JTextField();
        tf9.setBounds(30,300,200,24);
        tf9.setBackground(new Color(255,255,103));
        add(tf9);

        tf10= new JTextField();
        tf10.setBounds(240,300,200,24);
        tf10.setBackground(new Color(255,255,103));
        add(tf10);

        tf11= new JTextField();
        tf11.setBounds(30,325,200,24);
        tf11.setBackground(new Color(255,255,103));
        add(tf11);

        tf12= new JTextField();
        tf12.setBounds(240,325,200,24);
        tf12.setBackground(new Color(255,255,103));
        add(tf12);

        submit = new JButton(" Submit");
        submit.setBounds(100,370,90,30);
        submit.setFont(new Font("Raleway",Font.PLAIN,15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBorder(new LineBorder(Color.WHITE));
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton(" Back");
        cancel.setBounds(230,370,90,30);
        cancel.setFont(new Font("Raleway",Font.PLAIN,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBorder(new LineBorder(Color.WHITE));
        cancel.addActionListener(this);
        add(cancel);




        setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==cancel){
            setVisible(false);
            new Project(username).setVisible(true);
        } else if (e.getSource()==submit) {
            String roll = (String) crollno.getSelectedItem();
            String semester= (String) semesterch.getSelectedItem();
            String Sub1 = tf1.getText();
            String mark1 = tf2.getText();
            String Sub2 = tf3.getText();
            String mark2 = tf4.getText();
            String Sub3 = tf5.getText();
            String mark3 = tf6.getText();
            String Sub4 = tf7.getText();
            String mark4 = tf8.getText();
            String Sub5 = tf9.getText();
            String mark5 = tf10.getText();
            String Sub6 = tf11.getText();
            String mark6 = tf12.getText();

            try {

                String query = "insert into Mark values ('"+roll+"','"+semester+"','"+Sub1+"','"+mark1+"','"+Sub2+"','"+mark2+"','"+Sub3+"','"+mark3+"','"+Sub4+"','"+mark4+"','"+Sub5+"','"+mark5+"','"+Sub6+"','"+mark6+"')";

                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Mark Added Successfully");
                setVisible(false);



            }catch (Exception ae){
                System.out.println(ae);
            }


        }

    }

    public static void main(String[] args) {
        new StudentMark(" ");
    }
}
