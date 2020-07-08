package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Feedback;

@Repository
public interface FeedbackDAO extends JpaRepository<Feedback, Integer>{

}
