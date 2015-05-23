package javacommunity.airlinetravel.dao.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the airport database table.
 * 
 */
@Entity
@NamedQuery(name="Airport.findAll", query="SELECT a FROM Airport a")
public class Airport extends BaseEntity implements Serializable {
	
    private static final long serialVersionUID = 2399995372973947130L;

    @Id
	private String id =UUID.randomUUID().toString();

	private String code;


	private String name;

	//bi-directional many-to-one association to SpecialDeal
	@OneToMany(mappedBy="airportFrom")
	private List<SpecialDeal> specialDealsFrom;

	//bi-directional many-to-one association to SpecialDeal
	@OneToMany(mappedBy="airportTo")
	private List<SpecialDeal> specialDealsTo;

	public Airport() {
	}

	public Airport(String id) {
	    this.id = id;
	}
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<SpecialDeal> getSpecialDealsFrom() {
        return specialDealsFrom;
    }

    public void setSpecialDealsFrom(List<SpecialDeal> specialDealsFrom) {
        this.specialDealsFrom = specialDealsFrom;
    }

    public List<SpecialDeal> getSpecialDealsTo() {
        return specialDealsTo;
    }

    public void setSpecialDealsTo(List<SpecialDeal> specialDealsTo) {
        this.specialDealsTo = specialDealsTo;
    }

	
	

}