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

    @Embedded
    private Nameable nameable;

    @JoinColumn(name = "CITY_ID", nullable = false)
    @ManyToOne(optional = false)
    private City city;

}
