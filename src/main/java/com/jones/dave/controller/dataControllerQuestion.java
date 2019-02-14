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

import com.jones.dave.Repository.weightRepositoryQuestion;
import com.jones.dave.exception.ResourceNotFoundException;
import com.jones.dave.model.dataModelQuestion;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class dataControllerQuestion {

	@Autowired
	weightRepositoryQuestion myRepository;
	
	// Method to get all the questions posted 
		
		@GetMapping("/questions")
		public List<dataModelQuestion> getAllQuestions() {
			return myRepository.findAll();
		}
	
		@PostMapping("/question")
		public dataModelQuestion createQuestion(@Valid @RequestBody dataModelQuestion mSDM) {
			return myRepository.save(mSDM); 
		}

		// Method to get a question
		@GetMapping("question/{id}")
		public dataModelQuestion getQuestionByID(@PathVariable(value = "questionID") Long questionID) {
			return myRepository.findById(questionID)
					.orElseThrow(() -> new ResourceNotFoundException("dataModelQuestion", "id", questionID));
		}
		
//		@GetMapping("question/category/{type}")
//		public List<dataModelQuestion> findByQuestionType(@PathVariable(value = "type") String type) {
//			return myRepository.findByType(type);
//					//.orElseThrow(() -> new ResourceNotFoundException("dataModelQuestion", "type", questionType));
//		}

//		// Method to get all questions
//		@GetMapping("/question")
//		public List<dataModelQuestion> getAllQuestions() {
//			return myRepository.findAll(); 
//
//		}

		// Method to update/edit a question
		@PutMapping("/question/{id}")
		public dataModelQuestion updateQuestion(@PathVariable(value = "id") Long questionID,
				@Valid @RequestBody dataModelQuestion questionDetails) {
			dataModelQuestion mSDM = myRepository.findById(questionID)
					.orElseThrow(() -> new ResourceNotFoundException("Question", "id", questionID));

			mSDM.setDetail(questionDetails.getDetail());
//			mSDM.setDatetime(questionDetails.getDatetime());
			mSDM.setName(questionDetails.getName());

			dataModelQuestion updateData = myRepository.save(mSDM); 
			return updateData;
	 
		}

		// Method to remove a question
		@DeleteMapping("/question/{id}")
		public ResponseEntity<?> deleteQuestion(@PathVariable(value = "id") Long questionID) {
			dataModelQuestion mSDM = myRepository.findById(questionID)
					.orElseThrow(() -> new ResourceNotFoundException("Question", "id", questionID));

			myRepository.delete(mSDM);
			return ResponseEntity.ok().build();

		}

		
}
