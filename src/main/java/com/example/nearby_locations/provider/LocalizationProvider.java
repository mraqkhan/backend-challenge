package com.example.nearby_locations.provider;

import com.example.nearby_locations.provider.model.Places;
import com.example.nearby_locations.provider.model.PlacesItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Component
public class LocalizationProvider {

    private static final Logger logger = LoggerFactory.getLogger(LocalizationProvider.class);
    private static final String URL = "https://payback-coding-challenge.s3.eu-central-1.amazonaws.com/germany.json";

    private ResponseEntity<Places> getPlaces() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(URL, HttpMethod.GET, null, Places.class, String.class);
    }

    public List<PlacesItem> getPlacesCollection() {
        try {
            ResponseEntity<Places> response = getPlaces();
            if (response.getStatusCode().value() == 200) {
                return response.getBody().getPlaces();
            } else {
                logger.error("Problem while trying to get places.");
                logger.error("Request send to: " + URL);
                logger.error("Response status:" + response.getStatusCode());
                throw new IllegalStateException("Problem while trying to get list of places");
            }
        } catch (HttpClientErrorException exception) {
            logger.error("Problem while contacting with remote server.");
            logger.error("Request send to: " + URL);
            logger.error(exception.getMessage());
            logger.error(exception.getResponseBodyAsString());
            throw exception;
        } catch (Exception exception) {
            logger.error("Problem while contacting with payu servers.");
            logger.error("Request send to: $oauthUrl");
            logger.error(exception.getMessage());
            throw exception;
        }
    }
}