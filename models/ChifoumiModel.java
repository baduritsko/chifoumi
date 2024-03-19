package chifoumi.models;

import chifoumi.others.*;

public class ChifoumiModel
{
	private ValeursChifoumi valeurOrdi = null;

	private int scoreOrdi = 0;
	private int scoreHumain = 0;
	private int matchNul = 0;

	public ChifoumiModel()
	{
		this.retournerNouvelleValeur();
	}

	public ValeursChifoumi retournerNouvelleValeur()
	{
		int valeur = (int)(Math.random() * 3);
		switch(valeur)
		{
			case 0: this.valeurOrdi = ValeursChifoumi.pierre; break;
			case 1: this.valeurOrdi = ValeursChifoumi.feuille; break;
			default : this.valeurOrdi = ValeursChifoumi.ciseaux;
		}
		return this.valeurOrdi;
	}

	public String retournerTexte(ValeursChifoumi uneValeur)
	{
		switch(uneValeur)
		{
			case pierre: return "pierre";
			case feuille: return "feuille";
		}
		return "ciseaux";
	}

	public int getScoreOrdi() { return this.scoreOrdi; }
	public int getScoreHumain() { return this.scoreHumain; }
	public int getMatchNul() { return this.matchNul; }


	public String retournerScore()
	{
		return "";
	}

	public ValeursScore retournerResultat(ValeursChifoumi valeurHumain)
	{
		switch(valeurHumain)
		{
			case pierre: return this.evaluerResultat(ValeursChifoumi.pierre, ValeursChifoumi.feuille);
			case feuille: return this.evaluerResultat(ValeursChifoumi.feuille, ValeursChifoumi.ciseaux);
		}
		return this.evaluerResultat(ValeursChifoumi.ciseaux, ValeursChifoumi.pierre);
	}

	private ValeursScore evaluerResultat(ValeursChifoumi humain, ValeursChifoumi gagnant)
	{
		if(humain != this.valeurOrdi)
		{
			if(this.valeurOrdi == gagnant)
			{
				this.scoreOrdi++;
				return ValeursScore.défaite;
			}
			else
			{
				this.scoreHumain++;
				return ValeursScore.victoire;
			}
		}
		else
		{
			this.matchNul++;
			return ValeursScore.nul;
		}
	}

}