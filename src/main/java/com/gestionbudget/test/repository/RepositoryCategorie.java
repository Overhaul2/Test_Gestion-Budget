package com.gestionbudget.test.repository;

import com.gestionbudget.test.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCategorie extends JpaRepository<Categorie, Long> {
        Categorie findByNomCategorie(String nomCategorie);
        Categorie findByIdCategorie(Long idCategorie);

}
