package br.org.serratec.academia.services;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.academia.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
