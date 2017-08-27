package Controllers.Teams;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import DTO.Team.TeamsListResponse;
import Entities.Team;
import Repositories.TeamRepository;

@Path("/teams")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class TeamsController implements ITeamsController {

	@EJB
	TeamRepository repository;
	
	@Override
	@POST
	@Path("/")
	public Response create(Team team) {
		repository.create(team);
		return Response.status(Status.CREATED).entity(team).build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Team team) {
		try {
			team.setId(id);
			repository.update(team);
			return Response.status(Status.OK).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Path("/{id}")
	public Team getById(@PathParam("id") int id) {
		return repository.getTeamById(id);
	}

	@Override
	@GET
	@Path("/")
	public List<Team> getList() {
		return repository.getList();
	}

}
