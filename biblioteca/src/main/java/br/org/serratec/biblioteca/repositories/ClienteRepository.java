package br.org.serratec.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.biblioteca.entities.Usuario;

public interface ClienteRepository
	extends JpaRepository<Usuario, Integer> {

}
