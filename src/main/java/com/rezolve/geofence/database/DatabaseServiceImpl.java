package com.rezolve.geofence.database;

import com.rezolve.geofence.adapter.GeofenceAdapter;
import com.rezolve.geofence.database.dto.AltitudeDto;
import com.rezolve.geofence.database.dto.GeofenceDto;
import com.rezolve.geofence.database.repository.GeofenceRepository;
import com.rezolve.geofence.modelgenerated.AdvertSchemaOut;
import com.rezolve.geofence.modelgenerated.Geofence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    GeofenceAdapter geofenceAdapter;
    @Autowired
    GeofenceRepository geofenceRepository;


    public void createGeofence(Geofence geofence) {
        geofenceRepository.save(geofenceAdapter.apply(geofence));
    }

    public List<AdvertSchemaOut> getGeofence(Geofence geofence) {
        List<AdvertSchemaOut> list = null;
        AltitudeDto id = AltitudeDto.builder().latitude(geofence.getLatitude()).longitude(geofence.getLongitude()).build();
        Optional<GeofenceDto> result = geofenceRepository.findById(id);

        if(result.isPresent()){
          list =  Arrays.stream(result.get().getLink().split(",")).map(a1 -> createAdvertSchema(a1, result.get().getRadius())).collect(Collectors.toList());
        }
        return list;
    }

    private AdvertSchemaOut createAdvertSchema(String a1, Double radius) {
        AdvertSchemaOut advertSchemaOut = new AdvertSchemaOut();
        advertSchemaOut.setRadius(radius);
        advertSchemaOut.setLink(a1);
        return advertSchemaOut;
    }
}
