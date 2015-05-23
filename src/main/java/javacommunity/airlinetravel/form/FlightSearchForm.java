package javacommunity.airlinetravel.form;

import java.io.Serializable;

public class FlightSearchForm implements Serializable {

    private static final long serialVersionUID = -3149618679446727787L;

    private String airportFromName;
    private String airportToName;

    public String getAirportFromName() {
        return airportFromName;
    }

    public void setAirportFromName(String airportFromName) {
        this.airportFromName = airportFromName;
    }

    public String getAirportToName() {
        return airportToName;
    }

    public void setAirportToName(String airportToName) {
        this.airportToName = airportToName;
    }

  

}
