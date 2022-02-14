
package com.rezolve.geofence.modelgenerated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The root schema
 * <p>
 * The root schema comprises the entire JSON document.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latitude",
    "longitude",
    "radius",
    "link"
})
public class Geofence implements Serializable
{

    /**
     * The empId schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    @NotNull
    private Double latitude;
    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    @NotNull
    private Double longitude;
    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * 
     */
    @JsonProperty("radius")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private Double radius;
    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * 
     */
    @JsonProperty("link")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    @Valid
    private List<String> link = new ArrayList<String>();
    private final static long serialVersionUID = -8859991015965735452L;

    /**
     * The empId schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    /**
     * The empId schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Geofence withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Geofence withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * 
     */
    @JsonProperty("radius")
    public Double getRadius() {
        return radius;
    }

    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * 
     */
    @JsonProperty("radius")
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Geofence withRadius(Double radius) {
        this.radius = radius;
        return this;
    }

    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * 
     */
    @JsonProperty("link")
    public List<String> getLink() {
        return link;
    }

    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * 
     */
    @JsonProperty("link")
    public void setLink(List<String> link) {
        this.link = link;
    }

    public Geofence withLink(List<String> link) {
        this.link = link;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("latitude", latitude).append("longitude", longitude).append("radius", radius).append("link", link).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(link).append(radius).append(latitude).append(longitude).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Geofence) == false) {
            return false;
        }
        Geofence rhs = ((Geofence) other);
        return new EqualsBuilder().append(link, rhs.link).append(radius, rhs.radius).append(latitude, rhs.latitude).append(longitude, rhs.longitude).isEquals();
    }

}
