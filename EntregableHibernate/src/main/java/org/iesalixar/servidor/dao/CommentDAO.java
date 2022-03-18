package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Comment;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface CommentDAO extends GenericDAO<Comment> {
	
	public List<Comment> searchByWord(String word);
	
}
