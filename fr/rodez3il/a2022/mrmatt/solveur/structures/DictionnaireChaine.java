package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class DictionnaireChaine<C, V> implements Dictionnaire<C, V> {

  class Entree<C, V> {

    private C cle;
    private V valeur;

    public Entree(C cle, V valeur) {
      this.cle = cle;
      this.valeur = valeur;
    }
  }

  private ListeChainee<Entree<C,V>> liste = new ListeChainee<Entree<C,V>>();

  public DictionnaireChaine(){
    
  }
  @Override
  public void inserer(C cle, V valeur) {

    Entree<C, V> nouveauElement = new Entree<C, V>(cle, valeur);
    
    if (liste.estVide())
      liste.ajouter(nouveauElement);

    for(int i = 0; i<liste.taille(); i++){
      nouveauElement = liste.element(i);
      if(nouveauElement.cle.equals(cle))
        nouveauElement.valeur = valeur;
    } 

    liste.ajouter(new Entree<C, V>(cle, valeur));
  }

  @Override
  public boolean contient(C cle) {
    boolean resultat = false;

    if (liste.estVide()) {
      resultat = false;
    } else {
      for(int i = 0; i<liste.taille(); i++) {
        Entree<C, V> element = liste.element(i);
        if(element.cle.equals(cle)){
          resultat = true;
        }  
      }
    }
    return resultat;
  }

  @Override
  public V valeur(C cle){

    V val = null;
    
    if (liste.estVide()) {
      val = null;
    } else {
      for(int i = 0; i<liste.taille();i++) {
        Entree<C, V> element = liste.element(i);
        if(element.cle.equals(cle)) {
          val = element.valeur;
        } else {
          val = null;
        }
      }
    }
    return val;
}
}
