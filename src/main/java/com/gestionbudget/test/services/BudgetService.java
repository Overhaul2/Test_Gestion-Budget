package com.gestionbudget.test.services;

import com.gestionbudget.test.entites.Budget;

import java.util.List;

public interface BudgetService {

    String Creer(Budget budget);

    String modifier(Budget budget);

    List<Budget> afficher();

    Budget lire(Long idBudget);

    String supprimer (Long idBudget);
}
