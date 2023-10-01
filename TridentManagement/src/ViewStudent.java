import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class ViewStudent extends JFrame implements ActionListener {


    JLabel namelb,fnamelb,rolllb,doblb,addresslb,phonelb,emaillb,classxlb,classxiilb,adharnolb,courselb,branchlb;

    String username;

    Choice crollno;
    JButton cancel,search,print,add,update;


    public ViewStudent(String username){

        this.username=username;
        setSize(830,600);
        setLocation(250,50);
        setLayout(null);
        getContentPane().setBackground(new Color(255,255,102));

        JLabel heading = new JLabel( "View Student Details");
        heading.setBounds(30,30,190,30);
        heading.setFont(new Font("Raleway",Font.BOLD,17));
        add(heading);

        crollno = new Choice();
        crollno.setBounds(220,35,190,30);
        //crollno.setBackground(new Color(255,255,102));
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

        JLabel name = new JLabel( "Name");
        name.setBounds(50,120,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,16));
        add(name);

        namelb = new JLabel();
        namelb.setBounds(175,120,170,26);
        add(namelb);

        JLabel fname = new JLabel( "Father Name");
        fname.setBounds(400,120,100,30);
        fname.setFont(new Font("Raleway",Font.BOLD,16));
        add(fname);

        fnamelb = new JLabel();
        fnamelb.setBounds(540,120,170,26);
        add(fnamelb);

        JLabel rollno = new JLabel( "Roll");
        rollno.setBounds(50,170,100,30);
        rollno.setFont(new Font("Raleway",Font.BOLD,16));
        add(rollno);

        rolllb = new JLabel();
        rolllb.setBounds(175,170,100,30);
        rolllb.setFont(new Font("Raleway",Font.BOLD,16));
        add(rolllb);

        JLabel dob = new JLabel( "Date of Birth");
        dob.setBounds(400,170,100,30);
        dob.setFont(new Font("Raleway",Font.BOLD,16));
        add(dob);

        doblb= new JLabel();
        doblb.setBounds(540,170,170,26);
        add(doblb);

        JLabel address = new JLabel( "Address");
        address.setBounds(50,220,100,30);
        address.setFont(new Font("Raleway",Font.BOLD,16));
        add(address);

        addresslb = new JLabel();
        addresslb.setBounds(175,220,170,26);
        add(addresslb);

        JLabel phone = new JLabel( "Phone");
        phone.setBounds(400,220,100,30);
        phone.setFont(new Font("Raleway",Font.BOLD,16));
        add(phone);

        phonelb = new JLabel();
        phonelb.setBounds(540,220,170,26);
        add(phonelb);



        JLabel email = new JLabel( "Email ID");
        email.setBounds(50,270,100,30);
        email.setFont(new Font("Raleway",Font.BOLD,16));
        add(email);

        emaillb = new JLabel();
        emaillb.setBounds(175,270,170,26);
        add(emaillb);

        JLabel classx = new JLabel( "Class X(%)");
        classx.setBounds(400,270,100,30);
        classx.setFont(new Font("Raleway",Font.BOLD,16));
        add(classx);

        classxlb = new JLabel();
        classxlb.setBounds(540,270,170,26);
        add(classxlb);




        JLabel classxii = new JLabel( "Class XII(%)");
        classxii.setBounds(50,320,100,30);
        classxii.setFont(new Font("Raleway",Font.BOLD,16));
        add(classxii);

        classxiilb = new JLabel();
        classxiilb.setBounds(175,320,170,26);
        add(classxiilb);

        JLabel aadhar = new JLabel( "Aadhar Number");
        aadhar.setBounds(400,320,130,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,16));
        add(aadhar);

        adharnolb = new JLabel();
        adharnolb.setBounds(540,320,170,26);
        add(adharnolb);



        JLabel courdel = new JLabel( "Course");
        courdel.setBounds(50,370,100,30);
        courdel.setFont(new Font("Raleway",Font.BOLD,16));
        add(courdel);


        courselb = new JLabel();

        courselb.setBounds(175,370,170,26);
        add(courselb);

        JLabel branchl = new JLabel( "Branch");
        branchl.setBounds(400,370,130,30);
        branchl.setFont(new Font("Raleway",Font.BOLD,16));
        add(branchl);


        branchlb = new JLabel();

        branchlb.setBounds(540,370,170,26);
        add(branchlb);





        cancel = new JButton(" Back");
        cancel.setBounds(610,470,90,30);
        cancel.setFont(new Font("Raleway",Font.PLAIN,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBorder(new LineBorder(Color.WHITE));
        cancel.addActionListener(this);
        add(cancel);

        search = new JButton(" Search");
        search.setBounds(50,470,90,30);
        search.setFont(new Font("Raleway",Font.PLAIN,15));
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBorder(new LineBorder(Color.WHITE));
        search.addActionListener(this);
        add(search);

        print = new JButton(" Print");
        print.setBounds(190,470,90,30);
        print.setFont(new Font("Raleway",Font.PLAIN,15));
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setBorder(new LineBorder(Color.WHITE));
        print.addActionListener(this);
        add(print);

        add = new JButton(" Add");
        add.setBounds(330,470,90,30);
        add.setFont(new Font("Raleway",Font.PLAIN,15));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBorder(new LineBorder(Color.WHITE));
        add.addActionListener(this);
        add(add);

        update = new JButton(" Update");
        update.setBounds(470,470,90,30);
        update.setFont(new Font("Raleway",Font.PLAIN,15));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBorder(new LineBorder(Color.WHITE));
        update.addActionListener(this);
        add(update);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==search){

            try {


                Conn c = new Conn();
                ResultSet rel = c.s.executeQuery("Select * from addstudent where Roll ='" + crollno.getSelectedItem() + "' ");

                if (rel.next()) {
                    namelb.setText(rel.getString("Name"));
                    fnamelb.setText(rel.getString("FName"));
                    rolllb.setText(rel.getString("Roll"));
                    doblb.setText(rel.getString("Dob"));
                    addresslb.setText(rel.getString("Address"));
                    phonelb.setText(rel.getString("Phone"));
                    emaillb.setText(rel.getString("Email"));
                    classxlb.setText(rel.getString("ClassXMark"));
                    classxiilb.setText(rel.getString("ClassXIIMark"));
                    adharnolb.setText(rel.getString("Aadhar"));
                    courselb.setText(rel.getString("Course"));
                    branchlb.setText(rel.getString("Branch"));

                }

            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()==print) {

        } else if (ae.getSource()==add) {
            setVisible(false);
            new AddStudent(username).setVisible(true);

        } else if (ae.getSource()==update) {

        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Project(username).setVisible(true);
        }


    }

    public static void main(String[] args) {
        new ViewStudent("");
    }
}
