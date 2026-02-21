package com.bim.in.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bim.in.pojo.ReviewerPojo;

@Service
public class ReviewerService {

	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	public List<ReviewerPojo> getAllReviewer(){
		ResponseEntity<List<ReviewerPojo>> response=restTemplate.exchange("http://localhost:9999/api/reviewer",
				HttpMethod.GET,
				null, new ParameterizedTypeReference<List<ReviewerPojo>>() {});
		
		return response.getBody();
	}
	

	
	/*public ReviewerPojo saveReviewer(ReviewerPojo reviewer) {
        String sql = "INSERT INTO reviewer (ReviewerID,Name,employedby) VALUES (?, ?,?)";
        jdbcTemplate.update(sql, reviewer.getReviewerId(), reviewer.getName(),reviewer.getEmployedby());
        return reviewer;
    }

	*/
	public ReviewerPojo saveReviewer(ReviewerPojo reviewer) {
        ResponseEntity<ReviewerPojo> response = restTemplate.postForEntity(
                "http://localhost:9999/api/reviewer/post",
                reviewer,
                ReviewerPojo.class);
 
        return response.getBody();
    }
	

}
