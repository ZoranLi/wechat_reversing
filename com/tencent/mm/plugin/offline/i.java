package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.pb.common.b.h;
import java.util.ArrayList;

public final class i implements e {
    public ae mHandler = new ae();
    private boolean obP = false;
    private boolean obQ = false;
    private int obR = 10;
    private int obS = 0;
    private String obT = "";
    a obU;
    private m obV;
    public b obW = new b(this);
    public int obX = 14400000;
    public aj obY = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ i obZ;

        {
            this.obZ = r1;
        }

        public final boolean oQ() {
            if (ap.zb()) {
                long j;
                this.obZ.cD(5, 5);
                aj ajVar = this.obZ.obY;
                i iVar = this.obZ;
                long aRh = (long) com.tencent.mm.plugin.offline.c.a.aRh();
                if (aRh <= 0) {
                    j = (long) iVar.obX;
                } else {
                    w.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:" + aRh);
                    j = 1000 * aRh;
                }
                ajVar.v(j, j);
            } else {
                long j2 = (long) this.obZ.obX;
                this.obZ.obY.v(j2, j2);
            }
            return false;
        }
    }, false);

    public interface a {
        void aPX();
    }

    private class b implements Runnable {
        final /* synthetic */ i obZ;

        public b(i iVar) {
            this.obZ = iVar;
        }

        public final void run() {
            w.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
            this.obZ.cF(6, 6);
        }
    }

    public i() {
        long j = 1;
        try {
            com.tencent.mm.wallet_core.c.a.cbV();
            com.tencent.mm.wallet_core.c.a.init(ab.getContext());
        } catch (Exception e) {
            w.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[]{e});
        }
        ap.vd().a(385, this);
        k.aQd();
        String qL = k.qL(196649);
        if (TextUtils.isEmpty(qL) || !com.tencent.mm.plugin.offline.c.a.tb(qL)) {
            w.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        } else {
            Object aQT = com.tencent.mm.plugin.offline.c.a.aQT();
            w.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is " + aQT);
            long longValue = Long.valueOf(qL).longValue();
            if (TextUtils.isEmpty(aQT)) {
                w.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
            } else {
                j = Long.valueOf(aQT).longValue();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                w.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + currentTimeMillis + ";");
                j = longValue - (currentTimeMillis - j);
            }
        }
        w.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=" + j);
        j *= 1000;
        this.obY.v(j, j);
    }

    public static int aQc() {
        k.aQd();
        String qL = k.qL(196617);
        com.tencent.mm.wallet_core.c.a.cbV();
        int tokenCount = com.tencent.mm.wallet_core.c.a.getTokenCount(qL, true);
        w.i("MicroMsg.OfflineTokensMgr", "offline tokens count:" + tokenCount);
        return tokenCount;
    }

    public final void cD(int i, int i2) {
        if (am.isNetworkConnected(ab.getContext()) && com.tencent.mm.plugin.offline.c.a.aQL()) {
            w.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
            cF(i, i2);
        }
    }

    public final boolean gc(boolean z) {
        if (!com.tencent.mm.plugin.offline.c.a.aQL()) {
            w.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
            return false;
        } else if (aQc() < k.ocj) {
            w.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[]{Integer.valueOf(k.ocj)});
            com.tencent.mm.wallet_core.c.a.cbV();
            int lastError = com.tencent.mm.wallet_core.c.a.getLastError();
            if (lastError != 0) {
                w.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + lastError + ", don't  doNetSceneToken");
                return false;
            }
            w.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
            if (z) {
                cE(2, 9);
            } else {
                cE(2, 2);
            }
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.aRi()) {
            w.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
            if (z) {
                cF(5, 9);
            } else {
                cF(5, 5);
            }
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.aRf()) {
            return false;
        } else {
            w.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
            if (z) {
                cF(3, 9);
            } else {
                cF(3, 3);
            }
            return true;
        }
    }

    public final void cE(int i, final int i2) {
        if (aQc() > 2) {
            this.mHandler.postDelayed(new Runnable(this, 2) {
                final /* synthetic */ i obZ;

                public final void run() {
                    this.obZ.cF(2, i2);
                }
            }, 3000);
        } else {
            cF(2, i2);
        }
    }

    public final void cF(int i, int i2) {
        int i3 = 0;
        if (!this.obP) {
            this.obP = true;
            ap.vd().a(new m((System.currentTimeMillis() / 1000), i, i2), 0);
            boolean cB = com.tencent.mm.plugin.offline.c.a.cB(ab.getContext());
            boolean isNetworkConnected = h.isNetworkConnected();
            g gVar = g.oUh;
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(4);
            objArr[1] = Integer.valueOf(cB ? 0 : 1);
            objArr[2] = Integer.valueOf(isNetworkConnected ? 1 : 0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(i);
            if (k.oci) {
                i3 = 1;
            }
            objArr[5] = Integer.valueOf(i3);
            gVar.i(14163, objArr);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(isNetworkConnected ? 36 : 37);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(cB ? 38 : 39);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(k.oci ? 40 : 41);
            arrayList.add(iDKey);
            IDKey iDKey2;
            if (i == 2) {
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(k.oci ? 42 : 43);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(cB ? 44 : 45);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                iDKey2.SetValue(1);
                iDKey2.SetKey(isNetworkConnected ? 46 : 47);
                arrayList.add(iDKey2);
            } else if (i == 6) {
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(k.oci ? 48 : 49);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(cB ? 50 : 51);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                iDKey2.SetValue(1);
                iDKey2.SetKey(isNetworkConnected ? 52 : 53);
                arrayList.add(iDKey2);
            } else if (i == 6) {
                IDKey iDKey3 = new IDKey();
                iDKey3.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                iDKey3.SetValue(1);
                iDKey3.SetKey(cB ? 54 : 55);
                arrayList.add(iDKey3);
            }
            g.oUh.b(arrayList, true);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 6;
        if ((kVar instanceof com.tencent.mm.plugin.offline.a.h) || (kVar instanceof f)) {
            ArrayList arrayList = new ArrayList();
            if (kVar instanceof m) {
                IDKey iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(2);
                arrayList.add(iDKey);
                if (!(i == 0 && i2 == 0)) {
                    iDKey = new IDKey();
                    iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
                    iDKey.SetValue(1);
                    iDKey.SetKey(3);
                    arrayList.add(iDKey);
                }
                g.oUh.b(arrayList, true);
            }
            if ((kVar instanceof f) && ((i == 0 && i2 == 0) || i != 0)) {
                w.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (this.obV != null) {
                    this.obV.aQk();
                    this.obV = null;
                    if (this.obU != null) {
                        this.obU.aPX();
                    }
                }
            }
            if (i == 0 && i2 == 0) {
                if (kVar instanceof m) {
                    this.obS = 0;
                    this.obP = false;
                    this.mHandler.removeCallbacks(this.obW);
                    this.obV = (m) kVar;
                    String str2 = this.obV.ocV;
                    k.aQd();
                    ap.vd().a(new f(str2, k.qL(196617)), 0);
                } else if (kVar instanceof l) {
                    this.obQ = false;
                    this.obT = ((l) kVar).obT;
                    if (this.obU != null) {
                        this.obU.aPX();
                    }
                } else if (!(kVar instanceof f)) {
                }
            } else if (kVar instanceof m) {
                w.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
                this.obS++;
                this.obP = false;
                if (i2 == 411) {
                    w.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
                    com.tencent.mm.plugin.offline.c.a.aQW();
                } else if (this.obS < this.obR) {
                    this.mHandler.removeCallbacks(this.obW);
                    int i4 = this.obS - 1;
                    if (i4 <= 6) {
                        i3 = i4;
                    }
                    this.mHandler.postDelayed(this.obW, (long) ((((int) Math.pow(2.0d, (double) i3)) * 60) * 1000));
                }
            } else if (kVar instanceof l) {
                this.obQ = false;
            } else if (kVar instanceof f) {
                this.obV = null;
            }
        }
    }
}
