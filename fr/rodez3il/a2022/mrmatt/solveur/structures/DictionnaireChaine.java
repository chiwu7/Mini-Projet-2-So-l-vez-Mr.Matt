package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class DictionnaireChaine<C, V> implements Dictionnaire<C, V> {

  class Entree<C, V> {

    //la clé associé à l'entrée
    private C cle;
    //la valeur associé à l'entrée
    private V valeur;

    /** 
     * Constructeur de la classe Entree
     * @param cle : la clé associé à l'entrée
     * @param valeur : la valeur associé à l'entrée
     * @return une entrée
    */
    public Entree(C cle, V valeur) {
      this.cle = cle;
      this.valeur = valeur;
    }
  }

  //liste qui va contenir les différentes entrée
  private ListeChainee<Entree<C,V>> liste = new ListeChainee<Entree<C,V>>();

  public DictionnaireChaine(){
    
  }

	/**
	 * Ajoute un couple <Clé, Valeur> au dictionnaire.
	 * @param cle : la clé attribuer à l'élément
	 * @param valeur : la valeur de l'élément
	 */  
  @Override
  public void inserer(C cle, V valeur) {

    boolean cleExiste = false;
    Entree<C, V> nouveauElement = new Entree<C, V>(cle, valeur);
    
    //Si le dictionnaire est vide, on ajoutele nouvel element
    if (liste.estVide())
      liste.ajouter(nouveauElement);

    //On boucle sur la liste pour regarder si la clé n'existe pas déjà
    for(int i = 0; i<liste.taille(); i++){
      nouveauElement = liste.element(i);
      if(nouveauElement.cle.equals(cle)) 
        nouveauElement.valeur = valeur;
    } 

    //Si la clé n'existe pas on ajoute un nouvel élément
    if(!cleExiste)
      liste.ajouter(nouveauElement);
  }

	/**
	 * Indique s'il existe une clé f dans le dictionnaire
	 * telle que f.equals(cle) est VRAI.
	 * @param cle : la cle d'un couple qui est associé à sa valeur
	 * @return vrai ssi le dictionnaire contient la clé
	 */
  @Override
  public boolean contient(C cle) {
    boolean resultat = false;
    Entree<C, V> element;

    if (liste.estVide()) {
      resultat = false;
    } else {
      //on boucle sur la liste pour voir si l'element existe
      for(int i = 0; i<liste.taille(); i++) {
        element = liste.element(i);
        if(element.cle.equals(cle)){
          resultat = true;
        }  
      }
    }
    return resultat;
  }

	/**
	 * Renvoie la valeur associée à la clé.
	 * @param cle : cle qui permet de rechercher sa valeur associé
	 * @return NULL si la clé n'existe pas. Sinon retourne valeur
	 */
  @Override
  public V valeur(C cle){

    V val = null;
    
    if (liste.estVide()) {
      val = null;
    } else {
      for(int i = 0; i<liste.taille();i++) {
        Entree<C, V> element = liste.element(i);
        if(element.cle.equals(cle)) 
          val = element.valeur;
        }
      }
    return val;
  }
    

}
