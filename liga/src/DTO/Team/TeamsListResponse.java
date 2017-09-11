package DTO.Team;

import java.util.ArrayList;
import java.util.List;

import Entities.Footballer;
import Entities.Team;

public class TeamsListResponse {
	private List<Team> teams = new ArrayList<Team>();
	 
	public TeamsListResponse() {}
	
	public TeamsListResponse(List<Team> teams){
		super();
		this.teams = teams;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
