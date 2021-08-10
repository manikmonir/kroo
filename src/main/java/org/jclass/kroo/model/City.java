package org.jclass.kroo.model;

import java.util.ArrayList;
import java.util.List;
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
@Table(name = "CITY")
public class City extends AbstractVersion {

    
    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean active = Boolean.TRUE;

    @Column(name = "SL_NO")
    private Integer slNo;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    //@OrderBy(value = "code")
    private List<Zip> zips = new ArrayList();

}