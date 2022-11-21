import java.util.*;

class Guesser{
	int num;
	Scanner s = new Scanner(System.in);
	
	public int guesserNumber() {
		System.out.println();
		System.out.print("Guesser, please guess a number from 1 to 10: ");
		num = s.nextInt();	
		if(num<=0 || num>10) {
			System.out.println("You have guessed an INVALID number.");
			guesserNumber();
		}
		return num;
	}
}

class Player{
	int num;
	Scanner s = new Scanner(System.in);
	
	public int playerNumber() {
		System.out.println();
		System.out.print("Player, please guess a number from 1 to 10: ");
		num = s.nextInt();
		if(num<=0 || num>10) {
			System.out.println("You have guessed an INVALID number.");
			playerNumber();
		}
		return num;
	}
}

class Umpire{
	int numberFromGuesser;
	int numberFromPlayer;
	
	public void pointSystem() {
		System.out.println("Scoring System");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("If player guesses the number on 1st try, he/she will earn 50 points");
		System.out.println("If player guesses the number on 2nd try, he/she will earn 30 points");
		System.out.println("If player guesses the number on 3rd try, he/she will earn 20 points");
		System.out.println("-------------------------------------------------------------------");
		
	}
	
	
	public void collectNumbers() {
		Guesser g = new Guesser();
		numberFromGuesser = g.guesserNumber();
		
		Player p = new Player();
    	numberFromPlayer = p.playerNumber();
	}
	
	public void compare() {
		if(numberFromGuesser == numberFromPlayer) {
			System.out.println();
			System.out.println("Congratulations!!! Player has won and earned 50 points :D");
		}
		else {
			System.out.println("Player has guessed the wrong number. 2 more guesses left.");
			if(numberFromPlayer<numberFromGuesser) {
				System.out.println("You have guessed a smaller number. Try a BIGGER number.");
				Player p = new Player();
			    numberFromPlayer = p.playerNumber();
			    if(numberFromGuesser == numberFromPlayer) {
					System.out.println();
					System.out.println("Congratulations!!! Player has won and earned 30 points :D");
				}
			    else {
			    	System.out.println("Player has guessed the wrong number. 1 more guess left.");
			    	if(numberFromPlayer<numberFromGuesser) {
						System.out.println("You have guessed a smaller number. Try a BIGGER number.");
					}
			    	else if (numberFromPlayer>numberFromGuesser) {
			    		System.out.println("You have guessed a bigger number. Try a SMALLER number.");
					}
					Player p1 = new Player();
					numberFromPlayer = p1.playerNumber();
					if(numberFromGuesser == numberFromPlayer) {
					    System.out.println();
						System.out.println("Congratulations!!! Player has won and earned 20 points :D");
					}
					else {
					    System.out.println();
						System.out.println("Player has lost the game :(((");
					}
			    }
			}
			else if(numberFromPlayer>numberFromGuesser) {
				System.out.println("You have guessed a bigger number. Try a SMALLER number.");
				Player p = new Player();
			    numberFromPlayer = p.playerNumber();
			    if(numberFromGuesser == numberFromPlayer) {
					System.out.println();
					System.out.println("Congratulations!!! Player has won and earned 30 points :D");
				}
			    else {
			    	System.out.println("Player has guessed the wrong number. 1 more guess left.");
			    	if(numberFromPlayer<numberFromGuesser) {
						System.out.println("You have guessed a smaller number. Try a BIGGER number.");
					}
			    	else if (numberFromPlayer>numberFromGuesser) {
			    		System.out.println("You have guessed a bigger number. Try a SMALLER number.");	
			    	}
					Player p1 = new Player();
					numberFromPlayer = p1.playerNumber();
			    	if(numberFromGuesser == numberFromPlayer) {
			    		System.out.println();
			    		System.out.println("Congratulations!!! Player has won and earned 20 points :D");
					}
					else {
					   	System.out.println();
						System.out.println("Player has lost the game :(((");
					}
			    }
			}	
		}
	}
}

class GuesserGame{
    public static void main(String args[])
    {
    	Umpire obj = new Umpire();
    	obj.pointSystem();
    	obj.collectNumbers();
    	obj.compare();
    }
}