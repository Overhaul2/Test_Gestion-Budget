package com.gestionbudget.test.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Depense {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepense;
    @Column(name = "montant")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 2 ,max = 15)
    private String Montant;
    @Column(name = "Description")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 10 ,max = 250)
    private String Description;
    @Column(name = "dateDepense")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 50)
    private Date dateDepense ;

    @ManyToOne
    private Utilisateur UtilisateurDepense;

    @ManyToOne
    private Budget DepenseBudget;

    @ManyToOne
    private TypeDepense DepenseTypeDepense;
}
