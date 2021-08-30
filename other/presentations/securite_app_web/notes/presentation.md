La sécurité des applications web
=======================

1. De quoi parle t'on ?
    - (**problematique**) ?
    - (**intro**) Explication de ce qu'est la sécurité des applications web
    Présentation pas aussi technique que voulu, parce que pas assez de temps, mais je vous partagerai des ressources.
    - (**sommaire**) Présentation du plan :
        1. Qu'est ce que la sécurité
            1. Qu'est ce que la sécurité des applications web, et les limites ?
            2. Pourquoi le piratage est-ce si fréquent ?
        2. Comment sécurité une application web ?
        3. Quelques example de risque
        4. Conclusion

2. Qu'est ce que la sécurité
    1. Présentation de la sécurité informatique
        - définition : La sécurité des systèmes d’information (SSI) ou plus simplement sécurité informatique, est l’ensemble des moyens techniques, organisationnels, juridiques et humains nécessaires à la mise en place de moyens visant à empêcher l'utilisation non autorisée, le mauvais usage, la modification ou le détournement du système d'information.
        - La sécurité informatique est aujourd'hui un domaine majeur pour toutes les entreprises et autres organisations, mais il n'en a pas été toujours ainsi. Depuis l'invention et la généralisation des accès internets, de plus en plus de machines et d'applications sont en accès libre et donc on un risque potentiel de sécurité.
        - Pour les application web, elle sont par définition accessible le plus souvent à internet, ou au réseau web de l'entreprise.
        - Une des régles qu'on a appris en formation : never trust input user, c'est à dire pour toutes application, il faut vérifier et traiter chaque entrée, formulaire et toute données qu'un utilisateur humain ou application pourrait potentiellement entrée.
        - sécurité comme une chaine, chaque maillon doit être sûr
        - chaque maillon peut être une librairie, une fonction, une applicatiob sur le serveur de l'application web, un mauvaise mot de passe... Il est donc impossible d'avoir une application totalement sécurisé car l'erreur est humaine, mais on peut quand même faire beaucoup de chose pour limiter

    3. Quels sont les risques et adversaires
        - On peut comparer la sécurité des application web à une très longue chaine où chaques maillon serait une partie de notre application (serveur, etc...). Un seul maillon suffi à détruire. Il faut donc avoir une connaissance global de toutes la chaine, du plus bas niveau de l'informatique au plus haut niveau.
        - Les attaquants peuvent potentiellement utiliser de nombreux chemins différents à travers votre application pour nuire à votre entreprise ou organisation. Chacune de ces voies représente un risque qui peut, ou non, être suffisamment grave pour justifier une attention particulière.
        - savoir sécurisé une application, c'est également connaitre les technique de piratage, s'entrainer et connaitre les dernières techniques vous permettrons de prevenir les principales attaques et implémenter au plus tôt les contres mesures
        - C'est pour celà que le risque zero n'existe pas
        - De plus la sécurité n'est pas vital au bon fonctionnement de l'application, et demande de bonne connaissances en sécurité et une volonté de prendre soin de la sécurité de l'application, de l'entreprise et des clients
        Enfin, les logiciels deviennent de plus en plus complexes et connectés, la difficulté à atteindre un niveau de sécurité satisfaisant augmente de façon exponentielle.
        - Tout le monde peut potentiellement à travers internet vous pirater, mais pour une application web pour l'intranet d'une entreprise, le risque peut être également en interne. Il est important d'étudier l'ensemble des risques pour adapter la sécurité.
        - Accepter la possibilité d'être piraté et s'y préparer.

3. Les aspects de la sécurité d'une application
    - Sécurisé une application c'est minimiser les risques de l'application contre les menaces :
        - passives (visant à écouter et récupérer des informations)
        - active (alterer des informations ou le bon fonctionnement de l'application)
    - Penser à la sécurité dès la phase de conception
    - Réaliser des tests d’intrusion d’application web pour évaluer et réduire les risques sécurité
    - réaliser audit
    - limiter risque si pirate, en chiffrant données
    - ne donner que les droits strictement nécessaires pour chaques utilisateur ou application
    - Déployez des outils de prévention et de détection des terminaux pour empêcher les attaques malveillantes
    - mettre en oeuvre un système de gestion de vulnérabilités
    - se former continuellement aux niveaux risque de sécurité
    - pare-feu d'applications Web (WAF)
    - penser aux risque des utilisateurs de l'application
    - mettre en place un système de logging efficace pour voir si problème de sécurité

4. Quelques examples de problème de sécu 
- OWASP - Open Web Application Security Project, Top 10 Web Application Security Risks, 2017

5.2    A1. A1:2017-Injection
    A2.
    A3.
    A4.
    A5.
    A6.
    A7.
    A8.
    A9.
    A10.


6. Conclusion
```
- état actuelle de la sécurité, répércution financiére et autres
- Ne vous arrêtez pas à 10. Il existe des centaines de problèmes susceptibles d'altérer la sécurité globale d'une application web, comme expliqué dans le Guide du Développeur OWASP et la série des aide-mémoire OWASP. Un travail de tous les jours pour apprendre et découvrir les dernières nouvelles techniques.
- Posez vous la question : si je devais pirater, que ferais je ? Apprenez à piratez mais en respectant les lois, comme par exemple avecdes
```

7. Quelques liens, en savoir plus
- The OWASP Application Security Verification Standard (ASVS) Project provides a basis for testing web application technical security controls and also provides developers with a list of requirements for secure development.
- https://github.com/OWASP/CheatSheetSeries/tree/master/cheatsheets
- Mr Robot
- chaine youtube https://www.youtube.com/watch?v=4YS7Qh1xFIs
