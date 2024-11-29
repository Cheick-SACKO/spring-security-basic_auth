package com.springsecurity.basicauth.controller;

import java.util.List;     
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springsecurity.basicauth.modele.Etudiant;
import com.springsecurity.basicauth.service.EtudiantService;

@RestController
@RequestMapping("/etudiants")  // Mapping de l'URL de l'API
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    // Ajouter un étudiant
    @PostMapping("/add")  
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant newEtudiant = etudiantService.AddEtudiant(etudiant);
        return ResponseEntity.ok(newEtudiant); // Retourne l'étudiant ajouté
    }

    // Obtenir un étudiant par numéro de téléphone
    @GetMapping("/{tel}")
    public ResponseEntity<Etudiant> getEtudiantByTel(@PathVariable long tel) {
        Optional<Etudiant> etudiant = etudiantService.SearchEtudiantByTel(tel);
        return etudiant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtenir tous les étudiants
    @GetMapping("/getall")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.GetAllEtudiant();
    }

    // Mettre à jour un étudiant
    @PutMapping("/update/{tel}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable long tel, @RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = etudiantService.UpdateEtudiant(tel, etudiant);
        if (updatedEtudiant != null) {
            return ResponseEntity.ok(updatedEtudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un étudiant
    @DeleteMapping("/delete/{tel}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable long tel) {
        etudiantService.DeleteEtudiant(tel);
        return ResponseEntity.ok().build();
    }
}
