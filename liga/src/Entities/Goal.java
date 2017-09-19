package Entities;

import java.io.Serializable;
import java.time.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "Goal")
@XmlRootElement
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "goal_time")
	LocalTime time;
	
	@Column(name = "goal_teamname")
	String teamName;
	
	@ManyToOne
	@JoinColumn(name = "FootballerId")
	Footballer footballer;
	
	@ManyToOne(targetEntity=Match.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "MatchId")
	Match match;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public Footballer getFootballer() {
		return footballer;
	}
	
	public void setFootballer(Footballer footballer){
		this.footballer = footballer;
	}
	
	public Match getMatch() {
		return match;
	}
	
	public void setMatch(Match match){
		this.match = match;
	}
	
	
	public LocalTime getTime(){
		return time;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	public void setTime(String time){
		this.time = LocalTime.parse(time);
	}
	
	
	public String getTeamName(){
		return teamName;
	}
	
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
}
