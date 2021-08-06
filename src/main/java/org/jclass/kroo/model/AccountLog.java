package org.jclass.kroo.model;

/**
 *
 * @author Manik
 */
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT_LOG")
public class AccountLog extends CommonLog {

    @Column(name = "ACCOUNT_ID")
    private Long accountId;//disjoint account id

    @Column(name = "DEVICE_ID", length = 30)
    private String deviceId;
    
}
