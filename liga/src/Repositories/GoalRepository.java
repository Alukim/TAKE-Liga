package Repositories;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Entities.Goal;

@Stateless
public class GoalRepository {
	
	@PersistenceContext(name="Goal")
	EntityManager manager;
	
	public void create(Goal goal) {
		manager.persist(goal);
	}
	
	public void update(Goal goal) {
		manager.merge(goal);
	}
	
	public List<Goal> getList() {
		Query q = manager.createQuery("select g from Goal g");
		@SuppressWarnings("unchecked")
		List<Goal> list = q.getResultList();
		return list;
	}
	
	public Goal getFootballerById(int id) {
		return manager.find(Goal.class, id);
	}
}
