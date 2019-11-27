package login_page;

import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class issuebook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issuebook frame = new issuebook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField textField_5;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public issuebook() {
		connection=sqliteconnection.dbConnector(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(63, 57, 49, 14);
		contentPane.add(lblBookId);
		
		textField = new JTextField();
		textField.setBounds(196, 54, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(63, 109, 49, 14);
		contentPane.add(lblSubject);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 106, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(63, 167, 77, 14);
		contentPane.add(lblBookName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 164, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Student USN");
		lblAuthor.setBounds(63, 217, 77, 14);
		contentPane.add(lblAuthor);
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 214, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setBounds(63, 271, 77, 14);
		contentPane.add(lblIssueDate);
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setBounds(63, 321, 77, 14);
		contentPane.add(lblReturnDate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allfields all = new allfields();
				all.setVisible(true);
				
			}
		});
		btnBack.setBounds(124, 364, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblIssueBookDetails = new JLabel("Issue Book Details");
		lblIssueBookDetails.setBounds(147, 11, 101, 20);
		contentPane.add(lblIssueBookDetails);
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into issue_book(ID,Subject,Name,Usn,Issue_Date,Return_Date) values (?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText());
					pst.setString(5,textField_4.getText());
					pst.setString(6,textField_5.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Book Issued");
					
					pst.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(275, 364, 89, 23);
		contentPane.add(btnSave);
		
		textField_5 = new JTextField();
		textField_5.setBounds(176, 317, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(176, 267, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}