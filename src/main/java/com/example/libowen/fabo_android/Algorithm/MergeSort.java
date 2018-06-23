package com.example.libowen.fabo_android.Algorithm;

/**
 * Created by libowen on 2018/6/23.
 */

public class MergeSort {
    public static void mergeSort(int arr[],int left,int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr,int left,int mid,int right) {
        int[] arrTmp = new int [right - left + 1];
        for(int i = left; i < right + 1; i++){
            arrTmp[i - left] = arr[i];
        }
        int i = left,j = mid + 1;
        for(int k = left; k < right + 1; k++){
            if (i > mid) {
                arr[k] = arrTmp[j - left];
                j++;
            }else if (j > right) {
                arr[k] = arrTmp[i - left];
                i++;
            }else if (arrTmp[i - left] < arrTmp [j - left]) {
                arr[k] = arrTmp[i - left];
                i++;
            }else {
                arr[k] = arrTmp[j - left];
                j++;
            }
        }
    }
}
