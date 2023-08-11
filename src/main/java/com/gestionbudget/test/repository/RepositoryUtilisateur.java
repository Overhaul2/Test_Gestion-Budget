package com.gestionbudget.test.repository;

import com.gestionbudget.test.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUtilisateur extends JpaRepository<Utilisateur,Long>{

    Utilisateur findByEmail(String email);
    Utilisateur findByEmailAndMotDePasse(String email,String motDePasse);

    Utilisateur findByIdUser(Long idUser);

}
