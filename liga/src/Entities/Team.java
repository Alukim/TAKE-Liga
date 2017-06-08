package Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "Team")
@XmlRootElement
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String city;
	String league;
	Set<Footballer> footballers = new HashSet<Footballer>();
	Set<Match> matches = new HashSet<Match>();
	
	public Team(String name, String city, String league){
		this.name = name;
		this.city = city;
		this.league = league;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@XmlAttribute
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@Column(name = "Name")
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name = "City")
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	@Column(name = "League")
	public String getLeague(){
		return league;
	}
	
	public void setLeague(String leageu){
		this.league = leageu;
	}
	
	@OneToMany
	public Set<Footballer> getFootballers(){
		return footballers;
	}
	
	public void setFootballers(Set<Footballer> footballers){
		this.footballers = footballers;
	}
	
	@OneToMany
	public Set<Match> getMatches(){
		return matches;
	}
	
	public void setMatches(Set<Match> matches){
		this.matches = matches;
	}
}
