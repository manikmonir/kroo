package org.jclass.kroo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Manik
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUTH_USER_LOG")
public class AuthUserLog extends CommonLog {

    @Column(name = "AUTH_USER_ID")
    private Long authUserId;//disjoint auth user id

}
