package com.example.nearby_locations.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlacesItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("placeId")
	private String placeId;

	@JsonProperty("lon")
	private double lon;

	@JsonProperty("id")
	private int id;

	@JsonProperty("partnerId")
	private String partnerId;

	@JsonProperty("wifiCheckinEnabled")
	private boolean wifiCheckinEnabled;

	@JsonProperty("lat")
	private double lat;

	@JsonProperty("features")
	private List<String> features;

	@JsonProperty("zipCode")
	private String zipCode;

	@JsonProperty("city")
	private String city;

	@JsonProperty("countryCode")
	private String countryCode;

	@JsonProperty("street")
	private String street;

	@JsonProperty("wifis")
	private List<WifisItem> wifis;

	public String getName(){
		return name;
	}

	public String getPlaceId(){
		return placeId;
	}

	public double getLon(){
		return lon;
	}

	public int getId(){
		return id;
	}

	public String getPartnerId(){
		return partnerId;
	}

	public boolean isWifiCheckinEnabled(){
		return wifiCheckinEnabled;
	}

	public double getLat(){
		return lat;
	}

	public List<String> getFeatures(){
		return features;
	}

	public String getZipCode(){
		return zipCode;
	}

	public String getCity(){
		return city;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public String getStreet(){
		return street;
	}

	public List<WifisItem> getWifis(){
		return wifis;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(getName())
				.append(getPlaceId())
				.append(getStreet())
				.append(getZipCode())
				.append(getId())
				.append(getCountryCode())
				.append(getCity())
				.toString();
	}
}