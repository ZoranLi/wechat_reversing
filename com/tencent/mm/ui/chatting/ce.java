package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.wcdb.FileUtils;

final class ce extends b {
    private a vCd;

    public ce(int i) {
        super(i);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXW);
        view.setTag(new en(this.knu).p(view, true));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        en enVar = (en) aVar;
        en.a(enVar, auVar, true, i, aVar2, R.g.bdH);
        String str2 = auVar.gxD;
        if (str2 == null || str2.length() == 0) {
            enVar.vyE.setVisibility(8);
            return;
        }
        enVar.vyE.setVisibility(0);
        ah.b(aVar2, enVar.vyE, (Object) dt.TF(str2));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ap.yY();
        if (c.isSDCardAvailable()) {
            int i = ((dt) view.getTag()).position;
            r ls = o.KV().ls(auVar.field_imgPath);
            contextMenu.add(i, 129, 0, view.getContext().getString(R.l.dUt));
            contextMenu.add(i, MMGIFException.D_GIF_ERR_WRONG_RECORD, 0, view.getContext().getString(R.l.eLH));
            if (d.Jt("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
            }
            com.tencent.mm.sdk.b.b ddVar = new dd();
            ddVar.fGW.fGM = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            if (ddVar.fGX.fGu) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
            }
            if (ls != null && ((ls.status == 199 || ls.status == 199) && e.Dq() && !this.vCd.bVJ())) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dUl));
            }
            if (!this.vCd.bVJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUq));
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
