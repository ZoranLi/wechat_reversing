package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class o implements ICallBack {
    private static long iej = 0;
    private static int iek = 0;
    private final String TAG = "IPxxCallback";

    public final String getUplodLogExtrasInfo() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Device:").append(d.sYH).append(" ").append(d.sYI).append("\n");
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public final void setNewDnsDebugHostInfo(String str, int i) {
        MMLogic.setNewDnsDebugHost(str, String.valueOf(i));
    }

    public final String getCrashFilePath(int i) {
        String str = e.hgv + "crash_" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis() - (((long) i) * 86400000))) + ".txt";
        return com.tencent.mm.a.e.aO(str) ? str : null;
    }

    public final void recoverLinkAddrs() {
        MMLogic.recoverLinkAddrs();
    }

    public final void uploadLogResponse(long j, long j2) {
        int i = 100;
        int i2 = 0;
        w.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(iek));
        long Ny = bg.Ny();
        if (Ny - 1 >= iej) {
            iej = Ny;
            if (j2 >= 0 && j > 0 && j2 < j) {
                i2 = (int) ((100 * j2) / j);
            }
            if (i2 <= 100) {
                i = i2;
            }
            if (iek > i) {
                i = iek;
            }
            iek = i;
            gU(i);
        }
    }

    public final void uploadLogFail() {
        iek = 0;
        gU(-1);
    }

    public final void uploadLogSuccess() {
        iek = 0;
        gU(100);
    }

    private static void gU(int i) {
        try {
            s MO = z.MO();
            if (MO.iex != null) {
                try {
                    MO.iex.cR(i);
                } catch (Throwable e) {
                    w.e("MicroMsg.AutoAuth", "exception:%s", bg.g(e));
                }
            }
        } catch (Throwable e2) {
            w.e("IPxxCallback", "exception:%s", bg.g(e2));
        }
    }
}
