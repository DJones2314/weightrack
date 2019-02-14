package com.jones.dave.repositoryTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.validation.Valid;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jones.dave.WeightRackApplication;
import com.jones.dave.Repository.weightRepositoryAnswerimpl;
import com.jones.dave.Repository.weightRepositoryQuestion;
import com.jones.dave.model.dataModelAnswer;
import com.jones.dave.model.dataModelQuestion;
import com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private weightRepositoryQuestion myRepoQ;
	
	@Autowired
	private weightRepositoryAnswerimpl myRepoA;
	
	@Test
	public void retrieveByIdQTest() {
		dataModelQuestion modelQ = new dataModelQuestion();
		entityManager.persist(modelQ);
		entityManager.flush();
		assertTrue(myRepoQ.findById(modelQ.getQuestionID()).isPresent());
	}
	
	@Test
	public void retrieveByIdATest() {
		dataModelQuestion modelQ = new dataModelQuestion();
		myRepoQ.save(modelQ);
		dataModelAnswer modelA = new dataModelAnswer(5L, modelQ.getQuestionID(), "matt", "luke", "dave");
		myRepoA.save(modelA);
		assertFalse(myRepoA.findById(modelA.getAnswerID()).isPresent());
	}  
	
	

}