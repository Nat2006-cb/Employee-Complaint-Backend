package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Comment;
import com.examly.springapp.service.CommentServiceImpl;

@RestController
public class CommentController {
    
    @Autowired
    CommentServiceImpl commentServiceImpl;

    @PostMapping("/api/comments")
    public ResponseEntity<Comment> create(@RequestBody Comment comment){
        Comment res=commentServiceImpl.create(comment);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }   
        else{
            return new ResponseEntity<>(res,HttpStatus.CREATED);
        }

    }
}
