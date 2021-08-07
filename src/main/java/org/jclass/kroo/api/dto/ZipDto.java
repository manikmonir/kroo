package org.jclass.kroo.api.dto;

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
public class ZipDto extends BaseDto{
   
    private String code;//this is real zip code, 
}

