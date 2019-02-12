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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jones.dave.Repository.weightRepositoryAnswerimpl;
import com.jones.dave.exception.ResourceNotFoundException;
import com.jones.dave.model.dataModelAnswer;
import com.jones.dave.model.dataModelQuestion;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class dataControllerAnswer {

	@Autowired
	weightRepositoryAnswerimpl myRepository;
	
	// Method to get all the answers posted 
		
		@GetMapping("/answers")
		public List<dataModelAnswer> getAllAnswers() {
			return myRepository.findAll();
		}
	
		@PostMapping("/answer")
		public dataModelAnswer createAnswer(@Valid @RequestBody dataModelAnswer mSDM) {
			return myRepository.save(mSDM); 
		}

//		 Method to get an answer
		@GetMapping("answer/{answer_id}")
		public dataModelAnswer getAnswerByID(@PathVariable(value = "answer_id") Long answerID) {
			return myRepository.findById(answerID)
					.orElseThrow(() -> new ResourceNotFoundException("dataModelAnswer", "answer_id", answerID));
		}
		

		// Method to update/edit an answer
		@PutMapping("/answer/{id}")
		public dataModelAnswer updateAnswer(@PathVariable(value = "id") Long answerID,
				@Valid @RequestBody dataModelAnswer answerDetails) {
			dataModelAnswer mSDM = myRepository.findById(answerID)
					.orElseThrow(() -> new ResourceNotFoundException("Answer", "id", answerID));

			mSDM.setAnswerdetail(answerDetails.getAnswerdetail());
			mSDM.setAnswername(answerDetails.getAnswername());

			dataModelAnswer updateData = myRepository.save(mSDM); 
			return updateData;
	 
		}

		// Method to remove an answer
				@DeleteMapping("/answer/{id}")
				public ResponseEntity<?> deleteQuestion(@PathVariable(value = "id") Long answer_id) {
					dataModelAnswer mSDM = myRepository.findById(answer_id)
							.orElseThrow(() -> new ResourceNotFoundException("Question", "id", answer_id));

					myRepository.delete(mSDM);
					return ResponseEntity.ok().build();

				}
		
		

		
}
