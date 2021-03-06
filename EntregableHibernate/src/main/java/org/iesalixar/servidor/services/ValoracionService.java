package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Valoracion;

public interface ValoracionService {

	public void insertNewUserPost(final Valoracion userPost);

	public void updateUserPost(final Valoracion userPost);

	public void deleteUserPost(final Valoracion userPost);

	public Valoracion searchById(final int commentId, final int UserId);

	public List<Valoracion> searchAll();

	public List<Valoracion> searchByScore(int puntuacion);

}
