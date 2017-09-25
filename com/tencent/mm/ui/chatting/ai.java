package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.sd;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;

final class ai extends b {
    private a vCd;

    public ai() {
        super(59);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof e) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXG);
        view.setTag(new e(this.knu).dg(view));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        f.a B;
        this.vCd = aVar2;
        e eVar = (e) aVar;
        String str2 = auVar.field_content;
        if (str2 != null) {
            B = f.a.B(str2, auVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null) {
            TextView textView;
            CharSequence charSequence;
            int i2;
            int a;
            boolean equals = "1001".equals(B.hiV);
            com.tencent.mm.sdk.b.b sdVar = new sd();
            if (!(bg.mA(B.hiW) || equals)) {
                sdVar.fZD.fZF = B.hiW;
                com.tencent.mm.sdk.b.a.urY.m(sdVar);
            }
            ah.a.I(eVar.vBZ, eVar.vym);
            if ("1001".equals(B.hiV)) {
                eVar.vBZ.setBackgroundResource(v.c(B, auVar.field_isSend == 1));
                eVar.vyj.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                eVar.vBZ.setBackgroundResource(v.s(sdVar.fZE.fZG, sdVar.fZE.fZH, auVar.field_isSend == 1));
                eVar.vyj.setTypeface(Typeface.defaultFromStyle(0));
                eVar.vyn = eVar.vyn > eVar.maxSize ? eVar.maxSize : eVar.vyn;
            }
            eVar.vBZ.setPadding(aVar2.uSU.uTo.getResources().getDimensionPixelSize(R.f.aYY), 0, aVar2.uSU.uTo.getResources().getDimensionPixelSize(R.f.aXR), 0);
            CharSequence charSequence2 = auVar.field_isSend == 1 ? B.hiQ : B.hiP;
            if (bg.mA(charSequence2)) {
                charSequence2 = B.description;
                eVar.vyj.setSingleLine(false);
                eVar.vyj.setMaxLines(3);
            } else {
                eVar.vyj.setSingleLine(true);
            }
            eVar.vyj.setText(h.c(aVar2.uSU.uTo, charSequence2, eVar.vyn));
            eVar.vyj.setTextSize(0, (float) eVar.vyn);
            if (equals) {
                textView = eVar.vyk;
                charSequence2 = h.b(aVar2.uSU.uTo, v.b(B, auVar.field_isSend == 1), eVar.vyk.getTextSize());
            } else if (bg.mA(B.hiW)) {
                textView = eVar.vyk;
                charSequence2 = auVar.field_isSend == 1 ? B.hiR : B.hiS;
            } else {
                textView = eVar.vyk;
                charSequence2 = v.a(sdVar.fZE.fZG, sdVar.fZE.fZH, auVar.field_isSend == 1, B);
            }
            textView.setText(charSequence2);
            String str3 = B.hiT;
            if (bg.mA(str3)) {
                charSequence = B.title;
            } else {
                Object obj = str3;
            }
            com.tencent.mm.t.b bVar = (com.tencent.mm.t.b) B.n(com.tencent.mm.t.b.class);
            eVar.vyl.setText(charSequence);
            if (bg.mA(bVar.hhk)) {
                i2 = 0;
            } else {
                n.GW().a("", eVar.vyi);
                i2 = aVar2.getResources().getIdentifier(bVar.hhk, "drawable", ab.getPackageName());
            }
            w.v("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", Integer.valueOf(i2));
            if (i2 > 0) {
                w.v("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
                eVar.vyi.setImageResource(i2);
            }
            if ("1001".equals(B.hiV)) {
                a = v.a(B, auVar.field_isSend == 1);
            } else {
                a = v.t(sdVar.fZE.fZG, sdVar.fZE.fZH, auVar.field_isSend == 1);
            }
            if (a > 0) {
                w.v("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
                eVar.vyi.setImageResource(a);
            } else if (i2 <= 0) {
                w.v("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localResId");
                str3 = B.hiO;
                if (bg.mA(str3)) {
                    str3 = B.thumburl;
                }
                eVar.vyi.setImageBitmap(null);
                if (!bg.mA(str3)) {
                    c.a aVar3 = new c.a();
                    ap.yY();
                    aVar3.hIO = com.tencent.mm.u.c.xc();
                    aVar3.hIL = true;
                    aVar3.hJh = true;
                    n.GW().a(str3, eVar.vyi, aVar3.Hg());
                }
            }
        }
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        aVar.vBZ.setTag(new dt(auVar, this.vCd.vxp, i, null, 0, (byte) 0));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((dt) view.getTag()).position, 100, 0, this.vCd.getString(R.l.dUp));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                ay.L(auVar.field_msgId);
                return true;
            default:
                return false;
        }
    }

    public final boolean a(View view, a aVar, au auVar) {
        f.a B;
        String str = auVar.field_content;
        if (str != null) {
            B = f.a.B(str, auVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null) {
            String str2 = bg.mA(B.hiN) ? B.url : B.hiN;
            w.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", Boolean.valueOf(bg.mA(str2)), Boolean.valueOf(bg.mA(B.hje)));
            Intent intent;
            Intent intent2;
            if (bg.mA(B.hiW)) {
                if (!bg.mA(B.hje)) {
                    w.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", B.hje, Integer.valueOf(B.hjf), B.fOu);
                    intent = new Intent();
                    intent.putExtra("bill_no", B.hje);
                    intent.putExtra("launcher_user_name", B.fOu);
                    intent.putExtra("enter_scene", 1);
                    intent.putExtra("chatroom", aVar.bUg());
                    d.b(aVar.uSU.uTo, "aa", ".ui.PaylistAAUI", intent);
                    if (v.e(B).tbs == 2) {
                        g.oUh.i(13721, Integer.valueOf(4), Integer.valueOf(2));
                    } else {
                        g.oUh.i(13721, Integer.valueOf(4), Integer.valueOf(3));
                    }
                } else if (!bg.mA(str2)) {
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    d.b(aVar.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2);
                }
            } else if (B.hiW.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_way", 1);
                intent.putExtra("key_native_url", B.hiW);
                intent.putExtra("key_username", aVar.bUg());
                intent.putExtra("key_static_from_scene", 100002);
                d.b(aVar.uSU.uTo, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
            } else if (B.hiW.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                int i;
                Intent intent3 = new Intent();
                String str3 = "key_way";
                if (aVar.vBH) {
                    i = 0;
                } else {
                    i = 1;
                }
                intent3.putExtra(str3, i);
                intent3.putExtra("key_native_url", B.hiW);
                intent3.putExtra("key_username", aVar.bUg());
                d.b(aVar.uSU.uTo, "luckymoney", ".ui.En_fba4b94f", intent3);
            } else {
                w.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + B.hiW + ", go webview:" + str2);
                if (!bg.mA(str2)) {
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    d.b(aVar.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2);
                }
            }
        }
        return true;
    }
}
