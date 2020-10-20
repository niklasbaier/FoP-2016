/**
 * Die Klasse Game fuehrt die Benutzerinteraktion durch.
 *
 */

public class Game {

    private Position pos;
    private int counter = 0;
    private int veggies = 0;
    private int predators = 0;
    private int teilrunde = 0;


    /**
     * Startet ein neues Spiel.
     * Der Benutzer wird ueber das Spielgeschehen informiert.
     *
     * Dazu gehoert auch die Information, wie lange die
     * einzelnen Raubtiere noch ohne Essen auskommen koennen.
     * Diese Information soll auf Anfrage oder immer angezeigt werden.
     *
     * Es soll ausserdem eine Moeglichkeit geben, sich alle Zuege
     * anzeigen zu lassen, die in der Spielsituation moeglich sind.
     *
     * Bei fehlerhaften Eingaben wird die Eingabe natuerlich wiederholt.
     *
     * Der Parameter spezifiziert, wer das Spiel beginnen darf.
     */
    public void startGame(boolean ladiesFirst){
        pos = new Position();
        pos.reset(ladiesFirst ? 'W' : 'M');
        //TODO
        while(true) {
        	
        	Move[] tmp = new Move[4];
            int c = 0;
            int wahl = 0;
            
            while(c < 4) {
            	System.out.println("|--------------------|");
                System.out.println("Was moechtest du tun?\n(1)\tPassen\n(2)\tZiehen\n(3)\tInformation");
                wahl = chooseNumber();
                
                if(wahl == 1) {
                	if(arrLength(tmp) == 0) {
                		System.out.println("|--------------------|");
                    	System.out.println("Es wurden keine Steine bewegt.");
                    	System.out.println("|--------------------|");
                    }
                	break;
                }
                
                System.out.println("|--------------------|");
                if(wahl == 3) {	
                	if(c != 0) {
                    	System.out.print("Bisher ausgewaehlte Zuege:\t[");
                    	for(int i = 0; i < tmp.length; i++) {
                    		if(tmp[i + 1] == null) {
                    			System.out.println(tmp[i] + "]");
                    			break;
                    		}
                    		System.out.print(tmp[i] + ", ");
                    	}
                	}
                	System.out.println("Restliche Zuege:\t\t" + (4 - c));
                	System.out.println("\tDavon mit Vegetariern:\t" + (3 - veggies));
                	System.out.println("\tDavon mit Raubtieren:\t" + (1 - predators));
                	printAnimalDays();
                }
                
                if(wahl == 2) {
                	String stein = "";
                   	while(true) {
                    	stein = IO.readString("Bitte waehle einen Spielstein:\t");
                    	while(stein.length() != 2) {
                    		System.out.println("Bitte beachte, dass die Eingabe genau 2 Zeichen enthalten muss, z.B. a2.");
                    		stein = IO.readString("Bitte waehle einen Spielstein:\t");
                    	}
                    	
                    	if(tmp[0] != null && counter == 0 && pos.findAnimal(stein) != -1) {	
                    		for(int i = 0; i < tmp.length; i++) {
                    			if(tmp[i] == null) {
                    				break;
                    			}
                    			String s = "" + tmp[i].toString().charAt(0) + tmp[i].toString().charAt(1);
                    			if(s.equals(stein) == true) {
                    				System.out.println("Mit diesem Spielstein hast du bereits einen Zug ausgewaehlt.");
                    				counter++;
                    				break;
                    			} else if(pos.isVeggie(stein) == false) {
                    				if(predators != 0) {
                    					System.out.println("Du bist bereits mit einem Raubtier gezogen.");
                    					counter++;
                    					break;
                    				}
                    			}
                    		}
                    	}
                    	
                    	if(counter != 0) {
                    		counter = 0;
                    	} else {
                    		stein = chooseAnimal(stein);
                        	if(counter == 0) {
                        		if(tmp[0] != null) {
                            		
                            		for(int i = 0; i < tmp.length; i++) {
                            			if(tmp[i] == null) {
                            				break;
                            			}
                            			String s = "" + tmp[i].toString().charAt(0) + tmp[i].toString().charAt(1);
                            			if(s.equals(stein) == true) {
                            				System.out.println("Mit diesem Spielstein hast du bereits einen Zug ausgewaehlt.");
                            				counter++;
                            				break;
                            			}
                            		}
                            	}                       	
                            	if(counter == 0) {
                                	break;	
                            	} else {
                            		counter = 0;
                            	}
                        	} else {
                               	counter = 0;
                        	}
                    	}
                   	}      
                   	String hilfe = IO.readString("Moechtest du dir die moeglichen Zuege mit " + stein + " anzeigen lassen (tippe 'ja')? ");
                   	if(hilfe.equals("ja")) {
                        System.out.print("Moegliche Zuege mit dem Spielstein " + stein + ":\t");  
                        pos.printActualMoves(pos.actualMoves(stein));
                   	}
                    if(pos.actualMoves(stein) == null) {                	
                    	c--;
                    } else {
                        String ziel = IO.readString("Bitte Spielzug in der Form <Zielfeld> eingeben:\t");
                        while(true) {
                            Move zug = chooseMove(stein, ziel);
                            if(counter == 0) {                        	
                            	if(tmp[0] != null) {
                            		
                            		for(int i = 0; i < tmp.length; i++) {
                            			if(tmp[i] == null) {
                            				break;
                            			}
                            			String s = "" + tmp[i].toString().charAt(2) + tmp[i].toString().charAt(3);
                            			if(s.equals(ziel) == true) {
                            				System.out.println("Dieses Zielfeld hast du bereits ausgewaehlt.");
                            				c--;
                            				counter++;
                            				break;
                            			}
                            		}
                            	}                       	
                            	if(counter == 0) {
                            		tmp[c] = zug;
                            		if(pos.isVeggie(stein) == true) {
                            			veggies++;
                            		} else {
                            			predators++;
                            		}
                                	break;	
                            	} else {
                            		counter = 0;
                            		break;
                            	}                        	
                            } else {
                            	ziel = IO.readString("Bitte Spielzug in der Form <Zielfeld> eingeben:\t");
                            	counter = 0;
                            } 
                        }
                    }
                    c++;
                }
          
            }
            
            Move[] playerMoves;
            // Zuege ausfuehren
            if(arrLength(tmp) == 0) {
            	playerMoves = null;
            } else {
            	// Es wird ein Move Array erstellt, der wirklich nur so gross ist, wie Zuege gemacht wurden
            	playerMoves = new Move[arrLength(tmp)];
            	for(int i = 0; i < arrLength(tmp); i++) {
            		playerMoves[i] = tmp[i];
            	}
            	
            	System.out.print("Es werden folgende Zuege ausgefuehrt:\t[");
            	for(int i = 0; i < playerMoves.length; i++) {
            		if(i == playerMoves.length - 1) {
            			System.out.println(playerMoves[i] + "]");
            		} else {
                		System.out.print(playerMoves[i] + ", ");
            		}
            	}
                System.out.println("|--------------------|");
            }

            // Aktualisierung des Spielfelds
            teilrunde++;
            
            // Aktualisierung Raubtierwerte
            if(teilrunde == 2) {
            	
            	teilrunde = 0;
            	pos.triggerSunset();
            	pos.killPredators();
            	System.out.println("Es ist ein Tag vergangen. Die Restlaufzeiten der Raubtiere wurden aktualisiert.");
            	System.out.println("|--------------------|");
            }
        	pos.applyMoves(playerMoves);
             
            veggies = 0;
            predators = 0;       
            if(pos.theWinner() != 'X') {
            	break;
            }
        }
        
        showResults(pos.theWinner());
    }
    
