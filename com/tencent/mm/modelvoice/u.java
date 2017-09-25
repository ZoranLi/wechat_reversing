package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.k;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class u extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )", "DELETE FROM voiceinfo WHERE Status = 99"};
    public g hnH;
    Map<String, a> icx = new HashMap();
    Map<String, l> icy = new HashMap();
    Map<String, h> icz = new HashMap();

    public u(g gVar) {
        b(gVar);
        this.hnH = gVar;
    }

    private static void b(g gVar) {
        int i = 0;
        Cursor a = gVar.a("PRAGMA table_info(voiceinfo)", null, 0);
        if (a == null) {
            w.i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
            return;
        }
        int columnIndex = a.getColumnIndex("name");
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("MsgSource".equals(string)) {
                    i4 = 1;
                }
                if ("MsgFlag".equals(string)) {
                    i3 = 1;
                }
                if ("MsgSeq".equals(string)) {
                    i2 = 1;
                }
                if ("MasterBufId".equals(string)) {
                    i = 1;
                }
            }
        }
        a.close();
        if (i4 == 0) {
            gVar.eE("voiceinfo", "Alter table voiceinfo add MsgSource TEXT");
        }
        if (i3 == 0) {
            gVar.eE("voiceinfo", "Alter table voiceinfo add MsgFlag INT");
        }
        if (i2 == 0) {
            gVar.eE("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
        }
        if (i == 0) {
            gVar.eE("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
        }
    }

    public static String mf(String str) {
        return k.f(str, bg.Nz());
    }

    public final boolean b(p pVar) {
        Assert.assertTrue(pVar != null);
        ContentValues pv = pVar.pv();
        if (pv.size() <= 0) {
            w.e("MicroMsg.VoiceStorage", "insert falied, no values set");
        } else if (this.hnH.insert("voiceinfo", "FileName", pv) != -1) {
            doNotify();
            return true;
        }
        return false;
    }

    public final boolean gR(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.hnH.delete("voiceinfo", "FileName= ?", new String[]{str}) <= 0) {
            w.w("MicroMsg.VoiceStorage", "delete failed, no such file:" + str);
        }
        return true;
    }

    public final boolean a(String str, p pVar) {
        boolean z;
        Assert.assertTrue(str.length() > 0);
        if (pVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues pv = pVar.pv();
        if (pv.size() <= 0) {
            w.e("MicroMsg.VoiceStorage", "update failed, no values set");
        } else {
            if (this.hnH.update("voiceinfo", pv, "FileName= ?", new String[]{str}) > 0) {
                doNotify();
                return true;
            }
        }
        return false;
    }

    public final p ax(long j) {
        p pVar = null;
        Cursor a = this.hnH.a("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo WHERE MsgId=" + j, null, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.b(a);
        }
        a.close();
        return pVar;
    }

    public final p gR(int i) {
        p pVar = null;
        Cursor a = this.hnH.a("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo WHERE MsgLocalId=" + i, null, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.b(a);
        }
        a.close();
        return pVar;
    }

    public final p mg(String str) {
        p pVar = null;
        String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo WHERE FileName= ?";
        Cursor a = this.hnH.a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.b(a);
        }
        a.close();
        return pVar;
    }
}
