package Controllers.Footballers;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import DTO.Footballer.FootballersListResponse;
import Entities.Footballer;

@Local
public interface IFootballersController {
	public abstract Response create(Footballer footballer);
	public abstract Response update(int id, Footballer footballer);
	public abstract Footballer getById(int id);
	public abstract FootballersListResponse getList();
}
