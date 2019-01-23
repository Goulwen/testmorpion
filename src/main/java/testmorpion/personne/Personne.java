package testmorpion.personne;

import testmorpion.plateau.CaseChoisieGrille;

public class Personne {

	private int personneId;
	private CaseChoisieGrille imageJoueur;
	
	public Personne(int personneId, char imageJoueur) {
		this.personneId = personneId;
		this.imageJoueur = new CaseChoisieGrille(imageJoueur, this);
	}
	
	public CaseChoisieGrille getImageJoueur() {
		return this.imageJoueur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageJoueur == null) ? 0 : imageJoueur.hashCode());
		result = prime * result + personneId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Personne) {
			Personne personne = (Personne) obj;
			return personne.personneId == this.personneId;
		}
		else {
			return false;
		}
	}
	
	
}
