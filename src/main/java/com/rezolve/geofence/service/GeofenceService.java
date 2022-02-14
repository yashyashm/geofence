package com.rezolve.geofence.service;

import com.rezolve.geofence.modelgenerated.AdvertSchemaOut;
import com.rezolve.geofence.modelgenerated.Geofence;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface GeofenceService {
    public void createGeofence(Geofence geofence);
    public List<AdvertSchemaOut> getGeofence(Geofence geofence);
    public HttpStatus manageGeofence(Geofence geofence) ;
}
