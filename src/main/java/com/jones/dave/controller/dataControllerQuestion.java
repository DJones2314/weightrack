package com.jones.dave.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jones.dave.Repository.weightRepository;
import com.jones.dave.model.dataModelQuestion;


@RestController
@RequestMapping("/api")

public class dataControllerQuestion {

	@Autowired
	weightRepository myRepository;
	
	// Method to get all the questions posted 
		@CrossOrigin
		@GetMapping("/questions")
		public List<dataModelQuestion> getAllQuestions() {
			return myRepository.findAll();
		}
	
}
