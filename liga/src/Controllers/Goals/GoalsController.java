package Controllers.Goals;

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

import DTO.Goal.GoalsListResponse;
import Entities.Goal;
import Repositories.GoalRepository;

@Path("/goals")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class GoalsController implements IGoalsController{

	@EJB
	GoalRepository repository;
	
	@Override
	@POST
	@Path("/")
	public Response create(Goal goal) {
		repository.create(goal);
		return Response.status(Status.CREATED).entity(goal.getId()).build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Goal goal) {
		
		try {
			goal.setId(id);
			repository.update(goal);
			return Response.status(Status.OK).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Path("/{id}")
	public Goal getById(@PathParam("id") int id) {
		return repository.getGoalById(id);
	}

	@Override
	@GET
	@Path("/")
	public GoalsListResponse getList() {
		List<Goal> goals = repository.getList();
		return new GoalsListResponse(goals);
	}

}
