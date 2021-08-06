package org.jclass.kroo.model;

/**
 *
 * @author Manik
 */
import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Nameable implements Serializable{

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive = Boolean.TRUE;

    @Column(name = "SL_NO")
    private Integer slNo;

}