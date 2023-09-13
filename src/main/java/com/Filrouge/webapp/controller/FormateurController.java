package com.Filrouge.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Filrouge.webapp.model.Formateur;
import com.Filrouge.webapp.repository.FormateurRepository;
import com.Filrouge.webapp.service.FormateurService;

@RestController
public class FormateurController {
	@Autowired
	private FormateurService formateurService;
	
	@RequestMapping(method=RequestMethod.GET,value="/formateurs")
	public List<Formateur> getFormateurs() {
	
		return formateurService.getFormateur();
	}
	@RequestMapping(method=RequestMethod.GET,value="/formateur/{id}")
	public Formateur getFormateur(@PathVariable long id) {
		return  formateurService.getformateur(id)	;
     
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/formateur/{id}")
	public void deleteFormateur(@PathVariable long id) {
		
		formateurService.deleteFormateur(id);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/formateurs")
	public void addFormateur(@RequestBody Formateur formateur) {
		formateurService.addFormateur(formateur);
		//Ma methode ajouter ne fonctionne pas à travailler
	}
	@RequestMapping(method= RequestMethod.PUT, value="/formateur/{id}")
     public void updateFormateur(@RequestBody Formateur formateur, @PathVariable long id) {
    	 formateurService.updateFormateur(formateur, id);
     }
	
   /* @Autowired
    private FormationService formationService;
    
    @GetMapping
    public List<Formation> getAllFormations() {
        //return formationService.getAllFormations();
    }*/
    
    // Autres méthodes du contrôleur
}