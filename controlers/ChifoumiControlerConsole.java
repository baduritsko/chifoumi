package chifoumi.controlers;

import chifoumi.others.*;
import chifoumi.models.*;
import chifoumi.views.*;

public class ChifoumiControlerConsole extends ChifoumiControler
{	
	public ChifoumiControlerConsole()
	{
		jeu = new ChifoumiModel();
		vue = new ChifoumiViewConsole();
		jeu.retournerNouvelleValeur();
		do
		{
			runPartie(vue.demanderPropostion());
		} while(vue.demanderSiContinuer());
	}
}