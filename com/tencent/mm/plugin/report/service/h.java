package com.tencent.mm.plugin.report.service;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.BaseInfo;
import com.tencent.mars.smc.SmcLogic.ICallBack;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class h implements ICallBack {
    public static IKVReportNotify oUu = null;

    public final void onReportDataReady(byte[] bArr, byte[] bArr2, int i) {
        try {
            if (oUu != null && bArr2 != null && bArr2.length > 0) {
                oUu.onReportKVDataReady(bArr, bArr2, i);
            }
        } catch (Exception e) {
            w.e("KVReportJni", e.getMessage());
        }
    }

    public final boolean onRequestGetStrategy(byte[] bArr, int i) {
        try {
            synchronized (this) {
                if (com.tencent.mm.plugin.report.b.h.isRunning()) {
                    w.i("KVReportJni", "already running");
                    return false;
                }
                com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.report.b.h(), 0);
                return true;
            }
        } catch (Exception e) {
            w.e("KVReportJni", "onRequestGetStrategy error: " + e.getMessage());
            return false;
        }
    }

    public final boolean OnSelfMonitorOpLogReady(byte[] bArr) {
        com.tencent.mm.kernel.h.vG();
        if (a.uU()) {
            try {
                k kVar = new k();
                kVar.aD(bArr);
                com.tencent.mm.bd.a toMMSelfMonitor = SmcProtoBufUtil.toMMSelfMonitor(kVar);
                if (toMMSelfMonitor.tKR <= 0) {
                    w.e("KVReportJni", "error selfmonitor count");
                    return true;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(f.CTRL_INDEX, toMMSelfMonitor));
                return true;
            } catch (Exception e) {
                w.e("KVReportJni", e.getMessage());
                return false;
            }
        }
        w.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
        return false;
    }

    public final int getSingleReportBufSizeB() {
        return 20480;
    }

    public final BaseInfo getKVCommReqBaseInfo() {
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.deviceModel = Build.MODEL + Build.CPU_ABI;
        baseInfo.deviceBrand = Build.BRAND;
        baseInfo.osName = "android-" + Build.MANUFACTURER;
        baseInfo.osVersion = VERSION.SDK_INT;
        baseInfo.languageVer = v.bIN();
        return baseInfo;
    }

    public final String getKVCommPath() {
        return AppLogic.getAppFilePath() + "/kvcomm/";
    }

    public static void DB(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.SmcCallBack", "msg content is null");
            return;
        }
        w.i("MicroMsg.SmcCallBack", "receive msg: " + str);
        Map q = com.tencent.mm.b.f.q(str, "sysmsg");
        if (q == null || q.size() == 0) {
            w.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        String str2 = (String) q.get(".sysmsg.$type");
        if (bg.mA(str2) || !str2.equalsIgnoreCase("getkvidkeystg")) {
            w.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        long j = bg.getLong((String) q.get(".sysmsg.getkvidkeystg.generalversion"), -1);
        long j2 = bg.getLong((String) q.get(".sysmsg.getkvidkeystg.specialversion"), -1);
        long j3 = bg.getLong((String) q.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1);
        long j4 = bg.getLong((String) q.get(".sysmsg.getkvidkeystg.timeinterval"), -1);
        long j5 = bg.getLong((String) q.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1);
        long j6 = bg.getLong((String) q.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1);
        long j7 = bg.getLong((String) q.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1);
        if (j == -1 || j2 == -1 || j3 == -1 || j4 == -1 || -1 == j5 || -1 == j6 || -1 == j7) {
            w.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        w.i("MicroMsg.SmcCallBack", "plugin msg version:" + j + ", " + j2 + ", " + j3);
        SmcLogic.OnPluginMsg(j5, j6, j7, j, j2, j4);
    }
}
