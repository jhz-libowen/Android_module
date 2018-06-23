package com.example.libowen.fabo_android.Other;

/**
 * Created by libowen on 2018/2/7.
 */

public class adb {
    /**
     *
     * 获取设备列表及设备状态     adb devices
     *
     * 获取设备的状态            adb get-state
     设备的状态有3钟，device，offline ，unknown
     设备：设备正常连接
     离线：连接出现异常，设备无响应
     未知：没有连接设备

     * 结束adb服务，启动adb服务，通​​常两个命令一起用   adb kill-server，adb start-server
     *
     * 打印Android的系统日志   adb logcat
     *
     * 打印dumpsys，dumpstate，logcat的输出，也是用于分析错误
       输出比较多，建议重定向到一个文件中
       adb bugreport > d:\bugreport.log
     /
     * 安装应用，覆盖安装是使用-r选项      adb install
     *
     * 卸载应用，后面跟的参数是应用的包名，请区别于apk 文件名       adb uninstall
     '-k'表示保存数据和缓存目录，-k选项，卸载时保存数据和缓存目录

     * 将Android设备上的文件或者文件夹复制到本地   adb pull
       example: adb pull sdcard/pull.txt d:\

     * 推送本地文件至Android设备     adb push
     *
     * 重启Android设备  adb reboot
     *
     *
     *
     */


    /**
     * 安装系统应用
     * adb remount
     * adb shell
     * cd system/app
     * ls
     * rm xxx.apk
     * reboot
     */
}
