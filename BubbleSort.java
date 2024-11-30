package sort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort();
    }
    
    static void bubbleSort() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter 10 numbers: ");
        double[] numbers  = new double[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextDouble();
            
        }
        
        bubbleSort(numbers);
        
        System.out.println("In ascending order, the numbers are arranged as follows: ");
        for (double e: numbers)
            System.out.print(e + " ");
        System.out.println();
    }
    
    static void bubbleSort(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            
            for (int j = 0, k = j + 1; k < numbers.length; j++, k++) {
                
                if (numbers[j] > numbers[k]) {
                    double temp = numbers[j];
                    numbers[j] = numbers[k];
                    numbers[k] = temp;
                }
            }
        }
    }
}
