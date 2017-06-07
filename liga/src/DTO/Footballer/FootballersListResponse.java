package DTO.Footballer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import Entities.Footballer;

@XmlRootElement
public class FootballersListResponse {
	private List<Footballer> footballers = new ArrayList<Footballer>();

	public FootballersListResponse(List<Footballer> footballers) {
		super();
		this.footballers = footballers;
	}

	public FootballersListResponse() {	}
	
	public List<Footballer> getFootballers() {
		return footballers;
	}

	public void setFootballers(List<Footballer> footballers) {
		this.footballers = footballers;
	}
}
