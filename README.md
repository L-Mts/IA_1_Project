## Installer et lancer l'application

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

- Dossier ressource contient les fichiers "faits.txt" et "regles.txt"
    "fait.txt":
        Contient la liste des faits de notre base de fait
        Chaque ligne représente un fait
    "regle.txt"
        Contient la liste de tous les règles sous le format suivant:
            'conclusion;fait1,fait2,[...]'
                La conclusion est séparée de sa liste de prémisses par ";" et les faits sont séparés les uns des autres par des ",".
                Ne pas mettre d'espace avant ou après ces séparateurs
  
    **Attention aux lignes vides dans les fichiers, elles provoquent des erreurs**

## L'interface
