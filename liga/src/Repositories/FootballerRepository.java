package Repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Footballer;

@Stateless
public class FootballerRepository {
	
	@PersistenceContext(name="liga")
	EntityManager manager;
	
	public void create(Footballer footballer) {
		manager.persist(footballer);
	}
	
	public void update(Footballer footballer) {
		manager.merge(footballer);
	}
	
	public List<Footballer> getList() {
		Query q = manager.createQuery("select f from Footballer f");
		@SuppressWarnings("unchecked")
		List<Footballer> list = q.getResultList();
		return list;
	}
	
	public Footballer getFootballerById(int id) {
		Query q = manager.createQuery(
				"select t from Footballer t " +
				"left join fetch t.goals " +
				"where t.id = :id ")
				.setParameter("id", id);
		return (Footballer)q.getSingleResult();
	}
}
