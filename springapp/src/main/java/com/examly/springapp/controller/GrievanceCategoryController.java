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

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.service.GrievanceCategoryService;
import com.examly.springapp.service.GrievanceCategoryServiceImpl;

@RestController
@RequestMapping("/api")
public class GrievanceCategoryController {
    @Autowired
    GrievanceCategoryServiceImpl grievanceCategoryService;

    @PostMapping("/grievance-categories")
    public ResponseEntity<GrievanceCategory> create(@RequestBody GrievanceCategory grievanceCategory){
        GrievanceCategory res=grievanceCategoryService.create(grievanceCategory);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.CREATED);
        }
    }
    @GetMapping("/grievance-categories")
    public ResponseEntity<List<GrievanceCategory>> getData(){
        List<GrievanceCategory> res=grievanceCategoryService.getData();
        if(res.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @GetMapping("/grievance-categories/{id}")
    public ResponseEntity<GrievanceCategory> getid(@PathVariable Long id){
        GrievanceCategory res=grievanceCategoryService.getid(id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @PutMapping("/grievance-categories/{id}")
    public ResponseEntity<GrievanceCategory> update(@RequestBody GrievanceCategory grievanceCategory,@PathVariable Long id){
        GrievanceCategory res=grievanceCategoryService.update(grievanceCategory,id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @DeleteMapping("/grievance-categories/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        Boolean res=grievanceCategoryService.delete(id);
        if(res){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
