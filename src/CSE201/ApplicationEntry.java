package CSE201;
/***/

public class ApplicationEntry implements Comparable<ApplicationEntry> {

	String name, author;
	double price;
	int downloads, genre;

	// ctors

	/***/

	public ApplicationEntry(String name, String author) {
		this.name = name;
		this.author = author;
	}

	/***/

	public ApplicationEntry(String name, String author, int genre) {
		this(name, author);
		this.genre = genre;

		// default to new, free application (downloads and price are both zero)
		this.price = 0.0;
		this.downloads = 0;
	}

	/***/

	public ApplicationEntry(String name, String author, int genre, double price) {
		this(name, author, genre);
		this.price = price;

		// default to new application (no downloads)
		this.downloads = 0;
	}

	/***/

	public ApplicationEntry(String name, String author, int genre, double price, int downloads) {
		this(name, author, genre, price);
		this.downloads = downloads;
	}

	/***/

	// basic compareTo by name then author
	public int compareTo(ApplicationEntry a) {
		int comparison = this.name.compareTo(a.name);

		if (comparison == 0) {
			comparison = this.author.compareTo(a.author);

		}
		return comparison;
	}

	/***/

	public boolean equals(Object o) {
		if (o instanceof ApplicationEntry) {
			ApplicationEntry a = (ApplicationEntry) o;
			return this.name.equals(a.name) && this.author.equals(a.author);
		}
		return false;
	}

	public String toString() {
		return "[ Name: " + this.name + "\t\t Author: " + this.author + "\t\t Genre " + this.genre + "\t\t Price $" + this.price
				+ "\t\t Downloads " + this.downloads + " ]";
	}

	// getters

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getGenre() {
		return genre;
	}

	public double getPrice() {
		return price;
	}

	public int getDownloads() {
		return downloads;
	}

}
