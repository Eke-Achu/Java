package game;

public class LockerPuzzle {
    public static void main(String[] args) {
        lockerPuzzle();
    }
    
    static void lockerPuzzle() {
        boolean[] lockers = new boolean[100];
        
        int index;
        
        for (int i = 0; i < lockers.length; i++) {
            index = i + 1;
            
            for (int j = i; j < lockers.length; j += index) {
                if (lockers[j])
                    lockers[j] = false;
                else
                    lockers[j] = true;
                
            }
        }
        
        for (int i = 0; i < lockers.length; i++) {
             if (lockers[i])
                System.out.println("L" + (i + 1));
            
        }
    }
}
