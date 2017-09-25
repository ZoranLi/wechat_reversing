package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver extends BroadcastReceiver {
    private static String className = "";
    private static Object lock = new Object();
    private static ae oTG;
    private static int oTH = 10000;
    private static volatile long oTI = 10000;
    private static volatile int oTJ = -1;
    private static BroadCastData oTK = new BroadCastData();

    static /* synthetic */ void a(KVCommCrossProcessReceiver kVCommCrossProcessReceiver, Intent intent) {
        try {
            switch (s.a(intent, Columns.TYPE, 0)) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("INTENT_IDKEYGROUP");
                    if (bundleExtra != null) {
                        BroadCastData broadCastData = (BroadCastData) bundleExtra.getParcelable("BUNDLE_IDKEYGROUP");
                        ArrayList arrayList = broadCastData.oTz;
                        ArrayList arrayList2 = broadCastData.oTy;
                        w.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(broadCastData.oTx.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                            d.c(groupIDKeyDataInfo.oTA, groupIDKeyDataInfo.oTB);
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it2.next();
                            d.b(stIDKeyDataInfo.oUv, stIDKeyDataInfo.key, stIDKeyDataInfo.value, stIDKeyDataInfo.oTB);
                        }
                        it = r7.iterator();
                        while (it.hasNext()) {
                            KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                            d.a(kVReportDataInfo.oTT, kVReportDataInfo.value, kVReportDataInfo.oTU, kVReportDataInfo.oTB);
                        }
                        break;
                    }
                    break;
                case 2:
                    w.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive TYPE_ONCRASHOREXCEPTION");
                    BaseEvent.onSingalCrash(0);
                    break;
            }
            if (k.aL(ab.getContext())) {
                new ae(Looper.myLooper()).postDelayed(new Runnable(kVCommCrossProcessReceiver) {
                    final /* synthetic */ KVCommCrossProcessReceiver oTL;

                    {
                        this.oTL = r1;
                    }

                    public final void run() {
                        if (k.aL(ab.getContext())) {
                            w.e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
                            w.bIQ();
                            BaseEvent.onSingalCrash(0);
                            Process.killProcess(Process.myPid());
                        }
                    }
                }, 5000);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "", new Object[0]);
        }
    }

    static {
        HandlerThread Qu = e.Qu("kv_report");
        Qu.start();
        oTG = new ae(Qu.getLooper()) {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    KVCommCrossProcessReceiver.aXB();
                }
            }
        };
    }

    public void onReceive(Context context, final Intent intent) {
        if (intent == null) {
            w.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
        } else {
            oTG.post(new Runnable(this) {
                final /* synthetic */ KVCommCrossProcessReceiver oTL;

                public final void run() {
                    w.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", Long.valueOf(Thread.currentThread().getId()));
                    KVCommCrossProcessReceiver.a(this.oTL, intent);
                }
            });
        }
    }

    public static void aXz() {
        if (100 >= 0) {
            oTI = 100;
        }
    }

    public static void aXA() {
        oTJ = 1000;
    }

    private static void aXB() {
        Parcelable broadCastData;
        synchronized (lock) {
            broadCastData = new BroadCastData(oTK);
            BroadCastData broadCastData2 = oTK;
            broadCastData2.oTx.clear();
            broadCastData2.oTy.clear();
            broadCastData2.oTz.clear();
        }
        ArrayList arrayList = broadCastData.oTz;
        ArrayList arrayList2 = broadCastData.oTy;
        ArrayList arrayList3 = broadCastData.oTx;
        if (k.aL(ab.getContext()) || !ab.bJf()) {
            w.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                e.d(groupIDKeyDataInfo.oTA, groupIDKeyDataInfo.oTB);
            }
            it = arrayList2.iterator();
            while (it.hasNext()) {
                StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it.next();
                e.d((int) stIDKeyDataInfo.oUv, (int) stIDKeyDataInfo.key, (int) stIDKeyDataInfo.value, stIDKeyDataInfo.oTB);
            }
            it = arrayList3.iterator();
            while (it.hasNext()) {
                KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                e.b((int) kVReportDataInfo.oTT, kVReportDataInfo.value, kVReportDataInfo.oTU, kVReportDataInfo.oTB);
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ab.getPackageName(), getClassName()));
        intent.putExtra(Columns.TYPE, 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_IDKEYGROUP", broadCastData);
        intent.putExtra("INTENT_IDKEYGROUP", bundle);
        w.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
        try {
            ab.getContext().sendBroadcast(intent);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "sendBroadcastMessageDirectly", new Object[0]);
        }
    }

    private static String getClassName() {
        if (bg.mA(className)) {
            className = ab.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
        }
        return className;
    }

    public static void a(KVReportDataInfo kVReportDataInfo) {
        w.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, isImportant: %b,isReportNow: %b", Long.valueOf(kVReportDataInfo.oTT), Boolean.valueOf(kVReportDataInfo.oTB), Boolean.valueOf(kVReportDataInfo.oTU));
        synchronized (lock) {
            oTK.oTx.add(kVReportDataInfo);
        }
        if (oTI == 0) {
            aXB();
        } else if (!oTG.hasMessages(1)) {
            oTG.sendEmptyMessageDelayed(1, oTI);
        }
    }

    public static void a(StIDKeyDataInfo stIDKeyDataInfo) {
        w.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", Long.valueOf(stIDKeyDataInfo.oUv), Long.valueOf(stIDKeyDataInfo.key), Long.valueOf(stIDKeyDataInfo.value), Boolean.valueOf(stIDKeyDataInfo.oTB));
        synchronized (lock) {
            oTK.oTy.add(stIDKeyDataInfo);
        }
        if (oTI == 0 || aXC()) {
            aXB();
        } else if (!oTG.hasMessages(1)) {
            oTG.sendEmptyMessageDelayed(1, oTI);
        }
    }

    public static void O(ArrayList<IDKey> arrayList) {
        w.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", Integer.valueOf(arrayList.size()), Boolean.valueOf(false));
        synchronized (lock) {
            BroadCastData broadCastData = oTK;
            broadCastData.oTz.add(new GroupIDKeyDataInfo(arrayList, false));
        }
        if (oTI == 0 || aXC()) {
            aXB();
        } else if (!oTG.hasMessages(1)) {
            oTG.sendEmptyMessageDelayed(1, oTI);
        }
    }

    private static boolean aXC() {
        if (oTJ <= 0 || oTK == null) {
            return false;
        }
        try {
            if ((oTK.oTy.size() + oTK.oTz.size()) + oTK.oTx.size() >= oTJ) {
                return true;
            }
            return false;
        } catch (Exception e) {
            w.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", e);
            return false;
        }
    }

    public static void aXD() {
        if (k.aL(ab.getContext()) || !ab.bJf()) {
            w.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ab.getPackageName(), getClassName()));
        intent.putExtra(Columns.TYPE, 2);
        ab.getContext().sendBroadcast(intent);
    }

    public static void aXE() {
        if (oTG != null) {
            oTG.removeMessages(1);
            oTG.handleMessage(oTG.obtainMessage(1));
        }
    }
}
