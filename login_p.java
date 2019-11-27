package login_page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
public class login_p {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField password;
	protected JLabel txtPassword;
	protected JLabel txtUsername;
	protected JLabel name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_p window = new login_p();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    Connection connection=null;
	/**
	 * Create the application.
	 */
	public login_p() {
		initialize();
		connection=sqliteconnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 559, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login page");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setBounds(179, 21, 92, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 80, 81, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(21, 146, 81, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(158, 75, 113, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(158, 141, 119, 19);
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from login where username=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,password.getText());
					ResultSet rs = pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count = count + 1;
					}
					if(count==1) {
						JOptionPane.showMessageDialog(null,"credentials matched");
						//creating object
						allfields all = new allfields();
						all.setVisible(true);
						frame.setVisible(false);
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null,"Duplicate credentials");
					}
					else {
						JOptionPane.showMessageDialog(null,"invalid try again");
						rs.close();
						pst.close();
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
			}
				
		});
		Image img1  = new ImageIcon(this.getClass().getResource("/ooo.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNewButton.setBounds(46, 215, 113, 21);
		
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFrame frmLoginSystem = new JFrame("exit");
			    if(JOptionPane.showConfirmDialog(frmLoginSystem,"confirm if u want to exit","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
			    	System.exit(0);
			    }
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNewButton_1.setBounds(348, 215, 103, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 192, 505, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(80, 32, -131, 36);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(324, 51, 161, -109);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 51, 1, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(21, 51, 505, 2);
		frame.getContentPane().add(separator_4);
		
		JLabel label = new JLabel("");
		Image img  = new ImageIcon(this.getClass().getResource("/l.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(347, 70, 161, 109);
		frame.getContentPane().add(label);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				password.setText("");
			}
		});
		btnReset.setBounds(193, 212, 97, 25);
		frame.getContentPane().add(btnReset);
		
		
	}
}
