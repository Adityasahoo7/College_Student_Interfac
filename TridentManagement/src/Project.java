import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    String username;
    JMenuItem facultyinfo,studentinfo,ex,facultydetails,studentdetails,facultyleave,studentleave,facultyleavedetail,studentleavedetail,examdetail,entermark,updatefaculty,updatestudent,feestructer,feeform;
    public Project(String username){
        this.username=username;
        setLayout(null);
        setSize(1400,750);


        getContentPane().setBackground(new Color(134,201,239));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/main.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400,677,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1400,677);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu newinformation  = new JMenu("New Information");
        newinformation.setForeground(new Color(216,63,135));
        newinformation.setFont(new Font("Raleway",Font.BOLD,16));

         facultyinfo = new JMenuItem("New Faculty Information");
        facultyinfo.setForeground(new Color(86,128,233));
        facultyinfo.setFont(new Font("Ralewai",Font.BOLD,14));
        facultyinfo.setBackground(Color.white);
        facultyinfo.addActionListener(this);
        newinformation.add(facultyinfo);

         studentinfo = new JMenuItem("New Student Information");
        studentinfo.setForeground(new Color(86,128,233));
        studentinfo.setFont(new Font("Ralewai",Font.BOLD,14));
        studentinfo.setBackground(Color.white);
        studentinfo.addActionListener(this);
        newinformation.add(studentinfo);

        mb.add(newinformation);

        JMenu detail  = new JMenu("View Details");
        detail.setForeground(new Color(216,63,135));
        detail.setFont(new Font("Raleway",Font.BOLD,16));

         facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setForeground(new Color(86,128,233));
        facultydetails.setFont(new Font("Ralewai",Font.BOLD,14));
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        detail.add(facultydetails);

         studentdetails = new JMenuItem("View Student Details");
        studentdetails.setForeground(new Color(86,128,233));
        studentdetails.setFont(new Font("Ralewai",Font.BOLD,14));
        studentdetails.setBackground(Color.white);
        studentdetails.addActionListener(this);
        detail.add(studentdetails);

        mb.add(detail);

        JMenu leave  = new JMenu("Apply Leave");
        leave.setForeground(new Color(216,63,135));
        leave.setFont(new Font("Raleway",Font.BOLD,16));

         facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setForeground(new Color(86,128,233));
        facultyleave.setFont(new Font("Ralewai",Font.BOLD,14));
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

         studentleave = new JMenuItem(" Student Leave");
        studentleave.setForeground(new Color(86,128,233));
        studentleave.setFont(new Font("Ralewai",Font.BOLD,14));
        studentleave.setBackground(Color.white);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        mb.add(leave);

        JMenu leavedetail  = new JMenu("Leave Detail");
        leavedetail.setForeground(new Color(216,63,135));
        leavedetail.setFont(new Font("Raleway",Font.BOLD,16));

         facultyleavedetail = new JMenuItem("View Faculty Leave");
        facultyleavedetail.setForeground(new Color(86,128,233));
        facultyleavedetail.setFont(new Font("Raleway",Font.BOLD,14));
        facultyleavedetail.setBackground(Color.white);
       facultyleavedetail.addActionListener(this);
        leavedetail.add(facultyleavedetail);

         studentleavedetail = new JMenuItem("View Student Leave");
        studentleavedetail.setForeground(new Color(86,128,233));
        studentleavedetail.setFont(new Font("Ralewai",Font.BOLD,14));
        studentleavedetail.setBackground(Color.white);
        studentleavedetail.addActionListener(this);
        leavedetail.add(studentleavedetail);

        mb.add(leavedetail);

        JMenu exam  = new JMenu("Exam");
        exam.setForeground(new Color(216,63,135));
        exam.setFont(new Font("Raleway",Font.BOLD,16));



        examdetail = new JMenuItem("Examination Result");
        examdetail.setForeground(new Color(86,128,233));
        examdetail.setFont(new Font("Ralewai",Font.BOLD,14));
        examdetail.setBackground(Color.white);
        examdetail.addActionListener(this);
        exam.add(examdetail);

         entermark = new JMenuItem("Enter Marks");
        entermark.setForeground(new Color(86,128,233));
        entermark.setFont(new Font("Ralewai",Font.BOLD,14));
        entermark.setBackground(Color.white);
        entermark.addActionListener(this);
        exam.add(entermark);

        mb.add(exam);

        JMenu updateinfo  = new JMenu("Update Details");
        updateinfo.setForeground(new Color(216,63,135));
        updateinfo.setFont(new Font("Raleway",Font.BOLD,16));

         updatefaculty = new JMenuItem("Update Faculty Details");
        updatefaculty.setForeground(new Color(86,128,233));
        updatefaculty.setFont(new Font("Ralewai",Font.BOLD,14));
        updatefaculty.setBackground(Color.white);
        updatefaculty.addActionListener(this);
        updateinfo.add(updatefaculty);

         updatestudent = new JMenuItem("Update Student Details");
        updatestudent.setForeground(new Color(86,128,233));
        updatestudent.setFont(new Font("Ralewai",Font.BOLD,14));
        updatestudent.setBackground(Color.white);
        updatestudent.addActionListener(this);
        updateinfo.add(updatestudent);

        mb.add(updateinfo);

        JMenu fee  = new JMenu("Fee Details");
        fee.setForeground(new Color(216,63,135));
        fee.setFont(new Font("Raleway",Font.BOLD,16));



        JMenu exit  = new JMenu("Exit");
        exit.setForeground(new Color(216,63,135));
        exit.setFont(new Font("Raleway",Font.BOLD,16));

         ex = new JMenuItem("Exit ");
        ex.setForeground(new Color(86,128,233));
        ex.setFont(new Font("Ralewai",Font.BOLD,14));
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);
        mb.add(exit);

        setJMenuBar(mb);



        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource()==ex){
        setVisible(false);
    } else if (e.getSource()==facultyinfo) {
        new AddTeacher(username).setVisible(true);
    } else if (e.getSource()==studentinfo) {
        new AddStudent(username).setVisible(true);
    } else if (e.getSource()==facultydetails) {
         new ViewTeacher(username).setVisible(true);
    } else if (e.getSource()==studentdetails) {
         new ViewStudent(username).setVisible(true);
    } else if (e.getSource()==studentleave) {
        new StudentLeave(username).setVisible(true);
    } else if (e.getSource()==facultyleave) {
        new TeacherLeave(username).setVisible(true);
    } else if (e.getSource()==updatefaculty) {
        new UpdateTeacher(username).setVisible(true);
    } else if (e.getSource()==updatestudent) {
        new UpdateStudent(username).setVisible(true);
    } else if (e.getSource()==entermark) {
        new StudentMark(username).setVisible(true);

    } else if (e.getSource()==examdetail) {
        new StudentResult(username).setVisible(true);
    } else if (e.getSource()==facultyleavedetail) {
        new TeacherLeaveDtl(username).setVisible(true);
    } else if (e.getSource()==studentleavedetail) {
        new StudentLeaveDtl(username).setVisible(true);
    }


    }

    public static void main(String[] args) {

        new Project("");
    }
}
