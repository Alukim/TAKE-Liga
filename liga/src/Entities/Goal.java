package Entities;

import java.io.Serializable;
import java.time.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "goal")
@XmlRootElement
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "time")
	LocalTime time;
	
	@Column(name = "teamName")
	String teamName;
	
	@ManyToOne
	@JoinColumn(name = "footballerId")
	@JsonBackReference(value = "goals")
	Footballer footballer;
	
	@ManyToOne(targetEntity=Match.class)
	@JoinColumn(name = "matchId")
	@JsonBackReference(value = "match")
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
