package com.tencent.mm.ui.chatting;

import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;

final class bn extends c {
    private a vCd;

    public bn() {
        super(15);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYv);
        view.setTag(new do(this.knu).p(view, false));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        aVar = (do) aVar;
        com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(auVar.field_imgPath);
        if (ub != null) {
            aj RD = aj.RD(auVar.field_content);
            aVar.vyw.a(ub, auVar.field_msgId, RD);
            if (aVar.vIg != null) {
                if (RD.uJp) {
                    aVar.vIg.setVisibility(0);
                    TextView textView = (TextView) aVar.mil.findViewById(R.h.bBn).findViewById(R.h.bAt);
                    TextView textView2 = textView;
                    textView2.setText(Html.fromHtml(aVar2.getString(R.l.eco)));
                    ImageView imageView = (ImageView) aVar.mil.findViewById(R.h.bBn).findViewById(R.h.bAs);
                    textView2 = textView;
                    textView2.setTag(new dt(auVar, false, i, aVar2.vBD.hrM, 8, false, "", "", "", "", ub.field_groupId, "", true, false));
                    textView.setOnClickListener(aVar2.vBD.vEW);
                    if (((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().alC()) {
                        imageView.setVisibility(0);
                        ImageView imageView2 = imageView;
                        imageView2.setTag(new dt(auVar, aVar2.vxp, i, aVar2.vBD.hrM, 11, (byte) 0));
                        imageView.setOnClickListener(aVar2.vBD.vEW);
                    } else {
                        imageView.setVisibility(8);
                    }
                } else {
                    aVar.vIg.setVisibility(8);
                }
            }
            if (ub.bCU() && !RD.iai) {
                RD.iai = true;
                auVar.setContent(RD.bLQ());
                ap.yY();
                auVar.dv(com.tencent.mm.u.c.wT().cA(auVar.field_msgId).field_status);
                ap.yY();
                com.tencent.mm.u.c.wT().N(auVar);
            }
            if (ah.bUq()) {
                aVar.oDJ.setVisibility(8);
                if (auVar != null && auVar.field_status == 2 && ah.a(aVar2.vBD, auVar.field_msgId)) {
                    if (aVar.vyy != null) {
                        aVar.vyy.setVisibility(0);
                    }
                } else if (aVar.vyy != null) {
                    aVar.vyy.setVisibility(8);
                }
            } else {
                if (aVar.vyy != null) {
                    aVar.vyy.setVisibility(8);
                }
                if (aVar.oDJ != null) {
                    aVar.oDJ.setVisibility(0);
                    if (auVar.field_status >= 2) {
                        aVar.oDJ.setVisibility(8);
                    }
                }
            }
        }
        String str2 = "";
        if (!ub.bCU()) {
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
        aVar.vyw.setContentDescription(this.vCd.uSU.uTo.getString(R.l.edO) + str2);
        aVar.vyw.setTag(new dt(auVar, aVar2.vxp, i, aVar2.vBD.hrM, 0, (byte) 0));
        aVar.vyw.setOnClickListener(aVar2.vBD.vEW);
        aVar.vyw.setOnLongClickListener(aVar2.vBD.vEY);
        aVar.vyw.setOnTouchListener(aVar2.vBD.vFa);
        ah.a(i, aVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.bMn()) {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                int i = ((dt) view.getTag()).position;
                com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(auVar.field_imgPath);
                if (ub == null) {
                    String str;
                    String str2 = "MicroMsg.emoji.ChattingItemEmojiTo";
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
                    if (!(ub.field_catalog == com.tencent.mm.storage.a.c.uKY || ub.bNt() || ub.bNu())) {
                        if (bNr) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(R.l.dUy));
                        } else {
                            w.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (ub.field_catalog == com.tencent.mm.storage.a.c.uKY || bg.mA(ub.field_groupId) || (!bg.mA(ub.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(ub.field_groupId))) {
                        if (bNr) {
                            contextMenu.add(i, 113, 0, R.l.eLH);
                        } else {
                            w.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (!(bg.mA(ub.field_groupId) || ub.bCU() || ub.bNu())) {
                        contextMenu.add(i, 127, 0, R.l.dUA);
                    }
                    if (!auVar.bLX() && auVar.bMn() && ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
                    }
                    if (!this.vCd.bVJ()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUn));
                    }
                    if (auVar.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dVm));
                    }
                    g.oUh.i(12789, Integer.valueOf(0), ub.EP(), Integer.valueOf(0), ub.field_designerID, ub.field_groupId, "", "", "", "", "", ub.field_activityid);
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
