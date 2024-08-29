package org.example.poweruser.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "power_user")
@Entity
public class PowerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @NotBlank(message = "FirstName must not be null")
    @Length(min = 6, max = 50, message = "")
    @Column(name = "first_name")
    @Length(min = 3, max = 20, message = "First name must not be less than 3 and more than 20. Please enter a valid name")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "lastName must not be null")
    @Length(min = 6, max = 30, message = "last name must not be less than 6 and more than 30")
    private String lastName;
    @Column(name = "address")
    private String address;
    private String password;
    @Column(name = "phone_number")
    @Pattern(regexp = "[0-9]{11}")
    private String phoneNumber;
}