    public int chooseNumber() {
    	
    	String s = IO.readString("Bitte treffe eine Wahl:\t");
    	int c;
    	
    	while(true) {
        	if(s.equals("1") || s.equals("2") || s.equals("3")) {
        		c = toIndexInt(s, 0);
        		break;
        	} else {
        		System.out.println("Keine gueltige Eingabe.");
        		s = IO.readString("Bitte treffe eine Wahl:\t");
        	}
    	}
    	return c;
    }
    
    public void printAnimalDays() {
    	System.out.println("Restlaufzeiten Raubtiere:");
    	System.out.print("\tLeoparden:\t\t");
    	String[] leopards = pos.findPredator(5, pos.nextPlayer());
    	if(leopards == null) {
    		System.out.println("Beide deiner Leoparden sind verhungert.");
    	} else {
    		System.out.print("" + leopards[0].charAt(0) + leopards[0].charAt(1) + " mit " + leopards[0].charAt(2) + " Tagen");
        	if(leopards.length == 2) {
        		System.out.print(" und " + leopards[1].charAt(0) + leopards[1].charAt(1) + " mit " + leopards[1].charAt(2) + " Tagen");
        	}
        	System.out.println();
    	}
    	
    	System.out.print("\tSchlangen:\t\t");
    	String[] snakes = pos.findPredator(9, pos.nextPlayer());
    	if(snakes == null) {
    		System.out.println("Beide deiner Schlangen sind verhungert.");
    	} else {
    		System.out.print("" + snakes[0].charAt(0) + snakes[0].charAt(1) + " mit " + snakes[0].charAt(2) + " Tagen");
        	if(snakes.length == 2) {
        		System.out.print(" und " + snakes[1].charAt(0) + snakes[1].charAt(1) + " mit " + snakes[1].charAt(2) + " Tagen");
        	}
        	System.out.println();
    	}

    	System.out.print("\tPinguine:\t\t");
    	String[] penguins = pos.findPredator(12, pos.nextPlayer());
    	if(penguins == null) {
    		System.out.println("Beide deiner Pinguine sind verhungert.");
    	} else {
    		if(penguins[0].length() == 4) {
        		System.out.print("" + penguins[0].charAt(0) + penguins[0].charAt(1) + " mit " + penguins[0].charAt(2) + penguins[0].charAt(3) + " Tagen");
        	} else {
        		System.out.print("" + penguins[0].charAt(0) + penguins[0].charAt(1) + " mit " + penguins[0].charAt(2) + " Tagen");
        	}
        	
        	if(penguins.length == 2) {
        		if(penguins[1].length() == 4) {
        			System.out.print(" und " + penguins[1].charAt(0) + penguins[1].charAt(1) + " mit " + penguins[1].charAt(2) + penguins[1].charAt(3) + " Tagen");
        		} else {
            		System.out.print(" und " + penguins[1].charAt(0) + penguins[1].charAt(1) + " mit " + penguins[1].charAt(2) + " Tagen");
        		}
        	}
        	System.out.println();
    	}
    }
    
