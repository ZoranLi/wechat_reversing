package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

final class bh extends b {
    private a vCd;
    private String vDb;
    private String vDc;

    public bh() {
        super(12);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXO);
        view.setTag(new x(this.knu).p(view, true));
        return view;
    }

    protected final boolean a(a aVar) {
        return aVar.vxp;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        String gj;
        int i2;
        this.vCd = aVar2;
        x xVar = (x) aVar;
        if (aVar2.vxp) {
            gj = ay.gj(auVar.field_content);
        } else {
            gj = auVar.field_content;
        }
        ap.yY();
        au.a Av = c.wT().Av(gj);
        if (Av.rUK == null || Av.rUK.length() <= 0) {
            w.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.vDb = Av.rUK;
        this.vDc = "";
        if (!u.mA(gj)) {
            Map q = com.tencent.mm.sdk.platformtools.bh.q(gj, "msg");
            if (q.containsKey(".msg.$wechatid")) {
                this.vDc = (String) q.get(".msg.$wechatid");
            }
        }
        com.tencent.mm.x.b.u(this.vDb, Av.uJW);
        ah.a.I(xVar.vBZ, xVar.vym);
        if (o.eW(Av.rWg)) {
            xVar.vAg.setText(R.l.dTf);
            xVar.vAh.setVisibility(8);
            if (d.eo(16)) {
                xVar.vAf.setBackground(null);
            } else {
                xVar.vAf.setBackgroundDrawable(null);
            }
            ah.p(xVar.vAf, this.vDb);
        } else {
            xVar.vAg.setText(R.l.dUS);
            xVar.vAf.setBackgroundResource(R.g.bes);
            ah.o(xVar.vAf, this.vDb);
        }
        String str2 = this.vDc;
        if (u.mA(str2) || x.aO(str2, true) || o.eT(str2)) {
            i2 = true;
        } else {
            i2 = 0;
        }
        boolean eW = o.eW(Av.rWg);
        if (i2 != 0 || eW) {
            CharSequence charSequence = "";
        } else {
            Object obj = str2;
        }
        if (u.mA(charSequence)) {
            xVar.vAh.setVisibility(8);
        } else {
            xVar.vAh.setVisibility(0);
            xVar.vAh.setText(charSequence);
        }
        xVar.jWd.setText(h.c(aVar2.uSU.uTo, Av.fFa, (int) xVar.jWd.getTextSize()));
        xVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, str, 0, (byte) 0));
        xVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        xVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        xVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        ap.yY();
        au.a Av = c.wT().Av(auVar.field_content);
        if (Av.rUK == null || Av.rUK.length() <= 0) {
            w.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.vDb = Av.rUK;
        if (o.eW(Av.rWg)) {
            contextMenu.add(i, 118, 0, view.getContext().getString(R.l.eLH));
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
