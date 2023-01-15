package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class ListeChainee<T> implements Liste<T> {

  class Maillon {
    private T donnee;
    private Maillon suivant;
  }

  public Maillon tete;
  private int taille;

  public ListeChainee() {
    this.tete = null;
    this.taille = 0;
  }

  
}
