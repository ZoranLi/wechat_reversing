package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.e.a.cr;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.e;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public final class d {
    private static int lbf = 0;
    public c lba;
    private w lbb;
    public HashMap<Long, aj> lbc;
    public HashMap<Long, aj> lbd;
    public HashMap<Long, Integer> lbe;
    public j lbg = null;
    public Object lbh = new Object();

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ d lbi;
        final /* synthetic */ String lbm;
        final /* synthetic */ boolean lbn;

        AnonymousClass5(d dVar, String str, boolean z) {
            this.lbi = dVar;
            this.lbm = str;
            this.lbn = z;
        }

        public final void run() {
            if (this.lbi.lba == null) {
                this.lbi.lba = new c();
                this.lbi.lba.lgD = new a(this) {
                    final /* synthetic */ AnonymousClass5 lbo;

                    {
                        this.lbo = r2;
                    }

                    public final void onServiceConnected() {
                        this.lbo.lbi.lba.lgD = null;
                        e.apL().V(this.lbo.lbm, this.lbo.lbn);
                        synchronized (this.lbo.lbi.lbh) {
                            this.lbo.lbi.lbh.notify();
                        }
                    }
                };
                this.lbi.lba.bT(ab.getContext());
                synchronized (this.lbi.lbh) {
                    try {
                        this.lbi.lbh.wait();
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "mSyncLock.wait failed!!!, %s", new Object[]{e.getMessage()});
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectManager", e, "", new Object[0]);
                    }
                }
                return;
            }
            e.apL().V(this.lbm, this.lbn);
        }

        public final String toString() {
            return super.toString() + "|ranging";
        }
    }

    class AnonymousClass11 extends a {
        final /* synthetic */ d lbi;

        AnonymousClass11(d dVar, int i) {
            this.lbi = dVar;
            super(0);
        }

        public final void onServiceConnected() {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.exdevice.ExdeviceConnectManager", "onServiceConnected");
        }
    }

    class AnonymousClass2 extends a {
        final /* synthetic */ d lbi;
        final /* synthetic */ j lbj;

        AnonymousClass2(d dVar, j jVar) {
            this.lbi = dVar;
            this.lbj = jVar;
            super(0);
        }

        public final void onServiceConnected() {
            if (!u.apV().laU.a(this.lbj)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
    }

    class AnonymousClass3 extends a {
        final /* synthetic */ long jRY;
        final /* synthetic */ d lbi;
        final /* synthetic */ k lbk;

        AnonymousClass3(d dVar, long j, k kVar) {
            this.lbi = dVar;
            this.jRY = j;
            this.lbk = kVar;
            super(0);
        }

        public final void onServiceConnected() {
            if (!u.apV().laU.a(this.jRY, this.lbk)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
            }
        }
    }

    class AnonymousClass4 extends a {
        final /* synthetic */ d lbi;
        final /* synthetic */ Runnable lbl;

        public AnonymousClass4(d dVar, Runnable runnable) {
            this.lbi = dVar;
            this.lbl = runnable;
            super(0);
        }

        public final void onServiceConnected() {
            this.lbl.run();
        }
    }

    public d() {
        if (this.lbb == null) {
            this.lbb = new w(this) {
                final /* synthetic */ d lbi;

                {
                    this.lbi = r1;
                }

                public final void a(long j, int i, int i2, int i3, long j2) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[]{b.bG(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (ab.getContext() == null) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
                        return;
                    }
                    if (4 == i2) {
                        u.apU().by(j);
                        long[] vh = com.tencent.mm.plugin.exdevice.h.a.vh("shut_down_device");
                        if (!(vh == null || vh.length == 0)) {
                            for (long j3 : vh) {
                                if (j3 == j) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[]{Long.valueOf(j3)});
                                    d.bj(j3);
                                    if (!com.tencent.mm.plugin.exdevice.h.a.s("shut_down_device", j3)) {
                                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                                    }
                                }
                            }
                        }
                        if (this.lbi.lbe.get(Long.valueOf(j)) != null) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[]{this.lbi.lbe.get(Long.valueOf(j))});
                            com.tencent.mm.sdk.b.b crVar = new cr();
                            com.tencent.mm.sdk.b.a.urY.m(crVar);
                            if (!(crVar.fGi.fyt && (((Integer) this.lbi.lbe.get(Long.valueOf(j))).intValue() & 1) == 1)) {
                                d.bj(j);
                            }
                        } else {
                            d.bj(j);
                        }
                    }
                    if (i != i2) {
                        com.tencent.mm.plugin.exdevice.h.b vi = ad.apt().vi(String.valueOf(j));
                        if (vi == null || bg.mA(vi.field_brandName)) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[]{Long.valueOf(j)});
                            return;
                        }
                        f.a bv = u.apU().bv(j);
                        if (bv != null) {
                            bv.fHm = i2;
                        } else {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[]{Long.valueOf(j)});
                        }
                        if (i2 == 2) {
                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                            return;
                        }
                        ad.apE();
                        e.a(vi.field_brandName, vi.field_url, i2, vi.field_deviceID);
                    }
                }
            };
        }
        this.lbc = new HashMap();
        this.lbd = new HashMap();
        this.lbe = new HashMap();
    }

    public static int apb() {
        return lbf;
    }

    public final synchronized void lO(int i) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[]{Integer.valueOf(i)});
        lbf = i;
    }

    public final synchronized void a(Long l, int i) {
        this.lbe.put(l, Integer.valueOf(i));
    }

    public final void a(String str, long j, int i) {
        a(str, j, i, false);
    }

    public final void a(String str, long j, int i, boolean z) {
        com.tencent.mm.plugin.exdevice.h.a.s("shut_down_device", j);
        final String str2;
        final long j2;
        final boolean z2;
        if (this.lba == null) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
            this.lba = new c();
            str2 = str;
            j2 = j;
            z2 = z;
            this.lba.lgD = new a(this, i) {
                final /* synthetic */ d lbi;

                public final void onServiceConnected() {
                    this.lbi.lba.lgD = null;
                    this.lbi.b(str2, j2, this.fHD, z2);
                }
            };
            this.lba.bT(ab.getContext());
        } else if (this.lba == null || this.lba.lgE) {
            b(str, j, i, z);
        } else {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
            str2 = str;
            j2 = j;
            z2 = z;
            this.lba.lgD = new a(this, i) {
                final /* synthetic */ d lbi;

                public final void onServiceConnected() {
                    this.lbi.lba.lgD = null;
                    this.lbi.b(str2, j2, this.fHD, z2);
                }
            };
            this.lba.bT(ab.getContext());
        }
    }

    public final void b(String str, long j, int i, boolean z) {
        boolean b;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
        if (z) {
            b = b(str, j, i);
        } else if (ap.vd().BR() != 4) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            b = false;
        } else {
            if (this.lbc.containsKey(Long.valueOf(j))) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                aj ajVar = (aj) this.lbc.get(Long.valueOf(j));
                ajVar.KH();
                ajVar.v(30000, 30000);
            } else {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                final long j2 = j;
                final String str2 = str;
                final int i2 = i;
                aj ajVar2 = new aj(Looper.getMainLooper(), new aj.a(this) {
                    final /* synthetic */ d lbi;

                    public final boolean oQ() {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[]{str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(u.apU().bu(j2))});
                        if (u.apU().bu(j2) != 2) {
                            ad.apE();
                            e.aM(str2, 2);
                        }
                        this.lbi.lbc.remove(Long.valueOf(j2));
                        return false;
                    }
                }, false);
                ajVar2.v(30000, 30000);
                this.lbc.put(Long.valueOf(j), ajVar2);
            }
            if (u.apV().laU == null) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                b = false;
            } else {
                f.a bv = u.apU().bv(j);
                if (bv == null) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[]{Long.valueOf(j)});
                    b = false;
                } else {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[]{Integer.valueOf(bv.fHm)});
                    if (!(bv.fHm == 2 || bv.fHm == 1)) {
                        u.apV().laU.a(j, i, this.lbb);
                    }
                    b = true;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[]{Boolean.valueOf(b)});
    }

    public static void bj(long j) {
        if (u.apV().laU != null) {
            boolean bB = u.apV().laU.bB(j);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[]{Long.valueOf(j), Boolean.valueOf(bB)});
        }
    }

    public final void apc() {
        if (this.lba != null && this.lba.lgE) {
            try {
                ab.getContext().unbindService(this.lba);
            } catch (Exception e) {
            }
        }
    }

    private synchronized boolean b(String str, long j, int i) {
        boolean z;
        int BR = ap.vd().BR();
        if (BR != 4 && BR != 6) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            z = false;
        } else if (this.lbd.containsKey(Long.valueOf(j))) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", new Object[]{str, Long.valueOf(j)});
            z = false;
        } else {
            final long j2 = j;
            final String str2 = str;
            final int i2 = i;
            aj ajVar = new aj(Looper.getMainLooper(), new aj.a(this) {
                final /* synthetic */ d lbi;

                public final boolean oQ() {
                    int bu = u.apU().bu(j2);
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[]{str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(bu)});
                    d.bj(j2);
                    this.lbi.lbd.remove(Long.valueOf(j2));
                    return false;
                }
            }, false);
            long aqI = b.aqI();
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[]{Long.valueOf(aqI)});
            ajVar.v(aqI, aqI);
            this.lbd.put(Long.valueOf(j), ajVar);
            if (u.apV().laU != null) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[]{str, Long.valueOf(j)});
                z = u.apV().laU.a(j, i, this.lbb);
            } else {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
                z = false;
            }
        }
        return z;
    }

    public static boolean dH(boolean z) {
        if (u.apV().laU != null) {
            long[] apI = u.apV().laU.apI();
            if (apI == null || apI.length <= 0) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
                return false;
            }
            for (long j : apI) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[]{Long.valueOf(j)});
                com.tencent.mm.plugin.exdevice.h.b bF = ad.apt().bF(j);
                if (bF == null) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[]{Long.valueOf(j)});
                } else if (z && (bF.field_closeStrategy & 1) == 0) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[]{Long.valueOf(j)});
                } else {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[]{Long.valueOf(j)});
                    u.apV().laU.bB(j);
                }
            }
            return true;
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
        return false;
    }

    public final void a(final int i, j jVar) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            return;
        }
        this.lbg = jVar;
        if (this.lba == null) {
            this.lba = new c();
            this.lba.lgD = new a(this, i) {
                final /* synthetic */ d lbi;

                public final void onServiceConnected() {
                    if (!u.apV().laU.b(i, this.lbi.lbg)) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
                    }
                }
            };
            this.lba.bT(ab.getContext());
            return;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (u.apV().laU == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.apV().laU.b(i, this.lbg)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }
}
