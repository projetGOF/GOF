INSERT INTO personne VALUES ('1','testMail1','testNom1','testPasswd1','testPrenom1','testTel1');
INSERT INTO personne VALUES ('2','testMail2','testNom2','testPasswd2','testPrenom2','testTel2');

INSERT INTO statut VALUES ('ROLE_ADMIN','Administrateur');
INSERT INTO statut VALUES ('ROLE_USER','Utilisateur');
INSERT INTO statut VALUES ('ROLE_ROF','Administrateur ROF');

INSERT INTO personne_statut VALUES('1','ROLE_ADMIN');

INSERT INTO personne_statut VALUES('2','ROLE_USER');
INSERT INTO personne_statut VALUES('2','ROLE_ROF');