package Entities;
import java.io.Serializable;
import java.time.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "Match")
@XmlRootElement
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@XmlAttribute
	int id;
	@Column(name = "Date")
	LocalDate date;
	@Column(name = "Time")
	LocalTime time;
	@Column(name = "City")
	String city;
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(targetEntity=Goal.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	Collection<Goal> goals = new HashSet<Goal>();
	
	@ManyToOne(targetEntity=Team.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "HostId")
	Team host;
	
	@ManyToOne(targetEntity=Team.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "GuestId")
	Team guest;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public LocalDate getDate(){
		return date;
	}
	
	public void setDate(LocalDate date){
		this.date = date;
	}
	
	
	
	public LocalTime getTime(){
		return time;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}

	public Team getHostTeam() {
		return host;
	}
	
	public void setHostTeam(Team host){
		this.host = host;
	}

	public Team getGuestTeam() {
		return guest;
	}
	
	public void setGuestTeam(Team guest){
		this.guest = guest;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public Collection<Goal> getGoals(){
		return goals;
	}
	
	public void setGoals(Collection<Goal> goals){
		this.goals = goals;
	}

}
