package com.springsecurity.basicauth.modele;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity@Table(name = "t_etudiant")
public class Etudiant {
	
    @Id  // Clé primaire
    private long tel;
    
    @Column(name="nom")
    private String nom;
    
    @Column(name="email")
    private String email;

    @Column(name="adresse")
    private String adresse;
    
    // Constructeur sans paramètres
    public Etudiant() {
		super();
	}

    // Constructeur avec paramètres
	public Etudiant(long tel, String nom, String email, String adresse) {
		super();
		this.tel = tel;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
	}
	
    // Guetters et Setters 
    public String getNom() {
        return nom;
    }

	public void setNom(String nom) {
        this.nom = nom;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

