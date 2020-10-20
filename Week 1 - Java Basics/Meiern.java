public class Meiern extends MiniJava
{
	public static void main(String[] args)
	{
		int a, b, x, y, c, z, ps, pc;
		ps = 0; pc = 0;
		write("Würfeln Spieler");
		a = dice(); b = dice();
		if(a > b)
		{
			c = 10*a + b;
		}
		else
		{
			c = 10*b + a;
		}
		write("Die gewürfelten Zahlen waren:" + a + " " + b);
		write("Daraus ergibt sich der Wurf:"); write(c);
		ps = c;
		if(a == b)
		{
			write("Pasch!");
			ps = ps*100;
		}
		else if(c == 21)
		{
			write("Es wurde ein Meier gewürfelt: Sieg Spieler. Das Spiel wird beendet.");
			return;
		}
		write("Würfeln Computer");
		x = dice(); y = dice();
		if(x > y)
		{
			z = 10*x + y;
		}
		else
		{
			z = 10*y + x;
		}
		write("Die gewürfelten Zahlen waren"); write(x); write(y);
		write("Daraus ergibt sich der Wurf:"); write(z);
		pc = z;
		if(x == y)
		{
			write("Pasch!");
			pc = pc*100;
		}
		else if(z == 21)
		{
			write("Es wurde ein Meier gewürfelt: Sieg Computer. Das Spiel wird beendet.");
			return;
		}
		if(pc <= ps)
		{
			write("Der Wurf des Spielers konnte vom Computer nicht überboten werden: Sieg Spieler. Das Spiel wird beendet.");
			return;
		}
		write("Der Wurf des Spielers wurde vom Computer überboten. Es wird eine neue Runde gestartet.");
		
		while(ps != pc)
		{
			write("Würfeln Spieler");
			a = dice(); b = dice();
			if(a > b)
			{
				c = 10*a + b;
			}
			else
			{
				c = 10*b + a;
			}
			write("Die gewürfelten Zahlen waren:"); write(a); write(b);
			write("Daraus ergibt sich der Wurf:"); write(c);
			ps = c;
			if(a == b)
			{
				write("Pasch!");
				ps = ps*100;
			}
			else if(c == 21)
			{
				write("Es wurde ein Meier gewürfelt: Sieg Spieler. Das Spiel wird beendet.");
				return;
			}
			else if(ps <= pc)
			{
				write("Der Wurf des Computers konnte nicht überboten werden: Sieg Computer. Das Spiel wird beendet.");
				return;
			}
			else
			{
				write("Der Wurf des Computers wurde überboten. Es würfelt der Computer.");
			}
			write("Würfeln Computer");
			write("Die gewürfelten Zahlen waren"); write(x); write(y);
			write("Daraus ergibt sich der Wurf:"); write(z);
			pc = z;
			if(x == y)
			{
				write("Pasch!");
				pc = pc*100;
			}
			else if(z == 21)
			{
				write("Es wurde ein Meier gewürfelt: Sieg Computer. Das Spiel wird beendet.");
				return;
			}
			else if(pc <= ps)
			{
				write("Der Wurf des Spielers konnte nicht überboten werden: Sieg Spieler. Das Spiel wird beendet.");
				return;
			}
			else
			{
				write("Der Wurf des Spielers wurde vom Computer überboten. Es wird eine neue Runde gestartet.");
			}
		}
	}
}
