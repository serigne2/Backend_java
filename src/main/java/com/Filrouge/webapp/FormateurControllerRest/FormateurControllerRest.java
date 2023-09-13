package com.Filrouge.webapp.FormateurControllerRest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Filrouge.webapp.model.Formateur;
import com.Filrouge.webapp.service.FormateurService;

@RestController
@RequestMapping("api/v1/produits")// localhost:8080/api/v1/produits
public class FormateurControllerRest {
	  
	  private FormateurService formateurservice;
	  
	  @GetMapping("/all")
	  public List<Formateur> getAllFormateur(){
		  return this.formateurservice.getFormateur();
	  }
	  public FormateurControllerRest(FormateurService formateurservice) {
		this.formateurservice = formateurservice;
	}
	 
	 @PostMapping("/create_formateur")
	 public void addFormateur(@RequestBody Formateur formateur) {
		  this.formateurservice.addFormateur(formateur);
	  }
	/* @PostMapping("/delete")
	 public void deleteFormateur(@RequestBody Formateur formateur) {
		 formateurservice.deleteFormateur(formateur);
	 } je pouvais utiliser cette méthode si ma méthode de suppression était de type formateur*/
	  
}
