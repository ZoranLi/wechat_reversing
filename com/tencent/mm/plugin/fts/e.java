package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.storage.x;

public final class e implements h {
    private g lYl = com.tencent.mm.kernel.h.vI().gYh;

    public e() {
        com.tencent.mm.kernel.h.vJ();
    }

    public final Cursor g(String str, String[] strArr) {
        return this.lYl.a(str, strArr, 2);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        return this.lYl.a(str, strArr, 0);
    }

    public final x wU(String str) {
        x QX = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().QX(str);
        if (QX == null) {
            QX = new x();
            Cursor a = this.lYl.a("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[]{str}, 2);
            if (a.moveToNext()) {
                QX.gTQ = a.getLong(0);
                QX.setUsername(a.getString(1));
                QX.bO(a.getString(2));
                QX.bP(a.getString(3));
                QX.bR(a.getString(4));
                QX.de(a.getInt(5));
                QX.setType(a.getInt(6));
                QX.u(a.getBlob(7));
                QX.bY(a.getString(8));
                QX.dg(0);
            }
            a.close();
        }
        return QX;
    }

    public final boolean wV(String str) {
        String format = String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]);
        Cursor a = this.lYl.a(format, new String[]{str}, 2);
        try {
            boolean moveToNext = a.moveToNext();
            return moveToNext;
        } finally {
            if (a != null) {
                a.close();
            }
        }
    }

    public final long wW(String str) {
        String[] strArr = new String[]{str};
        Cursor a = this.lYl.a("SELECT conversationTime FROM rconversation WHERE username=?;", strArr, 2);
        long j = 0;
        if (a != null && a.moveToFirst()) {
            j = a.getLong(0);
        }
        if (a != null) {
            a.close();
        }
        return j;
    }
}
