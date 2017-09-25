package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e {
    public a jRO;
    private ReentrantLock jRP;
    public HashSet<Long> jRQ;
    public final HashMap<Long, Boolean> jRR;
    public com.tencent.mm.plugin.h.a.b.f.a jRS;
    public final HashMap<Long, f> jRd;
    public c jRf;
    public com.tencent.mm.plugin.h.a.b.c.a jRi;
    public Runnable lw;
    public ae mHandler;
    public Context ty;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ e jRT;
        final /* synthetic */ long jRY;
        final /* synthetic */ f jRZ;

        public AnonymousClass4(e eVar, long j, f fVar) {
            this.jRT = eVar;
            this.jRY = j;
            this.jRZ = fVar;
        }

        public final void run() {
            this.jRT.jRd.put(Long.valueOf(this.jRY), this.jRZ);
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ e jRT;
        final /* synthetic */ long jRY;

        public AnonymousClass5(e eVar, long j) {
            this.jRT = eVar;
            this.jRY = j;
        }

        public final void run() {
            f fVar = (f) this.jRT.jRd.remove(Long.valueOf(this.jRY));
            if (fVar != null) {
                w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------close------, mac=%s, name=%s", new Object[]{b.bG(fVar.jRv), fVar.jRw.getName()});
                if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(2))) {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(2)});
                }
                this.jRT.jRR.put(Long.valueOf(this.jRY), Boolean.valueOf(true));
                return;
            }
            w.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session not found! maybe ui don't handle session disconnect event correctly.");
        }
    }

    public static abstract class a {
        public void a(long j, boolean z, long j2) {
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

    public e(a aVar) {
        this.ty = null;
        this.jRP = new ReentrantLock();
        this.mHandler = null;
        this.lw = null;
        this.jRi = new com.tencent.mm.plugin.h.a.b.c.a(this) {
            final /* synthetic */ e jRT;

            {
                this.jRT = r1;
            }

            public final void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                long vx = b.vx(bluetoothDevice.getAddress());
                if (!this.jRT.jRQ.contains(Long.valueOf(vx))) {
                    w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(vx), b.aj(bArr)});
                    this.jRT.jRQ.add(Long.valueOf(vx));
                    if (c.Z(bArr)) {
                        this.jRT.jRO.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
                    }
                }
            }

            public final void acX() {
                w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
                if (this.jRT.jRO != null) {
                    this.jRT.jRO.acX();
                } else {
                    w.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
                }
                this.jRT.jRQ.clear();
            }
        };
        this.jRQ = new HashSet();
        this.jRd = new HashMap();
        this.jRR = new HashMap();
        this.jRS = new com.tencent.mm.plugin.h.a.b.f.a(this) {
            final /* synthetic */ e jRT;

            {
                this.jRT = r1;
            }

            public final void a(long j, boolean z, long j2) {
                String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
                String str2 = "onConnected. mac = %s, connected = %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.bG(j);
                objArr[1] = z ? "true" : "false";
                w.d(str, str2, objArr);
                final long j3 = j;
                final boolean z2 = z;
                final long j4 = j2;
                this.jRT.q(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 jRX;

                    public final void run() {
                        f fVar = (f) this.jRX.jRT.jRd.get(Long.valueOf(j3));
                        Boolean.valueOf(false);
                        if (z2) {
                            boolean z = false;
                        } else {
                            int i = 1;
                        }
                        if (fVar == null && i == 0) {
                            w.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[]{b.bG(j3)});
                            return;
                        }
                        if (this.jRX.jRT.jRO != null) {
                            this.jRX.jRT.jRO.a(j3, z2, j4);
                            if (i != 0) {
                                w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[]{b.bG(j3)});
                            }
                        }
                        if (i != 0) {
                            w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[]{b.bG(j3)});
                            this.jRX.jRT.jRd.remove(Long.valueOf(j3));
                            this.jRX.jRT.jRR.remove(Long.valueOf(j3));
                        }
                    }
                });
                w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[]{Integer.valueOf(this.jRT.jRd.size())});
            }

            public final void b(long j, byte[] bArr) {
                w.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[]{b.bG(j)});
                if (this.jRT.jRO != null) {
                    this.jRT.jRO.b(j, bArr);
                } else {
                    w.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
                }
            }

            public final void f(long j, boolean z) {
                String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
                String str2 = "onSend. mac = %s, success = %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.bG(j);
                objArr[1] = z ? "true" : "false";
                w.d(str, str2, objArr);
                if (this.jRT.jRO != null) {
                    this.jRT.jRO.f(j, z);
                }
            }
        };
        this.ty = ab.getContext();
        this.jRO = aVar;
        this.jRf = c.acY();
        this.lw = new Runnable(this) {
            final /* synthetic */ e jRT;

            {
                this.jRT = r1;
            }

            public final void run() {
                this.jRT.jRf.a(false, this.jRT.jRi);
                w.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
            }
        };
        this.mHandler = new ae(new af("BluetoothLESimpleManagerThread").nJF.getLooper());
    }

    public final void q(Runnable runnable) {
        this.jRP.lock();
        runnable.run();
        this.jRP.unlock();
    }

    @TargetApi(18)
    public final boolean acW() {
        return this.ty.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
}
