package com.inti.RestTD1.repository;

import com.inti.RestTD1.model.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {
	

}
