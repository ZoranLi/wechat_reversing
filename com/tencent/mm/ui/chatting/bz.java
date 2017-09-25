package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;

final class bz extends cd {
    private a vCd;

    public bz() {
        super(37);
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        aVar = (em) aVar;
        com.tencent.mm.aa.a.a iG = com.tencent.mm.aa.a.a.iG(auVar.field_content);
        if (auVar.field_status >= 2) {
            aVar.oDJ.setVisibility(8);
        } else {
            aVar.oDJ.setVisibility(0);
        }
        h.a(aVar.vOB.getContext(), com.tencent.mm.aa.a.a(iG), (int) aVar.vOB.getTextSize(), null, "");
        aVar.vOB.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        aVar.vOB.setOnClickListener(aVar2.vBD.vEW);
        aVar.vOB.setOnLongClickListener(aVar2.vBD.vEY);
        ah.a(i, aVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.bMr()) {
            int i = ((dt) view.getTag()).position;
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dVm));
            }
            if (!this.vCd.bVJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
            }
        }
        return true;
    }
}
