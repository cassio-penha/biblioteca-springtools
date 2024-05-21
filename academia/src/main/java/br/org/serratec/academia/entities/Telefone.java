package br.org.serratec.academia.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Telefone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "telefoneId",
		scope = Instrutor.class
		)
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telefone_id")
	private Integer telefoneId;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "instrutor_id")
	private String instrutor;
	
	public Telefone() {
		super();
	}

	public Telefone(Integer telefoneId, int numero, String instrutor) {
		super();
		this.telefoneId = telefoneId;
		this.numero = numero;
		this.instrutor = instrutor;
	}

	public Integer getTelefoneId() {
		return telefoneId;
	}

	public void setTelefoneId(Integer telefoneId) {
		this.telefoneId = telefoneId;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}
	
}
