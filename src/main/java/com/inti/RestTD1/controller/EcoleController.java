package com.inti.RestTD1.controller;

import java.util.List;

import com.inti.RestTD1.model.Ecole;
import com.inti.RestTD1.repository.EcoleRepository;

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
public class EcoleController {
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@GetMapping("/schools")
	public ResponseEntity<List<Ecole>> getAllSchools()
	{
		return new ResponseEntity<List<Ecole>>(ecoleRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/saveSchool")
	public ResponseEntity<Ecole> saveSchool(@RequestBody Ecole ecole) // @RequestBody = "il faut envoyer un objet de type étudiant"
	{
		return new ResponseEntity<Ecole>(ecoleRepository.save(ecole), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateSchool/{id}")
	public String updateSchool(@RequestBody Ecole ecole, @PathVariable int id)
	{
		Ecole e1 = ecoleRepository.getReferenceById(id);
		ecoleRepository.save(e1);
		
		return "The student : " + e1 + " has been updated";
	}
	
	@DeleteMapping("/deleteSchool")
	public String deleteSchool(@RequestParam("id") int id)
	{
		ecoleRepository.deleteById(id);
		return "School deleted";
	}
	
	@PutMapping("/updateStudentWithSchool/{idEtudiant}/{idEcole}")
	public String updateStudentWithSchool(@RequestBody)

}
