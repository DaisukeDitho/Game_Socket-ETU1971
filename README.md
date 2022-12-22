# Game_Socket-ETU1971
* il y'a un serveur du jeu et des joueurs qui se connecteront au serveur pour jouer ... 
# Pour lancer le jeu , voici les commandes à taper :
* Côté serveur : java serveur.Serveur 
* Côté joueur : java client.Joueur 

Alors le jeu consiste à mangé l'avatar des autres joueurs pour gagner de point et à la fin de partie celui qui a le plus de points à gagner ...
C'est un jeu en temps réel , c'est à dire qu'On peut voir la même image sur tout le Frame des joueurs et cela s'actualise à une très grande vitesse ...


# Fonctionnement :
* Chaque Joueur a 3 Threads : 
1. pour la généralité du jeu
2. pour la réception des messages venant du serveur
3. pour l'envoi des messages au serveur
À chaque fois qu'un joueur fait un déplacement, il envoie des informations au serveur sous formes de String qui est traité par le serveur après ...
Chaque fois que le serveur obtient un message venant des Joueurs ou Client , il fait un traitement ou interprétation sur le message reçu et distribue une information aux autres joueurs par rapport au résultat du traitement ...

Le Thread de réception (côté joueur) Attends le message venant du serveur pour synchroniser ou mettre à jour son plateforme de jeu à chaque changement .
Chaque message envoyé par les joueurs est accompagné par son ID pour qu'il n'y a pas de confusion lors du synchronisation au niveau du moteur de jeu côté Joueur ...
* Le serveur a 3 moyens d'envoyer d'information au joueur : 
1. SendToAll : envoie le message à tout les joueurs connectés 
2. SendToAllExpectingMe : envoi le message à tout les joueurs sauf à l'envoyeur
3. SendOnly : envoi le message qu'à un seul joueur précis ...
