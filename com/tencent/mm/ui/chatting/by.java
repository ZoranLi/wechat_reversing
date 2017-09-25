package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;

final class by extends cc {
    private a vCd;

    public by() {
        super(36);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYh);
        view.setTag(new ed(this.knu).du(view));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        ed edVar = (ed) aVar;
        com.tencent.mm.aa.a.a iG = com.tencent.mm.aa.a.a.iG(auVar.field_content);
        String str2 = iG.fOu;
        a((ah.a) edVar, aVar2, auVar, str2);
        ah.a((ah.a) edVar, aVar2, str2, auVar);
        h.a(edVar.suV.getContext(), com.tencent.mm.aa.a.a(iG), (int) edVar.suV.getTextSize(), null, "");
        edVar.suV.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        edVar.suV.setOnClickListener(aVar2.vBD.vEW);
        edVar.suV.setOnLongClickListener(aVar2.vBD.vEY);
    }

    protected final boolean bUp() {
        return false;
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
