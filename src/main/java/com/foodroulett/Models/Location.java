package com.foodroulett.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Location {
	
	private String city;
	private String country;
	private String state;
	private String address;
	private String zipCode;
}
