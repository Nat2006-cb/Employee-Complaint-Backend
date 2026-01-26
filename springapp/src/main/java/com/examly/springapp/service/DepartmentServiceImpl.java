package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository deprepo;

    public Department create(Department dep){
        try{
            return deprepo.save(dep);
        }
        catch(Exception e){
            return null;
        }
    }
    public List<Department> getData(){
        return deprepo.findAll();
    }
    public Department getid(Long id){
         Optional<Department> res=deprepo.findById(id);
         if(res.isPresent()){
            return res.get();
         }
         else{
            return null;
         }
    }
   public Department update(Department dep,Long id){
    if(deprepo.existsById(id)){
        dep.setDepartmentId(id);
        return deprepo.save(dep);
    }
    else{
        return null;
    }
   }
   public Boolean delete(Long id){
    Optional<Department> res=deprepo.findById(id);
    if(res.isPresent()){
        deprepo.delete(res.get());
        return true;
    }
    else{
        return false;
    }
   }
}
