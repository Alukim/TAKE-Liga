package Controllers.Footballers;

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

import DTO.Footballer.FootballersListResponse;
import Entities.Footballer;
import Repositories.FootballerRepository;

@Path("/footballers")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class FootballersController implements IFootballersController {
	
	@EJB
	FootballerRepository repository;
	
	@Override
	@POST
	@Path("/")
	public Response create(Footballer footballer) {
		repository.create(footballer);
		return Response.status(Status.CREATED).entity(footballer.getId()).build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Footballer footballer) {
		try {
			footballer.setId(id);
			repository.update(footballer);
			return Response.status(Status.OK).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	@Override
	@GET
	@Path("/{id}")
	public Footballer getById(@PathParam("id") int id) {
		Footballer footballer = repository.getFootballerById(id);
		return footballer;
	}

	@Override
	@GET
	@Path("/")
	public FootballersListResponse getList() {
		List<Footballer> listOfFootballers = repository.getList();
		FootballersListResponse footballers = new FootballersListResponse(listOfFootballers);
		return footballers;
	}
}
