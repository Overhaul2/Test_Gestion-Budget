package com.gestionbudget.test.services;

import com.gestionbudget.test.Exception.NotFoundException;
import com.gestionbudget.test.entites.Budget;
import com.gestionbudget.test.repository.RepositoryBudget;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BudgetServiceImpl implements BudgetService {
    private RepositoryBudget repositoryBudget;

    @Override
    public String Creer(Budget budget) {
        Budget budget1 = repositoryBudget.findByTitre(budget.getTitre());
        if (budget1 == null) {
            repositoryBudget.save(budget);
            return "Budget defini";
        }
        return "Cet budget existe déjà";
    }

    @Override
    public String modifier(Budget budget) {
        Budget budget1 = repositoryBudget.findByTitre(budget.getTitre());
        if (budget1 == null) {
            repositoryBudget.save(budget);
            return "Budget modifié";
        }
        return "Cet budget existe déjà";
    }

    @Override
    public List<Budget> afficher() {

        return repositoryBudget.findAll();
    }

    @Override
    public Budget lire(Long idBudget) {
        Budget budget = repositoryBudget.findByIdBudget(idBudget);
        if (idBudget == null) {
            throw new NotFoundException("le budget evec L'ID " + idBudget + " n'existe pas");

        }
        repositoryBudget.findAll();
        return budget;
    }

    @Override
    public String supprimer(Long idBudget) {
        Budget budget = repositoryBudget.findByIdBudget(idBudget);
        if (budget == null) {
            return "Le budget avec l'id " + idBudget + " n'existe pas";
        }
        repositoryBudget.deleteById(idBudget);
        return "Budget supprimer";
    }
}

