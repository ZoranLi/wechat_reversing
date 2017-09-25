package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends i<d> {
    public static final String[] gUx = new String[]{i.a(d.gTP, "shakeitem1")};
    public com.tencent.mm.sdk.e.e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return a((d) cVar, false);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.gTP, "shakeitem1", null);
        this.gUz = eVar;
        w.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
        eVar.eE("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
        eVar.eE("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
    }

    public final Cursor baH() {
        return rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", new String[]{"4"});
    }

    public final d baI() {
        d dVar = new d();
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            dVar.b(rawQuery);
        }
        rawQuery.close();
        return dVar;
    }

    public final boolean a(d dVar, boolean z) {
        if (dVar == null) {
            return false;
        }
        if (!(z || bg.mA(dVar.field_username))) {
            Ed(dVar.field_username);
        }
        dVar.fRW = -1;
        return super.b(dVar);
    }

    public final int sv(int i) {
        int delete = this.gUz.delete("shakeitem1", "shakeItemID=?", new String[]{String.valueOf(i)});
        doNotify();
        w.i("MicroMsg.NewShakeItemStorage", "delById id:" + i + " result:" + delete);
        return delete;
    }

    public final int Ed(String str) {
        int delete = this.gUz.delete("shakeitem1", "(username=?)", new String[]{str});
        if (delete > 0) {
            doNotify();
        }
        w.i("MicroMsg.NewShakeItemStorage", "delByusername:" + str + " result:" + delete);
        return delete;
    }

    public final boolean sw(int i) {
        boolean eE;
        if (i == 0) {
            eE = this.gUz.eE("shakeitem1", "delete from shakeitem1 where type = " + i + " or type is null");
        } else {
            eE = this.gUz.eE("shakeitem1", "delete from shakeitem1 where type = " + i);
        }
        doNotify();
        return eE;
    }

    public final boolean baJ() {
        boolean eE = this.gUz.eE("shakeitem1", "delete from shakeitem1");
        doNotify();
        return eE;
    }

    public final void baK() {
        w.i("MicroMsg.NewShakeItemStorage", "setAllOld");
        d dVar = new d();
        dVar.field_insertBatch = 0;
        dVar.fRW = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if (-1 != this.gUz.update("shakeitem1", dVar.pv(), "insertBatch!=?", new String[]{"0"})) {
            doNotify();
        }
    }
}
