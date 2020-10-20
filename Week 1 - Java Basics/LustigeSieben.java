public class LustigeSieben extends MiniJava {
	public static void main(String[] args) {
		
		int guthaben, einsatz, feld;
		int x, y, z, i;
		guthaben = 100;
		
		while(guthaben != 0)
		{
		feld = readInt("Auf welches Feld möchten Sie setzen?");
		if(feld == 0)
		{
			return;
		}
		while(feld < 2 || feld > 12)
		{
			feld = readInt("Bitte ein Feld zwischen 2 und 12 auswählen.");
			if(feld == 0)
			{
				return;
			}
		}
		einsatz = readInt("Welchen Einsatz möchten Sie auf das gewählte Feld setzen?");
		if(einsatz == 0)
		{
			return;
		}
		while(einsatz > guthaben)
		{
			write("Bitte einen Einsatz eingeben, der nicht größer als Ihr Guthaben ist.");
			write("Zur Erinnerung, ihr Guthaben beträgt:"); write(guthaben);
			einsatz = readInt("Welchen Einsatz möchte Sie auf das gewählte Feld setzen?");
			if(einsatz == 0)
			{
				return;
			}
		}
		guthaben = guthaben - einsatz;
		x = dice(); y = dice();
		z = x + y;
		if(z > 2 && z < 8 && z != 7)
		{
			i = 0;
		}
		else if(z != 7)
		{
			i = 1;
		}
		else
		{
			i = 2;
		}
		write("Die Summe der gewürfelten Augenzahlen ist"); write(z);
		if(z == 7 && feld == 7)
		{
			write("Glückwunsch, das Würfelergebnis ist 7. Sie erhalten den 3-fachen Einsatz zurück.");
			guthaben = guthaben + 3*einsatz;
			write("Ihr aktuelles Guthaben beträgt:"); write(guthaben);
		}
		else if(z == feld)
		{
			write("Glückwunsch, das Würfelergebnis entspricht dem gewählten Feld. Sie erhalten den 2-fachen Einsatz zurück.");
			guthaben = guthaben + 2*einsatz;
			write("Ihr aktuelles Guthaben beträgt:"); write(guthaben);
		}
		else if(i == 0 && feld <= 6)
		{
			write("Glückwunsch, das Würfelergebnisist ist auf derselben Längsseite, wie das gewählte Feld. Sie erhalten Ihren Einsatz zurück.");
			guthaben = guthaben + einsatz;
			write("Ihr aktuelles Guthaben beträgt:"); write(guthaben);
		}
		else if(i == 1 && feld >= 8)
		{
			write("Glückwunsch, das Würfelergebnisist ist auf derselben Längsseite, wie das gewählte Feld. Sie erhalten Ihren Einsatz zurück.");
			guthaben = guthaben + einsatz;
			write("Ihr aktuelles Guthaben beträgt:"); write(guthaben);
		}
		else
		{
			write("Schade, kein Gewinn.");
			write("Ihr aktuelles Guthaben beträgt:"); write(guthaben);
			if(guthaben == 0)
			{
				write("Sie haben kein Guthaben mehr. Das Spiel wird beendet.");
			}
		}
		}
	}
}
