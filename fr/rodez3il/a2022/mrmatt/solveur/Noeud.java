package fr.rodez3il.a2022.mrmatt.solveur;

import fr.rodez3il.a2022.mrmatt.sources.*;
import fr.rodez3il.a2022.mrmatt.solveur.structures.*;

public class Noeud {

  private DictionnaireChaine<String, Noeud> config;
  private Niveau etat;
  private ListeTableau<Noeud> fils;
  private String commandes;
  private boolean visite;

  public Noeud(DictionnaireChaine<String, Noeud> config, Niveau etat, String commandes) {
    this.config = config;
    this.etat = etat;
    this.fils = new ListeTableau<>();
    this.commandes = commandes;
    this.visite = false;
  }

  public boolean estVisite() {
    return this.visite;
  }

  public ListeTableau<Noeud> getFils() {
    return this.fils;
  }

  public void ajouterFils(Noeud fils) {
    if (fils != null) {
      this.fils.ajouter(fils);
    }
  }

  public Niveau getEtat() {
    return this.etat;
  }

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

  public String calculerFils() {
    String victoire = null;
    String solution = null;
    this.visite = true;
      //on transforme l'état du niveau en un String
    config.inserer(etat.valeurChaine(), this);

      Commande[] commande = Commande.values();

      for (int i = 0; i < 4; i++) {
        //on regarde si le joueur peut se déplacer et si l
        if (etat.deplacementPossible(commande[i]) && etat.enCours()) {

          solution = this.commandes + " " + commande[i];
          
          Niveau nouvelEtat = etat.copier();

          //on déplace le joueur
          nouvelEtat.deplacer(commande[i]);

          //on calcule le future etat du niveau
          nouvelEtat.calcule();

          boolean gagnant = nouvelEtat.estGagnant();
          
          if (gagnant) {
            victoire = solution;
          } else {
            Noeud filsNoeud;
            
            if (config.contient(nouvelEtat.valeurChaine())) {
              
              filsNoeud = config.valeur(nouvelEtat.valeurChaine());
            } else {
              filsNoeud = new Noeud(this.config, nouvelEtat, solution);
              this.config.inserer(nouvelEtat.valeurChaine(), filsNoeud);
            }
            this.fils.ajouter(filsNoeud);
          }
        }
      }

    return victoire;
}

}
