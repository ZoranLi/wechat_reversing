package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;

final class bm extends b {
    private a vCd;

    public bm() {
        super(14);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXQ);
        view.setTag(new do(this.knu).p(view, true));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(auVar.field_imgPath);
        do doVar = (do) aVar;
        if (ub != null) {
            aj RD = aj.RD(auVar.field_content);
            doVar.vyw.a(ub, auVar.field_msgId, RD);
            if (ub.bCU() && !RD.iai) {
                RD.iai = true;
                auVar.setContent(RD.bLQ());
                ap.yY();
                com.tencent.mm.u.c.wT().a(auVar.field_msgId, auVar);
            }
        }
        String str2 = "";
        if (ub == null || !ub.bCU()) {
            str2 = bg.ap(((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ue(ub.EP()), "");
        } else if (ub.field_name.startsWith("jsb_j")) {
            str2 = this.vCd.uSU.uTo.getString(R.l.ecH);
        } else if (ub.field_name.startsWith("jsb_s")) {
            str2 = this.vCd.uSU.uTo.getString(R.l.ecI);
        } else if (ub.field_name.startsWith("jsb_b")) {
            str2 = this.vCd.uSU.uTo.getString(R.l.ecG);
        } else if (ub.field_name.startsWith("dice")) {
            str2 = ub.field_name.replace("dice_", "").replace(".png", "");
        }
        doVar.vyw.setContentDescription(this.vCd.uSU.uTo.getString(R.l.edO) + str2);
        doVar.vyw.setTag(new dt(auVar, aVar2.vxp, i, str, 0, (byte) 0));
        doVar.vyw.setOnClickListener(aVar2.vBD.vEW);
        doVar.vyw.setOnLongClickListener(aVar2.vBD.vEY);
        doVar.vyw.setOnTouchListener(aVar2.vBD.vFa);
    }

    protected final boolean a(a aVar) {
        return aVar.vxp;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.bMn()) {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                int i = ((dt) view.getTag()).position;
                c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(auVar.field_imgPath);
                if (ub == null) {
                    String str;
                    String str2 = "MicroMsg.emoji.ChattingItemEmojiFrom";
                    String str3 = "emoji is null. md5:%s";
                    Object[] objArr = new Object[1];
                    if (auVar == null) {
                        str = "";
                    } else {
                        str = auVar.field_imgPath;
                    }
                    objArr[0] = str;
                    w.w(str2, str3, objArr);
                } else {
                    boolean bNr = ub.bNr();
                    if (!(ub.field_catalog == c.uKY || ub.bNt() || ub.bNu())) {
                        if (bNr) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(R.l.dUy));
                        } else {
                            w.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (ub.field_catalog == c.uKY || bg.mA(ub.field_groupId) || (!bg.mA(ub.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(ub.field_groupId))) {
                        if (bNr) {
                            contextMenu.add(i, 113, 0, R.l.eLH);
                        } else {
                            w.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (!(bg.mA(ub.field_groupId) || ub.bCU() || ub.bNu())) {
                        contextMenu.add(i, 127, 0, R.l.dUA);
                    }
                    if (!this.vCd.bVJ()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUn));
                    }
                    g.oUh.i(12789, Integer.valueOf(0), ub.EP(), Integer.valueOf(0), ub.field_designerID, ub.field_groupId, "", "", "", "", ub.field_activityid);
                }
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
