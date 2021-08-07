package org.jclass.kroo.repo;

/**
 *
 * @author Manik
 */
import org.jclass.kroo.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepo extends JpaRepository<AuthUser, Long> {

    //List<AuthUser> findAllByActive(boolean active);

}
