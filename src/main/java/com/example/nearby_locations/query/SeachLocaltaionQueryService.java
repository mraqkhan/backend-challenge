package com.example.nearby_locations.query;

import com.example.nearby_locations.provider.LocalizationProvider;
import com.example.nearby_locations.provider.model.PlacesItem;
import com.example.nearby_locations.provider.model.ResponsePlaces;
import com.example.nearby_locations.util.DistanceCalculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SeachLocaltaionQueryService {

    private final LocalizationProvider provider;

    public SeachLocaltaionQueryService(LocalizationProvider provider) {
        this.provider = provider;
    }

    public List<ResponsePlaces> getPlacesCollection(double lat, double lon, String query) {
        return fileredSortedList(provider.getPlacesCollection(), lat, lon, query);
    }

    public List<ResponsePlaces> fileredSortedList(List<PlacesItem> places, double lat, double lon, String query) {
        List<PlacesItem> collect = places.stream()
                .filter((PlacesItem placesItem) -> placesItem.toString().contains(query))
                .toList();

        List<ResponsePlaces> response = new ArrayList<>();

        for (PlacesItem placesItem : collect) {
            response.add(new ResponsePlaces(placesItem, DistanceCalculator.distance(placesItem, lat, lon)));
        }
        response.sort(Comparator.comparingDouble(ResponsePlaces::distance));

        return response;
    }
}
