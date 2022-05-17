package com.example.jigneshandroidtops.okhttp.gson;

import com.google.gson.annotations.SerializedName;

public class ImgSrcItem{

	@SerializedName("img")
	private String img;

	@SerializedName("imgDescription")
	private String imgDescription;

	public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return img;
	}

	public void setImgDescription(String imgDescription){
		this.imgDescription = imgDescription;
	}

	public String getImgDescription(){
		return imgDescription;
	}

	@Override
 	public String toString(){
		return 
			"ImgSrcItem{" + 
			"img = '" + img + '\'' + 
			",imgDescription = '" + imgDescription + '\'' + 
			"}";
		}
}