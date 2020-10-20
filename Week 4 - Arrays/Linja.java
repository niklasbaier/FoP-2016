public class Linja extends MiniJava {

    private static int[][] spielfeld = new int[8][6];
    
    // jeweils ein Array mit 12 (max.) freien Stellen fuer die Steine, die die Ziellinie ueberqueren
    private static int[] pos_ziellinie = new int[12];
    private static int[] neg_ziellinie = new int[12];

    /**
     * initialisiert das Spielfeld 
     * Ziellinie fuer Spieler 1 ist Zeile 7
     * Ziellinie fuer Spieler -1 ist Zeile 0
     */
    private static void initSpiel() {
        for (int i = 0; i < spielfeld.length; i++) {
            if (i != 0 && i != spielfeld.length - 1) {
                spielfeld[i] = new int[]{-(12 - i + 1), 0, 0, 0, 0, 6 + i};
            }
            if (i == 0) {
                spielfeld[i] = new int[]{1, 2, 3, 4, 5, 6};
            }
            if (i == spielfeld.length - 1) {
                spielfeld[i] = new int[]{-6, -5, -4, -3, -2, -1};
            }
        }
    }

    /**
     *
     * @return formatiertes aktuelles Spielfeld
     */
    private static String output() {
        String tmp = "Spieler 1 spielt von oben nach unten\n"
                + "Spieler -1 spielt von unten nach oben\n";
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                tmp = tmp + "\t" + spielfeld[i][j];
            }
            tmp = tmp + "\n";
        }
        return tmp;
    }

    /**
     * @return true, wenn die Eingabe stein im richtigen Wertebereich liegt und
     * zum Spieler gehoert; false, sonst
     */
    private static boolean gueltigeEingabe(int stein, int spieler) {
    
    //TODO
    	if(spieler == 1) {
    		if(stein >= 1 && stein <= 12) {
    			if(analysiereFeld(stein) == true) {
    				return true;	
    			}
    		}
    	} else if(spieler == -1) {
    		if(stein <= -1 && stein >= -12) {
    			if(analysiereFeld(stein) == true) {
        			return true;
    			}
    		}
    	}	
    	return false;
    }

    /**
     * @param stein kann Werte -1 bis -12 und 1 bis 12 haben
     * @return gibt x-Koordinate von stein an Position 0 und die y-Koordinaten
     * von stein an Position 1 zurueck; falls stein nicht gefunden, wird {-1,-1}
     * zurueckgegeben
     */
    private static int[] findeStein(int stein) {
    
    //TODO
    	int[] tmp = new int[2];
    	
    	for(int i = 0; i < spielfeld.length; i++) {
    		tmp[1] = i;
    		for(int j = 0; j < spielfeld[i].length; j++) {
    			tmp[0] = j;
    			if(stein == spielfeld[i][j]) {
    				return tmp;
    			}
    		}
    	}
    	tmp[0] = -1;
    	tmp[1] = -1;
    	return tmp;
    }

    /**
     * @param reihe hat Werte 0 bis 7
     * @return Anzahl der Steine in einer Reihe
     */
    private static int steineInReihe(int reihe) {
    
    //TODO
    	int counter = 0;

    	for(int j = 0; j < spielfeld[reihe].length; j++) {
    		if(spielfeld[reihe][j] != 0) {
    			counter++;
    		}
    	}
    	return counter;
    }

    /**
     * Ueberprueft, ob der Zug zulaessig ist und fuehrt diesen aus, wenn er
     * zulaessig ist.
     *
     * @param vorwaerts == true: Zug erfolgt vorwaerts aus Sicht des
     * Spielers/Steins vorwearts == false: Zug erfolgt rueckwaerts aus Sicht des
     * Spielers/Steins
     * @return Rueckgabe -1: Zug nicht zulaessig Rueckgabe 0-5: Weite des
     * potentiellen naechsten Zugs (falls Folgezug folgt) Rueckgabe 6: Ziellinie
     * wurde genau getroffen (potentieller Bonuszug)
     *
     */
    private static int setzeZug(int stein, int weite, boolean vorwaerts) {
    
    //TODO
    	int[] tmp = findeStein(stein);
    	int zuege = 0;
    	int i = 0;
    	
    	if(stein > 0) {
    		// Spieler 1 zieht
    		if(vorwaerts == true) {
    			// SONDERFAELLE
    			// Der Stein landet auf der Ziellinie (ergibt Bonus Zug); ueberzaehlige Schritte verfallen
    			if(tmp[1] + weite == 7) {
        			spielfeld[tmp[1]][tmp[0]] = 0;
        			while(i < pos_ziellinie.length) {
        				if(pos_ziellinie[i] == 0) {
        					break;
        				}
        				i++;
        			}
        			pos_ziellinie[i] = stein;
    				return 6;
    			} else if(tmp[1] + weite > 7) {
        			while(i < pos_ziellinie.length) {
        				if(pos_ziellinie[i] == 0) {
        					break;
        				}
        				i++;
        			}
        			pos_ziellinie[i] = stein;
        			spielfeld[tmp[1]][tmp[0]] = 0;
    				return 0;
    			}
        		// Ist die Reihe, in die gezogen werden soll besetzt?
        		if(steineInReihe(tmp[1] + weite) == 6) {
        			return -1;
        		} else if(steineInReihe(tmp[1] + weite) == 0) {
	    			spielfeld[tmp[1]][tmp[0]] = 0;
	    			spielfeld[tmp[1] + weite][neuePosition(tmp[1] + weite)] = stein;
        			return 0;
        		}
        		// Globale Variable spielfeld wird ueberschrieben
    			spielfeld[tmp[1]][tmp[0]] = 0;
    			zuege = steineInReihe(tmp[1] + weite);
    			spielfeld[tmp[1] + weite][neuePosition(tmp[1] + weite)] = stein;
    		} else {
	    			// Darf ich ueberhaupt zurueckziehen?
	    			if(tmp[1] == 0) {
	    				return -1;
	    			} else if(steineInReihe(tmp[1] - weite) == 6) {
	    				return -1;
	    			}
	        		// Globale Variable spielfeld wird ueberschrieben
	    			spielfeld[tmp[1]][tmp[0]] = 0;
	    			zuege = steineInReihe(tmp[1] - weite);
	    			spielfeld[tmp[1] - weite][neuePosition(tmp[1] - weite)] = stein;
    		}
    	} else {
    		// Spieler -1 zieht
    		if(vorwaerts == true) {
    			// SONDERFAELLE
    			// Der Stein landet auf der Ziellinie (ergibt Bonus Zug); ueberzaehlige Schritte verfallen
    			if(tmp[1] - weite == 0) {
        			spielfeld[tmp[1]][tmp[0]] = 0;
        			while(i < neg_ziellinie.length) {
        				if(neg_ziellinie[i] == 0) {
        					break;
        				}
        				i++;
        			}
        			neg_ziellinie[i] = stein;
    				return 6;
    			} else if(tmp[1] - weite < 0) {
        			spielfeld[tmp[1]][tmp[0]] = 0;
        			while(i < neg_ziellinie.length) {
        				if(neg_ziellinie[i] == 0) {
        					break;
        				}
        				i++;
        			}
        			neg_ziellinie[i] = stein;
        			spielfeld[tmp[1]][tmp[0]] = 0;
    				return 0;
    			}
    			// Ist die Reihe, in die gezogen werden soll besetzt?
    			if(steineInReihe(tmp[1] - weite) == 6) {
    				return -1;
    			} else if(steineInReihe(tmp[1] - weite) == 0) {
	    			spielfeld[tmp[1]][tmp[0]] = 0;
	    			spielfeld[tmp[1] - weite][neuePosition(tmp[1] - weite)] = stein;
    				return 0;
    			}
    			// Globale Variable spielfeld wird ueberschrieben
    			spielfeld[tmp[1]][tmp[0]] = 0;
    			zuege = steineInReihe(tmp[1] - weite);
    			spielfeld[tmp[1] - weite][neuePosition(tmp[1] - weite)] = stein;
    		} else {
    			// Darf ich ueberhaupt zurueckziehen?
    			if(tmp[1] == 7) {
    				return -1;
    			} else if(steineInReihe(tmp[1] + weite) == 6) {
    				return -1;
    			}
        		// Globale Variable spielfeld wird ueberschrieben
    			spielfeld[tmp[1]][tmp[0]] = 0;
    			zuege = steineInReihe(tmp[1] + weite);
    			spielfeld[tmp[1] + weite][neuePosition(tmp[1] + weite)] = stein;
    		}
    	}
		return zuege;
    }

    /**
     * @return true, falls die Bedingungen des Spielendes erfuellt sind, d.h. 
     * alle Steine des einen Spielers sind an den Steinen des gegnerischen Spielers
     * vorbeigezogen
     *
     */
    private static boolean spielende() {
    
    //TODO
    	int init_pos = 7;
    	int init_neg = 0;
    	int tmp[] = new int[2];
    	
    	// Spieler 1 (es wird die Position des "Schlusslichts" bestimmt)
    	for(int i = 1; i < 13; i++) {
    		if(analysiereFeld(i) == true) {
    			tmp = findeStein(i);
    			if(tmp[1] < init_pos) {
    				init_pos = tmp[1];
    			}
    		}
    	}
    	// Spieler 2
    	for(int i = -1; i > -13; i--) {
    		if(analysiereFeld(i) == true) {
    			tmp = findeStein(i);
    			if(tmp[1] > init_neg) {
    				init_neg = tmp[1];
    			}
    		}
    	}
    	// Vergleich
    	if(init_neg - init_pos < 0) {
    		return true;
    	} else {
    	return false;
    	}
    }

    /**
     * zaehlt die Punkte der beiden Spieler und gibt das Ergebnis aus
     */
    private static void zaehlePunkte() {
    
    //TODO
    	int[] pos_punkte = { -5, -3, -2, -1, 1, 2, 3, 5 };
    	int[] neg_punkte = { 5, 3, 2, 1, -1, -2, -3, -5 };
    	int pos_score = 0;
    	int neg_score = 0;
    	int counter = 0;
    	int tmp[] = new int[2];
    	
    	// Spieler 1
    	for(int i = 1; i < 13; i++) {
    		if(analysiereFeld(i) == true) {
    			tmp = findeStein(i);
    			pos_score = pos_score + pos_punkte[tmp[1]];
    		}
    	}
		while(counter < pos_ziellinie.length) {
			if(pos_ziellinie[counter] == 0) {
				break;
			}
			counter++;
		}
		pos_score = pos_score + 5*counter;
    	// Spieler -1
    	for(int i = -1; i > -13; i--) {
    		if(analysiereFeld(i) == true) {
    			tmp = findeStein(i);
    			neg_score = neg_score + neg_punkte[tmp[1]];
    		}
    	}
    	counter = 0;
    	while(counter < neg_ziellinie.length) {
			if(neg_ziellinie[counter] == 0) {
				break;
			}
			counter++;
		}
		neg_score = neg_score + 5*counter;
    	// Ausgabe
		System.out.print("|--------------------------------------------------|\n");
		System.out.print("Spieler 1:\t\t" + pos_score + "\nSpieler -1:\t\t" + neg_score);
    }

    /**
     * Spielablauf entsprechend Anfangszug, Folgezug, Bonuszug
     *
     * @param spieler ist 1 (Spielsteine 1 bis 12) oder -1 (Spielsteine -1 bis
     * -12)
     */
    private static void spielerZieht(int spieler) {
    
    //TODO
    	
    	// ANFANGSZUG
    	int stein = 0;
    	boolean gueltig = false;
    	
    	while(gueltig == false) {
        	stein = read("Mit welchem Stein moechtest du ziehen?");
        	gueltig = gueltigeEingabe(stein, spieler);	
    	}
    	// Wurde der Spielzug als ungueltig deklariert, muss der Spieler einen neuen, guetligen Spielzug wählen
    	int folge;
        folge = setzeZug(stein, 1, true);
    	// Aktualisierung des Spielfelds
    	if(folge != -1) {
    		System.out.print("|--------------------------------------------------|\n");
            System.out.println(output());
        	System.out.print("Es wurde mit Stein " + stein + " gezogen.\n");
    	} else {
    		System.out.print("Es konnte nicht in die vollbesetzte Reihe gezogen werden.\n");
    	}
    	if(folge == 6) {
    		System.out.print("Das Spielfeld wurde im Anfangszug verlassen. Damit erhaelt der Spieler keinen Folgezug.\n");
    	} else if(folge == 0) {
    		System.out.print("Der Stein wurde in eine leere Reihe gesetzt oder hat das Spielfeld verlassen. Damit erhaelt der Spieler keinen Folgezug.\n");
    	}
    	
    	// FOLGEZUG
    	int bonus = 0;
    	
    	if(folge != 0 && folge != 6 && folge != -1) {
            System.out.print("Im Folgezug kann mit " + folge + " Schritten gezogen werden.\n");
            gueltig = false;
            while(gueltig == false) {
            	stein = read("Mit welchem Stein moechtest du den Folgezug ausfuehren?");
            	gueltig = gueltigeEingabe(stein, spieler);
            }
            bonus = setzeZug(stein, folge, true);
            // Aktualisierung des Spielfelds
            if(bonus != -1) {
            	System.out.print("|--------------------------------------------------|\n");
            	System.out.println(output());
        		System.out.print("Es wurde mit Stein " + stein + " gezogen.\n");
            } else {
        		System.out.print("Es konnte nicht in die vollbesetzte Reihe gezogen werden..\n");
            }
    	}
    	
    	// BONUSZUG
    	if(folge == 6 || bonus == 6) {
    		System.out.print("Die Ziellinie wurde mit passender Schrittzahl erreicht. Das gibt einen Bonuszug!\n");
    		gueltig = false;
    		while(gueltig == false) {
    			stein = read("Mit welchem Stein moechtest du den Bonuszug ausfuehren?");
    			gueltig = gueltigeEingabe(stein, spieler);
    		}
    		int vorwaerts = -1;
    		boolean rueck;
    		
    		while(vorwaerts < 0 || vorwaerts > 1) {
    			vorwaerts = read("Moechtest du mit Stein " + stein + " eine Reihe vor(0) oder eine Reihe zurueck (1) ziehen?\n");
    			if(vorwaerts == 1) {
        			rueck = rueckzug(spieler, stein);
        			if(rueck == false) {
        				vorwaerts = -1;
        				System.out.print("Hinweis: Mit einem Stein, der in der eigenen Startlinie steht, kann nicht rueckwaerts gezogen werden.\n");
        			}
    			}
    		}
    		if(vorwaerts == 0) {
    			setzeZug(stein, 1, true);
            	System.out.print("|--------------------------------------------------|\n");
                System.out.println(output());
            	System.out.print("Es wurde mit Stein " + stein + " gezogen.\n");
    		} else {
        		setzeZug(stein, 1, false);
            	System.out.print("|--------------------------------------------------|\n");
                System.out.println(output());
            	System.out.print("Es wurde mit Stein " + stein + " gezogen.\n");
    		}
    	}
        System.out.print("Der Zug ist beendet. Nun ist Spieler " + (spieler*-1) + " an der Reihe.\n");
    }

    // EIGENE METHODEN
    
    /**
     * ermittelt per Zufall einen der beiden Spieler
     * 
     * @return 1 oder -1 für respektiv Spieler 1 oder Spieler -1
     */
    private static int ermittleSpieler() {
    	int spieler;
    	
    	if(dice() > 3) {
        	spieler = 1;
        } else {
        	spieler = -1;
        }
    	return spieler;
    }
     
    /**
     * ermittelt für eine gegebene Reihe, die am weitesten links befindliche freie Position
     * @param reihe
     * @return -1: wenn die Reihe voll ist und damit kein weiterer Spielstein dorthin gesetzt werden kann
     */
    private static int neuePosition(int reihe) {
    	
    	for(int j = 0; j < spielfeld[reihe].length; j++) {
    		if(spielfeld[reihe][j] == 0) {
    			return j;
    		}
    	}
    	return -1;
    }
    
    /*
     * analysiert das Spielfeld und bestimmt, ob der ausgewaehlte Stein sich darauf befindet
     * geschrieben, da in meinem Programm die Steine, die die Ziellinie erreicht haben, vom Spielfeld
     * entfernt werden und somit für weitere Züge nicht mehr ausgewaehlt werden können.
     * @param stein
     * @return false: wenn der Stein nicht gefunden wird, true andernfalls
     */
    private static boolean analysiereFeld(int stein) {
    	
    	for(int i = 0; i < spielfeld.length; i++) {
    		for(int j = 0; j < spielfeld[i].length; j++) {
    			if(spielfeld[i][j] == stein) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    /*
     * Ueberprueft fuer den Bonuszug, ob mit dem gewaehlten Stein rueckwaerts gegangen werden kann
     * (steht der Stein noch in der eigenen Startlinie, so ist das nicht moeglich)
     * @param spieler
     * @param stein
     * @return false: wenn der Stein in der eigenen Startlinie steht, true andernfalls
     */
    private static boolean rueckzug(int spieler, int stein) {
    	
    	int tmp[] = new int[2];
    	tmp = findeStein(stein);
    	
    	if(spieler == 1) {
    		if(tmp[1] == 0) {
    			return false;
    		}
    	} else {
    		if(tmp[1] == 7) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String args[]) {

        initSpiel();
        System.out.println(output());
        
        //TODO
        
        // Welcher Spieler beginnt?
        System.out.print("Es wird gewuerfelt, welcher Spieler beginnt:\n");
        int spieler = ermittleSpieler();
    	System.out.print("Es beginnt Spieler " + spieler + ".\n");
        
    	// Spielablauf
    	boolean end = false;
    	while(end == false) {
    		spielerZieht(spieler);
    		end = spielende();
    		spieler = spieler*-1;
    	}
    	
    	// FIX: Moechte der Spieler in eine vollbesetzte Reihe ziehen, wird sein Spielzug umgehend beendet.
    	
    	// Ende und Punktestand
    	System.out.print("Die Partien sind aneinander vorbeigezogen. Damit ist das Spiel zu Ende.\n");
    	zaehlePunkte();
    }
}