package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.e.b.cr;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends cr {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "uid";
        aVar.uxd.put("uid", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "uid";
        aVar.columns[1] = "name";
        aVar.uxd.put("name", "TEXT default '' ");
        stringBuilder.append(" name TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "devicetype";
        aVar.uxd.put("devicetype", "TEXT default '' ");
        stringBuilder.append(" devicetype TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createtime";
        aVar.uxd.put("createtime", "LONG default '0' ");
        stringBuilder.append(" createtime LONG default '0' ");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public c() {
        this.field_uid = "0";
        this.field_name = "";
        this.field_devicetype = "";
        this.field_createtime = 0;
    }

    public c(avz com_tencent_mm_protocal_c_avz) {
        this.field_createtime = (long) com_tencent_mm_protocal_c_avz.ogM;
        this.field_devicetype = com_tencent_mm_protocal_c_avz.thD;
        this.field_name = com_tencent_mm_protocal_c_avz.msj;
        this.field_uid = com_tencent_mm_protocal_c_avz.ttx;
    }
}
