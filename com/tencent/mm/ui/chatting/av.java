package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class av extends c {
    private a vCd;

    public av() {
        super(49);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof j) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYp);
        view.setTag(new j(this.knu).dj(view));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        f.a B;
        j jVar = (j) aVar;
        this.vCd = aVar2;
        String str2 = auVar.field_content;
        if (str2 != null) {
            B = f.a.B(str2, auVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null) {
            jVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
            jVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
            if (this.sXW) {
                jVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
                jVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
            }
            jVar.vyG.setText(B.title);
        }
        if (l.a.sBy == null || !l.a.sBy.zs(aVar2.bUg())) {
            jVar.vyG.setTextColor(-8750470);
            jVar.vBZ.setClickable(false);
            jVar.vBZ.setEnabled(false);
            return;
        }
        jVar.vyG.setTextColor(aVar2.bPj().getResources().getColor(R.e.aVo));
        jVar.vBZ.setClickable(true);
        jVar.vBZ.setEnabled(true);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        com.tencent.mm.pluginsdk.model.app.l.Mg(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
        f.a ek = f.a.ek(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
        com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(ek.appId, false);
        if (d.Jt("favorite") && (aJ == null || !aJ.bCU())) {
            switch (ek.type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 13:
                case 20:
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
                    break;
            }
        }
        if (!auVar.bLX() && auVar.bMj() && ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
        }
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                f.a aVar2 = null;
                if (str != null) {
                    aVar2 = f.a.ek(str);
                }
                if (aVar2 != null) {
                    com.tencent.mm.pluginsdk.model.app.l.ed(auVar.field_msgId);
                    ay.L(auVar.field_msgId);
                    com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(aVar2.appId, false);
                    if (aJ != null && aJ.bCU()) {
                        ah.a(aVar, aVar2, auVar, aJ);
                        break;
                    }
                }
                break;
            case 111:
                Intent intent = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.cQ(auVar.field_content, auVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        aVar.bUg();
        aVar.aX("fromMessage", true);
        return true;
    }
}
