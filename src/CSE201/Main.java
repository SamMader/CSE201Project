package CSE201;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;

	private User currentUser = new User(null, null, null);
	
	private String name = "N/A";
	
	private static ArrayList<User> database = new ArrayList<>();
	
	JLabel lblName = new JLabel("");
	JButton btnLogout = new JButton("Logout");
	JButton btnLogin = new JButton("Login");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		database.add(new User("Test", "abc", "Sam"));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblFilters.setBounds(0, 0, 80, 30);
		contentPane.add(lblFilters);
		
		JButton btnTopApps = new JButton("Top Apps");
		btnTopApps.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTopApps.setBounds(0, 32, 91, 25);
		contentPane.add(btnTopApps);
		
		JButton btnRpg = new JButton("RPG");
		btnRpg.setBounds(0, 60, 91, 25);
		contentPane.add(btnRpg);
		
		JButton btnStrategy = new JButton("Strategy");
		btnStrategy.setBounds(0, 87, 91, 25);
		contentPane.add(btnStrategy);
		
		JButton btnFps = new JButton("FPS");
		btnFps.setBounds(0, 114, 91, 25);
		contentPane.add(btnFps);
		
		JButton btnPuzzle = new JButton("Puzzle");
		btnPuzzle.setBounds(0, 142, 91, 25);
		contentPane.add(btnPuzzle);
		
		btnLogin.setBounds(0, 319, 80, 25);
		btnLogin.setActionCommand("LOGIN");
		btnLogin.addActionListener(this);
		contentPane.add(btnLogin);
		
		btnLogout.setVisible(false);
		btnLogout.setBounds(0, 348, 80, 25);
		btnLogout.setActionCommand("LOGOUT");
		btnLogout.addActionListener(this);
		contentPane.add(btnLogout);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as");
		lblLoggedInAs.setBounds(0, 299, 111, 16);
		contentPane.add(lblLoggedInAs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 59, 476, 285);
		contentPane.add(scrollPane);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(0, 173, 116, 22);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblVarcategory = new JLabel("var_Category");
		lblVarcategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVarcategory.setBounds(299, 4, 111, 30);
		contentPane.add(lblVarcategory);
		
		lblName.setBounds(77, 299, 56, 16);
		lblName.setText(name);
		contentPane.add(lblName);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if (cmd == "LOGIN") {
			Login a = new Login();
			a.getUser(currentUser);
			a.getDB(database);
			a.setModal(true);
			a.setVisible(true);
			if (currentUser.getUsername() != null) {
				name = currentUser.getRealName();
				lblName.setText(name);
				btnLogin.setVisible(false);
				btnLogout.setVisible(true);
			}
		}
		else if (cmd == "LOGOUT") {
			currentUser = new User(null,null,null);
			lblName.setText("N/A");
			btnLogout.setVisible(false);
			btnLogin.setVisible(true);
		}
	}
}
