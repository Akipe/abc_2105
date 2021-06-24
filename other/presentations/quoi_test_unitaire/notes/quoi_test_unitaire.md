C'est quoi "un test unitaire" ?
=========================

*Presentation entre 3 et 5 minutes à l'oral*

## Qu'est ce qu'un test unitaire ?

![Qu'est ce qu'un test unitaire](../img/qu_est_ce_test_unitaire.png)
(source : Débuguez et testez vos applications iOS https://openclassrooms.com/fr/courses/4729291-debuguez-et-testez-vos-applications-ios/4887470-decouvrez-les-tests )

Le test unitaire permet de vérifier le bon fonctionnement d'une petite partie bien précise d'une application, en validant son attitude et sa logique.

Il permet de vérifier que la relation d'entrée et de sortie souhaité est bel et bien correcte. 

On peut par exemple tester qu'une méthode fonctionne correctement dans les différents cas de figure des données en paramètres.

Les tests unitaires doivent être rejoués après chaque modification du code afin de vérifier qu'il n'y ait pas de régressions, c'est-à-dire que le programme fonctionne toujours comme prévu. À l'exécution de ce test, on est informé sur le succès ou sur l'échec de la vérification.

## Le test unitaire dans un projets

![Processus de développement](../img/test_unitaires_poo.png) (source : UML - Diagrammes de classes - 1. Classes et associations https://www.youtube.com/watch?v=8VMMu-vcF60)

Les tests peuvent être conçus avant, pendant ou après le développement de l'application. C'est l'une des procédures mises en oeuvre dans le cadre d'une méthode de travail agile.

Les tests unitaires sont écrits soit par le développeur, soit par une autre personne. Ils sont normalement exécutés par les développeurs, bien qu'ils puissent l'être également par les responsables en assurance qualité (QA).

Les tests unitaires peuvent être même à la base de certaines méthodologies de travail, comme pour le Test Diven Development (TDD), qui consiste à élaborer les procédures de test unitaires avant d'écrire le code du logiciel. Le développement est donc effectué conformément aux exigences d'un cahier des charges ou des spécifications.

Mais les tests restent une tache secondaire dans l'élaboration d'une application, donc sur certains projets ils peuvent ne pas être mis oeuvre à cause d'un manque de ressources (pas assez de budgets ou de personnel, manque de temps...).

## Un test en cache un autre...

![Pyramide des tests](../img/pyramide_de_tests.png) (source : https://practicalprogramming.fr/tests-unitaires)

Le test unitaire est à la base des autres types de tests, comme les tests fonctionnels, les tests d'intégration, etc...

Il est donc possible de tester d'autres parties plus complexe d'une application.

## Exemple concret


![Le code Java à tester](../img/example_pratique_test_unitaire_java_1.png)
![Un test unitaire sur le code java ci-dessus](../img/example_pratique_test_unitaire_java_2.png)

Voici un exemple concret de test unitaire avec le langage Java, et le framework JUnit. La première image correspond au code de l'application, et la deuxième au test unitaire.

### Première image
Dans la première image, on a un exemple de classe toute simple, Addition, qui a une méthode "calculer" qui va retourner le calcul sur deux nombres. Dans cet exemple, on fait exprès de réaliser une multiplication au lieu d'une addition, pour générer une erreur.

### Deuxième image
Dans la deuxième image on a une autre classe qui va tester la classe Addition.
Il y a 3 étapes :
1. étape : **La préparation** : caractérisé par le "@Before", c'est ici qu'on initialise l'ensemble des données utiles pour réaliser le test. On crée une instance de la classe addition, dans laquelle on réalisera nos différents tests.
2. étape : **Le test en lui-même** : caractérisé par le "@Test", c'est ici qu'on réalise les tests. Dans l'exemple, on va demander à JUnit qu'on attend pour le calcul de l'addition 3 + 3 le résultat de 6. Vu qu'on multiplie au lieu d'additionner, au lieu d'obtenir 6 on va obtenir 9. Du coup l'IDE arrive même à détecter que le test unitaire sera faux.
3. étape : **Terminer le test** : cette étape permet de clôturer si besoin les différents objets et autres modules pour terminer le test. Dans le cas suivant, il n'est pas utile, on n'a donc aucun code.

## Sources
- https://fr.wikipedia.org/wiki/Test_unitaire
- https://practicalprogramming.fr/tests-unitaires
- https://fr.yeeply.com/blog/test-unitaire-comment-sy-prendre/

## Outils
- Presentation (alternative à PowerPoint) : https://github.com/impress/impress.js/
