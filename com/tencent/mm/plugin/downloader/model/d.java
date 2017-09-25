package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    public static a ba(long j) {
        b wX = wX();
        if (wX == null) {
            return null;
        }
        return wX.bh(j);
    }

    public static a tE(String str) {
        b wX = wX();
        if (wX == null) {
            return null;
        }
        return wX.tE(str);
    }

    public static long a(a aVar) {
        if (aVar == null) {
            return -1;
        }
        b wX = wX();
        if (wX == null) {
            return -1;
        }
        w.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + aVar.field_downloadId + ", ret=" + wX.b((c) aVar));
        return aVar.field_downloadId;
    }

    public static long b(a aVar) {
        if (aVar == null) {
            return -1;
        }
        b wX = wX();
        if (wX == null) {
            return -1;
        }
        boolean c = wX.c(aVar, new String[0]);
        w.d("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", Long.valueOf(aVar.field_downloadId), Boolean.valueOf(c), Integer.valueOf(aVar.field_status));
        return aVar.field_downloadId;
    }

    public static boolean j(long j, int i) {
        b wX = wX();
        if (wX == null) {
            return false;
        }
        return wX.eE("FileDownloadInfo", "update FileDownloadInfo set status = " + i + " where downloadId = " + j);
    }

    public static boolean e(long j, long j2, long j3) {
        b wX = wX();
        if (wX == null) {
            return false;
        }
        return wX.eE("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + j2 + ",totalSize= " + j3 + " where downloadId = " + j);
    }

    public static boolean tF(String str) {
        b wX = wX();
        if (wX == null) {
            return false;
        }
        if (bg.mA(str)) {
            w.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
            return false;
        }
        return wX.eE("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + str + "\"");
    }

    public static boolean tG(String str) {
        b wX = wX();
        if (wX == null) {
            return false;
        }
        if (bg.mA(str)) {
            w.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
            return false;
        }
        return wX.eE("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + str + "\"");
    }

    public static a tH(String str) {
        a aVar = null;
        b wX = wX();
        if (wX != null) {
            if (bg.mA(str)) {
                w.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
            } else {
                Cursor rawQuery = wX.rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + str.hashCode(), new String[0]);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        aVar = new a();
                        aVar.b(rawQuery);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }
        }
        return aVar;
    }

    public static boolean bb(long j) {
        b wX = wX();
        if (wX == null) {
            return false;
        }
        c aVar = new a();
        aVar.field_downloadId = j;
        return wX.a(aVar, new String[0]);
    }

    public static b wX() {
        if (h.vG().uV()) {
            h.vG();
            if (!com.tencent.mm.kernel.a.uP()) {
                return ((com.tencent.mm.plugin.downloader.a.a) h.h(com.tencent.mm.plugin.downloader.a.a.class)).wX();
            }
        }
        w.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
        return null;
    }
}
