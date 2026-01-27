package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    public User create(User user){
        try{
            return userRepository.save(user);
        }
        catch(Exception e){
            return null;
        }
    }
    public List<User> getData(){
        return userRepository.findAll();
    }
    public User getid(Long id){
        Optional<User> res=userRepository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        else{
            return null;
        }
    }
    public User update(User user,Long id){
        if(userRepository.existsById(id)){
            user.setUserId(id);
            return userRepository.save(user);
        }
        else{
            return null;
        }
    }
    public Boolean delete(Long id){
        Optional<User> res=userRepository.findById(id);
        if(res.isPresent()){
            userRepository.delete(res.get());
            return true;
        }
        else{
            return false;
        }
    }
}
