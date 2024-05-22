package br.org.serratec.academia.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "usuario_perfil",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	public User() {
	}

	public User(Integer id, String email, String password, List<Role> roles) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	protected Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	protected List<Role> getRoles() {
		return roles;
	}

	protected void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
