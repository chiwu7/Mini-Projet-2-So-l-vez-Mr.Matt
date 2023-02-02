package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class ListeTableau<E> implements Liste<E> {

  // tableau d'objet
  private E[] tab;
  // taille du tableau;
  private int taille;

  public ListeTableau() {
    this.tab = (E[]) (new Object[5]);
    this.taille = 0;
  }

  /**
	 * Ajoute un élément à la liste.
	 * @param element l'élément à ajouter
	*/
  @Override
  public void ajouter(E element) {
    if (this.taille == this.tab.length)
      redimensionner();

    this.tab[taille] = element;
    this.taille++;
  }

  /**
   * Redimensionne le tableau en cours en doublant sa taille
  */
  private void redimensionner() {

    E[] NouveauTab = (E[]) (new Object[this.tab.length * 2]);

    for (int i = 0; i < this.tab.length; i++)
      NouveauTab[i] = this.tab[i];

    this.tab = NouveauTab;
  }

	/**
	 * Indique si la liste est vide.
	 * @return true ssi la liste est vide.
	 */  
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

	/**
	 * Indique la taille de la liste.
	 * @return La taille de la liste.
	 */  
  @Override
  public int taille() {
    return this.taille;
  }

	/**
	 * Enlève (et retourne) l'élément à la position
	 * i.
	 * @param i la position de l'élément.
	 * @return L'élément qui a été supprimé. 
	 */  
  @Override
  public E enlever(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= this.taille)
      throw new IndexOutOfBoundsException();

    E supprimer = this.tab[i];

    for (int j = i; j < this.tab.length - 1; j++)
      this.tab[j] = this.tab[j+1];

    this.taille--;

    return supprimer;
  }

	/**
	 * Renvoie l'élément à la position i.
	 * @param i la position de l'élément
	 * @return L'élément
	 */  
  @Override
  public E element(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= this.taille)
      throw new IndexOutOfBoundsException();

    return this.tab[i];
  }
  
	/**
	 * Indique s'il existe un élément f dans la liste
	 * tel que f.equals(e) est VRAI.
	 * @param e L'élément à comparer.
	 * @return vrai ssi la liste contient l'élément
	 */
  @Override
  public boolean contient(E e) {
    boolean etat = false;

    for (int i = 0; i < this.taille; i++)
      if (this.tab[i] != null && this.tab[i].equals(e)) {
        etat = true;
      }

    return etat;
  }

}