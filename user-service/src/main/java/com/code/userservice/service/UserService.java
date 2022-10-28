package com.code.userservice.service;

import com.code.userservice.entity.User;
import com.code.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public User addUser(User user) {

        return userRepository.insert(user);
    }

    public User updateUser(User user) throws Exception {
        Optional<User> op = userRepository.findById(user.getId());
        if (op.isPresent()) {
            User user1 = op.get();
            userRepository.save(user);
            return user1;
        } else {
            throw new Exception();
        }
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(String id) {
        Optional<User> op = userRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
            return null;
        }

    }


    public String deleteUser(String id) {
        Optional<User> op = userRepository.findById(id);
        if (op.isPresent()) {
            userRepository.delete(op.get());
        }
            return null;


    }


}





