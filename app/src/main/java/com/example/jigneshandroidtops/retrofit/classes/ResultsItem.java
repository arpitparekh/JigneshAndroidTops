package com.example.jigneshandroidtops.retrofit.classes;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("employment_type")
	private String employmentType;

	@SerializedName("role")
	private String role;

	@SerializedName("keywords")
	private List<Object> keywords;

	@SerializedName("source")
	private String source;

	@SerializedName("remote")
	private boolean remote;

	@SerializedName("url")
	private String url;

	@SerializedName("date_posted")
	private String datePosted;

	@SerializedName("company_name")
	private String companyName;

	@SerializedName("logo")
	private String logo;

	@SerializedName("location")
	private String location;

	@SerializedName("id")
	private int id;

	@SerializedName("text")
	private String text;

	@SerializedName("company_num_employees")
	private String companyNumEmployees;

	public void setEmploymentType(String employmentType){
		this.employmentType = employmentType;
	}

	public String getEmploymentType(){
		return employmentType;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setKeywords(List<Object> keywords){
		this.keywords = keywords;
	}

	public List<Object> getKeywords(){
		return keywords;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setRemote(boolean remote){
		this.remote = remote;
	}

	public boolean isRemote(){
		return remote;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setDatePosted(String datePosted){
		this.datePosted = datePosted;
	}

	public String getDatePosted(){
		return datePosted;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setCompanyNumEmployees(String companyNumEmployees){
		this.companyNumEmployees = companyNumEmployees;
	}

	public String getCompanyNumEmployees(){
		return companyNumEmployees;
	}

	@Override
 	public String toString(){
		return 


			"role = " + role +
			"\n\ndate_posted = '" + datePosted +
			"\n\ncompany_name = '" + companyName +
			"\n\nlocation = '" + location +
			"\n\ncompany_num_employees = '" + companyNumEmployees;
		}
}