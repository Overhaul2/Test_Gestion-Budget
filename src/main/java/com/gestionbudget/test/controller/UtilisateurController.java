package com.gestionbudget.test.controller;

import com.gestionbudget.test.entites.Utilisateur;
import com.gestionbudget.test.services.IutulisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UtilisateurController {
    private IutulisateurService iutulisateurService;
    @PostMapping("/inscrire")
    private String creer(@RequestBody Utilisateur utilisateur){
        return iutulisateurService.inscrire(utilisateur);
    }
    @GetMapping("/connexion")
    private String connecter(@RequestParam String email,@RequestParam  String motDePasse){
        return iutulisateurService.conexion(email,motDePasse);
    }
    @PutMapping("/modifier")
    private String modifier(@RequestBody Utilisateur utilisateur){
        return iutulisateurService.modifier(utilisateur);
    }
    @DeleteMapping("/supprimer/{idUser}")
    private String supprimer(@PathVariable Long idUser){
        return iutulisateurService.supprimer(idUser);
    }
    @GetMapping("/liste")
    private List<Utilisateur> afficher(){
        return iutulisateurService.afficher();
    }
    @GetMapping("/lire/{idUser}")
    private Utilisateur lire(@PathVariable Long idUser){
        return iutulisateurService.lire(idUser);
    }



}
