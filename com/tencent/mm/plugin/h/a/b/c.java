package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c implements LeScanCallback {
    private static c jRq;
    BluetoothAdapter jQw;
    public ArrayList<a> jRr;
    boolean jRs;
    Context mContext;
    private ae mHandler;

    public interface a {
        void acX();

        void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr);
    }

    public static c acY() {
        if (jRq != null) {
            return jRq;
        }
        c cVar = new c(ab.getContext());
        jRq = cVar;
        return cVar;
    }

    private c(Context context) {
        if (context == null) {
            w.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
            return;
        }
        this.mContext = context;
        this.jRr = new ArrayList();
        this.jRs = false;
        this.jQw = null;
        this.mHandler = null;
        this.jQw = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
        this.mHandler = new ae(new af("BluetoothLEScanerThread").nJF.getLooper());
    }

    public final boolean a(final boolean z, final a aVar) {
        Boolean bool = (Boolean) new bb<Boolean>(this) {
            final /* synthetic */ c jRu;

            protected final /* synthetic */ Object run() {
                boolean z;
                boolean z2 = true;
                c cVar = this.jRu;
                boolean z3 = z;
                a aVar = aVar;
                if (cVar.mContext == null) {
                    w.e("MicroMsg.exdevice.BluetoothLEScaner", "not found context");
                    z = false;
                } else {
                    z = cVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                }
                if (!z) {
                    w.e("MicroMsg.exdevice.BluetoothLEScaner", "this phone is not support BLE");
                    z2 = false;
                } else if (cVar.jQw == null) {
                    w.e("MicroMsg.exdevice.BluetoothLEScaner", "not found BluetoothAdapter");
                    z2 = false;
                } else {
                    if (z3) {
                        if (cVar.jRs) {
                            w.w("MicroMsg.exdevice.BluetoothLEScaner", "ble has scan. just add callback and return");
                            cVar.a(aVar);
                        } else {
                            w.d("MicroMsg.exdevice.BluetoothLEScaner", "start scan");
                            z = cVar.jQw.startLeScan(cVar);
                            if (z) {
                                cVar.jRs = true;
                                cVar.a(aVar);
                            } else if (cVar.jRr.size() <= 0) {
                                w.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed and callbacklist size is 0,start retry,and bluetooth state is(12 is on ,10 is off): " + cVar.jQw.getState());
                                int i = 0;
                                while (!z && i < 3) {
                                    cVar.jQw.stopLeScan(cVar);
                                    cVar.jRs = false;
                                    w.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed,retry no " + i + " time");
                                    boolean startLeScan = cVar.jQw.startLeScan(cVar);
                                    if (startLeScan) {
                                        cVar.jRs = true;
                                        cVar.a(aVar);
                                    }
                                    i++;
                                    z = startLeScan;
                                }
                                z2 = z;
                            } else if (cVar.jQw.getState() == 12) {
                                w.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed when bluetooth state is on.");
                                cVar.jRs = true;
                                cVar.a(aVar);
                                z = true;
                            } else {
                                w.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed");
                            }
                        }
                    } else if (cVar.jRs) {
                        if (aVar == null) {
                            w.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
                        } else {
                            w.d("MicroMsg.exdevice.BluetoothLEScaner", "remove callback " + cVar.jRr.remove(aVar));
                        }
                        if (aVar != null) {
                            aVar.acX();
                        }
                        w.d("MicroMsg.exdevice.BluetoothLEScaner", "stop deleteCallback");
                        if (cVar.jRr.size() <= 0) {
                            w.d("MicroMsg.exdevice.BluetoothLEScaner", "stop scan");
                            cVar.jQw.stopLeScan(cVar);
                            cVar.jRs = false;
                        }
                        z = true;
                    } else {
                        w.w("MicroMsg.exdevice.BluetoothLEScaner", "scan haven't started. just return, callback size = %d", new Object[]{Integer.valueOf(cVar.jRr.size())});
                    }
                    z2 = z;
                }
                return Boolean.valueOf(z2);
            }
        }.b(this.mHandler);
        Assert.assertTrue(bool != null);
        return bool.booleanValue();
    }

    final boolean a(a aVar) {
        if (aVar == null) {
            w.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
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
            w.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback " + add);
            return add;
        }
        w.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
        return true;
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        w.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{bluetoothDevice.getAddress(), bluetoothDevice.getName(), b.aj(bArr)});
        w.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[]{Integer.valueOf(this.jRr.size())});
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ c jRu;

            public final void run() {
                for (int i = 0; i < this.jRu.jRr.size(); i++) {
                    ((a) this.jRu.jRr.get(i)).c(bluetoothDevice, i, bArr);
                }
            }
        });
    }
}
