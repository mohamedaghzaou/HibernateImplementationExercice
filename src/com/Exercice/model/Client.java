package com.Exercice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {

	@Id
	@GeneratedValue
	private int ID;
	@Column
	private String NOM;
	// @Column
	private String PRENOM;
	@Column
	private String ADRESSE;
	@Column
	private String TEL;

}
