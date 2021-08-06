package org.jclass.kroo.model;

/**
 *
 * @author Manik
 */
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class CommonLog extends Abstract {//no need version field

    @Column(name = "ON_MOMENT", nullable = false)
    private LocalDateTime onMoment=LocalDateTime.now();

    @Column(name = "LOGIN_ID", nullable = false)
    private String loginId;//attempt to login, usaually email (AuthUser/Account), mobile no for account

    @Column(name = "IP", length = 30)
    private String ip;

    @Column(name = "STATUS")//successfull login, failed login, successful logout etc
    private String status;

}
