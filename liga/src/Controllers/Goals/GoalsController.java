package Controllers.Goals;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import DTO.Goal.GoalsListResponse;
import Entities.Goal;

@Path("/goals")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class GoalsController implements IGoalsController{

	@Override
	public Response create(Goal team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response update(int id, Goal team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goal getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoalsListResponse getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
