package org.jclass.kroo.model;

/**
 *
 * @author Manik
 */
import lombok.Data;
import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbstractVersion extends Abstract {

    @Version
    private Integer version;
}
