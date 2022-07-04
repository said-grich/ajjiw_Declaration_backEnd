package com.ajiw.entities;
 
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id; 
import javax.persistence.Table;
 
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
@Table(name = "categorie")
public class Categorie {

	
	@Id 
	@Column(name = "id_cat")
	private int id_cat;
	
	@Column(name = "libelle")
	@JsonProperty("libelle")
	private String libelle;
	 
	//===================
			/*@JsonIgnore
			@OneToMany(
		            mappedBy = "categorie",
		            cascade = CascadeType.ALL,
		            orphanRemoval = true
		    ) 
			private Collection<Declaration> declarations;*/

}
