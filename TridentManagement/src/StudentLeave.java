import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class StudentLeave extends JFrame implements ActionListener {

    Choice empch,tduration;

    JDateChooser date ;

    JTextField purpose;
    String username;

    JButton submit,cancel;
    public StudentLeave(String username){

        this.username=username;
        setBounds(400,150,400,440);

        getContentPane().setBackground(new Color(255,255,102));

        setLayout(null);

        JLabel apply = new JLabel("Apply Leave For Student");
        apply.setBounds(30,30,400,40);
        apply.setFont(new Font("Raleway",Font.BOLD,25));
        add(apply);

        JLabel search = new JLabel("Search By EMP-ID");
        search.setBounds(60,70,400,30);
        search.setFont(new Font("Raleway",Font.BOLD,16));
        add(search);

        empch = new Choice();
        empch.setBounds(60,105,190,30);
        empch.setBackground(new Color(255,255,102));
        add(empch);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from addstudent");
            while (rs.next()){
                empch.add(rs.getString("Roll"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel datelb = new JLabel("Date");
        datelb.setBounds(60,130,400,30);
        datelb.setFont(new Font("Raleway",Font.BOLD,16));
        add(datelb);

        date = new JDateChooser();
        date.setBounds(60,160,190,25);
        add(date);

        JLabel duration = new JLabel("Time Duration");
        duration.setBounds(60,190,400,30);
        duration.setFont(new Font("Raleway",Font.BOLD,16));
        add(duration);

        tduration = new Choice();
        tduration.setBounds(60,225,190,30);
        tduration.add("Full Day");
        tduration.add("Half Day");
        tduration.add("2 Days");
        tduration.add("3 Days");
        tduration.add("5 Days");
        tduration.add("7 Days");
        tduration.setBackground(new Color(255,255,102));
        add(tduration);


        JLabel purposeleave = new JLabel("Purpose Of Leave");
        purposeleave.setBounds(60,245,400,30);
        purposeleave.setFont(new Font("Raleway",Font.BOLD,16));
        add(purposeleave);

        purpose = new JTextField();
        purpose.setBounds(60,280,190,25);
        add(purpose);

        submit = new JButton(" Submit");
        submit.setBounds(100,330,90,30);
        submit.setFont(new Font("Raleway",Font.PLAIN,15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBorder(new LineBorder(Color.WHITE));
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton(" Back");
        cancel.setBounds(220,330,90,30);
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

            String empid = (String) empch.getSelectedItem();

            String leavedate = ((JTextField)date.getDateEditor().getUiComponent()).getText();
            String TimeDuration = (String) tduration.getSelectedItem();

            String Proposelv = purpose.getText();

            try {
                String query = "insert into StudentLeave values('"+empid+"','"+leavedate+"','"+TimeDuration+"','"+Proposelv+"')";

                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Leave Applied Successfully");
                setVisible(false);
                new Project(username).setVisible(true);

            }catch (Exception ae){
                System.out.println(ae);
            }
        }
    }

    public static void main(String[] args) {

        new StudentLeave("");
    }
}
