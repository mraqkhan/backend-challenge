package com.example.nearby_locations.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WifisItem{

	@JsonProperty("bssid")
	private String bssid;

	@JsonProperty("id")
	private int id;

	public String getBssid(){
		return bssid;
	}

	public int getId(){
		return id;
	}
}