package CSE201;

public class User {
	//hardcoding the credentials, later on we can use a text file or some database to retrieve the credentials
	private String[] loginCreds = {"username password", "username1 password1"};	
	
	private boolean loggedIn = false;
	private String username;
	private String password;
	private String realName;
	//private Application[] apps;
	//private Application[] wishlist;
	
	//Constructor
	public User(String u, String p, String name) {
		username = u;
		password = p;
		realName = name;
	}
	
	//Login method
	public boolean login(String username, String password) {
		
		//Checks to see if username and password are in the "database".
		//For now the login credentials wil be "username" and "password" until the "database" is set up.
		if(verifyLoginCreds(username, password)) {
			this.username = username;
			this.password = password;
			loggedIn = true;
			
			System.out.println("Logging in as " + this.username + " " + this.password);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean logout() {
		this.username = null;
		this.password = null;
		loggedIn = false;
		System.out.println("Logged out as " + this.username + " " + this.password);
		return true;
	}
	
	//Create account method
	public boolean createAccount(String username, String password){
		//Gets the current size to calculate size of new array
		int currentSize = loginCreds.length;
	    int newSize = currentSize + 1;
	    String[] tempArray = new String[newSize];
	    //Adds strings from old array into new one
	    for (int i = 0; i < currentSize; i++)
	    {
	        tempArray[i] = loginCreds[i];
	    }
	    //adds the new username and password to the array
	    tempArray[newSize - 1] = username + " " + password;
	    loginCreds = tempArray;
	    
	    System.out.println("Created account " + username + " " + password);
	    return true;
	}
	
	//public boolean download(Application a){}
	//public boolean rate(Application a, double score){}
	//public boolean comment(Application a, String comment){}
	
	//Gives the username and password as a String
	public String toString() {
		return (username + password);
	}
	//Helper methods
	private boolean verifyLoginCreds(String username, String password) {
		//compares the username and pass with the credentials stored in loginCreds
		for(String s : loginCreds) {
			
			//Split each string into an array which lists the username and then the password
			String[] creds = s.split(" ");
			
			//if statement to compare
			if(username.equals(creds[0]) && password.equals(creds[1])) {
				return true;
			}else {
				//continue through loop if credentials dont match
				continue;
			}
		}
		//return false if nothing matches
		return false;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRealName() { return realName; }

	public void write(User a) {
		this.username = a.getUsername();
		this.password = a.getPassword();
		this.realName = a.getRealName();
	}
	
}
