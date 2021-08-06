package org.jclass.kroo.model;

/**
 *
 * @author Manik
 */
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ZIP_CODE")
public class ZipCode extends Abstract {//no need version field

    @Column(length = 10, nullable = false)
    private String code;

    @Embedded
    private Nameable nameable;

    @JoinColumn(name = "CITY_ID", nullable = false)
    @ManyToOne(optional = false)
    private City city;

}
