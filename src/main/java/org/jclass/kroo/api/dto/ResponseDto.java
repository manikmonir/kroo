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
public class ResponseDto implements Serializable {

    private String message;
    private String status;//OK, ERROR etc
}
