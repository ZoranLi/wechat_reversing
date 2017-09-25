package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class bi extends c {
    private a vCd;
    private String vDb;

    public bi() {
        super(13);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYt);
        view.setTag(new x(this.knu).p(view, false));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        String str2;
        Object obj;
        String str3;
        boolean eW;
        this.vCd = aVar2;
        aVar = (x) aVar;
        ap.yY();
        au.a Av = com.tencent.mm.u.c.wT().Av(auVar.field_content);
        if (Av.rUK == null || Av.rUK.length() <= 0) {
            w.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
        }
        this.vDb = Av.rUK;
        w.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", Boolean.valueOf(o.eV(this.vDb)), this.vDb);
        ah.a.I(aVar.vBZ, aVar.vym);
        if (o.eW(Av.rWg)) {
            aVar.vAg.setText(R.l.dTf);
            aVar.vAh.setVisibility(8);
            if (d.eo(16)) {
                aVar.vAf.setBackground(null);
            } else {
                aVar.vAf.setBackgroundDrawable(null);
            }
            ah.p(aVar.vAf, this.vDb);
        } else {
            aVar.vAg.setText(R.l.dUS);
            aVar.vAf.setBackgroundResource(R.g.bes);
            ah.o(aVar.vAf, this.vDb);
        }
        aVar.jWd.setText(h.b(aVar2.uSU.uTo, Av.fFa, aVar.jWd.getTextSize()));
        Object obj2 = null;
        CharSequence charSequence = Av.gtR;
        if (!u.mA(this.vDb)) {
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(this.vDb);
            if (Rc != null && com.tencent.mm.j.a.ez(Rc.field_type)) {
                x.bLd();
                if (obj2 == null && u.mA(charSequence)) {
                    str2 = this.vDb;
                    obj = (u.mA(str2) || x.aO(str2, true) || o.eT(str2)) ? 1 : null;
                    str3 = str2;
                    obj2 = obj;
                    charSequence = str3;
                }
                eW = o.eW(Av.rWg);
                if (obj2 != null || eW) {
                    charSequence = "";
                }
                if (u.mA(charSequence)) {
                    aVar.vAh.setVisibility(0);
                    aVar.vAh.setText(charSequence);
                } else {
                    aVar.vAh.setVisibility(8);
                }
                aVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
                aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
                aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
                aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
                if (ah.bUq()) {
                    if (aVar.oDJ != null) {
                        aVar.oDJ.setVisibility(8);
                    }
                    if (auVar.field_status == 2 || !ah.a(aVar2.vBD, auVar.field_msgId)) {
                        if (aVar.vyy != null) {
                            aVar.vyy.setVisibility(8);
                        }
                    } else if (aVar.vyy != null) {
                        aVar.vyy.setVisibility(0);
                    }
                } else if (aVar.oDJ != null) {
                    aVar.oDJ.setVisibility(0);
                    if (auVar.field_status >= 2) {
                        aVar.oDJ.setVisibility(8);
                    }
                }
                ah.a(i, aVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
            }
        }
        obj2 = 1;
        str2 = this.vDb;
        if (!u.mA(str2)) {
        }
        str3 = str2;
        obj2 = obj;
        charSequence = str3;
        eW = o.eW(Av.rWg);
        charSequence = "";
        if (u.mA(charSequence)) {
            aVar.vAh.setVisibility(8);
        } else {
            aVar.vAh.setVisibility(0);
            aVar.vAh.setText(charSequence);
        }
        aVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        if (ah.bUq()) {
            if (aVar.oDJ != null) {
                aVar.oDJ.setVisibility(8);
            }
            if (auVar.field_status == 2) {
            }
            if (aVar.vyy != null) {
                aVar.vyy.setVisibility(8);
            }
        } else if (aVar.oDJ != null) {
            aVar.oDJ.setVisibility(0);
            if (auVar.field_status >= 2) {
                aVar.oDJ.setVisibility(8);
            }
        }
        ah.a(i, aVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        ap.yY();
        au.a Av = com.tencent.mm.u.c.wT().Av(auVar.field_content);
        if (Av.rUK == null || Av.rUK.length() <= 0) {
            w.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
        }
        this.vDb = Av.rUK;
        if (o.eW(Av.rWg)) {
            contextMenu.add(i, 118, 0, view.getContext().getString(R.l.eLH));
        }
        if (!auVar.bLX() && ((auVar.field_status == 2 || auVar.gxJ == 1) && auVar.bMi() && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
        }
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 118:
                Intent intent = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.cQ(auVar.field_content, auVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 8);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }
}
