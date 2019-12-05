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
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	private String comment;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supervisor_id")
    private User supervisorMsg;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="therapist_id")
    private User therapistMsg;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private User parenttMsg;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="client_messages", 
        joinColumns = @JoinColumn(name="client_id"), 
        inverseJoinColumns = @JoinColumn(name="message_id")
        )
    	private List<Message> messages;
}
