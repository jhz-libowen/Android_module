package com.example.libowen.fabo_android.Algorithm;

/**
 * Created by libowen on 2018/6/23.
 */

public class MergeSort {
    public static void sort(int arr[],int left,int right) {
//        if (right - left <= 15) {
//            InsertSort.sort(arr,left,right);
//            return;
//        }
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        sort(arr,left,mid);
        sort(arr,mid + 1,right);
        if (arr[mid] > arr[mid + 1])
        merge(arr,left,mid,right);
    }

    /**
     * 自底向上的归并排序
     */
    private static void sortBU(int[] arr, int n) {
        if (n > arr.length) return;
        for (int size = 1; size < n; size += size) {
            for (int i = 0; i + size < n; i += size + size) {
                merge(arr,i,i + size - 1,Math.min(i + size + size - 1,n - 1));
            }
        }
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
