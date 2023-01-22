package fr.rodez3il.a2022.mrmatt.solveur;
import fr.rodez3il.a2022.mrmatt.sources.*;
import fr.rodez3il.a2022.mrmatt.solveur.structures.*;

public class Noeud {

  private DictionnaireChaine<Niveau, Noeud> config;
  private Niveau etat;
  private Noeud[] fils;
  private String commandes;

  public Noeud(DictionnaireChaine<Niveau, Noeud> config, Niveau etat, String commandes) {
    this.config = config;
    this.etat = etat;
    this.commandes = commandes;
  }

  public boolean estVisite(){
    boolean resultat = false;
    if (config.contient(etat)){
      resultat = true;
    }
    return resultat;
  }

  public Noeud[] getFils() {
    return this.fils;
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

  public void calculerFils() {
    if(estVisite()){
      
    } else {
      config.inserer(etat, this);
    } 

    Commande[] commande = Commande.values();

    for(int i = 0; i<4; i++) {
      
      if(etat.deplacementPossible(commande[i]) && etat.enCours()) {

        String nouvellesCommandes = commandes + commande[i];

        Niveau nouvelEtat = etat.copier();

        if(nouvelEtat.estGagnant()){
          System.out.println("La solution est : " + nouvellesCommandes);
        } else {
          Noeud filsNoeud;

          if(config.contient(nouvelEtat)) {
            filsNoeud = config.valeur(nouvelEtat); 
          } else {
            filsNoeud = new Noeud(config, nouvelEtat, nouvellesCommandes);
          }
          fils[i] = filsNoeud;
        }
      }
    }

  }
  
  
}
