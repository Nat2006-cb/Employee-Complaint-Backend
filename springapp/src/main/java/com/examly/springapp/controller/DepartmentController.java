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

import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
     DepartmentServiceImpl depserv;

    @PostMapping("/departments")
    public ResponseEntity<Department> create(@RequestBody Department dep){
        Department res=depserv.create(dep);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.CREATED);
        }
    }
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getData(){
        List<Department> res=depserv.getData();
        if(res.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getid(@PathVariable Long id){
        Department res=depserv.getid(id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department>update(@RequestBody Department dep,@PathVariable Long id){
        Department res=depserv.update(dep,id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        Boolean res=depserv.delete(id);
        if(res){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
