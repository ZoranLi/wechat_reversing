package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.bd.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.boa;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends b {
    private int fCK;
    private String fJL;
    private boolean fPW;

    public j(String str, int i, boolean z) {
        this.fJL = str;
        this.fCK = i;
        this.fPW = z;
    }

    private String g(String str, ArrayList<au> arrayList) {
        w.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[]{str, Integer.valueOf(arrayList.size())});
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            stringBuffer.append(c(str, (au) arrayList.get(size)));
            stringBuffer.append("​​");
        }
        return stringBuffer.toString().trim();
    }

    private static String V(ArrayList<au> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            au auVar = (au) it.next();
            stringBuffer.append(auVar.field_msgId);
            stringBuffer.append(auVar.field_talker);
            stringBuffer.append(auVar.field_content);
            stringBuffer.append(auVar.field_type);
            stringBuffer.append(auVar.field_createTime);
        }
        return aa.Pq(stringBuffer.toString());
    }

    public final String getName() {
        return "WearNotificationCreateTask";
    }

    protected final void send() {
        w.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
        f IC = a.bvG().rTq.IC(this.fJL);
        ArrayList arrayList = new ArrayList();
        int i = this.fCK - IC.rTW;
        if (i < 0) {
            i = 0;
        }
        w.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[]{Integer.valueOf(i)});
        ap.yY();
        for (au auVar : c.wT().bd(this.fJL, i)) {
            if ((auVar.isSystem() ? 0 : 1) != 0) {
                arrayList.add(auVar);
            }
        }
        w.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        if (arrayList.size() != 0) {
            String V = V(arrayList);
            if (IC.fFW.equals(V)) {
                w.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
                return;
            }
            IC.fFW = V;
            boa com_tencent_mm_protocal_c_boa = new boa();
            com_tencent_mm_protocal_c_boa.mvT = IC.id;
            com_tencent_mm_protocal_c_boa.umH = IC.fJL;
            com_tencent_mm_protocal_c_boa.fDC = h.IH(IC.fJL);
            com_tencent_mm_protocal_c_boa.opI = g(IC.fJL, arrayList);
            com_tencent_mm_protocal_c_boa.umT = this.fCK;
            com_tencent_mm_protocal_c_boa.umV = this.fPW;
            com_tencent_mm_protocal_c_boa.umU = !bg.bJX();
            Bitmap IG = h.IG(IC.fJL);
            if (IG != null) {
                com_tencent_mm_protocal_c_boa.umz = new b(h.G(IG));
            }
            w.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
            try {
                a.bvG();
                r.a(20003, com_tencent_mm_protocal_c_boa.toByteArray(), true);
            } catch (IOException e) {
            }
            w.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
            a.bvG().rTq.a(IC);
            a.bvG().rTq.IF(this.fJL);
            com.tencent.mm.plugin.wear.model.c.a.dv(6, 0);
            com.tencent.mm.plugin.wear.model.c.a.vJ(1);
        }
    }
}
