package com.foodroulett.Search;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class SearchService {

	//gets api key from environment variable
	//NOTE: Place environment variable on applicaton.properties file then get apiKey from that file
	String apiKey = System.getenv("YELP_FOODROULETT_API_KEY");
	final int limit = 4;	//limits number of search results

	/*
	 * returns search results from query
	 */
	public ResponseEntity<Object> getRestaurantFromYelp(String location, String categories, int radius) {

		WebClient client = WebClient.create("https://api.yelp.com/v3/businesses");

		/*
		 * creates a get request, using query parameters [location, radius, categories, & limit(hard coded)]
		 * sets header Authorization to apiKey
		 * extracts the ResponseEntity from get request, which contains list of restaurants
		 */
		Mono<ResponseEntity<Object>> result = client.get().uri(builder -> builder.path("/search")
				.queryParam("location", location)
				.queryParam("radius", radius)
				.queryParam("limit", limit)
				.queryParam("categories", categories)
				.build())
				.header("Authorization", "Bearer " + apiKey).retrieve().toEntity(Object.class);

		
		return result.block();
	}
}
