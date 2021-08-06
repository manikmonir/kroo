package org.jclass.kroo.repo;

/**
 *
 * @author Manik
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.jclass.kroo.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {

    //List<Account> findAllByActive(boolean active);

}
