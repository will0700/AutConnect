package com.autconnect.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="clients")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Please provide a Client ID")
	private String clientID;
	@NotBlank(message="Please provide a First Initial")
	private String firstInitial;
	@NotBlank(message="Please provide a Last Initial")
	private String lastInitial;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supervisor_id")
    private User supervisor;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="therapist_clients", 
        joinColumns = @JoinColumn(name="client_id"), 
        inverseJoinColumns = @JoinColumn(name="therapist_id")
    )
    private List<User> therapists;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private User parent;
    
    @OneToMany(mappedBy="client", fetch=FetchType.LAZY)
    private List<Behavior> behaviors;
    
    
    //Getters and Setters
  	@PrePersist
  	protected void onCreate(){
  		this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getFirstInitial() {
		return firstInitial;
	}
	public void setFirstInitial(String firstInitial) {
		this.firstInitial = firstInitial;
	}
	public String getLastInitial() {
		return lastInitial;
	}
	public void setLastInitial(String lastInitial) {
		this.lastInitial = lastInitial;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(User supervisor) {
		this.supervisor = supervisor;
	}
	public List<User> getTherapists() {
		return therapists;
	}
	public void setTherapists(List<User> therapists) {
		this.therapists = therapists;
	}
	public User getParent() {
		return parent;
	}
	public void setParent(User parent) {
		this.parent = parent;
	}
}
