package com.inti.RestTD1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.RestTD1.model.Ecole;
import com.inti.RestTD1.model.Etudiant;
import com.inti.RestTD1.model.Professeur;
import com.inti.RestTD1.model.Utilisateur;
import com.inti.RestTD1.repository.EcoleRepository;
import com.inti.RestTD1.repository.ProfesseurRepository;
import com.inti.RestTD1.repository.UtilisateurRepository;

@RestController
public class MainController
{
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@Autowired
	ProfesseurRepository professeurRepository;
	
	@GetMapping("/hello")
	public String hello()
	{
		
		return "Hello World!";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Utilisateur> getAllUsers()
	{
		
		return utilisateurRepository.findAll();
	}
	
	@PostMapping("/save")
	public String saveUser()
	{
		Utilisateur u = new Utilisateur("login", "login");
		utilisateurRepository.save(u);
		
		return "user saved";
	}
	
	@PutMapping("/updateEcoleProfesseur/{idProf}/{idEcole}")
	public String updateStudentWithSchool(@PathVariable int idProf, @PathVariable int idEcole)
	{
		Ecole ecole = ecoleRepository.getReferenceById(idEcole);
		Professeur prof = professeurRepository.getReferenceById(idProf);
		
		List<Professeur> listProfesseurs = new ArrayList<Professeur>();
		
		listProfesseurs.add(prof);
		
		ecole.setListProfesseurs(listProfesseurs);
		
		ecoleRepository.save(ecole);
		
		return "The student : " + ecole + " has been updated";
	}

}