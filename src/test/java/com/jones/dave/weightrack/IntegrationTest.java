package com.jones.dave.weightrack;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
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
@SpringBootTest(classes = { WeightRackApplication.class })
@AutoConfigureMockMvc
@WebAppConfiguration
public class IntegrationTest {

	@Autowired
	private MockMvc mvc;
	private WebApplicationContext wac;

	@Autowired
	private weightRepositoryQuestion myRepoQ;
	
	@Autowired
	private weightRepositoryAnswerimpl myRepoA;

	@Before
	public void clearDB() {
		myRepoQ.deleteAll();
	}

//	@Test
//	public void findingAndRetrievingQuestionsFromDatabase() throws Exception {
//		myRepo.save(new dataModelQuestion(2L, "tester", "tests", "testy"));
//		mvc.perform(get("/api/question").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//				.andExpect(jsonPath("$[0].id", is(2)));
//
//	}

//	 testing the Get method
	@Test
	public void getTest() throws Exception {
		dataModelQuestion testQuestion = new dataModelQuestion(5L, "tester", "tests", "testy");
		myRepoQ.save(testQuestion);
		mvc.perform(get("/api/questions").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].questionID", is(2)));
	}

	// testing the post method
	@Test
	public void postingTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/api/question").contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\" : \"test@test\",\"name\" : \"dave\", \"detail\" : \"this is a test\"}")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name", is("dave")));
	}


	@Test
		public void deleteTest() throws Exception {
		dataModelQuestion testQuestion2 = new dataModelQuestion(5L, "honda", "green", "2001");
		myRepoQ.save(testQuestion2);

		mvc.perform(MockMvcRequestBuilders.delete("/api/question/5").contentType(MediaType.APPLICATION_JSON))
				// .accept(MediaType.APPLICATION_JSON)
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void deleteTest1() throws Exception {
		dataModelQuestion modelQ = new dataModelQuestion();
		myRepoQ.save(modelQ);
		dataModelAnswer modelA = new dataModelAnswer(5L, modelQ.getQuestionID(), "matt", "luke", "dave");
		myRepoA.save(modelA);
	mvc.perform(MockMvcRequestBuilders.delete("/api/question/5").contentType(MediaType.APPLICATION_JSON))
			// .accept(MediaType.APPLICATION_JSON)
			.andExpect(status().isNotFound());
}

}