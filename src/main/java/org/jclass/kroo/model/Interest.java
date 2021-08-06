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
@Table(name = "INTEREST")
public class Interest extends AbstractVersion {

    @Embedded
    private Nameable nameable;

    @Column(name = "IMAGE_PATH", nullable = false)
    private String imagePath;

}