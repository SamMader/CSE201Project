package CSE201;

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
	private boolean loggedIn = false;
	private static int listPosition = 0;
	private static int genre = 0;
	private boolean inSearch = false;
	
	private static ArrayList<User> database = new ArrayList<>();
	private static Catalog appCatalog = new Catalog();
	private static Catalog subCatalog = new Catalog();
	
	JLabel lblName = new JLabel("");
	JButton btnLogout = new JButton("Logout");
	JButton btnLogin = new JButton("Login");
	JLabel lblTitle = new JLabel("Title");
	JButton buttonLeft = new JButton("<");
	JButton buttonRight = new JButton(">");
	JButton btnAdd = new JButton("Add");
	JLabel lblVarcategory = new JLabel("Top Apps");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		database.add(new User("Test", "abc", "Sam"));
		
		appCatalog.add("Hello World", "Sam", 1, 0, 0);
		appCatalog.add("Test 2", "Sam", 2, 0, 0);
		appCatalog.add("Test 3", "Sam", 2, 0, 0);
		
		//populates appCatalog with the data from applications.txt
		FileManager.loadAppData("applications.txt", appCatalog);

		
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
		btnTopApps.setActionCommand("TOPAPPS");
		btnTopApps.addActionListener(this);
		contentPane.add(btnTopApps);
		
		JButton btnRpg = new JButton("RPG");
		btnRpg.setBounds(0, 60, 91, 25);
		btnRpg.setActionCommand("RPG");
		btnRpg.addActionListener(this);
		contentPane.add(btnRpg);
		
		JButton btnStrategy = new JButton("Strategy");
		btnStrategy.setBounds(0, 87, 91, 25);
		btnStrategy.setActionCommand("STRATEGY");
		btnStrategy.addActionListener(this);
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
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Search");
		txtSearch.setBounds(0, 173, 116, 22);
		txtSearch.setActionCommand("SEARCH");
		txtSearch.addActionListener(this);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		lblVarcategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVarcategory.setBounds(265, 4, 111, 30);
		contentPane.add(lblVarcategory);
		
		lblName.setBounds(77, 299, 56, 16);
		lblName.setText(name);
		contentPane.add(lblName);
		
		buttonLeft.setBounds(265, 335, 41, 25);
		buttonLeft.addActionListener(this);
		buttonLeft.setActionCommand("LEFT");
		contentPane.add(buttonLeft);
		
		buttonRight.setBounds(335, 335, 41, 25);
		buttonRight.addActionListener(this);
		buttonRight.setActionCommand("RIGHT");
		contentPane.add(buttonRight);
		
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblTitle.setBounds(216, 56, 200, 29);
		contentPane.add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(456, 118, 131, 137);
		contentPane.add(scrollPane);
		
		JLabel lblDescription = new JLabel("Description");
		scrollPane.setViewportView(lblDescription);
		
		JLabel lblRating = new JLabel("0");
		lblRating.setBounds(456, 96, 56, 16);
		contentPane.add(lblRating);
		
		JLabel lblOutOf = new JLabel("out of 5");
		lblOutOf.setBounds(468, 96, 56, 16);
		contentPane.add(lblOutOf);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(216, 87, 200, 200);
		contentPane.add(lblImage);
		
		btnAdd.setBounds(284, 295, 66, 25);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(0, 195, 66, 25);
		btnClear.addActionListener(this);
		btnClear.setActionCommand("CLEAR");
		contentPane.add(btnClear);
		
		displayUpdate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Button commands sent from action listener
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
				btnAdd.setVisible(true);
			}
		}
		else if (cmd == "LOGOUT") {
			currentUser = new User(null,null,null);
			lblName.setText("N/A");
			btnLogout.setVisible(false);
			btnLogin.setVisible(true);
			displayUpdate();
		}
		else if (cmd == "LEFT") {
			listPosition--;
			displayUpdate();
		}
		else if (cmd == "RIGHT") {
			listPosition++;
			displayUpdate();
		}
		else if (cmd == "SEARCH") {
			displayUpdate();
		}
		else if (cmd == "CLEAR") {
			txtSearch.setText("");
			displayUpdate();
		}
		else if (cmd == "TOPAPPS") {
			genre = 0;
			displayUpdate();
		}
		else if (cmd == "RPG") {
			genre = 1;
			displayUpdate();
		}
		else if (cmd == "STRATEGY") {
			genre = 2;
			lblVarcategory.setText("Strategy");
			displayUpdate();
		}
	}
	
	private void displayUpdate() {
		// If searching
		if(!txtSearch.getText().equalsIgnoreCase("")) {
			subCatalog.clear();
			for (int x = 0; x < appCatalog.getNumEntries(); x++) {
				if (appCatalog.get(x).getName().contains(txtSearch.getText()) && (appCatalog.get(x).getGenre() == genre || genre == 0)) {
					subCatalog.copy(appCatalog, x);
				}
			}
			if (subCatalog.getNumEntries() == 0) {
				JOptionPane.showMessageDialog(this, "Search returned no results, clearing.");
				txtSearch.setText("");
				for (int x = 0; x < appCatalog.getNumEntries(); x++) {
					subCatalog.copy(appCatalog, x);
				}
			}
			if (!inSearch) {
				listPosition = 0;
				inSearch = true;
			}
		}
		// Initialization if
		else if (subCatalog.getNumEntries() == 0){
			for (int x = 0; x < appCatalog.getNumEntries(); x++) {
				if (appCatalog.get(x).getGenre() == genre || genre == 0) {
					subCatalog.copy(appCatalog, x);
				}
			}
			if (inSearch) {
				inSearch = false;
				listPosition = 0;
			}
		}
		// Cleared search if
		else if (inSearch) {
			subCatalog.clear();
			for (int x = 0; x < appCatalog.getNumEntries(); x++) {
				if (appCatalog.get(x).getGenre() == genre || genre == 0) {
					subCatalog.copy(appCatalog, x);
				}
			}
			if (inSearch) {
				inSearch = false;
				listPosition = 0;
			}
		}
		else {
			subCatalog.clear();
			for (int x = 0; x < appCatalog.getNumEntries(); x++) {
				if (appCatalog.get(x).getGenre() == genre || genre == 0) {
					subCatalog.copy(appCatalog, x);
				}
			}
		}
		// Getting App Data and setting buttons
		ApplicationEntry a = subCatalog.get(listPosition);
		lblTitle.setText(a.getName());
		if (listPosition + 1 >= subCatalog.getNumEntries()) {
			buttonRight.setVisible(false);
		}
		else if (!buttonRight.isVisible()) {
			buttonRight.setVisible(true);
		}
		if (listPosition - 1 < 0) {
			buttonLeft.setVisible(false);
		}
		else if (!buttonLeft.isVisible()) {
			buttonLeft.setVisible(true);
		}
		
		if (!loggedIn) {
			btnAdd.setVisible(false);
		}
		else {
			btnAdd.setVisible(true);
		}
	}
}
