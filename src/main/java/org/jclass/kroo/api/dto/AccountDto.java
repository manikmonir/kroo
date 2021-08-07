package org.jclass.kroo.api.dto;

/**
 *
 * @author Manik
 */
import java.io.Serializable;
import lombok.*;

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

    private long interests[];

    private String password;

}
