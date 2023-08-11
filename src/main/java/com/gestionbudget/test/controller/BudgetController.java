package com.gestionbudget.test.controller;

import com.gestionbudget.test.entites.Budget;
import com.gestionbudget.test.services.BudgetService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
@AllArgsConstructor
@Data
public class BudgetController {
    private BudgetService budgetService;
    @PostMapping("/creer")
    private String creer(@RequestBody Budget budget){
       return   budgetService.Creer(budget);

    }
    @PutMapping("/modifier")
    private String modifier(@RequestBody Budget budget){
        return budgetService.modifier(budget);
    }
    @GetMapping("/liste")
    private List<Budget> liste(){
        return budgetService.afficher();
    }
    @GetMapping ("/lire/{idBudget}")
    private Budget lire(@PathVariable Long idBudhet){
        return budgetService.lire(idBudhet);
    }
    @DeleteMapping("/supprimer/{idBudget}")
    private String supprimer(@PathVariable Long idBudget){
        return budgetService.supprimer(idBudget);
    }
}
