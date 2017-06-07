package Repositories;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Entities.Team;

@Stateless
public class TeamRepository {
	
	@PersistenceContext(name="Team")
	EntityManager manager;
	
	public void create(Team team) {
		manager.persist(team);
	}
	
	public void update(Team team) {
		manager.merge(team);
	}
	
	public List<Team> getList() {
		Query q = manager.createQuery("select t from Team t");
		@SuppressWarnings("unchecked")
		List<Team> list = q.getResultList();
		return list;
	}
	
	public Team getFootballerById(int id) {
		return manager.find(Team.class, id);
	}
}
