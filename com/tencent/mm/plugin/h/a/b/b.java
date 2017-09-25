package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.view.InputDevice;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b {
    public BluetoothAdapter jQw;
    public a jRc;
    public final HashMap<String, d> jRd;
    public volatile boolean jRe;
    public c jRf;
    public g jRg;
    public final HashSet<Long> jRh;
    private com.tencent.mm.plugin.h.a.b.c.a jRi;
    private com.tencent.mm.plugin.h.a.b.g.a jRj;
    private Runnable lw;
    public ae mHandler;
    public volatile boolean mIsInit;
    public Context ty;

    public static abstract class a {
        public void d(long j, long j2, long j3) {
        }

        public void e(long j, boolean z) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void f(long j, boolean z) {
        }

        public void a(String str, String str2, int i, byte[] bArr) {
        }

        public void acX() {
        }
    }

    private final class b implements Runnable {
        final /* synthetic */ b jRk;
        private long jRo = 0;
        private long jRp = 0;

        public b(b bVar, long j, long j2) {
            this.jRk = bVar;
            this.jRo = j;
            this.jRp = j2;
        }

        public final void run() {
            b bVar = this.jRk;
            d dVar = new d(this.jRo, bVar.ty, bVar);
            String valueOf = String.valueOf(dVar.jRv);
            w.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", new Object[]{Integer.valueOf(dVar.hashCode()), Long.valueOf(r2), valueOf});
            d dVar2 = (d) bVar.jRd.remove(valueOf);
            if (dVar2 != null) {
                dVar2.close();
            }
            bVar.jRd.put(valueOf, dVar);
            long j = dVar.jRv;
            if (this.jRk.jRc != null) {
                this.jRk.jRc.d(j, this.jRo, this.jRp);
            }
        }
    }

    public b(af afVar) {
        this.jRc = null;
        this.ty = null;
        this.jRd = new HashMap();
        this.jQw = null;
        this.mHandler = null;
        this.lw = null;
        this.jRe = false;
        this.mIsInit = false;
        this.jRh = new HashSet();
        this.jRi = new com.tencent.mm.plugin.h.a.b.c.a(this) {
            final /* synthetic */ b jRk;

            {
                this.jRk = r1;
            }

            public final void c(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
                w.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.vx(bluetoothDevice.getAddress()))});
                this.jRk.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 jRm;

                    public final void run() {
                        this.jRm.jRk.b(bluetoothDevice, i, bArr);
                    }
                });
            }

            public final void acX() {
            }
        };
        this.jRj = new com.tencent.mm.plugin.h.a.b.g.a(this) {
            final /* synthetic */ b jRk;

            {
                this.jRk = r1;
            }

            public final void c(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
                w.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.vx(bluetoothDevice.getAddress()))});
                this.jRk.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 jRn;

                    public final void run() {
                        this.jRn.jRk.b(bluetoothDevice, i, bArr);
                    }
                });
            }

            public final void jK(int i) {
                w.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", new Object[]{Integer.valueOf(i)});
                if (i != 1) {
                    this.jRk.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 jRn;

                        {
                            this.jRn = r1;
                        }

                        public final void run() {
                            if (!this.jRn.jRk.jRh.isEmpty()) {
                                Iterator it = this.jRn.jRk.jRh.iterator();
                                while (it.hasNext()) {
                                    w.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                                    if (this.jRn.jRk.jRc != null) {
                                        this.jRn.jRk.jRc.e(r0.longValue(), false);
                                    }
                                }
                                this.jRn.jRk.jRh.clear();
                            }
                        }
                    });
                }
            }
        };
        this.lw = new Runnable(this) {
            final /* synthetic */ b jRk;

            {
                this.jRk = r1;
            }

            public final void run() {
                this.jRk.jRe = false;
                this.jRk.cS(false);
                w.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
                this.jRk.acV();
                if (this.jRk.jRc != null) {
                    this.jRk.jRc.acX();
                }
            }
        };
        this.mHandler = new ae(afVar.nJF.getLooper());
    }

    public final void acV() {
        w.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
        if (!this.jRh.isEmpty()) {
            Iterator it = this.jRh.iterator();
            while (it.hasNext()) {
                w.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                if (this.jRc != null) {
                    this.jRc.e(r0.longValue(), false);
                }
            }
            this.jRh.clear();
        }
    }

    @TargetApi(18)
    public final boolean acW() {
        Assert.assertTrue(this.mIsInit);
        return this.ty.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public final void b(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        w.d("MicroMsg.exdevice.BluetoothLEManager", "onLeScanImp");
        if (!this.jRh.isEmpty()) {
            long vx = com.tencent.mm.plugin.exdevice.j.b.vx(bluetoothDevice.getAddress());
            if (this.jRh.contains(Long.valueOf(vx))) {
                w.i("MicroMsg.exdevice.BluetoothLEManager", "------onConnectPreScanFound------ sessionid = %d", new Object[]{Long.valueOf(vx)});
                d dVar = (d) this.jRd.get(String.valueOf(vx));
                if (dVar == null) {
                    w.e("MicroMsg.exdevice.BluetoothLEManager", "null == les");
                    if (this.jRc != null) {
                        this.jRc.e(vx, false);
                    }
                } else if (!dVar.connect()) {
                    w.e("MicroMsg.exdevice.BluetoothLEManager", "les.connect() Failed!!!");
                    if (this.jRc != null) {
                        this.jRc.e(vx, false);
                    }
                }
                this.jRh.remove(Long.valueOf(vx));
                if (this.jRh.isEmpty()) {
                    w.i("MicroMsg.exdevice.BluetoothLEManager", "Connect PreScan is done.");
                }
            }
        }
        if (this.jRc != null) {
            this.jRc.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
        }
    }

    private void acS() {
        if (this.jRe) {
            this.mHandler.removeCallbacks(this.lw);
            this.jRe = false;
            cS(false);
            acV();
            if (this.jRc != null) {
                this.jRc.acX();
            }
        }
    }

    public final boolean a(boolean z, int... iArr) {
        w.i("MicroMsg.exdevice.BluetoothLEManager", "------scanLEDevice------" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!acW()) {
            w.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
            return false;
        } else if (!z) {
            acS();
            return true;
        } else if (this.jRe) {
            return true;
        } else {
            if (cS(z)) {
                if (iArr == null || iArr.length <= 0 || iArr[0] != 1) {
                    this.mHandler.postDelayed(this.lw, 10000);
                } else {
                    this.mHandler.removeCallbacks(this.lw);
                }
                this.jRe = true;
                return true;
            }
            w.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
            if (!this.jRh.isEmpty()) {
                Iterator it = this.jRh.iterator();
                while (it.hasNext()) {
                    w.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                    if (this.jRc != null) {
                        this.jRc.e(r0.longValue(), false);
                    }
                }
                this.jRh.clear();
            }
            return false;
        }
    }

    public final boolean cS(boolean z) {
        boolean z2 = false;
        if (f.eo(21) && this.jRg != null) {
            g gVar = this.jRg;
            com.tencent.mm.plugin.h.a.b.g.a aVar = this.jRj;
            w.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
            Boolean bool = (Boolean) new com.tencent.mm.plugin.h.a.b.g.AnonymousClass1(gVar, z, aVar).b(gVar.mHandler);
            if (bool != null) {
                z2 = true;
            }
            Assert.assertTrue(z2);
            return bool.booleanValue();
        } else if (this.jRf != null) {
            return this.jRf.a(z, this.jRi);
        } else {
            w.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
            return false;
        }
    }

    public final boolean connect(long j) {
        w.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", new Object[]{Long.valueOf(j)});
        Assert.assertTrue(this.mIsInit);
        if (acW()) {
            d dVar = (d) this.jRd.get(String.valueOf(j));
            Assert.assertTrue(dVar != null);
            BluetoothManager bluetoothManager = (BluetoothManager) this.ty.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
            } else {
                List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(8);
                if (connectedDevices == null) {
                    w.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
                } else {
                    for (BluetoothDevice address : connectedDevices) {
                        w.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", new Object[]{address.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.vx(((BluetoothDevice) r3.next()).getAddress())), ((BluetoothDevice) r3.next()).getName()});
                        if (j == com.tencent.mm.plugin.exdevice.j.b.vx(((BluetoothDevice) r3.next()).getAddress())) {
                            w.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
                            return dVar.connect();
                        }
                    }
                    w.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", new Object[]{VERSION.RELEASE});
                    if (f.eo(23) && !((LocationManager) this.ty.getSystemService("location")).isProviderEnabled("gps") && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
                        return dVar.connect();
                    }
                    Set<BluetoothDevice> bondedDevices = bluetoothManager.getAdapter().getBondedDevices();
                    if (bondedDevices == null) {
                        w.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
                    } else {
                        for (BluetoothDevice bluetoothDevice : bondedDevices) {
                            w.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", new Object[]{bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.vx(bluetoothDevice.getAddress())), bluetoothDevice.getName()});
                            if (j == com.tencent.mm.plugin.exdevice.j.b.vx(bluetoothDevice.getAddress())) {
                                w.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
                                InputManager inputManager = (InputManager) this.ty.getSystemService("input");
                                int[] inputDeviceIds = inputManager.getInputDeviceIds();
                                if (inputDeviceIds == null) {
                                    w.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                                    break;
                                }
                                for (int inputDevice : inputDeviceIds) {
                                    InputDevice inputDevice2 = inputManager.getInputDevice(inputDevice);
                                    if (inputDevice2 != null) {
                                        String name = inputDevice2.getName();
                                        w.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", new Object[]{name});
                                        if (name != null && name.equals(bluetoothDevice.getName())) {
                                            w.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                                            return dVar.connect();
                                        }
                                    }
                                }
                                w.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
                            }
                        }
                    }
                }
            }
            this.jRh.add(Long.valueOf(j));
            return a(true, new int[0]);
        }
        w.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
        return false;
    }
}
