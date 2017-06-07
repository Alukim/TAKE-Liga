package Repositories;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Entities.Match;

@Stateless
public class MatchRepository {
	@PersistenceContext(name="Match")
	EntityManager manager;
	
	public void create(Match match) {
		manager.persist(match);
	}
	
	public void update(Match match) {
		manager.merge(match);
	}
	
	public List<Match> getList() {
		Query q = manager.createQuery("select m from Match m");
		@SuppressWarnings("unchecked")
		List<Match> list = q.getResultList();
		return list;
	}
	
	public Match getFootballerById(int id) {
		return manager.find(Match.class, id);
	}
}
