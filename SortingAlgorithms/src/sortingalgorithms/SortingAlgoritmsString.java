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
public class SortingAlgoritmsString {

    public static void main(String[] args) {
        String[] a = new String[15];

        a[0] = "force";
        a[1] = "bare";
        a[2] = "delay";
        a[3] = "ill-fated";
        a[4] = "witty";
        a[5] = "filthy";
        a[6] = "impartial";
        a[7] = "quirky";
        a[8] = "sloppy";
        a[9] = "coil";
        a[10] = "narrow";
        a[11] = "bump";
        a[12] = "sleepy";
        a[13] = "coach";
        a[14] = "crack";

        String[] b = new String[15];
        System.arraycopy(a, 0, b, 0, 15);

        String[] c = new String[15];
        System.arraycopy(a, 0, c, 0, 15);

        long startTime = System.nanoTime();
        bubbleSort(a);
        long bubbleSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        selectionSort(b);
        long selectionSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        insertionSort(c);
        long insertionSortTime = System.nanoTime() - startTime;

        for (String a1 : c) {
            System.out.println(a1);
        }
        System.out.println("Bubble Sort time: " + bubbleSortTime + ", Selection Sort time: " + selectionSortTime + "\nInsertion Sort time: "
                + insertionSortTime);
    }

    //this is the main function for bubble sort
    public static void bubbleSort(String array[]) {
        int n = array.length;
        int k;
        boolean noSwaps = false;
        while (!noSwaps) {
            noSwaps = true;
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i].compareTo(array[k]) > 0) {
                    swapStrings(i, k, array);
                    noSwaps = false;
                }

            }
        }

    }

    //this is the helper function for bubble sort
    private static void swapStrings(int i, int j, String[] array) {

        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //this is the function for selection sort
    public static void selectionSort(String[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i].compareTo(arr[j]) > 0) {
                    swapStrings(i, j, arr);
                }

            }

        }

    }

    public static void insertionSort(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while ((j > 0) && (arr[j].compareTo(arr[j-1])<0)) {
                swapStrings(j-1, j, arr);
                j--;
            }
            

        }

    }

}
