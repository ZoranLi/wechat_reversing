package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public final class u {
    private static File wYU = null;

    public static long cfA() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    @TargetApi(9)
    public static boolean hb(Context context) {
        if (context == null) {
            return false;
        }
        if (wYU != null) {
            return true;
        }
        try {
            if (!context.getApplicationInfo().processName.contains("com.tencent.mm")) {
                return false;
            }
            File dir = context.getDir("tbs", 0);
            if (dir == null || !dir.isDirectory()) {
                return false;
            }
            File file = new File(dir, "share");
            if (!file.isDirectory() && !file.mkdir()) {
                return false;
            }
            wYU = file;
            file.setExecutable(true, false);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
