package com.gestionbudget.test.services;

import com.gestionbudget.test.entites.Utilisateur;

import java.util.List;

public interface IutulisateurService  {

    String inscrire(Utilisateur utilisateur);

    String conexion(String email, String motDePasse);

    String modifier(Utilisateur utilisateur);

    String supprimer(Long idUser);

    List<Utilisateur> afficher();

    Utilisateur lire(Long idUser);
}
