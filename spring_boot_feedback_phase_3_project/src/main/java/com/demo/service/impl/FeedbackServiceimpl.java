package com.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.FeedbackDAO;
import com.demo.exception.Business_Exception;
import com.demo.model.Feedback;
import com.demo.service.FeedbackService;

@Service
public class FeedbackServiceimpl implements FeedbackService {

	@Autowired
	private FeedbackDAO dao;
	
	@Override
	public Feedback createFeedback(Feedback feedback) throws Business_Exception {
		// TODO Auto-generated method stub
		int cr=feedback.getContent_rate();
		int pr=feedback.getPlatform_rate();
		String email=feedback.getEmail();
		String fname=feedback.getFname();
		String lname=feedback.getLname();
		if(!fname.matches("^[a-zA-Z]*$"))
		{
			throw new Business_Exception("Name can only contain letters");
		}
		if(!lname.matches("^[a-zA-Z]*$"))
		{
			throw new Business_Exception("Name can only contain letters");
		}
		if(cr<1 || cr >5 || pr<1 || pr>5)
		{
			throw new Business_Exception("ratings should be in the scale of 1 to 5");
		}
		if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
		{
			throw new Business_Exception("Invalid EmailID");
		}
		return dao.save(feedback);
	}

	@Override
	public Feedback getFeedbackById(int id) throws Business_Exception {
		if(id<=0) {
			throw new Business_Exception("ID "+id+" is invalid");
		}
		Feedback feedback=null;
		try {
			feedback= dao.findById(id).get();
		}
		 catch (NoSuchElementException e) {
			throw new Business_Exception("Feedback with the id "+id+" doesnt exist");
		}
		return feedback;
	}

	@Override
	public List<Feedback> getAllfeedbacks() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteFeedbackById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) throws Business_Exception {
		try {
			Feedback feedback1= dao.findById(feedback.getId()).get();
		}
		 catch (NoSuchElementException e) {
			throw new Business_Exception("Feedback with the id "+feedback.getId()+" doesnt exist");
		}
		int cr=feedback.getContent_rate();
		int pr=feedback.getPlatform_rate();
		String email=feedback.getEmail();
		String fname=feedback.getFname();
		String lname=feedback.getLname();
		if(!fname.matches("^[a-zA-Z]*$"))
		{
			throw new Business_Exception("Name can only contain letters");
		}
		if(!lname.matches("^[a-zA-Z]*$"))
		{
			throw new Business_Exception("Name can only contain letters");
		}
		if(cr<1 || cr >5 || pr<1 || pr>5)
		{
			throw new Business_Exception("ratings should be in the scale of 1 to 5");
		}
		if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
		{
			throw new Business_Exception("Invalid EmailID");
		}
		return dao.save(feedback);
	}

}
