/*
	Jeu du Chifoumi
	Support éducatif Java/MVC
	GPL-3.0-or-later
	Caryl Le Breton
*/

public class Program
{
	public enum ValeursChifoumi { pierre, feuille, ciseaux };
	
	public static void main(String[] args)
	{
		int scoreOrdi = 0;
		int scoreJoueur = 0;
		int matchNul = 0;
		ValeursChifoumi valeurOrdi;
		ValeursChifoumi valeurJoueur;
		boolean continuer = true;
		String réponse;
		String retour;
		
		do
		{
			//étape 1 : on sélectionne la valeur de l'ordinateur
			int valeur = (int)(Math.random() * 3); //valeur est un entier entre 0 et 2
			switch(valeur)
			{
				case 0: valeurOrdi = ValeursChifoumi.pierre; break;
				case 1: valeurOrdi = ValeursChifoumi.feuille; break;
				default : valeurOrdi = ValeursChifoumi.ciseaux;
			}

			//étape 2 : on demande au joueur de sélectionné une valeur
			System.out.println("Que voulez-vous jouer ? [p]ierre, [f]euille, [c]iseaux");
			réponse = System.console().readLine();
			switch(réponse)
			{
				case "p": valeurJoueur = ValeursChifoumi.pierre; break;
				case "f": valeurJoueur = ValeursChifoumi.feuille; break;
				default: valeurJoueur = ValeursChifoumi.ciseaux; break;
			}

			//étape 3 : on vérifie qui a gagné
			retour = "";
			if(valeurJoueur == valeurOrdi)
			{
				matchNul++;
				retour = "Match nul";
			}
			else
			{
				retour = "Vous avez perdu";
				if(valeurOrdi == ValeursChifoumi.pierre && valeurJoueur == ValeursChifoumi.feuille)
				{
					retour = "Vous avez gagné";
					scoreJoueur++;
				}
				else if(valeurOrdi == ValeursChifoumi.feuille && valeurJoueur == ValeursChifoumi.ciseaux)
				{
					retour = "Vous avez gagné";
					scoreJoueur++;
				}
				else if(valeurOrdi == ValeursChifoumi.ciseaux && valeurJoueur == ValeursChifoumi.pierre)
				{
					retour = "Vous avez gagné";
					scoreJoueur++;
				}
				else
				{
					scoreOrdi++;
				}
			}

			//étape 4 : on affiche le résultat et le score
			System.out.println(retour);
			System.out.println("Joueur : " + scoreJoueur + " | Ordinateur : " + scoreOrdi + " | Égalité : " + matchNul);

			//étape 5 : on demande au joueur s'il veut encore jouer
			System.out.println("Chifoumi, voulez-vous continuer la partie ? exit pour quitter");
			réponse = System.console().readLine();
			if(réponse.equals("exit"))
			{
				continuer = false;
			}
		} while(continuer);
	}
}