package javacommunity.airlinetravel.controller;

import javacommunity.airlinetravel.form.FlightForm;
import javacommunity.airlinetravel.form.FlightSearchForm;
import javacommunity.airlinetravel.service.AirtravelService;
import javacommunity.airlinetravel.validator.FlightFormValidator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AirlineHomeController {

    @Autowired
    private AirtravelService airtravelService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("specialdeals", airtravelService.getAllSpecialDeals());
        model.addAttribute("flightSearchForm", new FlightSearchForm());
        return "home";
    }

    @RequestMapping(value = "/flight", method = RequestMethod.GET)
    public String showFightNumberDetails(Model model, @RequestParam String flightNumber) {
        model.addAttribute("flightDetail", airtravelService.findFlightById(flightNumber));
        System.out.println("FlightNumber " + flightNumber);
        return "flightdetails";
    }

    @RequestMapping(value = "/flight/searchFlights", method = RequestMethod.POST)
    public String findFlightByNameOfFromAirport(Model model, FlightSearchForm flightSearchForm, BindingResult result) {
        model.addAttribute("specialdeals", airtravelService.findSpecialDealByAirportName(flightSearchForm.getAirportFromName()));
        return "home";
    }

    @RequestMapping(value = "/flight/initAddFlight", method = RequestMethod.GET)
    public String initAddFlight(Model model, FlightSearchForm flightSearchForm, BindingResult result) {
        model.addAttribute("airports", airtravelService.getAirports());
        model.addAttribute("flightForm", new FlightForm());
        return "add-flight";
    }
    
    @Autowired
    private FlightFormValidator flightFormValidator;

    @RequestMapping(value = "/flight/addFlight", method = RequestMethod.POST)
    public String addFlight(Model model,  FlightForm flightForm, BindingResult result) {
    	flightFormValidator.validate(flightForm, result);
        if (result.hasErrors()) {
            model.addAttribute("airports", airtravelService.getAirports());
            model.addAttribute("flightForm", flightForm);
            model.addAttribute("errors", result.getAllErrors());
            return "add-flight";
        }
        airtravelService.addFlight(flightForm);
        return "forward:/";
    }

    
    //
    // @ModelAttribute("specialdeals")
    // public List<SpecialDeal> specialDealModel() {
    // return airtravelService.getAllSpecialDeals();
    // }

}
