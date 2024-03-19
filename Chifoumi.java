package chifoumi;

import chifoumi.controlers.*;

public class Chifoumi
{
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			Chifoumi.afficherAide();
		}
		if(args.length > 0)
		{
			switch(args[0])
			{
				
				case "-c", "--console": new ChifoumiControlerConsole(); break;
				case "-w", "--windows": new ChifoumiControlerWindows(); break;
				default: Chifoumi.afficherAide();
			}
		}
	}

	public static void afficherAide()
	{
		System.out.println("Aide de Chifoumi");
		System.out.println("--console, -c : pour démarrer en mode console");
		System.out.println("--windows, -w : pour démarrer en mode graphique");
	}

}