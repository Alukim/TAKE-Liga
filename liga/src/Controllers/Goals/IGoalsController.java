package Controllers.Goals;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import DTO.Goal.GoalsListResponse;
import Entities.Goal;

@Local
public interface IGoalsController {
	public abstract Response create(Goal team);
	public abstract Response update(int id, Goal team);
	public abstract Goal getById(int id);
	public abstract List<Goal> getList();
}
