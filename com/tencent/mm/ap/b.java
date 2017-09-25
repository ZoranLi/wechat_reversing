package com.tencent.mm.ap;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import junit.framework.Assert;

public final class b extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public g hnH;

    public b(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(a aVar) {
        aVar.fRW = -1;
        if (((int) this.hnH.insert("chattingbginfo", "username", aVar.pv())) == -1) {
            return false;
        }
        Qr(aVar.getUsername());
        return true;
    }

    public final boolean b(a aVar) {
        Assert.assertTrue(aVar != null);
        ContentValues pv = aVar.pv();
        if (pv.size() > 0) {
            if (this.hnH.update("chattingbginfo", pv, "username= ?", new String[]{aVar.getUsername()}) > 0) {
                Qr(aVar.getUsername());
                return true;
            }
        }
        return false;
    }

    public final a jT(String str) {
        a aVar = null;
        Cursor a = this.hnH.a("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + bg.my(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.b(a);
            }
            a.close();
        }
        return aVar;
    }
}
