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
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "Goal")
@XmlRootElement
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	LocalTime time;
	String teamName;
	Footballer footballer;
	Match match;
	
	public Goal(String teamName, Match match, Footballer footballer, LocalTime time){
		this.teamName = teamName;
		this.match = match;
		this.footballer = footballer;
		this.time = time;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@XmlAttribute
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "FootballerId")
	public Footballer getFootballer() {
		return footballer;
	}
	
	public void setFootballer(Footballer footballer){
		this.footballer = footballer;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MatchId")
	public Match getMatch() {
		return match;
	}
	
	public void setMatch(Match match){
		this.match = match;
	}
	
	@Column(name = "Time")
	public LocalTime getTime(){
		return time;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	@Column(name = "TeamName")
	public String getTeamName(){
		return teamName;
	}
	
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
}
