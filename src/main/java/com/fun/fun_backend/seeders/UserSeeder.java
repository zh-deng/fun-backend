package com.fun.fun_backend.seeders;

import com.fun.fun_backend.model.User;
import com.fun.fun_backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSeeder {

    private final UserRepository userRepository;

    public UserSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    @Transactional
    public void seed() {
        if(userRepository.count() == 0) {
            User user1 = new User("Maxi", "maxi@gmail.com");
            User user2 = new User("Sarah", "sarah@gmail.com");

            userRepository.saveAll(List.of(user1, user2));
            System.out.println("Successfully seeded 2 test users");
        }
    }
}
