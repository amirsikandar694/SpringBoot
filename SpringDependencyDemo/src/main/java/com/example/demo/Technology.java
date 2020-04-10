package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Technology {
	
private String techId;
private String techName;

public String getTechId() {
	return techId;
}
public void setTechId(String techId) {
	this.techId = techId;
}
public String getTechName() {
	return techName;
}
public void setTechName(String techName) {
	this.techName = techName;
}

public void techDisplay()
{
	System.out.println("Tech Display");
}
}
