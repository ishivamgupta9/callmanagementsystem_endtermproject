import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 563);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("call service");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 27));
		lblNewLabel.setBounds(232, 84, 185, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("You are");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(173, 236, 107, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Manager");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mlogin m=new mlogin();
				m.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(281, 212, 136, 21);
		contentPane.add(btnNewButton);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clogin c= new clogin();
				c.setVisible(true);
				dispose();
				setVisible(false);
				
			}
		});
		btnCustomer.setFont(new Font("Algerian", Font.PLAIN, 16));
		btnCustomer.setBackground(Color.ORANGE);
		btnCustomer.setForeground(Color.RED);
		btnCustomer.setBounds(281, 251, 136, 21);
		contentPane.add(btnCustomer);
	}
}
