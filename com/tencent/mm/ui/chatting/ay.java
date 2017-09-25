package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ao.e;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class ay extends b {
    private a vCd;

    public ay() {
        super(22);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof n) && ((n) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXM);
        view.setTag(new l(this.knu).dl(view));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        f.a B;
        this.vCd = aVar2;
        aVar2.aI(auVar);
        l lVar = (l) aVar;
        String str2 = auVar.field_content;
        if (aVar2.vBH) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = auVar.field_content.substring(indexOf + 1);
            }
        }
        if (str2 != null) {
            B = f.a.B(str2, auVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null && B.type == 1) {
            com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(B.appId, true);
            String str3 = (aJ == null || aJ.field_appName == null || aJ.field_appName.trim().length() <= 0) ? B.appName : aJ.field_appName;
            if (B.appId == null || B.appId.length() <= 0 || !g.bn(str3)) {
                lVar.lMU.setVisibility(8);
            } else {
                lVar.lMU.setText(aVar2.getString(R.l.dVF, g.a(aVar2.uSU.uTo, aJ, str3)));
                lVar.lMU.setVisibility(0);
                ah.a(aVar2, lVar.lMU, B.appId);
                ah.a(aVar2, lVar.lMU, B.appId);
            }
            if (B.gxD == null || B.gxD.length() <= 0) {
                lVar.vyE.setVisibility(8);
            } else {
                ah.b(aVar2, lVar.vyE, (Object) dt.TF(B.gxD));
                lVar.vyE.setVisibility(0);
            }
            lVar.kxh.setText(B.title);
            lVar.kxh.setClickable(true);
            h.d(lVar.kxh, 1);
        }
        lVar.kxh.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        lVar.kxh.setOnClickListener(aVar2.vBD.vEW);
        ap.yY();
        if (c.isSDCardAvailable()) {
            lVar.kxh.setOnLongClickListener(aVar2.vBD.vEY);
            if (B != null && B.type != 1) {
                lVar.kxh.setOnTouchListener(aVar2.vBD.vFa);
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
        if (d.Jt("favorite")) {
            contextMenu.add(i, 116, 0, this.vCd.getString(R.l.eGa));
        }
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                com.tencent.mm.u.ay.L(auVar.field_msgId);
                ap.yY();
                c.wQ().b(new e(auVar.field_talker, auVar.field_msgSvrId));
                break;
            case 102:
                ((ClipboardManager) aVar.uSU.uTo.getSystemService("clipboard")).setText(aVar.cQ(f.a.ek(aVar.cQ(auVar.field_content, auVar.field_isSend)).title, auVar.field_isSend));
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
        return false;
    }
}
