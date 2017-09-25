package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.e.b.cw;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends cw {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.uxd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "card_id";
        aVar.columns[1] = "state_flag";
        aVar.uxd.put("state_flag", "INTEGER");
        stringBuilder.append(" state_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "update_time";
        aVar.uxd.put("update_time", "LONG");
        stringBuilder.append(" update_time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "seq";
        aVar.uxd.put("seq", "LONG");
        stringBuilder.append(" seq LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "retryCount";
        aVar.uxd.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[5] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (this.field_card_id == ((n) obj).field_card_id) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_card_id == null ? 0 : this.field_card_id.hashCode();
    }

    public static n b(azu com_tencent_mm_protocal_c_azu) {
        n nVar = new n();
        nVar.field_card_id = com_tencent_mm_protocal_c_azu.fVl;
        nVar.field_update_time = (long) com_tencent_mm_protocal_c_azu.tpx;
        nVar.field_state_flag = com_tencent_mm_protocal_c_azu.kgV;
        nVar.field_seq = com_tencent_mm_protocal_c_azu.ube;
        nVar.field_retryCount = 10;
        return nVar;
    }
}
