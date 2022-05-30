package com.inti.RestTD1.controller;

import java.util.List;

import com.inti.RestTD1.Ecole;
import com.inti.RestTD1.repository.EcoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoleController {
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@RequestMapping(value = "/ecoles", method = RequestMethod.GET)
	private List<Ecole> getAllEcoles()
	{
		return ecoleRepository.findAll();
	}
	
	@GetMapping("/ecole/{id}")
	private Ecole getEcole(@PathVariable("id") int id)
	{
		return ecoleRepository.getReferenceById(id);
	}
	
	@DeleteMapping("/ecole/{id}")
	private void deleteEcole(@PathVariable("id") int id)
	{
		ecoleRepository.delete(id);
//		return "Ecole deleted";
	}

}
