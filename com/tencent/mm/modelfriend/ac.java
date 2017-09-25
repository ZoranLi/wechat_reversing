package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class ac extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )"};
    public final g hnH;

    public ac(g gVar) {
        this.hnH = gVar;
    }

    public final ab fI(int i) {
        ab abVar = null;
        Cursor a = this.hnH.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = " + i, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                abVar = new ab();
                abVar.b(a);
            }
            a.close();
        }
        return abVar;
    }

    public final boolean a(ab abVar) {
        Assert.assertTrue(abVar != null);
        ContentValues FL = abVar.FL();
        if (FL.size() <= 0) {
            w.e("MicroMsg.QQGroupStorage", "update failed, no values set");
            return false;
        }
        if (this.hnH.update("qqgroup", FL, "grouopid= ?", new String[]{abVar.hBT}) <= 0) {
            return false;
        }
        doNotify();
        return true;
    }
}
