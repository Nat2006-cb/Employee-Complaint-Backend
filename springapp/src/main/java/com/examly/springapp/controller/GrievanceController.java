package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Grievance;
import com.examly.springapp.service.GrievanceService;


@RestController
public class GrievanceController {
    @Autowired
    GrievanceService grievanceService;
     
    @PostMapping("/api/grievances")
    public ResponseEntity<Grievance> create(@RequestBody Grievance grievance){
        Grievance res=grievanceService.create(grievance);
          if(res==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
          }else{
            return new ResponseEntity<>(res,HttpStatus.CREATED);
          }
    }
    @GetMapping("/api/grievances")
    public ResponseEntity<List<Grievance>> getData(@RequestBody Grievance grievance){
           List<Grievance> res=grievanceService.getData(grievance);
           if(res==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           else{
            return new ResponseEntity<>(res,HttpStatus.OK);
           }
    }
}

