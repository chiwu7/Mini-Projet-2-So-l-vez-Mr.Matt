package fr.rodez3il.a2022.mrmatt.solveur;
import fr.rodez3il.a2022.mrmatt.solveur.Noeud;
import fr.rodez3il.a2022.mrmatt.solveur.structures.*;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Solveur {

	public static String trouverSolution(Niveau niveau) {

  DictionnaireChaine<String, Noeud> configConnu = new DictionnaireChaine<>();
    
  Noeud noeudInitial = new Noeud(configConnu, niveau, "");
    
  ListeTableau<Noeud> aTraiter = new ListeTableau<>();
  ListeTableau<Noeud> traite = new ListeTableau<>();

  aTraiter.ajouter(noeudInitial);

  String solution = null;

  while (!aTraiter.estVide() && solution ==null){

    Noeud n = aTraiter.enlever(0);
    traite.ajouter(n);
  
    solution = n.calculerFils();
    
    if(solution==null) {
      ListeTableau<Noeud> tabFils = n.getFils();
      for(int i = 0; i < tabFils.taille(); i++) {
        Noeud fils = tabFils.element(i);
        if(!aTraiter.contient(fils) && !traite.contient(fils) && !fils.estVisite()){

          aTraiter.ajouter(fils);
        }
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
