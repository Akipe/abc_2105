La sécurité des applications web
=======================

1. La sécurité des applications web
    - Présentation pas aussi technique que voulu, parce que pas assez de temps, mais je vous partagerai des ressources.

    - Présentation du plan :

        1. Qu'est ce que la sécurité

            1. Définir le sujet et les limites.

            2. Historique de la sécurité.

            2. Pourquoi le piratage est-ce si fréquent ?

        3. Quelques example de risque

        4. Conclusion

2. Qu'est ce que la sécurité

    1. Présentation et limites.

        - > La sécurité informatique, c'est l’ensemble des moyens techniques, organisationnels, juridiques et humains nécessaires à la mise en place de moyens visant à empêcher l'utilisation non autorisée, le mauvais usage, la modification ou le détournement d'un système d'information.

        - presentation que petite partie technique.

        - Comparaison sécurité à chaine

            - Maillon :
                - serveur
                - configuration
                - librairie
                - mot de passe par défaut non changé
                - sapplication pas mise à jour...

        - Besoin connaitre globalité application web
            - bas à haut niveau
            - partie technique qu'une partie.

        - Mais chaine pas que technique
            - exemple: gestion personnel travaillant sur projet
            - exemple: accès locaux à n'importe qui (malvaillant?)

        - Très difficile, impossible de sécurisé totalement une application
            - erreur humaine
            - nécessaire connaissance total

        - Mais existe bonnes pratiques pour limiter risques.

        - Comparaison sécurité informatique avec sécurité maison :
            - protéger porte entrée, mais passer par fenêtre ou derrière, ou toit ?

    2. Historique.
        - Avant, systèmes information hors ligne

            - quand même risque virus avec disquette, cd, clés usb

            - plutôt technique humaine pour empécher risque

        - Début 21éme siécle, réseaux haut débit, profileration des risques potentiel de sécurité

            - plus en plus système d'informations accessible à tous

            - exemple : parefeux windows xp SP2, avant rien

        - Récemment
            - 2017, ransomware WannaCrypt

                - Hopitaux en Angleterre et en espagne HS ainsi que de d'autres entreprises touché

            - 2021, piratage du pipeline Colonial avec ransonmware

                - pénurie de carburants aux Etats-Unis

    3. Importance de la sécurité

        - Pour les application web sont par défaut accessible réseau, souvent à internet.
            
            - ne pas sous éstimer risque piratage application web intranet

                - même si pas connecté à internet

        - Avant, sécurité n'était pas important.

        - Maintenant, plus pris en compte nécessite volonté :

            - pas nécessaire pour fonctionnement d'une application

            - besoin de solide compétence en sécurité

            - besoin de resssources (temps, argent, personnel...)

            - besoin également souvent plus ressource informatique (cout en CPU, mémoire...)

            - nécessiter penser sécurité dans phase conception 

        - sécuriser application -> connaitre les technique de piratage

            - s'informer

            - s'entrainer
        
        - Malgré celà le risque zero n'existe pas

            - systèmes informatique de plus en plus complexe
            
            - difficile tenir au courant nouvaux risques

            - erreur humaine

        - Accepter risque d'être pirater et s'y prépare

            - contre mesure si piratage

                - exemple : chiffrement données
                
            - compte rendu aux client
            
            - apprendre de ses erreures

            - rester imble et éviter de juger


3. Un example concret de risque de piratage

    - OWASP

        - Open Web Application Security Project

        - créer en 2001
        
        - communauté en ligne travaillant sur la sécurité des applications web

        - libre et ouvert à tous

        - vocation publier des recommandation de sécurisation des applications web

        - propose également outils

    - un des projets : Top Ten OWASP
        - fournir liste des 10 risques de sécurité des application web les plus critiques.

        - presentation rapide Top Ten 2017
        
            - Top Ten 2021 vient de sortir

    1. Risque le plus courant : les injection de code

        - C'est le risque de sécurité le plus courant

        - Surtout dans du code ancien :

            - lors utilisation Framework, souvent protégé

            - sinon développeur doit protéger

        - Permet execution de code non prévu d'un utilisateur dans une entrée application

            - exemple : formulaire de connexion
            
        - Ce code peut :

            - récupérer des données

            - supprimer des données

            - réaliser autre chose comme être administrateur

        - Important :

        > never trust input user

    - Présentation exemple

        - (https://apcpedagogie.comQuelques examples de risque/les-injections-sql-classiques/)
        - (https://kinsta.com/fr/blog/injections-sql/)

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

    2. (bonus) Quelques autres erreurs courantes, jusqu'au top 6

        - 2- l'authentification de mauvaise qualité

            - outre passer la gestion de l’authentification
            - et de la session.

        - 3- l'exposition de données sensibles

            - accès à des données sensibles

                - comme les mots de passe & données personnelles.

        - 4- les faille lié à la gestion des fichiers XML

            - Mauvaise interprétation de fichier XML

                - permet l'execution de code arbitraire

        - 5- la disfonctionnement des contrôles d'accès

            - accès à des fonctionnalités non autorisé

        - 6- Mauvaise configuration des applications

            - mauvaise configuration des applications liée aux
                - serveurs web (apache)
                - base de données (mysql)
                - au frameworks (symfony)

6. Conclusion

    - Système de plus en plus touché par la sécurité

        - Répercution grave, voire présentation de Damien sur les concéquences

    - développeur est responsable de son application
        - ayez une bonne hygienne numérique
        - prendre conscience des menaces

    - Attaquant très créatif

        - passent par chemin non prévu

        - rester en alterte

        - n'oubliez pas le coté global sécu - chaine & maillon
        
    - Si je devais pirater, que ferais-je ?

        - attention : légalement, interdit de pirater, risque de peine de prison
    
        - Apprendre pirater par jeux, plateforme entrainement piratage légale

            - challenge piratage

            - Hack the Box - https://www.hackthebox.eu/

            - Try hack me - https://tryhackme.com/

        
    - Chaine Twitch & Youtube "Khaos Farbauti"

        - explication pédagogique de piratage sur des système 

        - https://www.twitch.tv/khaos_farbauti

        - https://www.youtube.com/channel/UCsRIv1fsbnQRIPKmUQbRzZg

    - Informez vous, allez plus loins que présentation

        - actualité numérique  
            - Nextinpact

            - https://www.journalduhacker.net/

        - regarder guides & ressources

            - OWASP
                - OWASP Top Ten : https://owasp.org/www-project-top-ten/
                - d'autre contenu sur site

            - ANSSI : https://www.ssi.gouv.fr/entreprise/guide/recommandations-pour-la-securisation-des-sites-web/
                - pdf : Recommandations pour la sécurisation des sites web
                - pdf : Recommandations pour la mise en œuvre d'un site web : maîtriser les standards de sécurité côté navigateur

    - Série MR Robot
        - representation de divers technique de piratage, manière réaliste


