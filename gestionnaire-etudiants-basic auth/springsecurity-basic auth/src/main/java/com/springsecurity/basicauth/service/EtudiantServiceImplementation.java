package com.springsecurity.basicauth.service;

import java.util.List;   

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.basicauth.modele.Etudiant;
import com.springsecurity.basicauth.repository.EtudiantRepository;

@Service
public class EtudiantServiceImplementation implements EtudiantService {

    @Autowired  // Injection du répository
    private EtudiantRepository etudiantrepository;

    @Override
    public Etudiant AddEtudiant(Etudiant etudiant) {
        return etudiantrepository.save(etudiant);
    }

    @Override
    public Optional<Etudiant> SearchEtudiantByTel(long tel) {
        return etudiantrepository.findByTel(tel);
    }

    @Override
    public List<Etudiant> GetAllEtudiant() {
        return etudiantrepository.findAll();
    }

    @Override
    public Etudiant UpdateEtudiant(long tel, Etudiant etudiant) {
        Optional<Etudiant> etudOpt = etudiantrepository.findByTel(tel);
        if (etudOpt.isPresent()) {
            Etudiant etud = etudOpt.get();
            etud.setNom(etudiant.getNom());
            etud.setAdresse(etudiant.getAdresse());
            etud.setEmail(etudiant.getEmail());
            return etudiantrepository.save(etud);  // Sauvegarde les modifications
        }
        return null;  // Si l'étudiant n'est pas trouvé
    }

    @Override
    public void DeleteEtudiant(long tel) {
        Optional<Etudiant> etudiantOpt = etudiantrepository.findByTel(tel);
        if (etudiantOpt.isPresent()) {
            etudiantrepository.delete(etudiantOpt.get());
        } else {
            throw new RuntimeException("Étudiant non trouvé avec le téléphone: " + tel);
        }
    }

}
