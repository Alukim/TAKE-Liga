package Controllers.Mathes;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import DTO.Match.MatchesListResponse;
import Entities.Match;

@Path("/matches")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MatchesController implements IMatchesController {

	@Override
	public Response create(Match match) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response update(int id, Match match) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Match getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchesListResponse getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
