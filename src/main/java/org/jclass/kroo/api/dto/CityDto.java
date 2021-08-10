package org.jclass.kroo.api.dto;

import java.util.List;
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
public class CityDto extends BaseDto {

    private List<BaseDto> zips;
}
