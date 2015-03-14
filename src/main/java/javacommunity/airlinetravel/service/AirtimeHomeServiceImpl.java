package javacommunity.airlinetravel.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import javacommunity.airlinetravel.entity.Airport;
import javacommunity.airlinetravel.entity.SpecialDeal;

@Service
public class AirtimeHomeServiceImpl implements AirtimeHomeService{

	public List<SpecialDeal> getAllSpecialDeals() {
		
		return createSpecialDeal();
	}
	
	private List<SpecialDeal> createSpecialDeal() {
		List<SpecialDeal> deals = new ArrayList<SpecialDeal>();
		
		
		for (int i = 1; i < 11; i++) {
			Airport depart = new Airport("airport depart" + i, ""+i);
			Airport arrive = new Airport("airport arrive " + i, ""+ i);
			SpecialDeal deal = new SpecialDeal(depart,arrive,new BigDecimal(i*100),"0"+i,"0"+i + 1);
			deals.add(deal);
		}
		
		return deals;
	}

}
