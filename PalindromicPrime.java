package comprehensive;

public class PalindromicPrime {
    public static void main(String[] args) {
        twinPrimes();
    }
    
    
    //Displays the first 100 palindromic primes  with 10 per line
    static void palindromicPrime() {
        final int NUMBER_OF_PALINDROMES = 100;
        final int NUMBER_PER_LINE = 10;
        int number = 1;
        int count = 0;
        
        while (count < NUMBER_OF_PALINDROMES) {
            if (isPalindromicPrime(number)) {
                count++;
                
                if (count % NUMBER_PER_LINE == 0)
                    System.out.println(number);
                else
                    System.out.print(number + " ");
            }
            
            number++;
        }
    }
    
    
    //Returns true if the number is a prime number
    static boolean isPrime(int number) {
        boolean isPrime = true;
        
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                isPrime = false;
                break;
            }
        }
        
        return isPrime;
    }
    
    
    //Returns true if the number is a palindrome
    static boolean isPalindrome(int number) {
        return ("" + number).equals(reverse(number));
    }
    
    
    //Returns true if the number is a palindromic prime
    static boolean isPalindromicPrime(int number) {
        return isPalindrome(number) && isPrime(number);
    }
    
    
    //Returns the reverse of the integer passed as a string
    static String reverse(int number) {
        String num = "" + number;
        String reverse = "";
        
        for (int i = num.length() - 1; i >= 0; i--) {
            reverse += num.charAt(i);
        }
        
        return reverse;
    }
    
    
    //Displays the first 100 emirps with 10 per line
    static void emirp() {
        final int NUMBER_OF_EMIRPS = 100;
        final int NUMBER_PER_LINE = 10;
        int number = 1;
        int count = 0;
        
        while (count < NUMBER_OF_EMIRPS) {
            if (isEmirp(number)) {
                count++;
                
                if (count % NUMBER_PER_LINE == 0)
                    System.out.println(number);
                else
                    System.out.print(number + " ");
            }
            
            number++;
        }
    }
    
    
    //Returns true if the number is a nonpalindromic prime but its reverse is a prime
    static boolean isEmirp(int number) {
        return !isPalindrome(number) && isPrime(number) && 
                isPrime(Integer.parseInt(reverse(number)));
    }
    
    
    
    static void mersennePrime() {
        System.out.printf("%-10s2^p-1\n", "p");
        System.out.println("----------------");
        
        int number = 2;
        
        for (int i = 0; i <= 31; i++) {
            if (isMersennePrime(number))
                System.out.printf("%-10d%d\n", number, potentialMersenne(number));
            
            number++;
        }
    }
    
    
    
    static boolean isMersennePrime(int number) {
        return isPrime(potentialMersenne(number));
    }
    
    
    static int potentialMersenne(int number) {
        return ((int)(Math.pow(2,number))) - 1;
    }
    
    
    static void twinPrimes() {
        for (int i = 2; i < 1000; i++) {
            if (isTwinPrime(i))
                System.out.printf("(%d,%2d)\n", i, (i + 2));
        }
    }
    
    
    static boolean isTwinPrime(int number) {
        return isPrime(number) && isPrime(number + 2);
    }
}


