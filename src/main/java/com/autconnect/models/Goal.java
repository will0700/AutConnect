package com.autconnect.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="goals")
public class Goal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String goalQuestion;
	
	private boolean mastered;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="target_id")
    private Target target;
	
	@OneToMany(mappedBy="goal", fetch=FetchType.LAZY)
	private List<GoalDaily> goalDailies;
	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoalQuestion() {
		return goalQuestion;
	}

	public void setGoalQuestion(String goalQuestion) {
		this.goalQuestion = goalQuestion;
	}

	public boolean isMastered() {
		return mastered;
	}

	public void setMastered(boolean mastered) {
		this.mastered = mastered;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public List<GoalDaily> getGoalDailies() {
		return goalDailies;
	}

	public void setGoalDailies(List<GoalDaily> goalDailies) {
		this.goalDailies = goalDailies;
	}
	
}
