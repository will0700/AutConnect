package com.autconnect.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="targetGoals")
public class TargetGoal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    private String target;
    private String goal;
    private Long percentage;
    private String tGcomment; 
}
