package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "footballer")
@XmlRootElement
public class Footballer implements Serializable{
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlAttribute
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "surname")
	String surname;
	
	@Column(name = "age")
	int age;
	
	@Column(name = "number")
	int number;
	
	@ManyToOne
	@JoinColumn(name = "teamId")
	@JsonBackReference(value = "footballers")
	Team team;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "footballer", orphanRemoval = true)
	@JsonManagedReference(value = "goals")
	Set<Goal> goals = new LinkedHashSet<Goal>();
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Collection<Goal> getGoals(){
		return goals;
	}
	
	public void setGoals(Set<Goal> goals){
		this.goals = goals;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}
	
	public Team getTeam(){
		return this.team;
	}
}
