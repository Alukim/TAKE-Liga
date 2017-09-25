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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "team")
@XmlRootElement
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@XmlAttribute
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "city")
	String city;
	@Column(name = "league")
	String league;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "team", orphanRemoval = true)
	@JsonManagedReference(value="footballers")
	Set<Footballer> footballers = new LinkedHashSet<Footballer>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Match> matches = new LinkedHashSet<Match>();
	
	
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
	
	public void setFootballers(Set<Footballer> footballers){
		this.footballers = footballers;				
	}
	
	public Collection<Match> getMatches(){
		return matches;
	}
	
	public void setMatches(Set<Match> matches){
		this.matches = matches;
	}
}
