package testmorpion.plateau;

import java.util.Arrays;

import testmorpion.personne.Personne;

public class Grille {

	private CaseGrille[] cases;
	
	public Grille() {
		this.cases = new CaseGrille[9];
		this.clean();
	}
	
	public Personne getJoueurGrilleChoisie(int id) {
		return this.cases[id].getcaseChoisieGrille();
	}
	
	public void setJoueurCase(int caseId, CaseChoisieGrille caseChoisieGrille) {
		this.cases[caseId].setCaseChoisieGrille(caseChoisieGrille);
	}
	
	//Pour connaitre si joueur a ligne pour gagner
	private Personne getLigneWinner() {
		Personne winner = null;
		
		for (int i = 0; i < 3; ++i) {
			Personne tmpPersonne = getJoueurGrilleChoisie(0 + i * 3);
			if (tmpPersonne == null) {
				continue;
			}
			if (tmpPersonne != null && tmpPersonne.equals(getJoueurGrilleChoisie(1 + i * 3))) {
				if (tmpPersonne.equals(getJoueurGrilleChoisie(2 + i * 3))) {
					winner = tmpPersonne;
					break;
				}
			}
		}
		return winner;
	}
	
	//Pour connaitre si joueur a colonne pour gagner
	private Personne getColonneWinner() {
		Personne winner = null;
		
		for (int i = 0; i < 3; ++i) {
			Personne tmpPersonne = getJoueurGrilleChoisie(i + 0 * 3);
			if (tmpPersonne == null) {
				continue;
			}
			if (tmpPersonne != null && tmpPersonne.equals(getJoueurGrilleChoisie(i + 1 * 3))) {
				if (tmpPersonne.equals(getJoueurGrilleChoisie(i + 2 * 3))) {
					winner = tmpPersonne;
					break;
				}
			}
		}
		return winner;
	}
	
	public Personne getWinner() {
		Personne winner = null;
		
		winner = getLigneWinner();
		if (winner != null) {
			return winner;
		}
		
		winner = getColonneWinner();
		if (winner != null) {
			return winner;
		}
		
		//Pour connaitre si joueur a diagonale hautGauche-basDroite pour gagner
		Personne tmpPersonne = getJoueurGrilleChoisie(0);
		if (tmpPersonne != null && tmpPersonne.equals(getJoueurGrilleChoisie(4))) {
			if (tmpPersonne.equals(getJoueurGrilleChoisie(8))) {
				return tmpPersonne;
			}
		}
		
		//Pour connaitre si joueur a diagonale hautDroite-basGauche pour gagner
		tmpPersonne = getJoueurGrilleChoisie(2);
		if (tmpPersonne != null && tmpPersonne.equals(getJoueurGrilleChoisie(4))) {
			if (tmpPersonne.equals(getJoueurGrilleChoisie(6))) {
				return tmpPersonne;
			}
		}
		
		return winner;
	}
	
	//Pour savoir si la grille est pleine
	public boolean grillePleine() {
		boolean grillePleine = true;
		
		for (int i = 0; i < this.cases.length; ++i) {
			if(this.cases[i].caseGrilleVide()) {
				grillePleine = false;
				break;
			}
		}
		return grillePleine;
	}
	
	//Pour re initialiser une grille de 0
	public void clean() {
		for (int i = 0; i < this.cases.length; i++) {
			if (this.cases[i] == null) {
			this.cases[i] = new CaseGrille(i);
			}
			else {
				this.cases[i].setCaseChoisieGrille(null);
			}
		}
	}

	//Pour afficher la grille :
	//╔═══╦═══╦═══╗
	//╠═══╬═══╬═══╣
	//╠═══╬═══╬═══╣
	//╚═══╩═══╩═══╝
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("╔═══╦═══╦═══╗").append(System.lineSeparator());
		builder.append("║ ").append(this.cases[0]).append(" ║ ").append(this.cases[1]).append(" ║ ").append(this.cases[2]).append(" ║").append(System.lineSeparator());
		builder.append("╠═══╬═══╬═══╣").append(System.lineSeparator());
		builder.append("║ ").append(this.cases[3]).append(" ║ ").append(this.cases[4]).append(" ║ ").append(this.cases[5]).append(" ║").append(System.lineSeparator());
		builder.append("╠═══╬═══╬═══╣").append(System.lineSeparator());
		builder.append("║ ").append(this.cases[6]).append(" ║ ").append(this.cases[7]).append(" ║ ").append(this.cases[8]).append(" ║").append(System.lineSeparator());
		builder.append("╚═══╩═══╩═══╝").append(System.lineSeparator());
		
		return builder.toString();
	}
	
	
	
}
