package com.Filrouge.webapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Filrouge.webapp.model.Formateur;

@Repository
public interface FormateurRepository extends CrudRepository<Formateur,Long>{
	//Optional<Formateur> save(Optional<Formateur> formateur);
}
