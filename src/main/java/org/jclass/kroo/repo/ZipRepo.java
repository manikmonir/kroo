package org.jclass.kroo.repo;

import org.jclass.kroo.model.Zip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manik
 */

@Repository
public interface ZipRepo extends JpaRepository<Zip, Long> {

}
