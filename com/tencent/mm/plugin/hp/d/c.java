package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public final class c {
    public static File ct(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        File file = new File(applicationInfo.dataDir, "tinker_server");
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    @Deprecated
    public static boolean cq(long j) {
        long availableBlocks;
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                long blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
                j2 = availableBlocks;
                availableBlocks = blockSize;
            } catch (Exception e) {
                j2 = availableBlocks;
                availableBlocks = 0;
                if (availableBlocks != 0) {
                }
                return false;
            }
        } catch (Exception e2) {
            availableBlocks = 0;
            j2 = availableBlocks;
            availableBlocks = 0;
            if (availableBlocks != 0) {
            }
            return false;
        }
        if (availableBlocks != 0 || r4 <= 83886080) {
            return false;
        }
        return true;
    }
}