    public String chooseAnimal(String stein) {
   		
    	if(toIndexChar(stein, 0) < 0 || toIndexChar(stein, 0) > 7 || toIndexInt(stein, 1) < 1 || toIndexInt(stein, 1) > 8) {
    		System.out.println("Bitte waehle ein gueltiges Ausgangsfeld zwischen a1 und h8.");
    		counter++;
		} 
    	
    	if(pos.findAnimal(stein) == -1) {
    		System.out.println("Der Spielstein wurde nicht gefunden.");
    		counter++;
    	} else {
        	if(pos.nextPlayer() == true) {
        		if(pos.femaleAnimal(stein) == false) {
        			System.out.println("Der Spielstein gehoert dem Gegner.");
        			counter++;
        		}
        	} else if(pos.nextPlayer() == false) {
        		if(pos.femaleAnimal(stein) == true) {
        			System.out.println("Der Spielstein gehoert dem Gegner.");
        			counter++;
        		}
        	}	
    	}
    	
    	return stein;
    }
    
    public Move chooseMove(String stein, String ziel) {
    	 
    	while(true) {
     		if(ziel.length() == 2) {
     			break;
     		} else {
     			System.out.println("Bitte beachte, dass die Eingabe genau 2 Zeichen enthalten muss, z.B. a2.");
     			ziel = IO.readString("Bitte Spielzug in der Form <Zielfeld> eingeben:\t");
     		}
     	}
         
         Move zug = new Move(stein, ziel);
         if(pos.legitMove(stein, zug) == false) {
 			System.out.println("Bitte waehle einen gueltigen Zug fuer den Spielstein " + stein + ".");
 			counter++;
         }
         
         return zug;
    }
    
    public int toIndexChar(String s, int i) {
    	return (s.charAt(i) - 'a');
    }
    
    public int toIndexInt(String s, int i) {
    	return (s.charAt(i) - '0');
    }
    
    public int arrLength(Move[] tmp) {
    	int counter = 0;
    	for(int i = 0; i < tmp.length; i++) {
    		if(tmp[i] != null) {
    			counter++;
    		}
    	}
    	return counter;
    }
    
    public void showResults(char result) {
        System.out.println("|--------------------|");
    	if(result == 'W') {
    		System.out.println("Die Weibchen haben gewonnen!");
    	} else if(result == 'M') {
    		System.out.println("Die Maennchen haben gewonnen!");
    	} else {
    		System.out.println("Unentschieden!");
    	}
    }
}
