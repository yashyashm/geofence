package com.rezolve.geofence.database.repository;

import com.rezolve.geofence.database.dto.AltitudeDto;
import com.rezolve.geofence.database.dto.GeofenceDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeofenceRepository extends CrudRepository<GeofenceDto, AltitudeDto> {

}
