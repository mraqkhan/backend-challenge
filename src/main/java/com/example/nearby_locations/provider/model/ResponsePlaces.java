package com.example.nearby_locations.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsePlaces {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("distance")
    private String distanceString;
    private double distance;

    public ResponsePlaces(PlacesItem placesItem, double distance) {
        name = placesItem.getName();
        address = getAddress(placesItem);
        this.distance = distance;
        distanceString = String.format("%.2f km", distance);
    }

    private String getAddress(PlacesItem placesItem) {
        return new StringBuilder().append(placesItem.getStreet() == null ? "" : placesItem.getStreet())
                .append(" ")
                .append(placesItem.getCity() == null ? "" : placesItem.getCity())
                .append(" ")
                .append(placesItem.getZipCode() == null ? "" : placesItem.getZipCode()).toString();
    }

    public double distance() {
        return distance;
    }
}
