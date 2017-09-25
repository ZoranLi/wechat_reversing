package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import junit.framework.Assert;

public final class e extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) "};
    private g hnH;

    public e(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(d dVar) {
        dVar.fRW = -1;
        return ((int) this.hnH.insert("qcontact", "username", dVar.pv())) != -1;
    }

    public final boolean a(String str, d dVar) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (dVar == null) {
            return false;
        }
        if (this.hnH.update("qcontact", dVar.pv(), "username=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final d CJ(String str) {
        d dVar = null;
        Cursor a = this.hnH.a("select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + bg.my(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                dVar = new d();
                dVar.username = a.getString(0);
                dVar.hCb = a.getLong(1);
                dVar.extInfo = a.getString(2);
                dVar.oyB = a.getInt(3);
                dVar.oyC = a.getLong(4);
                dVar.oyD = a.getLong(5);
                dVar.hnD = a.getInt(6);
                dVar.hBy = a.getInt(7);
                dVar.hrx = a.getInt(8);
                dVar.hry = a.getInt(9);
                dVar.oyE = a.getString(10);
                dVar.oyF = a.getString(11);
                dVar.oyG = a.getString(12);
                dVar.oyH = a.getString(13);
            }
            a.close();
        }
        return dVar;
    }
}
