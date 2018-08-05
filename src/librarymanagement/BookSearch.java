package librarymanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookSearch extends JFrame{
    JLabel L0=new JLabel("Please specify valid details  ");
    JLabel L1=new JLabel("Search by Book ID: ");
    JTextField T1=new JTextField(10);
    JLabel L01=new JLabel("Book ID: ");
    JTextField T2=new JTextField(10);
    JLabel L2=new JLabel("Book Name: ");
    JTextField T3=new JTextField(10);
    JLabel L3=new JLabel("Roll number of the issuer: ");
    JTextField T4=new JTextField(10);
    JButton B1=new JButton("Search");
    JButton B2=new JButton("Cancel");
    public BookSearch(){
        addWindowListener(new WindowAdapter(){
            public void windowOpened(WindowEvent E){
                T1.requestFocus();
            }
    });
        JFrame J = new JFrame();
        setVisible(true);
        setTitle("Welcome To The Library Management System-Search Entries (User ID- "+Login1.uid+")");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        add(L0);add(L1);add(T1);add(L01);add(T2);add(L2);add(T3);add(L3);add(T4);add(B1);add(B2);
        T2.setEditable(false);
        T2.setEditable(false);
        T3.setEditable(false);
        T4.setEditable(false);
        B1.addActionListener(new SB1());
        B2.addActionListener(new SB2());
    }
    
    class SB1 implements ActionListener{
       public void actionPerformed(ActionEvent A){
        try{
                 
                Login1.st=Login1.Con.createStatement();
                Login1.P=Login1.Con.prepareCall("select * from Books where id=(?)");
                Login1.P.setInt(1,Integer.parseInt(T1.getText()));
                Login1.Rs=Login1.P.executeQuery();
                if(Login1.Rs.next()){
                    T2.setText(Login1.Rs.getString(1));
                    T3.setText(Login1.Rs.getString(2));
                    T4.setText(Login1.Rs.getString(3));
                }
                        
                else
                     JOptionPane.showMessageDialog(null, "No such records exists in the database");
                        T1.setText("");
                        T1.requestFocus();
                        }
                catch(Exception E){
                    JOptionPane.showMessageDialog(null, "Invalid ID");
                        T1.setText("");
                        T1.requestFocus();
                    }
        }        }
        
    class SB2 implements ActionListener{
        public void actionPerformed(ActionEvent A){
            new librarymanagement.MenuList();
            dispose();
        }
    }
    
}
