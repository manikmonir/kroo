package org.jclass.kroo.model;

import java.io.Serializable;
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
@Embeddable
public class Nameable implements Serializable{

    @Column(name = "NAME", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean active = Boolean.TRUE;

    @Column(name = "SL_NO")
    private Integer slNo;

}