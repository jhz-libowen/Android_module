package com.example.libowen.fabo_android.Until;

import android.util.Log;

/**
 * Created by libowen on 2018/6/23.
 */

public class TimeUntil {
    public interface CallBack {
        void longTimeOperation();
    }
    public static void funTimeToCalculate(CallBack callBack) {
        long startTime= System.currentTimeMillis(); //起始时间
        callBack.longTimeOperation(); ///进行回调操作
        long endTime = System.currentTimeMillis(); //结束时间
        Log.e("FunTimeToCalculate",String.format("方法使用时间 %d ms", endTime - startTime)); //打印使用时间
    }
}
