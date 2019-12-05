package com.autconnect.models;

import java.util.List;

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
@Table(name="bxs")
public class Bx {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long attention;
	private Long aggression;
	private Long escape; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="supervisor_id")
	
	private User supervisorBx;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="therapist_id")
	
	private User therapistBx;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="client_bx", 
        joinColumns = @JoinColumn(name="client_id"), 
        inverseJoinColumns = @JoinColumn(name="bx_id")
        )
    private List<Bx> bxs;
	
}
