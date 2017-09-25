package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import java.util.ArrayList;
import java.util.List;

final class dh implements ai {
    final a vHR;
    dn vHS = new dn();

    public dh(a aVar) {
        this.vHR = aVar;
    }

    public final void a(au auVar) {
        if (this.vHR == null) {
            w.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
            return;
        }
        this.vHR.bTF();
        if (auVar.field_talker.equals(this.vHR.bUg()) && auVar.bMk()) {
            at(auVar);
        }
    }

    public final void p(List<au> list) {
        if (this.vHR == null) {
            w.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
        } else if (!o.dH(this.vHR.bUg())) {
            List arrayList = new ArrayList();
            for (au auVar : list) {
                if (auVar.field_talker.equals(this.vHR.bUg()) && auVar.bMk()) {
                    arrayList.add(auVar);
                }
            }
            cA(arrayList);
        }
    }

    public final void at(au auVar) {
        if (auVar != null) {
            List arrayList = new ArrayList();
            arrayList.add(auVar);
            cA(arrayList);
        }
    }

    private void cA(List<au> list) {
        if (this.vHS != null && this.vHR != null) {
            this.vHS.a(this.vHR.bPj(), list);
        }
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
    }
}
