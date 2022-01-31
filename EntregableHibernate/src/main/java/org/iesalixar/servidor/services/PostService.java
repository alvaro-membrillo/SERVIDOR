package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Post;

public interface PostService {

	public void insertNewPost(final Post post);

	public void updatePost(final Post post);

	public void deletePost(final Post post);

	public Post searchById(final int postId);

	public List<Post> searchAll();

	public List<Post> searchByTitle(String title);

}
