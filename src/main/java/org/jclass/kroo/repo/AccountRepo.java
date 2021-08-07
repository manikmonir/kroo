package org.jclass.kroo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.jclass.kroo.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manik
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    Account findByMobileNo(String mobileNo);

    @Query("SELECT m FROM Account m WHERE m.mobileNo=:code OR m.email=:code")
    Account findForLogin(String code);

}
