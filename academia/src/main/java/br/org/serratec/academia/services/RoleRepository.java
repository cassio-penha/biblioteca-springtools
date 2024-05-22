package br.org.serratec.academia.services;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.academia.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
