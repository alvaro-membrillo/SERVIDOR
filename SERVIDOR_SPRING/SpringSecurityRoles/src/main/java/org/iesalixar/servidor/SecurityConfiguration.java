package org.iesalixar.servidor;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/* MÉTODO PARA AUTENTIFICAR LOS USUARIOS */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
         .withUser("usuario")
         .password("usuario")
         .roles("USER")
         .and()
         .withUser("admin")
         .password("admin")
         .roles("ADMIN");
	}

	/*
	 * MÉTODO PARA ESTABLECER AUTORIZACION - A QUÉ PUEDO ACCEDER
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/* URL con información sobre ANT MATCHERS
		 * https://www.baeldung.com/spring-security-expressions */
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/products").hasRole("ADMIN")
		.antMatchers("/about","/services").hasRole("USER")
		.and()
		.formLogin();		
	}
	
	/*
	 * ESTABLECEMOS EL PASSWORD ENCODER
	 */
	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
	
}
