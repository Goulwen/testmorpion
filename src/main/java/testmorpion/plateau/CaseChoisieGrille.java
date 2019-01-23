package testmorpion.plateau;

import testmorpion.personne.Personne;

public class CaseChoisieGrille {

	private char imageJoueur;
	private Personne joueur;
	
	
	public CaseChoisieGrille(char imageJoueur, Personne joueur) {
		this.imageJoueur = imageJoueur;
		this.joueur = joueur;
	}
	
	public Personne getJoueur() {
		return this.joueur;
	}
	
	//Permet de retourné le signe du joueur : X ou O
	@Override
	public String toString() {
		return Character.toString(this.imageJoueur);
	}
	
}
