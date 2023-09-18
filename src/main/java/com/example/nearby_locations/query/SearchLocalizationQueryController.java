package com.example.nearby_locations.query;

import com.example.nearby_locations.provider.model.ResponsePlaces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchLocalizationQueryController {

    private final SeachLocaltaionQueryService searchService;

    public SearchLocalizationQueryController(SeachLocaltaionQueryService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/api/places", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ResponsePlaces> getPlaces(@RequestParam(defaultValue = "0") double lat, @RequestParam(defaultValue = "0") double lon, @RequestParam(required = false, defaultValue = "") String query) {
        return searchService.getPlacesCollection(lat, lon, query);
    }
}
