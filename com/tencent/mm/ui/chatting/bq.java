package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.NoMeasuredTextView;

public final class bq extends ah {

    final class a extends com.tencent.mm.ui.chatting.ah.a {
        protected ImageView hBi;
        protected NoMeasuredTextView vDQ;
        final /* synthetic */ bq vDR;

        public a(bq bqVar, int i) {
            this.vDR = bqVar;
            super(i);
        }

        public final a dq(View view) {
            super.dn(view);
            this.mfD = (CheckBox) view.findViewById(R.h.bAd);
            this.hBi = (ImageView) view.findViewById(R.h.cbj);
            this.vDQ = (NoMeasuredTextView) view.findViewById(R.h.cIG);
            return this;
        }
    }

    public bq() {
        super(57);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof a) && ((a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYb);
        view.setTag(new a(this, this.knu).dq(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.ah.a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar, String str) {
        com.tencent.mm.t.f.a aVar3;
        a aVar4 = (a) aVar;
        f ec = an.bDk().ec(auVar.field_msgId);
        String str2 = auVar.field_content;
        if (ec == null || str2 == null) {
            String str3 = "MicrMsg.ChattingItemHardDeviceMsgLike";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(ec == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(auVar.field_msgId);
            objArr[3] = str;
            w.e(str3, str4, objArr);
            aVar3 = null;
        } else {
            aVar3 = com.tencent.mm.t.f.a.B(str2, auVar.field_reserved);
        }
        dt dtVar = new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0);
        if (aVar3 != null && (aVar3.showType == 2 || aVar3.hik == 2 || aVar3.hik == 4)) {
            b.n(aVar4.hBi, aVar3.hio);
            aVar4.vDQ.H(aVar2.getResources().getDimension(R.f.aXI));
            aVar4.vDQ.setTextColor(Color.parseColor("#BF000000"));
            aVar4.vDQ.setEllipsize(TruncateAt.END);
            aVar4.vDQ.bSn();
            aVar4.vDQ.voV = true;
            aVar4.vDQ.setText(h.a(aVar2.uSU.uTo, aVar3.hin));
        }
        aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        aVar.vBZ.setTag(dtVar);
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((dt) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dUp));
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                com.tencent.mm.t.f.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.t.f.a.ek(str);
                }
                if (aVar2 != null) {
                    l.ed(auVar.field_msgId);
                }
                ay.L(auVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean a(View view, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        w.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
        if (auVar == null) {
            w.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
            return false;
        }
        String str = auVar.field_content;
        com.tencent.mm.t.f.a B = com.tencent.mm.t.f.a.B(str, auVar.field_reserved);
        if (B == null) {
            w.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
            return false;
        }
        w.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", B.url);
        if (u.mA(B.url)) {
            ap.yY();
            if (c.wR().Rc(B.hio).tB()) {
                w.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
                return false;
            } else if (B.showType == 2) {
                if (u.mA(B.hhW)) {
                    Intent intent = new Intent();
                    intent.putExtra("key_is_latest", true);
                    intent.putExtra("app_username", B.appName);
                    intent.putExtra("device_type", B.hil);
                    intent.putExtra("locate_to_username", B.hio);
                    d.b(aVar.uSU.uTo, "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                } else {
                    r1 = new Intent();
                    r1.putExtra("key_rank_info", str);
                    r1.putExtra("key_rank_semi", auVar.field_reserved);
                    r1.putExtra("key_rank_title", B.hih);
                    r1.putExtra("key_champion_info", B.hii);
                    r1.putExtra("key_champion_coverimg", B.hii);
                    r1.putExtra("rank_id", B.hhW);
                    r1.putExtra("app_username", B.appName);
                    r1.putExtra("device_type", B.hil);
                    r1.putExtra("key_champioin_username", B.hig);
                    r1.putExtra("locate_to_username", B.hio);
                    d.b(aVar.uSU.uTo, "exdevice", ".ui.ExdeviceRankInfoUI", r1);
                }
                com.tencent.mm.plugin.sport.b.d.mN(30);
                return false;
            } else if (B.showType != 4) {
                return false;
            } else {
                r1 = new Intent();
                r1.putExtra("username", B.hio);
                r1.putExtra("app_username", "gh_43f2581f6fd6");
                d.b(aVar.uSU.uTo, "exdevice", ".ui.ExdeviceProfileUI", r1);
                com.tencent.mm.plugin.sport.b.d.mN(29);
                return false;
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", B.url);
        d.b(aVar.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2);
        return true;
    }
}
