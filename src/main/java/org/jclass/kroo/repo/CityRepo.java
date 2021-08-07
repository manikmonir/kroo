package org.jclass.kroo.repo;

import java.util.List;
import org.jclass.kroo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manik
 */

@Repository
public interface CityRepo extends JpaRepository<City, Long> {

    @Query("SELECT m FROM City m inner join m.zips d WHERE m.nameable.active = true and d.nameable.active=true order by m.nameable.slNo, m.nameable.name, d.code")
    List<City> findAllCustom();//findAllNameable_ActiveTrueOrderByNameable_SlNoAsc();

}
