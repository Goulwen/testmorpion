package testmorpion.plateau;

import testmorpion.personne.Personne;

public class CaseGrille {

	private int caseId;
	private CaseChoisieGrille contenu;

	public CaseGrille(int caseId) {
		this.caseId = caseId;
		this.contenu = null;
	}

	public CaseGrille(int caseId, CaseChoisieGrille caseChoisieGrille) {
		this.caseId = caseId;
		this.contenu = caseChoisieGrille;
	}
	
	public void setCaseChoisieGrille(CaseChoisieGrille caseChoisieGrille) {
		this.contenu = caseChoisieGrille;
	}
	
	public Personne getcaseChoisieGrille() {
		if (this.contenu != null) {
			return this.contenu.getJoueur();
		}
		else {
			return null;
		}
	}
	
	public boolean caseGrilleVide() {
		return this.contenu == null;
	}

	@Override
	public String toString() {
		if (this.contenu != null)
			return this.contenu.toString();
		else
			return Integer.toString(this.caseId);
	}

}
