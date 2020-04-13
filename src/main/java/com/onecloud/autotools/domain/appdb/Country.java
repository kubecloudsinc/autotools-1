
package com.onecloud.autotools.domain.appdb;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COUNTRIES")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Country {

    private static final long serialVersionUID = 2993569267760500809L;

    private String countryId;
    private String countryName;

    @Id
    @Column(name="COUNTRY_ID", length = 2, nullable = false, columnDefinition = "char")
    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Size(max = 40)
    @Column(name="COUNTRY_NAME", length = 40, nullable = false)
    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (this.getCountryName() == null) {
            return false;
        } else if (o instanceof Country) {
            Country that = (Country) o;
            return this.getCountryName().equals(that.getCountryName());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getCountryName() == null ? System.identityHashCode(this) : 17 * this.getCountryName()
                .hashCode();
    }

    @Override
    public String toString() {
        return this.getCountryName();
    }
}