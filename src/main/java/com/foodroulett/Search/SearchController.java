package com.foodroulett.Search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	SearchService searchService;

	/*
	 * Maps get request to /search?queryParameters
	 * NOTE: returns response object (list of restaurants),
	 * NOTE: Account for multiple Categories. Query params such as /search?categories=sushi%2Cmexican decodes to sushi,mexican
	 * 		&2C encodes to ','
	 */
	@GetMapping("/search")
	@ResponseBody
	public ResponseEntity<Object> getLocation(@RequestParam("location") String location, @RequestParam(required=false) String categories, @RequestParam("radius") int radius) {
		
		if(categories == null) {
			categories = "restaurants";
		}
		
		ResponseEntity<Object> searchResponse = searchService.getRestaurantFromYelp(location, categories, radius);
		
		return searchResponse;
	}
}
