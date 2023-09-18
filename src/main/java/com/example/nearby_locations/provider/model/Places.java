package com.example.nearby_locations.provider.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Places{

	@JsonProperty("places")
	private List<PlacesItem> places;

	@JsonProperty("version")
	private int version;

	public List<PlacesItem> getPlaces(){
		return places;
	}

	public int getVersion(){
		return version;
	}
}