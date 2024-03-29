package Controllers.Mathes;

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

import DTO.Match.MatchesListResponse;
import Entities.Match;
import Repositories.MatchRepository;

@Path("/matches")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MatchesController implements IMatchesController {

	@EJB
	MatchRepository repository;
	
	@Override
	@POST
	@Path("/")
	public Response create(Match match) {
		repository.create(match);
		return Response.status(Status.CREATED).entity(match.getId()).build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Match match) {
		try {
			match.setId(id);
			repository.update(match);
			return Response.status(Status.OK).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Path("/{id}")
	public Match getById(@PathParam("id") int id) {
		return repository.getMatchById(id);
	}

	@Override
	@GET
	@Path("/")
	public MatchesListResponse getList() {
		List<Match> matches = repository.getList();
		return new MatchesListResponse(matches);
	}

}
