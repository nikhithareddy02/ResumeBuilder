package com.smartResume.lib;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Resume {
	private String personalInfo;
	private String careerObjective;
	private List<Project> projects;
	private HashMap<String,List<String>> technologies; 
	/*
	 * eg: (ProgrammingLaguages,{c,java})
	 */
	private HashMap<String,HashMap<String,Double>> educationalDetails;
	private List<String> extraCurricularActivities; 
	private List<String> coCurricularActivities;
	private List<String> certifications;
	private List<String> achievements;
	private String Signature;
	private Date dated;
	
	
	public String getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}
	public String getCareerObjective() {
		return careerObjective;
	}
	public void setCareerObjective(String careerObjective) {
		this.careerObjective = careerObjective;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public HashMap<String, List<String>> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(HashMap<String, List<String>> technologies) {
		this.technologies = technologies;
	}
	public HashMap<String, HashMap<String, Double>> getEducationalDetails() {
		return educationalDetails;
	}
	public void setEducationalDetails(
			HashMap<String, HashMap<String, Double>> educationalDetails) {
		this.educationalDetails = educationalDetails;
	}
	public List<String> getExtraCurricularActivities() {
		return extraCurricularActivities;
	}
	public void setExtraCurricularActivities(List<String> extraCurricularActivities) {
		this.extraCurricularActivities = extraCurricularActivities;
	}
	public List<String> getCoCurricularActivities() {
		return coCurricularActivities;
	}
	public void setCoCurricularActivities(List<String> coCurricularActivities) {
		this.coCurricularActivities = coCurricularActivities;
	}
	public List<String> getCertifications() {
		return certifications;
	}
	public void setCertifications(List<String> certifications) {
		this.certifications = certifications;
	}
	public List<String> getAchievements() {
		return achievements;
	}
	public void setAchievements(List<String> achievements) {
		this.achievements = achievements;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}

	
}
