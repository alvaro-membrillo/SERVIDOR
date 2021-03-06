package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Comment;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class PostDAOImpl extends GenericDAOImpl<Post> implements PostDAO {

	private Session session;

	public PostDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public void insert(Comment objetT) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Comment objectT) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Comment objectT) {
		// TODO Auto-generated method stub

	}

	@Override
	public Post searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchTitle(String userName) {
		// Compruebo que la conexión está activa
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		List<Post> postsList = new ArrayList();
		
		if (userName != null) {
			postsList = session.createQuery("FROM Posts WHERE Username=:username").setParameter("post", post).list();
		}
		
		return null;
	}

}
