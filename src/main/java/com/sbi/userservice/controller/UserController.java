package com.sbi.userservice.controller;

import com.sbi.userservice.dto.UserRequest;
import com.sbi.userservice.entity.User;
import com.sbi.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {


    private final UserService userservice;



    @PostMapping
    public ResponseEntity saveUserInfoToDB(@RequestBody UserRequest userRequest){

        User user = userservice.saveUserData(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
