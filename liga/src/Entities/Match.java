package Entities;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "match")
@XmlRootElement
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@XmlAttribute
	int id;
	
	@Column(name = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm") 
	Date date;
	
	@Column(name = "city")
	String city;
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "match", orphanRemoval = true)
	@JsonManagedReference(value="match")
	Set<Goal> goals = new HashSet<Goal>();
	
	@ManyToOne
	@JoinColumn(name = "HostId")
	@JsonBackReference(value = "HostId")
	Team host;
	
	@ManyToOne
	@JoinColumn(name = "GuestId")
	@JsonBackReference(value = "GuestId")
	Team guest;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(String dateString) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		this.date = format.parse(dateString);
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
	
	public void setGoals(Set<Goal> goals){
		this.goals = goals;
	}

}
