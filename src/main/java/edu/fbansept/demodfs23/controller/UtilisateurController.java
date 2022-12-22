package edu.fbansept.demodfs23.controller;

import edu.fbansept.demodfs23.dao.UtilisateurDao;
import edu.fbansept.demodfs23.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UtilisateurController {

    @Autowired
    UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable int id) {

        Optional<Utilisateur> reponse = utilisateurDao.findById(id);

        if(reponse.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reponse.get(), HttpStatus.OK);

       // return reponse.orElse(null);
    }

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurDao.findAll();
    }

    @GetMapping("/utilisateurs-by-name/{nom}/{prenom}")
    public List<Utilisateur> getUtilisateurs(
            @PathVariable String nom,
            @PathVariable String prenom) {

        return utilisateurDao.findAllByPrenomAndNom(prenom, nom);
    }

    @PostMapping("/utilisateur")
    public ResponseEntity<Utilisateur> ajoutUtilisateur(@RequestBody Utilisateur utilisateur) {

        Utilisateur utilisateurExistant = null;

        if(utilisateur.getId() != null) {
            utilisateurExistant = utilisateurDao
                    .findById(utilisateur.getId())
                    .orElse(null);

            //si l'utilisateur a essayé de créer un utilisateur avec un id défini
            if(utilisateurExistant == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            utilisateurDao.save(utilisateur);
            return new ResponseEntity<>(utilisateur,HttpStatus.OK);
        }

        utilisateurDao.save(utilisateur);
        return new ResponseEntity<>(utilisateur,HttpStatus.CREATED);
    }

    @DeleteMapping("/utilisateur/{id}")
    public boolean deleteUtilisateur(@PathVariable int id) {
        utilisateurDao.deleteById(id);
        return true;
    }
}
