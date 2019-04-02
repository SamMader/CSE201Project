package cse201;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Application {
	String name, description;
	double rating, price;
	boolean free;
	ArrayList<Application> relatedApps = new ArrayList<Application>();
	int category, downloads;
	Image thumbnail;
	public Application(String a, String b, double c, double d, Integer e, Integer g, ArrayList<Application> h, Image i) {
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
