package com.example.jigneshandroidtops.okhttp.gson;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Solar{

	@SerializedName("_count")
	private int count;

	@SerializedName("_last")
	private Object last;

	@SerializedName("_items")
	private List<ItemsItem> items;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setLast(Object last){
		this.last = last;
	}

	public Object getLast(){
		return last;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"Solar{" + 
			"_count = '" + count + '\'' + 
			",_last = '" + last + '\'' + 
			",_items = '" + items + '\'' + 
			"}";
		}
}