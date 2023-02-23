package fr.rodez3il.a2022.mrmatt.solveur;

import fr.rodez3il.a2022.mrmatt.sources.*;
import fr.rodez3il.a2022.mrmatt.solveur.structures.*;

public class Noeud {

  //dictionnaire qui va stocker les différentes configurations connues
  private DictionnaireChaine<String, Noeud> config;
  //référence vers l'état du niveau actuel
  private Niveau etat;
  //fils du noeud
  private ListeTableau<Noeud> fils;
  //représente la succession de commandes
  private String commandes;
  //permet de connaitre l'état de visite du noeud.
  private boolean visite;
  //chaine de caractère de la solution du niveau
  private String solution = null;
  //chaine de caractère représentant la succession des commandes
  private String suiteCommandes;
  //représente l'état du niveau sous forme de caractères
  private String valChaine;

  /**
   * Constructeur pour la classe Noeud.
   * @param config Le dictionnaire associant une commande à un Noeud.
   * @param etat Le niveau actuel.
   * @param commandes La succession de commandes associées à ce Noeud.
   * @return un nouveau noeud
   */
  public Noeud(DictionnaireChaine<String, Noeud> config, Niveau etat, String commandes) {
    this.config = config;
    this.etat = etat;
    this.fils = new ListeTableau<>();
    this.commandes = commandes;
    this.visite = false;
  }

  /**
   * Indique si le noeud à déjà été visité.
   * @return vrai ssi le noeud à été visité
   */  
  public boolean estVisite() {
    return this.visite;
  }

  /**
   * Retourne la liste des fils du noeud actuel
   * @return la liste du noeud actuel
   */  
  public ListeTableau<Noeud> getFils() {
    return this.fils;
  }

  /**
   * Redéfinition de la méthode equals
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (obj instanceof Noeud)
      return false;
    Noeud other = (Noeud) obj;
    if (config == null) {
      if (other.config != null)
        return false;
    } else if (!config.equals(other.config))
      return false;
    if (etat == null) {
      if (other.etat != null)
        return false;
    } else if (!etat.equals(other.etat))
      return false;
    if (fils == null) {
      if (other.fils != null)
        return false;
    } else if (!fils.equals(other.fils))
      return false;
    if (commandes == null) {
      if (other.commandes != null)
        return false;
    } else if (!commandes.equals(other.commandes))
      return false;
    return true;
  }

  /**
   * Calcule les fils du noeud actuel
   * @return retourne la solution du niveau ssi le niveau est gagnant. Sinon retourne null
  */
  
  public String calculerFils() {
    this.visite = true;
    //on le noeud actuel avec l'état du niveau dans le dictionnaire de configurations
    config.inserer(etat.valeurChaine(), this);
      //on récupère les valeurs de l'énumérations
      Commande[] commande = Commande.values();
      //On boucle 4 fois pour passer dans toutes les directions
      for (int i = 0; i < 4; i++) {
        //on regarde si le joueur peut se déplacer et si la partie de jeu (niveau) est toujours en cours
        if (etat.deplacementPossible(commande[i]) && etat.enCours()) {

          suiteCommandes = this.commandes + " " + commande[i];

          //on copie l'etat du niveau
          Niveau nouvelEtat = etat.copier();

          //on déplace le joueur
          nouvelEtat.deplacer(commande[i]);

          //on calcule le future etat du niveau
          nouvelEtat.calcule();

          boolean gagnant = nouvelEtat.estGagnant();

          //Si le niveau est gagant, on renvoie la chaine de caractère contenant la solution
          if (gagnant) {
            solution = suiteCommandes;
          } else {
            Noeud filsNoeud;
            //on calcule la valeurChaine du niveau
            valChaine = nouvelEtat.valeurChaine();
            //on regarde si elle est dans le dictionnaire des configurations
            if (config.contient(valChaine)) {
              //si elle est dans le dictionnaire, on récupère sa valeur
              filsNoeud = config.valeur(valChaine);
            } else {
              //si elle est pas dans le dictionnaire on l'ajoute
              filsNoeud = new Noeud(this.config, nouvelEtat, suiteCommandes);
              this.config.inserer(valChaine, filsNoeud);
            }
            //on ajoute le noeud à la liste
            this.fils.ajouter(filsNoeud);
          }
        }
      }

    return solution;
}

}
