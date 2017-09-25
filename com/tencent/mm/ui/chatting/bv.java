package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.wcdb.FileUtils;

final class bv extends c {
    private a vCd;

    public bv() {
        super(17);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYw);
        view.setTag(new dw(this.knu).p(view, false));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        dw.a((dw) aVar, auVar, false, i, aVar2);
        dw dwVar = (dw) aVar;
        if (ah.bUq()) {
            if (auVar.field_status == 2 && ah.a(aVar2.vBD, auVar.field_msgId)) {
                if (dwVar.vyy != null) {
                    dwVar.vyy.setVisibility(0);
                }
            } else if (dwVar.vyy != null) {
                dwVar.vyy.setVisibility(8);
            }
        }
        ah.a(i, (ah.a) dwVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.field_type == 48) {
            int i = ((dt) view.getTag()).position;
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dVm));
            }
            contextMenu.add(i, 126, 0, view.getContext().getString(R.l.eLH));
            if (e.Ds() && !this.vCd.bVJ()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dUl));
            }
            if (d.Jt("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
            }
            b ddVar = new dd();
            ddVar.fGW.fGM = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            if (ddVar.fGX.fGu || g.L(this.vCd.uSU.uTo, auVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
            }
            if (!auVar.bLX() && auVar.bMj() && ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
            }
            if (!this.vCd.bVJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }
}
