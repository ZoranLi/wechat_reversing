package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import java.lang.ref.WeakReference;

final class aq extends b {
    private a vCd;

    public aq() {
        super(22);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXI);
        view.setTag(new h(this.knu).p(view, true));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        f.a B;
        c cVar;
        this.vCd = aVar2;
        aVar2.aI(auVar);
        h hVar = (h) aVar;
        String str2 = auVar.field_content;
        if (str2 != null) {
            B = f.a.B(str2, auVar.field_reserved);
        } else {
            B = null;
        }
        if (B == null || B.hhs == null) {
            cVar = null;
        } else {
            cVar = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(B.hhs);
        }
        if (cVar == null || !cVar.bNr()) {
            Bitmap t;
            String v = n.GS().v(auVar.field_imgPath, true);
            Bitmap jH = n.GW().jH(v);
            if (jH == null || jH.isRecycled()) {
                jH = d.decodeFile(v, null);
                n.GW().h(v, jH);
            }
            if (cVar == null) {
                hVar.vyA.setVisibility(0);
                hVar.vyz.setVisibility(8);
                hVar.vyB.setText(u.ay(B == null ? 0 : (long) B.hhq));
                hVar.vyB.setVisibility(0);
                hVar.vyA.setImageResource(R.g.beK);
            } else {
                hVar.vyz.setVisibility(0);
                hVar.vyB.setVisibility(8);
                hVar.vyA.setVisibility(8);
                hVar.vyz.setProgress(0);
                hVar.vyB.setVisibility(8);
            }
            if (!(B == null || bg.mA(B.hhs))) {
                h.vyC.put(B.hhs, new WeakReference(hVar));
            }
            if (jH == null || jH.isRecycled()) {
                t = d.t(this.vCd.getResources().getDrawable(R.g.bch));
            } else {
                t = jH;
            }
            hVar.vyw.setImageBitmap(t);
        } else {
            hVar.vyw.a(cVar, auVar.field_msgId);
            hVar.vyA.setVisibility(8);
            hVar.vyz.setVisibility(8);
            hVar.vyB.setVisibility(8);
            hVar.vyA.setVisibility(8);
            if (!(B == null || bg.mA(B.hhs))) {
                h.vyC.remove(B.hhs);
            }
            ah.v(cVar);
        }
        hVar.vyw.setTag(new dt(auVar, aVar2.vxp, i, str, 0, (byte) 0));
        hVar.vyw.setOnClickListener(aVar2.vBD.vEW);
        hVar.vyw.setOnLongClickListener(aVar2.vBD.vEY);
        hVar.vyw.setOnTouchListener(aVar2.vBD.vFa);
        hVar.vyA.setOnClickListener(aVar2.vBD.vEW);
        hVar.vyA.setOnClickListener(aVar2.vBD.vEW);
        hVar.vyA.setOnLongClickListener(aVar2.vBD.vEY);
        hVar.vyA.setTag(hVar.vyw.getTag());
    }

    protected final boolean a(a aVar) {
        return aVar.vxp;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        f.a aVar;
        int i = ((dt) view.getTag()).position;
        aj RD = aj.RD(auVar.field_content);
        f.a B = f.a.B(auVar.field_content, auVar.field_reserved);
        if (B == null) {
            B = new f.a();
            B.hhs = RD.fFW;
            aVar = B;
        } else {
            aVar = B;
        }
        if (!(u.mA(aVar.hhs) || aVar.hhs.equals("-1"))) {
            c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(aVar.hhs);
            if (ub != null) {
                if (!(ub.field_catalog == c.uKY || ub.bNt())) {
                    contextMenu.add(i, 104, 0, view.getContext().getString(R.l.dUy));
                }
                if (ub != null) {
                    g.oUh.i(12789, Integer.valueOf(0), ub.EP(), Integer.valueOf(0), ub.field_designerID, ub.field_groupId, "", "", "", "", ub.field_activityid);
                }
                boolean bNr = ub.bNr();
                if (ub.field_catalog == c.uKY || bg.mA(ub.field_groupId) || (!bg.mA(ub.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(ub.field_groupId))) {
                    if (bNr) {
                        contextMenu.add(i, 113, 0, R.l.eLH);
                    } else {
                        w.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
                    }
                }
            }
        }
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUn));
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
