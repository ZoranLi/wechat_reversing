package com.tencent.mm.plugin.exdevice.service;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import com.tencent.mm.plugin.h.a.a.f.AnonymousClass6;
import com.tencent.mm.plugin.h.a.a.f.AnonymousClass7;
import com.tencent.mm.plugin.h.a.b.e.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

public final class y extends com.tencent.mm.plugin.exdevice.service.h.a implements g, com.tencent.mm.plugin.h.a.a.b, com.tencent.mm.plugin.h.a.d.a.a {
    private a lgT;
    private RemoteCallbackList<k> lgU;
    private RemoteCallbackList<p> lgV;
    private RemoteCallbackList<j> lgW;
    private RemoteCallbackList<i> lgX;
    private RemoteCallbackList<q> lgY;
    private RemoteCallbackList<n> lgZ;
    private final l lha;
    private int lhb;
    private final com.tencent.mm.plugin.h.a.a.f lhc;
    private final com.tencent.mm.plugin.h.a.d.a lhd;
    private RemoteCallbackList<j> lhe;
    private RemoteCallbackList<k> lhf;
    private RemoteCallbackList<s> lhg;
    private RemoteCallbackList<t> lhh;
    com.tencent.mm.plugin.h.a.b.e lhi;
    private com.tencent.mm.plugin.h.a.b.e.a lhj;
    private final ae mHandler;

    private final class a extends ae {
        final /* synthetic */ y lhk;

