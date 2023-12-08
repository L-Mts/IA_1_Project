## Installer et lancer l'application

__Prérequis: avoir Java 11 installé__

Sur votre ordinateur, ouvrez un terminal de commandes, placez vous dans le dossier où vous souhaitez installer notre application.

Les commandes à lancer sont :
```
git clone https://github.com/L-Mts/System_Expert_Planning.git
```
```
cd System_Expert_Planning
```
```
java -jar IA_1_Project.jar
```

## Structure du répertoire

- Dossier `ressource` : contient les fichiers "faits.txt" et "regles.txt"

    - **"fait.txt"**:  
        Contient la liste des faits de notre base de fait  
        Chaque ligne représente un fait
    - **"regle.txt"**:  
        Contient la liste de tous les règles sous le format suivant:  
            `conclusion;fait1,fait2,[...]`  
                La conclusion est séparée de sa liste de prémisses par ";" et les faits sont séparés les uns des autres par des ",".  
                Ne pas mettre d'espace avant ou après ces séparateurs
  
    :warning: **Attention aux lignes vides dans les fichiers, elles provoquent des erreurs**
    
- Dossier `src` : contient les fichiers des classes .java implémentées
    
    - Main = `Test.java`

- Fichier `IA_1_Project.jar` permettant de lancer l'application
- Fichier README.md

## L'interface 

L'interface est divisée en 3 grandes parties :

- Tout en haut:  

    - A gauche : la base de tous les faits existants  
    - A droite : la base des règles
        - Les boutons permettant de vérifier la cohérence de la base de règle, et de corriger les incohérences s'ils en existent
        
- Au milieu

    - La base de connaissances
        - Pour ajouter un fait à la base de connaissance :
            > Cliquer sur le fait dans la base de faits pour le sélectionner, appuyer sur le bouton "Ajouter à la base de connaissances"
        - Pour vider la base de connaissances :
            > Appuyer sur le bouton "Effacer la base de connaissances"
            
- En bas

    - Les boutons permettant de lancer les différents moteurs de recherches sur les faits de la base de connaissance
    
    
## Fonctionnalités implémentées
#### Moteurs de recherche

- Chainage avant simple : bouton `Chainage Avant Simple`
- Chainage avant appliquant d'abord les règles ayant comme prémisses les faits déduits les plus récents : bouton `Chainage Avant Faits Récents`
- Chainage avant appliquant d'abord les règles ayant le plus de prémisses à satisfaire : bouton `Chainage Avant Plus de Prémisses`
- Chainage arrière simple : bouton `Chainage Arrière Simple`
- Chainage arrière appliquant d'abord les règles ayant comme conclusion un fait déduit le plus récent : bouton `Chainage Arrière Plus Récent`
- Chainage arrière appliquant d'abord les règle ayant le plus de prémisses à ajouter à la base de connaissance : bouton `Chainage Arrière Plus de Prémisses`

#### Gestion de la cohérence  
Nous avons implémenté une gestion de la cohérence sur la base de règle :  
si plusieurs règles ont la même conclusion (incompatibilité des règles) et si plusieurs règles ont les mêmes prémisses (redondance des règles).

Concernant l'incohérence de bouclage, elle est gérée par le fait qu'un fait étant déjà dans la base de connaissance ne peut pas y être ajouté de nouveau.
