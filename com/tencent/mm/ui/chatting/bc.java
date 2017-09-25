package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.d;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.wcdb.FileUtils;

final class bc extends b implements f {
    private q iJm = new r((f) this);
    private a vCd;

    public bc() {
        super(72);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXN);
        er r = new er(this.knu).r(view, true);
        View aR = ((e) h.h(e.class)).aR(view.getContext());
        r.vOP = aR;
        r.vOO.addView(aR, new LayoutParams(-1, -1));
        view.setTag(r);
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        com.tencent.mm.t.f.a B;
        this.vCd = aVar2;
        er erVar = (er) aVar;
        String str2 = auVar.field_content;
        aVar2.aG(auVar);
        aVar2.aH(auVar);
        aVar2.aI(auVar);
        w.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", str);
        if (str2 != null) {
            B = com.tencent.mm.t.f.a.B(str2, auVar.field_reserved);
        } else {
            w.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", Long.valueOf(auVar.field_msgId), str);
            B = null;
        }
        dt dtVar = new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0);
        if (B != null) {
            CharSequence charSequence;
            erVar.vyS.setVisibility(8);
            erVar.vyR.setVisibility(8);
            erVar.vzn.setVisibility(8);
            d dVar = (d) B.n(d.class);
            if (erVar.vyU.b(dVar == null ? null : dVar.hhm, auVar.field_talker, false)) {
                erVar.vBZ.setBackgroundResource(R.g.bdY);
            } else {
                erVar.vBZ.setBackgroundResource(R.g.bdU);
            }
            com.tencent.mm.pluginsdk.model.app.f cv = g.cv(B.appId, B.fWF);
            if (cv != null && cv.bCU()) {
                ah.b(aVar2, B, auVar);
            }
            if (B.gxD == null || B.gxD.length() == 0) {
                erVar.vyE.setVisibility(8);
            } else {
                erVar.vyE.setVisibility(0);
                ah.b(aVar2, erVar.vyE, (Object) dt.TF(B.gxD));
            }
            WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(B.hjM);
            erVar.vyW.setVisibility(0);
            erVar.vyP.setVisibility(8);
            erVar.vyZ.setVisibility(0);
            erVar.vyX.setVisibility(8);
            if (og != null) {
                charSequence = og.field_nickname;
            } else {
                Object obj = B.fUS;
            }
            str2 = og != null ? og.field_brandIconURL : B.hjV;
            erVar.vzn.setVisibility(0);
            erVar.vzj.setVisibility(8);
            erVar.vzq.setText(B.title);
            erVar.vzj.setText(B.description);
            erVar.vzl.setText(charSequence);
            switch (B.hjT) {
                case 1:
                    erVar.vzm.setText(R.l.dGc);
                    break;
                case 2:
                    erVar.vzm.setText(R.l.dGb);
                    break;
                default:
                    erVar.vzm.setText(R.l.dDY);
                    break;
            }
            n.GW().a(str2, erVar.vzk, er.vOM);
            if (aVar2.vxp) {
                erVar.vyV.setVisibility(8);
            } else if (g.g(cv)) {
                erVar.vyV.setVisibility(0);
                ah.c(aVar2, erVar.vyV, dt.a(B, auVar));
            } else {
                erVar.vyV.setVisibility(8);
            }
            com.tencent.mm.t.a aVar3 = (com.tencent.mm.t.a) B.n(com.tencent.mm.t.a.class);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", B.hjN);
            bundle.putString("msg_id", auVar.field_msgId);
            bundle.putString("cache_key", aVar3 != null ? aVar3.hhj : null);
            bundle.putString("msg_title", B.title);
            bundle.putString("msg_path", B.hjL);
            bundle.putInt("msg_pkg_type", B.hjT);
            bundle.putInt("pkg_version", B.fWF);
            bundle.putInt("widget_type", 0);
            bundle.putInt("scene", aVar2.vBH ? MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE : MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE);
            bundle.putInt("view_init_width", er.vOK);
            bundle.putInt("view_init_height", er.vOL);
            erVar.vOP.setTag(erVar);
            ((e) h.h(e.class)).a(com.tencent.mm.plugin.appbrand.l.b.aM(aVar2), erVar.vOP, bundle, this.iJm);
        }
        erVar.vBZ.setTag(dtVar);
        erVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        com.tencent.mm.u.q.b n = com.tencent.mm.u.q.yC().n(com.tencent.mm.plugin.appbrand.l.b.aM(aVar2), true);
        cv cvVar = (cv) n.fS("listener");
        if (cvVar == null) {
            cvVar = new cv();
            n.l("listener", cvVar);
        }
        cvVar.b(aVar2);
        if (this.sXW) {
            erVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
        if (g.h(g.aJ(ek.appId, false)) && !aa.ah(auVar)) {
            if (ek.type == 6) {
                com.tencent.mm.pluginsdk.model.app.b Mh = l.Mh(ek.fCW);
                if ((Mh == null || !d.c(auVar, Mh.field_fileFullPath)) && !auVar.bMt()) {
                    contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
                }
            } else {
                contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
            }
        }
        com.tencent.mm.sdk.b.b ddVar = new dd();
        ddVar.fGW.fGM = auVar.field_msgId;
        com.tencent.mm.sdk.b.a.urY.m(ddVar);
        if (ddVar.fGX.fGu || d.a(this.vCd.uSU.uTo, ek)) {
            contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
        }
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
        }
        i AN = ((e) h.h(e.class)).AN();
        if (AN.AP() || AN.fp(ek.hjT)) {
            contextMenu.add(i, 131, 0, this.vCd.getString(R.l.dUv));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        com.tencent.mm.t.f.a aVar2 = null;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                str = auVar.field_content;
                if (str != null) {
                    aVar2 = com.tencent.mm.t.f.a.ek(str);
                }
                if (aVar2 != null) {
                    l.ed(auVar.field_msgId);
                    if (19 == aVar2.type) {
                        com.tencent.mm.sdk.b.b lzVar = new lz();
                        lzVar.fTf.type = 3;
                        lzVar.fTf.fGM = auVar.field_msgId;
                        com.tencent.mm.sdk.b.a.urY.m(lzVar);
                    }
                    com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(aVar2.appId, false);
                    if (aJ != null && aJ.bCU()) {
                        ah.a(aVar, aVar2, auVar, aJ);
                    }
                }
                ay.L(auVar.field_msgId);
                break;
            case 111:
                d.a(aVar, auVar, a(aVar, auVar));
                break;
            case 131:
                str = auVar.field_content;
                if (str != null) {
                    aVar2 = com.tencent.mm.t.f.a.ek(str);
                }
                if (aVar2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("app_id", aVar2.hjN);
                    bundle.putString("msg_id", auVar.field_msgId);
                    bundle.putInt("pkg_type", aVar2.hjT);
                    bundle.putInt("pkg_version", aVar2.hjQ);
                    ((e) h.h(e.class)).AN().b(aVar.uSU.uTo, bundle);
                    break;
                }
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        com.tencent.mm.modelstat.a.a(auVar, com.tencent.mm.modelstat.a.a.Click);
        String str = auVar.field_content;
        if (str == null) {
            return false;
        }
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(aVar.cQ(str, auVar.field_isSend));
        if (ek == null) {
            return false;
        }
        com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(ek.appId, false);
        if (aJ != null && aJ.bCU()) {
            ah.a(aVar, ek, ah.c(aVar, auVar), aJ, auVar.field_msgSvrId);
        }
        w.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", ek.hjM, ek.hjL, ek.hjN, ek.url, Integer.valueOf(ek.hjT), ek.hjP);
        com.tencent.mm.sdk.b.b prVar = new pr();
        prVar.fWB.appId = ek.hjN;
        prVar.fWB.userName = ek.hjM;
        prVar.fWB.fWD = ek.hjL;
        prVar.fWB.fWE = ek.hjT;
        prVar.fWB.fWG = ek.hjP;
        prVar.fWB.fWF = ek.hjU;
        prVar.fWB.fWH = ek.hjT != 0;
        prVar.fWB.fWJ.hpS = aVar.bUg();
        prVar.fWB.fWJ.hpT = ek.hjS;
        str = ek.hjR;
        StringBuilder stringBuilder;
        if (aVar.vBH) {
            prVar.fWB.scene = MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE;
            stringBuilder = new StringBuilder(aVar.bUg());
            stringBuilder.append(":");
            stringBuilder.append(a(aVar, auVar));
            stringBuilder.append(":");
            stringBuilder.append(str);
            prVar.fWB.fCN = stringBuilder.toString();
        } else {
            prVar.fWB.scene = MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE;
            stringBuilder = new StringBuilder(a(aVar, auVar));
            stringBuilder.append(":");
            stringBuilder.append(str);
            prVar.fWB.fCN = stringBuilder.toString();
        }
        com.tencent.mm.sdk.b.a.urY.m(prVar);
        return true;
    }

    public final void q(View view, int i) {
        Object tag = view.getTag();
        if (tag instanceof er) {
            w.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i));
            er erVar = (er) tag;
            switch (i) {
                case 0:
                    erVar.jmH.setVisibility(0);
                    erVar.jmH.caQ();
                    erVar.vON.setVisibility(4);
                    erVar.vOP.setVisibility(4);
                    return;
                case 1:
                    erVar.jmH.Wd();
                    erVar.jmH.setVisibility(4);
                    erVar.vOP.setVisibility(4);
                    erVar.vON.setVisibility(0);
                    erVar.vON.setImageResource(R.k.dwD);
                    return;
                case 4:
                    erVar.jmH.Wd();
                    erVar.jmH.setVisibility(4);
                    erVar.vOP.setVisibility(0);
                    erVar.vON.setVisibility(4);
                    return;
                default:
                    erVar.jmH.Wd();
                    erVar.jmH.setVisibility(4);
                    erVar.vOP.setVisibility(4);
                    erVar.vON.setVisibility(0);
                    erVar.vON.setImageResource(R.k.dtG);
                    return;
            }
        }
    }
}
