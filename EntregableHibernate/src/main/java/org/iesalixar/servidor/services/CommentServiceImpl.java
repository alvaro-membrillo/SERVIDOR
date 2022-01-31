package org.iesalixar.servidor.services;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentDAO;
import org.iesalixar.servidor.dao.CommentDAOImpl;
import org.iesalixar.servidor.model.Comment;

public class CommentServiceImpl implements CommentService {

	private CommentDAO commentDAO;

	public CommentServiceImpl(final Session session) {
		this.commentDAO = new CommentDAOImpl(session);
	}

	@Override
	public void insertNewComments(Comment comment) {
		
		if (comment != null && comment.getId() != null) {
			commentDAO.insert(comment);
		}

	}

	@Override
	public void updateComments(Comment comment) {
		
		if (comment != null && comment.getId() != null) {
			commentDAO.update(comment);
		}

	}

	@Override
	public void deleteComments(Comment comment) {
		
		if (comment != null && comment.getId() != null) {
			commentDAO.delete(comment);
		}

	}

	@Override
	public Comment searchById(int commentId) {
		
		Comment comment = null;
		
		if (commentId != 0) {
			commentDAO.searchById(commentId);
		}
		return comment;
	}

	@Override
	public List<Comment> searchAll() {
		
		return null;
	}

	@Override
	public List<Comment> searchByContent(String commentsName) {
		Comment comment = null;
		
		if (commentsName != null) {
			comment = (Comment) commentDAO.searchByWord(commentsName);
		}
		
		return comment;
	}

}
