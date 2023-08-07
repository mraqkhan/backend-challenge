package com.example.nearby_locations.util;

import com.example.nearby_locations.provider.model.PlacesItem;

public class DistanceCalculator {

    public static final double EQUATOR = 40075;
    public static final double ONE_DEGREE_DISTANCE = EQUATOR / 360;
    public static final double EARTH_RADIUS = 6371;

    public static double distance(double latitude1, double latitude2, double longitude1, double longitude2) {
        double latDistance = Math.toRadians(latitude2 - latitude1);
        double lonDistance = Math.toRadians(longitude2 - longitude1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }

    public static double distance(PlacesItem place, double latitude, double longitude) {
        return distance(place.getLat(), latitude, place.getLon(), longitude);
    }
}
