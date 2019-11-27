package login_page;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;


public class returnbook extends JFrame {
	Connection conn;
    ResultSet rs;
    PreparedStatement pst;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnbook frame = new returnbook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	 public void search(){
	        String a1=textField_1.getText();
	        String sql = "Select ID,Return_Date from issue_book where Usn='" +a1+ "'";
	        try{
	            pst=connection.prepareStatement(sql);
	            rs=pst.executeQuery();
	            if(rs.next()){
		        	textField.setText(rs.getString(1));
		        	textField_2.setText(rs.getString(2));
		        	 rs.close();
			         pst.close();
			         JOptionPane.showMessageDialog(null,"usn matched");
		        }
	        else{
	            JOptionPane.showMessageDialog(null,"Incorrect Usn");
	        }
	        }catch(Exception e){
	            JOptionPane.showMessageDialog(null,e);
	            e.printStackTrace();
	        }
	    }
	
	
	
	
	
	
	public returnbook() {
		connection=sqliteconnection.dbConnector(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setBounds(66, 115, 70, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(202, 112, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student USN");
		lblNewLabel_1.setBounds(56, 44, 80, 39);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 53, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Due Date");
		lblNewLabel_2.setBounds(67, 180, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date of return");
		lblNewLabel_3.setBounds(67, 238, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allfields all = new allfields();
				all.setVisible(true);
			}
		});
		btnBack.setBounds(137, 303, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblReturnBookDetails = new JLabel("Return book details");
		lblReturnBookDetails.setBounds(147, 11, 118, 26);
		contentPane.add(lblReturnBookDetails);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into return_book(ID,USN,Due_Date,Return_Date) values (?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText());
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Book Returned");
					
					pst.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
			

	}



				
			}
		});
		btnReturn.setBounds(253, 302, 97, 25);
		contentPane.add(btnReturn);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				search();
				
				
			}
		});
		btnSearch.setBounds(308, 53, 85, 21);
		contentPane.add(btnSearch);
		
		textField_2 = new JTextField();
		textField_2.setBounds(182, 176, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(182, 234, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}