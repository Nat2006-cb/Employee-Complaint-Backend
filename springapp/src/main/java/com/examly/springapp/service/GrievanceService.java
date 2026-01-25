package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Grievance;
import com.examly.springapp.repository.GrievanceRepository;

@Service
public class GrievanceService {
    @Autowired
    GrievanceRepository grievanceRepository;
     public Grievance create(Grievance grievance){
        try{
        return grievanceRepository.save(grievance);
        }
        catch(Exception e){
            return null;
        }
     }
     public List<Grievance> getData(Grievance grievance){
        return grievanceRepository.findAll();
     }
}
