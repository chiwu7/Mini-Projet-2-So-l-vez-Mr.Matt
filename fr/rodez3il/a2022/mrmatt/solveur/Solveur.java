package fr.rodez3il.a2022.mrmatt.solveur;
import fr.rodez3il.a2022.mrmatt.solveur.Noeud;
import fr.rodez3il.a2022.mrmatt.solveur.structures.*;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Solveur {

  /**
   * Trouve une solution pour un niveau donnée
   * @param le niveau pour lequel on cherche une solution
   * @return la chaine de caractères représentant la solution du niveau
  */
	public static String trouverSolution(Niveau niveau) {

  DictionnaireChaine<String, Noeud> configConnu = new DictionnaireChaine<>();
    
  Noeud noeudInitial = new Noeud(configConnu, niveau, "");
    
  ListeTableau<Noeud> aTraiter = new ListeTableau<>();
  ListeTableau<Noeud> traite = new ListeTableau<>();

  aTraiter.ajouter(noeudInitial);

  String solution = null;

  //tant que la liste est pas vide et qu'on a pas trouvé la solution, on boucle
  while (!aTraiter.estVide() && solution == null){

    //on récupère la valeur du premier noeud de la liste à traiter
    Noeud n = aTraiter.enlever(0);
    //on l'ajoute à la liste des noeud traités
    traite.ajouter(n);

    //on calcule les fils du noeud que l'on traite
    solution = n.calculerFils();

    //Si on a pas de solution
    if(solution == null) {
      //on recupère la liste des fils du noeud qu'on traite
      ListeTableau<Noeud> tabFils = n.getFils();
      //on boucle sur la liste pour récupèrer les noeuds individuellement
      for(int i = 0; i < tabFils.taille(); i++) {
        Noeud fils = tabFils.element(i);
        //si ils sont dans aucune liste et qu'ils n'ont pas été visité on les ajoute à la liste aTraiter
        if(!aTraiter.contient(fils) && !traite.contient(fils) && !fils.estVisite())
          aTraiter.ajouter(fils);
      }
    } 

  } 
  return solution;
}

	
	public static void main(String[] args) {
		String solution = trouverSolution(new Niveau("fr/niveaux/1rocher.txt"));
		if (solution == null) {
			System.out.println("Pas de solution.");
		} else {
			System.out.println("Une solution est : " + solution);
		}
	}

}
