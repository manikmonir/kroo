package org.jclass.kroo.api.dto;

import java.io.Serializable;
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

//only active records
public class BaseDto implements Serializable {

    private Long id;
    private String name;
}
