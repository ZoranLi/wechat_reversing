package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class ai extends j implements b {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) "};
    private g hnH;

    public ai(g gVar) {
        this.hnH = gVar;
    }

    public final boolean v(String str, long j) {
        if (bg.mA(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(j));
        if (((int) this.hnH.replace("DeletedConversationInfo", "userName", contentValues)) == -1) {
            return false;
        }
        Qr(str);
        return true;
    }

    public final long Ad(String str) {
        if (bg.mA(str)) {
            return 0;
        }
        Cursor a = this.hnH.a("select lastSeq from DeletedConversationInfo where userName = \"" + bg.my(str) + "\"", null, 2);
        if (a == null) {
            w.e("MicroMsg.DeletedConversationInfoStorage", "getLastSeq failed " + str);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return 0;
        }
    }
}
