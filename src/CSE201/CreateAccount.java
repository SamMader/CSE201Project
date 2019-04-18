package CSE201;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccount extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2562891490783120142L;
	private final JPanel contentPanel = new JPanel();
	private JTextField userField;
	private JPasswordField passwordField;
	
	private ArrayList<User> database = new ArrayList<>();
	private JTextField nameField;

	/**
	 * Create the dialog.
	 */
	public CreateAccount() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(12, 62, 269, 22);
		contentPanel.add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 131, 269, 22);
		contentPanel.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 33, 76, 16);
		contentPanel.add(lblUsername);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCreateAccount.setBounds(152, 13, 144, 22);
		contentPanel.add(lblCreateAccount);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 97, 56, 16);
		contentPanel.add(lblPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 166, 56, 16);
		contentPanel.add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(12, 195, 269, 22);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("CANCEL");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void getDB(ArrayList<User> a) {
		database = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if (cmd == "OK") {
			if (userField.getText().equalsIgnoreCase("") || passwordField.getPassword().toString().equalsIgnoreCase("") || nameField.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Please fill out all fields.");
			}
			else {
				String u = userField.getText();
				String p = new String(passwordField.getPassword());
				String n = nameField.getText();
				database.add(new User(u, p, n));
				dispose();
			}
		}
		else if (cmd == "CANCEL") {
			dispose();
		}
	}
}
