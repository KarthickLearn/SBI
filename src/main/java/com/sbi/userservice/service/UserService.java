package com.sbi.userservice.service;

import com.sbi.userservice.dto.UserRequest;
import com.sbi.userservice.entity.User;
import com.sbi.userservice.repo.UserRepo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User saveUserData(UserRequest userRequest) {

        User user = userRepo.save(mapToUser(userRequest));


        return user;
    }

    private User mapToUser(UserRequest userRequest) {
     return     User.builder()
                .email(userRequest.getEmail())
                .debit(BigDecimal.valueOf(0.00))
                .credit(BigDecimal.valueOf(0.00))
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .password(userRequest.getPassword())
                .createdAT(Instant.now())
                .updatedAT(Instant.now())
                .AccountNumber((long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L)
                .username(userRequest.getUsername()).build();



    }
}
