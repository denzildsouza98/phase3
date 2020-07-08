package com.demo.service;

import java.util.List;

import com.demo.exception.Business_Exception;
import com.demo.model.Feedback;

public interface FeedbackService {
	
	public Feedback createFeedback(Feedback feedback) throws Business_Exception;
	public Feedback getFeedbackById(int id) throws Business_Exception;
	public List<Feedback> getAllfeedbacks();
	public void deleteFeedbackById(int id);
	public Feedback updateFeedback(Feedback feedback) throws Business_Exception;

}
