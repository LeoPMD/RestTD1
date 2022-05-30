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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String anneeEtude;
	
	@ManyToOne(mappedBy = "etudiant")
	List<Ecole> listeEcole;
	
	public Etudiant(String nom, String prenom, String email, String telephone, String anneeEtude) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.anneeEtude = anneeEtude;
	}
	
	@ManyToMany
	@JoinTable(name = "Professeur_Etudiant",
	joinColumns = @JoinColumn(name = "idEtu"),
	inverseJoinColumns = @JoinColumn(name = "idProf"))
	@JsonIgnore
	private List<Professeur> listeProfesseur;

	
	
}
