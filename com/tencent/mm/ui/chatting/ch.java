package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.n;
import java.util.LinkedList;

final class ch extends ah {
    public e hUh;
    public ProgressDialog pjC;
    public a vCd;

    public ch() {
        super(34);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof di) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYD);
        view.setTag(new di(this.knu).dt(view));
        return view;
    }

    protected final boolean bUp() {
        return false;
    }

    public final void a(ah.a aVar, final int i, a aVar2, final au auVar, String str) {
        String M;
        di diVar = (di) aVar;
        this.vCd = aVar2;
        f ec = an.bDk().ec(auVar.field_msgId);
        String str2 = auVar.field_content;
        f.a aVar3 = null;
        if (!(ec == null || str2 == null)) {
            aVar3 = f.a.ek(str2);
        }
        boolean z = false;
        final com.tencent.mm.plugin.subapp.c.e Hk = com.tencent.mm.plugin.subapp.c.e.Hk(str2);
        if (!(Hk == null || Hk.qTd == 0)) {
            try {
                M = o.M(this.vCd.uSU.uTo, Hk.qTd);
                if (!(aVar3 == null || aVar3.description == null)) {
                    int indexOf = aVar3.description.indexOf(124);
                    if (indexOf <= 0 || aVar3.description.length() <= indexOf + 1) {
                        diVar.ipx.setText("");
                    } else {
                        diVar.ipx.setText(aVar3.description.substring(indexOf + 1));
                    }
                }
                if (M != null && M.length() > 0) {
                    String[] split = M.split(";");
                    diVar.vHT.setText(split[0]);
                    if (split.length > 1) {
                        diVar.vHU.setText(split[1]);
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", e, "", new Object[0]);
            }
            z = u.hc(Hk.qTd);
        }
        if (z) {
            diVar.vHX.setVisibility(0);
            diVar.ipx.setTextColor(this.vCd.getResources().getColor(R.e.aWd));
            diVar.vHU.setTextColor(this.vCd.getResources().getColor(R.e.aWd));
            diVar.vHT.setTextColor(this.vCd.getResources().getColor(R.e.aWd));
        } else {
            diVar.vHX.setVisibility(8);
            diVar.ipx.setTextColor(this.vCd.getResources().getColor(R.e.aWc));
            diVar.vHU.setTextColor(this.vCd.getResources().getColor(R.e.aWc));
            diVar.vHT.setTextColor(this.vCd.getResources().getColor(R.e.aWc));
        }
        diVar.vHV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ch vEC;

            public final void onClick(View view) {
                if (u.mA(auVar.field_imgPath)) {
                    w.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
                } else {
                    this.vEC.vCd.vBD.vES.c(i, auVar);
                }
            }
        });
        Object obj = (this.vCd.vBD.vES != null && this.vCd.vBD.vES.isPlaying() && this.vCd.vBD.vES.vzC == auVar.field_msgId) ? 1 : null;
        if (obj != null) {
            diVar.vHV.setBackgroundResource(R.g.blb);
        } else {
            diVar.vHV.setBackgroundResource(R.g.blc);
        }
        if (Hk != null && !u.mA(Hk.qTf) && Hk.qTg > 0 && u.mA(auVar.field_reserved)) {
            str2 = k.lu(m.xL());
            M = h.at(str2, false);
            auVar.cJ(str2);
            ap.yY();
            c.wT().a(auVar.field_msgId, auVar);
            long j = auVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = Hk.qTf;
            int i3 = Hk.qTg;
            int i4 = aVar3.type;
            String str5 = aVar3.hhE;
            M = l.a(M, j, i2, str3, str4, i3, i4, aVar3.hhu);
            if (M != null) {
                n vd = ap.vd();
                e anonymousClass2 = new e(this) {
                    final /* synthetic */ ch vEC;

                    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                        w.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        boolean z = false;
                        if (ag.a.hlV != null) {
                            z = ag.a.hlV.K(auVar.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((ab) kVar).getMediaId().equals(M)) {
                            au Y = au.Y(auVar);
                            Y.cI(auVar.field_reserved);
                            Y.x(-1);
                            this.vEC.vCd.vBD.vES.c(i, Y);
                        }
                        ap.vd().b(221, this.vEC.hUh);
                        this.vEC.hUh = null;
                    }
                };
                this.hUh = anonymousClass2;
                vd.a(221, anonymousClass2);
                com.tencent.mm.y.k abVar = new ab(M);
                abVar.bDf();
                ap.vd().a(abVar, 0);
            }
        }
        if (u.mA(auVar.field_imgPath) && Hk.qTj > 0) {
            ap.yY();
            ce x = c.wT().x(auVar.field_talker, (long) Hk.qTj);
            if (!u.mA(x.field_imgPath)) {
                str2 = k.lu(m.xL());
                if (j.p(h.at(x.field_imgPath, false), h.at(str2, false), false)) {
                    auVar.cI(str2);
                    ap.yY();
                    c.wT().a(auVar.field_msgId, auVar);
                }
            }
        }
        if (u.mA(auVar.field_imgPath) && Hk != null && !u.mA(Hk.fCW) && Hk.hhq > 0 && this.hUh == null) {
            str2 = k.lu(m.xL());
            M = h.at(str2, false);
            auVar.cI(str2);
            ap.yY();
            c.wT().a(auVar.field_msgId, auVar);
            final b a = l.a(M, auVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.fCW, aVar3.hhq);
            w.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + a.field_mediaSvrId);
            if (a.field_mediaSvrId != null) {
                n vd2 = ap.vd();
                e anonymousClass3 = new e(this) {
                    final /* synthetic */ ch vEC;

                    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                        w.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        if (((ab) kVar).getMediaId().equals(a.field_mediaSvrId)) {
                            ap.vd().b(221, this.vEC.hUh);
                            this.vEC.hUh = null;
                        }
                    }
                };
                this.hUh = anonymousClass3;
                vd2.a(221, anonymousClass3);
                ap.vd().a(new ab(a), 0);
            }
        }
        diVar.vHW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ch vEC;

            public final void onClick(View view) {
                g.a(this.vEC.vCd.uSU.uTo, R.l.faP, R.l.faR, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 vEF;

                    {
                        this.vEF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        n vd = ap.vd();
                        ch chVar = this.vEF.vEC;
                        e anonymousClass1 = new e(this) {
                            final /* synthetic */ AnonymousClass1 vEG;

                            {
                                this.vEG = r1;
                            }

                            public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                                w.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                                if (i == 0 && i2 == 0) {
                                    f.a ek;
                                    String str2 = auVar.field_content;
                                    if (str2 != null) {
                                        ek = f.a.ek(str2);
                                    } else {
                                        ek = null;
                                    }
                                    if (ek != null) {
                                        l.ed(auVar.field_msgId);
                                    }
                                    ay.L(auVar.field_msgId);
                                    Toast.makeText(this.vEG.vEF.vEC.vCd.uSU.uTo, this.vEG.vEF.vEC.vCd.getString(R.l.dUd), 0).show();
                                }
                                ap.vd().b(331, this.vEG.vEF.vEC.hUh);
                                this.vEG.vEF.vEC.hUh = null;
                                if (this.vEG.vEF.vEC.pjC != null) {
                                    this.vEG.vEF.vEC.pjC.dismiss();
                                }
                            }
                        };
                        chVar.hUh = anonymousClass1;
                        vd.a(331, anonymousClass1);
                        LinkedList linkedList = new LinkedList();
                        bjq com_tencent_mm_protocal_c_bjq = new bjq();
                        com_tencent_mm_protocal_c_bjq.tfX = Hk.qTe;
                        linkedList.add(com_tencent_mm_protocal_c_bjq);
                        final com.tencent.mm.y.k aVar = new com.tencent.mm.plugin.subapp.c.a(linkedList, linkedList.size());
                        ap.vd().a(aVar, 0);
                        ch chVar2 = this.vEF.vEC;
                        Context context = this.vEF.vEC.vCd.uSU.uTo;
                        this.vEF.vEC.vCd.getString(R.l.dIO);
                        chVar2.pjC = g.a(context, this.vEF.vEC.vCd.getString(R.l.dUe), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 vEG;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(aVar);
                                ap.vd().b(331, this.vEG.vEF.vEC.hUh);
                                this.vEG.vEF.vEC.hUh = null;
                                if (this.vEG.vEF.vEC.pjC != null) {
                                    this.vEG.vEF.vEC.pjC.dismiss();
                                }
                            }
                        });
                    }
                }, null);
            }
        });
        diVar.vBZ.setTag(new dt(auVar, this.vCd.vxp, i, null, 0, (byte) 0));
        diVar.vBZ.setOnClickListener(this.vCd.vBD.vEW);
        ap.yY();
        if (c.isSDCardAvailable()) {
            diVar.vBZ.setOnLongClickListener(this.vCd.vBD.vEY);
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
