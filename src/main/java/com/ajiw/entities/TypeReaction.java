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
@ToString

@Entity
@Table(name = "typeReaction")
public class TypeReaction {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id_ty;
	
	
	@Column(name = "libelle", unique = true)
	@JsonProperty("libelle")
	private String libelle;
	 
	//***********
	@JsonIgnore
	@OneToMany(
            mappedBy = "typeReactions",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
	private Collection<Reaction> reactions = new ArrayList<>();
}
