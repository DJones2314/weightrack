package com.jones.dave.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "answer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "creationDate", "lastModified"}, allowGetters = true)

public class dataModelAnswer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_ID")
	private int answer_ID;
	
	@NotBlank
	@Column(name = "question_ID")
	private int question_ID;
	
	@Lob
	@NotBlank
	@Column(name = "answer_detail")
	private String answer_detail;
	
	@Column(name = "answer_name")
	private String answer_name;

	@Column(name = "answer_email")
	private String answer_email;
	
	@Column(name ="answer_datetime")
	private String answer_datetime;
	
	@Column(name = "answer_view")
	private int answer_view;
	
	@Column(name = "answer_reply")
	private int answer_reply;

	public int getAnswer_ID() {
		return answer_ID;
	}

	public void setAnswer_ID(int answer_ID) {
		this.answer_ID = answer_ID;
	}

	public int getQuestion_ID() {
		return question_ID;
	}

	public void setQuestion_ID(int question_ID) {
		this.question_ID = question_ID;
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

	public String getAnswer_datetime() {
		return answer_datetime;
	}

	public void setAnswer_datetime(String answer_datetime) {
		this.answer_datetime = answer_datetime;
	}

	public int getAnswer_view() {
		return answer_view;
	}

	public void setAnswer_view(int answer_view) {
		this.answer_view = answer_view;
	}

	public int getAnswer_reply() {
		return answer_reply;
	}

	public void setAnswer_reply(int answer_reply) {
		this.answer_reply = answer_reply;
	}

	

}
