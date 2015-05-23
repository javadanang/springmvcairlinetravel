package javacommunity.airlinetravel.dao.repository;

import java.util.ArrayList;
import java.util.List;

import javacommunity.airlinetravel.dao.entity.Airport;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class AirportSearchSpecificator {
    
    public static  Specification<Airport> build(final String name, final String code) {
        return new Specification<Airport>() {

            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.add(cb.like(root.get("name"), "%"+name+"%"));
                if (!StringUtils.isEmpty(code)) {
                    predicates.add(cb.like(root.get("code"), code));    
                }
                
                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }

}
