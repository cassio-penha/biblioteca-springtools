package br.org.serratec.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "gestASingleUser")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "nomeId",
		scope = GetSingleUser.class
)
public class GetSingleUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nome_id")
	private Integer nomeId;
	
	@NotBlank(message = "O nome precisa estar preenchido")
	@Column(name = "user_name")
	private String userName;
	
	@Email(message = "Preencha o campo email corretamente exemplo@exemplo")
	@Column(name = "user_email", unique = true)
	private String userEmail;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Usuario userId;
	
	public GetSingleUser() {
	}

	public GetSingleUser(Integer nomeId, String userName, String userEmail, String userPassword, Usuario userId) {
		this.nomeId = nomeId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userId = userId;
	}

	public Integer getNomeId() {
		return nomeId;
	}

	public void setNomeId(Integer nomeId) {
		this.nomeId = nomeId;
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

	public Usuario getUserId() {
		return userId;
	}

	public void setUserId(Usuario userId) {
		this.userId = userId;
	}
	
}
