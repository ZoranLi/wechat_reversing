package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.eo;
import com.tencent.mm.e.a.lg;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.h;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;

public final class b implements am {
    private a lrP;
    private b lrQ;
    public boolean lrR = false;
    private com.tencent.mm.sdk.e.m.b lrS = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ b lsa;

        {
            this.lsa = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            w.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
            if (!this.lsa.lrR) {
                ap.yY();
                if (mVar != c.wW()) {
                    return;
                }
                if (mVar == null || obj == null) {
                    w.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
                } else if (ab.getContext() == null || !ap.zb()) {
                    w.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
                } else {
                    this.lsa.ari();
                }
            }
        }
    };
    public boolean lrT = false;
    public long lrU = 0;
    private final long lrV = 300000;
    private final long lrW = 4000;
    private final String lrX = "fun1";
    public int lrY = 0;
    private ae lrZ = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ b lsa;

        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            if (ab.getContext() == null || !ap.zb()) {
                w.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
            } else if (this.lsa.arh()) {
                int arg = b.arg();
                if (arg > 0 || arg < this.lsa.lrY) {
                    w.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
                    Intent intent = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
                    intent.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
                    ab.getContext().sendBroadcast(intent);
                    this.lsa.lrY = arg;
                }
            }
        }
    };

    public static class a extends com.tencent.mm.sdk.b.c<eo> {
        public a() {
            this.usg = eo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eo eoVar = (eo) bVar;
            if (eoVar instanceof eo) {
                ExtControlProviderQLauncher extControlProviderQLauncher = new ExtControlProviderQLauncher(eoVar.fIr.fCt, eoVar.fIr.fIt, eoVar.fIr.context);
                eoVar.fIs.fIu = extControlProviderQLauncher.query(eoVar.fIr.uri, null, null, eoVar.fIr.selectionArgs, null);
                return true;
            }
            w.f("MicroMsg.SubCoreExtQLauncher", "mismatched event");
            return false;
        }
    }

    private class b extends com.tencent.mm.sdk.b.c<lg> {
        final /* synthetic */ b lsa;

        private b(b bVar) {
            this.lsa = bVar;
            this.usg = lg.class.getName().hashCode();
        }

        /* synthetic */ b(b bVar, byte b) {
            this(bVar);
            this.usg = lg.class.getName().hashCode();
        }

        private boolean a(lg lgVar) {
            if (!this.lsa.arh()) {
                w.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
                return false;
            } else if (ab.getContext() == null) {
                w.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
                return false;
            } else {
                w.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[]{Integer.valueOf(lgVar.fRY.fRW), lgVar.fRY.scanResult});
                try {
                    switch (lgVar.fRY.fRW) {
                        case 0:
                            if (bg.mA(lgVar.fRY.scanResult) || !lgVar.fRY.scanResult.startsWith("qlauncher://")) {
                                return false;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
                            intent.setData(Uri.parse(lgVar.fRY.scanResult));
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            ab.getContext().startActivity(intent);
                            lgVar.fRZ.ret = 1;
                            return true;
                        default:
                            return false;
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[]{e.getMessage()});
                    return false;
                }
            }
        }
    }

    public static b arf() {
        b bVar = (b) ap.yR().gs("plugin.extqlauncher");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        ap.yR().a("plugin.extqlauncher", bVar2);
        return bVar2;
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        ap.yY();
        c.wW().a(this.lrS);
        if (this.lrP == null) {
            this.lrP = new a();
        }
        com.tencent.mm.sdk.b.a.urY.b(this.lrP);
        if (this.lrQ == null) {
            this.lrQ = new b();
        }
        com.tencent.mm.sdk.b.a.urY.b(this.lrQ);
    }

    public final void onAccountRelease() {
        if (this.lrP != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.lrP);
        }
        if (this.lrQ != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.lrQ);
        }
        ap.yY();
        c.wW().b(this.lrS);
        this.lrZ.removeMessages(0);
    }

    public static int arg() {
        if (ap.zb()) {
            int fM = p.fM(o.hlr);
            int xI = h.xI();
            if ((com.tencent.mm.u.m.xP() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
                return fM - xI;
            }
            return fM;
        }
        w.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
        return 0;
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final boolean arh() {
        if (ab.getContext() == null) {
            w.w("MicroMsg.SubCoreExtQLauncher", "isPluginInstall, ApplicationContext null");
            this.lrT = false;
            return false;
        } else if (System.currentTimeMillis() - this.lrU < 300000) {
            return this.lrT;
        } else {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ b lsa;

                {
                    this.lsa = r1;
                }

                public final void run() {
                    try {
                        this.lsa.lrU = System.currentTimeMillis();
                        List installedApplications = ab.getContext().getPackageManager().getInstalledApplications(FileUtils.S_IWUSR);
                        if (installedApplications == null) {
                            w.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
                            this.lsa.lrT = false;
                            return;
                        }
                        for (int i = 0; i < installedApplications.size(); i++) {
                            ApplicationInfo applicationInfo = (ApplicationInfo) installedApplications.get(i);
                            if (applicationInfo != null && ((bg.mz(applicationInfo.packageName).startsWith("com.tencent.qlauncher") || bg.mz(applicationInfo.packageName).startsWith("com.tencent.qqlauncher") || bg.mz(applicationInfo.packageName).startsWith("com.tencent.launcher")) && applicationInfo.metaData != null)) {
                                String string = applicationInfo.metaData.getString("qlauncher_wx_coop");
                                if (string == null || string.length() <= 0) {
                                    w.w("MicroMsg.SubCoreExtQLauncher", "qlauncher_wx_coop not found, %s, costTime = %s", new Object[]{applicationInfo.packageName, Long.valueOf(System.currentTimeMillis() - this.lsa.lrU)});
                                    this.lsa.lrT = false;
                                } else {
                                    String[] split = string.split(",");
                                    if (split != null) {
                                        for (String mz : split) {
                                            if (bg.mz(mz).trim().equalsIgnoreCase("fun1")) {
                                                w.d("MicroMsg.SubCoreExtQLauncher", "founded qlauncher, %s", new Object[]{applicationInfo.packageName});
                                                this.lsa.lrT = true;
                                                return;
                                            }
                                        }
                                    }
                                    this.lsa.lrT = false;
                                }
                            }
                        }
                        w.d("MicroMsg.SubCoreExtQLauncher", "qlauncher not founded, costTime = %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.lsa.lrU)});
                    } catch (Exception e) {
                        w.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", new Object[]{e.getMessage()});
                        this.lsa.lrT = false;
                    }
                }

                public final String toString() {
                    return super.toString() + "|isPluginInstall";
                }
            });
            return this.lrT;
        }
    }

    public final void ari() {
        this.lrZ.removeMessages(0);
        this.lrZ.sendEmptyMessageDelayed(0, 4000);
    }
}
