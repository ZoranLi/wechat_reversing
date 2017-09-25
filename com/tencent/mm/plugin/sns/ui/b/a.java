package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.pp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsBrowseUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.net.URLEncoder;
import java.util.Map;

public final class a implements d, e {
    private Activity activity;
    private ClipboardManager lMa;
    private View qNl;
    private String qNm;
    private bfc qNn;
    private p qqm;
    private ad qqx;
    private int scene;

    public a(Activity activity, int i, ad adVar) {
        this.activity = activity;
        this.scene = i;
        this.lMa = (ClipboardManager) activity.getSystemService("clipboard");
        this.qqx = adVar;
    }

    public final void a(View view, String str, bfc com_tencent_mm_protocal_c_bfc) {
        this.qNl = view;
        this.qNm = str;
        this.qNn = com_tencent_mm_protocal_c_bfc;
    }

    private String blq() {
        if (this.qNl != null && (this.qNl.getTag() instanceof ar) && ((ar) this.qNl.getTag()).bkG()) {
            b Fq = ao.Fq(ae.beL().Gg(this.qNm).bhe());
            if (Fq != null) {
                return Fq.result;
            }
        }
        return null;
    }

    public final void c(MenuItem menuItem, int i) {
        if (this.qNl != null) {
            CharSequence blq;
            cb cbVar;
            m Gg;
            com.tencent.mm.plugin.sns.ui.ao aoVar;
            String str;
            m Gg2;
            alh a;
            k cVar;
            String str2;
            String str3;
            String He;
            m Gg3;
            q.b n;
            long Ny;
            m Gg4;
            com.tencent.mm.sdk.b.b cbVar2;
            bfc com_tencent_mm_protocal_c_bfc;
            rv rvVar;
            rw rwVar;
            l lVar;
            Context context;
            Intent intent;
            com.tencent.mm.modelsns.b gz;
            Intent intent2;
            switch (menuItem.getItemId()) {
                case 0:
                    blq = blq();
                    if (bg.mA(blq)) {
                        blq = this.qNn.ufy;
                    }
                    this.lMa.setText(blq);
                    g.bl(this.activity, this.activity.getString(j.dGy));
                    return;
                case 1:
                    blq = blq();
                    if (bg.mA(blq)) {
                        blq = this.qNn.ufy;
                    }
                    this.qqx.beq().dz(this.qNm, this.qNn.mQY);
                    cbVar = new cb();
                    com.tencent.mm.plugin.sns.i.a.a(cbVar, this.qNm, blq);
                    cbVar.fFA.activity = this.activity;
                    cbVar.fFA.fFH = 30;
                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    return;
                case 2:
                    this.qqx.beq().dz(this.qNm, this.qNn.mQY);
                    cbVar = new cb();
                    Gg = h.Gg(this.qNm);
                    if (Gg.tE(32) && Gg.bha().qdV) {
                        Hf(this.qNm);
                    } else {
                        aoVar = (com.tencent.mm.plugin.sns.ui.ao) this.qNl.getTag();
                        str = this.qNm;
                        int i2 = aoVar.index;
                        if (u.GD(str) || i2 < 0) {
                            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                            cbVar.fFA.fFG = j.eib;
                        } else if (ae.beu()) {
                            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                            cbVar.fFA.fFG = j.pJI;
                        } else {
                            Gg2 = ae.beL().Gg(str);
                            if (Gg2 == null) {
                                w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                                cbVar.fFA.fFG = j.eic;
                            } else {
                                a = ai.a(Gg2, i2);
                                if (a == null) {
                                    w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
                                    cbVar.fFA.fFG = j.eic;
                                } else {
                                    com.tencent.mm.plugin.sns.i.a.a(cbVar, Gg2, a.mQY);
                                }
                            }
                        }
                        cbVar.fFA.activity = this.activity;
                        cbVar.fFA.fFH = 31;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    }
                    if (Gg.tE(32)) {
                        cVar = new c(Gg.bhH(), 11, this.scene == 0 ? 1 : 2, "", Gg.bhL());
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                        return;
                    }
                    return;
                case 3:
                    this.qqx.beq().dz(this.qNm, this.qNn.mQY);
                    str2 = this.qNn.ufB.msN;
                    str3 = this.qNn.ufA.mQY;
                    He = au.He(str2);
                    if (bg.mA(He)) {
                        w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        return;
                    }
                    cb cbVar3 = new cb();
                    Gg3 = h.Gg(this.qNm);
                    if (Gg3 != null) {
                        str3 = q.fQ(Gg3.field_snsId);
                        n = q.yC().n(str3, true);
                        n.l("prePublishId", "sns_" + i.df(Gg3.field_snsId));
                        n.l("preUsername", Gg3.field_userName);
                        n.l("preChatName", "");
                        n.l(SlookSmartClipMetaTag.TAG_TYPE_URL, He);
                        n.l("preMsgIndex", Integer.valueOf(0));
                        n.l("sendAppMsgScene", Integer.valueOf(1));
                        n.l("adExtStr", Gg3.bhd().qui);
                        cbVar3.fFA.fFF = str3;
                    }
                    Gg = ae.beL().Gg(this.qNm);
                    if (Gg != null && this.qNn.ufB.tsN == 18) {
                        com.tencent.mm.plugin.sns.a.a.j.a(com.tencent.mm.plugin.sns.a.a.j.d.AdUrl, com.tencent.mm.plugin.sns.a.a.j.c.Fav, com.tencent.mm.plugin.sns.a.a.j.e.Samll, 0, Gg);
                    }
                    if (bg.mA(this.qNn.qsQ)) {
                        if (Gg.tE(32)) {
                            cVar = new c(Gg.bhH(), 11, this.scene == 0 ? 1 : 2, "", Gg.bhL());
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                        }
                        com.tencent.mm.plugin.sns.i.a.a(cbVar3, He, this.qNm);
                        cbVar3.fFA.activity = this.activity;
                        cbVar3.fFA.fFH = 28;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar3);
                        if (cbVar3.fFB.ret == 0) {
                            Ny = bg.Ny();
                            if (!bg.mA(He)) {
                                w.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), He, Long.valueOf(Ny), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                str2 = "";
                                try {
                                    str2 = URLEncoder.encode(He, "UTF-8");
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(13378, new Object[]{str2, Long.valueOf(Ny), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Hf(Gg.bhy());
                    return;
                case 4:
                    this.qqx.beq().dz(this.qNm, this.qNn.mQY);
                    Gg4 = ae.beL().Gg(this.qNm);
                    if (this.qNn.ufB.tsO.size() != 0) {
                        a = (alh) this.qNn.ufB.tsO.get(0);
                        if (Gg4 == null || a == null) {
                            w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                            return;
                        }
                        com.tencent.mm.sdk.b.b cbVar4 = new cb();
                        if (a == null || Gg4 == null || Gg4.qnk == 0) {
                            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                            cbVar4.fFA.fFG = j.eib;
                        } else if (ae.beu()) {
                            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                            cbVar4.fFA.fFG = j.pJI;
                        } else {
                            String df = i.df(Gg4.field_snsId);
                            df = String.format("%s#%s", new Object[]{df, a.mQY});
                            rv rvVar2 = new rv();
                            rw rwVar2 = new rw();
                            w.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[]{Gg4.field_userName});
                            rwVar2.OD(Gg4.field_userName);
                            rwVar2.OE(com.tencent.mm.u.m.xL());
                            rwVar2.yj(2);
                            rwVar2.ep(((long) Gg4.field_createTime) * 1000);
                            rwVar2.OI(Gg4.bhe());
                            rwVar2.OF(df);
                            rm rmVar = new rm();
                            rmVar.Od(df);
                            rmVar.NS(a.msN);
                            rmVar.NT(a.tPm);
                            rmVar.NR(Gg4.bhd().ufB.msN);
                            df = am.du(ae.getAccSnsPath(), a.mQY) + i.e(a);
                            if (FileOp.aO(df)) {
                                rmVar.Oa(df);
                            } else {
                                rmVar.jK(true);
                                rmVar.NU(a.tPi);
                                sf sfVar = new sf();
                                sfVar.OT(a.tPi);
                                rvVar2.b(sfVar);
                            }
                            rmVar.yb(7);
                            rmVar.NL(a.fDC);
                            rmVar.NM(a.msk);
                            rmVar.jJ(true);
                            rvVar2.tzn.add(rmVar);
                            rvVar2.a(rwVar2);
                            cbVar4.fFA.fFC = rvVar2;
                            cbVar4.fFA.type = 7;
                            com.tencent.mm.plugin.sns.i.a.a(rmVar, Gg4);
                        }
                        cbVar4.fFA.activity = this.activity;
                        cbVar4.fFA.fFH = 25;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar4);
                        return;
                    }
                    return;
                case 5:
                    this.qqx.beq().dz(this.qNm, this.qNn.mQY);
                    if (this.qNn != null) {
                        cbVar2 = new cb();
                        com_tencent_mm_protocal_c_bfc = this.qNn;
                        if (com_tencent_mm_protocal_c_bfc == null) {
                            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                            cbVar2.fFA.fFG = j.eib;
                        } else {
                            rvVar = new rv();
                            rwVar = new rw();
                            ru ruVar = new ru();
                            rwVar.OD(com_tencent_mm_protocal_c_bfc.jNj);
                            rwVar.OE(com.tencent.mm.u.m.xL());
                            rwVar.yj(2);
                            rwVar.ep(bg.Nz());
                            if (com_tencent_mm_protocal_c_bfc.ufA != null) {
                                rwVar.OJ(com_tencent_mm_protocal_c_bfc.ufA.mQY);
                            }
                            if (com_tencent_mm_protocal_c_bfc.ufB != null) {
                                ruVar.Ow(com_tencent_mm_protocal_c_bfc.ufB.fDC);
                                ruVar.Ox(com_tencent_mm_protocal_c_bfc.ufB.msk);
                                if (!(com_tencent_mm_protocal_c_bfc.ufB.tsO == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.isEmpty())) {
                                    a = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
                                    ruVar.yg(a.fEC);
                                    ruVar.Oz(a.qqP);
                                    ruVar.Oy(a.tPi);
                                }
                            }
                            cbVar2.fFA.title = ruVar.title;
                            cbVar2.fFA.desc = ruVar.desc;
                            cbVar2.fFA.fFC = rvVar;
                            cbVar2.fFA.type = 10;
                            rvVar.a(rwVar);
                            rvVar.b(ruVar);
                        }
                        cbVar2.fFA.activity = this.activity;
                        cbVar2.fFA.fFH = 26;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar2);
                        return;
                    }
                    return;
                case 7:
                    com.tencent.mm.plugin.sns.model.q qVar;
                    str = ae.beL().Gg(this.qNm).bhe();
                    lVar = (l) this.qNl.getTag();
                    k qVar2;
                    if (u.Gz(str)) {
                        qVar2 = new com.tencent.mm.plugin.sns.model.q(u.GA(str), 6, lVar.pUa);
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(qVar2, 0);
                        qVar = qVar2;
                    } else {
                        qVar2 = new com.tencent.mm.plugin.sns.model.q(u.GA(str), 4, lVar.pUa);
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(qVar2, 0);
                        cVar = qVar2;
                    }
                    context = this.activity;
                    this.activity.getString(j.dIO);
                    this.qqm = g.a(context, this.activity.getString(j.pKE), true, new OnCancelListener(this) {
                        final /* synthetic */ a qNo;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.c(qVar);
                        }
                    });
                    return;
                case 8:
                    Gg3 = ae.beL().Gg(this.qNm);
                    if (Gg3 != null) {
                        com.tencent.mm.plugin.sns.abtest.a.b(Gg3);
                        intent = new Intent();
                        intent.putExtra("sns_permission_snsinfo_svr_id", Gg3.field_snsId);
                        intent.putExtra("sns_permission_userName", Gg3.field_userName);
                        intent.putExtra("sns_permission_anim", true);
                        intent.setClass(this.activity, SnsPermissionUI.class);
                        this.activity.startActivityForResult(intent, 11);
                        return;
                    }
                    return;
                case 9:
                    this.qqx.beq().dz(this.qNm, this.qNn.mQY);
                    if (this.qNn != null) {
                        cbVar2 = new cb();
                        com_tencent_mm_protocal_c_bfc = this.qNn;
                        if (com_tencent_mm_protocal_c_bfc == null) {
                            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                            cbVar2.fFA.fFG = j.eib;
                        } else {
                            rvVar = new rv();
                            rwVar = new rw();
                            rz rzVar = new rz();
                            rwVar.OD(com_tencent_mm_protocal_c_bfc.jNj);
                            rwVar.OE(com.tencent.mm.u.m.xL());
                            rwVar.yj(8);
                            rwVar.ep(bg.Nz());
                            if (com_tencent_mm_protocal_c_bfc.ufA != null) {
                                rwVar.OJ(com_tencent_mm_protocal_c_bfc.ufA.mQY);
                            }
                            if (com_tencent_mm_protocal_c_bfc.ufB != null) {
                                rzVar.OM(com_tencent_mm_protocal_c_bfc.ufB.fDC);
                                rzVar.ON(com_tencent_mm_protocal_c_bfc.ufB.msk);
                                if (!(com_tencent_mm_protocal_c_bfc.ufB.tsO == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.isEmpty())) {
                                    a = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
                                    rzVar.OP(a.qqP);
                                    rzVar.OO(a.tPi);
                                }
                            }
                            cbVar2.fFA.title = rzVar.title;
                            cbVar2.fFA.desc = rzVar.desc;
                            cbVar2.fFA.fFC = rvVar;
                            cbVar2.fFA.type = 15;
                            rvVar.a(rwVar);
                            rvVar.b(rzVar);
                        }
                        cbVar2.fFA.activity = this.activity;
                        cbVar2.fFA.fFH = 27;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar2);
                        return;
                    }
                    return;
                case 10:
                    this.qqx.beq().dz(this.qNm, this.qNn.mQY);
                    Gg3 = h.Gg(this.qNm);
                    if (Gg3.tE(32) && Gg3.bha().qdV) {
                        Gg4 = ae.beL().Gg(this.qNm);
                        if (Gg4 != null && Gg4.tE(32)) {
                            cVar = new c(Gg4.bhH(), 11, this.scene == 0 ? 1 : 2, "", 2);
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                        }
                        Hf(this.qNm);
                        return;
                    }
                    m Gg5 = ae.beL().Gg(this.qNm);
                    if (Gg5 != null) {
                        if (Gg5.tE(32)) {
                            com.tencent.mm.plugin.sns.a.a.j.a(com.tencent.mm.plugin.sns.a.a.j.d.Sight, com.tencent.mm.plugin.sns.a.a.j.c.Fav, com.tencent.mm.plugin.sns.a.a.j.e.Samll, 0, Gg5);
                            cVar = new c(Gg5.bhH(), 11, this.scene == 0 ? 1 : 2, "", Gg5.bhL());
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                        }
                        cb cbVar5 = new cb();
                        com.tencent.mm.plugin.sns.i.a.a(cbVar5, Gg5);
                        cbVar5.fFA.activity = this.activity;
                        cbVar5.fFA.fFH = 29;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar5);
                        return;
                    }
                    return;
                case 11:
                    if (this.qNl.getTag() instanceof l) {
                        this.lMa.setText(((l) this.qNl.getTag()).opI);
                        g.bl(this.activity, this.activity.getString(j.dGy));
                        return;
                    }
                    return;
                case 12:
                    a = (alh) this.qNn.ufB.tsO.get(0);
                    str2 = am.du(ae.getAccSnsPath(), a.mQY) + i.e(a);
                    intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("select_is_ret", true);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("image_path", str2);
                    intent.putExtra("Retr_Msg_Type", 11);
                    com.tencent.mm.bb.d.a(this.activity, ".ui.transmit.SelectConversationUI", intent, 15);
                    return;
                case 13:
                    com.tencent.mm.plugin.sns.abtest.a.a(this.activity, ae.beL().Gg(this.qNm));
                    return;
                case 14:
                    Gg4 = ae.beL().Gg(this.qNm);
                    if (Gg4 != null) {
                        if (this.scene == 0) {
                            gz = com.tencent.mm.modelsns.b.gz(714);
                        } else {
                            gz = com.tencent.mm.modelsns.b.gA(714);
                        }
                        gz.kG(i.g(Gg4)).gC(Gg4.field_type).bp(Gg4.tE(32)).kG(Gg4.bhI());
                        gz.JE();
                    }
                    ao.o(Gg4);
                    return;
                case 15:
                    if (this.qNl.getTag() instanceof l) {
                        lVar = (l) this.qNl.getTag();
                        Gg2 = ae.beL().Gf(lVar.qqG);
                        if (Gg2 != null) {
                            com.tencent.mm.modelsns.b gz2;
                            if (this.scene == 0) {
                                gz2 = com.tencent.mm.modelsns.b.gz(715);
                            } else {
                                gz2 = com.tencent.mm.modelsns.b.gA(715);
                            }
                            gz2.kG(i.g(Gg2)).gC(Gg2.field_type).bp(Gg2.tE(32)).kG(Gg2.bhI());
                            if (lVar.pUa != null) {
                                gz2.kG(lVar.pUa.ubK == 0 ? lVar.pUa.ubN : lVar.pUa.ubK);
                            } else {
                                gz2.kG("");
                            }
                            gz2.JE();
                        }
                        ao.a((l) this.qNl.getTag());
                        return;
                    }
                    return;
                case 16:
                    ao.p(ae.beL().Gg(this.qNm));
                    return;
                case 17:
                    if (this.qNl.getTag() instanceof l) {
                        ao.b((l) this.qNl.getTag());
                        return;
                    }
                    return;
                case 18:
                    context = this.activity;
                    Gg2 = ae.beL().Gg(this.qNm);
                    if (Gg2 != null) {
                        intent2 = new Intent();
                        if (Gg2.bhd().ufB.tsN == 1) {
                            aoVar = (com.tencent.mm.plugin.sns.ui.ao) this.qNl.getTag();
                            alh a2 = ai.a(Gg2, aoVar.index);
                            if (a2 == null) {
                                w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                                return;
                            } else {
                                intent2.putExtra("sns_send_data_ui_image_path", FlipView.f(am.du(ae.getAccSnsPath(), a2.mQY) + i.l(a2), context));
                                intent2.putExtra("sns_send_data_ui_image_position", aoVar.index);
                            }
                        } else if ((Gg2.bhd().ufB.tsN == 4 || Gg2.bhd().ufB.tsN == 15 || Gg2.bhd().ufB.tsN == 3) && ((alh) Gg2.bhd().ufB.tsO.get(0)) == null) {
                            w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                            return;
                        }
                        intent2.putExtra("exdevice_open_scene_type", 1);
                        intent2.putExtra("sns_local_id", this.qNm);
                        intent2.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.bb.d.a(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent2);
                        return;
                    }
                    return;
                case 19:
                    Gg3 = ae.beL().Gg(this.qNm);
                    if (Gg3 == null) {
                        w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                        return;
                    } else if (Gg3.tE(32)) {
                        w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                        return;
                    } else {
                        a = (alh) Gg3.bhd().ufB.tsO.get(0);
                        if (a == null) {
                            w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                            return;
                        }
                        str = am.du(ae.getAccSnsPath(), a.mQY);
                        str3 = "";
                        if (FileOp.aO(str + i.j(a))) {
                            str3 = str + i.e(a);
                        }
                        if (FileOp.aO(str + i.p(a))) {
                            str3 = str + i.n(a);
                        }
                        Intent intent3 = new Intent();
                        intent3.setClass(this.activity, SnsOnlineVideoActivity.class);
                        intent3.putExtra("intent_thumbpath", str3);
                        intent3.putExtra("intent_localid", this.qNm);
                        intent3.putExtra("intent_from_scene", this.scene);
                        intent3.putExtra("intent_ismute", true);
                        if (this.qNl != null) {
                            int[] iArr = new int[2];
                            this.qNl.getLocationInWindow(iArr);
                            int width = this.qNl.getWidth();
                            int height = this.qNl.getHeight();
                            intent3.putExtra("img_gallery_left", iArr[0]);
                            intent3.putExtra("img_gallery_top", iArr[1]);
                            intent3.putExtra("img_gallery_width", width);
                            intent3.putExtra("img_gallery_height", height);
                        }
                        this.activity.startActivity(intent3);
                        this.activity.overridePendingTransition(0, 0);
                        return;
                    }
                case 20:
                    this.qqx.beq().dz(this.qNm, this.qNn.mQY);
                    Gg3 = h.Gg(this.qNm);
                    if (Gg3.tE(32) && Gg3.bha().qdV) {
                        Gg4 = ae.beL().Gg(this.qNm);
                        if (Gg4 != null && Gg4.tE(32)) {
                            if (this.qNn == null || this.qNn.ufB.tsN != 15 || this.qNn.ufI == 1) {
                                cVar = new c(Gg4.bhH(), 11, this.scene == 0 ? 1 : 2, "", 4);
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                            } else {
                                cVar = new c(Gg4.bhH(), 11, this.scene == 0 ? 1 : 2, "", 5);
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                            }
                        }
                        Hf(this.qNm);
                        return;
                    }
                    m Gg6 = ae.beL().Gg(this.qNm);
                    str2 = null;
                    if (Gg6 != null && Gg6.tE(32)) {
                        str2 = Gg6.bhG();
                        if (bg.mA(str2)) {
                            str2 = Gg6.bhF();
                        }
                    }
                    if (bg.mA(str2)) {
                        str2 = this.qNn.ufB.msN;
                        str3 = this.qNn.ufA.mQY;
                        He = au.He(str2);
                    } else {
                        He = str2;
                    }
                    if (bg.mA(He)) {
                        w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        return;
                    }
                    cb cbVar6 = new cb();
                    Gg3 = h.Gg(this.qNm);
                    if (Gg3 != null) {
                        str3 = q.fQ(Gg3.field_snsId);
                        n = q.yC().n(str3, true);
                        n.l("prePublishId", "sns_" + i.df(Gg3.field_snsId));
                        n.l("preUsername", Gg3.field_userName);
                        n.l("preChatName", "");
                        n.l(SlookSmartClipMetaTag.TAG_TYPE_URL, He);
                        n.l("preMsgIndex", Integer.valueOf(0));
                        n.l("sendAppMsgScene", Integer.valueOf(1));
                        n.l("adExtStr", Gg3.bhd().qui);
                        cbVar6.fFA.fFF = str3;
                    }
                    if (Gg6 != null && (this.qNn.ufB.tsN == 18 || Gg6.tE(32))) {
                        com.tencent.mm.plugin.sns.a.a.j.a(com.tencent.mm.plugin.sns.a.a.j.d.AdUrl, com.tencent.mm.plugin.sns.a.a.j.c.Fav, com.tencent.mm.plugin.sns.a.a.j.e.Samll, 0, Gg6);
                        if (this.qNn == null || this.qNn.ufB.tsN != 15 || this.qNn.ufI == 1) {
                            cVar = new c(Gg6.bhH(), 11, this.scene == 0 ? 1 : 2, "", Gg6.bhL());
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                        } else {
                            cVar = new c(Gg6.bhH(), 11, this.scene == 0 ? 1 : 2, "", 5);
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                        }
                    }
                    if (bg.mA(this.qNn.qsQ)) {
                        com.tencent.mm.plugin.sns.i.a.a(cbVar6, He, this.qNm);
                        cbVar6.fFA.activity = this.activity;
                        cbVar6.fFA.fFH = 28;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar6);
                        if (cbVar6.fFB.ret == 0) {
                            Ny = bg.Ny();
                            if (!bg.mA(He)) {
                                w.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), He, Long.valueOf(Ny), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                str2 = "";
                                try {
                                    str2 = URLEncoder.encode(He, "UTF-8");
                                } catch (Throwable e2) {
                                    w.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e2, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(13378, new Object[]{str2, Long.valueOf(Ny), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Hf(Gg6.bhy());
                    return;
                case 21:
                    Gg4 = h.Gg(this.qNm);
                    if (Gg4 == null) {
                        w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
                        return;
                    }
                    aoVar = (com.tencent.mm.plugin.sns.ui.ao) this.qNl.getTag();
                    Context context2 = this.activity;
                    intent2 = menuItem.getIntent();
                    ad adVar = this.qqx;
                    if (intent2 == null) {
                        w.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
                        return;
                    } else if (adVar == null) {
                        w.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
                        return;
                    } else if (Gg4 == null) {
                        w.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                        return;
                    } else {
                        com.tencent.mm.kernel.h.vJ();
                        if (com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
                            String str4 = aoVar.fJz;
                            int i3 = aoVar.index;
                            int i4 = aoVar.position;
                            com_tencent_mm_protocal_c_bfc = Gg4.bhd();
                            if (com_tencent_mm_protocal_c_bfc.ufB == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.size() == 0) {
                                w.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
                                return;
                            }
                            adVar.beq().v(Gg4);
                            bfc bhd = Gg4.bhd();
                            a = i3 < bhd.ufB.tsO.size() ? (alh) bhd.ufB.tsO.get(i3) : new alh();
                            if (ae.beI().A(a)) {
                                com.tencent.mm.modelsns.b gz3 = com.tencent.mm.modelsns.b.gz(716);
                                gz3.kG(i.g(Gg4)).gC(Gg4.field_type).bp(Gg4.tE(32)).kG(Gg4.bhI()).kG(a.mQY).gC(i3).gC(bhd.ufB.tsO.size());
                                gz3.JE();
                                gz = com.tencent.mm.modelsns.b.gz(744);
                                gz.kG(i.g(Gg4)).gC(Gg4.field_type).bp(Gg4.tE(32)).kG(Gg4.bhI());
                                gz.b(intent2, "intent_key_StatisticsOplog");
                                intent2.putExtra("sns_soon_enter_photoedit_ui", true);
                                intent2.putExtra("sns_gallery_localId", str4);
                                intent2.putExtra("sns_gallery_position", i3);
                                intent2.putExtra("sns_position", i4);
                                intent2.putExtra("sns_gallery_showtype", 1);
                                intent2.putExtra("K_ad_scene", 1);
                                intent2.putExtra("k_is_from_sns_main_timeline", true);
                                intent2.setClass(context2, SnsBrowseUI.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("stat_scene", 3);
                                bundle.putString("stat_msg_id", "sns_" + i.df(Gg4.field_snsId));
                                bundle.putString("stat_send_msg_user", Gg4.field_userName);
                                intent2.putExtra("_stat_obj", bundle);
                                context2.startActivity(intent2);
                                context2.overridePendingTransition(0, 0);
                                return;
                            }
                            w.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[]{Integer.valueOf(a.pRa)});
                            return;
                        }
                        w.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void Hf(String str) {
        m Gg = ae.beL().Gg(str);
        if (Gg != null) {
            String w;
            if (Gg.tE(32)) {
                Gg.bhc();
                com.tencent.mm.plugin.sns.storage.e bhJ = Gg.bhJ();
                w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Gg);
                if (!bg.mA(w)) {
                    bhJ.field_adxml = w;
                }
                w = bhJ.field_adxml;
            } else {
                w = Gg.bhd().qsQ;
            }
            Map q = bh.q(w, "adxml");
            if (q == null) {
                return;
            }
            if (q.containsKey(".adxml.adCanvasInfo")) {
                String fQ = q.fQ(Gg.field_snsId);
                String ap = bg.ap((String) q.get(".adxml.adCanvasInfo.shareTitle"), "");
                String ap2 = bg.ap((String) q.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                String ap3 = bg.ap((String) q.get(".adxml.adCanvasInfo.shareDesc"), "");
                com.tencent.mm.sdk.b.b cbVar = new cb();
                com.tencent.mm.sdk.b.b ppVar = new pp();
                ppVar.fWv.fWy = str;
                ppVar.fWv.fWz = cbVar;
                ppVar.fWv.url = ap2;
                com.tencent.mm.sdk.b.a.urY.m(ppVar);
                if (ppVar.fWw.fFj) {
                    cbVar.fFA.fFF = fQ;
                    cbVar.fFA.title = ap;
                    cbVar.fFA.desc = ap3;
                    rv rvVar = cbVar.fFA.fFC;
                    if (!(rvVar == null || rvVar.tzn == null || rvVar.tzn.size() <= 0 || rvVar.tzn.get(0) == null)) {
                        ((rm) rvVar.tzn.get(0)).Ok(w);
                        if (bg.mA(((rm) rvVar.tzn.get(0)).title)) {
                            ((rm) rvVar.tzn.get(0)).NL(cbVar.fFA.title);
                        }
                        if (bg.mA(((rm) rvVar.tzn.get(0)).desc)) {
                            ((rm) rvVar.tzn.get(0)).NM(cbVar.fFA.desc);
                        }
                    }
                    cbVar.fFA.activity = this.activity;
                    cbVar.fFA.fFH = 28;
                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    return;
                }
                if (cbVar.fFA.fFG == 0) {
                    cbVar.fFA.fFG = j.eij;
                }
                g.h(this.activity, cbVar.fFA.fFG, 0);
                return;
            }
            g.h(this.activity, j.eik, 0);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 15) {
                m Gg = ae.beL().Gg(this.qNm);
                alh com_tencent_mm_protocal_c_alh = (alh) this.qNn.ufB.tsO.get(0);
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                String str = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.e(com_tencent_mm_protocal_c_alh);
                for (String str2 : bg.f(stringExtra.split(","))) {
                    String str3;
                    if (Gg.tE(32)) {
                        com.tencent.mm.plugin.sns.a.a.j.c cVar;
                        int eC;
                        str3 = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.j(com_tencent_mm_protocal_c_alh);
                        bfc bhd = Gg.bhd();
                        com.tencent.mm.plugin.sns.storage.b bha = Gg.bha();
                        bdu com_tencent_mm_protocal_c_bdu = new bdu();
                        com_tencent_mm_protocal_c_bdu.tyZ = com_tencent_mm_protocal_c_alh.qLq;
                        com_tencent_mm_protocal_c_bdu.hjD = com_tencent_mm_protocal_c_alh.tPp;
                        if (bhd.ufB.tsN == 15) {
                            com_tencent_mm_protocal_c_bdu.hjJ = Gg.bhc().pZI;
                            com_tencent_mm_protocal_c_bdu.hjK = bhd.mQY;
                        } else {
                            com_tencent_mm_protocal_c_bdu.hjJ = bhd.ufG.hjJ;
                            com_tencent_mm_protocal_c_bdu.hjK = bhd.ufG.hjK;
                        }
                        com_tencent_mm_protocal_c_bdu.hjF = bhd.ufy;
                        com_tencent_mm_protocal_c_bdu.hjI = bg.mA(com_tencent_mm_protocal_c_alh.tPs) ? com_tencent_mm_protocal_c_alh.tPi : com_tencent_mm_protocal_c_alh.tPs;
                        if (bha != null && bha.qef == 0) {
                            com_tencent_mm_protocal_c_bdu.hjH = bha.qeh;
                            com_tencent_mm_protocal_c_bdu.hjG = bha.qeg;
                        }
                        w.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str2, str3, str, com_tencent_mm_protocal_c_alh.tPp, Integer.valueOf(com_tencent_mm_protocal_c_alh.qLq), Integer.valueOf(i.ER(str3))});
                        com.tencent.mm.plugin.messenger.a.d.aJW().a(this.activity, str2, str3, str, 43, r7, com_tencent_mm_protocal_c_bdu, false, false, bhd.qui);
                        com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra2, str2);
                        k cVar2 = new c(Gg.bhH(), 12, this.scene == 0 ? 1 : 2, "", 2);
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar2, 0);
                        boolean dH = o.dH(str2);
                        com.tencent.mm.plugin.sns.a.a.j.d dVar = com.tencent.mm.plugin.sns.a.a.j.d.Sight;
                        if (dH) {
                            cVar = com.tencent.mm.plugin.sns.a.a.j.c.Chatroom;
                        } else {
                            cVar = com.tencent.mm.plugin.sns.a.a.j.c.Chat;
                        }
                        com.tencent.mm.plugin.sns.a.a.j.e eVar = com.tencent.mm.plugin.sns.a.a.j.e.Samll;
                        if (dH) {
                            eC = com.tencent.mm.u.j.eC(str2);
                        } else {
                            eC = 0;
                        }
                        com.tencent.mm.plugin.sns.a.a.j.a(dVar, cVar, eVar, eC, Gg);
                        return;
                    }
                    str3 = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.j(com_tencent_mm_protocal_c_alh);
                    w.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str2, str3, str, com_tencent_mm_protocal_c_alh.tPp, Integer.valueOf(com_tencent_mm_protocal_c_alh.qLq), Integer.valueOf(i.ER(str3))});
                    com.tencent.mm.plugin.messenger.a.d.aJW().a(this.activity, str2, str3, str, 43, r7, this.qNn.qui);
                    com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra2, str2);
                }
                com.tencent.mm.ui.snackbar.a.e(this.activity, this.activity.getString(j.esl));
            }
        } else if (i == 15) {
            m Gg2 = ae.beL().Gg(this.qNm);
            if (Gg2 == null) {
                w.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[]{this.qNm});
                return;
            }
            k cVar3 = new c(Gg2.bhH(), 13, this.scene == 0 ? 1 : 2, "", 2);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.a(cVar3, 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
        if (this.qqm != null && this.qqm.isShowing()) {
            this.qqm.dismiss();
        }
    }
}
