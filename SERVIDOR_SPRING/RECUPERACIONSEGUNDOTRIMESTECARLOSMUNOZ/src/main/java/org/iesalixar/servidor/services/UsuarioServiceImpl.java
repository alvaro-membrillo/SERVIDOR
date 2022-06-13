package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.repository.AsignaturaRepository;
import org.iesalixar.servidor.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository userRepo;

	@Override
	public Usuario insertUsuario(Usuario usuario) {

		if (usuario != null) {
			return userRepo.save(usuario);
		}

		return null;
	}

	@Override
	public List<Usuario> getAllUsuarios() {

		return userRepo.findAll();
	}

	@Override
	public Usuario deleteUsuario(Usuario usuario) {
		
		
		
		return null;
	}

	@Override
	public Optional<Usuario> findUsuarioById(Long id) {
		
		Optional<Usuario> usuario = null;
		
		if (id != null) {
			usuario = userRepo.findById(id); 
		}
		
		return usuario;
	}

}
