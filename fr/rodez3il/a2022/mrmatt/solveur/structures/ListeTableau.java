package fr.rodez3il.a2022.mrmatt.solveur.structures;

import java.util.Arrays;

public class ListeTableau<E> implements Liste<E> {

  // tableau d'objet
  private E[] tab;
  // taille du tableau;
  private int taille;

  public ListeTableau() {
    this.tab = (E[]) (new Object[5]);
    this.taille = 0;
  }

  @Override
  public void ajouter(E element) {
    if (this.taille == this.tab.length)
      redimensionner();

    this.tab[taille] = element;
    this.taille++;
  }

  private void redimensionner() {

    E[] NouveauTab = (E[]) (new Object[this.tab.length * 2]);

    for (int i = 0; i < this.tab.length; i++)
      NouveauTab[i] = this.tab[i];

    this.tab = NouveauTab;
  }

  @Override
  public boolean estVide() {
    boolean etat;
    if (this.taille == 0) {
      etat = true;
    } else {
      etat = false;
    }
    return etat;
  }

  @Override
  public int taille() {
    return this.taille;
  }

  @Override
  public E enlever(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= this.taille)
      throw new IndexOutOfBoundsException();

    E supprimer = this.tab[i];

    for (int j = i; j < this.taille - 1; j++)
      this.tab[j] = this.tab[j + 1];

    this.taille--;

    return supprimer;
  }

  @Override
  public E element(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= this.taille)
      throw new IndexOutOfBoundsException();

    return this.tab[i];
  }

  @Override
  public boolean contient(E e) {
    boolean etat = false;

    for (int i = 0; i < this.taille; i++)
      if (this.tab[i].equals(e))
        etat = true;

    return etat;
  }

}