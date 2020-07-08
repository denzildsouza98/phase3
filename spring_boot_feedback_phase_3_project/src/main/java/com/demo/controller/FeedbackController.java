package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.Business_Exception;
import com.demo.model.Feedback;
import com.demo.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService service;
	
	private MultiValueMap<String, String> map;

	@PostMapping("/feedback")
	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Feedback>(service.createFeedback(feedback), HttpStatus.OK); 
			}
		catch(Business_Exception e)
		{
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null, map, HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackById(id), HttpStatus.OK); 
		} catch (Business_Exception e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null, map, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/feedbacks")
	public List<Feedback> getAllfeedbacks() {
		// TODO Auto-generated method stub
		return service.getAllfeedbacks();
	}

	@DeleteMapping("/feedback/{id}")
	public void deleteFeedbackById(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		service.deleteFeedbackById(id);
	}

	@PutMapping("/feedback")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) {
		try {
			return new ResponseEntity<Feedback>(service.updateFeedback(feedback), HttpStatus.OK); 
			}
		catch(Business_Exception e)
		{
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null, map, HttpStatus.BAD_REQUEST);
					}
	}
	
	
}
