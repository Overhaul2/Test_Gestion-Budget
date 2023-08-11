package com.gestionbudget.test.repository;

import com.gestionbudget.test.entites.Budget;
import com.gestionbudget.test.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBudget extends JpaRepository<Budget, Long> {
        Budget findByTitre(String titre);
        Budget findByIdBudget(Long idBudget);

}
