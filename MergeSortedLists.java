package sort;
//Trace and debug
import java.util.Scanner;

public class MergeSortedLists {
    public static void main(String[] args) {
        mergeSortedLists();
    }
    
    static void mergeSortedLists() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter list1 size and contents: ");
        int size1 = input.nextInt();
        int[] list1 = new int[size1];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = input.nextInt();
            
        }
        
        System.out.print("Enter list2 size and contents: ");
        int size2 = input.nextInt();
        int[] list2 = new int[size2];
        for (int i = 0; i < list2.length; i++) {
            list2[i] = input.nextInt();
            
        }
        
        
        System.out.print("list1 is ");
        for (int e: list1) 
            System.out.print(e + " ");
        System.out.println();
        
        
        System.out.print("list2 is ");
        for (int e: list2) 
            System.out.print(e + " ");
        System.out.println();
        
        
        int[] mergedList = merge(list1, list2);
        
        System.out.print("The merged list is ");
        for (int e: mergedList) 
            System.out.print(e + " ");
        System.out.println();
    }
    
    static int[] merge(int[] list1, int[] list2) {
        int[] mergedList = new int[list1.length + list2.length];
        
        int j = 0, k = 0;
        
        for (int i = 0; i < mergedList.length; i++) {
            
            if (j < list1.length && k < list2.length) {
                if (list1[j] < list2[k]) {
                    mergedList[i] = list1[j];
                    j++;
                }
                else {
                    mergedList[i] = list2[k];
                    k++;
                }
            }
            else if (j > list1.length) {
                mergedList[i] = list2[k];
                k++;
            }
            else if (k > list2.length) {
                mergedList[i] = list1[j];
                j++;
            }
            
        }
        
        return mergedList;
    }
}
