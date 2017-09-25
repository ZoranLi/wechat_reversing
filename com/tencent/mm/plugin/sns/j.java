package com.tencent.mm.plugin.sns;

import android.database.Cursor;
import com.tencent.mm.e.a.lv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends c<lv> {
    public j() {
        this.usg = lv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lv lvVar = (lv) bVar;
        if (lvVar instanceof lv) {
            List linkedList = new LinkedList();
            lvVar.fSX.fSY = null;
            lvVar.fSX.fSZ = null;
            lvVar.fSX.fTa = null;
            w.i("MicroMsg.RecentlySnsMediaObjListener", "recently username " + lvVar.fSW.username);
            if (!bg.mA(lvVar.fSW.username)) {
                h.vJ();
                boolean z = lvVar.fSW.username.equals((String) h.vI().vr().get(2, null));
                n beL = ae.beL();
                String str = ("select *,rowid from SnsInfo " + n.aq(lvVar.fSW.username, z)) + " AND type in ( 1 , 15)" + n.qnA + " limit 3";
                w.d("MicroMsg.SnsInfoStorage", "getUserNewerInfo " + str);
                Cursor rawQuery = beL.gUz.rawQuery(str, null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        int i = 0;
                        do {
                            m mVar = new m();
                            mVar.b(rawQuery);
                            if (mVar.field_type != 21) {
                                Iterator it = mVar.bhd().ufB.tsO.iterator();
                                while (it.hasNext()) {
                                    alh com_tencent_mm_protocal_c_alh = (alh) it.next();
                                    if (com_tencent_mm_protocal_c_alh.jOc == 2 || com_tencent_mm_protocal_c_alh.jOc == 6) {
                                        i++;
                                        linkedList.add(com_tencent_mm_protocal_c_alh);
                                        if (i >= 3) {
                                            break;
                                        }
                                    }
                                    i = i;
                                }
                            }
                        } while (rawQuery.moveToNext());
                        rawQuery.close();
                        if (linkedList.size() > 0) {
                            lvVar.fSX.fSY = (alh) linkedList.get(0);
                        }
                        if (linkedList.size() > 1) {
                            lvVar.fSX.fSZ = (alh) linkedList.get(1);
                        }
                        if (linkedList.size() > 2) {
                            lvVar.fSX.fTa = (alh) linkedList.get(2);
                        }
                    } else {
                        rawQuery.close();
                    }
                }
            }
            return true;
        }
        w.f("MicroMsg.RecentlySnsMediaObjListener", "mismatched event");
        return false;
    }
}
