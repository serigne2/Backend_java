package com.Filrouge.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Filrouge.webapp.model.Formateur;
import com.Filrouge.webapp.repository.FormateurRepository;

@Service
public class FormateurService {
	
	@Autowired
	private FormateurRepository formateurRepository;
    public List<Formateur> getFormateur(){
    	List<Formateur> formateurs = new ArrayList<>();
    	formateurRepository.findAll().forEach(Formateur -> {
    		formateurs.add(Formateur);
    	});
    	
    	return formateurs;
    	
    	
    	
    }
    public Formateur getformateur(long id) {
        // TODO Auto-generated method stub
        return formateurRepository.findById(id).orElse(null);
    }
    public  void deleteFormateur(long id) {
    	//attention à static
		formateurRepository.deleteById(id);
	}
    public void addFormateur(Formateur formateur) {
		formateurRepository.save(formateur);
	}
	public void updateFormateur (Formateur formateur, long id) {
		formateurRepository.save(formateur);
	}
}

