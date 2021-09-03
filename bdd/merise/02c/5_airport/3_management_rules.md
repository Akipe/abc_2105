Airport - management rules
========

- **aircraft** and **aircraft_owners**
    - un avion appartient à 1 propriétaire.
    - un propriétaire à 1 ou plusieurs avions.

- **aircraft_owners** and **person_owners**
    - un propriétaire d'avion peut être 0 ou 1 personne.
    - une personne peut être 0 ou 1 propriétaire d'avion.

- **aircraft_owners** and **enterprise_owners**
    - un propriétaire d'avion peut être 0 ou 1 entreprise.
    - une entreprise est 1 propriétaire d'avion.

- **aircraft** and **aircraft_types**
    - un avion est défini par 1 type d'avion.
    - un type d'avion défini 0 ou plusieurs avions.

- **aircraft** and **aircraft_intervention**
    - un avion est entretenu par 0 ou plusieurs interventions.
    - une intervention entretient 1 avion.

- **mechanics** and **aircraft_intervention**
    - un mechanicien participe à 0 ou plusieurs interventions.
    - une intervention fait participer 2 méchaniciens.

- **mechanics** and **aircraft_types**
    - un méchanicien est spécialisé dans 1 ou plusieurs types d'avions.
    - un type d'avion specialise 0 ou plusieurs méchaniciens.

- **aircraft_pilots** and **aircraft_types**
    - un pilote d'avion connait 1 ou plusieurs types d'avion.
    - un type d'avion est connait par 0 ou plusieurs pilotes.

- **aircraft_pilots** and **aircraft**
    - un pilote d'avion conduit 0 ou plusieurs avions.
    - un avion est conduit par 1 à 4 pilotes.

- **workers** and **aircraft_pilots**
    - un travailleurs peut être caractèrisé en tant que 0 ou 1 pilote d'avion.
    - un pilote d'avion est 1 travailleur.

- **workers** and **mechanics**
    - un travailleur peut être 1 ou 0 méchanicien.
    - un méchanicien est 1 travailleur.

- **workers** and **person_owners**
    - un travailleur peut être 0 ou 1 particulier propriétaire.
    - un particulié propriétaire peut être un travailleur.
