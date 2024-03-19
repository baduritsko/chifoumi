package chifoumi.controlers;

import chifoumi.others.*;
import chifoumi.controlers.*;
import chifoumi.models.*;
import chifoumi.views.*;

public class ChifoumiControlerWindows extends ChifoumiControler
{
	public ChifoumiControlerWindows()
	{
		jeu = new ChifoumiModel();
		vue = new ChifoumiViewWindows(this);
	}
}