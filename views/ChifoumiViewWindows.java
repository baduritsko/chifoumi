package chifoumi.views;

import javax.swing.*;
import java.awt.*;
import chifoumi.others.*;
import chifoumi.controlers.*;

public class ChifoumiViewWindows extends JFrame implements InterfaceChifoumiView
{
	private JPanel contenu;
	private JLabel texte;
	private JLabel score;

	public ChifoumiViewWindows(ChifoumiControler controler)
	{
		super("Chifoumi"); //on définit le titre de la fenêtre
		this.initialise(controler); //une méthode pour configurer les éléments
	}

	private void initialise(ChifoumiControler controler)
	{
		//obligatoire, fermeture correcte de la fenêtre
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//récupération des informations de l'écran
		Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize(); 
		//positionnement de la fenêtre au milieu de l'écran
		this.setBounds((int)(ecran.width/2-200), (int)(ecran.height/2-200), 400, 100); 
		//fond blanc dans la fenêtre
		this.setBackground(Color.white);
		//suppression de la possibilité de modifier la forme de la fenêtre
		this.setResizable(false); 

		//création du premier JPanel		
		JPanel panneauPrincipal = new JPanel(new BorderLayout());

		//création et ajout du JLabel (commentaire résultat de partie)
		JLabel commentaire = new JLabel("Prêt pour le Chifoumi ?");
		commentaire.setHorizontalAlignment(SwingConstants.CENTER);
		panneauPrincipal.add(commentaire, BorderLayout.NORTH);

		this.texte = commentaire;

		//création et ajout du JLabel (affichage du score)
		this.score = new JLabel("Cliquez sur votre choix");
		this.score.setHorizontalAlignment(SwingConstants.CENTER);
		panneauPrincipal.add(this.score, BorderLayout.CENTER);

		//création du JPanel pour les boutons avec ajout
		JPanel groupeBoutons = new JPanel(new GridLayout(1, 2));
		groupeBoutons.add(new ChifoumiButton(controler, "Pierre", ValeursChifoumi.pierre));
		groupeBoutons.add(new ChifoumiButton(controler, "Feuille", ValeursChifoumi.feuille));
		groupeBoutons.add(new ChifoumiButton(controler, "Ciseaux", ValeursChifoumi.ciseaux));
		panneauPrincipal.add(groupeBoutons, BorderLayout.SOUTH);
		
		this.contenu = panneauPrincipal;

		//on ajoute les autres composants et si nécessaire des panneaux internes

		//le JPanel est ajouté à la JFrame et elle est affichée
		this.add(panneauPrincipal);
		this.setVisible(true); //en dernier
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
		this.texte.setText(texte);
	}

	public void afficherScores(int humain, int ordi, int matchNul)
	{
		this.score.setText("Joueur : " + humain + " | Ordinateur : " + ordi + " | Égalité : " + matchNul);
	}

	public ValeursChifoumi demanderPropostion() { return ValeursChifoumi.pierre; }

	public boolean demanderSiContinuer() { return false; }
}