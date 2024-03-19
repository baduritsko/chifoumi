package chifoumi.views;

import chifoumi.others.*;

public interface InterfaceChifoumiView
{
	public void afficherEtatPartie(ValeursScore état);

	public void afficherScores(int humain, int ordi, int matchNul);

	public ValeursChifoumi demanderPropostion();

	public boolean demanderSiContinuer();
}