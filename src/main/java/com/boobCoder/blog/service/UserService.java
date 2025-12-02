package com.boobCoder.blog.service;

import com.boobCoder.blog.entity.Blog;
import com.boobCoder.blog.entity.User;
import com.boobCoder.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogService blogService;

    public ResponseEntity<?> createUser(User user){
        User checkIfExist = userRepository.findByUserName(user.getUserName());
        if(checkIfExist != null){
            return new ResponseEntity<>("{\n" +
                    "  \"error\": \"User already exists\"\n" +
                    "}", HttpStatus.CONFLICT);
        }
        if(user !=null){
            if(user.getBlogList()!=null && !user.getBlogList().isEmpty()){
                for(Blog blog: user.getBlogList()){
                    blog.setUser(user);
                }
            }
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("user payload error", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> fetchAllUser(){
        if(!userRepository.findAll().isEmpty()){
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>("user table is Empty", HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> updateUser(User newUser, String userName){
        User userinDb = userRepository.findByUserName(userName);
        if(userinDb != null){
            userinDb.setId(newUser.getId());
            userinDb.setUserName(newUser.getUserName());
            userinDb.setPassword(newUser.getPassword());
            userRepository.save(userinDb);
            return new ResponseEntity<>(userinDb, HttpStatus.OK);
        }
        return new ResponseEntity<>("username is INVALID", HttpStatus.NOT_FOUND);
    }

}
