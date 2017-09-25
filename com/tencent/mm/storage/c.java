package com.tencent.mm.storage;

import com.tencent.mm.e.b.d;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c extends d implements Serializable {
    protected static a gTP;
    private Map<String, String> uyP = null;

    static {
        a aVar = new a();
        aVar.hXH = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "layerId";
        aVar.uxd.put("layerId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" layerId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "layerId";
        aVar.columns[1] = "business";
        aVar.uxd.put("business", "TEXT");
        stringBuilder.append(" business TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "expId";
        aVar.uxd.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sequence";
        aVar.uxd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "prioritylevel";
        aVar.uxd.put("prioritylevel", "INTEGER default '0' ");
        stringBuilder.append(" prioritylevel INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "startTime";
        aVar.uxd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "endTime";
        aVar.uxd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "needReport";
        aVar.uxd.put("needReport", "INTEGER");
        stringBuilder.append(" needReport INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "rawXML";
        aVar.uxd.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        aVar.columns[9] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean isValid() {
        long Ny = bg.Ny();
        return Ny >= this.field_startTime && Ny <= this.field_endTime;
    }

    public final Map<String, String> bKK() {
        if (this.uyP == null) {
            this.uyP = com.tencent.mm.u.c.a.gD(this.field_rawXML);
        }
        return this.uyP;
    }
}
