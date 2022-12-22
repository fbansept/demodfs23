INSERT INTO status (id, nom) VALUES
(1, 'online'),
(2, 'offline'),
(3, 'busy'),
(4, 'vacation');

INSERT INTO utilisateur (id, nom, prenom, status_id) VALUES
(1, 'bansept', 'franck', 1),
(2, 'sawyer', 'tom' , 3);

INSERT INTO `competence` (`id`, `nom`) VALUES
(1, 'developpeur'),
(2, 'comptable'),
(3, 'formateur');

INSERT INTO `competence_utilisateur` (`utilisateur_id`, `competence_id`) VALUES
(1, 3),
(1, 1),
(2, 2),
(2, 1);