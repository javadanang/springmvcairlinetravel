package javacommunity.airlinetravel.controller;

import java.util.List;

import javacommunity.airlinetravel.entity.SpecialDeal;
import javacommunity.airlinetravel.service.AirtimeHomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AirlineHomeController {

	@Autowired
	AirtimeHomeService airtimeHomeService;
	
	@RequestMapping("/")	
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value ="/flight",method = RequestMethod.GET )
	public String showFightNumberDetails(Model model,@RequestParam String flightNumber) {
		//Implement Special Flight
		System.out.println("FlightNumber " + flightNumber );
		return "flightdetails";
	}
	
	@RequestMapping(value ="/flight/{flightNumber}", method = RequestMethod.GET)
	public String showSecondFightNumberDetails(Model model, @PathVariable String flightNumber) {
		//Next Implement Special Flight
		
		return "flightdetails";
	}
	
	@ModelAttribute("specialdeals")
	public List<SpecialDeal> specialDealModel () {
		return airtimeHomeService.getAllSpecialDeals();
	} 
	
}
