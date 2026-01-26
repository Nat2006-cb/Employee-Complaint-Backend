package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

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
    public List<Comment> getList(){
        return commentRepository.findAll();
    }
    public Comment getid(Long id){
        Optional<Comment>res=commentRepository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        else{
            return null;
        }
    }
    public Comment update(Comment comment,Long id){
        if(commentRepository.existsById(id)){
            comment.setCommentId(id);
            return commentRepository.save(comment);
        }
        else{
            return null;
        }
    }
    public Boolean delete(Long id){
        Optional<Comment> res=commentRepository.findById(id);
        if(res.isPresent()){
            commentRepository.delete(res.get());
            return true;
        }
        else{
            return false;
        }
    }
}
