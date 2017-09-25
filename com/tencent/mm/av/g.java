package com.tencent.mm.av;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class g extends i<f> {
    public static final String[] gUx = new String[]{i.a(f.gTP, "fmessage_msginfo")};
    private static final String[] hXE = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )"};
    e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public g(e eVar) {
        super(eVar, f.gTP, "fmessage_msginfo", hXE);
        this.gUz = eVar;
    }

    public final f[] kZ(String str) {
        w.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
        Cursor a = this.gUz.a("select *, rowid from fmessage_msginfo  where talker = '" + bg.my(str) + "' order by createTime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            f fVar = new f();
            fVar.b(a);
            arrayList.add(fVar);
        }
        a.close();
        return (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    public final f la(String str) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
        } else {
            Cursor a = this.gUz.a("select * from fmessage_msginfo where talker = '" + bg.my(str) + "' order by createTime DESC limit 1", null, 2);
            fVar = new f();
            if (a.moveToFirst()) {
                fVar.b(a);
            }
            a.close();
        }
        return fVar;
    }

    public final f lb(String str) {
        f[] E = E(str, 1);
        if (E == null || E.length <= 0) {
            return null;
        }
        return E[0];
    }

    public final f[] E(String str, int i) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
            return null;
        }
        Cursor a = this.gUz.a("select * from fmessage_msginfo where isSend != 1 and talker = '" + bg.my(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            f fVar = new f();
            fVar.b(a);
            arrayList.add(fVar);
        }
        a.close();
        return (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    public final boolean a(f fVar) {
        if (fVar == null) {
            w.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
            return false;
        } else if (!super.b((c) fVar)) {
            return false;
        } else {
            Qr(fVar.uxb);
            return true;
        }
    }

    public final ArrayList<f> Kq() {
        w.d("MicroMsg.FMessageMsgInfoStorage", new StringBuilder("getFMsgByType, type = 0").toString());
        ArrayList<f> arrayList = new ArrayList();
        Cursor a = this.gUz.a(new StringBuilder("select *, rowid from fmessage_msginfo where type = 0").toString(), null, 2);
        while (a.moveToNext()) {
            f fVar = new f();
            fVar.b(a);
            arrayList.add(fVar);
        }
        a.close();
        w.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + arrayList.size());
        return arrayList;
    }
}
