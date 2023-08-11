package com.gestionbudget.test.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategorie")
    private Long idCategorie;
    @Column(name = "nomCategorie")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 150)
    private String nomCategorie;

    @ManyToOne
    private Utilisateur CategorieUtilisateur;

    @OneToMany(mappedBy = "CategorieBudget")
    private List<Budget> CategorieBudget;

}
