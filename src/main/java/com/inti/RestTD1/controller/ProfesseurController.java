package com.inti.RestTD1.controller;

import java.util.List;

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

import com.inti.RestTD1.model.Ecole;
import com.inti.RestTD1.model.Professeur;
import com.inti.RestTD1.repository.EcoleRepository;
import com.inti.RestTD1.repository.ProfesseurRepository;

@RestController
public class ProfesseurController
{
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@Autowired
	ProfesseurRepository professeurRepository;
	
	@GetMapping("/profs")
	public ResponseEntity<List<Professeur>> getAllProfesseur()
	{
		return new ResponseEntity<List<Professeur>>(professeurRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/saveProfesseur")
	public ResponseEntity<Professeur> saveProfesseur(@RequestBody Professeur prof)
	{
		return new ResponseEntity<Professeur>(professeurRepository.save(prof), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProfesseur/{id}")
	public String updateProfesseur(@RequestBody Professeur prof, @PathVariable int id)
	{
//		Ecole e1 = ecoleRepository.getReferenceById(id);
		professeurRepository.save(prof);
		
		return "The school : " + prof + " has been updated";
	}
	
	@DeleteMapping("/deleteProfesseur")
	public String deleteProfesseur(@RequestParam("id") int id)
	{
		professeurRepository.deleteById(id);
		return "Professeur deleted";
	}

}