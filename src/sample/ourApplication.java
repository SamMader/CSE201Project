package cse201;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class ourApplication {
	String name, description;
	double rating, price;
	boolean free;
	ArrayList<ourApplication> relatedApps = new ArrayList<ourApplication>();
	int category, downloads;
	Image thumbnail;
	public ourApplication(String a, String b, double c, double d, Integer e, Integer g, ArrayList<ourApplication> h, Image i) {
		name = a;
		description = b;
		rating = c;
		price = d;
		downloads = e;
		free = price > 0;
		category = g;
		relatedApps = h;
		thumbnail = i;
	}
}
