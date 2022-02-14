package com.rezolve.geofence.controller;

import com.rezolve.geofence.adapter.ValidationAdapter;
import com.rezolve.geofence.modelgenerated.AdvertSchemaOut;
import com.rezolve.geofence.modelgenerated.Geofence;
import com.rezolve.geofence.service.GeofenceService;
import com.rezolve.geofence.service.GeofenceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rezolve.geofence.constant.GeofenceConstants.GEOFENCE;
import static com.rezolve.geofence.constant.GeofenceConstants.GEOFENCE_MANAGE;

@RestController
@RequestMapping(GEOFENCE)
@Slf4j
public class GeofenceController {

    @Autowired
    GeofenceService geofenceService;

    @Autowired
    ValidationAdapter validationAdapter;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNewGeofence(@RequestBody @Validated Geofence geofence) {
        if (!validationAdapter.apply(geofence)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        geofenceService.createGeofence(geofence);
        return ResponseEntity.ok("Success");
    }

    @PostMapping(value = GEOFENCE_MANAGE , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity manageGeofence(@RequestBody @Validated Geofence geofence) {
        if (!validationAdapter.apply(geofence)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        HttpStatus result = geofenceService.manageGeofence(geofence);
        return ResponseEntity.status(result).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdvertSchemaOut>> getGeofenceEntrance(@RequestBody @Validated Geofence geofence) {
        List<AdvertSchemaOut> list = geofenceService.getGeofence(geofence);
        return ResponseEntity.ok(list);
    }

}
