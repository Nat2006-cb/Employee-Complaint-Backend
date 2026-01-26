package com.examly.springapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Grievance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grievanceId;
    private String title;
    private String description;
    private String priority;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private GrievanceCategory grievanceCategory;

    public Grievance(){

    }
    public Grievance(String title, String description, String priority, String status, LocalDateTime createdAt,
            LocalDateTime updatedAt, GrievanceCategory grievanceCategory) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.grievanceCategory = grievanceCategory;
    }
   
public Long getGrievanceId() {
    return grievanceId;
}
public void setGrievanceId(Long grievanceId) {
    this.grievanceId = grievanceId;
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
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
public LocalDateTime getCreatedAt() {
    return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}
public LocalDateTime getUpdatedAt() {
    return updatedAt;
}
public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
}
public GrievanceCategory getGrievanceCategory() {
    return grievanceCategory;
}
public void setGrievanceCategory(GrievanceCategory grievanceCategory) {
    this.grievanceCategory = grievanceCategory;
}  
    


}
