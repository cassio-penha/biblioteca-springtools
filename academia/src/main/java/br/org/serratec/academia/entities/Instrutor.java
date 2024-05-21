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
@Table(name = "intrutor")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "instrutorId",
		scope = Instrutor.class
		)
public class Instrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "intrutor_id")
	private Integer instrutorId;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "nomeInstrutor")
	private String nomeInstrutor;
	
	@Column(name = "telefone")
	private String telefone;
	
	public Instrutor() {
		super();
	}
		
	public Instrutor(Integer instrutorId, String rg, String nomeInstrutor, String telefone) {
		super();
		this.instrutorId = instrutorId;
		this.rg = rg;
		this.nomeInstrutor = nomeInstrutor;
		this.telefone = telefone;
	}

	public Integer getInstrutorId() {
		return instrutorId;
	}

	public void setInstrutorId(Integer instrutorId) {
		this.instrutorId = instrutorId;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
