package librarymanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReturnBooks extends JFrame{
    JLabel L1=new JLabel("Please specify the data of the book to be returned:                ");
    JLabel L2=new JLabel("Book ID: ");
    JTextField T1=new JTextField(20);
    JButton B1=new JButton("OK");
    JButton B2=new JButton("Cancel");
    public ReturnBooks(){
        
        addWindowListener(new WindowAdapter(){
            public void windowOpened(WindowEvent E){
                T1.requestFocus();
            }
    });
       
        JFrame J = new JFrame();
        setVisible(true);
        setTitle("Welcome To The Library Management System-Return Books (User ID- "+Login1.uid+")");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        add(L1);add(L2);add(T1);add(B1);add(B2);
        B1.addActionListener(new RB1());
        B2.addActionListener(new RB2());
    }
    
        class RB2 implements ActionListener{
            public void actionPerformed(ActionEvent A){
            new librarymanagement.MenuList();
            dispose();
        }}
    
        class RB1 implements ActionListener{
            public void actionPerformed(ActionEvent A){
                try{
                    
                Login1.P=Login1.Con.prepareCall("select * from Books where id=(?)");
                Login1.P.setInt(1,Integer.parseInt(T1.getText()));
                Login1.Rs=Login1.P.executeQuery();
                   
                if(Login1.Rs.next()){
                Login1.st=Login1.Con.createStatement();
                Login1.P=Login1.Con.prepareCall("delete from books where id=(?)");
                Login1.P.setInt(1,Integer.parseInt(T1.getText()));
                Login1.P.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Recorded successfully");
                        T1.setText("");
                        T1.requestFocus();
                }
                                     
                else{
                        JOptionPane.showMessageDialog(null, "Book ID Invalid");
                        T1.setText("");
                        T1.requestFocus();}
                }
                catch(Exception E){
                    JOptionPane.showMessageDialog(null, "Unsuccessful, Invalid data");
                        T1.setText("");
                        T1.requestFocus();}
                }
        }
    
    
    
}
