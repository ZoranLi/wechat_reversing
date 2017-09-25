package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.wcdb.FileUtils;

final class bd extends c implements f {
    private q iJm = new r((f) this);
    public a vCd;

    public bd() {
        super(73);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYs);
        er r = new er(this.knu).r(view, false);
        View aR = ((e) h.h(e.class)).aR(view.getContext());
        r.vOP = aR;
        r.vOO.addView(aR, new LayoutParams(-1, -1));
        view.setTag(r);
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        com.tencent.mm.t.f.a B;
        String str2 = null;
        aVar = (er) aVar;
        this.vCd = aVar2;
        aVar2.aI(auVar);
        String str3 = auVar.field_content;
        aVar2.aG(auVar);
        if (str3 != null) {
            B = com.tencent.mm.t.f.a.B(str3, auVar.field_reserved);
        } else {
            B = null;
        }
        dt dtVar = new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0);
        if (B != null) {
            CharSequence charSequence;
            aVar.vyS.setVisibility(8);
            aVar.vyR.setVisibility(8);
            aVar.vyP.setVisibility(8);
            aVar.vzn.setVisibility(8);
            WxaAttributes og = ((b) h.h(b.class)).og(B.hjM);
            if (og != null) {
                charSequence = og.field_nickname;
            } else {
                Object obj = B.fUS;
            }
            String str4 = og != null ? og.field_brandIconURL : B.hjV;
            aVar.vzn.setVisibility(0);
            aVar.vzj.setVisibility(8);
            aVar.vzq.setText(B.title);
            aVar.vzj.setText(B.description);
            aVar.vzl.setText(charSequence);
            switch (B.hjT) {
                case 1:
                    aVar.vzm.setText(R.l.dGc);
                    break;
                case 2:
                    aVar.vzm.setText(R.l.dGb);
                    break;
                default:
                    aVar.vzm.setText(R.l.dDY);
                    break;
            }
            n.GW().a(str4, aVar.vzk, er.vOM);
            if (ah.bUq()) {
                cw cwVar = aVar2.vBD;
                if (auVar.field_status == 2 && ah.a(cwVar, auVar.field_msgId)) {
                    if (aVar.vyy != null) {
                        aVar.vyy.setVisibility(0);
                    }
                } else if (aVar.vyy != null) {
                    aVar.vyy.setVisibility(8);
                }
                if (aVar.oDJ != null) {
                    aVar.oDJ.setVisibility(8);
                }
            } else if (aVar.oDJ != null) {
                aVar.oDJ.setVisibility(0);
                if (auVar.field_status >= 2) {
                    aVar.oDJ.setVisibility(8);
                }
            }
            com.tencent.mm.t.a aVar3 = (com.tencent.mm.t.a) B.n(com.tencent.mm.t.a.class);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", B.hjN);
            bundle.putString("msg_id", auVar.field_msgId);
            String str5 = "cache_key";
            if (aVar3 != null) {
                str2 = aVar3.hhj;
            }
            bundle.putString(str5, str2);
            bundle.putString("msg_title", B.title);
            bundle.putString("msg_path", B.hjL);
            bundle.putInt("msg_pkg_type", B.hjT);
            bundle.putInt("pkg_version", B.fWF);
            bundle.putInt("widget_type", 0);
            bundle.putInt("scene", aVar2.vBH ? MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE : MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE);
            bundle.putInt("view_init_width", er.vOK);
            bundle.putInt("view_init_height", er.vOL);
            aVar.vOP.setTag(aVar);
            ((e) h.h(e.class)).a(com.tencent.mm.plugin.appbrand.l.b.aM(aVar2), aVar.vOP, bundle, this.iJm);
        }
        aVar.vBZ.setTag(dtVar);
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        com.tencent.mm.u.q.b n = com.tencent.mm.u.q.yC().n(com.tencent.mm.plugin.appbrand.l.b.aM(aVar2), true);
        cv cvVar = (cv) n.fS("listener");
        if (cvVar == null) {
            cvVar = new cv();
            n.l("listener", cvVar);
        }
        cvVar.b(aVar2);
        if (this.sXW) {
            aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        }
        ah.a(i, aVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        String str = auVar.field_content;
        if (str != null) {
            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(this.vCd.cQ(str, auVar.field_isSend));
            if (ek != null) {
                if (g.h(g.aJ(ek.appId, false)) && !aa.ah(auVar)) {
                    contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
                }
                if ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker)) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
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
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        com.tencent.mm.t.f.a aVar2 = null;
        String str;
        com.tencent.mm.sdk.b.b lzVar;
        switch (menuItem.getItemId()) {
            case 100:
                str = auVar.field_content;
                if (str != null) {
                    aVar2 = com.tencent.mm.t.f.a.ek(str);
                }
                if (aVar2 != null) {
                    if (19 == aVar2.type) {
                        lzVar = new lz();
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
            case 103:
                String str2 = auVar.field_content;
                if (str2 != null) {
                    aVar2 = com.tencent.mm.t.f.a.ek(str2);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 16:
                                lzVar = new hq();
                                lzVar.fNf.fNg = aVar2.fNg;
                                lzVar.fNf.fEU = auVar.field_msgId;
                                lzVar.fNf.fNh = auVar.field_talker;
                                com.tencent.mm.sdk.b.a.urY.m(lzVar);
                                break;
                            default:
                                break;
                        }
                    }
                }
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

    public final boolean a(View view, a aVar, final au auVar) {
        if (((dt) view.getTag()).knu != 5 || auVar.field_isSend != 1) {
            String str = auVar.field_content;
            if (str == null) {
                return false;
            }
            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
            if (ek == null) {
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(ek.appId, true);
            if (!(aJ == null || bg.mA(aJ.field_appId) || !aJ.bCU())) {
                ah.a(aVar, ek, m.xL(), aJ, auVar.field_msgSvrId);
            }
            com.tencent.mm.sdk.b.b prVar = new pr();
            prVar.fWB.appId = ek.hjN;
            prVar.fWB.userName = ek.hjM;
            prVar.fWB.fWD = ek.hjL;
            prVar.fWB.fWE = ek.hjT;
            prVar.fWB.fWG = ek.hjP;
            prVar.fWB.fWF = ek.hjU;
            prVar.fWB.fWH = ek.hjT != 0;
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
            prVar.fWB.fWJ.hpS = aVar.bUg();
            prVar.fWB.fWJ.hpT = ek.hjS;
            com.tencent.mm.sdk.b.a.urY.m(prVar);
            return true;
        } else if (auVar == null) {
            return true;
        } else {
            com.tencent.mm.ui.base.g.a(this.vCd.uSU.uTo, this.vCd.getString(R.l.dVl), "", this.vCd.getString(R.l.dIv), this.vCd.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ bd vCC;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ef.V(auVar);
                    this.vCC.vCd.bVF();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ bd vCC;

                {
                    this.vCC = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
    }

    public final void q(View view, int i) {
        Object tag = view.getTag();
        if (tag instanceof er) {
            w.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i));
            er erVar = (er) tag;
            switch (i) {
                case 0:
                    erVar.jmH.setVisibility(0);
                    erVar.jmH.caQ();
                    erVar.vOP.setVisibility(4);
                    erVar.vON.setVisibility(4);
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
