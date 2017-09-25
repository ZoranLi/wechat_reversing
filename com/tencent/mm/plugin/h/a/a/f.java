package com.tencent.mm.plugin.h.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f implements LeScanCallback, r, b {
    public static boolean jQt = false;
    public static boolean jQv = false;
    public e jQA = null;
    private Map<String, Long> jQB = new ConcurrentHashMap();
    private final aj jQC = new aj(v.apW().laX.nJF.getLooper(), new a(this) {
        final /* synthetic */ f jQH;

        {
            this.jQH = r1;
        }

        public final boolean oQ() {
            this.jQH.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 jQI;

                {
                    this.jQI = r1;
                }

                public final void run() {
                    this.jQI.jQH.jQr.a(this.jQI.jQH.jQy, this.jQI.jQH.jQz, this.jQI.jQH.jQA);
                }
            });
            return false;
        }
    }, true);
    public final aj jQD = new aj(v.apW().laX.nJF.getLooper(), new a(this) {
        final /* synthetic */ f jQH;

        {
            this.jQH = r1;
        }

        public final boolean oQ() {
            if (this.jQH.jQs.size() > 0) {
                w.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
                LeScanCallback leScanCallback = this.jQH;
                if ((leScanCallback.jQw != null ? Boolean.valueOf(leScanCallback.jQw.startLeScan(leScanCallback)) : Boolean.valueOf(false)).booleanValue()) {
                    w.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
                } else {
                    w.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
                }
                boolean z = ab.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                f.jQv = z;
                if (!z) {
                    if (!this.jQH.jQE.bJq()) {
                        this.jQH.jQE.KH();
                    }
                    if (!this.jQH.jQD.bJq()) {
                        this.jQH.jQD.KH();
                    }
                }
            }
            return false;
        }
    }, true);
    public final aj jQE = new aj(v.apW().laX.nJF.getLooper(), new a(this) {
        final /* synthetic */ f jQH;

        {
            this.jQH = r1;
        }

        public final boolean oQ() {
            if (this.jQH.jQs.size() <= 0) {
                return false;
            }
            w.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
            LeScanCallback leScanCallback = this.jQH;
            if (leScanCallback.jQw != null) {
                leScanCallback.jQw.stopLeScan(leScanCallback);
            }
            if (this.jQH.jQD.bJq()) {
                this.jQH.jQD.v(2000, 2000);
            }
            return true;
        }
    }, true);
    private final aj jQF = new aj(v.apW().laX.nJF.getLooper(), new a(this) {
        final /* synthetic */ f jQH;

        {
            this.jQH = r1;
        }

        public final boolean oQ() {
            w.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
            f.jQt = false;
            return false;
        }
    }, true);
    private final aj jQG = new aj(v.apW().laX.nJF.getLooper(), new a(this) {
        final /* synthetic */ f jQH;

        {
            this.jQH = r1;
        }

        public final boolean oQ() {
            w.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
            this.jQH.acS();
            return false;
        }
    }, true);
    private final b jQo;
    public final d jQr;
    public final HashSet<UUID> jQs;
    private boolean jQu = false;
    BluetoothAdapter jQw;
    private boolean jQx = true;
    public int jQy = 0;
    public String jQz = "";
    public final ae mHandler;

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ f jQH;
        final /* synthetic */ UUID jQJ;

        public AnonymousClass6(f fVar, UUID uuid) {
            this.jQH = fVar;
            this.jQJ = uuid;
        }

        public final void run() {
            Object obj;
            f fVar = this.jQH;
            UUID uuid = this.jQJ;
            w.i("MicroMsg.exdevice.IBeaconServer", "startRanging");
            if (uuid == null) {
                w.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                obj = null;
            } else {
                if (!fVar.jQs.contains(uuid)) {
                    fVar.jQs.add(uuid);
                }
                fVar.acT();
                obj = 1;
            }
            if (obj == null) {
                w.e("MicroMsg.exdevice.IBeaconServer", "startRanging failed!!!");
            }
        }
    }

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ f jQH;
        final /* synthetic */ UUID jQJ;

        public AnonymousClass7(f fVar, UUID uuid) {
            this.jQH = fVar;
            this.jQJ = uuid;
        }

        public final void run() {
            Object obj;
            f fVar = this.jQH;
            UUID uuid = this.jQJ;
            w.i("MicroMsg.exdevice.IBeaconServer", "stopRanging");
            if (uuid == null) {
                w.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                obj = null;
            } else {
                fVar.jQs.remove(uuid);
                fVar.acS();
                obj = 1;
            }
            if (obj == null) {
                w.e("MicroMsg.exdevice.IBeaconServer", "stopRanging failed!!!");
            }
        }
    }

    public f(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("aCallback is null");
        }
        this.jQs = new HashSet();
        this.jQr = new d(this);
        this.jQo = bVar;
        this.mHandler = new ae(v.apW().laX.nJF.getLooper());
        this.jQw = ((BluetoothManager) ab.getContext().getSystemService("bluetooth")).getAdapter();
    }

    public final void acS() {
        this.jQB.clear();
        jQt = false;
        if (!this.jQF.bJq()) {
            this.jQF.KH();
        }
        if (!this.jQE.bJq()) {
            this.jQE.KH();
        }
        if (!this.jQD.bJq()) {
            this.jQD.KH();
        }
        if (!this.jQC.bJq()) {
            this.jQC.KH();
        }
        if (!this.jQG.bJq()) {
            this.jQG.KH();
        }
        if (this.jQu && this.jQw != null) {
            this.jQw.stopLeScan(this);
            this.jQu = false;
        }
    }

    final synchronized void acT() {
        if (this.jQF.bJq()) {
            this.jQF.v(2000, 2000);
        }
        if (jQv && this.jQE.bJq()) {
            this.jQE.v(10000, 10000);
        }
        if (this.jQG.bJq()) {
            if (jQv) {
                this.jQG.v(1800000, 1800000);
            } else {
                this.jQG.v(120000, 120000);
            }
        }
        if (!jQt) {
            this.jQx = true;
            Boolean valueOf = Boolean.valueOf(this.jQw.startLeScan(this));
            if (valueOf.booleanValue() || jQt) {
                this.jQu = true;
                jQt = true;
                w.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
            } else {
                int i = 0;
                while (!valueOf.booleanValue() && i < 3 && !jQt) {
                    i++;
                    this.jQw.stopLeScan(this);
                    w.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
                    valueOf = Boolean.valueOf(this.jQw.startLeScan(this));
                    if (valueOf.booleanValue()) {
                        jQt = true;
                        this.jQu = true;
                        w.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                    }
                }
            }
        }
    }

    public final void a(double d, c cVar) {
        w.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[]{Double.valueOf(d)});
        String aj = b.aj(cVar.jQl.jQq.jQR);
        if (aj.length() >= 32) {
            aj = aj.substring(0, 8) + "-" + aj.substring(8, 12) + "-" + aj.substring(12, 16) + "-" + aj.substring(16, 20) + "-" + aj.substring(20);
        }
        String str = aj + cVar.jQl.jQq.jQS + cVar.jQl.jQq.jQT;
        if (this.jQB.containsKey(str)) {
            long longValue = ((Long) this.jQB.get(str)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 500) {
                this.jQB.put(str, Long.valueOf(currentTimeMillis));
                this.jQo.a(d, cVar);
                return;
            }
            return;
        }
        this.jQB.put(str, Long.valueOf(System.currentTimeMillis()));
        this.jQo.a(d, cVar);
        w.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + aj + ",major = " + cVar.jQl.jQq.jQS + ",minor = " + (cVar.jQl.jQq.jQT & 65535));
    }

    public final void jJ(int i) {
        if (i == 0) {
            acS();
        }
    }

    public final void a(final String str, String str2, int i, final int i2, byte[] bArr) {
        w.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), b.aj(bArr)});
        if (i == 0) {
            final e eVar = new e();
            if (eVar.V(bArr)) {
                UUID al = b.al(eVar.jQq.jQR);
                if (al == null) {
                    w.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                    return;
                } else if (this.jQs.contains(al)) {
                    if (this.jQx) {
                        this.jQz = str;
                    }
                    this.mHandler.post(new Runnable(this) {
                        final /* synthetic */ f jQH;

                        public final void run() {
                            this.jQH.jQr.a(i2, str, eVar);
                        }
                    });
                    return;
                } else {
                    w.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                    return;
                }
            }
            w.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        }
    }

    public final void rW(String str) {
        w.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[]{Integer.valueOf(-1), str});
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, byte[] bArr) {
        final e eVar = new e();
        if (eVar.V(bArr)) {
            UUID al = b.al(eVar.jQq.jQR);
            if (al == null) {
                w.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                return;
            } else if (this.jQs.contains(al)) {
                if (this.jQx) {
                    this.jQy = i;
                    this.jQA = eVar;
                    if (this.jQC.bJq()) {
                        this.jQC.v(2000, 2000);
                    }
                    this.jQx = false;
                }
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ f jQH;

                    public final void run() {
                        this.jQH.jQr.a(i, bluetoothDevice.getAddress(), eVar);
                    }
                });
                return;
            } else {
                w.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                return;
            }
        }
        w.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
    }
}
