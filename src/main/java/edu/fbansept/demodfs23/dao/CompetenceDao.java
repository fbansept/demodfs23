package edu.fbansept.demodfs23.dao;

import edu.fbansept.demodfs23.model.Competence;
import edu.fbansept.demodfs23.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, Integer> {
}