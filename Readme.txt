1) Instruction à suivre

Dans le class Extracteur:
- Mettre le nom de votre base de donnée
- Mettre votre user
- Mettre votre mot de passe


2) Si vous avez l'erreur suivante quand vous lancez le projet :
- `java.sql.SQLException: Unable to load authentication plugin 'caching_sha2_password'`

Vous devez executez la commande suivante dans MySQL :
- `ALTER USER 'votreUser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'votreMotDePasse'`

Vous lancez uniquement la classe Main, vous verez l'affichage de toutes les requete à la suite:

---Requete 1---
"des données"
---Requete 2---
"encore des données"
---Requete 3---
"encore plus de données"


Haseeb Chaudhry, Damien Jaime, Anthony Nascimento


