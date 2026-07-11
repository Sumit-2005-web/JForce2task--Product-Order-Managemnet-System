package com.Ecommerce.Impl;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Ecommerce.Entity.User;
import com.Ecommerce.Exception.ResourceNotFoundException;
import com.Ecommerce.Repository.UserRepository;
import com.Ecommerce.Service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//
//    @Override
//    public User login(String username, String password) {
//
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("Invalid Username"));
//
//        if (!user.getPassword().equals(password)) {
//            throw new ResourceNotFoundException("Invalid Password");
//        }
//
//        return user;
//    }
	
    @Override
    public User login(String username, String password) {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        System.out.println("User found = " + optionalUser.isPresent());

        if(optionalUser.isPresent()){
            User u = optionalUser.get();
            System.out.println("Username = " + u.getUsername());
            System.out.println("Password = " + u.getPassword());
            System.out.println("Role = " + u.getRole());
        }

        if(optionalUser.isEmpty()){
            throw new ResourceNotFoundException("Invalid Username");
        }

        User user = optionalUser.get();

        if(!user.getPassword().equals(password)){
            throw new ResourceNotFoundException("Invalid Password");
        }

        return user;
    }
}
