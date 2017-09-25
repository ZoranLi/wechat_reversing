package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class au extends b {
    private a vCd;

    public au() {
        super(48);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof j) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXK);
        view.setTag(new j(this.knu).dj(view));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, com.tencent.mm.storage.au auVar, String str) {
        String substring;
        String str2;
        String str3;
        Object[] objArr;
        f.a aVar3;
        j jVar = (j) aVar;
        this.vCd = aVar2;
        f ec = an.bDk().ec(auVar.field_msgId);
        String str4 = auVar.field_content;
        if (aVar2.vBH) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                substring = auVar.field_content.substring(indexOf + 1);
                if (ec != null || substring == null) {
                    str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
                    str3 = "amessage:%b, %s, %s";
                    objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(ec != null);
                    objArr[1] = substring;
                    objArr[2] = Long.valueOf(auVar.field_msgId);
                    objArr[3] = str;
                    w.e(str2, str3, objArr);
                    aVar3 = null;
                } else {
                    aVar3 = f.a.B(substring, auVar.field_reserved);
                }
                if (aVar3 != null) {
                    jVar.vyG.setText(aVar3.title);
                    jVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
                    jVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
                    if (this.sXW) {
                        jVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
                        jVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
                    }
                }
                if (l.a.sBy == null && l.a.sBy.zs(aVar2.bUg())) {
                    jVar.vyG.setTextColor(aVar2.bPj().getResources().getColor(R.e.aVo));
                    jVar.vBZ.setClickable(true);
                    jVar.vBZ.setEnabled(true);
                    return;
                }
                jVar.vyG.setTextColor(-8750470);
                jVar.vBZ.setClickable(false);
                jVar.vBZ.setEnabled(false);
            }
        }
        substring = str4;
        if (ec != null) {
        }
        str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
        str3 = "amessage:%b, %s, %s";
        objArr = new Object[4];
        if (ec != null) {
        }
        objArr[0] = Boolean.valueOf(ec != null);
        objArr[1] = substring;
        objArr[2] = Long.valueOf(auVar.field_msgId);
        objArr[3] = str;
        w.e(str2, str3, objArr);
        aVar3 = null;
        if (aVar3 != null) {
            jVar.vyG.setText(aVar3.title);
            jVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
            jVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
            if (this.sXW) {
                jVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
                jVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
            }
        }
        if (l.a.sBy == null) {
        }
        jVar.vyG.setTextColor(-8750470);
        jVar.vBZ.setClickable(false);
        jVar.vBZ.setEnabled(false);
    }

    public final boolean a(ContextMenu contextMenu, View view, com.tencent.mm.storage.au auVar) {
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
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, com.tencent.mm.storage.au auVar) {
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

    public final boolean a(View view, a aVar, com.tencent.mm.storage.au auVar) {
        aVar.bUg();
        aVar.aX("fromMessage", true);
        return true;
    }
}
