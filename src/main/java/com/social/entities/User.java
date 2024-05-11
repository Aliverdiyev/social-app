package com.social.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "username must not be empty")
    @Size(min = 2, max = 20, message = "required username must be min 2, max 20 character")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "firstname must not be empty")
    @Size(min = 2, max = 20, message = "required username must be min 2, max 20 character")
    private String firstName;

    @NotBlank(message = "lastname must not be empty")
    @Size(min = 2, max = 20, message = "required username must be min 2, max 20 character")
    private String lastName;

    @NotBlank(message = "email must not be empty")
    @Column(unique = true)
    @Email
    private String email;

    @NotBlank(message = "email must not be empty")
    @Pattern(regexp = "^(?=,*[a-z])(?=,*[A-Z])(?=,*\\d).{8,}$",
            message = "password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit with a min length of 8 characters ")
    private String password;

    @NotNull(message = "birthday must not be empty")
    @Column(columnDefinition = "DATE")
    private LocalDate birthday;

/*
    private String phone;
    private String address;
    private String city;
    private String country;
*/
}