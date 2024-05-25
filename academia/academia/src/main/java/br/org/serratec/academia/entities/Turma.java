package br.org.serratec.academia.entities;

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

@Entity
@Table(name = "Turma")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "turmaId",
		scope = Instrutor.class
		)
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "turma_id")
	private Integer turmaId;
	
	@Column(name = "nome_disciplina")
	private String nomeDisciplina;
	
	@Column(name = "dia_semana")
	private String diaSemana;
	
	@ManyToOne
	@JoinColumn (name = "instrutor_id")
	private Instrutor instrutor;

	public Turma() {
	}

	public Turma(Integer turmaId, String nomeDisciplina, String diaSemana) {
		this.turmaId = turmaId;
		this.nomeDisciplina = nomeDisciplina;
		this.diaSemana = diaSemana;
	}

	public Integer getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(Integer turmaId) {
		this.turmaId = turmaId;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	protected Instrutor getInstrutor() {
		return instrutor;
	}

	protected void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

}
