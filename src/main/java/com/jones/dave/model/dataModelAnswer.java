package com.jones.dave.model;

import java.io.Serializable;
import java.util.Date;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "answer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "creationDate", "lastModified"}, allowGetters = true)

public class dataModelAnswer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answerID")
	private Long answerID;
	
	
	@Column(name = "questionID")
	private Integer questionID;
	
	public dataModelAnswer() {
	}
	
	public dataModelAnswer(Long answerID, Integer questionID, String answerdetail, String answername, String answeremail) {
		this.answerID = answerID;
		this.questionID = questionID;
		this.answerdetail = answerdetail;
		this.answeremail = answeremail;
		this.answername = answername;
	}
	 
	
	
	public dataModelAnswer(long l, Long questionID2, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}



	@Column(name = "answerdetail")
	private String answerdetail;
	
	@Column(name = "answername")
	private String answername;

	@Column(name = "answeremail")
	private String answeremail;

	public Long getAnswerID() {
		return answerID;
	}

	public void setAnswerID(Long answerID) {
		this.answerID = answerID;
	}

	public Integer getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}

	public String getAnswerdetail() {
		return answerdetail;
	}

	public void setAnswerdetail(String answerdetail) {
		this.answerdetail = answerdetail;
	}

	public String getAnswername() {
		return answername;
	}

	public void setAnswername(String answername) {
		this.answername = answername;
	}

	public String getAnsweremail() {
		return answeremail;
	}

	public void setAnsweremail(String answeremail) {
		this.answeremail = answeremail;
	}

	

}
