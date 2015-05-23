package javacommunity.airlinetravel.dao.repository;

import javacommunity.airlinetravel.dao.entity.Airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AirportRepository extends JpaRepository<Airport, String>, JpaSpecificationExecutor<Airport> {

    Airport findFirstByCode(String code);
}
