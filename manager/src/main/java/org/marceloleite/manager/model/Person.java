package org.marceloleite.manager.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Person {

	private Long id;

	private SchoolingLevel schoolingLevel;

	private Job job;

	private Building house;

	public Person(Long id, SchoolingLevel schoolingLevel) {
		super();
		this.id = id;
		this.schoolingLevel = schoolingLevel;
	}

	public Long getId() {
		return id;
	}

	public SchoolingLevel getSchoolingLevel() {
		return schoolingLevel;
	}

	public void setSchoolingLevel(SchoolingLevel schoolingLevel) {
		this.schoolingLevel = schoolingLevel;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Building getHouse() {
		return house;
	}

	public void setHouse(Building house) {
		this.house = house;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		try {
			return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
