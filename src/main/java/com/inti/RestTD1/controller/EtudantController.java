package com.inti.RestTD1.controller;

import java.util.List;

import com.inti.RestTD1.model.Etudiant;
import com.inti.RestTD1.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudantController {
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@GetMapping("/students")
	public ResponseEntity<List<Etudiant>> getAllStudents()
	{
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Etudiant> saveStudent(@RequestBody Etudiant etudiant) // @RequestBody = "il faut envoyer un objet de type étudiant"
	{
		return new ResponseEntity<Etudiant>(etudiantRepository.save(etudiant), HttpStatus.CREATED);
	}

}
