import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {

    JTextField nametf,fnametf,addresstf,phonetf,emailtf,classxtf,classxiitf,adharnotf;

    JDateChooser ddob ;
    JComboBox coursejcb,branchjcb;
    JButton submit,cancel;
    JLabel empid;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) +1000L);
    String username;


    public AddTeacher(String username){

        this.username=username;
        setSize(830,600);
        setLocation(250,50);
        setLayout(null);
        getContentPane().setBackground(new Color(86,128,233));

        JLabel heading = new JLabel( "New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("Raleway",Font.BOLD,20));
        add(heading);

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

        empid = new JLabel( "201"+first4);
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

        if (ae.getSource()==submit){

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
                String query  ="insert into addteacher values('"+name+"','"+fname+"','"+roll+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+classx+"','"+classxii+"','"+aadhar+"','"+course+"','"+branch+"')";

                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Details Update Successfully");
                setVisible(false);


            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Project(username).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AddTeacher("");
    }
}
