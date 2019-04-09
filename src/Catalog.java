
public class Catalog {

	/*
	 * To-do
	 * 
	 * Pretty much the whole thing
	 * 
	 * add, remove, get, clear
	 * 
	 * sort
	 * 
	 */

	// inner node class
	private class ApplicationEntry {

		String name, author;
		Genre genre;
		double price;
		int downloads;

		// ctors

		public ApplicationEntry(String name, String author, Genre genre) {
			this.name = name;
			this.author = author;
			this.genre = genre;

			// default to new, free application (downloads and price are both zero)
			this.price = 0.0;
			this.downloads = 0;
		}

		public ApplicationEntry(String name, String author, Genre genre, double price) {
			this(name, author, genre);
			this.price = price;

			// default to new application (no downloads)
			this.downloads = 0;
		}

		public ApplicationEntry(String name, String author, Genre genre, double price, int downloads) {
			this(name, author, genre, price);
			this.downloads = downloads;
		}

		// compareTo's for each field

		// basic compareTo by name then author, then genre, price, and downloads
		// respectively
		public int compareTo(ApplicationEntry a) {
			int comparison = this.name.compareTo(a.name);

			if (comparison == 0) {
				comparison = this.author.compareTo(a.author);
				if (comparison == 0) {
					comparison = this.genre.compareTo(a.genre);
					if (comparison == 0) {
						comparison = Double.compare(this.price, a.price);
						if (comparison == 0) {
							comparison = Integer.compare(this.downloads, a.downloads);
						}
					}
				}
			}
			return comparison;
		}

		public boolean equals(Object o) {
			if (o instanceof ApplicationEntry) {
				ApplicationEntry a = (ApplicationEntry) o;
				return this.name.equals(a.name) && this.author.equals(a.author) && this.genre == a.genre
						&& this.price == a.price && this.downloads == a.downloads;
			}
			return false;
		}

		/*
		 * To-do
		 * 
		 * getGenre, other compareTos?, equals
		 * 
		 */

	}

}
