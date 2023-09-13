package com.Filrouge.webapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;




@Entity
@Table(name = "app_user")

public class AppUser implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	private String username;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<AppRole> listRoles = new ArrayList<AppRole>();

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(int idUser, String username, String password, List<AppRole> listRoles) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.listRoles = listRoles;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AppRole> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<AppRole> listRoles) {
		this.listRoles = listRoles;
	}
	
	
	
}
