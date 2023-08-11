package com.gestionbudget.test.services;

import com.gestionbudget.test.Exception.NotFoundException;
import com.gestionbudget.test.entites.Categorie;
import com.gestionbudget.test.repository.RepositoryCategorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {
        private RepositoryCategorie repositoryCategorie;

        @Override
        public String definir(Categorie categorie) {
                Categorie categorie1 = repositoryCategorie.findByNomCategorie(categorie.getNomCategorie());
                if (categorie1 == null) {
                        repositoryCategorie.save(categorie);
                        return "Categorie definie";
                }
                throw new NotFoundException("Cet categorie existe déjà");
        }

        @Override
        public String modifier(Categorie categorie) {
                Categorie categorie1 = repositoryCategorie.findByNomCategorie(categorie.getNomCategorie());
                if (categorie1 == null) {
                        repositoryCategorie.save(categorie);
                        return "categorie modifier";
                }

                return "cette categorie existe dejà";
        }


        @Override
        public String supprimer(Long idCategorie) {
             Categorie categorie =   repositoryCategorie.findByIdCategorie(idCategorie);
             if (categorie==null ){
                     return "le categorie avec l'ID "+idCategorie+" n'existe pas";
             }
             repositoryCategorie.delete(categorie);
                return "Categorie supprimer";
        }

        @Override
        public List<Categorie> afficher() {
                return repositoryCategorie.findAll();
        }

        @Override
        public Categorie lire(Long idCategorie) {
              return   repositoryCategorie.findById(idCategorie).orElseThrow(()->
                new NotFoundException("Categorie non trouver"));

        }
}
