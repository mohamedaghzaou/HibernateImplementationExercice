package com.Exercice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Client {
	

	
	@Id
	@GeneratedValue
	private int ID;
	@Column
	private String NOM;
	@Column
	private String PRENOM;
	@Column
	private String ADRESSE;
	@Column
	private String TEL;
	
	
	public Client() {
		super();
	}
	public Client(int iD, String nOM, String pRENOM, String aDRESSE, String tE) {
		super();
		ID = iD;
		NOM = nOM;
		PRENOM = pRENOM;
		ADRESSE = aDRESSE;
		TEL = tE;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNOM() {
		return NOM;
	}
	public void setNOM(String nOM) {
		NOM = nOM;
	}
	public String getPRENOM() {
		return PRENOM;
	}
	public void setPRENOM(String pRENOM) {
		PRENOM = pRENOM;
	}
	public String getADRESSE() {
		return ADRESSE;
	}
	public void setADRESSE(String aDRESSE) {
		ADRESSE = aDRESSE;
	}
	public String getTE() {
		return TEL;
	}
	public void setTE(String tE) {
		TEL = tE;
	}
	
	


}
