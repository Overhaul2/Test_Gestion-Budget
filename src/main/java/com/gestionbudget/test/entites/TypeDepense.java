package com.gestionbudget.test.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class TypeDepense {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeDepense;
    @Column(name = "nomTypeDepnse")
    @NotNull(message = "Veiller remplir tout les champs")
    @Size(min = 5 ,max = 150)
    private String nomTypeDepense;

    @ManyToOne
    private Utilisateur TypeDepenseUtilisateur;

    @OneToMany(mappedBy = "DepenseTypeDepense")
    private List<Depense> DepenseTypeDepense;

}
