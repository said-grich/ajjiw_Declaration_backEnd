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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "reaction")
public class Reaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private int idReact;
	@Column(name = "date_react") 
	private Date dateReact;
	//=================
	@ManyToOne
	@JoinColumn(nullable = false) 
    @JsonBackReference(value="reaction-declaration")
	private Declaration declaration;
	
	//==================
	@ManyToOne
	@JoinColumn(nullable = false) 
    @JsonBackReference(value="reaction-user")  
	private User user;
	private int reaction;


	@Override
	public String toString() {
		return "Reaction{" +
				"idReact=" + idReact +
				", dateReact=" + dateReact +
				", declaration=" + declaration +
				", user=" + user.getNom()+" "+user.getPrenom() +
				", reaction=" + reaction +
				'}';
	}
}
