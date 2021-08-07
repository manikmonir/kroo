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
public class AccountDto implements Serializable {

    private String mobileNo;

    private String firstName;

    private String lastName;

    private Long cityId;

    private Long zipId;

    private String email;

    private String password;

}