package com.sethjava.selectionsort;
/*
- In place algorithm
- Time Complexity - O(n^2)
- Algorithm takes 100 steps to sort 10 items, 10000 steps to sort 100 items
- Doesn't require as much swapping as bubble sort
- Unstable algorithm
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        intArray = selectionSort(intArray);
        for(int i=0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    private static int[] selectionSort(int[] intArray) {
        for(int lastUnsortedPartitionIndex = intArray.length - 1; lastUnsortedPartitionIndex > 0;
            lastUnsortedPartitionIndex --){
            int largest = 0;
            for(int i=1; i <= lastUnsortedPartitionIndex; i++){
                if(intArray[i] > intArray[largest])
                    largest = i;
            }
            swap(intArray, largest, lastUnsortedPartitionIndex);
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
