package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.b.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.f.AnonymousClass3;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class j implements a, g {
    public String desc;
    public String fFW;
    public int fNd;
    public int fuX;
    public String fuZ;
    public byte[] htN;
    public byte[] idY;
    public byte[] iea;
    private Intent intent;
    protected Context mContext;
    private Notification qXN;
    public int qvw;
    public int size;
    public int uin;
    public int upV;
    public String[] uqx;
    public boolean urA;
    long urB;
    public f urC;
    private long urD;
    private com.tencent.mm.sandbox.b.a urE;
    public c urp;
    ArrayList<g> urq;
    public String[] urr;
    public String urs;
    public i urt;
    public com.tencent.mm.b.i.a uru;
    public boolean urv;
    public boolean urw;
    public boolean urx;
    public String ury;
    public boolean urz;

    private static final class a {
        public static final j urH = new j();
    }

    public j() {
        this.urp = null;
        this.urq = new ArrayList(1);
        this.fNd = d.sYN;
        this.urv = false;
        this.urw = false;
        this.urx = false;
        this.urz = false;
        this.urA = false;
        this.intent = null;
        this.qXN = null;
        this.mContext = null;
        this.urC = new f(this);
        this.urD = -1;
        this.urE = new com.tencent.mm.sandbox.b.a(this) {
            final /* synthetic */ j urG;

            {
                this.urG = r1;
            }

            public final void cx(int i, int i2) {
                w.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.urG.qvw != 2) {
                    this.urG.dL(i2, i);
                }
                this.urG.cx(i, i2);
            }

            public final void a(int i, int i2, avp com_tencent_mm_protocal_c_avp) {
                this.urG.urA = false;
                this.urG.urC.stop();
                this.urG.urB = System.currentTimeMillis();
                if (this.urG.urp == null) {
                    this.urG.ad(2, true);
                } else if (i == m.CTRL_INDEX && i2 == 0) {
                    w.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
                    if (this.urG.qvw != 2) {
                        this.urG.dL(100, 100);
                    }
                    if (this.urG.urv) {
                        i.X(this.urG.mContext, 0);
                    } else {
                        i.X(this.urG.mContext, 9);
                    }
                    this.urG.urs = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "yyb_pkg_sig_prefs", 4).getString(ab.getPackageName(), "");
                    w.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", this.urG.urs, this.urG.urp.bHM());
                    if (bg.mA(this.urG.urs)) {
                        g.oUh.a(322, 8, 1, false);
                        g.oUh.i(11098, Integer.valueOf(4008));
                    } else {
                        try {
                            com.tencent.mm.b.c.a(new File(this.urG.urp.bHM()), this.urG.urs);
                            w.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
                            g.oUh.a(322, 6, 1, false);
                            g.oUh.i(11098, Integer.valueOf(4006), this.urG.urs);
                        } catch (Exception e) {
                            w.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + e.getMessage());
                            g.oUh.a(322, 7, 1, false);
                            g.oUh.i(11098, Integer.valueOf(4007), e.getMessage());
                        }
                    }
                    if (this.urG.qvw == 1) {
                        i.Y(this.urG.mContext, 8);
                        this.urG.bIo();
                        this.urG.FW(this.urG.urp.bHM());
                        if (this.urG.urz) {
                            g.oUh.a(614, 58, 1, false);
                        }
                    } else if (this.urG.qvw == 0) {
                        this.urG.FW(this.urG.urp.bHM());
                    } else if (this.urG.qvw == 2) {
                        i.Y(this.urG.mContext, 1);
                        this.urG.bIo();
                    }
                    i.bIg();
                } else if (i2 == -13) {
                    w.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
                    UpdaterService.cj();
                    AppUpdaterUI.bHQ();
                    i.bIf();
                } else {
                    if (!(this.urG.urp instanceof c) || this.urG.upV == 4) {
                        w.e("MicroMsg.UpdaterManager", "update failed");
                        i.X(this.urG.mContext, 10);
                        if (this.urG.qvw == 1) {
                            this.urG.bIl();
                        } else if (this.urG.qvw == 0) {
                            this.urG.ad(1, true);
                        }
                    } else {
                        w.e("MicroMsg.UpdaterManager", "download package from cdn error.");
                        if (this.urG.urv) {
                            if (i == 3 || i == 4 || i == 2 || i == 1 || i == 13) {
                                i.X(this.urG.mContext, i);
                            }
                            this.urG.urv = false;
                            if (this.urG.qvw == 1) {
                                if (this.urG.urz) {
                                    switch (i) {
                                        case 1:
                                            g.oUh.a(614, 51, 1, false);
                                            break;
                                        case 2:
                                            g.oUh.a(614, 54, 1, false);
                                            break;
                                        case 3:
                                            g.oUh.a(614, 52, 1, false);
                                            break;
                                        case 4:
                                            g.oUh.a(614, 53, 1, false);
                                            break;
                                        case 13:
                                            g.oUh.a(614, 55, 1, false);
                                            break;
                                    }
                                }
                                this.urG.bIm();
                            } else if (this.urG.qvw == 0) {
                                this.urG.ad(1, true);
                            } else if (this.urG.qvw == 2) {
                                this.urG.bIp();
                            }
                        } else {
                            this.urG.urp = new b(this.urG.size, this.urG.fFW, this.urG.upV, this.urG.uin, this.urG.idY, this.urG.htN, this.urG.urr, this.urG.qvw == 2);
                            this.urG.bIn();
                        }
                    }
                    this.urG.a(this.urG.urp);
                }
            }

            public final void eq(long j) {
                f fVar = this.urG.urC;
                fVar.fyI.post(new com.tencent.mm.sandbox.updater.f.AnonymousClass2(fVar, j));
            }

            public final void er(long j) {
                f fVar = this.urG.urC;
                fVar.fyI.post(new AnonymousClass3(fVar, j));
            }
        };
        this.mContext = ab.getContext();
    }

    public final void jM(boolean z) {
        w.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", Boolean.valueOf(z));
        f fVar = this.urC;
        if (fVar.lFS != z) {
            fVar.jN(true);
            fVar.lFS = z;
        }
        if (this.qvw != 2 || this.urA) {
            w.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", Integer.valueOf(this.qvw), Boolean.valueOf(this.urA));
        } else if (z) {
            if (ac(this.intent)) {
                jO(true);
            }
        } else if (this.urA) {
            cancel();
        }
    }

    public final boolean ab(Intent intent) {
        boolean ac = ac(intent);
        w.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", Boolean.valueOf(ac));
        if (ac) {
            jO(false);
        }
        return ac;
    }

    public final boolean ac(Intent intent) {
        w.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
        if (intent == null) {
            w.i("MicroMsg.UpdaterManager", "intent == null");
            return false;
        }
        int intExtra = intent.getIntExtra("intent_update_type", 3);
        int intExtra2 = intent.getIntExtra("intent_extra_download_mode", 1);
        String stringExtra = intent.getStringExtra("intent_extra_md5");
        if (this.urA && !stringExtra.equalsIgnoreCase(this.fFW) && this.qvw == 2) {
            cancel();
        } else if (this.urA) {
            w.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
            return true;
        }
        i.bIg();
        reset();
        this.intent = intent;
        this.fuX = intent.getIntExtra("intent_extra_updateMode", 0);
        this.fuZ = intent.getStringExtra("intent_extra_marketUrl");
        this.urr = intent.getStringArrayExtra("intent_short_ips");
        this.fNd = intent.getIntExtra("intent_client_version", d.sYN);
        d.sYN = this.fNd;
        this.upV = intExtra;
        this.idY = intent.getByteArrayExtra("intent_extra_session");
        this.htN = intent.getByteArrayExtra("intent_extra_cookie");
        this.iea = intent.getByteArrayExtra("intent_extra_ecdhkey");
        this.uin = intent.getIntExtra("intent_extra_uin", 0);
        this.fFW = stringExtra;
        this.desc = intent.getStringExtra("intent_extra_desc");
        this.size = intent.getIntExtra("intent_extra_size", 0);
        this.uqx = intent.getStringArrayExtra("intent_extra_download_url");
        this.qvw = intExtra2;
        this.urx = intent.getBooleanExtra("intent_extra_force_download_full", false);
        String stringExtra2 = intent.getStringExtra("intent_extra_patchInfo");
        if (stringExtra2 != null) {
            w.i("MicroMsg.UpdaterManager", "patchXml != null");
            this.urt = i.bc(stringExtra2);
        }
        stringExtra2 = intent.getStringExtra("intent_extra_extinfo");
        w.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", stringExtra2);
        if (!bg.mA(stringExtra2)) {
            this.ury = (String) bh.q(stringExtra2, "extinfo").get(".extinfo.notautodownloadrange");
            w.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", this.ury);
        }
        w.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", Integer.valueOf(intExtra2), Boolean.valueOf(this.urA));
        if (intExtra != 999 || this.uqx == null || this.uqx.length <= 0) {
            if (this.uqx != null) {
                for (String str : this.uqx) {
                    w.i("MicroMsg.UpdaterManager", "download url : " + str);
                }
            }
            w.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", stringExtra, Integer.valueOf(this.size));
            if (stringExtra == null || this.size == 0) {
                return false;
            }
            if (intExtra == 2) {
                w.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", Boolean.valueOf(b.iT(this.ury)));
                if (b.iT(this.ury)) {
                    g.oUh.a(405, 78, 1, true);
                    return false;
                }
            }
            if (this.urt != null) {
                w.i("MicroMsg.UpdaterManager", "patchInfo != null");
                stringExtra2 = i.dS(this.mContext);
                this.uru = this.urt.bb(stringExtra2);
                w.i("MicroMsg.UpdaterManager", "increase apkMD5 = " + stringExtra2 + " : " + (this.uru == null ? "not match" : "match"));
            }
            w.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", Boolean.valueOf(this.urx));
            this.urz = intent.getBooleanExtra("intent_extra_tinker_patch", false);
            if ((this.uru == null || c.OW(stringExtra)) && !this.urz) {
                w.i("MicroMsg.UpdaterManager", "had try to download full pack.");
            } else {
                w.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
                this.urv = true;
            }
            stringExtra2 = i.Nu();
            if (bg.mA(stringExtra2) || stringExtra2.equals(stringExtra)) {
                return true;
            }
            i.bIh();
            return true;
        } else if (intExtra2 != 2) {
            return true;
        } else {
            w.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
            return true;
        }
    }

    public final void bIj() {
        jO(false);
    }

    private void jO(boolean z) {
        boolean z2 = true;
        w.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", Boolean.valueOf(z));
        w.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", Integer.valueOf(this.qvw), Boolean.valueOf(this.urA));
        if (this.intent == null) {
            w.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
        } else if (this.urA) {
            w.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
        } else if (h.getExternalStorageState().equals("mounted")) {
            if (this.qvw == 2 && !z) {
                i.Y(this.mContext, 0);
            }
            String DE = c.DE(this.fFW);
            w.i("MicroMsg.UpdaterManager", DE);
            if (DE != null) {
                w.i("MicroMsg.UpdaterManager", "update package already exist.");
                ad(1, true);
                FW(DE);
                if (this.qvw == 2 && !i.OY(this.fFW)) {
                    i.a(this.fFW, this.urs, this.desc, this.size, this.qvw, this.upV, this.ury);
                    return;
                }
                return;
            }
            if (this.urx) {
                if (this.urp != null) {
                    this.urp.deleteTempFile();
                }
                i.X(this.mContext, 11);
            }
            if (!this.urx && this.urv && this.urt != null && this.uru != null) {
                w.i("MicroMsg.UpdaterManager", "Incresment Update");
                i.X(this.mContext, 5);
                if (f.G((long) (this.size + this.uru.size))) {
                    cancel();
                    int i = this.uru.size;
                    String str = this.fFW;
                    int i2 = this.upV;
                    String str2 = this.urt.fvk + this.uru.url;
                    String str3 = this.uru.fvo;
                    String str4 = this.uru.fvn;
                    if (this.qvw != 2) {
                        z2 = false;
                    }
                    this.urp = new c(i, str, i2, str2, str3, str4, z2);
                    bIn();
                    return;
                }
                bIk();
            } else if (f.G((long) this.size)) {
                bIp();
            } else {
                w.e("MicroMsg.UpdaterManager", "SDCard is full");
                bIk();
            }
        } else {
            w.e("MicroMsg.UpdaterManager", "no sdcard.");
            MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bg.Ny() - 86400).commit();
            ad(2, true);
            bHS();
        }
    }

    public final void ad(final int i, boolean z) {
        this.urw = z;
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ j urG;

            public final void run() {
                ((NotificationManager) this.urG.mContext.getSystemService("notification")).cancel(99);
                w.d("MicroMsg.UpdaterManager", "finishType == " + i);
                if (i == 2 && this.urG.upV == 1) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
                    this.urG.mContext.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                }
            }
        }, 300);
    }

    public final void cancel() {
        if (this.urp != null) {
            this.urA = false;
            this.urp.cancel();
            this.urp = null;
            this.urB = System.currentTimeMillis();
            this.urC.stop();
        }
    }

    private void reset() {
        cancel();
        this.fuX = 0;
        this.fuZ = null;
        this.urr = null;
        this.fNd = d.sYN;
        this.upV = 0;
        this.idY = null;
        this.htN = null;
        this.iea = null;
        this.uin = 0;
        this.fFW = null;
        this.size = 0;
        this.desc = null;
        this.uqx = null;
        this.urt = null;
        this.uru = null;
        this.urv = false;
        this.urw = false;
        this.qvw = 0;
        this.urx = false;
        this.intent = null;
        this.urA = false;
        this.qXN = null;
        this.urD = 0;
    }

    private void bIk() {
        MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bg.Ny() - 86400).commit();
        ad(2, true);
        bHT();
    }

    public final void bIl() {
        CharSequence string = this.mContext.getString(R.l.dGH);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.qXN = new Builder(this.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(null).setContentIntent(PendingIntent.getActivity(this.mContext, 0, intent, 134217728)).getNotification();
        this.qXN.icon = R.g.bkV;
        Notification notification = this.qXN;
        notification.flags |= 16;
        ((NotificationManager) this.mContext.getSystemService("notification")).notify(99, this.qXN);
    }

    public final void bIm() {
        w.i("MicroMsg.UpdaterManager", "showDownloadFullPackNotification()");
        CharSequence string = this.mContext.getString(R.l.dGI, new Object[]{bg.ay((long) this.size)});
        Intent intent = this.intent;
        intent.putExtra("intent_extra_force_download_full", true);
        this.qXN = new Builder(this.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(null).setContentIntent(PendingIntent.getService(this.mContext, 0, intent, 134217728)).getNotification();
        this.qXN.icon = R.g.bkV;
        Notification notification = this.qXN;
        notification.flags |= 16;
        ((NotificationManager) this.mContext.getSystemService("notification")).notify(99, this.qXN);
    }

    public final void dL(int i, int i2) {
        CharSequence string = this.mContext.getString(R.l.dGG);
        CharSequence charSequence;
        Intent intent;
        Builder contentIntent;
        if (i < i2) {
            long j = (((long) i) * 100) / ((long) i2);
            if (j - this.urD >= 1) {
                this.urD = j;
                charSequence = this.mContext.getString(R.l.dGJ) + String.valueOf(this.urD) + "%";
                intent = new Intent(this.intent);
                intent.setClass(this.mContext, AppUpdaterUI.class);
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                contentIntent = new Builder(this.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(this.mContext, 0, intent, 134217728));
                contentIntent.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bkV));
                contentIntent.setSmallIcon(com.tencent.mm.ba.a.bCk());
                this.qXN = contentIntent.getNotification();
                this.qXN.icon = R.g.bkV;
            } else {
                return;
            }
        } else if (!this.urz || e.aO(this.urp.bHM())) {
            charSequence = this.mContext.getString(R.l.dGF);
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.urp.bHM())), "application/vnd.android.package-archive");
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            contentIntent = new Builder(this.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(this.mContext, 0, intent, 134217728));
            contentIntent.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bkV));
            contentIntent.setSmallIcon(com.tencent.mm.ba.a.bCk());
            this.qXN = contentIntent.getNotification();
            this.qXN.icon = R.g.bkV;
            Notification notification = this.qXN;
            notification.flags |= 16;
        } else {
            w.i("MicroMsg.UpdaterManager", "do noting. wait for merge apk.");
        }
        if (!this.urw) {
            ((NotificationManager) this.mContext.getSystemService("notification")).notify(99, this.qXN);
        }
    }

    public final void bIn() {
        if (this.qvw == 2 && !am.isWifi(this.mContext)) {
            i.bIe();
            w.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
        } else if (this.qvw == 2 && f.OX(this.fFW)) {
            w.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
            this.urC.stop();
        } else {
            this.urC.cy(this.fFW, this.size);
            if (this.urp != null) {
                ad(1, false);
                this.urA = true;
                this.urp.a(this.urE);
                bgn();
                if (this.qvw == 2) {
                    i.bIe();
                }
            }
        }
    }

    public final void bIo() {
        i.a(this.fFW, this.urs, this.desc, this.size, this.qvw, this.upV, this.ury);
    }

    public final void bIp() {
        cancel();
        w.i("MicroMsg.UpdaterManager", "downloadFullPack");
        i.X(this.mContext, 7);
        if (this.uqx == null || this.uqx.length <= 0) {
            this.urp = new b(this.size, this.fFW, this.upV, this.uin, this.idY, this.htN, this.urr, this.qvw == 2);
            g.oUh.a(405, 77, 1, true);
        } else {
            this.urp = new c(this.size, this.fFW, this.upV, this.uqx, this.qvw == 2);
            g.oUh.a(405, 76, 1, true);
        }
        bIn();
    }

    public final void cx(int i, int i2) {
        Iterator it = this.urq.iterator();
        while (it.hasNext()) {
            ((g) it.next()).cx(i, i2);
        }
    }

    public final void bgn() {
        Iterator it = this.urq.iterator();
        while (it.hasNext()) {
            ((g) it.next()).bgn();
        }
    }

    public final void FW(String str) {
        Iterator it = this.urq.iterator();
        while (it.hasNext()) {
            ((g) it.next()).FW(str);
        }
    }

    public final void a(c cVar) {
        Iterator it = this.urq.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(cVar);
        }
    }

    public final void bHS() {
        Iterator it = this.urq.iterator();
        while (it.hasNext()) {
            ((g) it.next()).bHS();
        }
    }

    public final void bHT() {
        Iterator it = this.urq.iterator();
        while (it.hasNext()) {
            ((g) it.next()).bHT();
        }
    }

    public final boolean isBusy() {
        if (this.urA || System.currentTimeMillis() - this.urB <= UpdaterService.urK) {
            w.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", Boolean.valueOf(this.urA), Long.valueOf(this.urB), Long.valueOf(System.currentTimeMillis() - this.urB));
            return true;
        }
        w.i("MicroMsg.UpdaterManager", "not busy");
        return false;
    }

    public final void onDestroy() {
        w.i("MicroMsg.UpdaterManager", "onDestroy");
        if (!this.urA) {
            reset();
            ad(1, true);
        }
    }
}
