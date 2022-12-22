package edu.fbansept.demodfs23.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.demodfs23.view.VueStatus;
import edu.fbansept.demodfs23.view.VueUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({VueUtilisateur.class, VueStatus.class})
    private Integer id;

    @JsonView({VueUtilisateur.class, VueStatus.class})
    private String nom;

    @JsonView({VueUtilisateur.class, VueStatus.class})
    private String prenom;

    @ManyToOne
    @JsonView(VueUtilisateur.class)
    private Status status;
}
