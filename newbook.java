package login_page;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.*;


public class newbook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newbook frame = new newbook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;


	/**
	 * Create the frame.
	 */
	
	 
	public newbook() {
		connection=sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(194, 44, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(55, 47, 49, 14);
		contentPane.add(lblBookId);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(55, 113, 89, 17);
		contentPane.add(lblBookName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 110, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(55, 173, 49, 35);
		contentPane.add(lblSubject);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 180, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjects sub = new subjects();
				sub.setVisible(true);
		}
		});

		btnBack.setBounds(126, 229, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewBookDetails = new JLabel("New book details");
		lblNewBookDetails.setBounds(140, 11, 107, 22);
		contentPane.add(lblNewBookDetails);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into add_book(BookID,BookName,Subject) values (?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(250, 228, 97, 25);
		contentPane.add(btnNewButton);
	}
}