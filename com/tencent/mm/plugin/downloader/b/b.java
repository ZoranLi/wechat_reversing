package com.tencent.mm.plugin.downloader.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )"};

    public b(e eVar) {
        super(eVar, a.gTP, "FileDownloadInfo", null);
    }

    public final a tE(String str) {
        a aVar = null;
        if (bg.mA(str)) {
            w.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where appId=\"" + str + "\"", new String[0]);
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
        return aVar;
    }

    public static String r(ArrayList<String> arrayList) {
        String str = "";
        if (bg.bV(arrayList)) {
            return "1=1";
        }
        String str2 = str;
        int i = 0;
        while (i < arrayList.size() - 1) {
            String str3 = str2 + "appId=\"" + ((String) arrayList.get(i)) + "\" or ";
            i++;
            str2 = str3;
        }
        return str2 + "appId=\"" + ((String) arrayList.get(arrayList.size() - 1)) + "\"";
    }

    public final a bh(long j) {
        a aVar = null;
        if (j < 0) {
            w.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadId=" + j, new String[0]);
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
        return aVar;
    }

    public final boolean akS() {
        return eE("FileDownloadInfo", "delete from FileDownloadInfo");
    }
}
