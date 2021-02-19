



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class mlogin extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mlogin frame = new mlogin();
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
	public mlogin() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lf = new JLabel("Manager Login Form");
		lf.setHorizontalAlignment(SwingConstants.CENTER);
		lf.setFont(new Font("Tahoma", Font.BOLD, 18));
		lf.setForeground(Color.DARK_GRAY);
		lf.setBounds(224, 65, 202, 51);
		contentPane.add(lf);
		
		JLabel id1 = new JLabel("User ID");
		id1.setFont(new Font("Tahoma", Font.BOLD, 16));
		id1.setBounds(126, 169, 89, 19);
		contentPane.add(id1);
		
		JLabel pas = new JLabel("Password");
		pas.setFont(new Font("Tahoma", Font.BOLD, 16));
		pas.setBounds(126, 237, 89, 19);
		contentPane.add(pas);
		
		id = new JTextField();
		id.setBounds(291, 171, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(291, 239, 96, 19);
		contentPane.add(pass);
		
		JButton mlogin = new JButton("login");
		mlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con2;
				PreparedStatement insert;
				try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
					
					con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/callsystem","root","");
					
					
					
					String user=id.getText();
				    String pwd=pass.getText();	
				    insert=con2.prepareStatement("select*from msignup where userid=? and password=?");
				    
				    insert.setString(1, user);
				    insert.setString(2, pwd);
				    
				    
				    ResultSet r=insert.executeQuery();
				    
				    if(r.next()) {
				   	ManagerMenu s=new ManagerMenu();
				  	s.setVisible(true);
				  	dispose();
				  	setVisible(false);
				  	
				  	
				   }
				    else {
				    	JOptionPane.showMessageDialog(null,"Wrong UserID or Password");
				    }
				    
				
				
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		mlogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		mlogin.setBounds(270, 349, 89, 25);
		contentPane.add(mlogin);
		
		JButton btnHomeMenu = new JButton("<-");
		btnHomeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homepage c= new homepage();
				c.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		btnHomeMenu.setBackground(Color.WHITE);
		btnHomeMenu.setForeground(Color.BLUE);
		btnHomeMenu.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnHomeMenu.setBounds(10, 10, 76, 25);
		contentPane.add(btnHomeMenu);
	}

}
