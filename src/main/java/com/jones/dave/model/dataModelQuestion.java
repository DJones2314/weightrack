package com.jones.dave.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "question")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "creationDate", "lastModified"}, allowGetters = true)

public class dataModelQuestion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questionID")
	private Long questionID;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "questionID", cascade = CascadeType.ALL)
	private Collection<dataModelAnswer> answers = new LinkedHashSet<dataModelAnswer>(); 
	
	public dataModelQuestion() {
	}
 
	public dataModelQuestion( Long questionID, String email, String name, String detail) {
		this.questionID = questionID;
		this.email = email;
		this.name = name;
		this.detail = detail;
	}
	
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	public Long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}

	public Collection<dataModelAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(Collection<dataModelAnswer> answers) {
		this.answers = answers;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
