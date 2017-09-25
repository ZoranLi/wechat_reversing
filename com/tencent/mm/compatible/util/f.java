package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class f {
    public static boolean eo(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean ep(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean rZ() {
        boolean z = false;
        if (e.hgs.equalsIgnoreCase(h.getExternalStorageDirectory().getAbsolutePath())) {
            try {
                if (h.getExternalStorageState().equals("mounted") && new File(h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    return true;
                }
                return z;
            } catch (Exception e) {
                w.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e.getMessage() + " SDCARD_ROOT: " + e.hgs);
                return z;
            }
        }
        try {
            return new File(e.hgs).canWrite();
        } catch (Exception e2) {
            w.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e2.getMessage() + " SDCARD_ROOT: " + e.hgs);
            return z;
        }
    }

    public static boolean sa() {
        StatFs statFs;
        StatFs statFs2;
        Exception e;
        long j;
        if (!rZ()) {
            return false;
        }
        long blockSize;
        long j2;
        long j3 = 0;
        long j4 = 0;
        try {
            statFs = new StatFs(e.hgs);
            try {
                j3 = (long) statFs.getBlockCount();
                j4 = (long) statFs.getAvailableBlocks();
                statFs2 = statFs;
                blockSize = (long) statFs.getBlockSize();
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.CUtil", "checkSDCardFull", e);
                statFs2 = statFs;
                blockSize = 0;
                if (statFs2 != null) {
                    return false;
                }
                if (j3 > 0) {
                    return false;
                }
                if (j3 - j4 >= 0) {
                    return false;
                }
                j = blockSize * j4;
                j2 = blockSize * j3;
                w.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
                if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
                    return false;
                }
                if (j <= 314572800) {
                    return false;
                }
                w.i("MicroMsg.CUtil", "checkSDCardFull is full!");
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            statFs = null;
            w.e("MicroMsg.CUtil", "checkSDCardFull", e);
            statFs2 = statFs;
            blockSize = 0;
            if (statFs2 != null) {
                return false;
            }
            if (j3 > 0) {
                return false;
            }
            if (j3 - j4 >= 0) {
                return false;
            }
            j = blockSize * j4;
            j2 = blockSize * j3;
            w.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
            if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
                return false;
            }
            if (j <= 314572800) {
                return false;
            }
            w.i("MicroMsg.CUtil", "checkSDCardFull is full!");
            return true;
        }
        if (statFs2 != null) {
            return false;
        }
        if (j3 > 0) {
            return false;
        }
        if (j3 - j4 >= 0) {
            return false;
        }
        j = blockSize * j4;
        j2 = blockSize * j3;
        w.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
        if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
            return false;
        }
        if (j <= 314572800) {
            return false;
        }
        w.i("MicroMsg.CUtil", "checkSDCardFull is full!");
        return true;
    }

    public static boolean G(long j) {
        StatFs statFs;
        long blockCount;
        long j2;
        Exception e;
        if (rZ()) {
            try {
                statFs = new StatFs(e.hgs);
                try {
                    blockCount = (long) statFs.getBlockCount();
                    try {
                        j2 = blockCount;
                        blockCount = (long) statFs.getAvailableBlocks();
                    } catch (Exception e2) {
                        e = e2;
                        w.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                        j2 = blockCount;
                        blockCount = 0;
                        return statFs != null ? false : false;
                    }
                } catch (Exception e3) {
                    e = e3;
                    blockCount = 0;
                    w.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                    j2 = blockCount;
                    blockCount = 0;
                    if (statFs != null) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                statFs = null;
                blockCount = 0;
                w.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                j2 = blockCount;
                blockCount = 0;
                if (statFs != null) {
                }
            }
            if (statFs != null || r8 <= 0 || r8 - r4 < 0) {
                return false;
            }
            if (((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize()) >= j) {
                return true;
            }
            w.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace needSize: " + j + " not enough and ret false");
            return false;
        }
        w.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace sdcard not avail and ret false");
        return false;
    }
}
