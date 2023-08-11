package com.gestionbudget.test.services;

import com.gestionbudget.test.entites.Utilisateur;
import com.gestionbudget.test.repository.RepositoryUtilisateur;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IutulisateurService {

    private RepositoryUtilisateur repositoryUtilisateur;


    @Override
    public String inscrire(Utilisateur utilisateur) {
        Utilisateur userVerif1 = repositoryUtilisateur.findByEmail(utilisateur.getEmail());
        if (userVerif1!=null){
            return "Utilisateur existe deja ";
        }
        repositoryUtilisateur.save(utilisateur);
        return "user inscrit";
    }

    @Override
    public String conexion(String email, String motDePasse) {
        Utilisateur utilisateur = repositoryUtilisateur.findByEmailAndMotDePasse(email,motDePasse);
        if (utilisateur==null){
            return "Connexion echouee !";
        }else {
            return "User connecter";
        }
    }

    @Override
    public String modifier(Utilisateur utilisateur) {
       Utilisateur utilisateurEmail = repositoryUtilisateur.findByEmail(utilisateur.getEmail());
       if (utilisateurEmail!=null){
           repositoryUtilisateur.save(utilisateur);
           return "user modifie";
       }
       return "user n'est pas modifie";
    }

    @Override
    public String supprimer(Long idUser) {
       Utilisateur utilisateurId = repositoryUtilisateur.findByIdUser(idUser);
       if (utilisateurId!=null){
           repositoryUtilisateur.deleteById(idUser);
           return "user supprimer";
       }
       return "Identifiant incorrect";
    }

    @Override
    public List<Utilisateur> afficher() {
       return repositoryUtilisateur.findAll();

    }

    @Override
    public Utilisateur lire(Long idUser) {
        return repositoryUtilisateur.findById(idUser).orElseThrow(
                ()-> new EntityExistsException("Identifiant incorrect")
        );

    }
}
