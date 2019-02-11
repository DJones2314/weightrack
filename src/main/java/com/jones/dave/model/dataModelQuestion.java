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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
//	private Long answer_id;
	
//	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Set<dataModelAnswer>answer;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "question_id", cascade = CascadeType.ALL)
	private Collection<dataModelAnswer> answers = new LinkedHashSet<dataModelAnswer>();
	
	public dataModelQuestion() {
	}

	public dataModelQuestion( Long id, /*Long answer_id*/ String email, String name, String detail) {
		this.id = id;
//		this.answer_id = answer_id;
		this.email = answers.
		this.name = name;
		this.detail = detail;
	}
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

//	public Long getAnswer_id() {
//		return answer_id;
//	}
//
//	public void setAnswer_id(Long answer_id) {
//		this.answer_id = answer_id;
//	}


}
