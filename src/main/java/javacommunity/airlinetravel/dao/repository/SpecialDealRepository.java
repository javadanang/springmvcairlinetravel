package javacommunity.airlinetravel.dao.repository;

import java.util.List;

import javacommunity.airlinetravel.dao.entity.SpecialDeal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpecialDealRepository extends JpaRepository<SpecialDeal, String>{

    List<SpecialDeal> findByAirportFrom_NameContaining(String name);
    @Query("SELECT s FROM SpecialDeal s JOIN FETCH s.airportTo JOIN FETCH s.airportFrom ")
    List<SpecialDeal> findAllAndFetchAirport();
}
