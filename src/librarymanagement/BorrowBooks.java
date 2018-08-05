package librarymanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BorrowBooks extends JFrame{
    JLabel L4=new JLabel("Enter data in the required fields:                       ");
    JLabel L1=new JLabel("Enter the Book ID");
    JLabel L2=new JLabel("Enter the Book Name");
    JLabel L3=new JLabel("Enter the Student Roll No.");
    JButton B1=new JButton("OK");
    JButton B2=new JButton("Cancel");
    JTextField T1=new JTextField(20);
    JTextField T2=new JTextField(20);
    JTextField T3=new JTextField(20);
    public BorrowBooks(){
            
        addWindowListener(new WindowAdapter(){
            public void windowOpened(WindowEvent E){
                T1.requestFocus();
            }
    });
        
    JFrame J = new JFrame();
    setVisible(true);
    setTitle("Welcome To The Library Management System-Borrow Books (User ID- "+Login1.uid+")");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    this.setExtendedState(this.MAXIMIZED_BOTH);
    add(L4);add(L1);add(T1);add(L2);add(T2);add(L3);add(T3);add(B1);add(B2);
    B1.addActionListener(new BuB1());
    B2.addActionListener(new BuB2());
    }
        
        class BuB1 implements ActionListener{
            public void actionPerformed(ActionEvent A){
                try{
                    
                Login1.st=Login1.Con.createStatement();
                Login1.P=Login1.Con.prepareCall("insert into Books values (?,?,?)");
                Login1.P.setInt(1,Integer.parseInt(T1.getText()));
                Login1.P.setString(2,T2.getText());
                Login1.P.setInt(3,Integer.parseInt(T3.getText()));
                Login1.P.executeUpdate();
                Login1.P=Login1.Con.prepareCall("select * from Books where id=(?)");
                Login1.P.setInt(1,Integer.parseInt(T1.getText()));
                Login1.Rs=Login1.P.executeQuery();
                if(Login1.Rs.next()){
                        JOptionPane.showMessageDialog(null, "Entry Successul");
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T1.requestFocus();
                }
                else{
                        JOptionPane.showMessageDialog(null, "Entry Unsuccessul");
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T1.requestFocus();
                        }
                }
                catch(Exception E){
                    JOptionPane.showMessageDialog(null, "Unsuccessful, Invalid entry details or the student has already issued a book");
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T1.requestFocus();
                }
                
        }}
        class BuB2 implements ActionListener{
                public void actionPerformed(ActionEvent A){
                    dispose();
                    new librarymanagement.MenuList();
        }
}
    
    
    
    
}
