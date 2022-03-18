package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Comment;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface PostDAO extends GenericDAO<Comment> {
	
	public List<Post> searchTitle(String userName);

}
