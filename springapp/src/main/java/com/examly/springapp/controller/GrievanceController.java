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

import com.examly.springapp.model.Grievance;
import com.examly.springapp.service.GrievanceServiceImpl;

@RestController
@RequestMapping("/api")
public class GrievanceController {
    @Autowired 
    GrievanceServiceImpl grievanceServiceImpl;

    @PostMapping("/grievances")
    public ResponseEntity<Grievance> create(@RequestBody Grievance grievance){
        Grievance res=grievanceServiceImpl.create(grievance);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.CREATED);
        }
    }

    @GetMapping("/grievances")
    public ResponseEntity<List<Grievance>> getData(){
        List<Grievance> res=grievanceServiceImpl.getData();
        if(res.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }

    @GetMapping("/grievances/{id}")
    public ResponseEntity<Grievance> getid(@PathVariable Long id){
        Grievance res=grievanceServiceImpl.getid(id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @PutMapping("/grievances/{id}")
    public ResponseEntity<Grievance> update(@RequestBody Grievance grievance,@PathVariable Long id){
        Grievance res=grievanceServiceImpl.update(grievance,id);
        if(res==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @DeleteMapping("/grievances/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        Boolean res=grievanceServiceImpl.delete(id);
        if(res){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
