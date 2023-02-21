package fr.rodez3il.a2022.mrmatt.Test;

import fr.rodez3il.a2022.mrmatt.solveur.structures.ListeTableau;
import fr.rodez3il.a2022.mrmatt.solveur.structures.Liste;

public class TestListeTableau {
  public static void main(String[] args) {
    Liste<String> list = new ListeTableau<String>();

    System.out.print("Test ajouter() : ");
    list.ajouter("Chevre");
    String result;
    if (list.contient("Chevre")) {
      result = "reussi";
    } else {
      result = "echec";
    }
    System.out.println(result);

    System.out.print("Test estVide() : ");
    if (list.estVide()) {
      result = "echec";
    } else {
      result = "reussi";
    }
    System.out.println(result);

    System.out.print("Test taille() : ");
    if (list.taille() == 1) {
      result = "reussi";
    } else {
      result = "echec";
    }
    System.out.println(result);

    System.out.print("Test enlever() : ");
    list.enlever(0);
    if (list.estVide()) {
      result = "reussi";
    } else {
      result = "echec";
    }
    System.out.println(result);

    System.out.print("Test element() : ");
    list.ajouter("Elephant");
    try {
      String elem = list.element(0);
      if (elem.equals("Elephant")) {
        result = "reussi";
      } else {
        result = "echec";
      }
    } catch (IndexOutOfBoundsException e) {
      result = "echec";
    }
    System.out.println(result);

    System.out.print("Test contient() : ");
    if (list.contient("Elephant")) {
      result = "reussi";
    } else {
      result = "echec";
    }
    System.out.println(result);
  }
}