package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ak;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.po;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.List;

public final class s implements e {
    public final Context context;
    public int fFo;
    public int fFp;
    public p irJ = null;
    public int jNY = 0;
    c lHl = new c<ly>(this) {
        final /* synthetic */ s qtX;

        {
            this.qtX = r2;
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ly lyVar = (ly) bVar;
            if (this.qtX.qtS == null || this.qtX.qtk == null) {
                w.e("MicroMsg.GalleryTitleManager", "not in recoging");
            } else if (lyVar == null || !(lyVar instanceof ly)) {
                w.e("MicroMsg.GalleryTitleManager", "receive invalid callbak");
            } else if (lyVar.fTe.filePath.equals(this.qtX.qtk)) {
                w.i("MicroMsg.GalleryTitleManager", "recog result: " + lyVar.fTe.result);
                if (!bg.mA(lyVar.fTe.result)) {
                    this.qtX.qtn = lyVar.fTe.result;
                    this.qtX.fFo = lyVar.fTe.fFo;
                    this.qtX.fFp = lyVar.fTe.fFp;
                    if (!(this.qtX.qtn == null || this.qtX.qtS == null)) {
                        this.qtX.qto = true;
                    }
                    this.qtX.a(this.qtX.qrn, this.qtX.pyJ, this.qtX.qtT, false, 0);
                }
                this.qtX.qtk = null;
            } else {
                w.e("MicroMsg.GalleryTitleManager", "not same filepath");
            }
            return false;
        }
    };
    public m pyJ;
    public boolean qrn;
    SnsCmdList qtQ = new SnsCmdList();
    private final a qtR;
    public com.tencent.mm.ui.widget.e qtS = null;
    public alh qtT;
    private final String qtU;
    public String qtk;
    public String qtn;
    public boolean qto = false;
    c qtq = new c<jp>(this) {
        final /* synthetic */ s qtX;

        {
            this.qtX = r2;
            this.usg = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jp jpVar = (jp) bVar;
            if (jpVar == null || !(jpVar instanceof jp)) {
                w.e("MicroMsg.GalleryTitleManager", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            } else {
                w.i("MicroMsg.GalleryTitleManager", "notify Event: %d", new Object[]{Integer.valueOf(jpVar.fQb.fPZ)});
                if (!(jpVar.fQb.activity == ((Activity) this.qtX.context) && jpVar.fQb.fDK.equals(this.qtX.qtn))) {
                    w.e("MicroMsg.GalleryTitleManager", "not the same");
                }
            }
            return false;
        }
    };
    public String uH;

    class AnonymousClass8 implements OnCancelListener {
        final /* synthetic */ s qtX;
        final /* synthetic */ q quc;

        AnonymousClass8(s sVar, q qVar) {
            this.qtX = sVar;
            this.quc = qVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            if (this.qtX.jNY != 0) {
                h.vJ();
                h.vH().gXC.c(this.quc);
                this.qtX.jNY = 0;
            }
        }
    }

    class AnonymousClass9 implements OnCancelListener {
        final /* synthetic */ s qtX;
        final /* synthetic */ q qud;

        AnonymousClass9(s sVar, q qVar) {
            this.qtX = sVar;
            this.qud = qVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            h.vJ();
            h.vH().gXC.c(this.qud);
        }
    }

    public interface a {
        void adz();

        void bN(String str, int i);

        void bO(String str, int i);

        void biU();

        void dF(String str, String str2);
    }

    public final void tK(int i) {
        if (i != 0) {
            this.qtQ.sO(i);
        }
    }

    public s(Context context, a aVar) {
        this.context = context;
        this.qtR = aVar;
        this.qtU = ((Activity) context).getIntent().getStringExtra("sns_gallery_pre_title");
    }

    public final void biT() {
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.qtQ);
        ((Activity) this.context).setResult(-1, intent);
        ((Activity) this.context).finish();
    }

