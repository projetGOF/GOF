INSERT INTO personne VALUES ('PER01','1','testMail1','testNom1','testPasswd1','testPrenom1','testTel1');
INSERT INTO personne VALUES ('PER02','2','testMail2','testNom2','testPasswd2','testPrenom2','testTel2');

INSERT INTO personne_statut VALUES('PER01','ROLE_ADMIN');
INSERT INTO personne_statut VALUES('PER02','ROLE_USER');
INSERT INTO personne_statut VALUES('PER02','ROLE_ROF');

INSERT INTO composante VALUES ('COMPO01','ACRO1','NOM1','WEB1');
INSERT INTO composante VALUES ('COMPO02','ACRO2','NOM2','WEB2');

INSERT INTO domaine VALUES('DOM1','NOM1');
INSERT INTO domaine VALUES('DOM2','NOM2');

INSERT INTO mention (code, nom, typeDiplome, publiable, contenuValide, structureValide, nbErreurs, nbCredits, version) VALUES('MENT01', 'MASTER 1 INFO', 'MASTER', 1, 1, 1, 0, 42, 1);

INSERT INTO motcle VALUES('MOTCLE1', 'MENT01');
INSERT INTO motcle VALUES('MOTCLE2', 'MENT01');

INSERT INTO mention_composante VALUES ('MENT01', 'COMPO01');
INSERT INTO mention_composante VALUES ('MENT01', 'COMPO02');

INSERT INTO mention_domaine VALUES ('MENT01', 'DOM1');
INSERT INTO mention_domaine VALUES ('MENT01', 'DOM2');

INSERT INTO mention_responsable VALUES ('MENT01', 'PER02');

INSERT INTO specialite (code, nom, publiable, contenuValide, structureValide, nbErreurs, version, code_mention) VALUES ('SPE01', 'SPECIALITE 01', 1, 1, 1, 0, 1, 'MENT01');

-- Insertion d'un programme
INSERT INTO element (code, nom, publiable, contenuValide, structureValide, nbErreurs, nbCredits) VALUES ('PROG01', 'PROGRAMME 01', 1, 1, 1, 0, 42);
INSERT INTO formation (code, capacite, dureeStage, version, volCM, volTD, volTP) VALUES ('PROG01', 50, 6, 1, 33, 33, 33);
INSERT INTO programme (code, troncCommun, code_mention) VALUES ('PROG01', 1, 'MENT01');

-- Insertion d'un composant programme
INSERT INTO element (code, nom, publiable, contenuValide, structureValide, nbErreurs, nbCredits) VALUES ('SEM01', 'SEMESTRE 01', 1, 1, 1, 0, 42);
INSERT INTO composant_programme (code, type, mutualisable) VALUES ('SEM01', 'SEMESTRE', 1);

-- Insertion d'un enseignement
INSERT INTO element (code, nom, publiable, contenuValide, structureValide, nbErreurs, nbCredits) VALUES ('ENS01', 'ENSEIGNEMENT 01', 1, 1, 1, 0, 42);
INSERT INTO formation (code, capacite, dureeStage, version, volCM, volTD, volTP) VALUES ('ENS01', 50, 6, 1, 33, 33, 33);
INSERT INTO enseignement (code, mutualisable, volAutres, volGlobal, volTravail) VALUES ('ENS01', 1, 33, 33, 33);

--Insertion d'une UECat
INSERT INTO element (code, nom, publiable, contenuValide, structureValide, nbErreurs, nbCredits) VALUES ('UE01', 'UECAT 01', 1, 1, 1, 0, 42);
INSERT INTO formation (code, capacite, dureeStage, version, volCM, volTD, volTP) VALUES ('UE01', 50, 6, 1, 33, 33, 33);
INSERT INTO enseignement (code, mutualisable, volAutres, volGlobal, volTravail) VALUES ('UE01', 1, 33, 33, 33);
INSERT INTO uecat (code, miseEnService) VALUES ('UE01', 1);


