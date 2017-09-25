package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class m implements v {
    public final void lM(String str) {
        final r ls = o.KV().ls(str);
        if (ls != null) {
            o.KV();
            final String lv = s.lv(str);
            aks com_tencent_mm_protocal_c_aks = ls.iaz;
            VideoTransPara Ev = d.Eu().Ev();
            if (com_tencent_mm_protocal_c_aks != null) {
                w.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aks.tOt), str, lv});
                if (com_tencent_mm_protocal_c_aks.tOt > 1) {
                    t.lA(str);
                    return;
                }
            }
            boolean a = l.a(lv, Ev, com_tencent_mm_protocal_c_aks, new d(this) {
                final /* synthetic */ m nCO;

                public final boolean aJQ() {
                    w.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[]{lv});
                    ls.hrs = s.lx(lv);
                    ls.fRW = 32;
                    o.KV().b(ls);
                    return true;
                }
            });
            if (com_tencent_mm_protocal_c_aks != null) {
                w.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[]{str, Boolean.valueOf(a)});
                com_tencent_mm_protocal_c_aks.tOw = !a;
                ls.iaz = com_tencent_mm_protocal_c_aks;
                ls.fRW = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                o.KV().b(ls);
            }
            if (a) {
                if (com_tencent_mm_protocal_c_aks != null) {
                    com_tencent_mm_protocal_c_aks.tOt++;
                    ls.iaz = com_tencent_mm_protocal_c_aks;
                }
                ls.fRW = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                o.KV().b(ls);
                c.pw(ls.iaq);
                if (l.b(lv, Ev, com_tencent_mm_protocal_c_aks, new d(this) {
                    final /* synthetic */ m nCO;

                    public final boolean aJQ() {
                        c.py(ls.iaq);
                        w.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[]{lv});
                        ls.hrs = s.lx(lv);
                        ls.fRW = 32;
                        o.KV().b(ls);
                        return true;
                    }
                }) < 0) {
                    w.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
                    g.oUh.a(440, 45, 1, false);
                    t.lA(str);
                } else if (com_tencent_mm_protocal_c_aks != null) {
                    com_tencent_mm_protocal_c_aks.tOw = true;
                    ls.iaz = com_tencent_mm_protocal_c_aks;
                    ls.fRW = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                    o.KV().b(ls);
                }
            }
        }
    }
}
