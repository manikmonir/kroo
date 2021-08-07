package org.jclass.kroo.api.dto;

import java.io.Serializable;
import lombok.*;

/**
 *
 * @author  Manik
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountInterestDto implements Serializable {

    private String mobileNo;

    private long interests[];

}
