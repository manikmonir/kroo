package org.jclass.kroo.model;

import lombok.*;
import javax.persistence.*;

/**
 *
 * @author Manik
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUTH_ROLE")
public class AuthRole extends AbstractVersion {

    @Column(unique = true, length = 30)//ADMIN, USER
    private String code;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean active = Boolean.TRUE;

    @Column(name = "SL_NO")
    private Integer slNo;

}
