package chifoumi.views;

import java.io.*;
import chifoumi.others.*;
import chifoumi.controlers.*;

public class ChifoumiViewConsole implements InterfaceChifoumiView
{
	public ChifoumiViewConsole()
	{

	}

	public boolean demanderSiContinuer()
	{
		System.out.println("Chifoumi, voulez-vous continuer la partie ? exit pour quitter");
		String réponse = System.console().readLine();
		if(réponse.equals("exit")) return false;
		return true;
	}

	public ValeursChifoumi demanderPropostion()
	{
		System.out.println("Que voulez-vous jouer ? [p]ierre, [f]euille, [c]iseaux");
		String réponse = System.console().readLine();
		switch(réponse)
		{
			case "p": return ValeursChifoumi.pierre;
			case "f": return ValeursChifoumi.feuille;
		}
		return ValeursChifoumi.ciseaux;
	}

	public void afficherScores(int humain, int ordi, int matchNul)
	{
		System.out.println("Joueur : " + humain + " | Ordinateur : " + ordi + " | Égalité : " + matchNul);
	}

	public void afficherEtatPartie(ValeursScore état)
	{
		String texte;
		switch(état)
		{
			case défaite: texte = "Vous avez perdu"; break;
			case victoire: texte = "Vous avez gagné"; break;
			default: texte = "Match nul";
		}
		System.out.println(texte);
	}
}