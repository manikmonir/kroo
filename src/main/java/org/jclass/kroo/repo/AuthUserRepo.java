package org.jclass.kroo.repo;

import org.jclass.kroo.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manik
 */

@Repository
public interface AuthUserRepo extends JpaRepository<AuthUser, Long> {

    //List<AuthUser> findAllByActive(boolean active);

}
