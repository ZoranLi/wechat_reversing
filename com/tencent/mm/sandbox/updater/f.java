package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

final class f {
    private static long uqS = 125829120;
    private static long uqT = 314572800;
    aj fyI = new aj(new a(this) {
        final /* synthetic */ f uqY;

        {
            this.uqY = r1;
        }

        public final boolean oQ() {
            this.uqY.jN(true);
            return true;
        }
    }, true);
    private boolean gUO = false;
    boolean lFS = false;
    public long uqU = 0;
    public long uqV = 0;
    private String uqW = null;
    private j uqX;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ f uqY;
        final /* synthetic */ long uqZ;

        AnonymousClass2(f fVar, long j) {
            this.uqY = fVar;
            this.uqZ = j;
        }

        public final void run() {
            w.d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", Long.valueOf(this.uqZ));
            this.uqY.uqU += Math.max(0, this.uqZ);
            this.uqY.jN(false);
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ f uqY;
        final /* synthetic */ long ura;

        AnonymousClass3(f fVar, long j) {
            this.uqY = fVar;
            this.ura = j;
        }

        public final void run() {
            w.d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", Long.valueOf(this.ura));
            this.uqY.uqV += Math.max(0, this.ura);
            this.uqY.jN(false);
        }
    }

    public f(j jVar) {
        this.uqX = jVar;
    }

    public final void cy(String str, int i) {
        if (!bg.mA(str)) {
            if (!str.equals(this.uqW)) {
                stop();
            }
            w.i("MicroMsg.TrafficStatistic", "pack size: " + i);
            w.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", Long.valueOf(uqS));
            uqS = Math.max((long) (i * 4), uqS);
            uqS = Math.min(uqT, uqS);
            w.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", Long.valueOf(uqS));
            if (!this.gUO) {
                if (this.uqX.mContext != null) {
                    this.lFS = am.isWifi(this.uqX.mContext);
                }
                this.fyI.v(30000, 30000);
                this.gUO = true;
                this.uqW = str;
            }
        }
    }

    public final void stop() {
        jN(true);
        this.fyI.KH();
        this.gUO = false;
    }

    public final void jN(boolean z) {
        long j = 0;
        if (z || this.uqU + this.uqV >= 524288) {
            if (this.uqU + this.uqV > 0) {
                Intent intent = new Intent();
                intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
                intent.putExtra("intent_extra_flow_stat_upstream", this.uqU);
                intent.putExtra("intent_extra_flow_stat_downstream", this.uqV);
                if (this.uqX.mContext != null) {
                    this.lFS = am.isWifi(this.uqX.mContext);
                }
                intent.putExtra("intent_extra_flow_stat_is_wifi", this.lFS);
                if (this.uqX.mContext != null) {
                    this.uqX.mContext.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                }
            }
            if (bg.mA(this.uqW)) {
                w.e("MicroMsg.TrafficStatistic", "traffic is null!");
            } else {
                long l = i.l(this.uqW, this.uqU, this.uqV);
                this.uqU = 0;
                this.uqV = 0;
                j = l;
            }
            if (j >= uqS && this.uqX.qvw == 2) {
                w.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
                this.uqX.cancel();
            }
        }
    }

    public static boolean OX(String str) {
        if (i.OZ(str) <= uqS) {
            return false;
        }
        w.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
        return true;
    }
}
