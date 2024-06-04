package com.example.bai2.configuration;

import com.example.bai2.entity.User;
import com.example.bai2.enums.Role;
import com.example.bai2.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
@RequiredArgsConstructor
@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;
    @Bean
    ApplicationRunner applicationRunner (UserRepository userRepository){

     return args -> {
         if(userRepository.findByUsername("admin").isEmpty()){
                    var roles = new HashSet<String>();
                    roles.add(Role.ADMIN.name());
                   User user  = User.builder()
                           .username("admin")
                           .password(passwordEncoder.encode("admin"))
//                           .roles(roles)
                           .build();
                   userRepository.save(user);
                   log.warn("Create admin user");
         }
     };

    }
}
