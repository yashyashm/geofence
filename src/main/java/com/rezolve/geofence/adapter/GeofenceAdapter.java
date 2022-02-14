package com.rezolve.geofence.adapter;

import com.rezolve.geofence.database.dto.AltitudeDto;
import com.rezolve.geofence.database.dto.GeofenceDto;
import com.rezolve.geofence.modelgenerated.Geofence;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class GeofenceAdapter implements Function<Geofence, GeofenceDto> {
    @Override
    public GeofenceDto apply(Geofence geofence) {
        return GeofenceDto.builder()
                .altitudeDto(AltitudeDto.builder()
                        .longitude(geofence.getLongitude())
                        .latitude(geofence.getLatitude())
                        .build())
                .radius(geofence.getRadius())
                .link(getClob(geofence.getLink()))
                .build();
    }

    private String getClob(List<String> link) {
        return link.stream().collect(Collectors.joining(","));
    }
}
