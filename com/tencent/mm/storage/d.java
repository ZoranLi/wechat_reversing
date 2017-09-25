package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d extends i<c> {
    public static final String[] gUx = new String[]{i.a(c.gTP, "ABTestItem")};
    private final e gUz;

    public d(e eVar) {
        super(eVar, c.gTP, "ABTestItem", null);
        this.gUz = eVar;
    }

    public final c dX(String str) {
        c cVar = new c();
        cVar.field_layerId = str;
        if (super.b(cVar, new String[0]) && cVar.field_endTime == 0) {
            cVar.field_endTime = Long.MAX_VALUE;
        }
        w.i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        return cVar;
    }

    public final Map<String, c> QD(String str) {
        Cursor cursor;
        if (bg.mA(str)) {
            cursor = null;
        } else {
            cursor = rawQuery(String.format("select * from %s where %s = %s", new Object[]{"ABTestItem", "business", str}), new String[0]);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            return new HashMap(0);
        }
        Map<String, c> hashMap = new HashMap();
        do {
            c cVar = new c();
            cVar.b(cursor);
            hashMap.put(cVar.field_layerId, cVar);
        } while (cursor.moveToNext());
        cursor.close();
        return hashMap;
    }

    public final void i(List<c> list, int i) {
        Object obj = null;
        long Ny = bg.Ny();
        this.gUz.delete("ABTestItem", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(Ny)}), null);
        if (i == 0) {
            c cVar = new c();
            cVar.field_prioritylevel = 1;
            b(cVar, false, "prioritylevel");
        }
        for (c cVar2 : list) {
            boolean z;
            Object obj2;
            if (cVar2 == null || bg.mA(cVar2.field_layerId)) {
                w.e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c cVar3 = new c();
                cVar3.field_layerId = cVar2.field_layerId;
                if (!super.b(cVar3, new String[0])) {
                    w.i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", cVar2.field_layerId, Boolean.valueOf(super.a(cVar2, false)));
                    z = r2;
                } else if ((cVar2.field_sequence <= cVar3.field_sequence || cVar2.field_prioritylevel != cVar3.field_prioritylevel) && cVar2.field_prioritylevel <= cVar3.field_prioritylevel) {
                    w.i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = false;
                } else {
                    w.i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Boolean.valueOf(super.a(cVar2, false, new String[0])), Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = r2;
                }
            }
            if (z) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj != null) {
            Qr("event_updated");
        }
    }

    public final String bKJ() {
        Cursor Kk = Kk();
        if (Kk == null) {
            return "null cursor!!";
        }
        if (Kk.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            c cVar = new c();
            do {
                stringBuilder.append("============\n");
                cVar.b(Kk);
                stringBuilder.append("layerId = ").append(cVar.field_layerId).append("\n");
                stringBuilder.append("sequence = ").append(cVar.field_sequence).append("\n");
                stringBuilder.append("priorityLV = ").append(cVar.field_prioritylevel).append("\n");
                stringBuilder.append("expId = ").append(cVar.field_expId).append("\n");
            } while (Kk.moveToNext());
            Kk.close();
            return stringBuilder.toString();
        }
        Kk.close();
        return "cursor empty!!";
    }

    public final LinkedList<qd> bKI() {
        LinkedList<qd> linkedList = new LinkedList();
        Cursor Kk = Kk();
        if (Kk != null && Kk.moveToFirst()) {
            c cVar = new c();
            do {
                cVar.b(Kk);
                qd qdVar = new qd();
                try {
                    qdVar.ttA = bg.getInt(cVar.field_expId, 0);
                } catch (Exception e) {
                    w.e("MicroMsg.ABTestStorage", "expId parse failed, %s", cVar.field_expId);
                }
                qdVar.priority = cVar.field_prioritylevel;
                linkedList.add(qdVar);
            } while (Kk.moveToNext());
            Kk.close();
        }
        return linkedList;
    }
}
