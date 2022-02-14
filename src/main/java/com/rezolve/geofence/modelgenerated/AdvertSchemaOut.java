
package com.rezolve.geofence.modelgenerated;

import java.io.Serializable;
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
    "radius",
    "link"
})
public class AdvertSchemaOut implements Serializable
{

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
    private String link = "";
    private final static long serialVersionUID = -8427463377016303008L;

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

    public AdvertSchemaOut withRadius(Double radius) {
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
    public String getLink() {
        return link;
    }

    /**
     * The fullName schema
     * <p>
     * An explanation about the purpose of this instance.
     * 
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    public AdvertSchemaOut withLink(String link) {
        this.link = link;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("radius", radius).append("link", link).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(radius).append(link).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdvertSchemaOut) == false) {
            return false;
        }
        AdvertSchemaOut rhs = ((AdvertSchemaOut) other);
        return new EqualsBuilder().append(radius, rhs.radius).append(link, rhs.link).isEquals();
    }

}
