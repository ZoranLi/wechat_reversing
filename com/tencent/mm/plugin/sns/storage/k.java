package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.e.b.db;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.lang.reflect.Field;

public final class k extends db {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.uxd.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "userName";
        aVar.columns[1] = "md5";
        aVar.uxd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "newerIds";
        aVar.uxd.put("newerIds", "TEXT");
        stringBuilder.append(" newerIds TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "bgId";
        aVar.uxd.put("bgId", "TEXT");
        stringBuilder.append(" bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bgUrl";
        aVar.uxd.put("bgUrl", "TEXT");
        stringBuilder.append(" bgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "older_bgId";
        aVar.uxd.put("older_bgId", "TEXT");
        stringBuilder.append(" older_bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "local_flag";
        aVar.uxd.put("local_flag", "INTEGER");
        stringBuilder.append(" local_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "istyle";
        aVar.uxd.put("istyle", "INTEGER");
        stringBuilder.append(" istyle INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "iFlag";
        aVar.uxd.put("iFlag", "INTEGER");
        stringBuilder.append(" iFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "icount";
        aVar.uxd.put("icount", "INTEGER");
        stringBuilder.append(" icount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "faultS";
        aVar.uxd.put("faultS", "BLOB");
        stringBuilder.append(" faultS BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "snsBgId";
        aVar.uxd.put("snsBgId", "LONG");
        stringBuilder.append(" snsBgId LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "snsuser";
        aVar.uxd.put("snsuser", "BLOB");
        stringBuilder.append(" snsuser BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "adsession";
        aVar.uxd.put("adsession", "BLOB");
        stringBuilder.append(" adsession BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "lastFirstPageRequestErrCode";
        aVar.uxd.put("lastFirstPageRequestErrCode", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastFirstPageRequestErrType";
        aVar.uxd.put("lastFirstPageRequestErrType", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrType INTEGER");
        aVar.columns[16] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final void bhm() {
        this.field_local_flag &= -3;
    }

    public final boolean bhn() {
        return (this.field_local_flag & 2) > 0;
    }

    public final bcp bho() {
        try {
            return (bcp) new bcp().aD(this.field_snsuser);
        } catch (Exception e) {
            return null;
        }
    }

    public final rk bhp() {
        st stVar = new st();
        rk rkVar = new rk();
        if (bg.bm(this.field_faultS)) {
            return rkVar;
        }
        try {
            rk rkVar2;
            stVar = (st) new st().aD(this.field_faultS);
            if (stVar.tAF.size() > 0) {
                rkVar2 = (rk) stVar.tAF.getFirst();
            } else {
                rkVar2 = rkVar;
            }
            return rkVar2;
        } catch (Exception e) {
            return rkVar;
        }
    }
}
