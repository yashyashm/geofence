package com.rezolve.geofence.service;

import com.rezolve.geofence.database.DatabaseService;
import com.rezolve.geofence.modelgenerated.Geofence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class GeofenceServiceTest {

    @InjectMocks
    GeofenceService geofenceService ;
    @Mock
    DatabaseService databaseService;
    @Mock
    RestTemplate restTemplate;


    @Test
    public void manageGeofence() {
        Geofence geofence = getGeofence();
        geofence.setLink(new ArrayList<>());
        HttpStatus result = geofenceService.manageGeofence(geofence);
        assertTrue(result.is4xxClientError());
    }

    private Geofence getGeofence() {
        Geofence geofence = new Geofence();
        geofence.setLatitude(11.11);
        geofence.setLongitude(22.22);
        geofence.setRadius(123.00);
        geofence.setLink(Arrays.asList("https://www.google.com"));
        return geofence;
    }
}