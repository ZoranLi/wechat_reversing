package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class l implements m, ITMQQDownloaderOpenSDKListener {
    private static l mpq = null;
    private static BroadcastReceiver mpr = null;
    public static Set<b> mps = Collections.synchronizedSet(new HashSet());
    public static HashMap<String, c> mpt = new HashMap();
    private static Map<Long, Long> mpu = new HashMap();

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                String action = intent.getAction();
                w.i("MicroMsg.GameInstallationReceiver", action);
                if (bg.mA(action)) {
                    w.e("MicroMsg.GameInstallationReceiver", "action is null or nill, ignore");
                } else if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                    action = "";
                    try {
                        action = intent.getDataString();
                    } catch (Throwable e) {
                        w.e("MicroMsg.GameInstallationReceiver", "%s", new Object[]{bg.g(e)});
                    }
                    w.i("MicroMsg.GameInstallationReceiver", "get added package name : %s", new Object[]{action});
                    if (bg.mA(action)) {
                        w.e("MicroMsg.GameInstallationReceiver", "get installed broadcast, while the package name is null or nil");
                        return;
                    }
                    if (action.startsWith("package:")) {
                        action = action.substring(8);
                    }
                    if (!ap.zb() || ap.uP()) {
                        w.e("MicroMsg.GameInstallationReceiver", "no user login");
                    } else if (ap.yY() != null) {
                        com.tencent.mm.plugin.downloader.b.a aVar;
                        com.tencent.mm.plugin.downloader.b.b wX = com.tencent.mm.u.c.wX();
                        if (bg.mA(action)) {
                            w.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
                            aVar = null;
                        } else {
                            Cursor rawQuery = wX.rawQuery("select * from FileDownloadInfo where packageName='" + action + "' order by downloadId desc limit 1", new String[0]);
                            if (rawQuery == null) {
                                aVar = null;
                            } else {
                                com.tencent.mm.plugin.downloader.b.a aVar2 = null;
                                if (rawQuery.moveToFirst()) {
                                    aVar2 = new com.tencent.mm.plugin.downloader.b.a();
                                    aVar2.b(rawQuery);
                                }
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                aVar = aVar2;
                            }
                        }
                        if (aVar == null) {
                            w.e("MicroMsg.GameInstallationReceiver", "No AppInfo found for package: %s", new Object[]{action});
                            return;
                        }
                        if (e.aO(aVar.field_filePath)) {
                            com.tencent.mm.loader.stub.b.deleteFile(aVar.field_filePath);
                            d.tG(aVar.field_appId);
                        }
                        if (!bg.mA(aVar.field_appId)) {
                            ai.a(aVar.field_appId, aVar.field_scene, 5, aVar.field_downloadedSize - aVar.field_startSize, aVar.field_totalSize, aVar.field_downloadUrl, 0, aVar.field_downloaderType, aVar.field_channelId, (System.currentTimeMillis() - aVar.field_startTime) / 1000, aVar.field_startState);
                        }
                        c cVar = (c) l.mpt.get(aVar.field_downloadUrl);
                        if (cVar == null) {
                            w.e("MicroMsg.GameInstallationReceiver", "No ReportInfo found for url: %s", new Object[]{aVar.field_downloadUrl});
                            return;
                        }
                        if (bg.mA(cVar.fFs)) {
                            cVar.fFs = l.a(cVar);
                        }
                        ai.a(cVar.appId, cVar.scene, 5, cVar.fFW, aVar.field_downloadUrl, cVar.mpy, cVar.fFs);
                    }
                }
            }
        }
    }

    public interface b {
        void g(int i, String str, boolean z);
    }

    private static class c {
        String appId = "";
        String fFW = "";
        String fFs = "";
        String mpy = "";
        int scene = 0;

        c(String str, int i, String str2, String str3, String str4) {
            this.fFW = str;
            this.scene = i;
            this.appId = str2;
            this.mpy = str3;
            this.fFs = str4;
        }
    }

    private l() {
    }

    public static l aAJ() {
        if (mpq == null) {
            mpq = new l();
        }
        return mpq;
    }

    public static void a(b bVar) {
        synchronized (mps) {
            mps.add(bVar);
        }
    }

    public static void b(b bVar) {
        synchronized (mps) {
            mps.remove(bVar);
            w.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[]{Integer.valueOf(mps.size()), bVar});
        }
    }

    public static void aAz() {
        if (mpq == null) {
            mpq = new l();
        }
        if (mpr == null) {
            mpr = new a();
        }
        com.tencent.mm.plugin.downloader.model.e.akM();
        com.tencent.mm.plugin.downloader.model.b.a(mpq);
        ay.aBw();
        ay.registerListener(mpq);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        ab.getContext().registerReceiver(mpr, intentFilter);
    }

    public static void aAA() {
        com.tencent.mm.plugin.downloader.model.e.akM();
        com.tencent.mm.plugin.downloader.model.b.b(mpq);
        ay.aBw();
        ay.unregisterListener(mpq);
        ab.getContext().unregisterReceiver(mpr);
        mpq = null;
        mps.clear();
        mpt.clear();
    }

    private void s(long j, int i) {
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba != null) {
            int i2 = 0;
            switch (i) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 6;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 2;
                    break;
                case 5:
                    i2 = 8;
                    break;
                case 6:
                    break;
                case 7:
                    i2 = 7;
                    break;
            }
            if (!bg.mA(ba.field_appId)) {
                ai.a(ba.field_appId, ba.field_scene, i2, ba.field_downloadedSize - ba.field_startSize, ba.field_totalSize, ba.field_downloadUrl, ba.field_errCode, ba.field_downloaderType, ba.field_channelId, (System.currentTimeMillis() - ba.field_startTime) / 1000, ba.field_startState);
            }
            c cVar = (c) mpt.get(ba.field_downloadUrl);
            if (cVar == null) {
                w.e("MicroMsg.GameDownloadEventBus", "No report info found, abort reporting: %s", new Object[]{ba.field_downloadUrl});
            } else {
                if (bg.mA(cVar.fFs)) {
                    cVar.fFs = a(cVar);
                }
                ai.a(cVar.appId, cVar.scene, i2, cVar.fFW, ba.field_downloadUrl, cVar.mpy, cVar.fFs);
            }
            f(i, ba.field_appId, !ba.field_autoDownload);
        }
    }

    private void f(final int i, final String str, final boolean z) {
        af.v(new Runnable(this) {
            final /* synthetic */ l mpx;

            public final void run() {
                synchronized (l.mps) {
                    for (b g : l.mps) {
                        g.g(i, str, z);
                    }
                }
            }
        });
    }

    public static void a(String str, String str2, int i, String str3, String str4) {
        if (!bg.mA(str)) {
            mpt.put(str, new c(str2, i, str3, "", str4));
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4, String str5) {
        if (!bg.mA(str)) {
            mpt.put(str, new c(str2, i, str3, str4, str5));
        }
    }

    public final void onTaskStarted(long j, String str) {
        mpu.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        s(j, 1);
    }

    public final void c(long j, String str, boolean z) {
        if (bg.mA(str) || !e.aO(str)) {
            com.tencent.mm.plugin.downloader.model.e.akM().aT(j);
            return;
        }
        if (mpu.containsKey(Long.valueOf(j))) {
            long longValue = ((Long) mpu.get(Long.valueOf(j))).longValue();
            mpu.remove(Long.valueOf(j));
            longValue = (System.currentTimeMillis() - longValue) / 1000;
            com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
            if (ba != null) {
                w.i("MicroMsg.GameDownloadEventBus", "appId = %s, downloadType = %d, costTime = %d", new Object[]{ba.field_appId, Integer.valueOf(ba.field_downloaderType), Long.valueOf(longValue)});
                ai.a(ab.getContext(), ba.field_appId, longValue, ba.field_downloaderType);
            }
        }
        s(j, 3);
        if (z) {
            com.tencent.mm.plugin.downloader.b.a ba2 = d.ba(j);
            if (ba2 != null) {
                String str2 = ba2.field_appId;
                SubCoreGameCenter.aBE();
                w.b(str2, 5, 0, null, null);
            }
        }
    }

    public final void d(long j, int i, boolean z) {
        mpu.remove(Long.valueOf(j));
        s(j, 5);
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba != null) {
            String str = null;
            if (i == com.tencent.mm.plugin.downloader.model.c.kGy) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ChannelId", ba.field_channelId);
                    jSONObject.put("DownloadSize", ba.field_downloadedSize);
                    str = ai.xR(jSONObject.toString());
                    w.d("MicroMsg.GameDownloadEventBus", "extInfo = " + jSONObject.toString());
                } catch (Exception e) {
                    w.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + e.getMessage());
                }
            }
            a(ba.field_appId, i, z, str);
        }
    }

    public final void onTaskRemoved(long j) {
        int i = 0;
        mpu.remove(Long.valueOf(j));
        s(j, 4);
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba != null) {
            Context context = ab.getContext();
            CharSequence charSequence = ba.field_appId;
            SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
            String string = sharedPreferences.getString("download_app_id_time_map", "");
            if (!bg.mA(string) && string.contains(charSequence)) {
                String str = new String();
                String[] split = string.split(",");
                while (i < split.length) {
                    String str2 = split[i];
                    if (!str2.contains(charSequence)) {
                        str = i == split.length + -1 ? str + str2 : str + str2 + ",";
                    }
                    i++;
                }
                sharedPreferences.edit().putString("download_app_id_time_map", str).apply();
            }
        }
    }

    public final void onTaskPaused(long j) {
        mpu.remove(Long.valueOf(j));
        s(j, 2);
    }

    public final void bg(long j) {
        s(j, 6);
    }

    public final void j(long j, String str) {
        s(j, 7);
    }

    public final void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, int i2, String str) {
        int i3 = 2;
        w.i("MicroMsg.GameDownloadEventBus", "OnDownloadTaskStateChanged, status = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i2 == 0) {
            switch (i) {
                case 1:
                case 2:
                    i3 = 1;
                    break;
                case 3:
                    break;
                case 4:
                    i3 = 3;
                    break;
                case 5:
                    i3 = 5;
                    break;
                case 6:
                    i3 = 4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                f(i3, tMQQDownloaderOpenSDKParam.taskPackageName, true);
            }
        }
    }

    public final void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2) {
    }

    public final void OnQQDownloaderInvalid() {
    }

    public final void OnServiceFree() {
    }

    public static String a(c cVar) {
        com.tencent.mm.plugin.downloader.b.a tE = d.tE(cVar.appId);
        if (tE == null) {
            return null;
        }
        if (tE.field_downloaderType == 1) {
            return "downloader_type_system";
        }
        return "downloader_type_tmassistant";
    }

    public static void a(String str, int i, boolean z, String str2) {
        if (i == 710 || i == 711) {
            i = com.tencent.mm.plugin.downloader.model.c.kGA;
        }
        w.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[]{str, Integer.valueOf(i)});
        if (z) {
            SubCoreGameCenter.aBE();
            w.b(str, 4, i, null, str2);
            return;
        }
        SubCoreGameCenter.aBE();
        w.b(str, 2, i, null, str2);
    }

    public static void cn(String str, String str2) {
        SubCoreGameCenter.aBE();
        w.b(str, 6, 0, null, str2);
    }
}
