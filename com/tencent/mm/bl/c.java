package com.tencent.mm.bl;

import android.os.Environment;
import android.os.Process;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.concurrent.Executors;

public final class c {
    public static boolean uNB = false;
    public static a uNC = null;

    public static void yU(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        switch (i) {
            case 1:
                z = false;
                z2 = true;
                z3 = false;
                z4 = true;
                break;
            case 2:
                z = false;
                z2 = true;
                z3 = true;
                z4 = true;
                break;
            case 3:
                z = false;
                z2 = false;
                z3 = false;
                z4 = true;
                break;
            case 4:
                z = true;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            case 5:
                z = true;
                z2 = false;
                z3 = true;
                z4 = false;
                break;
            case 6:
                w.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
                System.gc();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            default:
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
        }
        w.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z));
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public final void run() {
                if (c.uNB) {
                    w.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
                    return;
                }
                String I;
                if (z4) {
                    I = b.I(true, false);
                } else {
                    I = null;
                }
                Process.setThreadPriority(10);
                boolean isWifi = am.isWifi(ab.getContext());
                if (!z3 || isWifi) {
                    if (!z2 || r0 == null) {
                        I = z ? b.uNA : null;
                    }
                    c.uNB = true;
                    c.Sz(I);
                    c.uNB = false;
                    return;
                }
                w.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
            }
        });
    }

    public static void Sz(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.MemoryDumpOperation", "Hprof error uploadPath %s ", str);
        } else if (rZ()) {
            File file = new File(str);
            if (file.exists()) {
                String a = p.a(file, true, null);
                if (a != null) {
                    File file2 = new File(a);
                    if (!am.isWifi(ab.getContext()) && file2.length() > 5242880) {
                        w.i("MicroMsg.MemoryDumpOperation", "Hprof not wifi exceed max size, size " + file2.length());
                        return;
                    } else if (uNC == null) {
                        w.e("MicroMsg.MemoryDumpOperation", "Hprof upload : no file upload impl set!");
                        return;
                    } else {
                        w.i("MicroMsg.MemoryDumpOperation", "Hprof upload : %b", Boolean.valueOf(uNC.Cw(a)));
                        if (uNC.Cw(a)) {
                            e.e(new File(b.uNA));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            w.e("MicroMsg.MemoryDumpOperation", "Hprof upload file is not exist");
        } else {
            w.e("MicroMsg.MemoryDumpOperation", "Hprof sdcard invalid.");
        }
    }

    static boolean rZ() {
        try {
            return Environment.getExternalStorageState().equals("mounted") && new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e) {
            return false;
        }
    }
}
