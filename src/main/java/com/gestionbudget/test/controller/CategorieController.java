package com.gestionbudget.test.controller;

import com.gestionbudget.test.entites.Categorie;
import com.gestionbudget.test.services.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@AllArgsConstructor
public class CategorieController {
    private CategorieService categorieService ;

    @PostMapping("/definir")
    private String definir(@RequestBody Categorie categorie){
      return categorieService.definir(categorie);
    }
    @PutMapping("/modifier")
    private  String modiffier(@RequestBody Categorie categorie){
        return categorieService.modifier(categorie);
    }

    @GetMapping("/afficher")
    private List<Categorie> afficher(){
        return categorieService.afficher();
    }
    @GetMapping("/lire/{idCategorie}")
    private Categorie lire(@PathVariable Long idCategorie){
        return categorieService.lire(idCategorie);
    }

    @DeleteMapping("/supprimer/{idCategorie}")
    private String supprimer(@PathVariable Long idCategorie){
        return categorieService.supprimer(idCategorie);
    }

}
