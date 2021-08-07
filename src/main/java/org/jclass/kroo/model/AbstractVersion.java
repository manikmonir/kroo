package org.jclass.kroo.model;

import lombok.Data;
import javax.persistence.*;

/**
 *
 * @author Manik
 */

@Data
@MappedSuperclass
public abstract class AbstractVersion extends Abstract {

    @Version
    private Integer version;
}
