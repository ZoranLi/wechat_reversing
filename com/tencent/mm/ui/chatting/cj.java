package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.n;

final class cj extends b {
    public e hUh;
    public a vCd;

    public cj() {
        super(33);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof ek) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYF);
        view.setTag(new ek(this.knu).dw(view));
        return view;
    }

    public final void a(ah.a aVar, final int i, a aVar2, final au auVar, String str) {
        ek ekVar = (ek) aVar;
        this.vCd = aVar2;
        f ec = an.bDk().ec(auVar.field_msgId);
        String str2 = auVar.field_content;
        f.a aVar3 = null;
        if (!(ec == null || str2 == null)) {
            aVar3 = f.a.B(str2, auVar.field_reserved);
        }
        if (aVar3 != null) {
            ekVar.ipx.setText(aVar3.description);
        }
        w.d("MicroMsg.ChattingItemVoiceRemindsys", "content sys " + auVar.field_content);
        com.tencent.mm.plugin.subapp.c.e Hk = com.tencent.mm.plugin.subapp.c.e.Hk(str2);
        if (Hk != null && Hk.qTf != null && Hk.qTf.length() > 0 && Hk.qTg > 0 && this.hUh == null && aVar3 != null && bg.mA(auVar.field_imgPath)) {
            str2 = k.lu(m.xL());
            String at = h.at(str2, false);
            auVar.cI(str2);
            ap.yY();
            c.wT().a(auVar.field_msgId, auVar);
            long j = auVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = Hk.qTf;
            int i3 = Hk.qTg;
            int i4 = aVar3.type;
            String str5 = aVar3.hhE;
            final String a = l.a(at, j, i2, str3, str4, i3, i4, aVar3.hhu);
            if (a != null) {
                n vd = ap.vd();
                e anonymousClass1 = new e(this) {
                    final /* synthetic */ cj vEL;

                    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                        w.d("MicroMsg.ChattingItemVoiceRemindsys", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        boolean z = false;
                        if (ag.a.hlV != null) {
                            z = ag.a.hlV.K(auVar.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((ab) kVar).getMediaId().equals(a)) {
                            this.vEL.vCd.vBD.vES.b(i, auVar);
                        }
                        ap.vd().b(221, this.vEL.hUh);
                        this.vEL.hUh = null;
                    }
                };
                this.hUh = anonymousClass1;
                vd.a(221, anonymousClass1);
                com.tencent.mm.y.k abVar = new ab(a);
                abVar.bDf();
                ap.vd().a(abVar, 0);
            }
        }
        ekVar.ipx.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        ekVar.ipx.setOnClickListener(aVar2.vBD.vEW);
        ap.yY();
        if (c.isSDCardAvailable()) {
            ekVar.ipx.setOnLongClickListener(aVar2.vBD.vEY);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
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
                    l.ed(auVar.field_msgId);
                }
                ay.L(auVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        return true;
    }
}
