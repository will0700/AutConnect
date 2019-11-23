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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Please provide a First Name")
	private String firstName;
	@NotBlank(message="Please provide a Last Name")
	private String lastName;
	@NotBlank(message="Please provide an Email")
	@Email(message="Please provide a valid Email")
	private String email;
	@Size(min=8, message="Password must be longer than 8 characters")
	private String password;
	@Transient
	private String passwordConfirmation;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //Users to Clients
    @OneToMany(mappedBy="supervisor", fetch=FetchType.LAZY)
    private List<Client> clientsS;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="therapist_client", 
        joinColumns = @JoinColumn(name="therapist_id"), 
        inverseJoinColumns = @JoinColumn(name="client_id")
    )
    private List<Client> clientsT;
    
    @OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
    private List<Client> clientsP;
    
    //Users to Users
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name="supervisor_therapist", 
        joinColumns = @JoinColumn(name="supervisor_id"), 
        inverseJoinColumns = @JoinColumn(name="therapist_id")
    )
    private List<Client> supervisors;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name="supervisor_therapist", 
        joinColumns = @JoinColumn(name="therapist_id"), 
        inverseJoinColumns = @JoinColumn(name="supervisor_id")
    )
    private List<Client> therapists;
    
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
	public List<Client> getClientsS() {
		return clientsS;
	}
	public void setClientsS(List<Client> clientsS) {
		this.clientsS = clientsS;
	}
	public List<Client> getClientsT() {
		return clientsT;
	}
	public void setClientsT(List<Client> clientsT) {
		this.clientsT = clientsT;
	}
	public List<Client> getClientsP() {
		return clientsP;
	}
	public void setClientsP(List<Client> clientsP) {
		this.clientsP = clientsP;
	}
	public List<Client> getSupervisors() {
		return supervisors;
	}
	public void setSupervisors(List<Client> supervisors) {
		this.supervisors = supervisors;
	}
	public List<Client> getTherapists() {
		return therapists;
	}
	public void setTherapists(List<Client> therapists) {
		this.therapists = therapists;
	}
}
