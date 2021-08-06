package org.jclass.kroo.model;

/**
 *
 * @author Manik
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CITY")
public class City extends AbstractVersion {

    @Embedded
    private Nameable nameable;

    @OneToMany(mappedBy = "city")
    @OrderBy(value = "code")
    private List<ZipCode> zipCodes = new ArrayList();

}