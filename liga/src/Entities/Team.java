package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "Team")
@XmlRootElement
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@XmlAttribute
	int id;
	@Column(name = "Name")
	String name;
	@Column(name = "City")
	String city;
	@Column(name = "League")
	String league;
	
	@OneToMany(targetEntity=Footballer.class, fetch=FetchType.EAGER)
	Collection<Footballer> footballers = new LinkedHashSet<Footballer>();
	
	@OneToMany(targetEntity=Match.class, fetch=FetchType.EAGER)
	Collection<Match> matches = new LinkedHashSet<Match>();
	
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	
	public String getLeague(){
		return league;
	}
	
	public void setLeague(String leageu){
		this.league = leageu;
	}
	
	public Collection<Footballer> getFootballers(){
		return footballers;
	}
	
	public void setFootballers(Collection<Footballer> footballers){
		this.footballers = footballers;				
	}
	
	public Collection<Match> getMatches(){
		return matches;
	}
	
	public void setMatches(Collection<Match> matches){
		this.matches = matches;
	}
}
