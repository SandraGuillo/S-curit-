
Pour accéder à la page des mots de passe, il suffit de cliquer sur le bouton Connexion


L'application:
Nous avons réalisé une application avec coté front-end l'utilisation d'Angular et coté backend l'utilisation de java spring boot.
La page affiche deux champs : un champs sel et un champs mot de passe (il faut systématiquement remplir les deux champs). Avec ses deux champs, on transforme le mot de passe :
on obtient alors les 5 façons différentes de coder ce mot de passe suivant l'énoncer du DM

La base de données utilisée est une base de donnée chargée en mémoire vive( non persistante), c'est à dire qu'à chaque fois que le serveur est éteind, la base de données est effacée. Cette base de données est effectuée avec H2 Database. Elle est accessible lorsque le back est lancé en localhost:8080/h2-console il faut spécifier le JDBC URL qui est :

jdbc:h2:mem:password

Pour lancer l'application :

coté front, il faut se placer dans le dossier inscription-angular et ouvrir un terminal. Ecrire 
ng serve

cote back il faut se placer dans le dossier dm et ouvrir un terminal. Ecrire
mvn spring-boot:run

Pour accéder à l'interface de l'application l'adresse est :
http://localhost:4200/
