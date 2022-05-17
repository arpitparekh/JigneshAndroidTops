package com.example.jigneshandroidtops.okhttp.gson;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("wikiLink")
	private String wikiLink;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("planetOrder")
	private String planetOrder;

	@SerializedName("basicDetails")
	private List<BasicDetailsItem> basicDetails;

	@SerializedName("id")
	private int id;

	@SerializedName("source")
	private String source;

	@SerializedName("imgSrc")
	private List<ImgSrcItem> imgSrc;

	@SerializedName("key")
	private String key;

	public void setWikiLink(String wikiLink){
		this.wikiLink = wikiLink;
	}

	public String getWikiLink(){
		return wikiLink;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPlanetOrder(String planetOrder){
		this.planetOrder = planetOrder;
	}

	public String getPlanetOrder(){
		return planetOrder;
	}

	public void setBasicDetails(List<BasicDetailsItem> basicDetails){
		this.basicDetails = basicDetails;
	}

	public List<BasicDetailsItem> getBasicDetails(){
		return basicDetails;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setImgSrc(List<ImgSrcItem> imgSrc){
		this.imgSrc = imgSrc;
	}

	public List<ImgSrcItem> getImgSrc(){
		return imgSrc;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"wikiLink = '" + wikiLink + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",planetOrder = '" + planetOrder + '\'' + 
			",basicDetails = '" + basicDetails + '\'' + 
			",id = '" + id + '\'' + 
			",source = '" + source + '\'' + 
			",imgSrc = '" + imgSrc + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}