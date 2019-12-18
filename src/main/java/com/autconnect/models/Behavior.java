package com.autconnect.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="behaviors")
public class Behavior {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long percentAggression;
	private String commentAggression;
	private Long percentAttention;
	private String commentAttention;
	private Long percentEscape;
	private String commentEscape;
	private String session;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;


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

	public Long getPercentAggression() {
		return percentAggression;
	}

	public void setPercentAggression(Long percentAggression) {
		this.percentAggression = percentAggression;
	}

	public String getCommentAggression() {
		return commentAggression;
	}

	public void setCommentAggression(String commentAggression) {
		this.commentAggression = commentAggression;
	}

	public Long getPercentAttention() {
		return percentAttention;
	}

	public void setPercentAttention(Long percentAttention) {
		this.percentAttention = percentAttention;
	}

	public String getCommentAttention() {
		return commentAttention;
	}

	public void setCommentAttention(String commentAttention) {
		this.commentAttention = commentAttention;
	}

	public Long getPercentEscape() {
		return percentEscape;
	}

	public void setPercentEscape(Long percentEscape) {
		this.percentEscape = percentEscape;
	}

	public String getCommentEscape() {
		return commentEscape;
	}

	public void setCommentEscape(String commentEscape) {
		this.commentEscape = commentEscape;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
}
