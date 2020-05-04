import java.util.Random;
import java.util.Scanner;
 
// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRollerInJava {
 
    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }, 
                           { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
                           { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } }, 
                           { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
                           { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } }, 
                           { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } } };
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		Scanner stakein = new Scanner(System.in);
		Scanner name=new Scanner(System.in);
		Scanner playername = new Scanner(System.in);
		Scanner num = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();
		//dy
		System.out.println("Welcome to DiceRoller");
		System.out.println("Please put your name below");
		System.out.print("->");
		String player = playername.nextLine();
		//
		System.out.println("please input you token 10 token for a roll");
		int stake=stakein.nextInt();
		int opp=stake/10;
		System.out.println("times for roll is: "+opp);
		int rollcount=0;
		int count=0;
		
		//Sovandy
		boolean condition;
		//Sovandy
		System.out.println("Welcome "+player);
		System.out.println("times for roll is: "+opp);
		//Sovandy
		System.out.println("Press Enter to Roll");
		String input1 = scanner.nextLine();
		if (input1.equalsIgnoreCase("n") || input1.equalsIgnoreCase("no"))
		{
			System.out.println("Bye!");
			scanner.close();
            return;
		}
		else
		{
			condition = true;
		}
		
	
	
		
      while (condition) {
		if(rollcount<opp)
		{
            int result = dice.roll();
			int result2 = dice.roll();
			++rollcount;
			
            System.out.println("dice face value:" + result+
			" and "+result2);
			
            dice.draw(result);
			dice.draw(result2);
			int memory=result;
			int memory2=result2;
			int total=result+result2;
			if (result == 1 && result2 == 1) {
                    System.out.println("you rolled snake eyes after " + rollcount + " rolls");
                }
    
                else {
                    count ++;
                    System.out.println("roll count: " + count);
                }
			if(total%2 == 0)
			{
				System.out.println("You get even number.");
			}
			else
			{
				System.out.println("You get odd number.");
			}
			if(total >= 7)
			{
				System.out.println("WOW!You get good number.");
				System.out.println("   xxxxxxxxx ");
				System.out.println("  x         x");
				System.out.println("  x  $   $  x");
				System.out.println("  x         x");
				System.out.println("  x .     . x");
				System.out.println("  x  .....  x");
				System.out.println("  x         x");
				System.out.println("   xxxxxxxxx ");
			}
			else
			{
				System.out.println("OPP!You get bad number.");
				System.out.println("   xxxxxxxxx ");
				System.out.println("  x         x");
				System.out.println("  x  O   O  x");
				System.out.println("  x         x");
				System.out.println("  x  _____  x");
				System.out.println("  x         x");
				System.out.println("  x         x");
				System.out.println("   xxxxxxxxx ");
			}
			
            System.out.println("Roll again? (type no to quit):");
            String input = scanner.nextLine();
			
			System.out.println("Last roll result was: "+ memory+" and "+memory2);
			
			//dice.draw(memory);	
			
			
			
		
			
			
            if (input.equalsIgnoreCase("n") || 
                    input.equalsIgnoreCase("no")) {
                System.out.println("Bye!");
                scanner.close();
                return;
            }
        }else{
			System.out.println("you are out of roll");
			System.out.println("Would you like to continue? [Input Token] or [Input 0 to terminate]");
			int number = num.nextInt();
			if (number >0)
			{
				rollcount = 0;
				stake = number;
				opp = stake/10;
			}
			else
			{
				System.out.println("Bye!");
				return;
			}
    
		}
	  }
}
 
    // Draw the dice face using ascii characters
    private void draw(int value) 
	{
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("-----");
 
        for (int i = 0; i < 3; i++) 
		{
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----");
 
    }
 
    // Roll the dice in Java
    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
}