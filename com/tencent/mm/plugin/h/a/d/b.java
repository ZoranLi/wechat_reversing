package com.tencent.mm.plugin.h.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b {
    public com.tencent.mm.plugin.h.a.b.b jUG = null;
    public com.tencent.mm.plugin.h.a.c.a jUH = null;
    public c jUI = null;
    final HashSet<String> jUJ = new HashSet();
    private ae mHandler = null;

    class a extends com.tencent.mm.plugin.h.a.c.a.a {
        final /* synthetic */ b jUK;

        a(b bVar) {
            this.jUK = bVar;
        }

        public final void d(long j, long j2, long j3) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(this.jUK.e(6, 1, new d(j, j2, j3)));
        }

        public final void acX() {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
            this.jUK.jUJ.clear();
            Assert.assertTrue(this.jUK.e(2, 1, null));
        }

        public final void br(String str, String str2) {
            int i;
            b bVar = this.jUK;
            if (str == null) {
                w.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
                i = 0;
            } else if (bVar.jUJ.contains(str)) {
                i = 0;
            } else {
                bVar.jUJ.add(str);
                i = 1;
            }
            if (i != 0) {
                w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + str + "deviceName = " + str2);
                Assert.assertTrue(this.jUK.e(3, 1, new i(str, str2, 0, null)));
            }
        }

        public final void e(long j, boolean z) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(this.jUK.e(4, 1, new f(j, z)));
        }

        public final void b(long j, byte[] bArr) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = " + j);
            Assert.assertTrue(this.jUK.e(1, 1, new h(j, bArr)));
        }

        public final void f(long j, boolean z) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(this.jUK.e(0, 1, new j(j, z)));
        }

        public final void b(long j, int i, String str) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + j + " errorCode = " + i + " errorInfo = " + str);
            Assert.assertTrue(this.jUK.e(5, 1, new g(j, i, str)));
        }
    }

    static class c extends ae {
        private WeakReference<b> jRN = null;

        public c(Looper looper, b bVar) {
            super(looper);
            this.jRN = new WeakReference(bVar);
        }

        public final void handleMessage(Message message) {
            b bVar = (b) this.jRN.get();
            if (bVar == null) {
                w.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
                return;
            }
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + message.what);
            switch (message.what) {
                case 0:
                    j jVar = (j) message.obj;
                    bVar.jUI.f(jVar.jUM, jVar.jUN);
                    return;
                case 1:
                    h hVar = (h) message.obj;
                    bVar.jUI.b(hVar.jRv, hVar.jQY);
                    return;
                case 2:
                    bVar.jUI.jJ(message.arg1);
                    return;
                case 3:
                    i iVar = (i) message.obj;
                    bVar.jUI.a(iVar.jUQ, iVar.jUR, message.arg1, iVar.jUS, iVar.jUT);
                    return;
                case 4:
                    f fVar = (f) message.obj;
                    bVar.jUI.e(fVar.jUM, fVar.jUN);
                    return;
                case 5:
                    bVar.jUI.aK(((g) message.obj).jRv);
                    return;
                case 6:
                    d dVar = (d) message.obj;
                    bVar.jUI.d(dVar.jRv, dVar.jUL, dVar.jRp);
                    return;
                default:
                    return;
            }
        }
    }

    private static final class d {
        long jRp;
        long jRv;
        long jUL;

        public d(long j, long j2, long j3) {
            this.jRv = j;
            this.jUL = j2;
            this.jRp = j3;
        }
    }

    private static class e {
        long jUM;
        boolean jUN;

        public e(long j, boolean z) {
            this.jUM = j;
            this.jUN = z;
        }
    }

    private static final class g {
        long jRv;
        private int jUO;
        private String jUP;

        public g(long j, int i, String str) {
            this.jRv = j;
            this.jUO = i;
            this.jUP = str;
        }
    }

    private static final class h {
        byte[] jQY;
        long jRv;

        public h(long j, byte[] bArr) {
            this.jRv = j;
            this.jQY = bArr;
        }
    }

    private static final class i {
        String jUQ;
        String jUR;
        int jUS;
        byte[] jUT;

        public i(String str, String str2, int i, byte[] bArr) {
            this.jUQ = str;
            this.jUR = str2;
            this.jUS = i;
            this.jUT = bArr;
        }
    }

    class b extends com.tencent.mm.plugin.h.a.b.b.a {
        final /* synthetic */ b jUK;

        b(b bVar) {
            this.jUK = bVar;
        }

        public final void d(long j, long j2, long j3) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(this.jUK.e(6, 0, new d(j, j2, j3)));
        }

        public final void acX() {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
            this.jUK.jUJ.clear();
            Assert.assertTrue(this.jUK.e(2, 0, null));
        }

        public final void a(String str, String str2, int i, byte[] bArr) {
            w.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[]{str, str2});
            Assert.assertTrue(this.jUK.e(3, 0, new i(str, str2, i, bArr)));
        }

        public final void e(long j, boolean z) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(this.jUK.e(4, 0, new f(j, z)));
        }

        public final void b(long j, byte[] bArr) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = " + j);
            Assert.assertTrue(this.jUK.e(1, 0, new h(j, bArr)));
        }

        public final void f(long j, boolean z) {
            w.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(this.jUK.e(0, 0, new j(j, z)));
        }
    }

    private static final class f extends e {
        public f(long j, boolean z) {
            super(j, z);
        }
    }

    private static final class j extends e {
        public j(long j, boolean z) {
            super(j, z);
        }
    }

    public b(Context context, c cVar, af afVar) {
        this.jUH = new com.tencent.mm.plugin.h.a.c.a(afVar);
        if (VERSION.SDK_INT >= 18) {
            this.jUG = new com.tencent.mm.plugin.h.a.b.b(afVar);
            com.tencent.mm.plugin.h.a.b.b bVar = this.jUG;
            com.tencent.mm.plugin.h.a.b.b.a bVar2 = new b(this);
            w.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
            Assert.assertNotNull(context);
            Assert.assertNotNull(bVar2);
            if (!bVar.mIsInit) {
                bVar.mIsInit = true;
                bVar.ty = context;
                bVar.jRc = bVar2;
                bVar.jRf = com.tencent.mm.plugin.h.a.b.c.acY();
                if (com.tencent.mm.compatible.util.f.eo(21)) {
                    bVar.jRg = com.tencent.mm.plugin.h.a.b.g.adi();
                }
                if (bVar.acW()) {
                    bVar.jQw = ((BluetoothManager) bVar.ty.getSystemService("bluetooth")).getAdapter();
                } else {
                    w.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
                }
            }
        }
        com.tencent.mm.plugin.h.a.c.a aVar = this.jUH;
        com.tencent.mm.plugin.h.a.c.a.a aVar2 = new a(this);
        w.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
        Assert.assertNotNull(context);
        Assert.assertNotNull(aVar2);
        if (!aVar.mIsInit) {
            aVar.mIsInit = true;
            aVar.jUk = aVar2;
            aVar.jUl = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            aVar.jUl.registerReceiver(aVar.iRM, intentFilter);
            aVar.jQw = BluetoothAdapter.getDefaultAdapter();
        }
        this.mHandler = new c(v.apW().laX.nJF.getLooper(), this);
        this.jUI = cVar;
    }

    public final boolean a(int i, int... iArr) {
        w.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.jUG == null) {
                    w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return false;
                } else if (iArr == null) {
                    return this.jUG.a(true, new int[0]);
                } else {
                    return this.jUG.a(true, iArr);
                }
            case 1:
                if (this.jUH != null) {
                    return this.jUH.cT(true);
                }
                w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                return false;
            default:
                Assert.assertTrue(false);
                return false;
        }
    }

    public final void c(long j, long j2, int i) {
        w.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + j + "aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.jUG == null) {
                    w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return;
                }
                com.tencent.mm.plugin.h.a.b.b bVar = this.jUG;
                w.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
                Assert.assertTrue(bVar.mIsInit);
                if (bVar.acW()) {
                    Assert.assertTrue(bVar.mHandler.post(new b(bVar, j, j2)));
                    return;
                } else {
                    w.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    return;
                }
            case 1:
                if (this.jUH == null) {
                    w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    return;
                }
                com.tencent.mm.plugin.h.a.c.a aVar = this.jUH;
                w.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
                Assert.assertTrue(aVar.mIsInit);
                if (aVar.adk()) {
                    Assert.assertTrue(aVar.mHandler.post(new com.tencent.mm.plugin.h.a.c.a.b(aVar, j, j2)));
                    return;
                } else {
                    w.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    return;
                }
            default:
                Assert.assertTrue(false);
                return;
        }
    }

    public final boolean e(int i, int i2, Object obj) {
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(i, i2, 0, obj));
    }
}
