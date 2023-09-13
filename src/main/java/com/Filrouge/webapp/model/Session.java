package com.Filrouge.webapp.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Session {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Session;
	private LocalDate date_debut;
	private LocalDate date_fin;
	private String adress;
    public Session(long id_Session, LocalDate date_debut, LocalDate date_fin, String adress) {
		super();
		this.id_Session=id_Session;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.adress = adress;
	}
    
   public Session() {
		
	   }
    
  /* @ManyToOne
   @JoinColumn(name = "id_training")
   private Formateur formateur ;*/
    
    public Long getID_Session() {
		return id_Session;
	}
    public void setID_Session(Long id_Session) {
		this.id_Session = id_Session;
	}

	public LocalDate getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}
	public LocalDate getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDate date_fin) {
		this.date_debut = date_fin;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
    
