package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Comment;

public interface CommentService {

	public void insertNewComments(final Comment comment);

	public void updateComments(final Comment comment);

	public void deleteComments(final Comment comment);

	public Comment searchById(final int commentId);

	public List<Comment> searchAll();

	public List<Comment> searchByContent(String commentsName);

}
