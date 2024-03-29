package Repositories;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Entities.Team;

@Stateless
public class TeamRepository {
	
	@PersistenceContext(name="liga")
	EntityManager manager;
	
	public void create(Team team) {
		manager.persist(team);
	}
	
	public void update(Team team) {
		manager.merge(team);
	}
	
	public Collection<Team> getList() {
		Query q = manager.createQuery("select t from Team t");
		@SuppressWarnings("unchecked")
		Collection<Team> list = q.getResultList();
		return list;
	}
	
	public Team getTeamById(int id) {
		Query q = manager.createQuery(
				"select t from Team t " +
				"left join fetch t.footballers " +
				"left join fetch t.matches " +
				"where t.id = :id ")
				.setParameter("id", id);
		return (Team) q.getSingleResult();
	}
}
