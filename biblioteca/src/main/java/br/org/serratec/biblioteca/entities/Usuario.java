package br.org.serratec.biblioteca.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="usuario")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "userId",
		scope = Usuario.class
)

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@NotBlank(message = "O nome precisa estar preenchido")
	@Column(name = "user_nome")
	private String userName;
	
	@Email(message = "Preencha o campo email corretamente exemplo@exemplo")
	@Column(name = "user_email", unique=true)
	private String userEmail;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@ManyToOne
	@JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id") //Pode usar a variação também referencedColumnName = ""
	private Perfil perfilId;

	public Usuario() {
		super();
	}
	
	public Usuario(Integer userId, String userName, String userEmail, String userPassword, Perfil perfilId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.perfilId = perfilId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Perfil getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Perfil perfilId) {
		this.perfilId = perfilId;
	}
}