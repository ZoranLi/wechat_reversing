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
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.wcdb.FileUtils;

final class cf extends c {
    private a vCd;

    public cf(int i) {
        super(i);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYz);
        view.setTag(new en(this.knu).p(view, false));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        en enVar = (en) aVar;
        en.a(enVar, auVar, false, i, aVar2, R.g.bdJ);
        if (ah.bUq()) {
            r lH = t.lH(auVar.field_imgPath);
            if (lH != null && lH.status == 199 && ah.a(aVar2.vBD, auVar.field_msgId)) {
                if (enVar.vyy != null) {
                    enVar.vyy.setVisibility(0);
                }
            } else if (enVar.vyy != null) {
                enVar.vyy.setVisibility(8);
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            int i = ((dt) view.getTag()).position;
            r ls = o.KV().ls(auVar.field_imgPath);
            contextMenu.add(i, 129, 0, view.getContext().getString(R.l.dUt));
            if (ls != null) {
                int i2 = ls.status;
                if (!(104 == i2 || 103 == i2 || MMGIFException.D_GIF_ERR_NO_IMAG_DSCR == i2 || MMGIFException.D_GIF_ERR_NO_COLOR_MAP == i2)) {
                    contextMenu.add(i, MMGIFException.D_GIF_ERR_WRONG_RECORD, 0, view.getContext().getString(R.l.eLH));
                }
            }
            if (ls != null && (ls.status == 199 || ls.status == 199)) {
                if (d.Jt("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
                }
                b ddVar = new dd();
                ddVar.fGW.fGM = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.urY.m(ddVar);
                if (ddVar.fGX.fGu) {
                    contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
                }
                if (!auVar.bLX() && ((auVar.bMl() || auVar.bMm()) && ah.ao(auVar) && ((ls.status == 199 || ls.status == 199 || auVar.gxJ == 1) && ah.Tn(auVar.field_talker)))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
                }
                if (e.Dq() && !this.vCd.bVJ()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dUl));
                }
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
