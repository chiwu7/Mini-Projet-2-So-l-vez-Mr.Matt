package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class ListeChainee<T> implements Liste<T> {

  class Maillon {
    private T donnee;
    private Maillon suivant;

    public Maillon(T donnee) {
      this.donnee = donnee;
      this.suivant = null;
    }

    public void setDonne(T donnee) {
      this.donnee = donnee;
    }

    public void setSuivant(Maillon suivant){
      this.suivant = suivant;
    }

    public T getDonnee() {
      return this.donnee;
    }

    public Maillon getSuivant() {
      return this.suivant;
    }
  }

  private Maillon tete;
  private int taille;

  public ListeChainee() {
    this.tete = null;
    this.taille = 0;
  }

  @Override
  public void ajouter(T element){
    Maillon nouveauMaillon = new Maillon(element);

    if (tete == null) {
      tete = nouveauMaillon;
    } else {
      Maillon dernierMaillon = getMaillon(taille - 1);
      dernierMaillon.setSuivant(nouveauMaillon);
    }
    taille++;
  }

  @Override
  public T element(int i) throws IndexOutOfBoundsException{
    if (i < 0 ||i >= this.taille)
      throw new IndexOutOfBoundsException();

    Maillon maillon = getMaillon(i);
    
    return maillon.getDonnee();
  }

  @Override
  public T enlever(int i) throws IndexOutOfBoundsException {
    if (i<0 ||i >= this.taille)
      throw new IndexOutOfBoundsException();
    
    Maillon maillonSupprimer = getMaillon(i);
      
    if (i == 0) {
      tete.getSuivant();
    } else if(i == taille - 1) {
      Maillon maillonPrecedent = getMaillon(i-1);
      maillonPrecedent.setSuivant(null);
    } else {
      Maillon maillonPrecedent = getMaillon(i - 1);
      maillonPrecedent.setSuivant(getMaillon(i+1));
    }

    return maillonSupprimer.getDonnee();
  }

  private Maillon getMaillon(int i){
    Maillon maillon = tete;
    for (int j = 0; j < i; j++) {
      maillon = maillon.getSuivant();
    }
    return maillon;
  }

  @Override
  public int taille(){
    return this.taille;
  }

  @Override
  public boolean estVide(){
    boolean etat;
    if (this.taille == 0) {
      etat = true;
    } else {
      etat = false;
    }
    return etat;
  }

  @Override
  public boolean contient(T element) {
    boolean resultat = false;
    Maillon maillon = tete;
    while (maillon != null) {
      if (maillon.getDonnee().equals(element)) {
          resultat = true;
      }
      maillon = maillon.getSuivant();
    }
      return resultat;
    }

  
}
