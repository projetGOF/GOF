application GOF
======

******************
<h5>Nature:</h5>

  Application Web 
  
******************
<h5>cadre</h5>

Cette application s'inclut dans le cadre de notre projet de fin d'année.

******************
<h5>Objectifs:</h5>

  gérer et présenter l'offre de formation de l'UFR.
  
******************

<h5>Résumé:</h5>

  Aix-Marseille Université a fait l’acquisition d’un logiciel permettant la gestion de l’offre de
  formation : ROF (Référentiel de l’Offre de Formation). Cette application permet de construire la
  structure de l’ensemble de l’offre de formation de l’université mais ne procède à aucune vérification
  de la cohérence des données.
  Un logiciel a été développé afin de valider les données générées par ROF. En cas de non 
  cohérence des données, un message d’erreur est généré. Les données, agrémentées, ou non, des
  messages d’erreurs sont alors exportées dans un fichier XML à partir de la base de données de
  l’application ROF. Grâce à ce fichier XML, deux sites Web sont générés permettant la visualisation
  des données : un site officiel, n’incluant pas les erreurs relevées et une copie de ce site incluant les
  erreurs (site d’audit).
  L’objectif du projet est de développer une application permettant, à l’instar du site d’audit, la
  visualisation de l’ensemble de l’offre de formation, agrémentée des erreurs relevées, et l’édition des
  données afin de corriger les anomalies.

 
****************

<h5>installation :</h5>

1.créer une base de données nommé  <br/>
2.éditer le fichier /GOF/src/META-INF/persistence.xml en modifiant l'attribut value de "upload" à "create"  <br/>
3.éditer le fichier GOFSync.properties de la façon suivante:  <br/>

xml.pathToContentXSl= // Chemin d'acces au fichier XSL d'import de contenu  <br/>
xml.pathToStructureXSl= // Chemin d'acces au fichier XSL d'import de structure  <br/>
xml.pathGeneratedContentSQL= // Emplacement du fichier sql qui sera généré (Vous pouvez laissez la valeur deja présente)  <br/>
xml.pathGeneratedStructureSQL= //Emplacement du fichier sql qui sera généré (Vous pouvez laissez la valeur deja présente)  <br/>

4.éditer le fichier "/GOF/WebContent/WEB-INF/classes/jdbc.properties" en y en entrant vos identifiants  <br/>
jdbc.username= // Nom d'utilisateur  <br/>
jdbc.password= // Mot de passe <br/>
5.lancer l'application en exécutant "/GOF/WebContent/index.jspx" <br/>
6.éditer le fichier /GOF/src/META-INF/persistence.xml en modifiant l'attribut value de "create" à "upload"   <br/>
7.relancer l'application en exécutant à nouveau "/GOF/WebContent/index.jspx"  <br/>

******************
<h5>développeurs:</h5>

Denis Chavez, 
Jérome Miralles, 
Alexandre Monties, 
Walid Ouchefoune, 
Jesus Zavarce, 
