package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ma;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.i.g;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.subapp.c.i;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class ag implements b {
    public static boolean vBB = true;
    public ToneGenerator jYA;
    Vibrator jYD;
    public final aj jYU = new aj(new a(this) {
        final /* synthetic */ ag vBN;

        {
            this.vBN = r1;
        }

        public final boolean oQ() {
            this.vBN.nxh.xD(this.vBN.vBE.getMaxAmplitude());
            return true;
        }
    }, true);
    public final aj jYV = new aj(new a(this) {
        final /* synthetic */ ag vBN;

        {
            this.vBN = r1;
        }

        public final boolean oQ() {
            long pn = this.vBN.vBE.pn();
            w.d("MicroMsg.ChattingFooterEventImpl", "ms " + pn);
            if (pn >= 50000 && pn <= 60000) {
                if (!this.vBN.vBM) {
                    bg.el(this.vBN.vzE.uSU.uTo);
                    this.vBN.vBM = true;
                }
                int i = (int) ((60000 - pn) / 1000);
                this.vBN.nxh.MZ(this.vBN.vzE.bQl().getQuantityString(R.j.dsh, i, new Object[]{Integer.valueOf(i)}));
            }
            if (pn < 60000) {
                return true;
            }
            w.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
            this.vBN.bUf();
            this.vBN.nxh.auL();
            aq.B(this.vBN.vzE.uSU.uTo, R.l.eYh);
            return false;
        }
    }, true);
    final h.a jYY = new h.a(this) {
        final /* synthetic */ ag vBN;

        {
            this.vBN = r1;
        }

        public final void onError() {
            this.vBN.vBE.reset();
            this.vBN.jYU.KH();
            this.vBN.jYV.KH();
            ad.Pu("keep_app_silent");
            this.vBN.nxh.auL();
            this.vBN.vBD.vES.bTM();
            w.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
            this.vBN.vzE.kr(true);
            this.vBN.vzE.kq(true);
            Toast.makeText(this.vBN.vzE.uSU.uTo, this.vBN.vzE.uSU.uTo.getString(R.l.dVh), 0).show();
        }
    };
    public x jiL;
    public Object lock = new Object();
    private AppPanel.a nxT = new AppPanel.a(this) {
        l ovK = null;
        final /* synthetic */ ag vBN;

        {
            this.vBN = r2;
        }

        public final void aJD() {
            if (!com.tencent.mm.n.a.aH(this.vBN.vzE.uSU.uTo)) {
                com.tencent.mm.sdk.b.b rqVar = new rq();
                com.tencent.mm.sdk.b.a.urY.m(rqVar);
                if (this.vBN.bUg().equals(rqVar.fYE.fJL) || !(rqVar.fYE.fYG || rqVar.fYE.fYH)) {
                    if (1 == g.sV().getInt("EnableVoiceVoipFromPlugin", 0)) {
                        if (this.ovK == null) {
                            this.ovK = new l(this.vBN.vzE.uSU.uTo);
                            this.ovK.qJf = new c(this) {
                                final /* synthetic */ AnonymousClass12 vBP;

                                {
                                    this.vBP = r1;
                                }

                                public final void a(com.tencent.mm.ui.base.l lVar) {
                                    lVar.dX(2, R.l.dHk);
                                    lVar.dX(1, R.l.dHl);
                                }
                            };
                            this.ovK.qJg = new d(this) {
                                final /* synthetic */ AnonymousClass12 vBP;

                                {
                                    this.vBP = r1;
                                }

                                public final void c(MenuItem menuItem, int i) {
                                    switch (menuItem.getItemId()) {
                                        case 1:
                                            this.vBP.vBN.aTF();
                                            return;
                                        case 2:
                                            this.vBP.vBN.aTG();
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                        }
                        this.ovK.blb();
                    } else {
                        this.vBN.bUj();
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(11033, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
                    return;
                }
                Toast.makeText(this.vBN.vzE.uSU.uTo, rqVar.fYE.fYF ? R.l.dPY : R.l.dPZ, 0).show();
                w.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            }
        }

        public final void aJE() {
            if (!com.tencent.mm.n.a.aH(this.vBN.vzE.uSU.uTo)) {
                com.tencent.mm.sdk.b.b rqVar = new rq();
                com.tencent.mm.sdk.b.a.urY.m(rqVar);
                if (this.vBN.bUg().equals(rqVar.fYE.fJL) || !(rqVar.fYE.fYG || rqVar.fYE.fYH)) {
                    this.vBN.bUi();
                    return;
                }
                Toast.makeText(this.vBN.vzE.uSU.uTo, rqVar.fYE.fYF ? R.l.dPY : R.l.dPZ, 0).show();
                w.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            }
        }

        public final void aJF() {
            if (!com.tencent.mm.n.a.aJ(this.vBN.vzE.uSU.uTo) && !com.tencent.mm.n.a.aH(this.vBN.vzE.uSU.uTo)) {
                w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vBN.vzE.bPj(), "android.permission.RECORD_AUDIO", 81, "", "")), bg.bJZ(), this.vBN.vzE.bPj());
                if (com.tencent.mm.pluginsdk.i.a.a(this.vBN.vzE.bPj(), "android.permission.RECORD_AUDIO", 81, "", "")) {
                    this.vBN.bUk();
                }
            }
        }

        public final void aJG() {
            q qVar = this.vBN.vzE;
            com.tencent.mm.ui.base.g.a(qVar.uSU.uTo, null, !qVar.bVO() ? new String[]{qVar.zt(R.l.ewB)} : new String[]{qVar.zt(R.l.ewB), qVar.zt(R.l.ewC)}, null, new com.tencent.mm.ui.base.g.c(qVar) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            w.d("MicroMsg.ChattingUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vLq.bPj(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)));
                            if (com.tencent.mm.pluginsdk.i.a.a(this.vLq.bPj(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)) {
                                this.vLq.bVM();
                                return;
                            }
                            return;
                        case 1:
                            w.d("MicroMsg.ChattingUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vLq.bPj(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)));
                            if (com.tencent.mm.pluginsdk.i.a.a(this.vLq.bPj(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)) {
                                this.vLq.bVN();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
        }

        public final void aJH() {
            q qVar = this.vBN.vzE;
            Intent intent = new Intent(qVar.uSU.uTo, SelectContactUI.class);
            intent.putExtra("list_attr", s.q(s.vYR, 2048));
            intent.putExtra("list_type", 4);
            intent.putExtra("received_card_name", qVar.bUg());
            intent.putExtra("block_contact", qVar.bUg());
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("titile", qVar.zt(R.l.dCT));
            qVar.startActivityForResult(intent, 223);
        }

        public final void ph(int i) {
            switch (i) {
                case 0:
                    File file = new File(e.gSz);
                    if (file.exists() || file.mkdir()) {
                        w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vBN.vzE.bPj(), "android.permission.CAMERA", 20, "", "")), bg.bJZ(), this.vBN.vzE.bPj());
                        if (com.tencent.mm.pluginsdk.i.a.a(this.vBN.vzE.bPj(), "android.permission.CAMERA", 20, "", "")) {
                            this.vBN.bUl();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.vBN.vzE.uSU.uTo, this.vBN.vzE.getString(R.l.dVI), 1).show();
                    return;
                case 1:
                    String string = this.vBN.vzE.SB(ab.bIX()).getString("gallery", "1");
                    f.rY(19);
                    if (string.equalsIgnoreCase("0")) {
                        k.k(this.vBN.vzE);
                    } else {
                        string = this.vBN.vzE.bVP();
                        String bUg = this.vBN.vzE.bUg();
                        if (this.vBN.vBJ && ag.vBB) {
                            k.b(this.vBN.vzE, 3, string, bUg);
                        } else if (x.em(bUg)) {
                            k.a(this.vBN.vzE, 12, string, bUg);
                        } else {
                            k.a(this.vBN.vzE, 3, string, bUg);
                        }
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(13822, Integer.valueOf(2), Integer.valueOf(1));
                    af.f(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 vBP;

                        {
                            this.vBP = r1;
                        }

                        public final void run() {
                            this.vBP.vBN.nxh.bFR();
                        }
                    }, 1000);
                    return;
                default:
                    return;
            }
        }

        public final void b(com.tencent.mm.pluginsdk.model.app.f fVar) {
            q qVar = this.vBN.vzE;
            if (fVar == null) {
                w.e("MicroMsg.ChattingUI", "onAppSelected, info is null, %s", bg.bJZ());
                return;
            }
            if (!(fVar == null || !com.tencent.mm.pluginsdk.model.app.f.sDd.equals(fVar.field_appId) || qVar.oRe == null)) {
                qVar.oRe.au(2, En_5b8fbb1e.a.vIk);
            }
            if (fVar.bCV()) {
                qVar.m(fVar);
            } else if (fVar.field_status == 3) {
                w.e("MicroMsg.ChattingUI", "onAppSeleted fail, app is in blacklist, packageName = " + fVar.field_packageName);
            } else if (!qVar.vKm.eT(fVar.field_packageName, fVar.field_openId) && fVar.field_status == 5) {
                w.d("MicroMsg.ChattingUI", "SuggestionApp appSuggestionIntroUrl = %s", fVar.gfk);
                if (!bg.mA(fVar.gfk)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", fVar.gfk);
                    com.tencent.mm.bb.d.b(qVar.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        }

        public final void aJI() {
            com.tencent.mm.bb.d.b(this.vBN.vzE.uSU.uTo, "subapp", ".ui.openapi.AddAppUI", new Intent());
        }

        public final void aJJ() {
            Intent intent = new Intent();
            Iterable arrayList = new ArrayList();
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            if (com.tencent.mm.modelbiz.e.dr(this.vBN.jiL.field_username)) {
                arrayList.add("4");
                arrayList.add("7");
                arrayList.add("9");
                arrayList.add(PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
                arrayList.add("11");
                arrayList.add("12");
                arrayList.add("13");
                arrayList.add("15");
                arrayList.add("16");
                arrayList.add("17");
                arrayList.add("18");
            }
            intent.putExtra("key_to_user", this.vBN.jiL.field_username);
            intent.putExtra("key_fav_item_id", TextUtils.join(",", arrayList));
            com.tencent.mm.bb.d.b(this.vBN.vzE.uSU.uTo, "favorite", ".ui.FavSelectUI", intent);
            com.tencent.mm.plugin.report.service.g.oUh.i(14103, Integer.valueOf(1));
        }

        public final void aJK() {
            Intent intent = new Intent();
            intent.putExtra("service_app_talker_user", this.vBN.bUg());
            com.tencent.mm.bb.d.a(this.vBN.vzE, "subapp", ".ui.openapi.ServiceAppUI", intent, 222);
        }

        public final void aJL() {
            Intent intent = new Intent();
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("preceding_scence", 13);
            com.tencent.mm.bb.d.b(this.vBN.vzE.uSU.uTo, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            com.tencent.mm.plugin.report.service.g.oUh.i(12065, Integer.valueOf(4));
        }

        public final void pi(int i) {
            if (!com.tencent.mm.n.a.aI(this.vBN.vzE.bPj()) && !com.tencent.mm.n.a.aJ(this.vBN.vzE.bPj()) && !com.tencent.mm.n.a.aH(this.vBN.vzE.bPj())) {
                this.vBN.AO(i);
            }
        }

        public final void aJM() {
            com.tencent.mm.plugin.report.service.g.oUh.i(12097, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.report.service.g.oUh.i(11850, Integer.valueOf(4), Integer.valueOf(1));
            if (this.vBN.vBH) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2));
                Intent intent = new Intent();
                int eC = j.eC(this.vBN.bUg());
                intent.putExtra("key_way", 1);
                intent.putExtra("key_chatroom_num", eC);
                intent.putExtra("key_type", 1);
                intent.putExtra("key_from", 1);
                intent.putExtra("key_username", this.vBN.bUg());
                intent.putExtra("pay_channel", 14);
                com.tencent.mm.bb.d.b(this.vBN.vzE.uSU.uTo, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                return;
            }
            ap.yY();
            Integer num = (Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(0));
            ap.yY();
            Integer num2 = (Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0));
            if (num.intValue() == 1 || num2.intValue() == 1) {
                if ((m.xS() == 0 ? 1 : 0) != 0) {
                    com.tencent.mm.ui.base.g.a(this.vBN.vzE.uSU.uTo, null, new String[]{this.vBN.vzE.getString(R.l.exT), this.vBN.vzE.getString(R.l.eyw)}, null, new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass12 vBP;

                        {
                            this.vBP = r1;
                        }

                        public final void hq(int i) {
                            Intent intent = new Intent();
                            switch (i) {
                                case 0:
                                    com.tencent.mm.plugin.report.service.g.oUh.i(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3));
                                    intent.putExtra("key_username", this.vBP.vBN.bUg());
                                    intent.putExtra("key_way", 0);
                                    intent.putExtra("pay_channel", 11);
                                    com.tencent.mm.bb.d.b(this.vBP.vBN.vzE.uSU.uTo, "luckymoney", ".ui.LuckyMoneyNewYearSendUI", intent);
                                    return;
                                case 1:
                                    com.tencent.mm.plugin.report.service.g.oUh.i(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
                                    intent.putExtra("key_way", 0);
                                    intent.putExtra("key_type", 0);
                                    intent.putExtra("key_from", 1);
                                    intent.putExtra("key_username", this.vBP.vBN.bUg());
                                    intent.putExtra("pay_channel", 11);
                                    com.tencent.mm.bb.d.b(this.vBP.vBN.vzE.uSU.uTo, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return;
                }
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
            intent = new Intent();
            intent.putExtra("key_way", 0);
            intent.putExtra("key_type", 0);
            intent.putExtra("key_from", 1);
            intent.putExtra("key_username", this.vBN.bUg());
            intent.putExtra("pay_channel", 11);
            com.tencent.mm.bb.d.b(this.vBN.vzE.uSU.uTo, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
        }

        public final void aJN() {
            ap.yY();
            com.tencent.mm.u.c.vr().set(81, Boolean.valueOf(false));
            if (am.isNetworkConnected(this.vBN.vzE.uSU.uTo)) {
                this.vBN.bUh();
            } else {
                com.tencent.mm.al.a.a(this.vBN.vzE.uSU.uTo, R.l.fco, null);
            }
        }

        public final void aJO() {
            Intent intent = new Intent();
            intent.putExtra("enterprise_scene", 4);
            intent.putExtra("enterprise_biz_name", this.vBN.bUg());
            intent.putExtra("biz_chat_chat_id", this.vBN.vzE.bVQ());
            com.tencent.mm.bb.d.b(this.vBN.vzE.uSU.uTo, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent);
        }

        public final void aJP() {
            if (this.vBN.vBH) {
                Intent intent = new Intent();
                intent.putExtra("enter_scene", 1);
                intent.putExtra("chatroom_name", this.vBN.bUg());
                com.tencent.mm.bb.d.b(this.vBN.vzE.uSU.uTo, "aa", ".ui.LaunchAAUI", intent);
            }
        }
    };
    public ChatFooter nxh;
    final h.b nxm = new h.b(this) {
        final /* synthetic */ ag vBN;

        {
            this.vBN = r1;
        }

        public final void BF() {
            this.vBN.nxh.bFv();
        }
    };
    public ListView vBC;
    public cw vBD;
    public h vBE;
    private String vBF;
    String vBG;
    public boolean vBH;
    private boolean vBI;
    public boolean vBJ;
    public volatile boolean vBK = false;
    public volatile boolean vBL = false;
    public boolean vBM = false;
    private boolean vxp;
    public En_5b8fbb1e.a vzE;

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ boolean ipo = true;
        final /* synthetic */ ag vBN;
        final /* synthetic */ boolean vBO;

        AnonymousClass11(ag agVar, boolean z, boolean z2) {
            this.vBN = agVar;
            this.vBO = z2;
        }

        public final void run() {
            int lastVisiblePosition = this.vBN.vBC.getLastVisiblePosition();
            int count = this.vBN.vBC.getCount() - 1;
            w.v("MicroMsg.ChattingFooterEventImpl", "last visible/adapter=" + lastVisiblePosition + "/" + count + " " + this.ipo);
            if (lastVisiblePosition >= count - 1 || this.ipo) {
                lastVisiblePosition = this.vBN.vBD.getCount();
                if (lastVisiblePosition <= 1 || !((au) this.vBN.vBD.getItem(lastVisiblePosition - 2)).isSystem()) {
                    En_5b8fbb1e.c.a(this.vBN.vBC, count, this.vBO);
                    return;
                }
                En_5b8fbb1e.c.a(this.vBN.vBC, count - 1, 0, this.vBO);
            }
        }
    }

    public ag(ListView listView, cw cwVar, En_5b8fbb1e.a aVar, ChatFooter chatFooter, String str) {
        this.vBC = listView;
        this.vBD = cwVar;
        this.vzE = aVar;
        this.nxh = chatFooter;
        this.vBF = str;
        ap.yY();
        this.jiL = com.tencent.mm.u.c.wR().Rc(str);
        this.vBH = aVar.bUg().endsWith("@chatroom");
        this.vBI = o.eQ(aVar.bUg());
        boolean z = this.vBH || this.vBI;
        this.vxp = z;
        this.jYD = (Vibrator) aVar.uSU.uTo.getSystemService("vibrator");
        if (o.fq(this.vBF)) {
            this.vBE = new i();
            w.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
        } else {
            String str2 = this.vBF;
            if (o.fC(str2)) {
                z = true;
            } else {
                com.tencent.mm.e.b.af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str2);
                if (Rc != null && Rc.bLe()) {
                    BizInfo hW = com.tencent.mm.modelbiz.e.hW(Rc.field_username);
                    if (hW != null) {
                        ExtInfo bd = hW.bd(false);
                        if (bd != null) {
                            if (bd.hux != null) {
                                bd.huB = "1".equals(bd.hux.optString("CanReceiveSpeexVoice"));
                            }
                            if (bd.huB) {
                                w.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + Rc.field_username + " canReceiveSpeexVoice");
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (z) {
                this.vBE = new com.tencent.mm.c.b.h(this.vzE.uSU.uTo, true);
                w.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
            } else {
                this.vBE = new com.tencent.mm.c.b.h(this.vzE.uSU.uTo, false);
                w.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
            }
        }
        this.vBE.a(this.nxm);
        this.vBE.a(this.jYY);
        chatFooter.a(this.nxT);
    }

    public final boolean aJv() {
        synchronized (this.lock) {
            this.vBK = true;
        }
        if (this.vBL) {
            this.vBL = false;
            releaseWakeLock();
            if (bUf()) {
                this.nxh.auL();
                w.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
            } else {
                this.nxh.bFt();
                w.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
            }
            this.vBD.vES.bTM();
            this.vzE.Ba(4);
            this.vzE.stopSignalling();
            AN(1);
            this.vzE.lk(false);
            return true;
        }
        w.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
    }

    public final boolean aJx() {
        w.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
        synchronized (this.lock) {
            this.vBK = true;
        }
        if (this.vBL) {
            this.vBL = false;
            releaseWakeLock();
            this.vzE.kr(true);
            this.vzE.kq(true);
            if (this.vBE != null) {
                this.vBE.cancel();
                this.jYU.KH();
                this.jYV.KH();
            }
            this.nxh.auL();
            this.vBD.vES.bTM();
            this.vzE.Ba(4);
            this.vzE.stopSignalling();
            AN(1);
            this.vzE.lk(false);
            return true;
        }
        w.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
    }

    public final boolean aJy() {
        if (com.tencent.mm.n.a.aJ(this.vzE.uSU.uTo) || com.tencent.mm.n.a.aH(this.vzE.uSU.uTo)) {
            w.d("MicroMsg.ChattingFooterEventImpl", "voip is running, cann't record voice");
            return false;
        }
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            if (!com.tencent.mm.compatible.e.b.rU()) {
                com.tencent.mm.ui.base.g.a(this.vzE.uSU.uTo, this.vzE.getString(R.l.dIM), this.vzE.getString(R.l.dHK), this.vzE.getString(R.l.dHM), true, new OnClickListener(this) {
                    final /* synthetic */ ag vBN;

                    {
                        this.vBN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.compatible.e.b.az(this.vBN.vzE.uSU.uTo);
                    }
                });
            }
            if (this.vBE != null) {
                if (this.jYA == null) {
                    try {
                        this.jYA = new ToneGenerator(3, (int) ((((float) this.vzE.uSU.ibo.getStreamMaxVolume(3)) / ((float) this.vzE.uSU.ibo.getStreamVolume(3))) * 100.0f));
                        w.i("MicroMsg.ChattingFooterEventImpl", "init tone");
                    } catch (Exception e) {
                        w.e("MicroMsg.ChattingFooterEventImpl", "init tone failed");
                    }
                }
                if (this.jYA != null) {
                    this.jYA.startTone(24);
                    w.i("MicroMsg.ChattingFooterEventImpl", "start tone");
                }
                this.vBC.postDelayed(new Runnable(this) {
                    final /* synthetic */ ag vBN;

                    {
                        this.vBN = r1;
                    }

                    public final void run() {
                        if (this.vBN.jYA != null) {
                            this.vBN.jYA.stopTone();
                            w.i("MicroMsg.ChattingFooterEventImpl", "stopTone");
                        }
                    }
                }, 200);
            }
            synchronized (this.lock) {
                this.vBK = false;
            }
            new ae(Looper.myLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ ag vBN;

                {
                    this.vBN = r1;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r8 = this;
                    r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                    r2 = 100;
                    r5 = 1;
                    r4 = 0;
                    r0 = r8.vBN;
                    r1 = r0.lock;
                    monitor-enter(r1);
                    r0 = r8.vBN;	 Catch:{ all -> 0x00be }
                    r0 = r0.vBK;	 Catch:{ all -> 0x00be }
                    if (r0 == 0) goto L_0x001c;
                L_0x0011:
                    r0 = "MicroMsg.ChattingFooterEventImpl";
                    r2 = "jacks already stop before begin!!";
                    com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x00be }
                    monitor-exit(r1);	 Catch:{ all -> 0x00be }
                L_0x001b:
                    return;
                L_0x001c:
                    monitor-exit(r1);	 Catch:{ all -> 0x00be }
                    r0 = r8.vBN;
                    r0.vBL = r5;
                    r0 = r8.vBN;
                    r0 = r0.jYU;
                    r0.v(r2, r2);
                    r0 = r8.vBN;
                    r0.vBM = r4;
                    r0 = r8.vBN;
                    r0 = r0.jYV;
                    r0.v(r6, r6);
                    r0 = r8.vBN;
                    r0 = r0.nxh;
                    r1 = r8.vBN;
                    r1 = r1.vBC;
                    r1 = r1.getHeight();
                    r0.xC(r1);
                    r0 = r8.vBN;
                    r0 = r0.vBD;
                    r0 = r0.vES;
                    r0.bTL();
                    r0 = r8.vBN;
                    r1 = r0.vzE;
                    r1.kr(r4);
                    r1 = r0.vzE;
                    r1.kq(r4);
                    r1 = r0.vBE;
                    if (r1 == 0) goto L_0x00c1;
                L_0x005b:
                    r1 = "keep_app_silent";
                    com.tencent.mm.sdk.platformtools.ad.Pt(r1);
                    r1 = r0.nxh;
                    r2 = r0.vzE;
                    r3 = com.tencent.mm.R.l.dSG;
                    r2 = r2.getString(r3);
                    r1.MZ(r2);
                    r1 = r0.vBE;
                    r2 = r0.bUg();
                    r1.bx(r2);
                    r1 = r0.vBE;
                    r1 = r1.getFileName();
                    r0.vBG = r1;
                    r1 = r0.vBE;
                    r2 = r0.nxm;
                    r1.a(r2);
                    r1 = r0.jYD;
                    r2 = 50;
                    r1.vibrate(r2);
                    r1 = r0.vBD;
                    r1.notifyDataSetChanged();
                    r0.lg(r5);
                    r1 = r0.vBE;
                    r0 = r0.jYY;
                    r1.a(r0);
                L_0x009c:
                    r0 = r8.vBN;
                    r0 = r0.vBC;
                    r0.setKeepScreenOn(r5);
                    r0 = r8.vBN;
                    r0 = r0.vzE;
                    r1 = 3;
                    r0.Ba(r1);
                    r0 = r8.vBN;
                    r0 = r0.vzE;
                    r0.keepSignalling();
                    com.tencent.mm.ui.chatting.ag.AN(r4);
                    r0 = r8.vBN;
                    r0 = r0.vzE;
                    r0.lk(r5);
                    goto L_0x001b;
                L_0x00be:
                    r0 = move-exception;
                    monitor-exit(r1);	 Catch:{ all -> 0x00be }
                    throw r0;
                L_0x00c1:
                    r0 = "MicroMsg.ChattingFooterEventImpl";
                    r1 = "startRecording recorder is null and stop recod";
                    com.tencent.mm.sdk.platformtools.w.e(r0, r1);
                    goto L_0x009c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ag.7.run():void");
                }
            }, 200);
            return true;
        }
        com.tencent.mm.ui.base.s.eP(this.vzE.uSU.uTo);
        w.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        return false;
    }

    public final boolean zV(String str) {
        lg(false);
        bUe();
        return this.vzE.TB(str);
    }

    public final void aJz() {
        lg(false);
        bUe();
    }

    public final void aJA() {
        lg(false);
        bUe();
    }

    public final void aJB() {
        lg(false);
        bUe();
    }

    private void bUe() {
        this.vBC.smoothScrollBy(0, 0);
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    void lg(boolean z) {
        this.vBC.postDelayed(new AnonymousClass11(this, true, z), 10);
    }

    private void releaseWakeLock() {
        this.vBC.setKeepScreenOn(false);
    }

    public final boolean bUf() {
        this.vzE.kr(true);
        this.vzE.kq(true);
        if (this.vBE != null) {
            boolean z;
            boolean pd;
            au auVar;
            long L;
            if (this.vBE.pm()) {
                z = this.jiL.field_username.equals("medianote") && (m.xP() & 16384) == 0;
                if (z) {
                    z = true;
                    pd = this.vBE.pd();
                    this.jYU.KH();
                    this.jYV.KH();
                    if (z) {
                        auVar = new au();
                        auVar.cH("medianote");
                        auVar.setType(34);
                        auVar.dw(1);
                        auVar.cI(this.vBG);
                        auVar.dv(2);
                        auVar.setContent(n.b(m.xL(), (long) this.vBE.pl(), false));
                        auVar.z(ay.gk("medianote"));
                        if (this.vBE.pp() == 2) {
                            auVar.cN("SOURCE_SILK_FILE");
                        }
                        ap.yY();
                        L = com.tencent.mm.u.c.wT().L(auVar);
                        if (L > 0) {
                            w.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
                        } else {
                            w.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + L);
                        }
                    }
                    ad.Pu("keep_app_silent");
                    return pd;
                }
            }
            z = false;
            pd = this.vBE.pd();
            this.jYU.KH();
            this.jYV.KH();
            if (z) {
                auVar = new au();
                auVar.cH("medianote");
                auVar.setType(34);
                auVar.dw(1);
                auVar.cI(this.vBG);
                auVar.dv(2);
                auVar.setContent(n.b(m.xL(), (long) this.vBE.pl(), false));
                auVar.z(ay.gk("medianote"));
                if (this.vBE.pp() == 2) {
                    auVar.cN("SOURCE_SILK_FILE");
                }
                ap.yY();
                L = com.tencent.mm.u.c.wT().L(auVar);
                if (L > 0) {
                    w.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + L);
                } else {
                    w.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
                }
            }
            ad.Pu("keep_app_silent");
            return pd;
        }
        w.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
        return false;
    }

    public final String bUg() {
        if (this.jiL == null || !x.eO(this.jiL.field_username)) {
            return this.jiL == null ? null : this.jiL.field_username;
        } else {
            return this.vBF;
        }
    }

    public final void release() {
        if (this.jYA != null) {
            w.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.jYA.release();
            this.jYA = null;
        }
    }

    public final void onPause() {
        if (this.jYA != null) {
            w.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.jYA.release();
            this.jYA = null;
        }
        bUf();
        this.jYU.KH();
        this.jYV.KH();
    }

    public final void fA(boolean z) {
        if (z) {
            this.vzE.keepSignalling();
        } else {
            this.vzE.stopSignalling();
        }
    }

    public static void AN(int i) {
        com.tencent.mm.sdk.b.b maVar = new ma();
        maVar.fTt.state = i;
        com.tencent.mm.sdk.b.a.urY.m(maVar);
    }

    public final void bUh() {
        w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.CAMERA", 22, "", "")), bg.bJZ(), this.vzE.bPj());
        if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.CAMERA", 22, "", "")) {
            w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 22, "", "")), bg.bJZ(), this.vzE.bPj());
            if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 22, "", "")) {
                w.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
                Intent intent = new Intent();
                if (com.tencent.mm.pluginsdk.l.a.sBy.zs(bUg())) {
                    w.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
                    Toast.makeText(ab.getContext(), R.l.esA, 0).show();
                    return;
                }
                if (bUg() != null) {
                    boolean z;
                    List<String> Bb = com.tencent.mm.pluginsdk.l.a.sBz.Bb(bUg());
                    ap.yY();
                    String str = (String) com.tencent.mm.u.c.vr().get(2, null);
                    boolean AZ = com.tencent.mm.pluginsdk.l.a.sBz.AZ(bUg());
                    for (String str2 : Bb) {
                        if (str != null && str.equals(str2)) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (Bb.size() < 9 || z) {
                        if (z) {
                            if (com.tencent.mm.pluginsdk.l.a.sBz.aMM()) {
                                w.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
                                Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eBZ), 0).show();
                                return;
                            }
                            w.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
                        }
                        if (com.tencent.mm.pluginsdk.l.a.sBz.aNb()) {
                            w.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
                            Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eBZ), 0).show();
                            return;
                        } else if (AZ) {
                            w.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
                            com.tencent.mm.ui.base.g.a(this.vzE.uSU.uTo, this.vzE.getString(R.l.eCv), "", this.vzE.getString(R.l.eBJ), this.vzE.getString(R.l.eBH), new OnClickListener(this) {
                                final /* synthetic */ ag vBN;

                                {
                                    this.vBN = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (!com.tencent.mm.pluginsdk.l.a.sBz.AZ(this.vBN.bUg())) {
                                        Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eCr), 0).show();
                                    } else if (!com.tencent.mm.pluginsdk.l.a.sBz.Bg(this.vBN.bUg())) {
                                        Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eBS), 0).show();
                                    }
                                }
                            }, null);
                            return;
                        }
                    }
                    w.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
                    Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eCf, new Object[]{Integer.valueOf(9)}), 0).show();
                    return;
                }
                intent.putExtra("chatroomName", bUg());
                intent.putExtra("key_need_gallery", true);
                intent.putExtra("titile", this.vzE.getString(R.l.eCm));
                com.tencent.mm.bb.d.b(this.vzE.uSU.uTo, "multitalk", ".ui.MultiTalkSelectContactUI", intent);
            }
        }
    }

    public final void AO(final int i) {
        w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.CAMERA", 18, "", "")), bg.bJZ(), this.vzE.bPj());
        if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.CAMERA", 18, "", "")) {
            w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 18, "", "")), bg.bJZ(), this.vzE.bPj());
            if (!com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 18, "", "")) {
                return;
            }
            if (com.tencent.mm.sdk.a.b.bIu() || r.ijR) {
                l lVar = new l(this.vzE.uSU.uTo);
                lVar.qJf = new c(this) {
                    final /* synthetic */ ag vBN;

                    {
                        this.vBN = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.e(1, this.vBN.vzE.getString(R.l.dHa));
                        lVar.e(5, "拍摄参数设置面板");
                    }
                };
                lVar.qJg = new d(this) {
                    final /* synthetic */ ag vBN;

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                Intent intent = new Intent();
                                com.tencent.mm.plugin.report.service.g.oUh.i(13822, Integer.valueOf(1), Integer.valueOf(1));
                                k.a(this.vBN.vzE, new Intent(), this.vBN.bUg(), i);
                                return;
                            case 5:
                                com.tencent.mm.bb.d.b(this.vBN.vzE.uSU.uTo, "mmsight", ".ui.SightSettingsUI", new Intent());
                                return;
                            default:
                                return;
                        }
                    }
                };
                lVar.blb();
            } else if (!r.ijS) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13822, Integer.valueOf(1), Integer.valueOf(1));
                k.a(this.vzE, new Intent(), bUg(), i);
            }
        }
    }

    public final void bUi() {
        w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 83, "", "")), bg.bJZ(), this.vzE.bPj());
        if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 83, "", "")) {
            if (this.nxh.bFP()) {
                this.nxh.bFR();
            }
            com.tencent.mm.sdk.b.b rrVar = new rr();
            rrVar.fYI.fJK = 5;
            rrVar.fYI.fJL = bUg();
            rrVar.fYI.context = this.vzE.uSU.uTo;
            rrVar.fYI.fYD = 3;
            com.tencent.mm.sdk.b.a.urY.m(rrVar);
            com.tencent.mm.plugin.report.service.g.oUh.i(11033, Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0));
        }
    }

    public final void bUj() {
        w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.CAMERA", 21, "", "")), bg.bJZ(), this.vzE.bPj());
        if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.CAMERA", 21, "", "")) {
            w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 21, "", "")), bg.bJZ(), this.vzE.bPj());
            if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 21, "", "")) {
                if (this.nxh.bFP()) {
                    this.nxh.bFR();
                }
                com.tencent.mm.sdk.b.b rrVar = new rr();
                rrVar.fYI.fJK = 5;
                rrVar.fYI.fJL = bUg();
                rrVar.fYI.context = this.vzE.uSU.uTo;
                rrVar.fYI.fYD = 2;
                com.tencent.mm.sdk.b.a.urY.m(rrVar);
            }
        }
    }

    public final void aTF() {
        w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 82, "", "")), bg.bJZ(), this.vzE.bPj());
        if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 82, "", "")) {
            com.tencent.mm.sdk.b.b rrVar = new rr();
            rrVar.fYI.fJK = 5;
            rrVar.fYI.fJL = bUg();
            rrVar.fYI.context = this.vzE.uSU.uTo;
            rrVar.fYI.fYD = 4;
            if (this.nxh.bFP()) {
                this.nxh.bFR();
            }
            com.tencent.mm.sdk.b.a.urY.m(rrVar);
        }
    }

    public final void aTG() {
        w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.CAMERA", 19, "", "")), bg.bJZ(), this.vzE.bPj());
        if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.CAMERA", 19, "", "")) {
            w.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 19, "", "")), bg.bJZ(), this.vzE.bPj());
            if (com.tencent.mm.pluginsdk.i.a.a(this.vzE.bPj(), "android.permission.RECORD_AUDIO", 19, "", "")) {
                com.tencent.mm.sdk.b.b rrVar = new rr();
                rrVar.fYI.fJK = 5;
                rrVar.fYI.fJL = bUg();
                rrVar.fYI.context = this.vzE.uSU.uTo;
                rrVar.fYI.fYD = 2;
                if (this.nxh.bFP()) {
                    this.nxh.bFR();
                }
                com.tencent.mm.sdk.b.a.urY.m(rrVar);
            }
        }
    }

    public final void bUk() {
        this.vzE.lp(false);
        this.nxh.bFR();
    }

    public final void bUl() {
        if (!k.a(this.vzE, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText(this.vzE.uSU.uTo, this.vzE.getString(R.l.eQD), 1).show();
        }
    }
}
