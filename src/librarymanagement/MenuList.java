package librarymanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuList extends JFrame{
    JLabel L1=new JLabel("MENU LIST  ");
    JButton B1=new JButton("Borrow Books");
    JButton B2=new JButton("Return Books");
    JButton B3=new JButton("Logout");
    JButton B4=new JButton("Search By Book Id");
    JButton B5=new JButton("Search By Student ID");
    public MenuList(){
    JFrame J = new JFrame();
    setVisible(true);
    setTitle("Welcome To The Library Management System-Menu List (User ID- "+Login1.uid+")");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    this.setExtendedState(this.MAXIMIZED_BOTH);
    add(L1);add(B1);add(B2);add(B4);add(B5);add(B3);
    B3.addActionListener(new MBut3());
    B2.addActionListener(new MBut2());
    B1.addActionListener(new MBut1());
    B4.addActionListener(new MBut4());
    B5.addActionListener(new MBut5());
}
    class MBut1 implements ActionListener{
        public void actionPerformed(ActionEvent A){
            new librarymanagement.BorrowBooks();
            dispose();
        }
    }
    class MBut2 implements ActionListener{
        public void actionPerformed(ActionEvent A){
            new librarymanagement.ReturnBooks();
            dispose();
        }
    }
    class MBut3 implements ActionListener{
        public void actionPerformed(ActionEvent A){
            new librarymanagement.Login1();
            dispose();
        }
    }
    class MBut4 implements ActionListener{
        public void actionPerformed(ActionEvent A){
            new librarymanagement.BookSearch();
            dispose();
        }
    }
    class MBut5 implements ActionListener{
        public void actionPerformed(ActionEvent A){
            new librarymanagement.StudentSearch();
            dispose();
        }
    }
    
   
}
