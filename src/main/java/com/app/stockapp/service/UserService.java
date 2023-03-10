package com.app.stockapp.service;

import com.app.stockapp.entity.User;
import com.app.stockapp.repository.UserRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepository;

    public String signUp(User registerUser){
        User queriedUser = userRepository.findByUsername(registerUser.getUsername());
//        System.out.println("Queried user "+Querieduser);
        if(queriedUser == null){
            User user = new User();
            user.setUsername(registerUser.getUsername());
            user.setEmail(registerUser.getEmail());
            user.setPassword(hashPassword(registerUser.getPassword()));
            userRepository.save(user);
            return (user.getEmail()+ " is registered");
        }
        else{
            return(queriedUser.getEmail()+ " already registered");
        }
    }

//    public String login(LoginUserDto loginUserDto){
//        User queriedUser = userRepository.findByUsername(loginUserDto.getUsername());
//        if(queriedUser == null) return "User does not exist";
//        else if(queriedUser != null && BCrypt.checkpw(loginUserDto.getPassword(),queriedUser.getPassword())) return "Login successful";
//        else return "Incorrect password";
//    }

    public String hashPassword(String plainTextPassword){
        String pwd = BCrypt.hashpw(plainTextPassword,BCrypt.gensalt());
        return pwd;
    }
}
