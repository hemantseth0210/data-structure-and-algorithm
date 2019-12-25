package com.sethjava.insertionsort;

/*
- In place algorithm
- Time Complexity - O(n^2)
- Algorithm takes 100 steps to sort 10 items, 10000 steps to sort 100 items
- Stable algorithm
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        intArray = insertionSort(intArray);
        for(int i=0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    private static int[] insertionSort(int[] intArray) {
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++){
            int newElement = intArray[firstUnsortedIndex];
            int i;
            for(i=firstUnsortedIndex; i>0 && intArray[i-1] > newElement; i--){
                intArray[i] = intArray[i-1];
            }
            intArray[i] = newElement;
        }
        return intArray;
    }

}
