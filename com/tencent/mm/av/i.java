package com.tencent.mm.av;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.e.b.bz;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.x.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;

public final class i extends com.tencent.mm.sdk.e.i<h> {
    public static final String[] gUx = new String[]{com.tencent.mm.sdk.e.i.a(h.gTP, "LBSVerifyMessage")};
    public e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return a((h) cVar);
    }

    public i(e eVar) {
        super(eVar, h.gTP, "LBSVerifyMessage", bz.gaK);
        this.gUz = eVar;
    }

    public final int Kr() {
        Cursor a = this.gUz.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            return i;
        }
        a.close();
        return 0;
    }

    public final int getCount() {
        int i = 0;
        Cursor a = this.gUz.a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final h Ks() {
        Cursor a = this.gUz.a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            h hVar = new h();
            hVar.b(a);
            a.close();
            return hVar;
        }
        a.close();
        return null;
    }

    public final void Kt() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        if (this.gUz.update(getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            doNotify();
        }
    }

    public final void lc(String str) {
        int delete = this.gUz.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        w.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void ld(String str) {
        int delete = this.gUz.delete(getTableName(), "sayhiuser = '" + str + "' or sayhiencryptuser='" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        w.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = " + delete);
    }

    public final void Ku() {
        this.gUz.delete(getTableName(), null, null);
    }

    public final void a(bu buVar, d dVar) {
        w.d("MicroMsg.LBSVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + buVar.jNB + ", id = " + buVar.tfk);
        h hVar = new h();
        hVar.field_content = n.a(buVar.tff);
        hVar.field_createtime = bg.Ny();
        hVar.field_imgpath = "";
        hVar.field_sayhicontent = dVar.content;
        hVar.field_sayhiuser = dVar.rUK;
        hVar.field_scene = dVar.scene;
        hVar.field_status = buVar.jNB > 3 ? buVar.jNB : 3;
        hVar.field_svrid = buVar.tfk;
        hVar.field_talker = n.a(buVar.tfd);
        hVar.field_type = buVar.mtd;
        hVar.field_isSend = 0;
        hVar.field_sayhiencryptuser = dVar.uKj;
        hVar.field_ticket = dVar.osP;
        hVar.field_flag = 1;
        a(hVar);
        b.u(hVar.field_sayhiencryptuser, 3);
    }

    public final boolean a(h hVar) {
        if (hVar == null) {
            w.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
            return false;
        } else if (!super.b((c) hVar)) {
            return false;
        } else {
            Qr(hVar.uxb);
            return true;
        }
    }

    public final h[] le(String str) {
        w.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
        Cursor a = this.gUz.a("select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bg.my(str) + "' or sayhiencryptuser = '" + bg.my(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            h hVar = new h();
            hVar.b(a);
            arrayList.add(hVar);
        }
        a.close();
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public final h lf(String str) {
        h hVar = null;
        w.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
        Cursor a = this.gUz.a("select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bg.my(str) + "' or sayhiencryptuser = '" + bg.my(str) + "') and flag=1 order by createtime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            hVar = new h();
            hVar.b(a);
        } else {
            w.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
        }
        a.close();
        return hVar;
    }

    public final h lg(String str) {
        h[] F = F(str, 1);
        if (F != null) {
            return F[0];
        }
        return null;
    }

    public final h[] F(String str, int i) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
            return null;
        }
        Cursor a = this.gUz.a("select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bg.my(str) + "' or sayhiencryptuser = '" + bg.my(str) + "') order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            h hVar = new h();
            hVar.b(a);
            arrayList.add(hVar);
        }
        a.close();
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public static long lh(String str) {
        h hVar = null;
        long j = 0;
        if (str != null) {
            i Kz = l.Kz();
            Cursor a = Kz.gUz.a("SELECT * FROM " + Kz.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    hVar = new h();
                    hVar.b(a);
                    a.close();
                } else {
                    a.close();
                }
            }
            if (hVar != null) {
                j = hVar.field_createtime + 1;
            }
        }
        long Ny = bg.Ny();
        return j > Ny ? j : Ny;
    }
}
