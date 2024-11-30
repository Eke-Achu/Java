package sort;

import java.util.Scanner;
import numbers.ReverseArray;

public class SortStudents {
    public static void main(String[] args) {
        sortStudents();
    }
    
    static void sortStudents() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numOfStudents = input.nextInt();
        
        System.out.println("Enter the names and scores of the students: ");
        String[] names = new String[numOfStudents];
        int[] scores = new int[numOfStudents];
        
        for (int i = 0; i < numOfStudents; i++) {
            names[i] = input.next();
            scores[i] = input.nextInt();
            
        }
        
        int[] temp = new int[scores.length];
        System.arraycopy(scores, 0, temp, 0, numOfStudents);
        
        sort(scores);
        scores = ReverseArray.reverse(scores);
        printNames(names, scores, temp);
    }
    
    
    static void sort(int[] scores) {
        int currentMin;
        int indexOfMin;
        
        for (int i = 0; i < scores.length; i++) {
            currentMin = scores[i]; 
            indexOfMin = i;
            
            for (int j = i + 1; j < scores.length; j++) {
                if (currentMin > scores[j]) {
                    currentMin = scores[j];
                    indexOfMin = j;
                }
            }
            
            if (indexOfMin != i) {
                scores[indexOfMin] = scores[i];
                scores[i] = currentMin;
            }
            
        }
    }
    
    static void printNames(String[] names, int[] scores, int[] temp) {
        System.out.println("The Students scores in decreasing order are: ");
        
        for (int i = 0; i < scores.length; i++) {
            
            for (int j = 0; j < temp.length; j++) {
                
                if (scores[i] == temp[j]) {
                    System.out.println(names[j] + ": " + temp[j]);
                    temp[j] = 0;
                }
                
            }
            
        }
    }
}
