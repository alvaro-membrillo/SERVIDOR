package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Comment;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class CommentDAOImpl extends GenericDAOImpl<Comment> implements CommentDAO {

	private Session session;

	public CommentDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Comment> searchByWord(String content) {

		// Compruebo que la conexión está activa
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		List<Comment> commentsList = new ArrayList();

		if (content != null) {
			commentsList = session.createQuery("FROM Comments WHERE content=:content").setParameter("content",content).list();
		}

		return commentsList;
	}

}
