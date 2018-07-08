package com.example.libowen.fabo_android.Algorithm;

public class SelectionSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minInjdex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minInjdex]) {
                    int tmp = arr[j];
                    arr[j] = arr[minInjdex];
                    arr[minInjdex] = tmp;
                }
            }
        }
    }
}
