package com.ajiw.entities;

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
@Table(name = "etat")
public class Etat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id_et;
	
	@Column(name = "libelle")
	@JsonProperty("libelle")
	private String libelle;
		 
	
	//===================
		@JsonIgnore
		@OneToMany(
	            mappedBy = "etat",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    ) 
		private Collection<EtatDeclaration> etatDeclarations;


	@Override
	public String toString() {
		return "Etat{" +
				"id_et=" + id_et +
				", libelle='" + libelle + '\'' ;
	}
}
