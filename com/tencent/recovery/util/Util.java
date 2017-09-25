package com.tencent.recovery.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings.Secure;
import com.tencent.recovery.Recovery;
import com.tencent.recovery.log.RecoveryLog;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Util {
    private static String processName = "";

    public static final boolean mA(String str) {
        return str == null || str.length() == 0;
    }

    public static final int fs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("recovery-info", 0);
        int i = sharedPreferences.getInt("KeySafeModeUUID", -1);
        if (i != -1) {
            return i;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Secure.getString(context.getContentResolver(), "android_id"));
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        String macAddress = connectionInfo != null ? connectionInfo.getMacAddress() : null;
        if (macAddress == null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            macAddress = defaultAdapter != null ? defaultAdapter.getAddress() : null;
        }
        if (macAddress == null) {
            macAddress = UUID.randomUUID().toString();
        }
        stringBuffer.append(macAddress);
        stringBuffer.append(Build.MANUFACTURER + Build.MODEL);
        i = ("A" + n(stringBuffer.toString().getBytes()).substring(0, 15)).hashCode();
        sharedPreferences.edit().putInt("KeySafeModeUUID", i).commit();
        return i;
    }

    private static final String n(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    public static String eY(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(j));
    }

    public static String ft(Context context) {
        return q(context, Process.myPid());
    }

    private static String q(Context context, int i) {
        if (!mA(processName)) {
            return processName;
        }
        if (context == null) {
            context = Recovery.getContext();
        }
        if (context == null || i <= 0) {
            return processName;
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (!(runningAppProcessInfo.pid != i || runningAppProcessInfo.processName == null || runningAppProcessInfo.processName.equals(""))) {
                    processName = runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable e) {
            RecoveryLog.printErrStackTrace("Recovery.Util", e, "", new Object[0]);
        }
        return processName;
    }
}
