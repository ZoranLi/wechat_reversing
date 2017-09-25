package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import java.lang.ref.WeakReference;

final class ar extends c {
    private a vCd;

    public ar() {
        super(23);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYn);
        view.setTag(new h(this.knu).p(view, false));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        aVar2.aI(auVar);
        aVar = (h) aVar;
        if (auVar != null) {
            com.tencent.mm.storage.a.c cVar;
            f.a aVar3;
            com.tencent.mm.storage.a.c cVar2;
            String str2 = auVar.field_content;
            aj RD = aj.RD(auVar.field_content);
            if (RD.iai) {
                cVar = null;
                aVar3 = null;
            } else {
                if (str2 != null) {
                    aVar3 = f.a.B(str2, auVar.field_reserved);
                } else {
                    aVar3 = null;
                }
                cVar = aVar3 != null ? ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(aVar3.hhs) : null;
            }
            if (RD.fFW == null || RD.fFW.equals("-1") || cVar != null) {
                cVar2 = cVar;
            } else {
                cVar2 = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(RD.fFW);
            }
            if (cVar2 == null || !cVar2.bNr()) {
                long j;
                String v = n.GS().v(auVar.field_imgPath, true);
                Bitmap jH = n.GW().jH(v);
                if (jH == null || jH.isRecycled()) {
                    jH = d.decodeFile(v, null);
                    n.GW().h(v, jH);
                }
                aVar.oDJ.setVisibility(8);
                aVar.vyA.setVisibility(0);
                aVar.vyz.setVisibility(8);
                TextView textView = aVar.vyB;
                if (aVar3 == null) {
                    j = 0;
                } else {
                    j = (long) aVar3.hhq;
                }
                textView.setText(u.ay(j));
                aVar.vyB.setVisibility(0);
                aVar.vyA.setImageResource(R.g.beK);
                if (jH == null || jH.isRecycled()) {
                    jH = d.t(this.vCd.getResources().getDrawable(R.g.bch));
                }
                aVar.vyw.setImageBitmap(jH);
                if (!(aVar3 == null || bg.mA(aVar3.hhs))) {
                    h.vyC.put(aVar3.hhs, new WeakReference(aVar));
                }
            } else {
                int i2;
                aVar.vyw.a(cVar2, auVar.field_msgId);
                RTChattingEmojiView rTChattingEmojiView = aVar.vyw;
                if (rTChattingEmojiView.sRI != null) {
                    rTChattingEmojiView.sRI.resume();
                }
                boolean z = auVar.field_status != 1;
                ProgressBar progressBar = aVar.oDJ;
                if (z) {
                    i2 = 4;
                } else {
                    i2 = 0;
                }
                progressBar.setVisibility(i2);
                ah.v(cVar2);
            }
            if (ah.bUq()) {
                if (auVar != null && auVar.field_status == 2 && ah.a(aVar2.vBD, auVar.field_msgId)) {
                    if (aVar.vyy != null) {
                        aVar.vyy.setVisibility(0);
                    }
                } else if (aVar.vyy != null) {
                    aVar.vyy.setVisibility(8);
                }
            }
            aVar.vyw.setTag(new dt(auVar, aVar2.vxp, i, aVar2.vBD.hrM, 0, (byte) 0));
            aVar.vyw.setOnClickListener(aVar2.vBD.vEW);
            aVar.vyw.setOnLongClickListener(aVar2.vBD.vEY);
            aVar.vyw.setOnTouchListener(aVar2.vBD.vFa);
            ah.a(i, aVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
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
                com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(aVar.hhs);
                if (ub != null) {
                    if (!(ub.field_catalog == com.tencent.mm.storage.a.c.uKY || ub.bNt())) {
                        contextMenu.add(i, 104, 0, view.getContext().getString(R.l.dUy));
                    }
                    g.oUh.i(12789, Integer.valueOf(0), ub.EP(), Integer.valueOf(0), ub.field_designerID, ub.field_groupId, "", "", "", "", ub.field_activityid);
                    boolean bNr = ub.bNr();
                    if (ub.field_catalog == com.tencent.mm.storage.a.c.uKY || bg.mA(ub.field_groupId) || (!bg.mA(ub.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(ub.field_groupId))) {
                        if (bNr) {
                            contextMenu.add(i, 113, 0, R.l.eLH);
                        } else {
                            w.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                } else {
                    w.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", aVar.hhs);
                }
            }
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dVm));
            }
            if (!auVar.bLX() && auVar.bMo() && ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
            }
            if (!this.vCd.bVJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUn));
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
