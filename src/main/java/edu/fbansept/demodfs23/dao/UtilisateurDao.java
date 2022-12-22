package edu.fbansept.demodfs23.dao;

import edu.fbansept.demodfs23.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    List<Utilisateur> findAllByPrenomAndNom(String prenom, String nom);

}