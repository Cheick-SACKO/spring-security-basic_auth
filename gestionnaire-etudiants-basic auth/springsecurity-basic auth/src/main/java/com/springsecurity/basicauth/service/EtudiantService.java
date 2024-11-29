package com.springsecurity.basicauth.service;

import java.util.List;   
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.springsecurity.basicauth.modele.Etudiant;


@Service
public interface EtudiantService {
	
	// Méthode permettant d'ajouter un nouveau étudiant
    Etudiant AddEtudiant(Etudiant etudiant);
    
    // Méthode permettant  de rechercher un étudiant à l'aide de son numéro de tel
    Optional<Etudiant> SearchEtudiantByTel(long tel);
    
    // Méthode permettant d'afficher la liste complète des étudiants
    List<Etudiant> GetAllEtudiant();
    
    // Méthode permettant de mettre à jour les coordonnées d'un étudiant
    Etudiant UpdateEtudiant(long tel, Etudiant etudiant);
    
 // Méthode permettant de supprimer un étudiant de la liste 
    void DeleteEtudiant(long tel);
}
