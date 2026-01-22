package com.examly.springapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Grievance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long complaintId; 
    private String title;
    private String description ;
    private String priority;

    public Grievance(){

    }
    public Grievance(String title, String description, String priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
    public long getComplaintId() {
        return complaintId;
    }
    public void setComplaintId(long complaintId) {
        this.complaintId = complaintId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    
}
