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

    @Embedded
    private Nameable nameable;

}
