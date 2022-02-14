package com.rezolve.geofence.database;

import com.rezolve.geofence.modelgenerated.AdvertSchemaOut;
import com.rezolve.geofence.modelgenerated.Geofence;

import java.util.List;

public interface DatabaseService {
    public void createGeofence(Geofence geofence) ;
    public List<AdvertSchemaOut> getGeofence(Geofence geofence) ;
}
