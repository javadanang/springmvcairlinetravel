package javacommunity.airlinetravel.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * The persistent class for the special_deal database table.
 * 
 */
@Entity
@Table(name = "special_deal")
@NamedQuery(name = "SpecialDeal.findAll", query = "SELECT s FROM SpecialDeal s")
public class SpecialDeal extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4123275285354930203L;

    @Id
    private String id = UUID.randomUUID().toString();

    private BigDecimal cost;
    @Column(name = "depart")
    private Date depart;

    @Column(name = "arrive")
    private Date arrive;
    @Column(name = "flight_no")
    private String flightNo;
    @ManyToOne()
    
    @JoinColumn(name = "airport_from")
    private Airport airportFrom;

    // bi-directional many-to-one association to Airport
    @ManyToOne()
    @JoinColumn(name = "airport_to")
    private Airport airportTo;

    public SpecialDeal() {
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Airport getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(Airport airportFrom) {
        this.airportFrom = airportFrom;
    }

    public Airport getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(Airport airportTo) {
        this.airportTo = airportTo;
    }

}