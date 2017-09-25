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
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.wcdb.FileUtils;

final class bu extends b {
    private a vCd;

    public bu() {
        super(16);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXS);
        view.setTag(new dw(this.knu).p(view, true));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        dw.a((dw) aVar, auVar, true, i, aVar2);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.field_type == 48) {
            int i = ((dt) view.getTag()).position;
            contextMenu.add(i, 126, 0, view.getContext().getString(R.l.eLH));
            if (e.Ds() && !this.vCd.bVJ()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dUl));
            }
            if (d.Jt("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
            }
            com.tencent.mm.sdk.b.b ddVar = new dd();
            ddVar.fGW.fGM = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            if (ddVar.fGX.fGu || g.L(this.vCd.uSU.uTo, auVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
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
