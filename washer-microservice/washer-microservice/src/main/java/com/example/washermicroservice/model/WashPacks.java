package com.example.washermicroservice.model;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class WashPacks {

	@Id
	private int id;
	
	@NotBlank(message="Name cannot be blank")
	private String name;
	
	@NotNull(message="Cost cannot be Null")
	private int cost;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WashPacks(int id, @NotBlank(message = "Name cannot be blank") String name,
			@NotNull(message = "Cost cannot be Null") int cost, String description) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}

	public WashPacks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

	
}
