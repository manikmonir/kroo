package org.jclass.kroo.model;

import javax.persistence.*;
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
@Entity
@Table(name = "INTEREST")
public class Interest extends AbstractVersion {

   @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean active = Boolean.TRUE;

    @Column(name = "SL_NO")
    private Integer slNo;
    
    @Column(name = "IMAGE_PATH", nullable = false)
    private String imagePath;

    public boolean equals(Object aa) {

        if (aa != null && aa instanceof Interest) {
            return this.getId().equals(((Interest) aa).getId());
        } else {
            return false;
        }
    }
}
