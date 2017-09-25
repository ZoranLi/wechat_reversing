package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.LongWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class a implements r {
    private static a lgf = null;
    public Object hvG = new Object();
    final HashMap<Long, Long> lgg = new HashMap();
    public g lgh = null;
    ae mHandler = new a(this, v.apW().laX.nJF.getLooper());

    private final class a extends ae {
        final /* synthetic */ a lgi;

        public a(a aVar, Looper looper) {
            this.lgi = aVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    c cVar = (c) message.obj;
                    this.lgi.lgh.a(1, 0, null, cVar.jUQ, cVar.jUR, cVar.jUS, cVar.jUT);
                    return;
                case 2:
                    this.lgi.lgh.a(2, 0, null, null, null, 0, null);
                    return;
                case 3:
                    e eVar = (e) message.obj;
                    this.lgi.lgh.c(eVar.lgm, eVar.laH, eVar.lav, eVar.laI);
                    return;
                case 4:
                    d dVar = (d) message.obj;
                    this.lgi.lgh.b(dVar.jUL, dVar.lgk, dVar.lgl, dVar.lav);
                    return;
                case 5:
                    b bVar = (b) message.obj;
                    this.lgi.lgh.a(message.arg1, bVar.jUL, bVar.laC, bVar.lgj, bVar.law);
                    return;
                case 8:
                    g gVar = (g) message.obj;
                    this.lgi.a(gVar.lgm, gVar.lgn);
                    return;
                case 9:
                    a.br(((Long) message.obj).longValue());
                    return;
                case 10:
                    f fVar = (f) message.obj;
                    a aVar = this.lgi;
                    long j = fVar.jUL;
                    byte[] bArr = fVar.jQY;
                    w.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKeyImp------ deviceId = %d", new Object[]{Long.valueOf(j)});
                    if (aVar.lgg.containsKey(Long.valueOf(j))) {
                        Java2CExDevice.setChannelSessionKey(((Long) aVar.lgg.get(Long.valueOf(j))).longValue(), bArr);
                        return;
                    } else {
                        w.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
                        return;
                    }
                case 11:
                    synchronized (this.lgi.hvG) {
                        a aVar2 = this.lgi;
                        long longValue = ((Long) message.obj).longValue();
                        w.i("MicroMsg.exdevice.BTDeviceManager", "startChannelImp deviceId = %d", new Object[]{Long.valueOf(longValue)});
                        if (com.tencent.mm.plugin.exdevice.h.a.q("conneted_device", longValue)) {
                            w.w("MicroMsg.exdevice.BTDeviceManager", "This deviceId is not call stop channel before startChannel, Call it");
                            aVar2.bq(longValue);
                        }
                        LongWrapper longWrapper = new LongWrapper();
                        longWrapper.value = -1;
                        int createChannel = Java2CExDevice.createChannel(longValue, longWrapper);
                        if (createChannel != 0) {
                            w.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.createChannel Failed, ret = " + createChannel);
                            aVar2.lgh.b(longValue, 1, 4, -1);
                        } else {
                            w.i("MicroMsg.exdevice.BTDeviceManager", "Create channel id is ok, deviceId = %d, channelId = %d", new Object[]{Long.valueOf(longValue), Long.valueOf(longWrapper.value)});
                            aVar2.lgg.put(Long.valueOf(longValue), Long.valueOf(longWrapper.value));
                            w.i("MicroMsg.exdevice.BTDeviceManager", "add the device to connected devices : [%d]", new Object[]{Long.valueOf(longValue)});
                            if (com.tencent.mm.plugin.exdevice.h.a.r("conneted_device", longValue)) {
                                int startChannelService = Java2CExDevice.startChannelService(longWrapper.value);
                                if (startChannelService != 0) {
                                    w.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startChannelService Failed, ret = " + startChannelService);
                                    aVar2.lgh.b(longValue, 1, 4, -1);
                                }
                            } else {
                                w.e("MicroMsg.exdevice.BTDeviceManager", "addToSharedPreferences failed!!!");
                                aVar2.lgh.b(longValue, 1, 4, -1);
                            }
                        }
                    }
                    return;
                case 12:
                    synchronized (this.lgi.hvG) {
                        this.lgi.bq(((Long) message.obj).longValue());
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static final class b {
        long jUL = 0;
        short laC = (short) 0;
        byte[] law = null;
        short lgj = (short) 0;
    }

    private static final class c {
        String jUQ;
        String jUR;
        int jUS;
        byte[] jUT;

        public c(String str, String str2, int i, byte[] bArr) {
            this.jUQ = str;
            this.jUR = str2;
            this.jUS = i;
            this.jUT = bArr;
        }
    }

    private static final class d {
        long jUL = 0;
        int lav = 0;
        int lgk = 0;
        int lgl = 0;
    }

    private static final class e {
        int laH = 0;
        String laI = null;
        int lav = 0;
        long lgm = 0;
    }

    private static final class f {
        byte[] jQY;
        long jUL;

        public f(long j, byte[] bArr) {
            this.jUL = j;
            this.jQY = bArr;
        }
    }

    private static final class g {
        long lgm;
        p lgn;

        public g(long j, p pVar) {
            this.lgm = j;
            this.lgn = pVar;
        }
    }

    public a(g gVar) {
        this.lgh = gVar;
        lgf = this;
    }

    public static boolean lQ(int i) {
        w.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
        if (b.lQ(i)) {
            return true;
        }
        w.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
        return false;
    }

    public static long[] apI() {
        return com.tencent.mm.plugin.exdevice.h.a.vh("conneted_device");
    }

    public final boolean bq(long j) {
        w.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = " + j);
        w.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", new Object[]{Long.valueOf(j)});
        if (!com.tencent.mm.plugin.exdevice.h.a.s("conneted_device", j)) {
            w.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
        }
        if (this.lgg.containsKey(Long.valueOf(j))) {
            Java2CExDevice.stopChannelService(((Long) this.lgg.get(Long.valueOf(j))).longValue());
            Java2CExDevice.destroyChannel(((Long) this.lgg.get(Long.valueOf(j))).longValue());
            return true;
        }
        w.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        return false;
    }

    public final int a(long j, p pVar) {
        w.i("MicroMsg.exdevice.BTDeviceManager", "startTaskImp, taskId = %d", new Object[]{Long.valueOf(j)});
        Assert.assertNotNull(pVar);
        try {
            long apM = pVar.apR().apM();
            if (!com.tencent.mm.plugin.exdevice.h.a.q("conneted_device", apM)) {
                w.w("MicroMsg.exdevice.BTDeviceManager", "Cannot startTask because this channel is close aready!!!");
                e eVar = new e();
                eVar.lgm = j;
                eVar.lav = -1;
                eVar.laH = -1;
                eVar.laI = "Channel is close aready!!!";
                Assert.assertTrue(lgf.mHandler.sendMessage(lgf.mHandler.obtainMessage(3, 0, 0, eVar)));
                return -1;
            } else if (this.lgg.containsKey(Long.valueOf(apM))) {
                AccessoryCmd accessoryCmd = new AccessoryCmd();
                accessoryCmd.channelID = ((Long) this.lgg.get(Long.valueOf(apM))).longValue();
                try {
                    accessoryCmd.reqCmdID = pVar.apR().apO();
                    accessoryCmd.respCmdID = pVar.apR().apP();
                    try {
                        if (Java2CExDevice.startTask(j, (short) pVar.apR().apQ(), accessoryCmd, pVar.apR().apN()) != 0) {
                            w.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startTask Failed!!!");
                            return -1;
                        }
                        w.i("MicroMsg.exdevice.BTDeviceManager", "------let task go------ taskId = %d, deviceId = %d, channelId = %d, seq = %d, reqCmdId = %d, respCmdId = %d", new Object[]{Long.valueOf(j), Long.valueOf(apM), Long.valueOf(accessoryCmd.channelID), Integer.valueOf(pVar.apR().apQ()), Integer.valueOf(accessoryCmd.reqCmdID), Integer.valueOf(accessoryCmd.respCmdID)});
                        return 0;
                    } catch (Throwable e) {
                        w.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDataOut failed!!! %s", new Object[]{e.getMessage()});
                        w.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e, "", new Object[0]);
                        this.lgh.c(j, -1, -1, "Remote getDataOut failed!!!!!!");
                        return -1;
                    }
                } catch (Throwable e2) {
                    w.e("MicroMsg.exdevice.BTDeviceManager", "Remote getResquestCmdId or getResponseCmdId failed!!! %s", new Object[]{e2.getMessage()});
                    w.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e2, "", new Object[0]);
                    this.lgh.c(j, -1, -1, "Remote getResquestCmdId or getResponseCmdId failed!!!");
                    return -1;
                }
            } else {
                w.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find Channel by DeviceId(%s) in mMapDeviceChannelId", new Object[]{Long.valueOf(apM)});
                this.lgh.c(j, -1, -1, "Cannot find Channel by DeviceId!!!");
                return -1;
            }
        } catch (Throwable e22) {
            w.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDeviceId failed!!! %s", new Object[]{e22.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e22, "", new Object[0]);
            this.lgh.c(j, -1, -1, "Remote getDeviceId failed!!!");
            return -1;
        }
    }

    public static void br(long j) {
        w.i("MicroMsg.exdevice.BTDeviceManager", "stopTaskImp taskId = %d", new Object[]{Long.valueOf(j)});
        Java2CExDevice.stopTask(j);
    }

    public static void c(long j, int i, int i2, String str) {
        Assert.assertNotNull(lgf);
        w.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + j + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        e eVar = new e();
        eVar.lgm = j;
        eVar.lav = i2;
        eVar.laH = i;
        eVar.laI = str;
        Assert.assertTrue(lgf.mHandler.sendMessage(lgf.mHandler.obtainMessage(3, 0, 0, eVar)));
    }

    public static void b(long j, int i, int i2, int i3) {
        Assert.assertNotNull(lgf);
        w.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + j + " oldState = " + i + " newState = " + i2 + " errCode = " + i3);
        long bs = lgf.bs(j);
        if (-1 == bs) {
            w.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        d dVar = new d();
        dVar.jUL = bs;
        dVar.lav = i3;
        dVar.lgl = i2;
        dVar.lgk = i;
        Assert.assertTrue(lgf.mHandler.sendMessage(lgf.mHandler.obtainMessage(4, 0, 0, dVar)));
    }

    private long bs(long j) {
        if (this.lgg.containsValue(Long.valueOf(j))) {
            for (Entry entry : this.lgg.entrySet()) {
                if (j == ((Long) entry.getValue()).longValue()) {
                    return ((Long) entry.getKey()).longValue();
                }
            }
            Assert.assertTrue(false);
            return -1;
        }
        w.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceId by channelId");
        return -1;
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        String str = "MicroMsg.exdevice.BTDeviceManager";
        String str2 = "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Short.valueOf(s);
        objArr[2] = Short.valueOf(s2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Integer.valueOf(i);
        w.i(str, str2, objArr);
        Assert.assertNotNull(lgf);
        w.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + j + " seq = " + s + "cmdId = " + s2 + "errCode = " + i);
        long bs = lgf.bs(j);
        if (-1 == bs) {
            w.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        b bVar = new b();
        bVar.jUL = bs;
        bVar.law = bArr;
        bVar.lgj = s2;
        bVar.laC = s;
        Assert.assertTrue(lgf.mHandler.sendMessage(lgf.mHandler.obtainMessage(5, i, 0, bVar)));
    }

    public final void jJ(int i) {
        w.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = " + i);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BTDeviceManager";
        String str4 = "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        w.d(str3, str4, objArr);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, new c(str, str2, i2, bArr))));
    }

    public final void rW(String str) {
        w.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", new Object[]{Integer.valueOf(-1), Integer.valueOf(-1)});
        if (!this.mHandler.post(new Runnable(this) {
            final /* synthetic */ a lgi;

            {
                this.lgi = r1;
            }

            public final void run() {
                this.lgi.lgh.a(0, -1, "", "", "", 0, null);
            }
        })) {
            w.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
        }
    }
}
