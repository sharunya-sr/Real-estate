package com.broker.realEstate.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="email",unique = true)
    @Email(message = "invalid email format")
    @NotBlank(message = "email is required")
    String email;
    @NotBlank(message = "name is required")
    @Pattern(regexp = "^[A-Za-z ]+$")
    @Column(name = "full_name")
    String full_name;
    @Column(name = "password")
    @NotBlank
    @Pattern(  regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least 1 lowercase, 1 uppercase, 1 digit, 1 special character, and be at least 8 characters long")
    String password;

}

