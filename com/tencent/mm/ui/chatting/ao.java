package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class ao extends b {
    private a vCd;

    public ao() {
        super(61);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof g) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXP);
        view.setTag(new g(this.knu).o(view, true));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        f.a B;
        this.vCd = aVar2;
        g gVar = (g) aVar;
        String str2 = auVar.field_content;
        if (str2 != null) {
            B = f.a.B(str2, auVar.field_reserved);
        } else {
            B = null;
        }
        if (gVar != null) {
            gVar.a(aVar2.uSU.uTo, B, auVar.field_imgPath, this.sXW);
        }
        dt dtVar = new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0);
        if (aVar.vBZ != null) {
            aVar.vBZ.setTag(dtVar);
            aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
            if (this.sXW) {
                aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
                aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        String str = auVar.field_content;
        if (str == null) {
            return true;
        }
        f.a ek = f.a.ek(this.vCd.cQ(str, auVar.field_isSend));
        if (ek == null) {
            return true;
        }
        switch (ek.type) {
            case 16:
                if (ek.hiA == 5 || ek.hiA == 6 || ek.hiA == 2) {
                    if (ek.hiA != 2) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
                    return false;
                }
            case 34:
                contextMenu.clear();
                contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
                return false;
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        f.a aVar2;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                String str2 = auVar.field_content;
                aVar2 = null;
                if (str2 != null) {
                    aVar2 = f.a.ek(str2);
                }
                if (aVar2 != null) {
                    l.ed(auVar.field_msgId);
                }
                ay.L(auVar.field_msgId);
                break;
            case 103:
                str = auVar.field_content;
                if (str != null) {
                    aVar2 = f.a.ek(str);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 16:
                                com.tencent.mm.sdk.b.b hqVar = new hq();
                                hqVar.fNf.fNg = aVar2.fNg;
                                hqVar.fNf.fEU = auVar.field_msgId;
                                hqVar.fNf.fNh = auVar.field_talker;
                                com.tencent.mm.sdk.b.a.urY.m(hqVar);
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
            case 111:
                str = aVar.cQ(auVar.field_content, auVar.field_isSend);
                Intent intent = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", str);
                aVar2 = f.a.ek(str);
                if (aVar2 == null || 16 != aVar2.type) {
                    intent.putExtra("Retr_Msg_Type", 2);
                } else {
                    intent.putExtra("Retr_Msg_Type", 14);
                }
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        String str = auVar.field_content;
        if (str == null) {
            return false;
        }
        f.a ek = f.a.ek(str);
        if (ek == null) {
            return false;
        }
        switch (ek.type) {
            case 16:
                if (bg.mA(ek.fNg)) {
                    return false;
                }
                Intent intent = new Intent();
                intent.setFlags(65536);
                intent.putExtra("key_card_app_msg", ek.fNg);
                intent.putExtra("key_from_scene", ek.hiA);
                d.b(aVar.uSU.uTo, "card", ".ui.CardDetailUI", intent);
                return true;
            case 34:
                h b = h.b(ek);
                if (1 < b.ver) {
                    String str2;
                    int i;
                    String s = p.s(ek.hhp, "message");
                    PackageInfo az = ah.az(aVar.uSU.uTo, ek.appId);
                    if (az == null) {
                        str2 = null;
                    } else {
                        str2 = az.versionName;
                    }
                    if (az == null) {
                        i = 0;
                    } else {
                        i = az.versionCode;
                    }
                    a(aVar, s, s, str2, i, ek.appId, true, auVar.field_msgId, auVar.field_msgSvrId, auVar);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_from_user_name", a(aVar, auVar));
                    intent2.putExtra("key_biz_uin", b.hiC);
                    intent2.putExtra("key_order_id", b.hiD);
                    if (!(auVar.field_talker == null || auVar.field_talker.equals("") || !auVar.field_talker.endsWith("@chatroom"))) {
                        intent2.putExtra("key_chatroom_name", auVar.field_talker);
                    }
                    d.b(aVar.uSU.uTo, "card", ".ui.CardGiftAcceptUI", intent2);
                }
                return true;
            default:
                return false;
        }
    }
}
