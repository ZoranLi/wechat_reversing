package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
public final class g extends ScanCallback {
    private static g jSj;
    private BluetoothAdapter jQw;
    private ArrayList<a> jRr;
    private boolean jRs;
    private BluetoothManager jSk;
    private BluetoothLeScanner jSl;
    private Context mContext;
    ae mHandler;

    class AnonymousClass1 extends bb<Boolean> {
        final /* synthetic */ a jSm;
        final /* synthetic */ g jSn;
        final /* synthetic */ boolean jdq;

        AnonymousClass1(g gVar, boolean z, a aVar) {
            this.jSn = gVar;
            this.jdq = z;
            this.jSm = aVar;
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(g.a(this.jSn, this.jdq, this.jSm));
        }
    }

    public interface a {
        void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr);

        void jK(int i);
    }

    static /* synthetic */ boolean a(g gVar, boolean z, a aVar) {
        boolean z2;
        if (gVar.mContext == null) {
            w.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found context");
            z2 = false;
        } else {
            z2 = gVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (z2) {
            if (gVar.jSl == null) {
                gVar.jQw = gVar.jSk.getAdapter();
                if (gVar.jQw != null) {
                    w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
                    gVar.jSl = gVar.jQw.getBluetoothLeScanner();
                    if (gVar.jSl == null) {
                        return false;
                    }
                }
                w.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found BluetoothScannner");
                return false;
            }
            if (!com.tencent.mm.plugin.h.a.e.a.adm()) {
                w.i("MicroMsg.exdevice.NewBluetoothLEScanner", "Bluetooth state off");
            } else if (z) {
                w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "start scan");
                if (gVar.jRs) {
                    w.w("MicroMsg.exdevice.NewBluetoothLEScanner", "ble has scan. just add callback and return");
                    gVar.a(aVar);
                } else {
                    gVar.jSl.startScan(gVar);
                    gVar.a(aVar);
                    gVar.jRs = true;
                }
            } else if (gVar.jRs) {
                if (aVar == null) {
                    w.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
                } else {
                    w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "remove callback " + gVar.jRr.remove(aVar));
                }
                if (gVar.jRr.size() <= 0) {
                    w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "stop scan");
                    gVar.jSl.stopScan(gVar);
                    gVar.jRs = false;
                }
            } else {
                w.w("MicroMsg.exdevice.NewBluetoothLEScanner", "scan haven't started. just return, callback size = %d", new Object[]{Integer.valueOf(gVar.jRr.size())});
            }
            return true;
        }
        w.e("MicroMsg.exdevice.NewBluetoothLEScanner", "this phone is not support BLE");
        return false;
    }

    public static g adi() {
        if (jSj != null) {
            return jSj;
        }
        g gVar = new g(ab.getContext());
        jSj = gVar;
        return gVar;
    }

    private g(Context context) {
        if (context == null) {
            w.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
            return;
        }
        this.mContext = context;
        this.jRr = new ArrayList();
        this.jRs = false;
        this.jQw = null;
        this.jSl = null;
        this.mHandler = null;
        this.jSk = (BluetoothManager) this.mContext.getSystemService("bluetooth");
        this.jQw = this.jSk.getAdapter();
        if (this.jQw != null) {
            w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
            this.jSl = this.jQw.getBluetoothLeScanner();
        }
        this.mHandler = new ae(new af("NewBluetoothLEScannerThread").nJF.getLooper());
    }

    private boolean a(a aVar) {
        if (aVar == null) {
            w.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
            return false;
        }
        int i = 0;
        while (i < this.jRr.size()) {
            if (((a) this.jRr.get(i)) == aVar) {
                break;
            }
            i++;
        }
        i = -1;
        if (i < 0) {
            boolean add = this.jRr.add(aVar);
            w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback " + add);
            return add;
        }
        w.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
        return true;
    }

    public final void onScanFailed(final int i) {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ g jSn;

            public final void run() {
                for (int i = 0; i < this.jSn.jRr.size(); i++) {
                    ((a) this.jSn.jRr.get(i)).jK(i);
                }
            }
        });
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        if (scanResult != null && scanResult.getScanRecord() != null) {
            w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.aj(scanResult.getScanRecord().getBytes())});
            w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", new Object[]{Integer.valueOf(this.jRr.size())});
            final BluetoothDevice device = scanResult.getDevice();
            final int rssi = scanResult.getRssi();
            final byte[] bytes = scanResult.getScanRecord().getBytes();
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ g jSn;

                public final void run() {
                    for (int i = 0; i < this.jSn.jRr.size(); i++) {
                        ((a) this.jSn.jRr.get(i)).c(device, rssi, bytes);
                    }
                }
            });
        }
    }

    public final void onBatchScanResults(List<ScanResult> list) {
        if (list != null) {
            for (ScanResult scanResult : list) {
                w.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.aj(scanResult.getScanRecord().getBytes())});
            }
        }
    }
}
