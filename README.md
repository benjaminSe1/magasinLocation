# Présentation de l'application

L'objectif de ce mini-projet était de développer une application devant servir à la gestion des articles mis en location par un magasin spécialisé dans le matériel médical. Cette application devra traiter des articles de nature diverse : des lits médicalisés, des tables d’alité, des fauteuils roulants, des soulève-malades, et des matelas à air.
Tous les produits à la location dans le magasin sont manipulés au travers de la même représentation : celle d'un article. Tous les articles possèdent une référence, une marque, un modèle, un prix par jour de location, et un nb en stock disponibles à la location.
Afin de faciliter la gestion de ce magasin, et tenir ses comptes, le gérant du magasin souhaiterait implémenter un logiciel informatique lui permettant de réaliser ses tâches fondamentales pour son magasin.


# Utilisation de l'application

Pour lancer l’application, il faut exécuter la classe Main du package Application.
Pour utiliser cette application, l’utilisateur doit lire les instructions affichées dans le terminal et valider une action en utilisant la touche “Entrée”.
Après avoir lancé l’application, l’utilisateur doit choisir un choix entre 1 et 7 pour effectuer une action :
Le choix numéro 1 permet d’afficher l’ensemble des articles. Une fois ce choix effectué, l’application redemande un numéro entre 1 et 8 pour choisir le tri de l’affichage des articles.
Le choix numéro 2 permet de louer les locations prédéfinies.
Le choix numéro 3 permet d’afficher les locations d’un client
Le choix numéro 4 permet d’archiver les locations dans le fichier .loc. Une fois ce choix effectué, l’application redemande un mois dont on souhaite archiver les locations.
L’utilisateur doit alors saisir un mois avec un numéro allant de 1 à 12, le 1 étant le mois de janvier et le 12 le mois de décembre.
Le choix numéro 5 permet de calculer les recette sur une période choisie. Une fois ce choix effectué, l’application redemande deux dates à saisir, qui correspondent à la période. L’utilisateur doit alors rentrer deux dates au format JJ/MM/AAAA.
Le choix numéro 6 permet de terminer l’application.
Le choix numéro 7 permet de lancer un cas de test automatique prédéfinie qui teste toutes les fonctionnalités, puis termine l’application.

L’utilisateur peut donc enchaîner les actions sauf pour le choix numéro 6 et 7 qui terminent l’application.
