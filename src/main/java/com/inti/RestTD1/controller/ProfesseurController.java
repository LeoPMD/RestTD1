package com.inti.RestTD1.controller;

import java.util.List;

import com.inti.RestTD1.model.Professeur;
import com.inti.RestTD1.repository.ProfesseurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesseurController {

	@Autowired
	ProfesseurRepository professeurRepository;
	
	@GetMapping("/profs")
	public ResponseEntity<List<Professeur>> getAllProfesseur()
	{
		return new ResponseEntity<List<Professeur>>(professeurRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/saveProfesseur")
	public ResponseEntity<Professeur> saveProfesseur(@RequestBody Professeur prof) // @RequestBody = "il faut envoyer un objet de type étudiant"
	{
		return new ResponseEntity<Professeur>(professeurRepository.save(prof), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProfesseur/{id}")
	public String updateProfesseur(@RequestBody Professeur professeur, @PathVariable int id)
	{
		Professeur p1 = professeurRepository.getReferenceById(id);
		
		if(!p1.getNom().equals(professeur.getNom()))
		{
			p1.setNom(professeur.getNom());
		}
		
		if(!p1.getPrenom().equals(professeur.getPrenom()) && professeur.getPrenom() != null)
		{
			p1.setPrenom(professeur.getPrenom());
		}
		
		professeurRepository.save(p1);
		
		return "The professeur : " + p1 + " has been updated";
	}
	
	@DeleteMapping("/deleteProfesseur")
	public String deleteProfesseur(@RequestParam("id") int id)
	{
		professeurRepository.deleteById(id);
		return "Professeur deleted";
	}
	
}
