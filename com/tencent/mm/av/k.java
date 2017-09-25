package com.tencent.mm.av;

import android.database.Cursor;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.x.b;
import java.util.ArrayList;

public final class k extends i<j> {
    public static final String[] gUx = new String[]{i.a(j.gTP, "shakeverifymessage")};
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )"};
    public e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return a((j) cVar);
    }

    public k(e eVar) {
        super(eVar, j.gTP, "shakeverifymessage", gaK);
        this.gUz = eVar;
    }

    public final int Kr() {
        Cursor a = this.gUz.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                return i;
            }
            return 0;
        }
        a.close();
        return 0;
    }

    public final int getCount() {
        Cursor a = this.gUz.a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                return i;
            }
            return 0;
        }
        a.close();
        return 0;
    }

    public final j Kv() {
        Cursor a = this.gUz.a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            j jVar = new j();
            jVar.b(a);
            a.close();
            return jVar;
        }
        a.close();
        return null;
    }

    public final void lc(String str) {
        int delete = this.gUz.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        w.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void Ku() {
        this.gUz.delete(getTableName(), null, null);
    }

    public final void a(bu buVar, d dVar) {
        w.d("MicroMsg.ShakeVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + buVar.jNB + ", id = " + buVar.tfk);
        j jVar = new j();
        jVar.field_content = n.a(buVar.tff);
        jVar.field_createtime = bg.Ny();
        jVar.field_imgpath = "";
        jVar.field_sayhicontent = dVar.content;
        jVar.field_sayhiuser = dVar.rUK;
        jVar.field_scene = dVar.scene;
        jVar.field_status = buVar.jNB > 3 ? buVar.jNB : 3;
        jVar.field_svrid = buVar.tfk;
        jVar.field_talker = n.a(buVar.tfd);
        jVar.field_type = buVar.mtd;
        jVar.field_isSend = 0;
        a(jVar);
        b.u(jVar.field_sayhiuser, 3);
    }

    public final boolean a(j jVar) {
        if (jVar == null) {
            w.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b((c) jVar)) {
            return false;
        } else {
            Qr(jVar.uxb);
            return true;
        }
    }

    public final j li(String str) {
        j[] G = G(str, 1);
        if (G != null) {
            return G[0];
        }
        return null;
    }

    public final j[] G(String str, int i) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
            return null;
        }
        Cursor a = this.gUz.a("select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bg.my(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            j jVar = new j();
            jVar.b(a);
            arrayList.add(jVar);
        }
        a.close();
        if (arrayList.size() != 0) {
            return (j[]) arrayList.toArray(new j[arrayList.size()]);
        }
        return null;
    }

    public final j[] lj(String str) {
        w.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
        Cursor a = this.gUz.a("select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bg.my(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            j jVar = new j();
            jVar.b(a);
            arrayList.add(jVar);
        }
        a.close();
        if (arrayList.size() == 0) {
            return null;
        }
        return (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    public static long lh(String str) {
        long j = 0;
        if (str != null) {
            j Kv = l.KA().Kv();
            if (Kv != null) {
                j = Kv.field_createtime + 1;
            }
        }
        long Ny = bg.Ny();
        return j > Ny ? j : Ny;
    }
}
