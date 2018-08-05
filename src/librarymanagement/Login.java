package librarymanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login1 extends JFrame{
    int trial=3;
    static String uid;
    static Connection Con=null;
    static Statement st=null;
    static PreparedStatement P=null; 
    static ResultSet Rs=null;
    JLabel L1=new JLabel("Username:  ");
    JLabel L2=new JLabel("Password:  ");
    JTextField T1=new JTextField(20);
    JPasswordField T2=new JPasswordField(20);
    JButton B1=new JButton("Login");
    JButton B2=new JButton("Cancel");
    JLabel L3=new JLabel();
    public Login1(){
        addWindowListener(new WindowAdapter(){
            public void windowOpened(WindowEvent E){
                T1.requestFocus();
            }
    });
            
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Con=DriverManager.getConnection("jdbc:mysql://localhost/Library","root","root");
    }
    catch(Exception E){
    JOptionPane.showMessageDialog(null, "Database Connectivity Unsucccessful");
    dispose();
    System.exit(0);
    }     
        JFrame J = new JFrame();    
        setVisible(true);
        setTitle("Welcome To The Library Management System-User Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        this.setExtendedState(this.MAXIMIZED_BOTH);
        add(L1); add(T1); add(L2); add(T2); add(B1); add(B2);
        B1.addActionListener(new BB1());
        B2.addActionListener(new BB2());
    
    }

    class BB1 implements ActionListener{
    public void actionPerformed(ActionEvent A){
        try{
        int a=Integer.parseInt(T1.getText());
        String b=T2.getText();
        st=Con.createStatement();
        P=Con.prepareStatement("select * from login where id=(?) and pwd=(?)");
        P.setInt(1,a);
        P.setString(2,b);
        Rs=P.executeQuery();
        if(Rs.next()){
            JOptionPane.showMessageDialog(null, "Login Successul");
            uid=T1.getText();
            new librarymanagement.MenuList();
            dispose();
          }
        else{
            if(trial==1){
         JOptionPane.showMessageDialog(null, "You have exceeded maximum attempts. Application will shut down");
         System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "Login unsuccessful, You have maximum of "+(--trial)+" attempt(s) left");
            T1.setText("");
            T2.setText("");
                T1.requestFocus();
           }
        
    }
    catch(Exception f){
        if(trial==1){
         JOptionPane.showMessageDialog(null, "You have exceeded maximum attempts. Application will shut down");
         System.exit(0);
         }
        JOptionPane.showMessageDialog(null, "Username and password invalid, You have maximum of "+(--trial)+" attempt(s) left");
            T1.setText("");
            T2.setText("");
           T1.requestFocus();
    }   }
} 

class BB2 implements ActionListener{
    public void actionPerformed(ActionEvent B){
        dispose();
        System.exit(0);
    } }

void funTime(int i){
    add(L3);
    if(i==59)
 try{
     for(;i>=0;i--){
         L3.setText("     Application will shutdown within "+String.valueOf(i)+" second(s) on Login Failure");
         Thread.sleep(1000);
         if(i==0){
             dispose();
         }
        
     }
 }
 catch(InterruptedException E){}
}}

public class Login {
    static int i=59;
    public static void main(String[] args){
    new Login1().funTime(i);
   }    
}