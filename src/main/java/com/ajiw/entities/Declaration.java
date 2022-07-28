package com.ajiw.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "declaration")
public class Declaration {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	private String title;
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
	@ToString.Exclude
	@JsonIgnore
	@OneToOne(cascade = CascadeType.REMOVE)
	private FileDB photo;
	
	@Column(name = "categ")
	@JsonProperty("categ")
	private String categ;
	@ManyToOne
	@JsonProperty("user")
	@JsonIgnore
	@JoinColumn(nullable = false)  
	private User user;
	private String photoUri;

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
