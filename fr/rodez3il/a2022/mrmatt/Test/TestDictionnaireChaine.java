package fr.rodez3il.a2022.mrmatt.Test;

import fr.rodez3il.a2022.mrmatt.solveur.structures.Dictionnaire;
import fr.rodez3il.a2022.mrmatt.solveur.structures.DictionnaireChaine;

public class TestDictionnaireChaine {
  public static void main(String[] args) {
    DictionnaireChaine<String, Integer> dictionnaire = new DictionnaireChaine<String, Integer>();

    System.out.print("Test inserer() : ");
    dictionnaire.inserer("Chevre", 1);
    String result = dictionnaire.contient("Chevre") ? "reussi" : "echec";
    System.out.println(result);

    System.out.print("Test valeur() : ");
    Integer valeur = dictionnaire.valeur("Chevre");
    result = (valeur != null && valeur == 1) ? "reussi" : "echec";
    System.out.println(result);
  }
}