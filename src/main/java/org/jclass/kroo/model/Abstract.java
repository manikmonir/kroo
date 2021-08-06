package org.jclass.kroo.model;

/**
 *
 * @author Manik
 */
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class Abstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
