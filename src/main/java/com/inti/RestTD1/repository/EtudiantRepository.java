package com.inti.RestTD1.repository;

import com.inti.RestTD1.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
