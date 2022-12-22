package edu.fbansept.demodfs23.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.demodfs23.dao.StatusDao;
import edu.fbansept.demodfs23.model.Status;
import edu.fbansept.demodfs23.view.VueStatus;
import edu.fbansept.demodfs23.view.VueUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StatusController {

    @Autowired
    StatusDao statusDao;

    @GetMapping("/status/{id}")
    @JsonView(VueStatus.class)
    public ResponseEntity<Status> getStatus(@PathVariable int id) {

        Optional<Status> reponse = statusDao.findById(id);

        if(reponse.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reponse.get(), HttpStatus.OK);

       // return reponse.orElse(null);
    }

    @GetMapping("/liste-status")
    @JsonView(VueStatus.class)
    public List<Status> getStatuss() {
        return statusDao.findAll();
    }

    @PostMapping("/status")
    public ResponseEntity<Status> ajoutStatus(@RequestBody Status status) {

        Status statusExistant = null;

        if(status.getId() != null) {
            statusExistant = statusDao
                    .findById(status.getId())
                    .orElse(null);

            //si l'status a essayé de créer un status avec un id défini
            if(statusExistant == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            statusDao.save(status);
            return new ResponseEntity<>(status,HttpStatus.OK);
        }

        statusDao.save(status);
        return new ResponseEntity<>(status,HttpStatus.CREATED);
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<String> deleteStatus(@PathVariable int id) {

        Optional<Status> statusExistant = statusDao.findById(id);

        if(statusExistant.isPresent()) {
            statusDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}