package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.h.a.b.d;
import com.tencent.mm.plugin.h.a.c.a;
import com.tencent.mm.plugin.h.a.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b implements c {
    private static b lgs = null;
    public com.tencent.mm.plugin.h.a.d.b lgo = null;
    final Vector<r> lgp = new Vector();
    final HashMap<Long, Integer> lgq = new HashMap();
    final HashMap<Long, Integer> lgr = new HashMap();
    public CountDownLatch lgt;
    private ae mHandler = new ae(v.apW().laX.nJF.getLooper());

    public b() {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", new Object[]{Long.valueOf(Thread.currentThread().getId()), Long.valueOf(Looper.getMainLooper().getThread().getId())});
        if (VERSION.SDK_INT != 14 && VERSION.SDK_INT != 15) {
            this.lgo = new com.tencent.mm.plugin.h.a.d.b(ab.getContext(), this, v.apW().laX);
        } else if (r0 == r2) {
            w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
            this.lgo = new com.tencent.mm.plugin.h.a.d.b(ab.getContext(), this, v.apW().laX);
        } else {
            new ae(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable(this) {
                final /* synthetic */ b lgu;

                {
                    this.lgu = r1;
                }

                public final void run() {
                    this.lgu.lgo = new com.tencent.mm.plugin.h.a.d.b(ab.getContext(), this.lgu, v.apW().laX);
                    w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
                    this.lgu.lgt.countDown();
                }
            });
            this.lgt = new CountDownLatch(1);
            try {
                this.lgt.await();
            } catch (InterruptedException e) {
            }
            w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
        }
    }

    private static b apJ() {
        if (lgs != null) {
            return lgs;
        }
        b bVar = new b();
        lgs = bVar;
        return bVar;
    }

    public static boolean a(final int i, final r rVar, final int... iArr) {
        if (rVar == null) {
            w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            return false;
        }
        final b apJ = apJ();
        boolean post = apJ.mHandler.post(new Runnable() {
            public final void run() {
                int i = 0;
                b bVar = apJ;
                int i2 = i;
                r rVar = rVar;
                int[] iArr = iArr;
                if (rVar == null) {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
                    throw new IllegalArgumentException("scanImp: null == aCallback");
                }
                if (iArr == null ? bVar.lgo.a(i2, new int[0]) : bVar.lgo.a(i2, iArr)) {
                    bVar.lgp.add(rVar);
                    i = 1;
                } else {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.scan failed!!!");
                    if (rVar != null) {
                        rVar.rW("scanImp: mBTSDKMrg.scan failed!!!");
                    }
                }
                if (i == 0) {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
        return post;
    }

    public static boolean lQ(final int i) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", new Object[]{Integer.valueOf(i)});
        final b apJ = apJ();
        boolean post = apJ.mHandler.post(new Runnable() {
            public final void run() {
                boolean a;
                boolean z = false;
                b bVar = apJ;
                int i = i;
                com.tencent.mm.plugin.h.a.d.b bVar2 = bVar.lgo;
                w.i("MicroMsg.exdevice.BluetoothSDKManager", "***stopScan*** aBluetoothVersion = " + i);
                switch (i) {
                    case 0:
                        if (bVar2.jUG != null) {
                            a = bVar2.jUG.a(false, new int[0]);
                            break;
                        }
                        w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                        a = false;
                        break;
                    case 1:
                        if (bVar2.jUH != null) {
                            a = bVar2.jUH.cT(false);
                            break;
                        }
                        w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                        a = false;
                        break;
                    default:
                        Assert.assertTrue(false);
                        a = false;
                        break;
                }
                if (a) {
                    z = true;
                } else {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.stopScan failed!!!");
                }
                if (!z) {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
                }
            }
        });
        if (!post) {
            w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void createSession(long j, long j2) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
        final b apJ = apJ();
        final long j3 = j;
        final long j4 = j2;
        if (!apJ.mHandler.post(new Runnable() {
            public final void run() {
                boolean z = false;
                b bVar = apJ;
                long j = j3;
                long j2 = j4;
                if (bVar.lgq.containsKey(Long.valueOf(j))) {
                    bVar.lgo.c(j, j2, ((Integer) bVar.lgq.get(Long.valueOf(j))).intValue());
                    return;
                }
                int intValue;
                v apW = v.apW();
                if (apW.lgR.containsKey(Long.valueOf(j))) {
                    intValue = ((Integer) apW.lgR.get(Long.valueOf(j))).intValue();
                } else {
                    w.e("MicroMsg.exdevice.MMExDevicePushCore", "getBluetoothVersionByDeviceId Failed!!! Cannot find BLuetoothVersion by DeviceId(%d)", new Object[]{Long.valueOf(j)});
                    intValue = -1;
                }
                Assert.assertTrue(-1 != intValue);
                String bG = com.tencent.mm.plugin.exdevice.j.b.bG(j);
                w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "insertDeviceIdTypeMap deviceid = %s, BTVersion = %d", new Object[]{bG, Integer.valueOf(intValue)});
                Assert.assertNotNull(bG);
                if (1 == intValue || intValue == 0) {
                    z = true;
                }
                Assert.assertTrue(z);
                long vx = com.tencent.mm.plugin.exdevice.j.b.vx(bG);
                if (!bVar.lgq.containsKey(Long.valueOf(vx))) {
                    bVar.lgq.put(Long.valueOf(vx), Integer.valueOf(intValue));
                }
                bVar.lgo.c(j, j2, intValue);
            }
        })) {
            w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
        }
    }

    public static boolean sendData(final long j, final byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str2 = "----sendData---- aSessionId = %d, datalength = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        w.i(str, str2, objArr);
        Assert.assertNotNull(bArr);
        final b apJ = apJ();
        boolean post = apJ.mHandler.post(new Runnable() {
            public final void run() {
                boolean z;
                boolean z2 = true;
                b bVar = apJ;
                long j = j;
                Object obj = bArr;
                Assert.assertTrue(bVar.lgr.containsKey(Long.valueOf(j)));
                com.tencent.mm.plugin.h.a.d.b bVar2 = bVar.lgo;
                int intValue = ((Integer) bVar.lgr.get(Long.valueOf(j))).intValue();
                Assert.assertNotNull(obj);
                w.i("MicroMsg.exdevice.BluetoothSDKManager", "***SendData*** sessionId = " + j + "bluetoothVersion = " + intValue);
                switch (intValue) {
                    case 0:
                        if (bVar2.jUG != null) {
                            com.tencent.mm.plugin.h.a.b.b bVar3 = bVar2.jUG;
                            w.i("MicroMsg.exdevice.BluetoothLEManager", "------writeData------ sessionId = %d, data length = %d", new Object[]{Long.valueOf(j), Integer.valueOf(obj.length)});
                            Assert.assertTrue(bVar3.mIsInit);
                            if (!bVar3.acW()) {
                                w.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                                z = false;
                                break;
                            }
                            d dVar = (d) bVar3.jRd.get(String.valueOf(j));
                            if (dVar != null) {
                                w.i("MicroMsg.exdevice.BluetoothLESession", "------writeData------length = %d", new Object[]{Integer.valueOf(obj.length)});
                                w.d("MicroMsg.exdevice.BluetoothLESession", "writeData data dump = %s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.aj(obj)});
                                z = dVar.mHandler.sendMessage(dVar.mHandler.obtainMessage(3, obj));
                                break;
                            }
                            w.w("MicroMsg.exdevice.BluetoothLEManager", "session is null, may be this session is closed");
                            z = false;
                            break;
                        }
                        w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                        z = false;
                        break;
                    case 1:
                        if (bVar2.jUH != null) {
                            a aVar = bVar2.jUH;
                            w.i("MicroMsg.exdevice.BluetoothChatManager", "writeData to: " + j);
                            Assert.assertTrue(aVar.mIsInit);
                            if (!aVar.adk()) {
                                w.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                                z = false;
                                break;
                            }
                            com.tencent.mm.plugin.h.a.c.b bVar4 = (com.tencent.mm.plugin.h.a.c.b) aVar.jRd.get(Long.valueOf(j));
                            if (bVar4 == null) {
                                z2 = false;
                            }
                            Assert.assertTrue(z2);
                            w.i("MicroMsg.exdevice.BluetoothChatSession", "write");
                            if (bVar4.jUq == null) {
                                z = false;
                                break;
                            } else {
                                z = bVar4.jUq.aa(obj);
                                break;
                            }
                        }
                        w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                        z = false;
                        break;
                    default:
                        Assert.assertTrue(false);
                        z = false;
                        break;
                }
                if (!z) {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.sendData failed!!!");
                    bVar.f(j, false);
                }
                if (!z) {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
                }
            }
        });
        if (!post) {
            w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static boolean connect(final long j) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", new Object[]{Long.valueOf(j)});
        final b apJ = apJ();
        boolean post = apJ.mHandler.post(new Runnable() {
            public final void run() {
                boolean z = true;
                b bVar = apJ;
                long j = j;
                Assert.assertTrue(bVar.lgr.containsKey(Long.valueOf(j)));
                com.tencent.mm.plugin.h.a.d.b bVar2 = bVar.lgo;
                int intValue = ((Integer) bVar.lgr.get(Long.valueOf(j))).intValue();
                w.i("MicroMsg.exdevice.BluetoothSDKManager", "***connect*** aSessionId = " + j + " aBluetoothVersion = " + intValue);
                switch (intValue) {
                    case 0:
                        if (bVar2.jUG != null) {
                            z = bVar2.jUG.connect(j);
                            break;
                        }
                        w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                        z = false;
                        break;
                    case 1:
                        if (bVar2.jUH != null) {
                            a aVar = bVar2.jUH;
                            w.i("MicroMsg.exdevice.BluetoothChatManager", "connect, session id = %d, secure = %s", new Object[]{Long.valueOf(j), "true"});
                            Assert.assertTrue(aVar.mIsInit);
                            if (!aVar.adk()) {
                                w.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                                z = false;
                                break;
                            }
                            com.tencent.mm.plugin.h.a.c.b bVar3 = (com.tencent.mm.plugin.h.a.c.b) aVar.jRd.get(Long.valueOf(j));
                            Assert.assertTrue(bVar3 != null);
                            w.i("MicroMsg.exdevice.BluetoothChatSession", "connect");
                            if (bVar3.jRw != null) {
                                bVar3.mState = 2;
                                if (bVar3.jUo != null) {
                                    bVar3.jUo.disconnect();
                                    bVar3.jUo = null;
                                }
                                bVar3.jUo = new com.tencent.mm.plugin.h.a.c.c.a(bVar3, aVar, bVar3.jRw, true);
                                com.tencent.mm.plugin.h.a.c.c.a aVar2 = bVar3.jUo;
                                w.i("MicroMsg.exdevice.ConnectThread", "------connect------");
                                if (!aVar2.mHandler.sendMessage(aVar2.mHandler.obtainMessage(0))) {
                                    w.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[]{Integer.valueOf(0)});
                                    if (aVar2.jUu != null) {
                                        aVar2.jUu.jUk.e(aVar2.jUt.jRv, false);
                                        break;
                                    }
                                }
                            }
                            w.e("MicroMsg.exdevice.BluetoothChatSession", "Can not found remote device(" + com.tencent.mm.plugin.h.a.e.a.aL(bVar3.jUn) + ")");
                            if (aVar != null) {
                                aVar.jUk.b(bVar3.jRv, 7, "Device not found");
                            }
                            z = false;
                            break;
                        }
                        w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                        z = false;
                        break;
                        break;
                    default:
                        Assert.assertTrue(false);
                        z = false;
                        break;
                }
                if (!z) {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.connect failed!!!");
                    bVar.e(j, false);
                }
                if (!z) {
                    w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
                }
            }
        });
        if (!post) {
            w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void destroySession(final long j) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", new Object[]{Long.valueOf(j)});
        final b apJ = apJ();
        if (!apJ.mHandler.post(new Runnable() {
            public final void run() {
                boolean z = true;
                b bVar = apJ;
                long j = j;
                if (bVar.lgq.containsKey(Long.valueOf(j))) {
                    com.tencent.mm.plugin.h.a.d.b bVar2 = bVar.lgo;
                    int intValue = ((Integer) bVar.lgr.get(Long.valueOf(j))).intValue();
                    w.i("MicroMsg.exdevice.BluetoothSDKManager", "***Destroy Session*** aSessionId = " + j + " aBluetoothVersion" + intValue);
                    switch (intValue) {
                        case 0:
                            if (bVar2.jUG == null) {
                                w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                                return;
                            }
                            com.tencent.mm.plugin.h.a.b.b bVar3 = bVar2.jUG;
                            w.i("MicroMsg.exdevice.BluetoothLEManager", "------destroySession------ sessionId = %d", new Object[]{Long.valueOf(j)});
                            Assert.assertTrue(bVar3.mIsInit);
                            if (bVar3.acW()) {
                                d dVar = (d) bVar3.jRd.remove(String.valueOf(j));
                                if (dVar == null) {
                                    w.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot find BluetoothLESession by sessionId(%d)", new Object[]{Long.valueOf(j)});
                                    return;
                                }
                                dVar.close();
                                return;
                            }
                            w.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                            return;
                        case 1:
                            if (bVar2.jUH == null) {
                                w.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                                return;
                            }
                            a aVar = bVar2.jUH;
                            w.i("MicroMsg.exdevice.BluetoothChatManager", "------destroySession------ sessionId = %d", new Object[]{Long.valueOf(j)});
                            Assert.assertTrue(aVar.mIsInit);
                            if (aVar.adk()) {
                                com.tencent.mm.plugin.h.a.c.b bVar4 = (com.tencent.mm.plugin.h.a.c.b) aVar.jRd.remove(Long.valueOf(j));
                                if (bVar4 == null) {
                                    z = false;
                                }
                                Assert.assertTrue(z);
                                bVar4.disconnect();
                                return;
                            }
                            w.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                            return;
                        default:
                            Assert.assertTrue(false);
                            return;
                    }
                }
                w.w("MicroMsg.exdevice.BluetoothSDKAdapter", "the session not exist");
            }
        })) {
            w.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
        }
    }

    public final void d(long j, long j2, long j3) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + j + " aDeviceID = " + j2);
        Assert.assertTrue(this.lgq.containsKey(Long.valueOf(j2)));
        if (!this.lgr.containsKey(Long.valueOf(j))) {
            this.lgr.put(Long.valueOf(j), this.lgq.get(Long.valueOf(j2)));
        }
        Java2CExDevice.onBluetoothSessionCreated(j2, j3, j);
    }

    public final void jJ(int i) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", new Object[]{Integer.valueOf(i)});
        if (this.lgp.isEmpty()) {
            w.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.lgp.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.jJ(i);
            }
        }
        this.lgp.clear();
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str4 = "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        w.d(str3, str4, objArr);
        if (this.lgp.isEmpty()) {
            w.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.lgp.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a(str, str2, i, i2, bArr);
        }
    }

    public final void e(long j, boolean z) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + j + "Connected = " + z);
        if (z) {
            Java2CExDevice.onBluetoothConnected(j);
        } else {
            Java2CExDevice.onBluetoothDisconnected(j);
        }
    }

    public final void b(long j, byte[] bArr) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = " + j);
        Java2CExDevice.onBluetoothRecvData(j, bArr);
    }

    public final void f(long j, boolean z) {
        w.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + j + "success = " + z);
        if (z) {
            Java2CExDevice.onBluetoothSendDataCompleted(j);
        } else {
            Java2CExDevice.onBluetoothError(j, 0);
        }
    }

    public final void aK(long j) {
        Java2CExDevice.onBluetoothError(j, 0);
    }
}
