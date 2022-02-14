package com.rezolve.geofence.database.dto;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AltitudeDto implements Serializable {
    private static final long serialVersionUID = -4465093519165776228L;

    @Column(name = "LATITUDE", nullable = false)
    private Double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    private Double longitude;

}
