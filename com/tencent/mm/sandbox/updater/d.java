package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.l;
import com.tencent.smtt.sdk.q;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.t;

public final class d implements a {
    private Intent intent = new Intent();
    Notification qXN = null;
    private a uqM = null;
    int uqN = 999;
    boolean uqO = false;
    private boolean uqP = false;

    private static final class b {
        public static final d uqR = new d();
    }

    private final class a implements q {
        final /* synthetic */ d uqQ;

        public a(d dVar) {
            this.uqQ = dVar;
        }

        public final void iu(int i) {
            w.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", Integer.valueOf(i));
            j.dJ(5, i);
            if (i != MMGIFException.D_GIF_ERR_CLOSE_FAILED) {
                if (i == 100) {
                    g.oUh.n(64, 64, 4, 3);
                } else {
                    g.oUh.a(64, 3, 1, false);
                }
            }
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                w.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
                Editor edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
        }

        public final void iv(int i) {
            w.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", Integer.valueOf(i));
            j.dJ(6, i);
            if (i == m.CTRL_INDEX || i == 220) {
                g.oUh.n(64, 64, 7, 6);
                d dVar = this.uqQ;
                if (dVar.uqO) {
                    String bk = bg.bk(ab.getContext());
                    w.i("MicroMsg.TBSDownloadMgr", "topActivityName = %s", bk);
                    if (bg.mA(bk) || !bk.equalsIgnoreCase("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                        ab.getContext().sendBroadcast(intent);
                        Context context = ab.getContext();
                        android.support.v4.app.y.d dVar2 = new android.support.v4.app.y.d(context);
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                        dVar2.L(com.tencent.mm.ba.a.bCk());
                        dVar2.a(context.getString(R.l.fmE));
                        dVar2.b(context.getString(R.l.fmD));
                        dVar2.j(2, false);
                        dVar2.o(true);
                        dVar2.rR = PendingIntent.getActivity(ab.getContext(), 0, new Intent(), 0);
                        dVar.qXN = dVar2.build();
                        notificationManager.notify(dVar.uqN, dVar.qXN);
                        intent = new Intent();
                        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        ab.getContext().sendBroadcast(intent);
                        return;
                    }
                    return;
                }
                return;
            }
            g.oUh.a(64, 6, 1, false);
        }

        public final void iw(int i) {
        }
    }

    static {
        TbsLog.setTbsLogClient(new t(ab.getContext()) {
            public final void qQ(String str) {
                w.i("TBSDownloadMgr.TbsLogClient", "TbsLogClient: " + str);
            }
        });
    }

    public static d bHV() {
        return b.uqR;
    }

    public final void jM(boolean z) {
        if (this.uqM == null) {
            w.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
            return;
        }
        Context context = ab.getContext();
        boolean atk = l.atk();
        boolean q = l.q(context, this.uqO | this.uqP);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        boolean cep = l.cep();
        w.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", Boolean.valueOf(z), Boolean.valueOf(atk), Boolean.valueOf(q), Boolean.valueOf(booleanExtra));
        if ((z || booleanExtra) && !atk && q) {
            bHW();
            j.mN(3);
        } else if (!z && !booleanExtra && atk && !cep) {
            l.stopDownload();
            j.mN(4);
        }
    }

    private void bHW() {
        l.fO(ab.getContext());
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            w.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", Boolean.valueOf(this.uqP), Boolean.valueOf(this.uqO));
            if (this.uqP || this.uqO) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
            }
        }
    }

    public final boolean ab(Intent intent) {
        this.intent = intent;
        this.uqO = this.intent.getIntExtra("intent_extra_download_type", 1) == 2;
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            this.uqP = sharedPreferences.getBoolean("tbs_download_oversea", false);
        }
        w.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", Boolean.valueOf(this.uqO), Boolean.valueOf(this.uqP));
        if (l.atk()) {
            w.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
            return true;
        }
        Context context = ab.getContext();
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        w.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", Integer.valueOf(tbsCoreVersion), Boolean.valueOf(l.q(context, this.uqO | this.uqP)), Boolean.valueOf(am.isWifi(context)), Boolean.valueOf(this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false)));
        if ((!am.isWifi(context) && !r5) || !r4) {
            return false;
        }
        if (this.uqM == null) {
            this.uqM = new a(this);
            QbSdk.setTbsListener(this.uqM);
            j.mN(2);
        }
        bHW();
        j.mN(3);
        return true;
    }

    public final boolean isBusy() {
        w.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", Boolean.valueOf(l.atk()), Boolean.valueOf(QbSdk.getTBSInstalling()));
        if (l.atk() || r3) {
            return true;
        }
        return false;
    }

    public final void onDestroy() {
        w.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    }
}
