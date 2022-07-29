package com.ajiw.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "userss")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	
	@Column(name = "email")
	@JsonProperty("email")
	private String email;
	
	@Column(name = "active")
	@JsonProperty("active")
	private boolean active;
	
	@Column(name = "password")
	@JsonProperty("password")
	private String password;
	
	@Column(name = "nom")
	@JsonProperty("nom")
	private String nom;
	
	@Column(name = "prenom")
	@JsonProperty("prenom")
	private String prenom;
	
	@JsonProperty("role")
	private String role;
	
	
	@Column(name = "cin")
	@JsonProperty("cin")
	private String cin;
	
	@Column(name = "telephone")
	@JsonProperty("telephone")
	private String telephone;
	  
	@Column(name = "imm")
	@JsonProperty("imm")
	private String imm;
	private Boolean isAdmin;
	
	//==================
			@JsonIgnore
			@OneToMany(
		           mappedBy = "user",
		           cascade = CascadeType.ALL,
		           orphanRemoval = true
		    )
			private Collection<Role> roles;
	
	//==================
		@JsonIgnore
		@OneToMany(
	           mappedBy = "user",
	           cascade = CascadeType.ALL,
	           orphanRemoval = true
	    )
		private Collection<EtatDeclaration> etatDeclarations;
				
	//==================
		@JsonIgnore
		@OneToMany(
	            mappedBy = "user",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
		private Collection<Declaration> declarations = new ArrayList<>();
		
	//==================
		@JsonIgnore
		@OneToMany(
	            mappedBy = "user",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
		private Collection<Reaction> reactions = new ArrayList<>();

	@Override
	public String toString() {
		return "User{" +
				"email='" + email + '\'' +
				", active=" + active +
				", password='" + password + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", role='" + role + '\'' +
				", cin='" + cin + '\'' +
				", telephone='" + telephone + '\'' +
				'}';
	}
}
