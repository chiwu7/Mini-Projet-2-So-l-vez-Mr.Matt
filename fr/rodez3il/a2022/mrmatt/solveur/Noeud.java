package fr.rodez3il.a2022.mrmatt.solveur;
import fr.rodez3il.a2022.mrmatt.sources.*;
import fr.rodez3il.a2022.mrmatt.solveur.structures.*;

public class Noeud {

  private DictionnaireChaine<Niveau, Noeud> config;
  private Niveau etat;
  private ListeTableau<Noeud> fils;
  private String commandes;

  public Noeud(DictionnaireChaine<Niveau, Noeud> config, Niveau etat, String commandes) {
    this.config = config;
    this.etat = etat;
    this.fils = new ListeTableau<>();
    this.commandes = commandes;
  }

  public boolean estVisite(){
    boolean resultat = false;
    if (config.contient(etat)){
      resultat = true;
    }
    return resultat;
  }

  public ListeTableau<Noeud> getFils() {
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

  public void ajouterFils(Noeud fils) {
    if(fils != null) {
      this.fils.ajouter(fils);
    }
  }

  public String calculerFils() {
    String solution = null;
    if(estVisite()){
      solution = null;
    } else {
      config.inserer(etat, this);
    } 

    Commande[] commande = Commande.values();

    for(int i = 0; i<4; i++) {
      if(etat.jouer(commande[i]) && etat.enCours()) {
        
        String nouvellesCommandes = commandes + commande[i];

        Niveau nouvelEtat = etat.copier();
        nouvelEtat.deplacer(commande[i]);

        if(nouvelEtat.estGagnant()){
          return nouvellesCommandes;
          //System.out.println("Ici 1");
        } else {
          Noeud filsNoeud;
          if(config.contient(nouvelEtat)) {
            filsNoeud = config.valeur(nouvelEtat); 
          } else {
            filsNoeud = new Noeud(config, nouvelEtat, nouvellesCommandes);
          }
          this.fils.ajouter(filsNoeud);
        }
      }
    }
  return solution;
  }
  
  
}
