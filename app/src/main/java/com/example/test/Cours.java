package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Une classe finale est une classe qui ne peut pas avoir de classe fille
public final class Cours {

    public void coursIterable() {
        // Déclaration d'un tableau, usage des { }
        int[] intArray = {1, 2, 3, 4};

        // On récupère la taille d'un tableau, c'est un attribut !
        int sizeArray = intArray.length;

        // Déclaration d'une liste
        List<String> listOfString = new ArrayList<>();
        // Ajout d'éléments dans la liste
        listOfString.add("Oui");
        listOfString.add("Non");
        // Si la liste contient la valeur en paramètre...
        if (listOfString.contains("Oui")) {
            // alors, traitement pour un "Oui"...
        }

        // Retourne le 1er élément de la liste
        String stringIndexZero = listOfString.get(0);

        // Itérer sur une liste - size nous donne la taille de la liste
        for (int i = 0; i < listOfString.size(); i++) {
            String tmp = listOfString.get(i);
        }

        // Itère sur une liste (meilleure utilisation)
        for (String tmp : listOfString) {

        }

        // Fonctionnement des maps en Java
        // Le premier type de la map est la clé, elle doit être d'un type primitif
        // Le deuxième type de la map est la valeur, elle doit être d'un type non primitif
        Map<String, Integer> mapExample = new HashMap<>();
        mapExample.put("Pomme", 2);
        mapExample.put("Poire", 3);
        mapExample.put("Orange", 3);
        // Itération de la map :
        // Il faut récupérer l'entryset de la map
//        Set<Map.Entry<String, Integer>> entries = mapExample.entrySet();
        // Et lui indiqer qu'on itère bien sur un entry avec les types de <K, V> de la map initiale
        for(Map.Entry<String, Integer> entry : mapExample.entrySet()) {
            // On peut ainsi récupérer la key et la value depuis l'entry
            System.out.print("Key : " + entry.getKey() + " ; value : " + entry.getValue());
        }

    }

    public void coursString() {
        // Pour un caractère c'est les simples quote
        char achar = 'a';
        // Pour une chaîne de caractère c'est les doubles quotes
        // Notez aussi que String en Java a une majuscule > c'est un objet
        String aString = "abc";

        // En Java si vous devez tester des chaînes de caractères entre elle, il faut impérativement
        // utiliser equals
        if (aString.equals("abc")) {
            // Traitement si les deux chaînes sont égales
        }

        // Obtenir la taille d'une chaîne de caractères
        aString.length();

        // split est l'équivalent de explode en php
        aString = "a:b:c";
        String[] saves = aString.split(":"); // => ["a", "b", "c"];

        // Les booléens sont de type "boolean"
        boolean isOk = true;

        // Les opérateurs existent comme en php, sauf pour celui qui concatène de chaine :
        // En java c'est le + pour concaténer les chaînes de caractères
        aString += ":d:e:f";

        // remplace les occurences du premier caractère par la valeur du deuxième
        aString.replace('a', 'z');

        // Mettre tout en majuscule
        aString = aString.toUpperCase();
        // Mettre tout en minuscule
        aString = aString.toLowerCase();
    }

    private void coursConditionsEtType() {
        // Le triple égal n'existe pas en java (le double est déjà suffisamment stricte comme ça...)

        // Le instanceof existe, comme en php

        // Tous les types primitifs ont leur équivalent en type non-primitif (en objet)
        // Par exemple :
        // - int > Integer
        // - float > Float
        // - boolean > Boolean
        // ...

        // Pour initialiser un float il faut impérativement lui préciser le f derrière
        float price = 0.0f;

        String myString = new String("Rory");
        Integer myInteger = Integer.valueOf(myString);
        // Aucune erreur à la création, par contre on aura une NumberFormatException

        double aDouble = 4.5;
        // ceil renverra 5.0 ici
        double newCeilDouble = Math.ceil(aDouble);
        // ceil renverra 5.0 ici
        double newFloorDouble = Math.floor(aDouble);

        // Génération d'aléatoire
        double aRandom = Math.random();
    }

    /**
     * Exemple de création de fonction qui prend une liste en paramètre
     *  > Pour un tableau : String[]
     *  > Pour une map : Map<String, Integer>
     *
     * @param listOfString
     */
    private void iterateOnStringList(List<String> listOfString) {

    }
}
