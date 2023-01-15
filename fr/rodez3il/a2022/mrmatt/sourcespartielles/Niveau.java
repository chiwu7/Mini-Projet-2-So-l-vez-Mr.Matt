package fr.rodez3il.a2022.mrmatt.sourcespartielles;

/**
 * Fourretout temporaire avant le 9/12/22
 * @author proussille
 *
 */

public class Niveau{

	///////////////////////////////////////////////////////////////////////

	// Méthodes supplémentaires pour le solveur.

	/**
	 * Indique si le déplacement passé en paramètre est possible.
	 * 
	 * @param direction
	 * @return VRAI ssi le déplacement est possible.
	 */
	public boolean deplacementPossible(Commande direction) {
		return false;
	}

	/**
	 * Réalise le déplacement passé en paramètre sur le niveau.
	 * @param direction Le déplacement à réaliser.
	 */
	public void deplacer(Commande direction) {
	}

	/**
	 * Calcule l'état fixe suivant (saute les états intermédiaires).
	 */
	public void calcule() {

	}

	/**
	 * Accesseur pour savoir si le joueur a gagné.
	 */
	public boolean estGagnant() {
		return false;
	}

	/**
	 * Renvoie la valeur du niveau sous forme de chaîne (pour déterminer les doublons).
	 */
	public String valeurChaine() {
		return "";
	}
}
