package chifoumi.controlers;

import chifoumi.others.*;
import chifoumi.models.*;
import chifoumi.views.*;

public abstract class ChifoumiControler
{
	protected ChifoumiModel jeu;
	protected InterfaceChifoumiView vue;

	public ChifoumiControler()
	{
		jeu = new ChifoumiModel();
	}

	public void runPartie(ValeursChifoumi valeur)
	{
		vue.afficherEtatPartie(jeu.retournerResultat(valeur));
		vue.afficherScores(jeu.getScoreHumain(), jeu.getScoreOrdi(), jeu.getMatchNul());
		jeu.retournerNouvelleValeur();
	}
}