package CSE201;

import java.util.ArrayList;
import java.util.Collections;

/***/

public class Catalog {

	private static final int DEFAULT_CAPACITY = 50;

	private ArrayList<ApplicationEntry> catalog;
	private int numEntries;

	/***/

	public Catalog() {
		this.catalog = new ArrayList<ApplicationEntry>(DEFAULT_CAPACITY);
		this.numEntries = 0;
	}

	/***/

	public ApplicationEntry add(String name, String author, int genre, double price, int downloads) {
		ApplicationEntry a = new ApplicationEntry(name, author, genre, price, downloads);

		this.catalog.add(a);
		this.numEntries++;
		return a;
	}

	/***/

	public void remove(int x) {
		this.catalog.remove(x);
		this.numEntries--;
	}

	/***/

	public ApplicationEntry get(int index) {
		return this.catalog.get(index);
	}

	/***/

	public void clear() {
		this.catalog = new ArrayList<ApplicationEntry>(DEFAULT_CAPACITY);
		this.numEntries = 0;
	}

	/***/

	public int getNumEntries() {
		return this.numEntries;
	}

	/***/

	public boolean isEmpty() {
		return this.numEntries == 0;
	}

	public String toString() {
		String str = "";

		for (ApplicationEntry a : this.catalog) {
			str += a.toString() + "\n";
		}
		return str;
	}

	public void sort() {
		Collections.sort(this.catalog);
	}
	
	public void copy(Catalog a, int x) {
		this.catalog.add(a.get(x));
		this.numEntries++;
	}
	
	public int find(ApplicationEntry a) {
		int y = 0;
		for (ApplicationEntry x: catalog) {
			if (x.equals(a)) {
				return y;
			}
			else {
				y++;
			}
		}
		return 0;
	}


}
