package Controllers.Teams;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import DTO.Team.TeamsListResponse;
import Entities.Team;

@Path("/teams")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class TeamsController implements ITeamsController {

	@Override
	public Response create(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response update(int id, Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamsListResponse getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
