package com.rezolve.geofence.adapter;

import com.rezolve.geofence.database.dto.GeofenceDto;
import com.rezolve.geofence.modelgenerated.Geofence;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static com.rezolve.geofence.constant.GeofenceConstants.ALLOWED_DECIMAL_NUMBER_RANGE;

@Component
public class ValidationAdapter implements Function<Geofence, Boolean> {

    @Override
    public Boolean apply(Geofence geofence) {
        return validateDouble(geofence.getLatitude()) && validateDouble(geofence.getLongitude());
    }

    private boolean validateDouble(Double doubleValue) {
        String[] parts = doubleValue.toString().split("\\.");
        int decimalLength = parts[1].length();

        if (decimalLength <= ALLOWED_DECIMAL_NUMBER_RANGE){
            return true;
        }
        return false;
    }
}
