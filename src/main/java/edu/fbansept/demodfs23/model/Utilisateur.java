package edu.fbansept.demodfs23.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany
    @JsonView(VueUtilisateur.class)
    @JoinTable(
            name="competence_utilisateur",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name="competence_id")
    )
    private List<Competence> listeCompetence = new ArrayList<>();
}
