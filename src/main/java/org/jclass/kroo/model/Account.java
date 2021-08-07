package org.jclass.kroo.model;

import java.util.ArrayList;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Manik
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class Account extends AbstractVersion {

    @Column(name = "MOBILE_NO", unique = true, length = 14, nullable = false)
    private String mobileNo;

    @Column(name = "VERIFICATION_CODE", length = 6, nullable = false)
    private String verificationCode;

    @Column(name = "FIRST_NAME", length = 35, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 35, nullable = false)
    private String lastName;

    @JoinColumn(name = "CITY_ID", nullable = false)
    @ManyToOne(optional = false)
    private City city;

    @JoinColumn(name = "ZIP_ID", nullable = false)
    @ManyToOne(optional = false)
    private Zip zip;

    @Email
    @Column(length = 50, unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ACCOUNT_INTEREST",
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"ACCOUNT_ID", "INTEREST_ID"}
                )},
            joinColumns = {
                @JoinColumn(name = "ACCOUNT_ID", nullable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "INTEREST_ID", nullable = false)})
    private List<Interest> interests = new ArrayList<>();

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean active = Boolean.FALSE;

    @Column(name = "IS_VERIFIED", nullable = false)
    private boolean verified = Boolean.FALSE;

    @Column(name = "IMAGE_PATH")
    private String imagePath;

    @Column(name = "PASSWORD_HASH", length = 64)
    private String passwordHash;

    @Column(length = 64, nullable = false)
    private String password;

}
