package com.example.jigneshandroidtops.okhttp.gson;

import com.google.gson.annotations.SerializedName;

public class BasicDetailsItem{

	@SerializedName("volume")
	private String volume;

	@SerializedName("mass")
	private String mass;

	public void setVolume(String volume){
		this.volume = volume;
	}

	public String getVolume(){
		return volume;
	}

	public void setMass(String mass){
		this.mass = mass;
	}

	public String getMass(){
		return mass;
	}

	@Override
 	public String toString(){
		return 
			"BasicDetailsItem{" + 
			"volume = '" + volume + '\'' + 
			",mass = '" + mass + '\'' + 
			"}";
		}
}