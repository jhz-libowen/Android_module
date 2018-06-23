package com.example.libowen.fabo_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.libowen.fabo_android.Algorithm.MergeSort;
import com.example.libowen.fabo_android.Until.TimeUntil;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

//        TextMessage message = new TextMessage();
//        message.setRequestMethod(TextMessage.REQUEST_METHOD_GET);
//        message.setMediaTypeMarkdown("application/json; charset=utf-8");
//        message.setUrl("http://www.kuwo.cn/bd/search/musicSearch?key=林俊杰&bdfrom=xpjqr&c=qmtcweap90pj&rn=30&pn=3");
//        message.setConnectTimeout(10);
//        getUpLoadLogRootUrl();


        TimeUntil.funTimeToCalculate(new TimeUntil.CallBack() {
            @Override
            public void longTimeOperation() {
                int[] arr = {9,8,1,3,5,2};
                MergeSort.mergeSort(arr,0,arr.length - 1);
                Log.e(TAG, "onCreate: " + Arrays.toString(arr));
            }
        });
    }

    //    private void getUpLoadLogRootUrl() {
//        String ROOT_PATH = Environment.getExternalStorageDirectory() + "/efrobot/" + "robot_url_out.config";
//        File filePath = new File(ROOT_PATH);
//        if (filePath.exists()) {
//            Log.d(TAG, "getUpLoadLogRootUrl: ");
//        } else {
//            Log.d(TAG, "getUpLoadLogRootUrl: ");
//        }
//    }

}

