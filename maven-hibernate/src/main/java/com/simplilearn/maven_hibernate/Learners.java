package com.simplilearn.maven_hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //Makes this class bind to a table in the database
@Table(name="learnertbl")
public class Learners {
	
	

	public Learners(String learnerFName, String learnerLName, String learnerAddr) {
		this.LearnerFName = learnerFName;
		this.LearnerLName = learnerLName;
		this.LearnerAddr = learnerAddr;
	}

	
	public Learners() {
		
	}


	public int getLearnerId() {
		return LearnerId;
	}

	
	public String getLearnerFName() {
		return LearnerFName;
	}

	public String getLearnerLName() {
		return LearnerLName;
	}

	public String getLearnerAddr() {
		return LearnerAddr;
	}


	public void setLearnerFName(String learnerFName) {
		LearnerFName = learnerFName;
	}


	public void setLearnerLName(String learnerLName) {
		LearnerLName = learnerLName;
	}


	public void setLearnerAddr(String learnerAddr) {
		LearnerAddr = learnerAddr;
	}


	@Override
	public String toString() {
		return "Learners [LearnerId=" + LearnerId + ", LearnerFName=" + LearnerFName + ", LearnerLName=" + LearnerLName
				+ ", LearnerAddr=" + LearnerAddr + "]";
	}



	@Column(name="LearnerId") //Tells Hibernate to map this property to the column in table
	@GeneratedValue(strategy = GenerationType.IDENTITY) //For Auto-Increment columns
	@Id //Tells Hibernate this is our primary key in the table
	int LearnerId;
	
	@Column(name = "LearnerFName")
	String LearnerFName;
	
	@Column(name = "LearnerLName")
	String LearnerLName;
	
	@Column(name = "LearnerAddr")
	String LearnerAddr;
	
	/*
	 * @Embedded private Skill skill;
	 * 
	 * public Skill getSkill() { return skill; }
	 * 
	 * 
	 * public void setSkill(Skill theskill) { this.skill = theskill; }
	 */
	@ElementCollection
	@JoinTable(name="LearnerSkills")
	private List<Skill> listOfSkills = new ArrayList<Skill>();

	public List<Skill> getListOfSkills() {
		return listOfSkills;
	}


	public void setListOfSkills(List<Skill> listOfSkills) {
		this.listOfSkills = listOfSkills;
	}
	
	@OneToOne
	@JoinColumn(name="id")
	private Mobile theMobile;

	public Mobile getTheMobile() {
		return theMobile;
	}


	public void setTheMobile(Mobile theMobile) {
		this.theMobile = theMobile;
	}
	
	
	
}

