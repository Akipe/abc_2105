La sécurité des applications web
=======================

1. De quoi parle t'on ?
    - (**problematique**) ?
    - (**intro**) Explication de ce qu'est la sécurité des applications web
        - 
        - Présentation pas aussi technique que voulu, parce que pas assez de temps, mais je vous partagerai des ressources.
    - (**sommaire**) Présentation du plan :
        1. Qu'est ce que la sécurité
            1. Définir le sujet et les limites.
            2. Historique de la sécurité.
            2. Pourquoi le piratage est-ce si fréquent ?
        2. Comment sécuriser une application web ?
        3. Quelques example de risque
        4. Conclusion

2. Qu'est ce que la sécurité
    1. Présentation et limites.
        - >La sécurité informatique, est l’ensemble des moyens techniques, organisationnels, juridiques et humains nécessaires à la mise en place de moyens visant à empêcher l'utilisation non autorisée, le mauvais usage, la modification ou le détournement du système d'information.
        - Du coup, ici on ne parlera que d'une petite partie des moyens techniques de la sécurité informatique.
        - On peut comparer la sécurité des application web à une très longue chaine où chaques maillon serait une partie de notre application (serveur, etc...). Un seul maillon suffi à détruire. Il faut donc avoir une connaissance global de toutes la chaine, du plus bas niveau de l'informatique au plus haut niveau.
        - Mais cette chaine ne se limite pas à la partie technique : elle peut toucher de prêt ou de loins à l'ensemble de l'entreprise résponsable du projet, par exemple si un travailleur de l'entreprise travaillant sur ce projet décide de voler ou de vérolé une partie de l'application.
        - Il faut penser la sécurité dans un ensemble, et la partie technique n'est qu'une partie de cet ensemble.
        - Mais même dans la partie technique, le risque peut venir d'une librairie utilisé pour votre projet, une fonction mal sécurisé, une application non mise à jour sur le serveur web, un mot de passe par défaut non remplacé... Il est très difficile, et même impossible de sécurisé totalement une application, car il y a énormément d'ellements à prendre en compte, et le tout est réalisé par des humains, avec donc des risques d'oublie ou d'erreur.
        Malgré tout, il existe des bonnes pratiques pour limiter les risques de piratage.
        - On peut comparer la sécurité d'un système informatique comme la sécurité d'une maison : il faut protéger chacune des portes, fenêtres et autre ouverture de votre maison (comparable à tous les endroits où vous récupérer des entrée de l'utilisateur). Mais il ne faut pas se contenter de sécuriser la porte d'entrée : les voleurs essayeront presque toujours de passer par le chemin le plus simple, par exemple par la fenêtre ouverte sur le toit.

    2. Historique.
        - La sécurité informatique est aujourd'hui un domaine majeur pour toutes les entreprises et autres organisations, mais il n'en a pas été toujours ainsi. Depuis l'invention et la généralisation des accès internets, de plus en plus de applications, de machines et donc de systèmes d'entreprises sont accéssible depuis internet et donc on un risque potentiel de sécurité.

    3. Importance de la sécurité
        - Il y a régulierement des actualités par rapport aux piratages d'entreprises, par exemple avec le ransomware WannaCrypt touchant des hopitaux en Angleterre et en espagne ainsi que de d'autres entreprises en 2017, ou plus récemment cette année avec le piratage du pipeline Colonial qui a entrainé une pénurie de carburants aux Etats-Unis,
        - Pour les application web, elle sont par définition accessible le plus souvent à internet, ou au réseau web de l'entreprise.
        - savoir sécurisé une application, c'est également connaitre les technique de piratage, s'entrainer et connaitre les dernières techniques vous permettrons de prevenir les principales attaques et implémenter au plus tôt les contres mesures
        
        - C'est pour celà que le risque zero n'existe pas
        - De plus la sécurité n'est pas vital au bon fonctionnement de l'application, et demande de bonne connaissances en culture numérique, dans les derniers risques de pirtatage et une volonté de prendre soin de la sécurité de l'application, de l'entreprise et des clients
        Enfin, les logiciels deviennent de plus en plus complexes et connectés, la difficulté à atteindre un niveau de sécurité satisfaisant augmente de façon exponentielle.
        - Tout le monde peut potentiellement à travers internet vous pirater, mais pour une application web pour l'intranet d'une entreprise, le risque peut être également en interne. Il est important d'étudier l'ensemble des risques pour adapter la sécurité.
        - Il faut malheureusement accepter la possibilité d'être piraté, pour ainsi mieux préparer les contre mesures, par exemple en chiffrant données.

3. Les aspects de la sécurité d'une application
    
    - Sécurisé une application c'est minimiser les risques de l'application contre les menaces :
        - passives (visant à écouter et récupérer des informations)
        - active (alterer des informations ou le bon fonctionnement de l'application)
    - Penser à la sécurité dès la phase de conception
    - Réaliser des tests d’intrusion d’application web pour évaluer et réduire les risques sécurité
    - réaliser audit
    - Déployez des outils de prévention et de détection des terminaux pour empêcher les attaques malveillantes
    - se former continuellement aux niveaux risque de sécurité
    - pare-feu d'applications Web (WAF)
    - penser aux risque des utilisateurs de l'application
    - mettre en place un système de logging efficace pour voir si problème de sécurité

    - man in the middle
        - http & https
    
    - phishing
    - ingénieurie sociale

            


4. Quelques examples de problème de sécu 
- OWASP - Open Web Application Security Project, Top 10 Web Application Security Risks, 2017

    1. Injection
        - C'est le risque de sécurité le plus courant, surtout dans du code ancien.
        - C'est la possibilité à partir de n'importe quel entrée dans votre application, par exemple dans un formulaire d'une page web, d'envoyer du code qui sera executé par votre application. Ce code permettra par exemple de récupérer des données ou de réaliser différents actions, comme se connecter en tant qu'administrateur, ou supprimer la base de donnée.
        - C'est pour celà que le formateur nous répéte :

        > never trust input user

        Il faut vérifier et traité chacune des entrée de l'utilisateur, en échappant les caractères spéciaux qui servirait à executer du code.

        Exemple : 
        ```
        SELECT * FROM Utilisateur WHERE nom = 'Toto' AND mot_de_passe = 'ljkè456qrt1q';

        Au lieu de "Toto" -> "Toto';--"

        SELECT * FROM Utilisateur WHERE nom = 'Toto';--' AND mot_de_passe = 'jesaispas';
        <=>
        SELECT * FROM Utilisateur WHERE nom = 'Toto'

        Du coup plus besoin d'avoir un mot de passe pour se connecter en tant que Toto

        Si échapement de caractère :
        "Toto';--" -> "Toto'';--"

        SELECT * FROM Utilisateur WHERE nom = 'Toto'';--' AND mot_de_passe = 'jesaispas';
        ```

    2. Broken authentification
        - brut force
            - politique de protection anti brutforce
            - mot de passe taille minimum, charactère obligatoire, pas même mot de passe
            - gestionnaire de mot de passe
        - ne donner que les droits strictement nécessaires pour chaques utilisateur ou application

    3. Sensitive Data Exposure

    4. XML External Entities

    5. Broken Access Control

    6. Security Misconfiguration

    7. Cross Site Scripting

    8. Insecure Deserialization

    9. Using components with know vulnerabilities
        - mettre en oeuvre un système de gestion de vulnérabilités


    10. Insufficient logging & monitoring


6. Conclusion

- état actuelle de la sécurité, répércution financiére et autres
- Ne vous arrêtez pas à 10. Il existe des centaines de problèmes susceptibles d'altérer la sécurité globale d'une application web, comme expliqué dans le Guide du Développeur OWASP et la série des aide-mémoire OWASP. Un travail de tous les jours pour apprendre et découvrir les dernières nouvelles techniques.
- Les attaquants peuvent potentiellement utiliser de nombreux chemins différents à travers votre application pour nuire à votre entreprise ou organisation. Les pirates ont beaucoup de créativité pour passer par des chemins dont on n'aurait jamais imaginer pour entrer sur des systèmes. Chacune de ces voies représente un risque qui peut, ou non, être suffisamment grave pour justifier une attention particulière.
- Posez vous la question : si je devais pirater, que ferais je ? Apprenez à piratez mais en respectant les lois, comme par exemple avec des


7. Quelques liens, en savoir plus
- The OWASP Application Security Verification Standard (ASVS) Project provides a basis for testing web application technical security controls and also provides developers with a list of requirements for secure development.
- https://github.com/OWASP/CheatSheetSeries/tree/master/cheatsheets
- Mr Robot
- chaine youtube https://www.youtube.com/watch?v=4YS7Qh1xFIs
- ANSSI (Recommandations pour la sécurisation des sites web)
- https://arfp.eu/crm/ressources/securite/
