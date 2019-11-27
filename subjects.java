package login_page;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class subjects extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					subjects frame = new subjects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 Connection connection= null;
 private JTextField textField;
	/**
	 * Create the frame.
	 */
	public subjects() {
		connection=sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddNewSubject = new JButton("Add new book");
		btnAddNewSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newbook nb = new newbook();
				nb.setVisible(true);
			}
		});
		btnAddNewSubject.setBounds(32, 226, 143, 23);
		contentPane.add(btnAddNewSubject);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	allfields all = new allfields();
			//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				subjects frame = new subjects();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//	all.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
				//	all.setVisible(true);
			//	all.setVisible(false);
				
			}
		});
		btnBack.setBounds(32, 274, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblChooseASubject = new JLabel("Choose a subject");
		lblChooseASubject.setBounds(32, 34, 134, 39);
		contentPane.add(lblChooseASubject);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(224, 107, 307, 231);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadButton = new JButton("Load Table");
		btnLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					   String query = "select * from add_book";
					   PreparedStatement pst=connection.prepareStatement(query);
					   ResultSet rs=pst.executeQuery();
					   table.setModel(DbUtils.resultSetToTableModel(rs));
				}
					 catch(Exception e1)  {
						 e1.printStackTrace();
					 }
			
			}
		});
		btnLoadButton.setBounds(32, 180, 115, 23);
		contentPane.add(btnLoadButton);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					  // String selection=(String)comboBox.getSelectedItem();
					   String query = "select BookID,BookName,Subject from add_book where Subject = ?";
					   System.out.println(query);
					   PreparedStatement pst=connection.prepareStatement(query);
					   pst.setString(1,textField.getText());
					   
					   ResultSet rs=pst.executeQuery();
					   table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e1)  {
					 e1.printStackTrace();
				 }
			
			}
		});
		textField.setBounds(224, 43, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}