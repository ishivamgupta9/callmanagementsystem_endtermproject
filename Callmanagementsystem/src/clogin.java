



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
import javax.swing.JFormattedTextField;

public class clogin extends JFrame {

	
	public JPanel contentPane;
	public JTextField id;
	private JPasswordField pass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clogin frame = new clogin();
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
	public clogin() {
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lf = new JLabel("Customer Login Form");
		lf.setHorizontalAlignment(SwingConstants.CENTER);
		lf.setFont(new Font("Tahoma", Font.BOLD, 18));
		lf.setForeground(Color.DARK_GRAY);
		lf.setBounds(194, 68, 207, 51);
		contentPane.add(lf);
		
		JLabel id1 = new JLabel("User Id");
		id1.setFont(new Font("Tahoma", Font.BOLD, 16));
		id1.setBounds(114, 169, 123, 19);
		contentPane.add(id1);
		
		JLabel pas = new JLabel("Password");
		pas.setFont(new Font("Tahoma", Font.BOLD, 16));
		pas.setBounds(114, 237, 89, 19);
		contentPane.add(pas);
		
		id = new JTextField();
		id.setBounds(291, 171, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(291, 239, 96, 19);
		contentPane.add(pass);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(316, 395, 7, 19);
		contentPane.add(formattedTextField);
		
		String cn = null;
		
		
		JButton clogin = new JButton("Login");
		clogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con2;
				PreparedStatement insert;
				try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
					
					con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/callsystem","root","");
					
					
					
			        String user=id.getText();
				    String pwd=pass.getText();	
				    
					
				    insert=con2.prepareStatement("select * from details where userid=? and customerpassword=?");
				    
				    
				    
				    insert.setString(1, user);
				    insert.setString(2, pwd);
				  
				    
				   
				
				 ResultSet r=insert.executeQuery();
				       new customermenu(user);
				      if(r.next()) {
				    	  
				    	  
				    	  
				    	
				    	
				    	customermenu c=new customermenu();
				    	c.setVisible(true);
				    	dispose();
				    	setVisible(false);
				  
				  	
				  	//new customerinfopage(user).setVisible(true);;
				  	
				  	
				  	
				  	
				  	
				   }
				    else {
				    	JOptionPane.showMessageDialog(null,"Wrong UserID or Password");
				    }
				    
				
				
				}
				catch(Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}

			
			
			
			
			
			
		});
		clogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		clogin.setBounds(270, 349, 89, 25);
		contentPane.add(clogin);
		
		JLabel lblNewLabel = new JLabel(" if you dont know your User Id and password then contact your manager.");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Stencil", Font.ITALIC, 9));
		lblNewLabel.setBounds(108, 279, 751, 60);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage c= new homepage();
				c.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.BOLD, 22));
		button.setBackground(Color.WHITE);
		button.setBounds(21, 10, 76, 25);
		contentPane.add(button);
		
		
	}
}
