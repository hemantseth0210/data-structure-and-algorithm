package com.sethjava.shellsort;

/*
- In place algorithm
- Time Complexity - O(n^2) - But it can perform much better than that
- Algorithm takes 100 steps to sort 10 items, 10000 steps to sort 100 items
- Unstable algorithm
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        intArray = shellSort(intArray);
        for(int i=0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    private static int[] shellSort(int[] intArray) {
        for(int gap = intArray.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < intArray.length; i++){
                int newElement = intArray[i];
                int j = i;
                while (j >= gap && intArray[j - gap] > newElement){
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = newElement;
            }
        }
        return intArray;
    }

}
