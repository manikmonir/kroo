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
@Table(name = "ZIP")
public class Zip extends Abstract {//no need version field

    @Column(length = 10, nullable = false, unique = true)
    private String code;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean active = Boolean.TRUE;

    @Column(name = "SL_NO")
    private Integer slNo;
    
    @JoinColumn(name = "CITY_ID", nullable = false)
    @ManyToOne(optional = false)
    private City city;

}
