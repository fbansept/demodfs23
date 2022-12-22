package edu.fbansept.demodfs23.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.demodfs23.view.VueStatus;
import edu.fbansept.demodfs23.view.VueUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({VueUtilisateur.class, VueStatus.class})
    private Integer id;

    @JsonView({VueUtilisateur.class, VueStatus.class})
    private String nom;

    @OneToMany(mappedBy = "status")
    @JsonView(VueStatus.class)
    List<Utilisateur> listeUtilisateur = new ArrayList<>();
}
