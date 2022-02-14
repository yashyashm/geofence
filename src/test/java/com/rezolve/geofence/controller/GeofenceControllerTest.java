package com.rezolve.geofence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rezolve.geofence.GeofenceApplication;
import com.rezolve.geofence.config.TestDBConfiguration;
import com.rezolve.geofence.modelgenerated.Geofence;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"spring.cloud.consul.enabled=false"} ,
        classes = {GeofenceApplication.class, TestDBConfiguration.class})

@AutoConfigureMockMvc
@ContextConfiguration(classes = {TestConfiguration.class})
@TestPropertySource(locations = {"classpath:application-test.properties"})
@ActiveProfiles("test")
public class GeofenceControllerTest {

    public static final String INVALID_URI = "https://www.test.com";
    @Autowired
    private MockMvc mockMvc ;

    @org.junit.Test
    public void createNewGeofence() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String postRequest = objectMapper.writeValueAsString(getGeofence());
        mockMvc.perform(post("/geofence").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").value("Success"));
    }

    @org.junit.Test
    public void createNewGeofenceInvalidPrecisionOfLatitude() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Geofence geofence = getGeofence();
        geofence.setLatitude(12.12345678);
        String postRequest = objectMapper.writeValueAsString(geofence);
        mockMvc.perform(post("/geofence").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @org.junit.Test
    public void createNewGeofenceInvalidPrecisionOfLongitude() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Geofence geofence = getGeofence();
        geofence.setLongitude(12.12345678);
        String postRequest = objectMapper.writeValueAsString(geofence);
        mockMvc.perform(post("/geofence").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @org.junit.Test
    public void createNewGeofenceInvalidPrecisionOfData() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Geofence geofence = getGeofence();
        geofence.setLongitude(12.12345678);
        geofence.setLatitude(12.12345678);
        String postRequest = objectMapper.writeValueAsString(geofence);
        mockMvc.perform(post("/geofence").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @org.junit.Test
    public void createNewGeofenceWithEmptyLongitude() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Geofence geofence = getGeofence();
        geofence.setLongitude(null);
        String postRequest = objectMapper.writeValueAsString(geofence);
        mockMvc.perform(post("/geofence").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @org.junit.Test
    public void createNewGeofenceWithEmptyLatitude() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Geofence geofence = getGeofence();
        geofence.setLatitude(null);
        String postRequest = objectMapper.writeValueAsString(geofence);
        mockMvc.perform(post("/geofence").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @org.junit.Test
    public void manageGeofence() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String postRequest = objectMapper.writeValueAsString(getGeofence());
        mockMvc.perform(post("/geofence/manage").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());
    }

    @org.junit.Test
    public void manageGeofenceWithEmptyUri() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Geofence geofence = getGeofence();
        geofence.setLink(null);
        String postRequest = objectMapper.writeValueAsString(geofence);
        mockMvc.perform(post("/geofence/manage").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @org.junit.Test(expected = Exception.class)
    public void manageGeofenceWithInvalidUri() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Geofence geofence = getGeofence();
        geofence.setLink(Arrays.asList(INVALID_URI));
        String postRequest = objectMapper.writeValueAsString(geofence);
        mockMvc.perform(post("/geofence/manage").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @org.junit.Test
    public void getGeofenceEntrance() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String postRequest = objectMapper.writeValueAsString(getGeofence());
        mockMvc.perform(get("/geofence").content(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    private Geofence getGeofence() {
        Geofence geofence = new Geofence();
        geofence.setLatitude(11.111111);
        geofence.setLongitude(22.222222);
        geofence.setRadius(123.00);
        geofence.setLink(Arrays.asList("https://www.google.com"));
        return geofence;
    }
}