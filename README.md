# Projet CoursEpfBack - Backend du jeu "Plants vs Zombies"

## Description du projet
Ce projet est le backend d'un jeu inspiré de "Plants vs Zombies". Il utilise **Spring Boot**, **Maven**, et une base de données **MySQL** pour gérer les données. Le backend expose des endpoints RESTful pour gérer les zombies, les plantes et les cartes du jeu. Les tests unitaires ont été réalisés et tous les tests passent.

## Tests
- **Tests unitaires** : Tous les tests unitaires sont passés avec succès.
- **Tests des endpoints** : La première série de tests des endpoints REST a été concluante. Cependant, lors du test de l'endpoint **POST /zombies**, un problème est survenu car le zombie tente de se créer avec un **ID de carte** qui n'existe plus. Il est recommandé de réinitialiser la base de données avant de refaire les tests.

## Défis rencontrés
J'ai passé **plus de 15 heures** à essayer de connecter le backend au frontend, en rencontrant plusieurs problèmes liés à **Tomcat** et à la configuration **Maven**. Lors des tests des endpoints, j'ai rencontré des problèmes de conflits dans la base de données, ce qui a causé des erreurs lors de l'insertion de données pour les zombies. (Le **POST /zombies** avec un **ID de carte** ne fonctionnait pas car la carte devait être supprimée de la base de données, ce qui a empêché le bon fonctionnement lors des tests suivants).

## Améliorations possibles
- **Tests d'intégration** : Ajouter des tests d'intégration pour vérifier le bon fonctionnement entre le backend et la base de données.
- **Documentation API** : Ajouter une documentation détaillée des endpoints pour faciliter l’utilisation de l’API.
