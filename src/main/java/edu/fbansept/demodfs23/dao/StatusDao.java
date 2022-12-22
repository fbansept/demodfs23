package edu.fbansept.demodfs23.dao;

import edu.fbansept.demodfs23.model.Status;
import edu.fbansept.demodfs23.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusDao extends JpaRepository<Status, Integer> {
}