package com.foodroulett.Models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Business {
	
	private Float rating;
	private String price;
	private String phone;
	private String id;
	ArrayList<Categorie> categories;
	private String name;
	private String url;
	private Coordinates coordinates;
	private String imageUrl;
	private Location location;
}
