package fr.rodez3il.a2022.mrmatt.solveur;
import fr.rodez3il.a2022.mrmatt.solveur.Noeud;
import fr.rodez3il.a2022.mrmatt.solveur.structures.*;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Solveur {

	public static String trouverSolution(Niveau niveau) {
    
    DictionnaireChaine<Niveau, Noeud> configConnu = new DictionnaireChaine<>();
    
    Noeud noeudInitial = new Noeud(configConnu, niveau,"");
    
    ListeTableau<Noeud> aTraiter = new ListeTableau<>();
    
    ListeTableau<Noeud> traites = new ListeTableau<>(); 

    String solution = null;

    aTraiter.ajouter(noeudInitial);

    while (!aTraiter.estVide()){

      Noeud noeudTraiter = aTraiter.enlever(0);
      traites.ajouter(noeudTraiter);

      String solut = noeudTraiter.calculerFils();

      if(solut==null) {
        Noeud[] tabFils = noeudTraiter.getFils();
        for(int i = 0; i < tabFils.length; i++) {
          Noeud fils = tabFils[i];
          if(!aTraiter.contient(fils) && !traites.contient(fils))
            aTraiter.ajouter(fils);
        }
      } else {
        solution = solut;
      }
    }
		return solution;
	}
	
	public static void main(String[] args) {
		String solution = trouverSolution(new Niveau("niveaux/1rocher.txt"));
		if (solution == null) {
			System.out.println("Pas de solution.");
		} else {
			System.out.println("Une solution est : " + solution);
		}
	}

}
