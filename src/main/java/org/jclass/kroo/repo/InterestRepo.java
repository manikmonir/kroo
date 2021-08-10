package org.jclass.kroo.repo;

import java.util.List;
import org.jclass.kroo.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manik
 */
@Repository
public interface InterestRepo extends JpaRepository<Interest, Long> {

    @Query("SELECT m FROM Interest m WHERE m.active = true order by m.slNo, m.name")
    List<Interest> findAllCustom();

}
