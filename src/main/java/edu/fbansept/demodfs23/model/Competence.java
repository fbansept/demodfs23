package edu.fbansept.demodfs23.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.demodfs23.view.VueStatus;
import edu.fbansept.demodfs23.view.VueUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VueUtilisateur.class)
    private Integer id;

    @JsonView(VueUtilisateur.class)
    private String nom;
}
