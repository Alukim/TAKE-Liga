package DTO.Goal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import Entities.Goal;

@XmlRootElement
public class GoalsListResponse {
	private List<Goal> goals = new ArrayList<Goal>();
	
	public GoalsListResponse(List<Goal> goals) {
		super();
		this.goals = goals;
	}
	
	public GoalsListResponse() {}
	
	public List<Goal> getGoals() {
		return goals;
	}
	
	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}
}
