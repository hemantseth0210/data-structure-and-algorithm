package com.sethjava.bubblesort;
/*
- In place algorithm
- Time Complexity - O(n^2)
- Algorithm takes 100 steps to sort 10 items, 10000 steps to sort 100 items
- Algorithm degrades quickly
 */
public class BubbleSort {

    public static void main(String[] args) {
	    int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
	    intArray = bubbleSort(intArray);
	    for(int i=0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    private static int[] bubbleSort(int[] intArray) {
        for(int unsortedPartitionIndex = intArray.length -1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            for(int i=0; i < unsortedPartitionIndex; i++){
                if(intArray[i] > intArray[i+1])
                    swap(intArray, i, i+1);
            }
        }
        return intArray;
    }

    private static void swap(int[] array, int i, int j) {
        if(i==j)
            return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
