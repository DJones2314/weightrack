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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "answer_id")
	private Long answer_id;
	
	
	@Column(name = "question_id")
	private Long question_id;
	
	public dataModelAnswer() {
	}
	
	public dataModelAnswer(Long answer_id, Long question_id, String answer_detail, String answer_name, String answer_email) {
		this.answer_id = answer_id;
		this.question_id = question_id;
		this.answer_detail = answer_detail;
		this.answer_email = answer_email;
		this.answer_name = answer_name;
	}
	
	@Column(name = "answer_detail")
	private String answer_detail;
	
	@Column(name = "answer_name")
	private String answer_name;

	@Column(name = "answer_email")
	private String answer_email;

	public Long getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(Long answer_id) {
		this.answer_id = answer_id;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}

	public String getAnswer_detail() {
		return answer_detail;
	}

	public void setAnswer_detail(String answer_detail) {
		this.answer_detail = answer_detail;
	}

	public String getAnswer_name() {
		return answer_name;
	}

	public void setAnswer_name(String answer_name) {
		this.answer_name = answer_name;
	}

	public String getAnswer_email() {
		return answer_email;
	}

	public void setAnswer_email(String answer_email) {
		this.answer_email = answer_email;
	}

}
