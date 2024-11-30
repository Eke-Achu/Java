public class Craps {
    public static void main(String[] args) {
        craps();
    }
    
    static void craps() {
        int roll = rollDice();
        
        if (win(roll))
            System.out.println("You win");
        
        else if (loss(roll))
            System.out.println("You lose");
        
        else {
            System.out.println("Point is " + roll);
            int newRoll;
            
            boolean notFound = true;
            
            while(notFound) {
                newRoll = rollDice();
                
                notFound = checkPoint(newRoll, roll);
            }
        }
    }
    
    static int rollDice() {
        int num1 = 1 + (int)(Math.random() *6);
        int num2 = 1 + (int)(Math.random() * 6);
        
        System.out.println("You rolled " + num1 + " + " + num2 + " = " +
            (num1 + num2));
        
        return (num1 + num2);
    }
    
    static boolean win(int roll) {
        return roll == 7 || roll == 11;
    }
    
    static boolean loss(int roll) {
        return roll == 2 ||roll == 3 || roll == 12; 
    }
    
    static boolean checkPoint(int newRoll, int roll) {
        if (newRoll == roll) {
            System.out.println("You win");
            return false;
        }
        else if (newRoll == 7) {
            System.out.println("You lose");
            return false;
        }
        
        return true;
    }
}
