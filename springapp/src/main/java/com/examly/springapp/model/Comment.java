package com.examly.springapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String content;
    private Boolean isInternal;
    private LocalDateTime createdAt;
    @ManyToOne 
    @JoinColumn(name = "grievance_id")
    private Grievance grievance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(){
        
    }
    public Comment(String content, Boolean isInternal, LocalDateTime createdAt, Grievance grievance, User user) {
        this.content = content;
        this.isInternal = isInternal;
        this.createdAt = createdAt;
        this.grievance = grievance;
        this.user = user;
    }
    public Long getCommentId() {
        return commentId;
    }
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Boolean getIsInternal() {
        return isInternal;
    }
    public void setIsInternal(Boolean isInternal) {
        this.isInternal = isInternal;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Grievance getGrievance() {
        return grievance;
    }
    public void setGrievance(Grievance grievance) {
        this.grievance = grievance;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    } 
}
    
