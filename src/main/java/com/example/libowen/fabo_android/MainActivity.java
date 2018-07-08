package com.example.libowen.fabo_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.libowen.fabo_android.Algorithm.InsertSort;
import com.example.libowen.fabo_android.Algorithm.MergeSort;
import com.example.libowen.fabo_android.Algorithm.SelectionSort;
import com.example.libowen.fabo_android.Until.TimeUntil;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);


        TimeUntil.funTimeToCalculate(new TimeUntil.CallBack() {
            @Override
            public void longTimeOperation() {
                int[] arr = randomArr(500000);
//                int[] arr = {9,8,6,1,4,2};
//               InsertSort.sort(arr,2,4);
                MergeSort.sort(arr, 0, arr.length - 1);
//                Log.e(TAG, "onCreate: " + Arrays.toString(arr));
            }
        });
    }

    public int[] randomArr(int length) {
        int[] arr = new int[length];
        int i = 0;
        for (int value : arr) {
            Random random = new Random();
            arr[i] = random.nextInt(length) + 1;
            i++;
        }
        return arr;
    }
}

