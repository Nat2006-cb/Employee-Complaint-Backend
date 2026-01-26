package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;

    public Comment create(Comment comment){
        try{
            return commentRepository.save(comment);
        }
        catch(Exception e){
            return null;
        }
    }
    
}
