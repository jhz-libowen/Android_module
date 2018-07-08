package com.example.libowen.fabo_android.Algorithm;

public class InsertSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
        }
    }
    public static void sort(int[] arr, int left, int right) {
        if (left<0) return;
        if (right>=arr.length) return;
        for (int i = left + 1; i <= right; i++) {
            for (int j = i; j > left; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }
}
