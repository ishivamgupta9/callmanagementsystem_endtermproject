import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customermenu extends JFrame {

	private JPanel contentPane;
	private LayoutManager absolute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customermenu frame = new customermenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param user 
	 */
	public static String user1 ;
	private JTable table;
	private JTextField recharge;
	customermenu(String user) {
		 user1=user;
		
		
			
	}
	public customermenu() throws Throwable {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 745, 840);
			contentPane = new JPanel();
			setResizable(false);
			setVisible(true);
			contentPane.setBackground(Color.PINK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
		getContentPane().setLayout(absolute);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 680, 245);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Your mobile", "Prepaid/Postpaid", "call total time", "call balance", "Next Recharge Date", "Due Amount"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(101);
		table.getColumnModel().getColumn(4).setPreferredWidth(113);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 0, 0);
		getContentPane().add(lblNewLabel);
		
		JLabel lbl = new JLabel(user1);
		lbl.setForeground(Color.DARK_GRAY);
		lbl.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 20));
		lbl.setBounds(329, 38, 86, 29);
		getContentPane().add(lbl);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(329, 10, 114, 29);
		contentPane.add(lblNewLabel_1);
		
		recharge = new JTextField();
		recharge.setBounds(214, 407, 96, 19);
		contentPane.add(recharge);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Amount");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(115, 395, 100, 36);
		contentPane.add(lblNewLabel_2);
		
		JButton btnRecharge = new JButton("Recharge");
		btnRecharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				PreparedStatement p;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/callsystem","root","");
				     
				     p=con.prepareStatement("select * from details WHERE userid=?");//to do me jo v hai usse laa na hai
					 p.setString(1, user1);
					ResultSet rs=p.executeQuery();
					
					String rech=recharge.getText();
					
					while(rs.next()) {
					
					
					int da=Integer.parseInt(rs.getString("dueamount"));
					int rech1=Integer.parseInt(rech);
					int due=da-rech1;
					
					String dueamt=String.valueOf(due);
					
					
					
					
					
					
					
					p=con.prepareStatement("update details set dueamount=? where userid=?");//means yaha pe id as a input jaa rahi hai uske basis pe important and other ka data update hoga
					
					p.setString(1, dueamt);
					p.setString(2,user1);
					
					p.executeUpdate();
					JOptionPane.showMessageDialog(null,"Recharge done");
				     
				     
					}
				     
				     
				     
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnRecharge.setBounds(356, 406, 120, 21);
		contentPane.add(btnRecharge);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 0, 0);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clogin c= new clogin();
				c.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(526, 406, 110, 21);
		contentPane.add(btnNewButton_1);
		
	
		
		
		PreparedStatement insert;
		Connection con2;
		try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
			
			con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/callsystem","root","");
			     
			     int a;
			insert=con2.prepareStatement("select * from details WHERE userid=?");//to do me jo v hai usse laa na hai
			 insert.setString(1, user1);
			ResultSet rs=insert.executeQuery();//jo v insert me aaya aur execute hua usse rs me laana hai
			ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData();//pura information mil jaata h colun kaa table me
			a=rd.getColumnCount();//coloun count 
			DefaultTableModel df=(DefaultTableModel) table.getModel();//khaali  insert.setString(1, user);table ye humesha jaruri hota hai table jo humne create kiyaa hai eclipse me
			df.setRowCount(0);//o se start krnaa hai row count
			
	
			
			while(rs.next()) {
				
				Vector v=new Vector(); 
		         
				
				
				v.add(rs.getString("customermobile"));
				v.add(rs.getString("simtype"));
				v.add(rs.getString("calltime"));
				v.add(rs.getString("balance"));
				v.add(rs.getString("rechargedate"));
				v.add(rs.getString("dueamount"));
					
				df.addRow(v);
			}
			}
			 catch (SQLException e1) {
				// infopage Auto-generated catch block
				e1.printStackTrace();
					
					
				
				
				
				
			 }}
		}
				
				
		
		    	
		    	
		  	
		  	//new customerinfopage(user).setVisible(true);;
		  	
		  	
		  	
		  	
		
		    
		
			
	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
	
