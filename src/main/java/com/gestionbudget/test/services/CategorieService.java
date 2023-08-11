package com.gestionbudget.test.services;

import com.gestionbudget.test.entites.Categorie;

import java.util.List;

public interface CategorieService {

    String definir(Categorie categorie);

    String modifier(Categorie categorie);

    String supprimer(Long idCategorie);

    List<Categorie> afficher();

    Categorie lire(Long idCategorie);


}
