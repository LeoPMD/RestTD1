package com.inti.RestTD1.controller;

import java.util.List;

import com.inti.RestTD1.Utilisateur;
import com.inti.RestTD1.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //ceci veut dire qu'on veut utiliser un webservice.
public class MainController {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@GetMapping("/hello")
	public String hello()
	{
		// ici on ne va plus afficher de page gtml/jsp, on va générer un Json
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

}