        public a(y yVar, Looper looper) {
            this.lhk = yVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    k kVar = (k) message.obj;
                    if (!this.lhk.b(kVar.lgm, kVar.lhs)) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                        return;
                    }
                    return;
                case 1:
                    if (!y.a(this.lhk, ((Long) message.obj).longValue())) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                        return;
                    }
                    return;
                case 2:
                    d dVar = (d) message.obj;
                    this.lhk.d(dVar.lgm, dVar.laH, dVar.lav, dVar.laI);
                    return;
                case 3:
                    j jVar = (j) message.obj;
                    if (!y.a(this.lhk, jVar.jUL, jVar.lhr, jVar.lhn)) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                        return;
                    }
                    return;
                case 4:
                    if (!y.b(this.lhk, ((Long) message.obj).longValue())) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                        return;
                    }
                    return;
                case 5:
                    c cVar = (c) message.obj;
                    y.a(this.lhk, cVar.jUL, cVar.lgk, cVar.lgl, cVar.lav);
                    return;
                case 6:
                    b bVar = (b) message.obj;
                    y.a(this.lhk, bVar.jUO, bVar.jUL, bVar.laC, bVar.lgj, bVar.law);
                    return;
                case 7:
                    e eVar = (e) message.obj;
                    if (!this.lhk.c(eVar.ldz, eVar.lhm, eVar.lhn)) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
                        return;
                    }
                    return;
                case 8:
                    long longValue = ((Long) message.obj).longValue();
                    y yVar = this.lhk;
                    w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", new Object[]{Long.valueOf(longValue)});
                    if (yVar.lhi != null) {
                        com.tencent.mm.plugin.h.a.b.e eVar2 = yVar.lhi;
                        w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", new Object[]{Long.valueOf(longValue)});
                        if (eVar2.acW()) {
                            eVar2.q(new AnonymousClass5(eVar2, longValue));
                            return;
                        } else {
                            w.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                            return;
                        }
                    }
                    return;
                case 9:
                    c cVar2 = (c) message.obj;
                    if (!this.lhk.b(cVar2.jUL, cVar2.lgk, cVar2.lgl, cVar2.lav, cVar2.jSe)) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
                        return;
                    }
                    return;
                case 10:
                    i iVar = (i) message.obj;
                    if (!this.lhk.c(iVar.ldz, iVar.jQY, iVar.lhq)) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
                        return;
                    }
                    return;
                case 11:
                    h hVar = (h) message.obj;
                    if (!this.lhk.e(hVar.ldz, hVar.laH, hVar.lav, hVar.laI)) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
                        return;
                    }
                    return;
                case 12:
                    f fVar = (f) message.obj;
                    this.lhk.d(fVar.ldz, fVar.jQY);
                    return;
                case 13:
                    y.a(this.lhk, (g) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    private static final class b {
        long jUL = 0;
        int jUO = 0;
        short laC = (short) 0;
        byte[] law = null;
        short lgj = (short) 0;
    }

    private static final class c {
        public long jSe = 0;
        public long jUL = 0;
        public int lav = 0;
        public int lgk = 0;
        public int lgl = 0;
    }

    private static final class d {
        int laH = 0;
        String laI = null;
        int lav = 0;
        long lgm = 0;
    }

    private static final class e {
        public long ldz;
        public int lhm;
        public k lhn;
    }

    private static final class f {
        public byte[] jQY;
        public long ldz;
    }

    private static final class g {
        String jUQ;
        String jUR;
        int jUS;
        boolean lho;
        byte[] lhp;
    }

    private static final class h {
        public int laH;
        public String laI;
        public int lav;
        public long ldz;
    }

    private static final class i {
        public byte[] jQY;
        public long ldz;
        public t lhq;
    }

    private static final class j {
        long jUL;
        k lhn;
        int lhr;

        public j(long j, int i, k kVar) {
            this.jUL = j;
            this.lhr = i;
            this.lhn = kVar;
        }
    }

    private static final class k {
        long lgm;
        p lhs;

        public k(long j, p pVar) {
            this.lgm = j;
            this.lhs = pVar;
        }
    }

    private static final class l {
        long lgm = 0;
    }

    static /* synthetic */ void a(y yVar, int i, long j, short s, short s2, byte[] bArr) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequestImp errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        w.i(str, str2, objArr);
        int beginBroadcast = yVar.lgX.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                i iVar = (i) yVar.lgX.getBroadcastItem(i2);
                if (iVar != null) {
                    iVar.a(i, j, s, s2, bArr);
                } else {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "get req callback failed, cmdId = %d", new Object[]{Short.valueOf(s2)});
                }
            } catch (Throwable e) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest Failed!!! i = " + i2);
                w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        yVar.lgX.finishBroadcast();
    }

    static /* synthetic */ void a(y yVar, long j, int i, int i2, int i3) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChangeImp deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        k kVar = (k) a(j, yVar.lgU, yVar.lgU.beginBroadcast());
        if (kVar == null) {
            w.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            yVar.lgU.finishBroadcast();
            return;
        }
        try {
            kVar.a(j, i, i2, i3, 0);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        yVar.lgU.finishBroadcast();
    }

    static /* synthetic */ void a(y yVar, g gVar) {
        int beginBroadcast = yVar.lhe.beginBroadcast();
        w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnDiscoverCallback size=%d", new Object[]{Integer.valueOf(beginBroadcast)});
        if (beginBroadcast <= 0) {
            w.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "no simpleBTOnDiscoverCallback");
        }
        int i = 0;
        while (i < beginBroadcast) {
            try {
                if (gVar.lho) {
                    ((j) yVar.lhe.getBroadcastItem(i)).a(2, 0, "scan finish", null, null, 0, null);
                    if (!yVar.lhe.unregister(yVar.lhe.getBroadcastItem(i))) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mSimpleOnScanCallbackList.unregister failed!!!");
                    }
                } else {
                    ((j) yVar.lhe.getBroadcastItem(i)).a(1, 0, "discover device", gVar.jUQ, gVar.jUR, gVar.jUS, gVar.lhp);
                }
                i++;
            } catch (Throwable e) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception: " + e.toString());
                w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                return;
            } finally {
                yVar.lhe.finishBroadcast();
            }
        }
        yVar.lhe.finishBroadcast();
    }

    static /* synthetic */ boolean a(y yVar, long j) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp, task id = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            return false;
        }
        int beginBroadcast = yVar.lgV.beginBroadcast();
        IInterface iInterface = (p) a(j, yVar.lgV, beginBroadcast);
        if (iInterface == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask Failed, Cannot find such netCmd in RemoteCallbackList");
            yVar.lgV.finishBroadcast();
            return false;
        }
        a aVar = yVar.lgT;
        w.i("MicroMsg.exdevice.BTDeviceManager", "stopTask taskId = %d", new Object[]{Long.valueOf(j)});
        aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(9, Long.valueOf(j)));
        boolean a = a(yVar.lgV, j, iInterface, beginBroadcast);
        if (!a) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListTask.unregister Failed!!!");
        }
        yVar.lgV.finishBroadcast();
        return a;
    }

    static /* synthetic */ boolean a(y yVar, long j, int i, k kVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp deviceId = %d, bluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        Assert.assertNotNull(kVar);
        v apW = v.apW();
        w.i("MicroMsg.exdevice.MMExDevicePushCore", "insertDeviceIdAndBluetoothVersion aDeviceId = %d, aBluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        apW.lgR.put(Long.valueOf(j), Integer.valueOf(i));
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange, deviceId = %d", new Object[]{Long.valueOf(j)});
        boolean a = a(yVar.lgU, j, (IInterface) kVar);
        if (!a) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnStateChange.register Failed!!!");
        }
        if (a) {
            a aVar = yVar.lgT;
            w.i("MicroMsg.exdevice.BTDeviceManager", "startChannel deviceId = %d", new Object[]{Long.valueOf(j)});
            if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(11, Long.valueOf(j)))) {
                return true;
            }
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startChannel Failed!!!");
            w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange, deviceId = %d", new Object[]{Long.valueOf(j)});
            a = a(yVar.lgU, j, (IInterface) kVar, yVar.lgU.beginBroadcast());
            if (!a) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
            }
            yVar.lgU.finishBroadcast();
            if (!a) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange");
            }
            yVar.b(j, 1, 4, -1);
            return false;
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange Failed!!!");
        yVar.b(j, 1, 4, -1);
        return false;
    }

    static /* synthetic */ boolean b(y yVar, long j) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp deviceId = %d", new Object[]{Long.valueOf(j)});
        a aVar = yVar.lgT;
        w.i("MicroMsg.exdevice.BTDeviceManager", "stopChannel deviceId = " + j);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(12, Long.valueOf(j)))) {
            return true;
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopChannel Failed!!!");
        return false;
    }

    public y() {
        this.lgT = null;
        this.lgU = new RemoteCallbackList();
        this.lgV = new RemoteCallbackList();
        this.lgW = new RemoteCallbackList();
        this.lgX = new RemoteCallbackList();
        this.lgY = new RemoteCallbackList();
        this.lgZ = new RemoteCallbackList();
        this.lha = new l();
        this.lhb = 0;
        this.lhe = new RemoteCallbackList();
        this.lhf = new RemoteCallbackList();
        this.lhg = new RemoteCallbackList();
        this.lhh = new RemoteCallbackList();
        this.lgT = new a(this);
        this.mHandler = new a(this, v.apW().laX.nJF.getLooper());
        if (VERSION.SDK_INT >= 18) {
            this.lhc = new com.tencent.mm.plugin.h.a.a.f(this);
        } else {
            this.lhc = null;
        }
        this.lhd = new com.tencent.mm.plugin.h.a.d.a(this);
        this.lhj = new com.tencent.mm.plugin.h.a.b.e.a(this) {
            final /* synthetic */ y lhk;

            {
                this.lhk = r1;
            }

            public final void a(long j, boolean z, long j2) {
                String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
                String str2 = "onConnected. seesionId=%d, connected=%s, profileType=%d";
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(j);
                objArr[1] = z ? "true" : "false";
                objArr[2] = Long.valueOf(j2);
                w.d(str, str2, objArr);
                c cVar = new c();
                cVar.jUL = j;
                cVar.lgl = z ? 2 : 4;
                cVar.lgk = 1;
                cVar.lav = 0;
                cVar.jSe = j2;
                if (!this.lhk.mHandler.sendMessage(this.lhk.mHandler.obtainMessage(9, cVar))) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(9)});
                }
            }

            public final void b(long j, byte[] bArr) {
                f fVar = new f();
                fVar.ldz = j;
                fVar.jQY = bArr;
                if (!this.lhk.mHandler.sendMessage(this.lhk.mHandler.obtainMessage(12, fVar))) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(12)});
                }
            }

            public final void f(long j, boolean z) {
                String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
                String str2 = "onSend. sessionId=%d, success=%s";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j);
                objArr[1] = z ? "true" : "false";
                w.d(str, str2, objArr);
                h hVar = new h();
                hVar.ldz = j;
                if (z) {
                    hVar.laH = 0;
                    hVar.lav = 0;
                } else {
                    hVar.laH = -1;
                    hVar.lav = -1;
                }
                hVar.laI = "";
                if (!this.lhk.mHandler.sendMessage(this.lhk.mHandler.obtainMessage(11, hVar))) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(11)});
                }
            }

            public final void a(String str, String str2, int i, byte[] bArr) {
                w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", new Object[]{str, str2});
                g gVar = new g();
                gVar.lho = false;
                gVar.jUQ = str;
                gVar.jUR = str2;
                gVar.jUS = i;
                gVar.lhp = bArr;
                if (!this.lhk.mHandler.sendMessage(this.lhk.mHandler.obtainMessage(13, gVar))) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(13)});
                }
            }

            public final void acX() {
                w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
                g gVar = new g();
                gVar.lho = true;
                gVar.jUQ = null;
                gVar.jUR = null;
                gVar.jUS = 0;
                gVar.lhp = null;
                if (!this.lhk.mHandler.sendMessage(this.lhk.mHandler.obtainMessage(13, gVar))) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(13)});
                }
            }
        };
        com.tencent.mm.compatible.a.a.a(18, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ y lhk;

            {
                this.lhk = r1;
            }

            public final void run() {
                this.lhk.lhi = new com.tencent.mm.plugin.h.a.b.e(this.lhk.lhj);
            }
        });
    }

    private static IInterface a(long j, RemoteCallbackList remoteCallbackList, int i) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        for (int i2 = 0; i2 < i; i2++) {
            HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i2);
            if (hashMap.containsKey(Long.valueOf(j))) {
                return (IInterface) hashMap.get(Long.valueOf(j));
            }
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
        return null;
    }

    private boolean c(j jVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
        boolean unregister = this.lgW.unregister(jVar);
        if (unregister) {
            this.lhb--;
        } else {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
        }
        return unregister;
    }

    public final boolean b(final int i, final j jVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = " + i);
        if (jVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            return false;
        }
        boolean post = this.mHandler.post(new Runnable(this) {
            final /* synthetic */ y lhk;

            public final void run() {
                if (!this.lhk.f(i, jVar)) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
        return post;
    }

    private boolean f(int i, j jVar) {
        if (jVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            throw new IllegalArgumentException("scanImp: null == aCallback");
        }
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
        boolean register = this.lgW.register(jVar);
        if (register) {
            this.lhb++;
        } else {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
        }
        if (register) {
            boolean z;
            r rVar = this.lgT;
            w.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            if (b.a(i, rVar, new int[0])) {
                z = true;
            } else {
                w.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
                z = false;
            }
            if (!z) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
                try {
                    jVar.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
                } catch (Throwable e) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[]{e.getMessage()});
                    w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
                if (!c(jVar)) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
                }
            }
            return z;
        }
        try {
            jVar.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
        } catch (Throwable e2) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[]{e2.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        }
        return false;
    }

    public final boolean c(final int i, final j jVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = " + i);
        if (jVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
            return false;
        }
        boolean post = this.mHandler.post(new Runnable(this) {
            final /* synthetic */ y lhk;

            public final void run() {
                if (!this.lhk.g(i, jVar)) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
        return post;
    }

    private boolean g(int i, j jVar) {
        if (jVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            return false;
        }
        boolean lQ = a.lQ(i);
        if (!lQ) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
            try {
                jVar.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
            } catch (Throwable e) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", new Object[]{e.getMessage()});
                w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        if (!c(jVar)) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        return lQ;
    }

    public final long[] apI() {
        return a.apI();
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", new Object[]{Long.valueOf(j)});
        if (remoteCallbackList == null || iInterface == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            return false;
        }
        int beginBroadcast = remoteCallbackList.beginBroadcast();
        do {
            beginBroadcast--;
            if (beginBroadcast < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(beginBroadcast).asBinder().equals(iInterface.asBinder()));
        if (beginBroadcast < 0) {
            w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
            HashMap hashMap = new HashMap();
            hashMap.put(Long.valueOf(j), iInterface);
            remoteCallbackList.register(iInterface, hashMap);
            remoteCallbackList.finishBroadcast();
            return true;
        }
        hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(beginBroadcast);
        if (hashMap == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            remoteCallbackList.finishBroadcast();
            return false;
        }
        hashMap.put(Long.valueOf(j), iInterface);
        remoteCallbackList.finishBroadcast();
        return true;
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface, int i) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (remoteCallbackList == null || iInterface == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            return false;
        }
        do {
            i--;
            if (i < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(i).asBinder().equals(iInterface.asBinder()));
        if (i < 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
            return false;
        }
        HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i);
        if (hashMap == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            return false;
        } else if (((IInterface) hashMap.remove(Long.valueOf(j))) == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
            return false;
        } else if (!hashMap.isEmpty()) {
            return true;
        } else {
            w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
            boolean unregister = remoteCallbackList.unregister(iInterface);
            if (unregister) {
                return unregister;
            }
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
            return unregister;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (kVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
            return false;
        } else if (j < 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (1 == i || i == 0) {
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(3, new j(j, i, kVar)))) {
                return true;
            }
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[]{Integer.valueOf(3)});
            return false;
        } else {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            return false;
        }
    }

    public final boolean bB(long j) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(j)))) {
            return true;
        } else {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[]{Integer.valueOf(4)});
            return false;
        }
    }

    public final boolean bC(long j) {
        return false;
    }

    private boolean b(long j, p pVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", new Object[]{Long.valueOf(j)});
        if (pVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            d(j, -1, -1, "null == aTask");
            return false;
        }
        boolean z;
        a aVar = this.lgT;
        w.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", new Object[]{Long.valueOf(j)});
        Assert.assertNotNull(pVar);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(8, new g(j, pVar)))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", new StringBuilder("mBTDeviceMrg.startTask Failed ret = -1").toString());
            d(j, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
            return false;
        } else if (a(this.lgV, j, (IInterface) pVar)) {
            return true;
        } else {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
            d(j, -1, -1, "registerRemoteCB Fail!!!");
            return false;
        }
    }

    public final long a(p pVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
        if (pVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            return -1;
        }
        l lVar = this.lha;
        if (Long.MAX_VALUE == lVar.lgm) {
            w.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
            lVar.lgm = 0;
        }
        long j = lVar.lgm;
        lVar.lgm = 1 + j;
        if (this.mHandler.sendMessage(this.mHandler.obtainMessage(0, new k(j, pVar)))) {
            return j;
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", new Object[]{Integer.valueOf(0)});
        return -1;
    }

    public final boolean bD(long j) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(j)))) {
            return true;
        } else {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", new Object[]{Integer.valueOf(1)});
            return false;
        }
    }

    public final boolean a(i iVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
        boolean register = this.lgX.register(iVar);
        if (!register) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
        }
        return register;
    }

    public final boolean b(i iVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
        boolean unregister = this.lgX.unregister(iVar);
        if (!unregister) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
        }
        return unregister;
    }

    public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        int beginBroadcast = this.lgW.beginBroadcast();
        int i4 = 0;
        while (i4 < beginBroadcast) {
            try {
                ((j) this.lgW.getBroadcastItem(i4)).a(i, i2, str, str2, str3, i3, bArr);
                if (2 == i && !this.lgW.unregister(this.lgW.getBroadcastItem(i4))) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
                }
            } catch (Throwable e) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = " + i4);
                w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            i4++;
        }
        this.lgW.finishBroadcast();
    }

    private void d(long j, int i, int i2, String str) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        int beginBroadcast = this.lgV.beginBroadcast();
        IInterface iInterface = (p) a(j, this.lgV, beginBroadcast);
        if (iInterface == null) {
            w.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = " + j);
            this.lgV.finishBroadcast();
            return;
        }
        try {
            iInterface.apS().a(j, i, i2, str, iInterface);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
            w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        if (!a(this.lgV, j, iInterface, beginBroadcast)) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
        }
        this.lgV.finishBroadcast();
    }

    public final void c(long j, int i, int i2, String str) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        d dVar = new d();
        dVar.lgm = j;
        dVar.laH = i;
        dVar.lav = i2;
        dVar.laI = str;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, dVar))) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", new Object[]{Integer.valueOf(2)});
        }
    }

    public final void a(int i, long j, short s, short s2, byte[] bArr) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        w.i(str, str2, objArr);
        b bVar = new b();
        bVar.lgj = s2;
        bVar.law = bArr;
        bVar.jUL = j;
        bVar.laC = s;
        bVar.jUO = i;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, bVar))) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(6)});
        }
    }

    public final void b(long j, int i, int i2, int i3) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        c cVar = new c();
        cVar.jUL = j;
        cVar.lgk = i;
        cVar.lgl = i2;
        cVar.lav = i3;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, cVar))) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", new Object[]{Integer.valueOf(5)});
        }
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", new Object[]{Long.valueOf(j)});
        a aVar = this.lgT;
        w.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", new Object[]{Long.valueOf(j)});
        if (!aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(10, new f(j, bArr)))) {
            w.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", new Object[]{Integer.valueOf(10)});
        }
    }

    public final boolean a(String str, boolean z, q qVar) {
        if (VERSION.SDK_INT < 18 || this.lhc == null) {
            return false;
        }
        boolean hasSystemFeature = ab.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!hasSystemFeature || defaultAdapter == null) {
            return false;
        }
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        if (this.lgY.register(qVar)) {
            try {
                UUID fromString = UUID.fromString(str);
                com.tencent.mm.plugin.h.a.a.f fVar = this.lhc;
                com.tencent.mm.plugin.h.a.a.f.jQv = ab.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                String str2 = "MicroMsg.exdevice.IBeaconServer";
                String str3 = "Ranging, uuid = %s, op = %s";
                Object[] objArr = new Object[2];
                objArr[0] = fromString == null ? "" : fromString.toString();
                objArr[1] = String.valueOf(z);
                w.d(str2, str3, objArr);
                if (fromString == null) {
                    w.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                    hasSystemFeature = false;
                } else {
                    hasSystemFeature = z ? fVar.mHandler.post(new AnonymousClass6(fVar, fromString)) : fVar.mHandler.post(new AnonymousClass7(fVar, fromString));
                }
                if (hasSystemFeature) {
                    return true;
                }
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
                if (!this.lgY.unregister(qVar)) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
                }
                return false;
            } catch (Exception e) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", new Object[]{e.getMessage()});
                return false;
            }
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
        return false;
    }

    public final void a(double d, com.tencent.mm.plugin.h.a.a.c cVar) {
        if (cVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
            return;
        }
        com.tencent.mm.plugin.h.a.a.h hVar = cVar.jQl.jQq;
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", new Object[]{Double.valueOf(d), com.tencent.mm.plugin.exdevice.j.b.aj(hVar.jQR), Short.valueOf(hVar.jQS), Short.valueOf(hVar.jQT), Integer.valueOf(hVar.jQT & 65535)});
        try {
            int beginBroadcast = this.lgY.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ((q) this.lgY.getBroadcastItem(i)).a(d, hVar.jQS, hVar.jQT, hVar.jQR, cVar.jQm, cVar.jQl.jQq.jQU, cVar.aQl);
                } catch (Throwable e) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", new Object[]{Integer.valueOf(i), e.toString()});
                    w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", new Object[]{e2.toString()});
            w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        } finally {
            this.lgY.finishBroadcast();
        }
    }

    public final void jN(int i) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", new Object[]{Integer.valueOf(i)});
        for (int beginBroadcast = this.lgZ.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_state", i);
            try {
                ((n) this.lgZ.getBroadcastItem(beginBroadcast)).g(0, bundle);
            } catch (Throwable e) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", new Object[]{Integer.valueOf(beginBroadcast)});
                w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        this.lgZ.finishBroadcast();
    }

    public final void a(n nVar) {
        w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
        if (!this.lgZ.register(nVar)) {
            w.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
        }
    }

    public final boolean d(int i, j jVar) {
        w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
            return false;
        } else if (i != 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
            return false;
        } else {
            boolean register = this.lhe.register(jVar);
            if (register) {
                w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
            } else {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
            }
            if (this.lhi != null) {
                boolean z;
                com.tencent.mm.plugin.h.a.b.e eVar = this.lhi;
                w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
                if (eVar.jRf != null) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                if (eVar.acW()) {
                    z = eVar.jRf.a(true, eVar.jRi);
                    if (z) {
                        eVar.jRQ.clear();
                    }
                } else {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    z = false;
                }
                if (!z) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
                    try {
                        jVar.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
                    } catch (Throwable e) {
                        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", new Object[]{e.getMessage()});
                        w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                    if (!register) {
                        return false;
                    }
                    this.lhe.unregister(jVar);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean e(int i, j jVar) {
        w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
            return false;
        } else if (this.lhi == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
            return false;
        } else {
            boolean a;
            com.tencent.mm.plugin.h.a.b.e eVar = this.lhi;
            w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
            Assert.assertTrue(eVar.jRf != null);
            if (eVar.acW()) {
                eVar.mHandler.removeCallbacks(eVar.lw);
                a = eVar.jRf.a(false, eVar.jRi);
            } else {
                w.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                a = false;
            }
            if (!a) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
                try {
                    jVar.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
                } catch (Throwable e) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", new Object[]{e.getMessage()});
                    w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
            return a;
        }
    }

    public final boolean b(long j, int i, k kVar) {
        if (kVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        } else if (j < 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (i != 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else {
            e eVar = new e();
            eVar.ldz = j;
            eVar.lhm = i;
            eVar.lhn = kVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(7, eVar))) {
                return true;
            }
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(7)});
            return false;
        }
    }

    public final boolean bE(long j) {
        if (j < 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(j)))) {
            return true;
        } else {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(8)});
            return false;
        }
    }

    public final boolean a(s sVar) {
        if (sVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        }
        boolean register = this.lhg.register(sVar);
        if (register) {
            return register;
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
        return register;
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        if (0 > j) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
            return false;
        } else if (bArr == null || bArr.length <= 0) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
            return false;
        } else if (tVar == null) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        } else {
            i iVar = new i();
            iVar.ldz = j;
            iVar.jQY = bArr;
            iVar.lhq = tVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(10, iVar))) {
                return true;
            }
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(10)});
            return false;
        }
    }

    public final boolean c(long j, int i, k kVar) {
        w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (a(this.lhf, j, (IInterface) kVar)) {
            try {
                kVar.a(j, -1, 1, -1, 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            if (this.lhi != null) {
                boolean connect;
                com.tencent.mm.plugin.h.a.b.e eVar = this.lhi;
                w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", new Object[]{Long.valueOf(j)});
                if (eVar.acW()) {
                    com.tencent.mm.plugin.h.a.b.f fVar = (com.tencent.mm.plugin.h.a.b.f) eVar.jRd.get(Long.valueOf(j));
                    if (fVar != null) {
                        w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
                        connect = fVar.connect();
                    } else {
                        fVar = new com.tencent.mm.plugin.h.a.b.f(j, eVar.ty, eVar.jRS);
                        if (fVar.connect()) {
                            eVar.q(new com.tencent.mm.plugin.h.a.b.e.AnonymousClass4(eVar, j, fVar));
                            connect = true;
                        } else {
                            w.e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
                            connect = false;
                        }
                    }
                } else {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    connect = false;
                }
                if (!connect) {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", new Object[]{Long.valueOf(j)});
                    if (kVar != null) {
                        try {
                            kVar.a(j, 1, 4, -1, 0);
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
        try {
            kVar.a(j, -1, 4, -1, 0);
        } catch (Throwable e22) {
            w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e22, "", new Object[0]);
        }
        return false;
    }

    public final boolean c(long j, byte[] bArr, t tVar) {
        w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", new Object[]{Long.valueOf(j), com.tencent.mm.plugin.exdevice.j.b.aj(bArr)});
        if (this.lhi != null) {
            boolean z;
            com.tencent.mm.plugin.h.a.b.e eVar = this.lhi;
            w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", new Object[]{Long.valueOf(j)});
            if (eVar.acW()) {
                com.tencent.mm.plugin.h.a.b.f fVar = (com.tencent.mm.plugin.h.a.b.f) eVar.jRd.get(Long.valueOf(j));
                if (fVar == null) {
                    w.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
                    z = false;
                } else {
                    w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.j.b.bG(fVar.jRv), fVar.jRw.getName()});
                    z = fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(3, bArr));
                }
            } else {
                w.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                z = false;
            }
            if (!z) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
                if (tVar != null) {
                    try {
                        tVar.b(j, -1, -1, "start write data error");
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                }
                return false;
            }
        }
        if (a(this.lhh, j, (IInterface) tVar)) {
            return true;
        }
        w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
        return false;
    }

    public final boolean b(long j, int i, int i2, int i3, long j2) {
        w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        k kVar = (k) a(j, this.lhf, this.lhf.beginBroadcast());
        if (kVar == null) {
            w.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            this.lhf.finishBroadcast();
            return false;
        }
        try {
            kVar.a(j, i, i2, i3, j2);
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.lhf.finishBroadcast();
        }
    }

    public final boolean e(long j, int i, int i2, String str) {
        w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        t tVar = (t) a(j, this.lhh, this.lhh.beginBroadcast());
        if (tVar == null) {
            w.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            this.lhh.finishBroadcast();
            return false;
        }
        try {
            tVar.b(j, i, i2, str);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
            w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.lhh.finishBroadcast();
        }
        return true;
    }

    public final boolean d(long j, byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "simpleBTOnRecvImpl. mac=%d, data = %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = bArr == null ? "null" : com.tencent.mm.plugin.exdevice.j.b.aj(bArr);
        w.d(str, str2, objArr);
        w.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "SimpleOnRecvList size = %d", new Object[]{Integer.valueOf(this.lhg.beginBroadcast())});
        while (i < r2) {
            try {
                s sVar = (s) this.lhg.getBroadcastItem(i);
                if (sVar != null) {
                    sVar.c(j, bArr);
                } else {
                    w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ISimpleBTOnRecv_AIDL callback is null");
                }
                i++;
            } catch (Throwable e) {
                w.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onDataRecv Failed!!!");
                w.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            } finally {
                this.lhg.finishBroadcast();
            }
        }
        this.lhg.finishBroadcast();
        return true;
    }
}
