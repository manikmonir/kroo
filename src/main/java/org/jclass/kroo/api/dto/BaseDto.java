package org.jclass.kroo.api.dto;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Manik
 */
@Data
//only active records
public abstract class BaseDto implements Serializable {

    private long id;
    private String name;
}
