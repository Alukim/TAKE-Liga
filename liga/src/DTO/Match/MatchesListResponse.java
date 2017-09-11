package DTO.Match;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import Entities.Footballer;
import Entities.Match;

@XmlRootElement
public class MatchesListResponse {
	private List<Match> matches = new ArrayList<Match>();
	
	public MatchesListResponse(List<Match> matches) {
		super();
		this.matches = matches;
	}
	
	public MatchesListResponse() { }
	
	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
}
