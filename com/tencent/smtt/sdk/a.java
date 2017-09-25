package com.tencent.smtt.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class a {
    private static int wST = 0;
    public static int wSU = 600;

    public static int cdP() {
        BufferedReader bufferedReader;
        Throwable th;
        int i = 0;
        if (wST > 0) {
            return wST;
        }
        try {
            int indexOf;
            String readLine;
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        indexOf = readLine.indexOf("MemTotal:");
                    }
                    break;
                } catch (IOException e) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (-1 == indexOf);
            readLine = readLine.substring(indexOf + 9).trim();
            if (readLine != null && readLine.length() != 0 && readLine.contains("k")) {
                i = Integer.parseInt(readLine.substring(0, readLine.indexOf("k")).trim()) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            }
            try {
                bufferedReader.close();
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
            }
            wST = i;
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        wST = i;
        return i;
    }

    public static long fC(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Throwable th) {
            return -1;
        }
    }
}
