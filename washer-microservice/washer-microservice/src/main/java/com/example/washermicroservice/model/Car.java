package com.example.washermicroservice.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class Car {
	
	@Id
	private int id;
	
	private String name;
	
	@NotBlank(message="model cannot be blank")
	private String model;

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Car(int id, String name, @NotBlank(message = "model cannot be blank") String model) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
