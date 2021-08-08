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

    @Embedded
    private Nameable nameable;

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
