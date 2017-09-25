package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class z {

    private static class a implements com.tencent.mm.sdk.platformtools.ar.a {
        private Set<Long> vAX;
        private p vAY;
        private dz vAZ;

        public a(Set<Long> set, p pVar, dz dzVar) {
            this.vAX = set;
            this.vAY = pVar;
            this.vAZ = dzVar;
        }

        public final boolean Bn() {
            Set<Long> set = this.vAX;
            List linkedList = new LinkedList();
            for (Long l : set) {
                ap.yY();
                ce cA = c.wT().cA(l.longValue());
                if (cA.field_msgId == l.longValue()) {
                    if (cA.axO()) {
                        b.hUp.d(cA, g.g(cA));
                    } else {
                        b.hUp.u(cA);
                    }
                }
                linkedList.add(l);
                com.tencent.mm.sdk.b.b lzVar = new lz();
                lzVar.fTf.type = 3;
                lzVar.fTf.fGM = l.longValue();
                com.tencent.mm.sdk.b.a.urY.m(lzVar);
            }
            ay.v(linkedList);
            if (this.vAZ != null) {
                this.vAZ.a(com.tencent.mm.ui.chatting.dz.a.del);
            }
            return true;
        }

        public final boolean Bo() {
            if (this.vAY != null) {
                this.vAY.dismiss();
                if (this.vAZ != null) {
                    this.vAZ.b(com.tencent.mm.ui.chatting.dz.a.del);
                }
            }
            return true;
        }
    }

    public static void a(Context context, Set<Long> set, dz dzVar) {
        if (context == null) {
            w.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
        } else if (set == null || set.isEmpty()) {
            w.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
        } else {
            context.getString(R.l.dIO);
            db.vGa.c(new a(set, com.tencent.mm.ui.base.g.a(context, context.getString(R.l.ebx), false, null), dzVar));
            com.tencent.mm.plugin.report.service.g.oUh.i(10811, Integer.valueOf(4), Integer.valueOf(set.size()));
        }
    }
}
