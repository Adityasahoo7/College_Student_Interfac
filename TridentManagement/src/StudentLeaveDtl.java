import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentLeaveDtl extends JFrame implements ActionListener {

    Choice empch;

    JLabel date,timeduration,Purpose;


    String username;

    JButton show,cancel;
    public StudentLeaveDtl(String username){

        this.username=username;
        setBounds(400,150,400,370);

        getContentPane().setBackground(new Color(255,255,102));

        setLayout(null);

        JLabel apply = new JLabel("Leave Detail of Student");
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
            ResultSet rs = c.s.executeQuery("Select * from TeacherLeave");
            while (rs.next()){
                empch.add(rs.getString("EmpID"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel datelb = new JLabel("Date");
        datelb.setBounds(40,130,200,30);
        datelb.setFont(new Font("Raleway",Font.BOLD,16));
        add(datelb);

        date = new JLabel();
        date.setFont(new Font("Rale way",Font.BOLD,15));
        date.setBounds(200,130,150,30);
        add(date);



        JLabel durationlb = new JLabel("Time Duration");
        durationlb.setBounds(40,165,200,30);
        durationlb.setFont(new Font("Raleway",Font.BOLD,16));
        add(durationlb);

        timeduration = new JLabel();
        timeduration.setFont(new Font("Rale way",Font.BOLD,15));
        timeduration.setBounds(200,165,150,30);
        add(timeduration);

        JLabel purposelb = new JLabel("Purpose Of Leave");
        purposelb.setBounds(40,200,200,30);
        purposelb.setFont(new Font("Raleway",Font.BOLD,16));
        add(purposelb);

        Purpose = new JLabel();
        Purpose.setFont(new Font("Rale way",Font.BOLD,15));
        Purpose.setBounds(200,200,150,30);
        add(Purpose);



        show = new JButton(" Show");
        show.setBounds(100,270,90,30);
        show.setFont(new Font("Raleway",Font.PLAIN,15));
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBorder(new LineBorder(Color.WHITE));
        show.addActionListener(this);
        add(show);


        cancel = new JButton(" Back");
        cancel.setBounds(220,270,90,30);
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

        } else if (e.getSource()==show) {
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from StudentLeave");
                while (rs.next()){
                    date.setText(rs.getString("LeaveDate"));
                    timeduration.setText(rs.getString("TimeDuration"));
                    Purpose.setText(rs.getString("Purpose"));


                }
            } catch (Exception ex) {
                System.out.println(ex);
            }


        }
    }

    public static void main(String[] args) {

        new StudentLeaveDtl("");
    }
}
