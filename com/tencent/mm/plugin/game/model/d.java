package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static BroadcastReceiver moW = null;
    private static boolean moX = false;
    public static int moY = -1;
    private static ae moZ = new ae(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    int netType = am.getNetType(ab.getContext());
                    if (aVar != null && netType == 0) {
                        boolean aW = e.akM().aW(aVar.fCw);
                        if (!aW) {
                            e.akM().aT(aVar.fCw);
                            if (aVar.mpa != null) {
                                d.b(aVar.mpa);
                            }
                        }
                        w.i("MicroMsg.GameAutoDownloader", "resumeTask, ret = " + aW);
                        return;
                    }
                    return;
                case 2:
                    if (aVar != null) {
                        e.akM().aT(aVar.fCw);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    private static class a {
        long fCw;
        q mpa;
    }

    private static class b extends BroadcastReceiver {
        private b() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (!ap.zb() || ap.uP()) {
                w.e("MicroMsg.GameAutoDownloader", "acc has not ready");
                return;
            }
            int netType = am.getNetType(ab.getContext());
            if (netType != d.moY) {
                d.moY = netType;
                w.i("MicroMsg.GameAutoDownloader", "onNetStateChange, netState = " + netType);
                LinkedList aAV = SubCoreGameCenter.aBB().aAV();
                if (!bg.bV(aAV)) {
                    d.M(aAV);
                    Iterator it;
                    q qVar;
                    if (netType == 0) {
                        it = aAV.iterator();
                        while (it.hasNext()) {
                            qVar = (q) it.next();
                            qVar.aAN();
                            d.a(qVar, false);
                        }
                        return;
                    }
                    it = aAV.iterator();
                    while (it.hasNext()) {
                        qVar = (q) it.next();
                        qVar.aAN();
                        d.c(qVar);
                    }
                }
            }
        }
    }

    public static void aAz() {
        if (moW == null) {
            moW = new b();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ab.getContext().registerReceiver(moW, intentFilter);
            moX = true;
        } catch (Exception e) {
            w.e("MicroMsg.GameAutoDownloader", e.getMessage());
            moX = false;
        }
    }

    public static void aAA() {
        if (moW != null) {
            try {
                ab.getContext().unregisterReceiver(moW);
            } catch (Exception e) {
                w.e("MicroMsg.GameAutoDownloader", e.getMessage());
            }
        }
        moW = null;
        moX = false;
    }

    public static void a(q qVar) {
        qVar.aAN();
        if (qVar.mqc == 0) {
            int i = 0;
        } else {
            boolean z = true;
        }
        if (i == 0) {
            FileDownloadTaskInfo tI = e.akM().tI(qVar.field_appId);
            w.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(tI.id), Integer.valueOf(tI.status)});
            if (tI.id > 0) {
                e.akM().aT(tI.id);
            }
            SubCoreGameCenter.aBB().a(qVar, new String[0]);
            return;
        }
        a(qVar, true);
    }

    public static void b(q qVar) {
        if (!ap.zb()) {
            w.e("MicroMsg.GameAutoDownloader", "MMCore is not ready");
        } else if (ap.uP()) {
            w.e("MicroMsg.GameAutoDownloader", "MMCore.isHold() = " + ap.uP());
        } else {
            boolean z;
            int i = qVar.mpM;
            ap.yY();
            if (!c.isSDCardAvailable()) {
                w.e("MicroMsg.GameAutoDownloader", "sdCard is not available");
                z = false;
            } else if (f.G((long) i)) {
                z = true;
            } else {
                w.e("MicroMsg.GameAutoDownloader", "sdCard have not enough space, need size = " + i);
                z = false;
            }
            if (!z) {
                return;
            }
            if (bg.mA(qVar.mpK) || bg.mA(qVar.mpL) || bg.mA(qVar.field_appId)) {
                w.e("MicroMsg.GameAutoDownloader", "mAppDownloadURL = %s, mAppMD5 = %s, appId = %s", new Object[]{qVar.mpK, qVar.mpL, qVar.field_appId});
                return;
            }
            com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(qVar.field_appId, true);
            if (aJ == null) {
                w.e("MicroMsg.GameAutoDownloader", "appInfo = null");
                return;
            }
            w.i("MicroMsg.GameAutoDownloader", "startDownloadTask, appid = %s, url = %s, md5 = %s", new Object[]{qVar.field_appId, qVar.mpK, qVar.mpL});
            com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
            aVar.tL(qVar.mpK);
            aVar.setAppId(qVar.field_appId);
            aVar.bl(aJ.field_packageName);
            aVar.tN(g.a(ab.getContext(), aJ, null));
            aVar.tO(qVar.mpL);
            aVar.dn(false);
            aVar.do(false);
            aVar.la(1);
            aVar.dp(true);
            long a = e.akM().a(aVar.kHa);
            w.i("MicroMsg.GameAutoDownloader", "startDownloadTask id = " + a);
            if (a > 0) {
                l.a(qVar.mpK, qVar.mpL, 1999, qVar.field_appId, null, null);
            }
        }
    }

    public static void a(q qVar, boolean z) {
        if (bg.mA(qVar.field_appId)) {
            w.e("MicroMsg.GameAutoDownloader", "appid = " + qVar.field_appId);
            return;
        }
        w.i("MicroMsg.GameAutoDownloader", "addDownloadTask, appid = %s, initDownload = %s", new Object[]{qVar.field_appId, Boolean.valueOf(z)});
        FileDownloadTaskInfo tI = e.akM().tI(qVar.field_appId);
        if (tI == null) {
            return;
        }
        if (g.n(ab.getContext(), qVar.field_appId)) {
            SubCoreGameCenter.aBB().a(qVar, new String[0]);
            w.i("MicroMsg.GameAutoDownloader", "app is installed, appid = " + qVar.field_appId);
            return;
        }
        w.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(tI.id), Integer.valueOf(tI.status)});
        switch (tI.status) {
            case 0:
            case 4:
            case 5:
                if (am.getNetType(ab.getContext()) == 0 && moX) {
                    b(qVar);
                    return;
                }
                return;
            case 1:
                if (z && !tI.kHg) {
                    SubCoreGameCenter.aBB().a(qVar, new String[0]);
                    return;
                }
                return;
            case 2:
                if (!z || tI.kHg) {
                    Message message = new Message();
                    message.what = 1;
                    a aVar = new a();
                    aVar.fCw = tI.id;
                    aVar.mpa = qVar;
                    message.obj = aVar;
                    moZ.sendMessageDelayed(message, 2000);
                    return;
                }
                SubCoreGameCenter.aBB().a(qVar, new String[0]);
                return;
            case 3:
                SubCoreGameCenter.aBB().a(qVar, new String[0]);
                return;
            default:
                return;
        }
    }

    public static void c(q qVar) {
        FileDownloadTaskInfo tI = e.akM().tI(qVar.field_appId);
        if (tI != null) {
            w.i("MicroMsg.GameAutoDownloader", "pauseDownloadTask, downloadId = %d, status = %d", new Object[]{Long.valueOf(tI.id), Integer.valueOf(tI.status)});
            if (tI.status == 1) {
                boolean aV = e.akM().aV(tI.id);
                if (!aV) {
                    e.akM().aT(tI.id);
                }
                w.i("MicroMsg.GameAutoDownloader", "pauseDownloadTask ret = " + aV);
            }
        }
    }

    public static void M(LinkedList<q> linkedList) {
        Object linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (qVar.field_expireTime <= System.currentTimeMillis() / 1000) {
                w.i("MicroMsg.GameAutoDownloader", "expireTime expireTime = %d, currentTime = %d, appid = %s", new Object[]{Long.valueOf(qVar.field_expireTime), Long.valueOf(System.currentTimeMillis() / 1000), qVar.field_appId});
                FileDownloadTaskInfo tI = e.akM().tI(qVar.field_appId);
                if (tI != null) {
                    w.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(tI.id), Integer.valueOf(tI.status)});
                    if (tI.id > 0) {
                        Message message = new Message();
                        message.what = 2;
                        a aVar = new a();
                        aVar.fCw = tI.id;
                        aVar.mpa = qVar;
                        message.obj = aVar;
                        moZ.sendMessageDelayed(message, 2000);
                    }
                    SubCoreGameCenter.aBB().a(qVar, new String[0]);
                    linkedList2.add(qVar);
                } else {
                    return;
                }
            }
        }
        if (!bg.bV(linkedList2)) {
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                linkedList.remove((q) it2.next());
            }
        }
    }
}
