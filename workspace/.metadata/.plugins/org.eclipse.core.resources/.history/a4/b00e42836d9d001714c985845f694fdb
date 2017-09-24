package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "Footballer")
@XmlRootElement
public class Footballer implements Serializable{
	private static final long serialVersionUID = 1l;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@XmlAttribute
	int id;
	@Column(name = "Name")
	String name;
	@Column(name = "Surname")
	String surname;
	@Column(name = "Age")
	int age;
	@Column(name = "Number")
	int number;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "TeamId")
	Team team;
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(targetEntity=Goal.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	Collection<Goal> goals = new LinkedHashSet<Goal>();
	
	
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
	
	public void setGoals(Collection<Goal> goals){
		this.goals = goals;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}
	
	public Team getTeam(){
		return this.team;
	}
}
