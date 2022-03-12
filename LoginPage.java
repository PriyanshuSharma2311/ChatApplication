import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField Pincode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void register() {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(textField.getText());
		userDTO.setPassword(passwordField.getPassword());
		userDTO.setPincode(Pincode.getText());
		try {
			String result = userDAO.register(userDTO);
			JOptionPane.showMessageDialog(this, result);
		} catch (ClassNotFoundException e) {
			System.out.println("Server Error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Server Error");
		}
		
	}
	private UserDAO userDAO = new UserDAO();
	private void doLogin() {
		JFrame f=new JFrame();
		String userid = textField.getText();
		char[] password =passwordField.getPassword();
		UserDTO userDTO =new UserDTO(userid, password);
		userDTO.setPincode(Pincode.getText());
		
		try {
			String result = userDAO.doLogin(userDTO);
			if(result.contains("Welcome"))
			{
				JOptionPane.showMessageDialog(this, result);
				Dashboard dashBoard = new Dashboard();
				dashBoard.setVisible(true);
				this.setVisible(false);
			}
			else
			{

				JOptionPane.showMessageDialog(f,"Invalid ID or Password");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Server Error");
		} catch (SQLException e) {
			System.out.println("Server Error");
		}
		
	}
	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(233, 38, 144, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserId");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(112, 38, 48, 20);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(233, 79, 144, 26);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(105, 83, 92, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton LoginBTN = new JButton("Login");
		LoginBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		LoginBTN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LoginBTN.setBounds(112, 193, 85, 21);
		contentPane.add(LoginBTN);
		
		JButton RegisterBTN = new JButton("Register");
		RegisterBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		RegisterBTN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RegisterBTN.setBounds(264, 193, 111, 21);
		contentPane.add(RegisterBTN);
		
		Pincode = new JTextField();
		Pincode.setFont(new Font("Tahoma", Font.BOLD, 15));
		Pincode.setBounds(233, 124, 144, 26);
		contentPane.add(Pincode);
		Pincode.setColumns(10);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPincode.setBounds(112, 130, 85, 20);
		contentPane.add(lblPincode);
	}
}
