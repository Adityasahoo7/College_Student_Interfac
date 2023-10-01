import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField nametf,fnametf,addresstf,phonetf,emailtf,classxtf,classxiitf,adharnotf;

    JDateChooser ddob ;

    Choice empch;
    JComboBox coursejcb,branchjcb;
    JButton submit,cancel, searchbt ;
    JLabel empid;
    String username;


    public UpdateTeacher(String username){

        this.username=username;
        setSize(830,600);
        setLocation(250,50);
        setLayout(null);
        getContentPane().setBackground(new Color(255,255,105));

        JLabel heading = new JLabel( "Update Teacher Details");
        heading.setBounds(310,10,500,50);
        heading.setFont(new Font("Raleway",Font.BOLD,20));
        add(heading);

        JLabel search = new JLabel( "Search By EMP-ID");
        search.setBounds(30,60,200,30);
        search.setFont(new Font("Raleway",Font.BOLD,18));
        add(search);

        empch = new Choice();
        empch.setBounds(230,64,190,30);
        empch.setBackground(new Color(255,255,102));
        add(empch);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from addteacher");
            while (rs.next()){
                empch.add(rs.getString("EmpID"));
            }

        }catch (Exception e){
            System.out.println(e);
        }


        searchbt = new JButton(" Search");
        searchbt.setBounds(450,61,90,30);
        searchbt.setFont(new Font("Raleway",Font.PLAIN,15));
        searchbt.setBackground(Color.BLACK);
        searchbt.setForeground(Color.WHITE);
        searchbt.setBorder(new LineBorder(Color.WHITE));
        searchbt.addActionListener(this);
        add(searchbt);


        JLabel name = new JLabel( "Name");
        name.setBounds(50,120,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,16));
        add(name);

        nametf = new JTextField();
        nametf.setBounds(175,120,170,26);
        add(nametf);

        JLabel fname = new JLabel( "Father Name");
        fname.setBounds(400,120,100,30);
        fname.setFont(new Font("Raleway",Font.BOLD,16));
        add(fname);

        fnametf = new JTextField();
        fnametf.setBounds(540,120,170,26);
        add(fnametf);

        JLabel rollno = new JLabel( "Emp-Id");
        rollno.setBounds(50,170,100,30);
        rollno.setFont(new Font("Raleway",Font.BOLD,16));
        add(rollno);

        empid = new JLabel();
        empid.setBounds(175,170,100,30);
        empid.setFont(new Font("Raleway",Font.BOLD,16));
        add(empid);

        JLabel dob = new JLabel( "Date of Birth");
        dob.setBounds(400,170,100,30);
        dob.setFont(new Font("Raleway",Font.BOLD,16));
        add(dob);

        ddob= new JDateChooser();
        ddob.setBounds(540,170,170,26);
        add(ddob);

        JLabel address = new JLabel( "Address");
        address.setBounds(50,220,100,30);
        address.setFont(new Font("Raleway",Font.BOLD,16));
        add(address);

        addresstf = new JTextField();
        addresstf.setBounds(175,220,170,26);
        add(addresstf);

        JLabel phone = new JLabel( "Phone");
        phone.setBounds(400,220,100,30);
        phone.setFont(new Font("Raleway",Font.BOLD,16));
        add(phone);

        phonetf = new JTextField();
        phonetf.setBounds(540,220,170,26);
        add(phonetf);



        JLabel email = new JLabel( "Email ID");
        email.setBounds(50,270,100,30);
        email.setFont(new Font("Raleway",Font.BOLD,16));
        add(email);

        emailtf = new JTextField();
        emailtf.setBounds(175,270,170,26);
        add(emailtf);

        JLabel classx = new JLabel( "Class X(%)");
        classx.setBounds(400,270,100,30);
        classx.setFont(new Font("Raleway",Font.BOLD,16));
        add(classx);

        classxtf = new JTextField();
        classxtf.setBounds(540,270,170,26);
        add(classxtf);




        JLabel classxii = new JLabel( "Class XII(%)");
        classxii.setBounds(50,320,100,30);
        classxii.setFont(new Font("Raleway",Font.BOLD,16));
        add(classxii);

        classxiitf = new JTextField();
        classxiitf.setBounds(175,320,170,26);
        add(classxiitf);

        JLabel aadhar = new JLabel( "Aadhar Number");
        aadhar.setBounds(400,320,130,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,16));
        add(aadhar);

        adharnotf = new JTextField();
        adharnotf.setBounds(540,320,170,26);
        add(adharnotf);



        JLabel courdel = new JLabel( "Education");
        courdel.setBounds(50,370,100,30);
        courdel.setFont(new Font("Raleway",Font.BOLD,16));
        add(courdel);

        String course[] ={"B-Tech","M-Tech","BBA","BCA","Bio-Tech","MCA","MBA"};
        coursejcb = new JComboBox<>(course);
        coursejcb.setBackground(new Color(86,128,233));
        coursejcb.setBounds(175,370,170,26);
        add(coursejcb);

        JLabel branchl = new JLabel( "Department");
        branchl.setBounds(400,370,130,30);
        branchl.setFont(new Font("Raleway",Font.BOLD,16));
        add(branchl);

        String branch[]={"Cse","ETC","CS-AIML","CST","Mechanical","Civil","CS-IT"};
        branchjcb = new JComboBox<>(branch);
        branchjcb.setBackground(new Color(86,128,233));
        branchjcb.setBounds(540,370,170,26);
        add(branchjcb);


        submit = new JButton(" Submit");
        submit.setBounds(300,470,90,30);
        submit.setFont(new Font("Raleway",Font.PLAIN,15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBorder(new LineBorder(Color.WHITE));
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton(" Back");
        cancel.setBounds(430,470,90,30);
        cancel.setFont(new Font("Raleway",Font.PLAIN,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBorder(new LineBorder(Color.WHITE));
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==searchbt){

            try {
                String strempid =empch.getSelectedItem();
                Conn ch = new Conn();
                ResultSet rs = ch.s.executeQuery("Select * from addteacher where EmpID = '"+strempid+"'");
                if (rs.next()){

                    empid.setText(rs.getString("EmpID"));
                    nametf.setText(rs.getString("Name"));
                    fnametf.setText(rs.getString("FName"));
                   // ddob.setDateFormatString(rs.getString("Dob"));
                    ddob.setName(rs.getString("Dob"));
                    addresstf.setText(rs.getString("Address"));
                    phonetf.setText(rs.getString("Phone"));
                    emailtf.setText(rs.getString("Email"));
                    classxtf.setText(rs.getString("ClassXMark"));
                    classxiitf.setText(rs.getString("ClassXIIMark"));
                    adharnotf.setText(rs.getString("Aadhar"));
                    coursejcb.setName(rs.getString("Education"));
                    branchjcb.setName(rs.getString("Department"));



                }
            }catch (Exception e){

                System.out.println(e);
            }

        } else if (ae.getSource()==submit){

            String name = nametf.getText();
            String fname = fnametf.getText();
            String roll = empid.getText();
            String dob = ((JTextField)ddob.getDateEditor().getUiComponent()).getText();
            String address = addresstf.getText();
            String phone = phonetf.getText();
            String email = emailtf.getText();
            String classx = classxtf.getText();
            String classxii = classxiitf.getText();
            String aadhar = adharnotf.getText();
            String course = (String) coursejcb.getSelectedItem();
            String branch = (String) branchjcb.getSelectedItem();

            try {

                Conn c = new Conn();
                String query  ="update addteacher set Name ='"+name+"',FName = '"+fname+"',EmpID ='"+roll+"',Dob ='"+dob+"',Address = '"+address+"',Phone ='"+phone+"',Email='"+email+"',ClassXMark ='"+classx+"',ClassXIIMark='"+classxii+"',Aadhar='"+aadhar+"',Education='"+course+"',Department='"+branch+"' ";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Details Update Successfully");
                setVisible(false);
                new Project(username).setVisible(true);


            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Project(username).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher("");
    }
}
