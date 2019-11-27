package login_page;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;

public class stats extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stats frame = new stats();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection= null;
	/**
	 * Create the frame.
	 */
	public stats() {
		connection=sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allfields all = new allfields();
				all.setVisible(true);
				
				
			}
		});
		btnBack.setBounds(147, 618, 89, 23);
		contentPane.add(btnBack);
		
		table = new JTable();
		table.setBounds(43, 34, 631, 265);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(43, 341, 631, 264);
		contentPane.add(table_1);
		
		JLabel lblBooksIssued = new JLabel("Books Issued");
		lblBooksIssued.setBounds(43, 13, 97, 16);
		contentPane.add(lblBooksIssued);
		
		JLabel lblBooksReturned = new JLabel("Books Returned");
		lblBooksReturned.setBounds(43, 312, 104, 16);
		contentPane.add(lblBooksReturned);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					   String query = "select * from issue_book";
					   PreparedStatement pst=connection.prepareStatement(query);
					   ResultSet rs=pst.executeQuery();
					   table.setModel(DbUtils.resultSetToTableModel(rs));
				}
					 catch(Exception e1)  {
						 e1.printStackTrace();
					 }
				
				try {
					   String query = "select * from return_book";
					   PreparedStatement pst=connection.prepareStatement(query);
					   ResultSet rs=pst.executeQuery();
					   table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}
					 catch(Exception e1)  {
						 e1.printStackTrace();
					 }
			}
		});
		btnShow.setBounds(320, 617, 97, 25);
		contentPane.add(btnShow);
	}
}