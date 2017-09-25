package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "ABTestInfo")};
    private e gUz;

    public b(e eVar) {
        super(eVar, a.gTP, "ABTestInfo", null);
        this.gUz = eVar;
    }

    public final void i(List<a> list, int i) {
        Object obj = null;
        long Ny = bg.Ny();
        this.gUz.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(Ny)}), null);
        if (1 == i) {
            c aVar = new a();
            aVar.field_prioritylevel = 1;
            b(aVar, false, "prioritylevel");
        }
        for (c aVar2 : list) {
            boolean z;
            Object obj2;
            if (aVar2 == null || bg.mA(aVar2.field_abtestkey)) {
                w.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c aVar3 = new a();
                aVar3.field_abtestkey = aVar2.field_abtestkey;
                if (!super.b(aVar3, new String[0])) {
                    w.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", aVar2.field_abtestkey, Boolean.valueOf(super.a(aVar2, false)));
                    z = r2;
                } else if ((aVar2.field_sequence <= aVar3.field_sequence || aVar2.field_prioritylevel != aVar3.field_prioritylevel) && aVar2.field_prioritylevel <= aVar3.field_prioritylevel) {
                    w.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", aVar2.field_abtestkey, Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel));
                    z = false;
                } else {
                    w.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", aVar2.field_abtestkey, Boolean.valueOf(super.a(aVar2, false, new String[0])), Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel));
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

    public final LinkedList<qd> bKI() {
        LinkedList<qd> linkedList = new LinkedList();
        Cursor Kk = Kk();
        if (Kk != null) {
            if (Kk.moveToFirst()) {
                a aVar = new a();
                do {
                    aVar.b(Kk);
                    qd qdVar = new qd();
                    try {
                        qdVar.ttA = bg.getInt(aVar.field_expId, 0);
                    } catch (Exception e) {
                        w.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", aVar.field_expId);
                    }
                    qdVar.priority = aVar.field_prioritylevel;
                    linkedList.add(qdVar);
                } while (Kk.moveToNext());
                Kk.close();
            } else {
                Kk.close();
            }
        }
        return linkedList;
    }

    public final a QC(String str) {
        c aVar = new a();
        aVar.field_abtestkey = str;
        if (super.b(aVar, new String[0]) && aVar.field_endTime == 0) {
            aVar.field_endTime = Long.MAX_VALUE;
        }
        w.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        return aVar;
    }

    public final int cF(String str, int i) {
        a QC = QC(str);
        if (QC.isValid()) {
            return bg.getInt(QC.field_value, i);
        }
        return i;
    }

    public final String getExpIdByKey(String str) {
        a QC = QC(str);
        if (QC.isValid()) {
            return QC.field_expId == null ? "" : QC.field_expId;
        } else {
            return "";
        }
    }

    public final String bKJ() {
        Cursor Kk = Kk();
        if (Kk == null) {
            return "null cursor!!";
        }
        if (Kk.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            a aVar = new a();
            do {
                stringBuilder.append("============\n");
                aVar.b(Kk);
                stringBuilder.append("abtestkey = ").append(aVar.field_abtestkey).append("\n");
                stringBuilder.append("sequence = ").append(aVar.field_sequence).append("\n");
                stringBuilder.append("priorityLV = ").append(aVar.field_prioritylevel).append("\n");
                stringBuilder.append("expId = ").append(aVar.field_expId).append("\n");
            } while (Kk.moveToNext());
            Kk.close();
            return stringBuilder.toString();
        }
        Kk.close();
        return "cursor empty!!";
    }
}
