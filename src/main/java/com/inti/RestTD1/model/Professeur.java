package com.inti.RestTD1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inti.RestTD1.model.Etudiant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor
public class Professeur
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private double salaire;
	
	@ManyToMany
	@JoinTable(name = "Professeur_Etudiant",
				joinColumns = @JoinColumn(name = "idProf"),
				inverseJoinColumns = @JoinColumn(name = "idEtu"))
	@JsonIgnore
	List<Etudiant> lisEtudiants;
	
	@ManyToMany
	@JoinTable(name = "Professeur_Ecole",
				joinColumns = @JoinColumn(name = "idProf"),
				inverseJoinColumns = @JoinColumn(name = "idEcole"))
	@JsonIgnore
	List<Ecole> lisEcoles;
	
	public Professeur(String nom, String prenom, double salaire)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	
	

}