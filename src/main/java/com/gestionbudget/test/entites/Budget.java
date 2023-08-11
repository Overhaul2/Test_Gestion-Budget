package com.gestionbudget.test.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBudget;

    @Column(name = "titre")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 150)
    private String titre;

    @Column(name = "montant")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 15)
    private int Montant;

    @Column(name = "dateDebut")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 50)
    private Date dateDebutDepense;
    @Column(name = "dateFin")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 50)
    private Date dateFinDepense;

    @ManyToOne
    private Utilisateur BudgetUtilisateur;

    @OneToMany(mappedBy = "BudgetAlert")
    private List<Alert> AlertBudget;

    @ManyToOne()
    private Categorie CategorieBudget;

    @OneToMany(mappedBy = "DepenseBudget")
    private List<Depense> BudgetDepense;



}
