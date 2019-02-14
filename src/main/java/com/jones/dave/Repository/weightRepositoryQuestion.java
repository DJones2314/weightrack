package com.jones.dave.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jones.dave.model.dataModelAnswer;
import com.jones.dave.model.dataModelQuestion;

@Repository
public interface weightRepositoryQuestion extends JpaRepository<dataModelQuestion, Long>{

	Optional<dataModelQuestion> findById(Long id);


//	List<dataModelQuestion> findByType(String type);

	
	
}
