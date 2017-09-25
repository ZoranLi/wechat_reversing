package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class q extends c<lz> {
    public q() {
        this.usg = lz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lz lzVar = (lz) bVar;
        w.i("MicroMsg.RecordOperationListener", "on record operation listener, %d", Integer.valueOf(lzVar.fTf.type));
        switch (lzVar.fTf.type) {
            case 0:
                lzVar.fTg.fTp = m.Dp(lzVar.fTf.fTh);
                break;
            case 1:
                w.i("MicroMsg.RecordOperationListener", "get record paths, msg id %d", Long.valueOf(lzVar.fTf.fGM));
                lzVar.fTg.fTr = m.d(lzVar.fTf.fKe, lzVar.fTf.fGM);
                lzVar.fTg.fTq = m.c(lzVar.fTf.fKe, lzVar.fTf.fGM);
                lzVar.fTg.fTs = m.e(lzVar.fTf.fKe, lzVar.fTf.fGM);
                lzVar.fTg.fKz = m.f(lzVar.fTf.fKe, lzVar.fTf.fGM);
                break;
            case 2:
                w.i("MicroMsg.RecordOperationListener", "send record msg, to %s, thumbPath %s, thumbId %s", lzVar.fTf.toUser, lzVar.fTf.fKz, Integer.valueOf(lzVar.fTf.fTj));
                m.a(lzVar.fTf.toUser, lzVar.fTf.fTi, lzVar.fTf.title, lzVar.fTf.desc, lzVar.fTf.fKz, lzVar.fTf.fTj, lzVar.fTf.fTn);
                break;
            case 3:
                w.i("MicroMsg.RecordOperationListener", "clear resouces, msg id %d", Long.valueOf(lzVar.fTf.fGM));
                m.cT(lzVar.fTf.fGM);
                break;
            case 4:
                w.i("MicroMsg.RecordOperationListener", "forward record msg, to %s, msg id %d", lzVar.fTf.toUser, Long.valueOf(lzVar.fTf.fTk.field_msgId));
                m.a(lzVar.fTf.toUser, lzVar.fTf.fKv, lzVar.fTf.fTk);
                break;
            case 5:
                w.i("MicroMsg.RecordOperationListener", "summerrecord forward multi record msg, to %s", lzVar.fTf.toUser);
                m.a(lzVar.fTf.context, lzVar.fTf.toUser, lzVar.fTf.fTm, lzVar.fTf.fTl, lzVar.fTf.fSJ, lzVar.fTf.fTo);
                break;
            case 6:
                cb cbVar = new cb();
                g.a(lzVar.fTf.context, cbVar, lzVar.fTf.fTm, lzVar.fTf.fTl, true);
                d a = m.a(lzVar.fTf.context, cbVar, lzVar.fTf.fTm);
                lzVar.fTg.fSJ = cbVar;
                lzVar.fTg.fTo = a;
                break;
            case 8:
                if (!bg.mA(lzVar.fTf.fKz)) {
                    m.b(lzVar.fTf.fKe, lzVar.fTf.fGM, true);
                    break;
                }
                m.a(lzVar.fTf.fKe, lzVar.fTf.fGM, true);
                break;
        }
        return false;
    }
}
