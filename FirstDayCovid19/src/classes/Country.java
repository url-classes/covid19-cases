/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties; // para seleccionar algunas propiedades del JSON
import org.codehaus.jackson.annotate.JsonProperty; // para hacer match con las propiedades elegidas

/**
 *
 * @author Miguel Matul <https://github.com/MigueMat4>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String country_code;
    @JsonProperty("Cases")
    private int cases;
    @JsonProperty("Date")
    private String date;
        
    public Country() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountryCode(String CountryCode) {
        this.country_code = CountryCode;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return String.valueOf(cases) + " en " + country + " el ";
    }
}
