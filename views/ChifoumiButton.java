package chifoumi.views;

import chifoumi.others.*;
import chifoumi.controlers.*;
import javax.swing.*;
import java.awt.event.*;

public class ChifoumiButton extends JButton implements ActionListener
{
	private ValeursChifoumi valeur;
	private ChifoumiControler controler;

	public ChifoumiButton(ChifoumiControler controler, String nom, ValeursChifoumi valeur)
	{
		super();
		this.valeur = valeur;
		this.controler = controler;
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		this.controler.runPartie(this.valeur);
	}
}