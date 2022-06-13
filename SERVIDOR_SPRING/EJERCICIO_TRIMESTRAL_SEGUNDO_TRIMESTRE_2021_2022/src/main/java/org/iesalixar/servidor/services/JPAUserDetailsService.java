package org.iesalixar.servidor.services;

import org.iesalixar.servidor.model.JPAUserDetails;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JPAUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario user = usuarioRepository.findUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("Not found: " + username);
		}

		JPAUserDetails userDetails = new JPAUserDetails(user);
		return userDetails;
	}

}
