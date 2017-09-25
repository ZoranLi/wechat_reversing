package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;

public final class bp extends ah {
    private com.tencent.mm.ui.chatting.En_5b8fbb1e.a vCd;

    final class a extends com.tencent.mm.ui.chatting.ah.a {
        protected TextView vDI;
        protected TextView vDJ;
        protected TextView vDK;
        protected TextView vDL;
        protected TextView vDM;
        protected TextView vDN;
        protected ImageView vDO;
        final /* synthetic */ bp vDP;

        public a(bp bpVar, int i) {
            this.vDP = bpVar;
            super(i);
        }

        public final a dp(View view) {
            super.dn(view);
            this.vDI = (TextView) view.findViewById(R.h.cGD);
            this.vDK = (TextView) view.findViewById(R.h.cvj);
            this.vDJ = (TextView) view.findViewById(R.h.cGE);
            this.vDL = (TextView) view.findViewById(R.h.cvk);
            this.vDM = (TextView) view.findViewById(R.h.cMz);
            this.vDN = (TextView) view.findViewById(R.h.bVL);
            this.mfD = (CheckBox) view.findViewById(R.h.bAd);
            this.vDO = (ImageView) view.findViewById(R.h.cMv);
            return this;
        }
    }

    public bp() {
        super(52);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof a) && ((a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYc);
        view.setTag(new a(this, this.knu).dp(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.ah.a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar, String str) {
        com.tencent.mm.t.f.a aVar3;
        this.vCd = aVar2;
        a aVar4 = (a) aVar;
        f ec = an.bDk().ec(auVar.field_msgId);
        String str2 = auVar.field_content;
        if (ec == null || str2 == null) {
            String str3 = "MicroMsg.ChattingItemHardDeviceMsg";
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
        HardDeviceChattingItemView hardDeviceChattingItemView = (HardDeviceChattingItemView) aVar.vBZ;
        if (aVar3 != null && (aVar3.showType == 1 || aVar3.hik == 1)) {
            int i2;
            if (u.mA(aVar3.hif)) {
                str3 = aVar3.hib;
                str2 = aVar3.hic;
                if (bg.mA(str3) || bg.mA(str2)) {
                    w.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", str3, str2);
                    str3 = "#ffffff";
                    str2 = "#ffffff";
                }
                Drawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[]{16842766}, new ColorDrawable(Color.parseColor(str3)));
                stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor(str3)));
                hardDeviceChattingItemView.setBackgroundDrawable(stateListDrawable);
                aVar3.hif = "#ffffff";
                str3 = aVar3.hid;
                str4 = aVar3.hie;
                int i3 = R.e.white;
                i2 = R.e.white;
                if (!(u.mA(str3) || u.mA(str4))) {
                    try {
                        i3 = Color.parseColor(str3);
                        i2 = Color.parseColor(str4);
                    } catch (IllegalArgumentException e) {
                        w.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
                    }
                }
                Drawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[]{16842919}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842908}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842766}, new ColorDrawable(i3));
                stateListDrawable2.addState(new int[0], new ColorDrawable(i3));
                aVar4.vDN.setBackgroundDrawable(stateListDrawable2);
            }
            str2 = aVar3.hif;
            if (aVar4 != null) {
                i2 = R.e.white;
                if (!u.mA(str2)) {
                    try {
                        i2 = Color.parseColor(str2);
                    } catch (IllegalArgumentException e2) {
                        w.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
                    }
                }
                aVar4.vDK.setTextColor(i2);
                aVar4.vDL.setTextColor(i2);
                aVar4.vDI.setTextColor(i2);
                aVar4.vDJ.setTextColor(i2);
                aVar4.vDM.setTextColor(i2);
            }
            aVar4.vDK.setText(aVar3.hhX);
            aVar4.vDL.setText(aVar3.hhV);
            aVar4.vDI.setText(aVar3.hhZ);
            aVar4.vDJ.setText(aVar3.hhY);
            aVar4.vDM.setText(aVar3.hia);
            if (u.mA(aVar3.hig)) {
                aVar4.vDO.setVisibility(8);
            } else {
                aVar4.vDO.setVisibility(0);
                b.n(aVar4.vDO, aVar3.hig);
            }
        }
        aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        aVar.vBZ.setTag(dtVar);
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((dt) view.getTag()).position, 100, 0, this.vCd.getString(R.l.dUp));
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
        boolean z = false;
        String str = auVar.field_content;
        com.tencent.mm.t.f.a B = com.tencent.mm.t.f.a.B(str, auVar.field_reserved);
        if (B == null) {
            w.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
            return false;
        }
        w.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", B.url);
        if (u.mA(B.url)) {
            if (!u.mA(B.hhW)) {
                if (System.currentTimeMillis() - (((long) B.him) * 1000) >= 2592000000L) {
                    z = true;
                }
                if (!z) {
                    Intent intent = new Intent();
                    intent.putExtra("key_rank_info", str);
                    intent.putExtra("key_rank_semi", auVar.field_reserved);
                    intent.putExtra("key_rank_title", B.hih);
                    intent.putExtra("key_champion_info", B.hii);
                    intent.putExtra("key_champion_coverimg", B.hii);
                    intent.putExtra("rank_id", B.hhW);
                    intent.putExtra("app_username", B.appName);
                    intent.putExtra("device_type", B.hil);
                    intent.putExtra("key_champioin_username", B.hig);
                    d.b(aVar.uSU.uTo, "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                    com.tencent.mm.plugin.sport.b.d.mN(28);
                    return true;
                }
            }
            d.w(aVar.uSU.uTo, "exdevice", ".ui.ExdeviceExpireUI");
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", B.url);
        d.b(aVar.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}
