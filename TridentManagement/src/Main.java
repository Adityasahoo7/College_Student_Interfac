import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements  Runnable {
    Thread t;
 public Main(){

     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
     Image i2 = i1.getImage().getScaledInstance(900,500,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     add(image);

    t= new Thread(this);
    t.start();

     setVisible(true);

        int x =1;
     for (int i = 0;i<=500;i+=4,x+=1) {
        setLocation(530-((i+x)/2),350-(i/2));
         setSize(i+(3*x),i+(x/3));

         try {
             Thread.sleep(10);
         }catch (Exception e){
             System.out.println(e);
         }
     }
 }

    @Override
    public void run() {
    try {
        Thread.sleep(7000);
        setVisible(false);
        new Login().setVisible(true);
    }catch (Exception ae){
        System.out.println(ae);
    }
    }

    public static void main(String[] args) {
 Main m = new Main();
    }
}