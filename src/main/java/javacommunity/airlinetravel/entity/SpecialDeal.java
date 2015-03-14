package javacommunity.airlinetravel.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpecialDeal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Airport departFrom;
	private Airport arriveAt;
	private BigDecimal cost;
	private String beginOn;
	private String endOn;

	public SpecialDeal(Airport departFrom, Airport arriveAt, BigDecimal cost,
			String beginOn, String endOn) {
		this.departFrom = departFrom;
		this.arriveAt = arriveAt;
		this.cost = cost;
		this.beginOn = beginOn;
		this.endOn = endOn;
	}

	public Airport getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(Airport departFrom) {
		this.departFrom = departFrom;
	}

	public Airport getArriveAt() {
		return arriveAt;
	}

	public void setArriveAt(Airport arriveAt) {
		this.arriveAt = arriveAt;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getBeginOn() {
		return beginOn;
	}

	public void setBeginOn(String beginOn) {
		this.beginOn = beginOn;
	}

	public String getEndOn() {
		return endOn;
	}

	public void setEndOn(String endOn) {
		this.endOn = endOn;
	}

}
