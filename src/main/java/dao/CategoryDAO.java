package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Category;

public class CategoryDAO {
	
	//create session factory
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void insert(Category category) {
		//create new session
		Session session = sessionFactory.openSession();
		try {
			//start transaction
			session.beginTransaction();
			//save object to db
			session.save(category);
			//commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			//rollback
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}
	
	public List<Category> getAllCategories() {
		List<Category> result = new ArrayList<Category>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		result = session.createQuery(" from Category").list();
		session.flush();
		session.close();
		return result;
	}
	
	public Category findById(int id) {
		Session session = sessionFactory.openSession();
		return session.get(Category.class, id);
	}
	
	public void update(Category category) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}
}
