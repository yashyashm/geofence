package com.rezolve.geofence.service;

import com.rezolve.geofence.database.DatabaseService;
import com.rezolve.geofence.modelgenerated.AdvertSchemaOut;
import com.rezolve.geofence.modelgenerated.Geofence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.rezolve.geofence.constant.GeofenceConstants.ALLOWED_DECIMAL_NUMBER_RANGE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class GeofenceServiceImpl implements GeofenceService  {

    @Autowired
    DatabaseService databaseService ;

    @Autowired
    RestTemplate restTemplate;

    public void createGeofence(Geofence geofence) {
        databaseService.createGeofence(geofence);
    }

    public List<AdvertSchemaOut> getGeofence(Geofence geofence) {
        return databaseService.getGeofence(geofence);
    }

    public HttpStatus manageGeofence(Geofence geofence) {
        if (geofence.getLink().isEmpty()) {
            return BAD_REQUEST;
        }
        //More input required to update schema if user can not enter more than one href link.
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(geofence.getLink().get(0), String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful() ){
            databaseService.getGeofence(geofence);
        }
        return HttpStatus.ACCEPTED;
    }
}
