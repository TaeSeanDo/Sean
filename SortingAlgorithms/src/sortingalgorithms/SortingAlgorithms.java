/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

/**
 *
 * @author Education Unlimited
 */
public class SortingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = new int[50];
        for (int i =0; i<50; i++) {
            a[i]=(int) (Math.random()*1000);
        }
        int[] b =new int[50];
        System.arraycopy(a, 0, b, 0, 50);
        
        int[] c = new int[50];
        System.arraycopy(a, 0, c, 0, 50);
        
        long startTime = System.nanoTime(); 
        bubbleSort(a);
        long bubbleSortTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime(); 
        selectionSort(b);
        long selectionSortTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime(); 
        insertionSort(c);
        long insertionSortTime = System.nanoTime() - startTime;
        
        for (int al: b){
            System.out.println(al);

        }
        System.out.println("Bubble Sort time: "+bubbleSortTime +", Selection Sort time: "+selectionSortTime + "\nInsertion Sort time: " + insertionSortTime);
    }
    
    
    //this is the main function for bubble sort
    public static void bubbleSort(int array[]) {
        int n = array.length;
        int k;
        boolean noSwaps = false;
        while (!noSwaps) {
            noSwaps = true;
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                    noSwaps = false;
                }
           
        }
        }
        
    }
    //this is the helper function for bubble sort
    private static void swapNumbers(int i, int j, int[] array) {
  
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    //this is the function for selection sort
    public static void selectionSort(int[] arr){
         
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) 
                    index = j;
      
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
    
    public static void insertionSort(int[] arr) {
        
        
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]) {
                swapNumbers(i, j, arr);
                j--;
            }
            
            
            
        }
        
    }
    
}
