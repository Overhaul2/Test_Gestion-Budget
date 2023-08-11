package com.gestionbudget.test.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(name = "nom")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 100)
    private String Nom;
    @Column(name = "prenom")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 100)
    private String Prenom;
    @Column(name = "email")
    @NotNull(message = "Veiller remplir tout les champ")
    @Size(min = 5 ,max = 100)
    private String email;
    @Column(name = "pasword")
    @NotNull(message = "Veiller remplir tout les champ")
    @Size(min = 5 ,max = 20)
    private String motDePasse;

    @OneToMany(mappedBy = "UtilisateurDepense")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Depense> DepenseUtilisateur;

    @OneToMany(mappedBy = "UtilisateurAlert")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Alert> alertUtilisateur;

    @OneToMany(mappedBy = "BudgetUtilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Budget> utilisateurBudget;

    @OneToMany(mappedBy = "TypeDepenseUtilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TypeDepense> UtilisateurTypeDepense;

    @OneToMany(mappedBy = "CategorieUtilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Categorie> UtilisateurCategorie;


}
