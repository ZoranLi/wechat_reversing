package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class v {
    public boolean qoe = false;

    public static boolean a(g gVar, g gVar2) {
        try {
            if (bg.mA(gVar.getKey())) {
                gVar2.eE("", "ATTACH DATABASE '" + gVar.getPath() + "' AS old ");
            } else {
                gVar2.eE("", "ATTACH DATABASE '" + gVar.getPath() + "' AS old KEY '" + gVar.getKey() + "'");
            }
            w.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + gVar.getKey());
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.TrimSnsDb", e, "", new Object[0]);
            return false;
        }
    }

    public static int a(g gVar, g gVar2, String str) {
        String str2 = null;
        Cursor a = gVar.a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
        if (a != null) {
            if (a.getCount() == 1) {
                a.moveToFirst();
                str2 = a.getString(0);
            }
            a.close();
        }
        if (str2 == null) {
            w.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
            return -1;
        }
        w.i("MicroMsg.TrimSnsDb", "create sql %s", new Object[]{str2});
        w.i("MicroMsg.TrimSnsDb", "create result " + gVar2.eE("", str2));
        return 1;
    }

    public static void GE(String str) {
        List<FileEntry> x = FileOp.x(str, false);
        if (x != null) {
            for (FileEntry fileEntry : x) {
                if (fileEntry.name.startsWith("SnsMicroMsg.dberr")) {
                    w.i("MicroMsg.TrimSnsDb", "find error %s", new Object[]{str + fileEntry.name});
                    FileOp.deleteFile(str + fileEntry.name);
                }
            }
        }
    }
}
