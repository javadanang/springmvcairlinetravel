package javacommunity.airlinetravel.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javacommunity.airlinetravel.validator.constrains.FlightNoConstrains;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class FlightForm implements Serializable {

	private static final long serialVersionUID = 803578416832812382L;
	 @NotBlank
	@FlightNoConstrains
	private String flightNo;
	@NotBlank
	private String airportFromId;
	@NotBlank
	private String airportToId;

	@NotNull
	private BigDecimal cost;
	@Future
	private Date depart;
	@NotNull
	private Date arrive;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirportFromId() {
		return airportFromId;
	}

	public void setAirportFromId(String airportFromId) {
		this.airportFromId = airportFromId;
	}

	public String getAirportToId() {
		return airportToId;
	}

	public void setAirportToId(String airportToId) {
		this.airportToId = airportToId;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getDepart() {
		return depart;
	}

	public void setDepart(Date depart) {
		this.depart = depart;
	}

	public Date getArrive() {
		return arrive;
	}

	public void setArrive(Date arrive) {
		this.arrive = arrive;
	}

}
