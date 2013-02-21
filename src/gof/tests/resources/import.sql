INSERT INTO personne VALUES ('PER01','1','testMail1','testNom1','testPrenom1','testTel1');
INSERT INTO personne VALUES ('PER02','2','testMail2','testNom2','testPrenom2','testTel2');

INSERT INTO statut VALUES ('ROLE_ADMIN','Administrateur');
INSERT INTO statut VALUES ('ROLE_USER','Utilisateur');
INSERT INTO statut VALUES ('ROLE_ROF','Administrateur ROF');

INSERT INTO personne_statut VALUES('PER01','ROLE_ADMIN');

INSERT INTO personne_statut VALUES('PER02','ROLE_USER');
INSERT INTO personne_statut VALUES('PER02','ROLE_ROF');