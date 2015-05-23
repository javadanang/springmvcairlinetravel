package javacommunity.airlinetravel.service;

import java.util.ArrayList;
import java.util.List;

import javacommunity.airlinetravel.dao.entity.Airport;
import javacommunity.airlinetravel.dao.entity.SpecialDeal;
import javacommunity.airlinetravel.dao.repository.AirportRepository;
import javacommunity.airlinetravel.dao.repository.SpecialDealRepository;
import javacommunity.airlinetravel.form.FlightForm;
import javacommunity.airlinetravel.form.LabelValueBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AirtravelServiceImpl implements AirtravelService {

    @Autowired
    private SpecialDealRepository specialDealRepository;
    @Autowired
    private AirportRepository airportRepository;

    public List<SpecialDeal> getAllSpecialDeals() {
        return specialDealRepository.findAll();
        // If we configure lazy load for SpecialDeal.AirportFrom or SpecialDeal.AirportTo
        // We have use JOIN FETCH to select related data
        // return specialDealRepository.findAllAndFetchAirport();
    }

    @Override
    public List<SpecialDeal> findSpecialDealByAirportName(String airportName) {
        return specialDealRepository.findByAirportFrom_NameContaining(airportName);
    }

    @Override
    public SpecialDeal findFlightById(String id) {
        return specialDealRepository.findOne(id);
    }

    @Override
    public List<LabelValueBean> getAirports() {
        // List<Airport> airports = airportRepository.findAll(AirportSearchSpecificator.build("", ""));
        List<Airport> airports = airportRepository.findAll();
      
        List<LabelValueBean> airportForSelectBeans = new ArrayList<LabelValueBean>();
        for (Airport airport : airports) {
            airportForSelectBeans.add(new LabelValueBean(airport.getId(), airport.getName()));
        }
        return airportForSelectBeans;
    }
   
    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addFlight(FlightForm flightForm) {
        SpecialDeal specialDeal = new SpecialDeal();
        specialDeal.setFlightNo(flightForm.getFlightNo());
        specialDeal.setAirportFrom(airportRepository.findOne(flightForm.getAirportFromId()));
        specialDeal.setAirportTo(airportRepository.findOne(flightForm.getAirportToId()));
        specialDeal.setCost(flightForm.getCost());
        specialDeal.setDepart(flightForm.getDepart());
        specialDeal.setArrive(flightForm.getArrive());
        specialDealRepository.save(specialDeal);
    }
}
