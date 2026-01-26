package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Grievance;
import com.examly.springapp.repository.GrievanceRepository;

@Service
public class GrievanceServiceImpl implements GrievanceService{
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
    public List<Grievance> getData(){
        return grievanceRepository.findAll();
    }
    public Grievance getid(Long id){
        Optional<Grievance> res=grievanceRepository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        else{
            return null;
        }
    }
    public Grievance update(Grievance grievance,Long id){
        if(grievanceRepository.existsById(id)){
            grievance.setGrievanceId(id);
            return grievanceRepository.save(grievance);
        }
        else{
            return null;
        }
    }
    public Boolean delete(Long id){
        Optional<Grievance> res=grievanceRepository.findById(id);
        if(res.isPresent()){
            grievanceRepository.delete(res.get());
            return true;
        }
        else{
            return false;
        }
    }
}
