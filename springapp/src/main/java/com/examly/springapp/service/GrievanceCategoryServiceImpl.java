package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.repository.GrievanceCategoryRepository;

@Service
public class GrievanceCategoryServiceImpl implements GrievanceCategoryService{
    @Autowired
    GrievanceCategoryRepository grievanceCategoryRepository;

    public GrievanceCategory create(GrievanceCategory grievanceCategory){
         try{
            return grievanceCategoryRepository.save(grievanceCategory);
         }
         catch(Exception e){
            return null;
         }
    }
    public List<GrievanceCategory>  getData(){
        return grievanceCategoryRepository.findAll();
    }
    public GrievanceCategory getid(Long id){
    Optional<GrievanceCategory> res=grievanceCategoryRepository.findById(id);
       if(res.isPresent()){
         return res.get();
       }
       else{
        return null;
       } 
    }
    public GrievanceCategory update(GrievanceCategory grievanceCategory,Long id){
        if(grievanceCategoryRepository.existsById(id)){
          grievanceCategory.setCategoryId(id);
          return grievanceCategoryRepository.save(grievanceCategory);
        }
        else{
            return null;
        }
    }
    public Boolean delete(Long id){
      Optional<GrievanceCategory> res=grievanceCategoryRepository.findById(id);
      if(res.isPresent()){
        grievanceCategoryRepository.delete(res.get());
        return true;
      }
      else{
        return false;
      }
    }
}
