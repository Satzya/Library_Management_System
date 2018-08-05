package librarymanagement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
public class StudentSearch extends JFrame{
    String[] columnNames = {"Book ID", "Book Name", "Student ID"};
    String from;
    JComboBox C1;
    JLabel L0=new JLabel("Please specify valid details       ");
    JLabel L1=new JLabel("Search by Student ID: ");
    JTextField T1=new JTextField(10);
    JButton B1=new JButton("Search");
    JButton B2=new JButton("Cancel");
    
    public StudentSearch(){
        JFrame J = new JFrame();
        setTitle("Welcome To The Library Management System-Search Entries (User ID- "+Login1.uid+")");
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Vector<String> V=new Vector<String>();
        B1.addActionListener(new SS1());
        B2.addActionListener(new SS2());
        try{
            
                Login1.st=Login1.Con.createStatement();
                Login1.P=Login1.Con.prepareCall("select stroll from Books");
                Login1.Rs=Login1.P.executeQuery();
                
                while(Login1.Rs.next()){
                V.add(Login1.Rs.getString(1));
                }
                
                C1=new JComboBox(V);
                add(L0);add(L1);add(C1);add(B1);add(B2);
            }
                catch(Exception E){
                    JOptionPane.showMessageDialog(null, "Invalid ID");
                }
    }
    
    
            class SS2 implements ActionListener{
        
            public void actionPerformed(ActionEvent A){
                new librarymanagement.MenuList();
                dispose();
            
        }}
    
        class SS1 implements ActionListener{
        public void actionPerformed(ActionEvent A){
            if(A.getSource()==B1){
                showTableData();
            }
        }
    }
    
    public void showTableData(){
        JFrame J1 = new JFrame("Database Search Result");
        J1.setExtendedState(J1.MAXIMIZED_BOTH);
     DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable Table = new JTable();
        Table.setModel(model);
        Table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(Table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        from = (String)C1.getSelectedItem();
        
        String BID = "";
        String  Bname= "";
        String SRoll = "";
        try{
            
                Login1.st=Login1.Con.createStatement();
                Login1.P=Login1.Con.prepareCall("select * from Books where stroll='"+from+"'");
                Login1.Rs=Login1.P.executeQuery();
                int i=0;
                while(Login1.Rs.next()){
                    BID=Login1.Rs.getString(1);
                    Bname=Login1.Rs.getString(2);
                    SRoll=Login1.Rs.getString(3);
                     model.addRow(new Object[]{BID, Bname, SRoll });
                     i++;
                }
                 if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        J1.add(scroll);
        J1.setVisible(true);
        J1.setLayout(new FlowLayout());
        }
                
    
}
