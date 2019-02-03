package com.jones.dave.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jones.dave.model.dataModelQuestion;

@Repository
public interface weightRepository extends JpaRepository<dataModelQuestion, Long>{

	
	
}
