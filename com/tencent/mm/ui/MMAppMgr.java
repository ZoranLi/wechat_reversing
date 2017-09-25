package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.Process;
import android.provider.Settings.Secure;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.au.e;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.z;
import com.tencent.mm.e.a.cj;
import com.tencent.mm.e.a.fl;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.l;
import com.tencent.mm.e.a.mi;
import com.tencent.mm.e.a.nb;
import com.tencent.mm.e.a.pt;
import com.tencent.mm.e.a.qf;
import com.tencent.mm.e.a.qs;
import com.tencent.mm.e.a.ss;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.b.d;
import com.tencent.mm.pluginsdk.l.aa;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.ui.d.g;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Map;

public final class MMAppMgr {
    public static StringBuffer uUh;
    private static long uUi;
    public long hTc;
    public String uUj;
    public Receiver uUk;
    public boolean uUl = false;
    public boolean uUm = false;
    public final aj uUn = new aj(new a(this) {
        final /* synthetic */ MMAppMgr uUp;

        {
            this.uUp = r1;
        }

        public final boolean oQ() {
            String bk = bg.bk(ab.getContext());
            if (bk == null || !bk.toLowerCase().startsWith(ab.getPackageName())) {
                w.i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                ab.getContext().sendBroadcast(intent);
            } else {
                w.i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
            }
            return false;
        }
    }, true);
    private final aj uUo = new aj(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ MMAppMgr uUp;

        {
            this.uUp = r1;
        }

        public final boolean oQ() {
            if (this.uUp.uUm == this.uUp.uUl) {
                w.d("MicroMsg.MMAppMgr", "status not changed, cur=" + this.uUp.uUm);
                return true;
            } else if (ap.yQ()) {
                return false;
            } else {
                this.uUp.uUm = this.uUp.uUl;
                BaseEvent.onForeground(this.uUp.uUm);
                b lVar;
                if (this.uUp.uUm) {
                    w.w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
                    WorkerProfile.an(false);
                    ap.vd().aX(true);
                    if (ap.zb() && h.vG().gXp && !ap.uP()) {
                        z zVar = z.gKE;
                        if (!zVar.hasInit) {
                            Map bKK;
                            zVar.hasInit = true;
                            c dX = com.tencent.mm.u.c.c.Az().dX("100066");
                            if (dX.isValid()) {
                                bKK = dX.bKK();
                                zVar.gKL = u.getInt((String) bKK.get("maxCacheCount"), 20);
                                zVar.gKM = u.getInt((String) bKK.get("maxCacheHours"), 24);
                            }
                            dX = com.tencent.mm.u.c.c.Az().dX("100058");
                            if (dX.isValid()) {
                                bKK = dX.bKK();
                                zVar.gKN = u.getInt((String) bKK.get("cacheLogCount"), 30);
                                zVar.gKO = u.getInt((String) bKK.get("maxCacheTime"), 10800);
                            }
                            w.i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", Integer.valueOf(zVar.gKL), Integer.valueOf(zVar.gKM), Integer.valueOf(zVar.gKN), Integer.valueOf(zVar.gKO));
                        }
                        f.bn(true);
                        q.Hy().gg(3);
                        ap.vd().a(new j(), 0);
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass8 uUs;

                            {
                                this.uUs = r1;
                            }

                            public final void run() {
                                m.LA().run();
                                o.La().run();
                                n.GQ().run();
                                an.bDm().run();
                                if (ag.a.hlV != null) {
                                    ag.a.hlV.yK();
                                }
                                com.tencent.mm.sdk.b.a.urY.m(new pt());
                                ap.yY();
                                com.tencent.mm.u.c.wQ().b(null);
                            }
                        });
                        bm.zN().c(19, Integer.valueOf(1));
                        e JR = e.JR();
                        w.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
                        JR.hCV.jU(true);
                        n.GU().aX(true);
                        if (aa.sBG != null) {
                            aa.sBG.bmT();
                        }
                        lVar = new l();
                        lVar.fCE.fCF = true;
                        com.tencent.mm.sdk.b.a.urY.m(lVar);
                        com.tencent.mm.modelstat.n.gI(4);
                        com.tencent.mm.modelstat.n.gI(3);
                        com.tencent.mm.modelstat.n.bq(true);
                        lVar = new qf();
                        lVar.fXk.fXl = true;
                        lVar.fXk.scene = 1;
                        com.tencent.mm.sdk.b.a.urY.m(lVar);
                        lVar = new ss();
                        lVar.gaE.fEG = 5;
                        com.tencent.mm.sdk.b.a.urY.m(lVar);
                    }
                    ap.vd().aW(false);
                    ab.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
                    if (this.uUp.uUn.bJq()) {
                        return true;
                    }
                    this.uUp.uUn.KH();
                    return true;
                }
                w.w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
                WorkerProfile.an(true);
                this.uUp.hTc = bg.NA();
                this.uUp.uUj = "desktop";
                lVar = new l();
                lVar.fCE.fCF = false;
                com.tencent.mm.sdk.b.a.urY.m(lVar);
                ap.vd().aX(false);
                if (ap.zb()) {
                    h.vJ();
                    if (h.vG().gXp) {
                        boolean z;
                        com.tencent.mm.bc.a.ND(com.tencent.mm.bc.a.bGQ());
                        Looper.myQueue().addIdleHandler(new IdleHandler(e.JR()) {
                            final /* synthetic */ e hUi;

                            {
                                this.hUi = r1;
                            }

                            public final boolean queueIdle() {
                                if (h.vd().foreground) {
                                    w.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
                                } else {
                                    w.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
                                    this.hUi.hCV.jU(false);
                                }
                                return false;
                            }
                        });
                        lVar = new mi();
                        lVar.fTE.state = 0;
                        com.tencent.mm.sdk.b.a.urY.m(lVar);
                        com.tencent.mm.sdk.b.a.urY.m(new qs());
                        lVar = new com.tencent.mm.e.a.e();
                        lVar.fCm.fCn = false;
                        com.tencent.mm.sdk.b.a.urY.m(lVar);
                        lVar = new nb();
                        lVar.fUk.fCp = false;
                        com.tencent.mm.sdk.b.a.urY.m(lVar);
                        n.GU().aX(false);
                        w.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
                        ap.yY();
                        Object obj = com.tencent.mm.u.c.vr().get(327808, null);
                        if (obj == null) {
                            z = true;
                        } else if (bg.mA(obj.toString())) {
                            z = true;
                        } else {
                            z = System.currentTimeMillis() - bg.PZ(obj.toString()) >= 604800000;
                        }
                        w.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", String.valueOf(z));
                        if (z) {
                            try {
                                com.tencent.mm.plugin.report.service.g.oUh.A(11375, bg.mz(Secure.getString(ab.getContext().getContentResolver(), "default_input_method")));
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(327808, Long.valueOf(System.currentTimeMillis()));
                            } catch (Exception e) {
                                w.e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + e.getMessage());
                            }
                        }
                        lVar = new cj();
                        lVar.fFP.state = 0;
                        com.tencent.mm.sdk.b.a.urY.m(lVar);
                        lVar = new ss();
                        lVar.gaE.fEG = 3;
                        com.tencent.mm.sdk.b.a.urY.m(lVar);
                        f.bn(false);
                        com.tencent.mm.modelstat.n.bq(false);
                    }
                }
                if (!this.uUp.uUn.bJq()) {
                    this.uUp.uUn.KH();
                }
                w.i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", Boolean.valueOf(bg.bb(ab.getContext(), ab.getPackageName() + ":tools")));
                if (!bg.bb(ab.getContext(), ab.getPackageName() + ":tools")) {
                    return true;
                }
                this.uUp.uUn.v(60000, 60000);
                return true;
            }
        }
    }, false);

    static class AnonymousClass11 implements OnDismissListener {
        final /* synthetic */ OnClickListener sao;

        AnonymousClass11(OnClickListener onClickListener) {
            this.sao = onClickListener;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            ad.Pu("show_wap_adviser");
            if (this.sao != null) {
                this.sao.onClick(dialogInterface, 0);
            }
        }
    }

    static class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass13(Context context) {
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.val$context.startActivity(new Intent("android.settings.APN_SETTINGS"));
            } catch (Exception e) {
            }
        }
    }

    static class AnonymousClass9 implements OnClickListener {
        final /* synthetic */ int hMP;

        AnonymousClass9(int i) {
            this.hMP = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(65, Integer.valueOf(this.hMP + 1));
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class Receiver extends BroadcastReceiver {
        private MMAppMgr appMgr;

        public Receiver(MMAppMgr mMAppMgr) {
            this.appMgr = mMAppMgr;
        }

        private static boolean ah(Intent intent) {
            if (intent.getBooleanExtra("process_is_mm", false) && intent.getIntExtra("process_id", 0) != Process.myPid()) {
                return false;
            }
            return true;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && !ap.yQ() && !ap.yS()) {
                String action = intent.getAction();
                if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(action)) {
                    if (ah(intent)) {
                        this.appMgr.f(intent, true);
                        this.appMgr.e(intent, true);
                        return;
                    }
                    w.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                } else if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(action)) {
                    if (ah(intent)) {
                        com.tencent.mm.booter.o.qg();
                        this.appMgr.f(intent, false);
                        this.appMgr.e(intent, false);
                        if (MMAppMgr.uUh != null && MMAppMgr.uUh.length() > 800) {
                            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ Receiver uUt;

                                {
                                    this.uUt = r1;
                                }

                                public final void run() {
                                    MMAppMgr.bQh();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    w.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                } else if ("com.tencent.mm.ui.ACTION_ABTEST".equals(action)) {
                    action = intent.getStringExtra("content");
                    if (bg.mA(action)) {
                        w.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
                    } else {
                        if (MMAppMgr.uUh == null) {
                            MMAppMgr.uUh = new StringBuffer(800);
                        }
                        MMAppMgr.uUh.append(action);
                        w.i("MicroMsg.MMAppMgr", "cpan content: %s", action);
                    }
                    if (MMAppMgr.uUh != null && MMAppMgr.uUh.length() > 800) {
                        new ae(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ Receiver uUt;

                            {
                                this.uUt = r1;
                            }

                            public final void run() {
                                MMAppMgr.bQh();
                            }
                        });
                    }
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE")) {
                    int intExtra;
                    if (intent.getBooleanExtra("intent_extra_is_silence_stat", false)) {
                        intExtra = intent.getIntExtra("intent_extra_opcode", 0);
                        w.d("MicroMsg.MMAppMgr", "silence_update_stat = " + intExtra);
                        if (ap.zb()) {
                            if (intExtra == 2) {
                                int intExtra2 = intent.getIntExtra("intent_extra_install_dialog_times", 0);
                                com.tencent.mm.plugin.report.service.g.oUh.i(11147, Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                            } else {
                                com.tencent.mm.plugin.report.service.g.oUh.i(11147, Integer.valueOf(intExtra));
                            }
                            if (intExtra == 4 && t.Nv() == 4) {
                                com.tencent.mm.pluginsdk.model.app.a bCQ = com.tencent.mm.pluginsdk.model.app.a.bCQ();
                                if (bCQ != null) {
                                    bCQ.bCS();
                                }
                            }
                        }
                    } else {
                        w.d("MicroMsg.MMAppMgr", "incremental_update = " + intent.getIntExtra("intent_extra_opcode", 0));
                        if (ap.zb()) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(10328, Integer.valueOf(intExtra));
                        }
                    }
                    long longExtra = intent.getLongExtra("intent_extra_flow_stat_upstream", 0);
                    long longExtra2 = intent.getLongExtra("intent_extra_flow_stat_downstream", 0);
                    boolean booleanExtra = intent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
                    if (!ap.zb()) {
                        return;
                    }
                    if (longExtra != 0 || longExtra2 != 0) {
                        w.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", Long.valueOf(longExtra), Long.valueOf(longExtra2), Boolean.valueOf(booleanExtra));
                        if (booleanExtra) {
                            com.tencent.mm.modelstat.m.s((int) longExtra2, (int) longExtra, 0);
                        } else {
                            com.tencent.mm.modelstat.m.t((int) longExtra2, (int) longExtra, 0);
                        }
                    }
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP")) {
                    MMAppMgr.a(context, true);
                } else if (intent.getAction().equals("MINIQB_OPEN_RET")) {
                    com.tencent.mm.pluginsdk.ui.tools.a.aa(intent);
                } else {
                    w.e("MicroMsg.MMAppMgr", "unknown broadcast action");
                }
            }
        }
    }

    public final void e(Intent intent, boolean z) {
        b miVar;
        String str;
        if (z) {
            com.tencent.mm.x.m.Bw();
            miVar = new mi();
            miVar.fTE.state = 1;
            com.tencent.mm.sdk.b.a.urY.m(miVar);
            miVar = new com.tencent.mm.e.a.e();
            miVar.fCm.fCn = true;
            com.tencent.mm.sdk.b.a.urY.m(miVar);
            miVar = new nb();
            miVar.fUk.fCp = true;
            com.tencent.mm.sdk.b.a.urY.m(miVar);
            miVar = new cj();
            miVar.fFP.state = 1;
            com.tencent.mm.sdk.b.a.urY.m(miVar);
        }
        miVar = new fl();
        miVar.fKb.fCF = z;
        com.tencent.mm.sdk.b.a.urY.m(miVar);
        this.uUl = z;
        String stringExtra = intent.getStringExtra("classname");
        if (bg.mA(stringExtra)) {
            str = "";
        } else {
            str = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        }
        z zVar;
        if (z) {
            zVar = z.gKE;
            if (zVar.gKK == -1) {
                if (zVar.gKF.yA(3) == 0) {
                    zVar.gKF.setLong(1, u.Ny());
                }
                zVar.gKK = u.Ny();
                String str2 = "MicroMsg.StayTimeReport";
                String str3 = "onAppResume chatUser:%s, class:%s";
                Object[] objArr = new Object[2];
                objArr[0] = zVar.gKG == null ? "null" : zVar.gKG.gKP;
                objArr[1] = str;
                w.i(str2, str3, objArr);
                if (zVar.gKG != null) {
                    zVar.gKH = u.NA();
                    if (str != null && str.contains("WebViewUI")) {
                        zVar.gKI = u.NA();
                    }
                }
            }
        } else {
            zVar = z.gKE;
            if (zVar.gKK != -1) {
                stringExtra = ((String) zVar.gKF.get(2, "")) + zVar.gKK + "|" + u.Ny() + "#";
                zVar.gKF.set(2, stringExtra);
                int yA = zVar.gKF.yA(3) + 1;
                zVar.gKF.setInt(3, yA);
                w.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", Integer.valueOf(yA), Long.valueOf(zVar.gKK), Long.valueOf(r4));
                zVar.gKK = -1;
                if (u.az(zVar.gKF.getLong(1, 0)) > 3600 * ((long) zVar.gKM) || yA > zVar.gKL) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(13110, stringExtra);
                    w.i("MicroMsg.StayTimeReport", "report appStayTime:%s", stringExtra);
                    zVar.gKF.set(2, "");
                    zVar.gKF.setInt(3, 0);
                }
                if (zVar.gKG != null) {
                    a aVar = zVar.gKG;
                    aVar.time += u.aB(zVar.gKH) / 1000;
                    if (str != null && str.contains("WebViewUI")) {
                        aVar = zVar.gKG;
                        aVar.gKT = (int) (((long) aVar.gKT) + (u.aB(zVar.gKI) / 1000));
                    }
                    w.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", Long.valueOf(zVar.gKG.time));
                }
            }
        }
        this.uUo.v(800, 800);
    }

    public final void f(Intent intent, boolean z) {
        String stringExtra = intent.getStringExtra("classname");
        if (bg.mA(stringExtra)) {
            w.i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
            return;
        }
        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        com.tencent.mm.sdk.a.b.Pa(stringExtra);
        if (uUh == null) {
            uUh = new StringBuffer(800);
            uUi = bg.Ny();
            uUh.append("start:");
            uUh.append(bg.Ny());
            uUh.append("|");
        }
        if (z) {
            if ("desktop".equals(this.uUj)) {
                uUh.append("desktop:");
                uUh.append(bg.aB(this.hTc) + 800);
                uUh.append("|");
            }
            this.hTc = bg.NA();
            this.uUj = stringExtra;
        } else {
            uUh.append(this.uUj + ":");
            uUh.append(bg.aB(this.hTc));
            uUh.append("|");
        }
        b fVar = new com.tencent.mm.e.a.f();
        fVar.fCo.fCp = z;
        fVar.fCo.className = stringExtra;
        com.tencent.mm.sdk.b.a.urY.m(fVar);
        w.i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", stringExtra, Boolean.valueOf(z));
    }

    public static void bQh() {
        StringBuffer stringBuffer = new StringBuffer(800);
        if (uUh == null) {
            uUh = stringBuffer;
            uUi = bg.Ny();
            return;
        }
        String stringBuffer2 = uUh.toString();
        stringBuffer.append(SG(stringBuffer2));
        uUh = stringBuffer;
        w.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", stringBuffer2);
        com.tencent.mm.plugin.report.service.g.oUh.A(10508, "1," + uUi + "," + stringBuffer2);
        uUi = bg.Ny();
    }

    private static String SG(String str) {
        int i = 0;
        int length = str.length() - 1;
        while (length >= 0) {
            if (str.charAt(length) == '|') {
                i++;
            }
            if (i == 3) {
                break;
            }
            length--;
        }
        return str.substring(length + 1);
    }

    public static void cancelNotification(String str) {
        ap.getNotification().cancelNotification(str);
    }

    public static void ox() {
        ap.getNotification().ox();
    }

    public static void Sk() {
        kv(true);
    }

    public static void kv(boolean z) {
        w.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bg.bJZ(), Boolean.valueOf(z));
        d.o(2, 0, "");
        if (z) {
            Context context = ab.getContext();
            if (context != null) {
                context.stopService(new Intent(context, CoreService.class));
                context.stopService(new Intent(context, NotifyService.class));
                context.stopService(new Intent(context, CacheService.class));
                context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"));
            }
        }
        com.tencent.mm.sdk.b.a.urY.m(new com.tencent.mm.e.a.w());
        b imVar = new im();
        imVar.fOk.status = 0;
        imVar.fOk.fOl = 2;
        com.tencent.mm.sdk.b.a.urY.m(imVar);
        bQh();
        if (z) {
            ap.eb(bg.bJZ().toString());
            h.vJ().releaseAll();
        }
        w.appenderClose();
        BaseEvent.onSingalCrash(0);
        Process.killProcess(Process.myPid());
    }

    public static void ai(Context context) {
        a(context, true);
    }

    public static void a(Context context, boolean z) {
        h.vJ().gYJ.gZg.ak(z);
        BaseEvent.onSingalCrash(0);
        MMNativeJpeg.Destroy();
        com.tencent.mm.booter.o.oA();
        if (!(ap.vd() == null || ap.vd().hsZ == null)) {
            ap.vd().hsZ.bb(z);
        }
        Intent intent = new Intent().setClass(context, LauncherUI.class);
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        intent.putExtra("kill_service", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public static boolean oK() {
        if (com.tencent.mm.protocal.d.sYQ) {
            return false;
        }
        if (!com.tencent.mm.bb.d.NC("whatsnew")) {
            w.i("MicroMsg.MMAppMgr", "plugin cannot load");
            return false;
        } else if (com.tencent.mm.plugin.ipcall.d.aDM()) {
            return true;
        } else {
            return false;
        }
    }

    public static void aa(Activity activity) {
        com.tencent.mm.bb.d.b(activity, "whatsnew", ".ui.WhatsNewUI", new Intent(), 57005);
    }

    public static void eA(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ab.bIX(), 0);
        if (!sharedPreferences.getBoolean("Main_ShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(R.l.ewg));
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(context.getPackageName(), ab.bIW() + ".ui.LauncherUI"));
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.g.icon));
            intent.putExtra("shortcut_icon_resource_id", R.g.icon);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            intent.putExtra("is_main_shortcut", true);
            com.tencent.mm.plugin.base.model.c.l(context, intent);
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("Main_ShortCut", true);
            edit.commit();
        }
    }

    public static void d(final Activity activity) {
        final SharedPreferences sharedPreferences = activity.getSharedPreferences(ab.bIX(), 0);
        boolean z = sharedPreferences.getBoolean("gprs_alert", true);
        com.tencent.mm.sdk.platformtools.f.usu &= z;
        if (z) {
            View inflate = View.inflate(activity, R.i.dfz, null);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.bVy);
            Dialog a = com.tencent.mm.ui.base.g.a((Context) activity, false, null, inflate, activity.getString(R.l.dXk), activity.getString(R.l.ezk), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (checkBox.isChecked()) {
                        Editor edit = sharedPreferences.edit();
                        edit.putBoolean("gprs_alert", false);
                        edit.commit();
                    }
                    com.tencent.mm.sdk.platformtools.f.usu = false;
                    dialogInterface.dismiss();
                    MMAppMgr.eA(activity);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MMAppMgr.a(activity, true);
                }
            });
            if (a != null) {
                a.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        activity.onKeyDown(4, new KeyEvent(0, 4));
                    }
                });
            }
        }
    }

    public static boolean a(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        View inflate = View.inflate(context, R.i.dkh, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cnb);
        checkBox.setText(context.getString(R.l.eDs));
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(16385, Boolean.valueOf(!z));
            }
        });
        inflate.findViewById(R.h.cnd).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.h.cnc);
        switch (i) {
            case 1:
                textView.setText(R.l.eDr);
                z = true;
                break;
            case 3:
                textView.setText(R.l.eDy);
                z = false;
                break;
            default:
                textView.setText(R.l.eDy);
                z = true;
                break;
        }
        if (!z) {
            return false;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.zW(R.l.dIO);
        aVar.kK(false);
        aVar.dd(inflate);
        aVar.zZ(R.l.eDv).a(onClickListener);
        aVar.Aa(R.l.eDs).b(onClickListener2);
        aVar.WJ().show();
        return true;
    }

    public static com.tencent.mm.ui.base.h aj(final Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (am.isWifi(context) && locationManager.isProviderEnabled("gps")) {
                return null;
            }
            ap.yY();
            Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(4105, Boolean.valueOf(false));
            if (bool != null && bool.booleanValue()) {
                return null;
            }
            View inflate = View.inflate(context, R.i.dgL, null);
            ((CheckBox) inflate.findViewById(R.h.caX)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(4105, Boolean.valueOf(true));
                        return;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(4105, Boolean.valueOf(false));
                }
            });
            OnClickListener anonymousClass7 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert", new Object[0]);
                    }
                }
            };
            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
            aVar.zW(R.l.eDb);
            aVar.dd(inflate);
            aVar.zZ(R.l.dID).a(anonymousClass7);
            aVar.Aa(R.l.dHy);
            com.tencent.mm.ui.base.h WJ = aVar.WJ();
            WJ.show();
            return WJ;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert error", new Object[0]);
            return null;
        }
    }
}
