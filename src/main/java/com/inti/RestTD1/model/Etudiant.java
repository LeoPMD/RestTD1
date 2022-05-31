package com.inti.RestTD1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inti.RestTD1.model.Ecole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor
public class Etudiant
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String anneeEtude;
	
	@ManyToOne
	@JoinColumn(name = "idEcole")
	@JsonIgnore
	Ecole ecole;
	
	@ManyToMany
	@JoinTable(name = "Professeur_Etudiant",
				joinColumns = @JoinColumn(name = "idEtu"),
				inverseJoinColumns = @JoinColumn(name = "idProf"))
	@JsonIgnore
	List<Professeur> listprProfesseurs;
	
	public Etudiant(String nom, String prenom, String email, String telephone, String anneeEtude)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.anneeEtude = anneeEtude;
	}

	@Override
	public String toString()
	{
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + ", anneeEtude=" + anneeEtude + "]";
	}
	
	
}