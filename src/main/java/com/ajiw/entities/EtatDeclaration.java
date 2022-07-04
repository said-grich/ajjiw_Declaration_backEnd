package com.ajiw.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "etatDeclaration")

public class EtatDeclaration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id_etatD;
	
	@Column(name = "dateEtat")
	@JsonProperty("dateEtat")
	private Date dateEtat;

		
	 
	//=================
	@ManyToOne
	@JoinColumn(nullable = false) 
    @JsonBackReference(value="etatdeclaration-declaration")
	private Declaration declaration;
	
	//=================
	@ManyToOne
	@JoinColumn(nullable = false) 
    @JsonBackReference(value="etatdeclaration-etat")
	private Etat etat;
	
	//=================
	@ManyToOne
	@JoinColumn(nullable = false) 
    @JsonBackReference(value="etatdeclaration-user")
	private User user;
	 
	
	 
	
}