    public final void a(boolean z, final m mVar, final alh com_tencent_mm_protocal_c_alh, boolean z2, final int i) {
        b ddVar;
        this.qrn = z;
        this.pyJ = mVar;
        this.qtT = com_tencent_mm_protocal_c_alh;
        this.uH = com_tencent_mm_protocal_c_alh.mQY;
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        if (!z) {
            mVar.bhd();
            arrayList.add(this.context.getString(j.eWV));
            arrayList2.add(Integer.valueOf(3));
            if (d.Jt("favorite")) {
                arrayList.add(this.context.getString(j.eGa));
                arrayList2.add(Integer.valueOf(6));
            }
            if (mVar.field_type == 15 || mVar.field_type == 5) {
                arrayList.add(this.context.getString(j.eOn));
                arrayList2.add(Integer.valueOf(2));
            } else if (mVar.field_type == 1) {
                arrayList.add(this.context.getString(j.eOk));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(j.pMk));
                arrayList2.add(Integer.valueOf(2));
            }
            ddVar = new dd();
            ddVar.fGW.fGN = mVar.bhy();
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            if (ddVar.fGX.fGu) {
                arrayList.add(this.context.getString(j.pJF));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.qtn != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.ak(this.fFo, this.qtn) ? this.context.getString(j.eIB) : this.context.getString(j.eIA));
                arrayList2.add(Integer.valueOf(7));
            }
            if (arrayList.size() != 0) {
                if (this.qtS == null || !this.qto) {
                    this.qtS = new com.tencent.mm.ui.widget.e(this.context, com.tencent.mm.ui.widget.e.wuP, false);
                } else {
                    this.qto = false;
                }
                this.qtS.qJf = new n.c(this) {
                    final /* synthetic */ s qtX;

                    public final void a(l lVar) {
                        lVar.clear();
                        for (int i = 0; i < arrayList.size(); i++) {
                            lVar.e(((Integer) arrayList2.get(i)).intValue(), (CharSequence) arrayList.get(i));
                        }
                    }
                };
                this.qtS.qJg = new n.d(this) {
                    final /* synthetic */ s qtX;

                    public final void c(MenuItem menuItem, int i) {
                        int itemId = menuItem.getItemId();
                        w.d("MicroMsg.GalleryTitleManager", "showAlert " + itemId);
                        switch (itemId) {
                            case 2:
                                if (mVar != null && mVar.bhd().ufB != null) {
                                    if (mVar.field_type != 15) {
                                        k.h(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.l(com_tencent_mm_protocal_c_alh), this.qtX.context);
                                        return;
                                    } else {
                                        s.GM(mVar.bhy());
                                        return;
                                    }
                                }
                                return;
                            case 3:
                                if (mVar != null && mVar.bhd().ufB != null) {
                                    if (mVar.bhd().ufB.tsN == 1) {
                                        this.qtX.GK(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.l(com_tencent_mm_protocal_c_alh));
                                        return;
                                    }
                                    s.GL(mVar.bhy());
                                    return;
                                }
                                return;
                            case 4:
                                s sVar = this.qtX;
                                long j = mVar.field_snsId;
                                m dG = ae.beL().dG(j);
                                if (j != 0 && dG != null) {
                                    Intent intent = new Intent();
                                    intent.putExtra("k_username", dG.field_userName);
                                    intent.putExtra("k_expose_msg_id", j);
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                    d.b(sVar.context, "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                }
                                return;
                            case 6:
                                if (mVar != null && mVar.bhd().ufB != null) {
                                    this.qtX.a(mVar, com_tencent_mm_protocal_c_alh);
                                    return;
                                }
                                return;
                            case 7:
                                Bundle bundle = new Bundle();
                                bundle.putString("stat_msg_id", "sns_" + i.df(mVar.field_snsId));
                                bundle.putString("stat_send_msg_user", mVar.field_userName);
                                bundle.putInt("stat_scene", 3);
                                this.qtX.E(bundle);
                                return;
                            case 8:
                                this.qtX.a(mVar, com_tencent_mm_protocal_c_alh, i);
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.qtS.bzh();
            }
        } else if (mVar != null) {
            if (mVar.field_localPrivate > 0) {
                if (!bg.mA(ae.ber()) && ae.ber().equals(mVar.field_userName)) {
                    arrayList.add(this.context.getString(j.pMp));
                    arrayList2.add(Integer.valueOf(5));
                }
                arrayList.add(this.context.getString(j.eWV));
                arrayList2.add(Integer.valueOf(3));
            } else {
                arrayList.add(this.context.getString(j.pMq));
                arrayList2.add(Integer.valueOf(1));
                arrayList.add(this.context.getString(j.eWV));
                arrayList2.add(Integer.valueOf(3));
            }
            if (d.Jt("favorite")) {
                arrayList.add(this.context.getString(j.eGa));
                arrayList2.add(Integer.valueOf(6));
            }
            if (mVar.field_type == 15 || mVar.field_type == 5) {
                arrayList.add(this.context.getString(j.eOn));
                arrayList2.add(Integer.valueOf(2));
            } else if (mVar.field_type == 1) {
                arrayList.add(this.context.getString(j.eOk));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(j.pMk));
                arrayList2.add(Integer.valueOf(2));
            }
            ddVar = new dd();
            ddVar.fGW.fGN = mVar.bhy();
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            if (ddVar.fGX.fGu) {
                arrayList.add(this.context.getString(j.pJF));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.qtn != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.ak(this.fFo, this.qtn) ? this.context.getString(j.eIB) : this.context.getString(j.eIA));
                arrayList2.add(Integer.valueOf(7));
            }
            if (this.qtS == null || !this.qto) {
                this.qtS = new com.tencent.mm.ui.widget.e(this.context, com.tencent.mm.ui.widget.e.wuP, false);
            } else {
                this.qto = false;
            }
            this.qtS.qJf = new n.c(this) {
                final /* synthetic */ s qtX;

                public final void a(l lVar) {
                    lVar.clear();
                    for (int i = 0; i < arrayList.size(); i++) {
                        lVar.e(((Integer) arrayList2.get(i)).intValue(), (CharSequence) arrayList.get(i));
                    }
                    lVar.e(-1, this.qtX.context.getString(j.pKD));
                }
            };
            this.qtS.qJg = new n.d(this) {
                final /* synthetic */ s qtX;

                public final void c(MenuItem menuItem, int i) {
                    int itemId = menuItem.getItemId();
                    w.d("MicroMsg.GalleryTitleManager", "showAlertWithDel " + itemId);
                    s sVar;
                    com.tencent.mm.y.k qVar;
                    Context context;
                    switch (itemId) {
                        case -1:
                            if (mVar.bhd().ufB.tsO.size() > 1) {
                                g.a(this.qtX.context, this.qtX.context.getString(j.pMa), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass3 qtZ;

                                    {
                                        this.qtZ = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.qtZ.qtX.A(mVar);
                                    }
                                }, null);
                                return;
                            } else {
                                g.a(this.qtX.context, this.qtX.context.getString(j.pLY), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass3 qtZ;

                                    {
                                        this.qtZ = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.qtZ.qtX.A(mVar);
                                    }
                                }, null);
                                return;
                            }
                        case 1:
                            sVar = this.qtX;
                            m mVar = mVar;
                            if (mVar.bhz() || mVar.bhA()) {
                                ae.beL().tI(mVar.qnk);
                                return;
                            }
                            qVar = new q(mVar.field_snsId, 2);
                            h.vJ();
                            h.vH().gXC.a(qVar, 0);
                            context = sVar.context;
                            sVar.context.getString(j.dIO);
                            sVar.irJ = g.a(context, sVar.context.getString(j.pMn), true, new AnonymousClass8(sVar, qVar));
                            return;
                        case 2:
                            if (mVar != null && mVar.bhd().ufB != null) {
                                if (mVar.field_type != 15) {
                                    k.h(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.l(com_tencent_mm_protocal_c_alh), this.qtX.context);
                                    return;
                                } else {
                                    s.GM(mVar.bhy());
                                    return;
                                }
                            }
                            return;
                        case 3:
                            if (mVar != null && mVar.bhd().ufB != null) {
                                if (mVar.bhd().ufB.tsN == 1) {
                                    this.qtX.GK(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.l(com_tencent_mm_protocal_c_alh));
                                    return;
                                }
                                s.GL(mVar.bhy());
                                return;
                            }
                            return;
                        case 5:
                            sVar = this.qtX;
                            qVar = new q(mVar.field_snsId, 3);
                            h.vJ();
                            h.vH().gXC.a(qVar, 0);
                            context = sVar.context;
                            sVar.context.getString(j.dIO);
                            sVar.irJ = g.a(context, sVar.context.getString(j.pMn), true, new AnonymousClass9(sVar, qVar));
                            return;
                        case 6:
                            if (mVar != null && mVar.bhd().ufB != null) {
                                this.qtX.a(mVar, com_tencent_mm_protocal_c_alh);
                                return;
                            }
                            return;
                        case 7:
                            Bundle bundle = new Bundle();
                            bundle.putString("stat_msg_id", "sns_" + i.df(mVar.field_snsId));
                            bundle.putString("stat_send_msg_user", mVar.field_userName);
                            bundle.putInt("stat_scene", 3);
                            this.qtX.E(bundle);
                            return;
                        case 8:
                            this.qtX.a(mVar, com_tencent_mm_protocal_c_alh, i);
                            return;
                        default:
                            return;
                    }
                }
            };
            this.qtS.wva = new com.tencent.mm.ui.widget.e.a(this) {
                final /* synthetic */ s qtX;

                {
                    this.qtX = r1;
                }

                public final void onDismiss() {
                    b akVar = new ak();
                    akVar.fDL.filePath = this.qtX.qtk;
                    com.tencent.mm.sdk.b.a.urY.m(akVar);
                    this.qtX.qtS = null;
                    this.qtX.qtk = null;
                    this.qtX.pyJ = null;
                    this.qtX.uH = null;
                    this.qtX.qtn = null;
                    s sVar = this.qtX;
                    this.qtX.fFp = 0;
                    sVar.fFo = 0;
                }
            };
            this.qtS.bzh();
        } else {
            return;
        }
        if (true == z2) {
            h.vJ();
            if (h.vH().gXC.BR() != 0) {
                ddVar = new lw();
                String str = am.du(ae.getAccSnsPath(), this.uH) + i.l(com_tencent_mm_protocal_c_alh);
                ddVar.fTb.filePath = str;
                this.qtk = str;
                com.tencent.mm.sdk.b.a.urY.m(ddVar);
            }
        }
    }

    public final void a(m mVar, alh com_tencent_mm_protocal_c_alh, int i) {
        if (mVar == null) {
            w.e("MicroMsg.GalleryTitleManager", "error beacause info null");
            return;
        }
        Intent intent = new Intent();
        if (mVar.field_type == 1) {
            intent.putExtra("sns_send_data_ui_image_path", FlipView.f(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.l(com_tencent_mm_protocal_c_alh), this.context));
            intent.putExtra("sns_send_data_ui_image_position", i);
        }
        intent.putExtra("sns_send_data_ui_activity", true);
        intent.putExtra("sns_local_id", mVar.bhy());
        d.a(this.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
    }

    public final void a(m mVar, alh com_tencent_mm_protocal_c_alh) {
        if (mVar == null) {
            w.i("MicroMsg.GalleryTitleManager", "error beacause info null");
        } else if (mVar.field_type == 1) {
            r1 = new cb();
            com.tencent.mm.plugin.sns.i.a.a(r1, mVar, com_tencent_mm_protocal_c_alh.mQY);
            r1.fFA.activity = (Activity) this.context;
            r1.fFA.fFH = 15;
            com.tencent.mm.sdk.b.a.urY.m(r1);
        } else if (mVar == null) {
        } else {
            if (mVar.tE(32)) {
                r1 = new cb();
                com.tencent.mm.plugin.sns.i.a.a(r1, mVar);
                r1.fFA.activity = (Activity) this.context;
                r1.fFA.fFH = 16;
                com.tencent.mm.sdk.b.a.urY.m(r1);
                return;
            }
            String bhy = mVar.bhy();
            b poVar = new po();
            poVar.fWr.fJK = 2;
            poVar.fWr.fWs = 16;
            poVar.fWr.fWt = false;
            poVar.fWr.fJz = bhy;
            com.tencent.mm.sdk.b.a.urY.m(poVar);
        }
    }

    protected final void A(m mVar) {
        if (mVar.bhz() || mVar.bhA()) {
            ae.beL().tI(mVar.qnk);
            this.qtQ.sO(mVar.qnk);
            return;
        }
        ae.beK().ds(mVar.field_snsId);
        final com.tencent.mm.y.k qVar = new q(mVar.field_snsId, 1);
        h.vJ();
        h.vH().gXC.a(qVar, 0);
        Context context = this.context;
        this.context.getString(j.dIO);
        this.irJ = g.a(context, this.context.getString(j.pKE), true, new OnCancelListener(this) {
            final /* synthetic */ s qtX;

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.qtX.jNY != 0) {
                    h.vJ();
                    h.vH().gXC.c(qVar);
                    this.qtX.jNY = 0;
                }
            }
        });
    }

    protected final void GK(String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.plugin.sns.c.a.imv.l(intent, this.context);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (i == 0 && i2 == 0 && kVar != null) {
            w.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
            if (this.irJ != null) {
                this.irJ.dismiss();
            }
            q qVar = (q) kVar;
            switch (qVar.type) {
                case -1:
                    this.qtR.bN("", qVar.type);
                    return;
                case 1:
                    this.qtQ.sO(qVar.pRa);
                    this.qtR.bN(u.T("sns_table_", (long) qVar.pRa), qVar.type);
                    return;
                case 2:
                    this.qtQ.sP(qVar.pRa);
                    this.qtR.bN("", qVar.type);
                    return;
                case 3:
                    this.qtQ.sP(qVar.pRa);
                    this.qtR.bN(u.T("sns_table_", (long) qVar.pRa), qVar.type);
                    return;
                default:
                    return;
            }
        }
    }

    public final void E(Bundle bundle) {
        w.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
        b bxVar = new bx();
        bxVar.fFn.activity = (Activity) this.context;
        bxVar.fFn.fDK = this.qtn;
        bxVar.fFn.fFo = this.fFo;
        bxVar.fFn.fFp = this.fFp;
        bxVar.fFn.fFu = bundle;
        com.tencent.mm.sdk.b.a.urY.m(bxVar);
    }

    public static void GL(String str) {
        b poVar = new po();
        poVar.fWr.fJK = 1;
        poVar.fWr.fWu = 2;
        poVar.fWr.fJz = str;
        com.tencent.mm.sdk.b.a.urY.m(poVar);
    }

    public static void GM(String str) {
        b poVar = new po();
        poVar.fWr.fJK = 3;
        poVar.fWr.fJz = str;
        com.tencent.mm.sdk.b.a.urY.m(poVar);
    }
}
