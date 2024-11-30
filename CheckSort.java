package sort;

import java.util.*;

public class CheckSort {
    public static void main(String[] args) {
        isSorted();
    }
    
    static void isSorted() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the list: ");
        int length = input.nextInt();
        
        System.out.print("Enter the contents of the list: ");
        int[] list = new int[length];
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
            
        }
        
        System.out.print("The list has " + length + " integers ");
        for (int e: list) 
            System.out.print(e + " ");
        
        
        System.out.println("\nThe list is " + (isSorted(list) ? "already sorted" :
            "not sorted"));
        
        
    }
    
    static boolean isSorted(int[] list) {
        int[] temp = new int[list.length];
        System.arraycopy(list, 0, temp, 0, list.length);
        
        SortStudents.sort(list);
        
        return Arrays.equals(list, temp);
    }
}
