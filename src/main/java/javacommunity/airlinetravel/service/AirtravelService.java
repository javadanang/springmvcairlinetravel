package javacommunity.airlinetravel.service;

import java.util.List;

import javacommunity.airlinetravel.dao.entity.SpecialDeal;
import javacommunity.airlinetravel.form.FlightForm;
import javacommunity.airlinetravel.form.LabelValueBean;

public interface AirtravelService {

    List<LabelValueBean> getAirports();
    SpecialDeal findFlightById(String id);
    void addFlight(FlightForm flightForm);
    List<SpecialDeal> findSpecialDealByAirportName(String airportName);
	List<SpecialDeal> getAllSpecialDeals();
}
