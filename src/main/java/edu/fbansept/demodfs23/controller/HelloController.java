package edu.fbansept.demodfs23.controller;


import edu.fbansept.demodfs23.dao.UtilisateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {

        return "<h1>Hello world !</h1>";
    }

    @GetMapping("/")
    public String home() {
        return "Le serveur marche bien";
    }
}
