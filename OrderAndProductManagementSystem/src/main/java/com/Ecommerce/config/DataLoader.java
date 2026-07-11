package com.Ecommerce.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Ecommerce.Entity.User;
import com.Ecommerce.Repository.UserRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {

        if(userRepository.findByUsername("admin").isEmpty()){

            User admin = new User();

            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setRole("ADMIN");

            userRepository.save(admin);
        }

    }
}
