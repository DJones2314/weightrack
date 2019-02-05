package com.jones.dave.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jones.dave.model.dataModelAnswer;

@Repository
public interface weightRepositoryAnswer extends JpaRepository<dataModelAnswer, Long>{

	Optional<dataModelAnswer> findById(int questionID);

	List<dataModelAnswer> findByType(String type);

	
	
}
