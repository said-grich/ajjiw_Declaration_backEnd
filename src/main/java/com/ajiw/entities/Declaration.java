package com.ajiw.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "declaration")
public class Declaration {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id_dec;
	
	@Column(name = "dateDecl")
	@JsonProperty("dateDecl")
	private Date dateDecl;
	
	//content c-a-d l'Objet de declaration
	@Column(name = "content")
	@JsonProperty("content")
	private String content;
	
	@Column(name = "longitude")
	@JsonProperty("longitude")
	private Double longitude;
	
	@Column(name = "latitude")
	@JsonProperty("latitude")
	private Double latitude;
	
	@Column(name = "adresse")
	@JsonProperty("adresse")
	private String adresse;
	
	@Column(name = "etatD")
	@JsonProperty("etatD")
	private String etatD;
	
	@Column(name = "photo")
	@JsonProperty("photo")
	private String photo;
	
	@Column(name = "categ")
	@JsonProperty("categ")
	private String categ;
	 
	@ManyToOne
	@JsonProperty("user")
	@JoinColumn(nullable = false)  
	private User user;

	/*
	@ManyToOne
	@JoinColumn(nullable = true) 
    @JsonBackReference(value="declaration-categorie")
	private Categorie categorie;
    */
	//===================
	@JsonIgnore
	@OneToMany(
            mappedBy = "declaration",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    ) 
	private Collection<EtatDeclaration> etatDeclarations;
	
	 
	//===================
	@JsonIgnore
	@OneToMany(
            mappedBy = "declaration",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
	private Collection<Reaction> reactions = new ArrayList<>();
	 

	
}
