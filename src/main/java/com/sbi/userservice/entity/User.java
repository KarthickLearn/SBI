package com.sbi.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank( message  = "First Name can't be blank!!")
    @Column(name="firstname")
    private String firstName;
    @NotBlank(message = "Last Name can't be blank!!!")
    @Column(name="lastname")
    private String lastName;
    @Email(message = "Email is incorrect!!!")
    private String email;
    @NotBlank(message = "username can't be blank!!!")
    private String username;
    @NotBlank(message = "password can't be blank!!")
    private String password;
    @Size(max = 10)
    @Column(name="phonenumber")
    private Long phoneNumber;

    @Column(name="accountnumber")
    @Size(min = 12,max = 12)
    private Long AccountNumber;


    private BigDecimal credit;

    private BigDecimal debit;

    @Column(name="createdat")
    private Instant createdAT;

    @Column(name = "updatedat")
    private Instant updatedAT;

}
