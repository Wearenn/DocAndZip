# Getting Started

### Lancement du projet

Pour lancer le projet pour évaluation :

```shell
> docker-compose up -d --build 
```

Pour lancer postgres et adminer (puis lancer l'API via un IDE) :

```shell
> docker-compose -f docker-compose.local.yml up -d 
```

Pour lancer seulement l'API :

```shell
> docker build -t docandzip . 
> docker run --name docandzip-api -d -p 8080:8080 -t docandzip
```
