package com.gestionbudget.test.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Alert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlert;
    @Column(name = "message")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 250)
    private String message;

    @ManyToOne
    private Utilisateur UtilisateurAlert;

    @ManyToOne
    private Budget BudgetAlert;
}
