package com.tencent.mm.u;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class bu {
    public static boolean hoq = false;
    private static bu hot = null;
    private ArrayList<String> hor = new ArrayList();
    private String hos = "";

    public bu(String str, boolean z) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        try {
            String format;
            this.hos = str + "version_history.cfg";
            randomAccessFile = new RandomAccessFile(this.hos, "rw");
            long length = randomAccessFile.length();
            w.i("MicroMsg.VersionHistory", "init fileLen:%d isNewAcc:%b curVer:0x%x path:%s", Long.valueOf(length), Boolean.valueOf(z), Integer.valueOf(d.sYN), this.hos);
            if (length <= 0 || length > 10240) {
                randomAccessFile.seek(0);
                if (!z) {
                    format = String.format("%x", new Object[]{Integer.valueOf(536870913)});
                    randomAccessFile.write((format + "\n").getBytes());
                    this.hor.add(format);
                }
            } else {
                while (randomAccessFile.getFilePointer() < length) {
                    format = bg.ap(randomAccessFile.readLine(), "");
                    if (format.length() != 8) {
                        w.e("MicroMsg.VersionHistory", "Read ver history failed , line len:%d path:%s", Integer.valueOf(format.length()), this.hos);
                    } else {
                        try {
                            if (format.startsWith("2")) {
                                this.hor.add(format);
                            } else {
                                w.e("MicroMsg.VersionHistory", "Read ver history failed , line:%s %s", format, this.hos);
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                }
            }
            format = String.format("%x", new Object[]{Integer.valueOf(d.sYN)});
            if (this.hor.size() == 0 || !format.equals(this.hor.get(this.hor.size() - 1))) {
                hoq = true;
                this.hor.add(format);
                randomAccessFile.seek(length);
                randomAccessFile.write((format + "\n").getBytes());
            }
            format = "";
            int i = 0;
            while (i < this.hor.size()) {
                String str2 = format + ((String) this.hor.get(i)) + ";";
                i++;
                format = str2;
            }
            w.i("MicroMsg.VersionHistory", "Read succ isupdate:%b ver:%s file:%s", Boolean.valueOf(hoq), format, this.hos);
            try {
                randomAccessFile.close();
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.VersionHistory", e3, "Close Version History file failed.", "");
            }
        } catch (Exception e4) {
            e3 = e4;
            randomAccessFile = null;
            try {
                w.printErrStackTrace("MicroMsg.VersionHistory", e3, "Open Version History file failed.", "");
                try {
                    randomAccessFile.close();
                } catch (Throwable e32) {
                    w.printErrStackTrace("MicroMsg.VersionHistory", e32, "Close Version History file failed.", "");
                }
                if (hot != null) {
                    return;
                }
                return;
            } catch (Throwable th) {
                e32 = th;
                try {
                    randomAccessFile.close();
                } catch (Throwable e5) {
                    w.printErrStackTrace("MicroMsg.VersionHistory", e5, "Close Version History file failed.", "");
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            randomAccessFile = null;
            randomAccessFile.close();
            throw e32;
        }
        if (hot != null && hot != this && hot.hor.size() < this.hor.size()) {
            hot.hor = this.hor;
            j.p(this.hos, hot.hos, false);
        }
    }

    public static void gt(String str) {
        hot = new bu(str, true);
    }

    public static String Ab() {
        if (hot == null) {
            return "";
        }
        bu buVar = hot;
        String str = "";
        String str2 = str;
        for (int size = 4 >= buVar.hor.size() ? 0 : buVar.hor.size() - 4; size < buVar.hor.size(); size++) {
            str2 = str2 + ((String) buVar.hor.get(size)) + ";";
        }
        return str2;
    }
}
