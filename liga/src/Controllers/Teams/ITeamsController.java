package Controllers.Teams;

import java.util.Collection;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import Entities.Team;

@Local
public interface ITeamsController {
	public abstract Response create(Team team);
	public abstract Response update(int id, Team team);
	public abstract Team getById(int id);
	public abstract Collection<Team> getList();
}
