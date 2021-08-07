package org.jclass.kroo.model;
import java.time.LocalDateTime;
//import org.postgis.Point;
import javax.persistence.*;
import lombok.Data;
import org.springframework.data.geo.Point;

/**
 *
 * @author Manik
 */

@Data
@MappedSuperclass
public abstract class CommonLog extends Abstract {//no need version field

    @Column(name = "ON_MOMENT", nullable = false)
    private LocalDateTime onMoment = LocalDateTime.now();

    @Column(name = "LOGIN_ID", nullable = false)
    private String loginId;//attempt to login, usaually email (AuthUser/Account), mobile no for account

    @Column(name = "IP", length = 30)
    private String ip;

    @Column(name="GEO_LOCATION",columnDefinition = "Geometry")
    private Point geoLocation;//using org.postgis.Point

    @Column(name = "STATUS")//successfull login, failed login, successful logout etc
    private String status;

}
