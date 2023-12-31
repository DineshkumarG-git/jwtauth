package com.dinesh.security.service;

import com.dinesh.security.model.User;
import com.dinesh.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository ;
    public User  findByEmail(String email)
    {
        return    userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found " + email));

    }

    public  void addUser(User user)
    {
        userRepository.save(user) ;
    }


}
