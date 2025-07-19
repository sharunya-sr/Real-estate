package com.broker.realEstate.application.service;

import com.broker.realEstate.adapter.out.presistence.UserRepository;
import com.broker.realEstate.domain.entity.User;
import com.broker.realEstate.domain.exception.ConflictException;
import com.broker.realEstate.domain.port.in.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements RegisterUserUseCase {

public final UserRepository userRepository;


    @Override
    public void registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new ConflictException("email already exists");
        }
        else {
            userRepository.save(user);
        }
    }
}
