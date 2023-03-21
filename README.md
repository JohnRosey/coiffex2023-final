# Coiffex

Réalisé par Winner MAZONZIKA PINDI, Ismael GANSONRE et Quentin ANIERE 

##  Description

Coiffex est une plateforme web innovante de services de coiffure à domicile. Nous permettons aux clients de bénéficier d'une expérience de coiffure de qualité supérieure, sans avoir à se déplacer en salon. Nos coiffeurs qualifiés se rendent chez nos clients pour fournir des prestations de coiffure sur demande, à une date et à un endroit de leur choix.

## Lancement du projet

Installation des dépandances
```
npm install
```

Lancement du serveur
```
ng serve
```

Compilation du projet
```
ng build
```

## Déploiement continu

Nous avons en place le déploiment continu avec un Docker Registry privé hébergé sur le serveur de Quentin. A chaque fois qu'une image est push sur le Docker Registry, le container qui héberge l'application est automatiquement mis à jour.

Tutoriel :

1 - Se connecter au docker registry privé (une fois normalement)
```
docker login docker-hub.montreal.aniere.fr
```

2 - Build l'image docker (se mettre dans le dossier racine pour le front et dans le dossier backend pour le back)
```
docker build -t docker-hub.montreal.aniere.fr/coiffex/<frontend OU backend> .
```

3 - Push l'image sur le docker registry
```
docker push docker-hub.montreal.aniere.fr/coiffex/<frontend OU backend>
```
Dans les 30 secondes, l'application sera mise à jour sur le serveur à l'adresse https://coiffex.store .
