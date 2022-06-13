package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Usuario;

public interface UsuarioService {
	
	public Usuario insertUsuario(Usuario usuario);
	public List<Usuario> getAllUsuarios();
	public Usuario deleteUsuario(Usuario usuario);
	public Optional<Usuario> findUsuarioById(Long id);
	
}
