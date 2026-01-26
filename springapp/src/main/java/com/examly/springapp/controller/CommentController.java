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
    @GetMapping("/api/comments")
    public ResponseEntity<List<Comment>> getList(){
          List<Comment> res=commentServiceImpl.getList();
          if(res.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          else{
            return new ResponseEntity<>(res,HttpStatus.OK);
          }
    }
    @GetMapping("/api/comments/{id}")
    public ResponseEntity<Comment> getid(@PathVariable Long id){
        Comment res=commentServiceImpl.getid(id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @PutMapping("/api/comments/{id}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment,@PathVariable Long id){
        Comment res=commentServiceImpl.update(comment,id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        Boolean res=commentServiceImpl.delete(id);
        if(res){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
