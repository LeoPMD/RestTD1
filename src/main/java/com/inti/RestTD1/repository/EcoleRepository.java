package com.inti.RestTD1.repository;

import com.inti.RestTD1.Ecole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer>{

}
