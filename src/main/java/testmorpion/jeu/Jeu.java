package testmorpion.jeu;

import java.util.Scanner;

import testmorpion.personne.Input;
import testmorpion.personne.Personne;
import testmorpion.plateau.Grille;

public class Jeu {

	private Grille grille;
	private Personne joueur;
	private Personne ordinateur;
	private Personne joueurCourrant;
	
	public Jeu() {
		this.grille = new Grille();
		this.joueur = new Personne(0, 'O');
		this.ordinateur = new Personne(1, 'X');
	}
	
	//Pour changer de joueur
	private void changerJoueur() {
		if (this.joueurCourrant.equals(this.joueur)) {
			this.joueurCourrant = this.ordinateur;
		}
		else {
			this.joueurCourrant = this.joueur;
		}
	}
	
	private int getJoueurInput (Scanner scan) {
		int input = -1;
		while (true) {
			System.out.println("Joueur " + this.joueurCourrant.getImageJoueur() + " à toi de jouer");
			input = Input.lecturePosition(scan);
			
			if(0 <= input && input <= 8) {
				break;
			}
		}
		
		return input;
	}
	
	public void afficherGrille() {
		System.out.flush();
		System.out.println(this.grille);
	}
	
	public void start() {
		this.joueurCourrant = this.joueur;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			afficherGrille();
			int input = getJoueurInput(scan);
			this.grille.setJoueurCase(input, this.joueurCourrant.getImageJoueur());
			
			if (this.grille.getWinner() != null) {
				System.out.println(this.joueurCourrant.getImageJoueur() + " a gagné");
				afficherGrille();
				break;
			}
			else if (this.grille.grillePleine()) {
				System.out.println("Match nul");
				afficherGrille();
				break;
			}
		
			changerJoueur();
		}
		scan.close();
	}
	
	public void reinitialise() {
		this.grille.clean();
	}
	
}
 