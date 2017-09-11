package Controllers.Mathes;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import DTO.Match.MatchesListResponse;
import Entities.Match;

@Local
public interface IMatchesController {
	public abstract Response create(Match match);
	public abstract Response update(int id, Match match);
	public abstract Match getById(int id);
	public abstract MatchesListResponse getList();
}
