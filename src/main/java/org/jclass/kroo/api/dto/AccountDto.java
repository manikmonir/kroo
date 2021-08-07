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

    private long cityId;

    private long zipId;

    private String email;

    private String password;

}