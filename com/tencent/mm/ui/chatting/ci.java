package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.n;

final class ci extends b {
    public e hUh;
    public a vCd;

    public ci() {
        super(35);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof ee) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYE);
        view.setTag(new ee(this.knu).dv(view));
        return view;
    }

    protected final String a(a aVar, au auVar) {
        return aVar.vBD.fJL;
    }

    protected final boolean a(a aVar) {
        return false;
    }

    public final void a(ah.a aVar, final int i, a aVar2, final au auVar, String str) {
        String M;
        ee eeVar = (ee) aVar;
        this.vCd = aVar2;
        f ec = an.bDk().ec(auVar.field_msgId);
        String str2 = auVar.field_content;
        f.a aVar3 = null;
        if (!(ec == null || str2 == null)) {
            aVar3 = f.a.B(str2, auVar.field_reserved);
        }
        com.tencent.mm.plugin.subapp.c.e Hk = com.tencent.mm.plugin.subapp.c.e.Hk(str2);
        if (!(Hk == null || Hk.qTd == 0)) {
            try {
                M = o.M(aVar2.uSU.uTo, Hk.qTd);
                CharSequence charSequence = "";
                if (M != null && M.length() > 0) {
                    String[] split = M.split(";");
                    charSequence = charSequence + split[0].replace(" ", "");
                    if (split.length > 1) {
                        charSequence = charSequence + split[1];
                    }
                }
                if (!(aVar3 == null || aVar3.description == null)) {
                    charSequence = charSequence + " " + aVar3.description;
                }
                eeVar.ipx.setText(charSequence);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", e, "", new Object[0]);
            }
        }
        w.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + auVar.field_content);
        if (u.mA(auVar.field_imgPath) && Hk.qTj > 0) {
            ap.yY();
            ce x = c.wT().x(auVar.field_talker, (long) Hk.qTj);
            if (!u.mA(x.field_imgPath)) {
                M = k.lu(m.xL());
                if (j.p(h.at(x.field_imgPath, false), h.at(M, false), false)) {
                    auVar.cI(M);
                    ap.yY();
                    c.wT().a(auVar.field_msgId, auVar);
                }
            }
        }
        if (u.mA(auVar.field_imgPath) && Hk != null && Hk.fCW != null && Hk.fCW.length() > 0 && Hk.hhq > 0 && this.hUh == null) {
            str2 = k.lu(m.xL());
            String at = h.at(str2, false);
            if (u.mA(auVar.field_imgPath)) {
                auVar.cI(str2);
                ap.yY();
                c.wT().a(auVar.field_msgId, auVar);
                w.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + aVar3.fCW);
                com.tencent.mm.pluginsdk.model.app.b a = l.a(at, auVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.fCW, aVar3.hhq);
                w.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + a.field_mediaSvrId);
                if (a.field_mediaSvrId != null) {
                    n vd = ap.vd();
                    e anonymousClass1 = new e(this) {
                        final /* synthetic */ ci vEI;

                        {
                            this.vEI = r1;
                        }

                        public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                            w.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                            ap.vd().b(221, this.vEI.hUh);
                            this.vEI.hUh = null;
                        }
                    };
                    this.hUh = anonymousClass1;
                    vd.a(221, anonymousClass1);
                    w.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
                    ap.vd().a(new ab(a), 0);
                }
            }
        }
        eeVar.vOd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ci vEI;

            public final void onClick(View view) {
                if (u.mA(auVar.field_imgPath)) {
                    w.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
                } else {
                    this.vEI.vCd.vBD.vES.d(i, auVar);
                }
            }
        });
        Object obj = (this.vCd.vBD.vES.isPlaying() && this.vCd.vBD.vES.vzC == auVar.field_msgId) ? 1 : null;
        if (obj != null) {
            eeVar.vOd.setImageResource(R.g.bho);
        } else {
            eeVar.vOd.setImageResource(R.g.bhp);
        }
        eeVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        eeVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        ap.yY();
        if (c.isSDCardAvailable()) {
            eeVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        int Mg = l.Mg(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
        f.a ek = f.a.ek(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
        if (ek.hhq <= 0 || (ek.hhq > 0 && Mg >= 100)) {
            contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
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
                    l.ed(auVar.field_msgId);
                }
                ay.L(auVar.field_msgId);
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
        return true;
    }
}
