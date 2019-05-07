package CSE201;

import java.util.ArrayList;

public class User {
	//hardcoding the credentials, later on we can use a text file or some database to retrieve the credentials
	
	private String username;
	private String password;
	private String realName;
	private boolean isAdmin;
	private ArrayList<ApplicationEntry> apps;
	//private Application[] wishlist;
	
	//Constructor
	public User(String u, String p, String name) {
		username = u;
		password = p;
		realName = name;
		isAdmin = true;
		apps = new ArrayList<>();
	}
	
	//Gives the username and password as a String
	public String toString() {
		return (username + password);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRealName() { return realName; }
	
	public boolean getAdmin() {
		return isAdmin;
	}
	
	public ArrayList<ApplicationEntry> getApps() {
		return apps;
	}


	public void write(User a) {
		this.username = a.getUsername();
		this.password = a.getPassword();
		this.realName = a.getRealName();
		this.apps = a.getApps();
	}
	
	
	
}
