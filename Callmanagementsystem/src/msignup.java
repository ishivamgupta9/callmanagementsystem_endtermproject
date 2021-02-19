



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class msignup extends JFrame {

	private JPanel contentPane;
	private JTextField first1;
	private JTextField last1;
	private JTextField user1;
	private JTextField Mobile;
	private JPasswordField password1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					msignup frame = new msignup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public msignup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 774);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP FORM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 17));
		lblNewLabel.setBounds(350, 79, 175, 57);
		contentPane.add(lblNewLabel);
		
		JLabel first = new JLabel("First Name");
		first.setForeground(Color.WHITE);
		first.setFont(new Font("Tahoma", Font.PLAIN, 15));
		first.setBounds(213, 198, 93, 29);
		contentPane.add(first);
		
		JLabel last = new JLabel("Last Name");
		last.setForeground(Color.WHITE);
		last.setFont(new Font("Tahoma", Font.PLAIN, 15));
		last.setBounds(213, 242, 93, 29);
		contentPane.add(last);
		
		JLabel user = new JLabel("User Name");
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user.setBounds(213, 293, 93, 29);
		contentPane.add(user);
		
		JLabel password = new JLabel("Password");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(213, 343, 93, 29);
		contentPane.add(password);
		
		first1 = new JTextField();
		first1.setBounds(389, 205, 96, 19);
		contentPane.add(first1);
		first1.setColumns(10);
		
		last1 = new JTextField();
		last1.setBounds(389, 249, 96, 19);
		contentPane.add(last1);
		last1.setColumns(10);
		
		user1 = new JTextField();
		user1.setBounds(389, 300, 96, 19);
		contentPane.add(user1);
		user1.setColumns(10);
		
		Mobile = new JTextField();
		Mobile.setBounds(389, 404, 96, 19);
		contentPane.add(Mobile);
		Mobile.setColumns(10);
		
		password1 = new JPasswordField();
		password1.setBounds(389, 350, 93, 19);
		contentPane.add(password1);
		
		
		JLabel mobile = new JLabel("Mobile no");
		mobile.setForeground(Color.WHITE);
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mobile.setBounds(213, 397, 93, 29);
		contentPane.add(mobile);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String first=first1.getText();
				String last=last1.getText();
				String user=user1.getText();
				String password=password1.getText();
				String mobile1=Mobile.getText();
				
				Connection con2;
				PreparedStatement insert;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/callsystem","root","");
					
					insert=con2.prepareStatement("insert into msignup(firstname,lastname,userid,password,mobileno)values(?,?,?,?,?)");
					insert.setString(1,first);
					insert.setString(2, last);
					insert.setString(3, user);
					insert.setString(4, password);
					insert.setString(5, mobile1);
					
					
					insert.executeUpdate();
					
					JOptionPane.showInternalMessageDialog(null,"Record added");
					
					first1.setText("");
					last1.setText("");
					user1.setText("");
					password1.setText("");
					Mobile.setText("");
					
					
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.BLUE);
		submit.setFont(new Font("Arial Black", Font.BOLD, 18));
		submit.setBounds(384, 483, 141, 29);
		contentPane.add(submit);
		
		
	}

}
