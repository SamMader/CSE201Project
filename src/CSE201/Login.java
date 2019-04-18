package CSE201;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Login extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField pwdPassword;
	
	private User currentUser;
	private ArrayList<User> database = new ArrayList<>();

	/**
	 * Create the frame.
	 */
	public Login() {
		this.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
		this.setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogin.setBounds(110, 0, 99, 43);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(86, 69, 116, 22);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(86, 120, 116, 22);
		contentPane.add(pwdPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(96, 154, 97, 25);
		btnLogin.setActionCommand("LOGIN");
		btnLogin.addActionListener(this);
		contentPane.add(btnLogin);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(73, 192, 136, 25);
		btnCreateAccount.setActionCommand("CREATE");
		btnCreateAccount.addActionListener(this);
		contentPane.add(btnCreateAccount);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(110, 52, 72, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(110, 104, 56, 16);
		contentPane.add(lblPassword);
	}
	// Get currentUser from Main
	public void getUser(User a) {
		currentUser = a;
	}
	// Get user database from Main
	public void getDB(ArrayList<User> a) {
		database = a;
	}
	
	// Button action method
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (txtLogin.getText() == null || pwdPassword.getPassword() == null) {
			JOptionPane.showMessageDialog(this, "Incorrect username or password. Please try again.");
		}
		String u = txtLogin.getText();
		String p = new String(pwdPassword.getPassword());
		String cmd = e.getActionCommand();
		boolean foundUser = false;
		if (cmd == "LOGIN") {
			for (User a: database) {
				if (a.getUsername().equals(u) && a.getPassword().equals(p)) {
					currentUser.write(a);
					foundUser = true;
					dispose();
				}
			}
			if (!foundUser) {
				JOptionPane.showMessageDialog(this, "Incorrect username or password. Please try again.");
			}
		}
		else if (cmd == "CREATE") {
			CreateAccount a = new CreateAccount();
			a.getDB(database);
			a.setModal(true);
			a.setVisible(true);
		}
		
	}
}
