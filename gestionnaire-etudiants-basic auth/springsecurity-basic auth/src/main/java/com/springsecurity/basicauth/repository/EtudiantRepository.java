package com.springsecurity.basicauth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.basicauth.modele.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByTel(long tel); // Trouver par clé primaire (tel)
    void deleteByTel(long tel);  // Supprimer par clé primaire (tel)
}
