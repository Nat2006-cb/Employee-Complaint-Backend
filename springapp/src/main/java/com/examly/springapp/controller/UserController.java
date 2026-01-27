package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired 
    UserServiceImpl userServiceImpl;

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user){
        User res=userServiceImpl.create(user);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.CREATED);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getData(){
        List<User> res=userServiceImpl.getData();
        if(res.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getid(@PathVariable Long id){
        User res=userServiceImpl.getid(id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@RequestBody User user,@PathVariable Long id){
        User res=userServiceImpl.update(user,id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        Boolean res=userServiceImpl.delete(id);
        if(res){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
