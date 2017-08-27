package Entities;
import java.io.Serializable;
import java.time.*;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "Match")
@XmlRootElement
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	LocalDate date;
	LocalTime time;
	String city;
	Set<Goal> goals = new HashSet<Goal>();
	Team host;
	Team guest;
	
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
	
	@Column(name = "Date")
	public LocalDate getDate(){
		return date;
	}
	
	public void setDate(LocalDate date){
		this.date = date;
	}
	
	
	@Column(name = "Time")
	public LocalTime getTime(){
		return time;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "HostId")
	public Team getHostTeam() {
		return host;
	}
	
	public void setHostTeam(Team host){
		this.host = host;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "GuestId")
	public Team getGuestTeam() {
		return guest;
	}
	
	public void setGuestTeam(Team guest){
		this.guest = guest;
	}
	
	@Column(name = "City")
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	@OneToMany
	public Set<Goal> getGoals(){
		return goals;
	}
	
	public void setGoals(Set<Goal> goals){
		this.goals = goals;
	}

}
