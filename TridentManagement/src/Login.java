import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField usertf,passwordtf ;
    JButton login,cancel;
    public Login(){
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(30,40,100,30);
        username.setFont(new Font("Raleway",Font.BOLD,17));
        add(username);
        usertf = new JTextField();
        usertf.setBounds(130,40,200,25);
        add(usertf);

        JLabel password = new JLabel("Password");
        password.setBounds(30,100,100,30);
        password.setFont(new Font("Raleway",Font.BOLD,17));
        add(password);
        passwordtf = new JTextField();
        passwordtf.setBounds(130,100,200,25);
        add(passwordtf);

        login = new JButton(" Login");
        login.setBounds(90,200,90,30);
        login.setFont(new Font("Raleway",Font.PLAIN,15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(Color.WHITE));
        login.addActionListener(this);
        add(login);


        cancel = new JButton(" Cancel");
        cancel.setBounds(200,200,90,30);
        cancel.setFont(new Font("Raleway",Font.PLAIN,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBorder(new LineBorder(Color.WHITE));
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/down1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(260,260,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,260,260);
        add(image);

        getContentPane().setBackground(new Color(134,201,239));
        setSize(600,300);
        setLocation(400,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==login){
            String username = usertf.getText();
            String password = passwordtf.getText();

            String query = "Select * from login where username = '"+username+"' and password = '"+password+"'";

            try {
                Conn c = new Conn();
              ResultSet rs = c.s.executeQuery(query);
              if (rs.next()){
                setVisible(false);
                new Project(username).setVisible(true);
              }else {
                JOptionPane.showMessageDialog(null,"Invalid Username And Password");
                setVisible(false);
              }

            }catch (Exception ae){
                System.out.println(ae);
            }
        } else if (e.getSource()==cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}
