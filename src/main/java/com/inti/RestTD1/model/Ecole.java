package com.inti.RestTD1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor 
public class Ecole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private  String nom;
	private  String adresse;
	private int cp;
	private String ville;
	
	@OneToMany(mappedBy = "ecole")
	@JsonIgnore
	List<Etudiant> listeEtudiants;
	
	public Ecole(String nom, String adresse, int cp, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}

	
	
}
