package com.Filrouge.webapp.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Formateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_training;
    public Formateur(long id_training, String first_name, String last_name, String adress) {
		super();
		this.id_training = id_training;
		this.first_name = first_name;
		this.last_name = last_name;
		this.adress = adress;
	}
    
      
     @OneToMany(
   		   cascade = CascadeType.ALL, 
   		   orphanRemoval = true, 
   		   fetch = FetchType.EAGER)
   @JoinColumn(name="id_training")
      private List<Session>  sessions=  new ArrayList<>();
    
	public Formateur() {
		
	}

	private String first_name;
    private String last_name;
    private String adress;
    
    // Getters and setters
 
    public String getFirst_name() {
		return first_name;
	}
    public String getLast_name() {
		return last_name;
	}
    
    
    public long getId_training() {
		return id_training;
	}
	public void setId_training(long id_training) {
		this.id_training = id_training;
	}
	public String getAdress() {
		return adress;
	}

    public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
    
    public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	
	}
	public int setnom() {
		return 0000000;
		// juste pour testercjlnclnslcxxccwks
	}

}


 


	


  
