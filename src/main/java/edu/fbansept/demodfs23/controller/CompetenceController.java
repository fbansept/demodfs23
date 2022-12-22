package edu.fbansept.demodfs23.controller;

import edu.fbansept.demodfs23.dao.CompetenceDao;
import edu.fbansept.demodfs23.model.Competence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompetenceController {

    @Autowired
    CompetenceDao competenceDao;

    @GetMapping("/competence/{id}")
    public ResponseEntity<Competence> getCompetence(@PathVariable int id) {

        Optional<Competence> reponse = competenceDao.findById(id);

        if(reponse.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reponse.get(), HttpStatus.OK);

       // return reponse.orElse(null);
    }

    @GetMapping("/liste-competence")
    public List<Competence> getCompetences() {
        return competenceDao.findAll();
    }

    @PostMapping("/competence")
    public ResponseEntity<Competence> ajoutCompetence(@RequestBody Competence competence) {

        Competence competenceExistant = null;

        if(competence.getId() != null) {
            competenceExistant = competenceDao
                    .findById(competence.getId())
                    .orElse(null);

            //si l'competence a essayé de créer un competence avec un id défini
            if(competenceExistant == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            competenceDao.save(competence);
            return new ResponseEntity<>(competence,HttpStatus.OK);
        }

        competenceDao.save(competence);
        return new ResponseEntity<>(competence,HttpStatus.CREATED);
    }

    @DeleteMapping("/competence/{id}")
    public ResponseEntity<String> deleteCompetence(@PathVariable int id) {

        Optional<Competence> competenceExistant = competenceDao.findById(id);

        if(competenceExistant.isPresent()) {
            competenceDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}