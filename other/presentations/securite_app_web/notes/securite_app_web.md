La sécurité des applications web
======================

# Définition d'une problèmatique
- Qu'est ce que la sécurité des applications web, et la limite ?
- Comment sécurité une application web ?

# Oragnisation 
- Présentation rapide d'une application web
- Présentation de la sécurité informatique, état actuelle de la sécurité, répércution financiére et autres
- définir les risques et adversaires, accepter la possibilité d'être piraté
- Présentation de la sécurité application web
    - les différentes attaques (top 10 des risque de sécurité web de OWASP)
    - les solutions
- Conclusion sur comment gérer ces risques

- Faire une présentation avec des exemples, et peut être une comparaison avec un objet du quotidien (bateau, voiture, etc...) ?

# Liste d'attaques
- authentification et bruteforce
- gestion des droits d'accès et élévation de privilèges
- exploitation de failles XSS, les attaques XSS reposent sur l’envoi de contenus malicieux affichés sur le navigateur des utilisateurs d’une application web, sous forme de pop-up ou une redirection vers un site externe.
    - Les attaques XSS stockées (stored XSS attacks) qui envoient un contenu malicieux sur le serveur hébergeant une application web, afin qu’il soit renvoyé dans le navigateur des utilisateurs.  
    - Les attaques XSS reflétées (reflected XSS attacks) qui ne stockent pas le contenu malicieux sur le serveur web, mais qui le livrent aux utilisateurs de l’application via une URL ou directement sur le navigateur.
- Les attaques en injection (Commandes injection, SQL Injection, LDAP injection...).
- Les attaques sur les sessions (cookie poisonning, session hijacking...).
- Exploitation de vulnérabilités sur le frontal HTTP (ver Nimda, faille Unicode...).
- Attaques sur les configurations standard (Default Password, Directory Transversal...).
- Falsification de demandes intersites (CSRF), CSRF trompe les victimes lorsqu'elles font une demande qui utilise leur autorisation ou leur authentification. Par conséquent, grâce à ces privilèges de compte, les attaquants peuvent faire des requêtes usurpant l'identité de l'utilisateur. Cela pourrait entraîner un transfert de fonds, des changements de mot de passe, etc.
- Déni de service (DoS) et déni de service distribué (DDoS), Les attaquants surchargent le serveur ciblé et / ou son infrastructure avec divers trafics d'attaque. Une fois que le serveur devient incapable de traiter efficacement les demandes inkling, il commence à se comporter lentement et refuse finalement le service à davantage de demandes entrantes, même de visiteurs légitimes.
- Sécurité des systèmes interconnectés
- Sécurité des composants tiers
- Au-delà des failles techniques, des failles logiques souvent oubliées
- chiffrement des pages web (HTTPS)

# Liste de solution
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


# Choses à rechercher...
- Les risques majeurs des applications Web selon l'OWASP (Top Ten 2017).

# Sources
- https://www.dgssi.gov.ma/sites/default/files/attached_files/guide_appli_web_v23-12-2015.pdf
- https://www.vaadata.com/blog/fr/comment-renforcer-la-securite-de-vos-applications-web-pour-contrer-les-attaques-les-plus-courantes/
- https://geekflare.com/fr/learn-web-application-security/
- https://developer.mozilla.org/en-US/docs/Web/Security
- https://www.edx.org/course/web-security-fundamentals
- https://developer.mozilla.org/en-US/docs/Web/Security
- https://www.synbioz.com/blog/securite-applications-web
- https://owasp.org/www-project-top-ten/
- https://fr.wikipedia.org/wiki/Open_Web_Application_Security_Project
