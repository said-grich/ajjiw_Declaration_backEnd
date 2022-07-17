package com.ajiw.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "etatDeclaration")

public class EtatDeclaration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id_etatD;
	
	@Column(name = "dateEtat")
	@JsonProperty("dateEtat")
	private Timestamp dateEtat;

		
	 
	//=================
	@ManyToOne
	@JoinColumn(nullable = false) 
	@JsonIgnore
	private Declaration declaration;
	
	//=================
	@ManyToOne
	@JoinColumn(nullable = false) 
	private Etat etat;
	
	//=================
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnore
	private User user;

	@Override
	public String toString() {
		return "EtatDeclaration{" +
				"id_etatD=" + id_etatD +
				",libelle="+ etat.getLibelle()+
				'}';
	}
}

