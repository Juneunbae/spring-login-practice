package com.example.springloginpractice.Service;

import com.example.springloginpractice.Dto.UserDto;
import com.example.springloginpractice.Entity.User;
import com.example.springloginpractice.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void UserSave(UserDto create) {
        User newUser = User.builder()
            .email(create.email())
            .password(bCryptPasswordEncoder.encode(create.password()))
            .build();

        userRepository.save(newUser);
    }
}