package com.app.stockapp.Controller;

import com.app.stockapp.entity.User;
import com.app.stockapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User registerUser) throws Exception{
        String message = userService.signUp(registerUser);
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
