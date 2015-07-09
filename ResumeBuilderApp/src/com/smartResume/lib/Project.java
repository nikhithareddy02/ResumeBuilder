package com.smartResume.lib;

import java.util.HashMap;
import java.util.List;

public class Project {
	private String title;
	private String description;
	private String URL;
	private HashMap<String,List<String>> technologiesUsed; 
	public void setTechnologiesUsed(HashMap<String, List<String>> technologiesUsed) {
		this.technologiesUsed = technologiesUsed;
	}
	/*
	 * eg: (ProgrammingLaguages,{c,java})
	 */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public HashMap<String, List<String>> getTechnologiesUsed() {
		return technologiesUsed;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		this.URL = uRL;
	}
	
}
