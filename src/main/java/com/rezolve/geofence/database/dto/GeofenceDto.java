package com.rezolve.geofence.database.dto;

import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;

@Entity
@Table(name = "GEOFENCE")
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeofenceDto implements Serializable {
    private static final long serialVersionUID = -4465093519165776227L;

/*    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;*/

    @EmbeddedId
    private AltitudeDto altitudeDto;

    @Column(name = "RADIUS")
    private Double radius;

    @Column(name = "LINK")
    @Lob
    private String link;
}
