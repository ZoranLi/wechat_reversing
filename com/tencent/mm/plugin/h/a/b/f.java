package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.h.a.b.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class f {
    static int jSh = 0;
    private int hEV;
    private BluetoothAdapter jQw;
    private a jRC;
    private Runnable jRD;
    Runnable jRF;
    private final LinkedList<byte[]> jRH;
    private volatile boolean jRI;
    private HandlerThread jRJ;
    public volatile int jRK;
    final BluetoothGattCallback jRL;
    public long jRv;
    public BluetoothDevice jRw;
    Context jRx;
    BluetoothGatt jRy;
    public a jSa;
    private Runnable jSb;
    private f jSc;
    HashMap<String, HashMap<String, BluetoothGattCharacteristic>> jSd;
    public long jSe;
    ArrayList<BluetoothGattCharacteristic> jSf;
    public boolean jSg;
    public ae mHandler;

    public static abstract class a {
        public void a(long j, boolean z, long j2) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void f(long j, boolean z) {
        }
    }

    private static class b extends ae {
        private final WeakReference<f> jRN;

        public b(Looper looper, f fVar) {
            super(looper);
            this.jRN = new WeakReference(fVar);
        }

        public final void handleMessage(Message message) {
            f fVar = (f) this.jRN.get();
            if (fVar == null) {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
                return;
            }
            int i;
            Object obj;
            switch (message.what) {
                case 0:
                    w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connectImp------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(fVar.jRv), fVar.jRw.getName()});
                    if (1 == fVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connected !!!");
                        if (fVar.jSa != null) {
                            w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device has connected, just callback.");
                            fVar.jSa.a(fVar.jRv, true, fVar.jSe);
                            return;
                        }
                        return;
                    } else if (fVar.jRK == 0) {
                        w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connecting !!!");
                        return;
                    } else {
                        fVar.acZ();
                        if (fVar.jRy == null) {
                            fVar.jRy = fVar.jRw.connectGatt(fVar.jRx, false, fVar.jRL);
                            f.jSh++;
                            w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------create resource------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(fVar.hashCode()), Integer.valueOf(f.jSh), com.tencent.mm.plugin.exdevice.j.b.bG(fVar.jRv), fVar.jRw.getName()});
                            if (fVar.jRy == null) {
                                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mDevice.connectGatt Failed!!!");
                                fVar.adg();
                                return;
                            }
                            fVar.jRK = 0;
                            fVar.mHandler.postDelayed(fVar.jRF, 10000);
                            return;
                        } else if (fVar.jRy.connect()) {
                            fVar.jRK = 0;
                            fVar.mHandler.postDelayed(fVar.jRF, 10000);
                            return;
                        } else {
                            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.connect() Failed!!!");
                            fVar.adg();
                            return;
                        }
                    }
                case 1:
                    fVar.ade();
                    return;
                case 2:
                    fVar.adf();
                    return;
                case 3:
                    fVar.X((byte[]) message.obj);
                    return;
                case 4:
                    i = message.arg1;
                    String str = "MicroMsg.exdevice.BluetoothLESimpleSession";
                    String str2 = "------onConnectionStateChangeImp------ aState = %s, mac=%s, name=%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = i == 2 ? "Connected" : "Disconnected";
                    objArr[1] = com.tencent.mm.plugin.exdevice.j.b.bG(fVar.jRv);
                    objArr[2] = fVar.jRw.getName();
                    w.i(str, str2, objArr);
                    if (i == 2) {
                        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "PHY Connected is OK, mConnectState = %d", new Object[]{Integer.valueOf(fVar.jRK)});
                        if (3 == fVar.jRK) {
                            w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Leave without discover Services");
                            fVar.mHandler.removeCallbacks(fVar.jRF);
                            return;
                        } else if (1 == fVar.jRK) {
                            w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Leave without discover Services");
                            fVar.mHandler.removeCallbacks(fVar.jRF);
                            return;
                        } else if (fVar.jRy.discoverServices()) {
                            fVar.mHandler.removeCallbacks(fVar.jRF);
                            fVar.mHandler.postDelayed(fVar.jRF, 10000);
                            w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "start discoverServices...");
                            return;
                        } else {
                            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "discover Services start failed!!!");
                            fVar.adb();
                            return;
                        }
                    } else if (i == 0) {
                        w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Disconnected from GATT server.");
                        fVar.jSd.clear();
                        fVar.jSf.clear();
                        fVar.jSe = 0;
                        fVar.adb();
                        return;
                    } else {
                        return;
                    }
                case 5:
                    BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                    w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "onServicesDiscoveredImp, status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(message.arg1), com.tencent.mm.plugin.exdevice.j.b.bG(fVar.jRv), fVar.jRw.getName()});
                    fVar.mHandler.removeCallbacks(fVar.jRF);
                    if (3 == fVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Just Leave");
                        obj = null;
                    } else {
                        if (1 == fVar.jRK) {
                            w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Just Leave");
                        } else if (i != 0) {
                            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Discover services error");
                            fVar.adb();
                            obj = null;
                        } else {
                            List services = bluetoothGatt.getServices();
                            for (int i2 = 0; i2 < services.size(); i2++) {
                                Object obj2;
                                BluetoothGattService bluetoothGattService = (BluetoothGattService) services.get(i2);
                                if (bluetoothGattService == null) {
                                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service is null");
                                    obj2 = null;
                                } else if (c.b(bluetoothGattService)) {
                                    fVar.jSe |= c.a(bluetoothGattService);
                                    HashMap hashMap = new HashMap();
                                    List characteristics = bluetoothGattService.getCharacteristics();
                                    for (int i3 = 0; i3 < characteristics.size(); i3++) {
                                        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristics.get(i3);
                                        Object uuid = bluetoothGattCharacteristic.getUuid().toString();
                                        int properties = bluetoothGattCharacteristic.getProperties();
                                        int permissions = bluetoothGattCharacteristic.getPermissions();
                                        w.d("MicroMsg.exdevice.BluetoothLESimpleSession", "found characteristic = %s, properties = %d, permission = %d", new Object[]{uuid, Integer.valueOf(properties), Integer.valueOf(permissions)});
                                        if (uuid == null) {
                                            uuid = "null";
                                        }
                                        hashMap.put(uuid, bluetoothGattCharacteristic);
                                        fVar.jSf.add(bluetoothGattCharacteristic);
                                    }
                                    fVar.jSd.put(bluetoothGattService.getUuid().toString(), hashMap);
                                    obj2 = 1;
                                } else {
                                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse service error");
                                    obj2 = null;
                                }
                                if (obj2 == null) {
                                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parseService error. service uuid = %s", new Object[]{bluetoothGattService.getUuid().toString()});
                                }
                            }
                            if (0 == fVar.jSe) {
                                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "the device hasn't pass test");
                                fVar.adb();
                                obj = null;
                            } else if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
                                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(9)});
                            }
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        fVar.disconnect();
                        return;
                    }
                    return;
                case 6:
                    obj = message.obj;
                    fVar.jL(message.arg1);
                    return;
                case 7:
                    fVar.jM(message.arg1);
                    return;
                case 8:
                    fVar.a((BluetoothGattCharacteristic) message.obj);
                    return;
                case 9:
                    fVar.adh();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceiveImp------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        if (bluetoothGattCharacteristic == null) {
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic is null");
            return;
        }
        byte[] value = bluetoothGattCharacteristic.getValue();
        String w = com.tencent.mm.plugin.exdevice.j.b.w(value, value.length);
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "data length = %d", new Object[]{Integer.valueOf(value.length)});
        w.d("MicroMsg.exdevice.BluetoothLESimpleSession", "data dump = %s", new Object[]{w});
        value = c.a(bluetoothGattCharacteristic, value);
        if (value == null) {
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse data error");
        } else if (this.jSa != null) {
            this.jSa.b(this.jRv, value);
        }
    }

    final void adb() {
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        this.jRK = 2;
        this.mHandler.removeCallbacks(this.jRF);
        this.mHandler.removeCallbacks(this.jSb);
        adg();
        adc();
    }

    public final void jL(int i) {
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWriteImp------ status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(9))) {
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(9)});
        }
    }

    public final void jM(int i) {
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallbackImp------ status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        this.mHandler.removeCallbacks(this.jRD);
        if (i != 0) {
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error: " + i);
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
            }
            ada();
            return;
        }
        byte[] acU = this.jRC.acU();
        w.d("MicroMsg.exdevice.BluetoothLESimpleSession", "Out data dump = %s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.aj(acU)});
        if (acU == null) {
            w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write data complete");
            if (this.jSa != null) {
                this.jSa.f(this.jRv, true);
            }
            ada();
            return;
        }
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write next chunk...");
        this.jRC.jRb.setValue(acU);
        this.jRy.writeCharacteristic(this.jRC.jRb);
        this.mHandler.postDelayed(this.jRD, 5000);
    }

    @TargetApi(18)
    public f(long j, Context context, a aVar) {
        this.jRH = new LinkedList();
        this.jRI = false;
        this.jSd = new HashMap();
        this.jSe = 0;
        this.jSf = new ArrayList();
        this.jRL = new BluetoothGattCallback(this) {
            final /* synthetic */ f jSi;

            {
                this.jSi = r1;
            }

            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.jSi.jRK)});
                if (!this.jSi.mHandler.sendMessage(this.jSi.mHandler.obtainMessage(4, i2, 0))) {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(4)});
                }
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.jSi.mHandler.sendMessage(this.jSi.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(5)});
                }
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.jSi.mHandler.sendMessage(this.jSi.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(6)});
                }
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
                if (!this.jSi.mHandler.sendMessage(this.jSi.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
                }
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[]{Integer.valueOf(i)});
                if (i == 0 && !this.jSi.mHandler.sendMessage(this.jSi.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
                }
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.jSi.mHandler.sendMessage(this.jSi.mHandler.obtainMessage(7, i, 0))) {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(7)});
                }
            }
        };
        this.hEV = -1;
        this.hEV = hashCode();
        this.jSc = this;
        this.jSa = aVar;
        this.jRx = context;
        this.jQw = ((BluetoothManager) this.jRx.getSystemService("bluetooth")).getAdapter();
        this.jRv = j;
        this.jRK = 3;
        this.jRw = this.jQw.getRemoteDevice(com.tencent.mm.plugin.h.a.e.a.aL(j));
        this.jRC = new a();
        this.jSg = false;
        this.jRJ = e.Qu("BluetoothLESimpleSession_handlerThread");
        this.jRJ.start();
        this.mHandler = new b(this.jRJ.getLooper(), this);
        this.jRD = new Runnable(this) {
            final /* synthetic */ f jSi;

            {
                this.jSi = r1;
            }

            public final void run() {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jSi.jRv), this.jSi.jRw.getName()});
                if (this.jSi.jSa != null) {
                    this.jSi.jSa.f(this.jSi.jRv, false);
                }
                this.jSi.ada();
            }
        };
        this.jRF = new Runnable(this) {
            final /* synthetic */ f jSi;

            {
                this.jSi = r1;
            }

            public final void run() {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jSi.jRv), this.jSi.jRw.getName()});
                if (3 == this.jSi.jRK) {
                    w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
                } else if (this.jSi.jRK == 1) {
                    w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
                } else {
                    this.jSi.adb();
                }
            }
        };
        this.jSb = new Runnable(this) {
            final /* synthetic */ f jSi;

            {
                this.jSi = r1;
            }

            public final void run() {
                if (this.jSi.jSg) {
                    if (this.jSi.jSa != null) {
                        this.jSi.jSa.a(this.jSi.jRv, false, this.jSi.jSe);
                    }
                    w.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
                    this.jSi.adc();
                }
            }
        };
    }

    public final void adc() {
        if (this.jRy == null) {
            w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(hashCode()), com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
            return;
        }
        jSh--;
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(jSh), com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        this.jSg = false;
        this.jRy.close();
        this.jRJ.quitSafely();
        this.jRy = null;
        this.jRJ = null;
    }

    public final boolean connect() {
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    public final void ade() {
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnectImp------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        if (3 == this.jRK) {
            w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "diconnect or close is called aready, just leave");
        } else if (2 == this.jRK) {
            w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "already disconnected, just leave");
        } else {
            acZ();
            if (this.jRy == null) {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect:BluetoothGatt not found");
                return;
            }
            this.jRK = 3;
            this.mHandler.removeCallbacks(this.jRF);
            if (this.jRy != null) {
                this.jRy.disconnect();
            }
        }
    }

    public final void disconnect() {
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(1)});
        }
    }

    public final void adf() {
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------closeImp------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        if (3 == this.jRK) {
            w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close aready, Just leave");
            adg();
            return;
        }
        acZ();
        if (this.jRy == null) {
            w.w("MicroMsg.exdevice.BluetoothLESimpleSession", "close:BluetoothGatt not found");
            adg();
            return;
        }
        this.jRK = 3;
        this.mHandler.removeCallbacks(this.jRF);
        adg();
        if (this.jRy != null) {
            w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect gatt, and wait gatt disconnected callback, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
            this.jRy.disconnect();
            this.jSg = true;
            this.mHandler.postDelayed(this.jSb, 10000);
        }
    }

    public final void X(byte[] bArr) {
        boolean z = true;
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeDataAsync------parserobj length = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        if (1 != this.jRK) {
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Not ready for write data, connectstate = %d", new Object[]{Integer.valueOf(this.jRK)});
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
                return;
            }
            return;
        }
        com.tencent.mm.plugin.h.a.b.a.a Y = com.tencent.mm.plugin.h.a.b.a.a.Y(bArr);
        w.d("MicroMsg.exdevice.BluetoothLESimpleSession", "rawData data dump = %s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.aj(Y.adj())});
        String str = Y.jSL;
        int i = Y.jSM;
        HashMap hashMap = (HashMap) this.jSd.get(c.aJ(Y.jSe));
        if (hashMap == null) {
            String str2;
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found", new Object[]{str2});
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        String str3;
        if (bluetoothGattCharacteristic == null) {
            String str4;
            str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            str2 = "characteristic(%s) not found";
            Object[] objArr = new Object[1];
            if (str == null) {
                str4 = "null";
            } else {
                str4 = str;
            }
            objArr[0] = str4;
            w.e(str3, str2, objArr);
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
            }
        } else if ((bluetoothGattCharacteristic.getProperties() | i) == 0) {
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "property not support. current = %d, provided = %d", new Object[]{Integer.valueOf(bluetoothGattCharacteristic.getProperties()), Integer.valueOf(i)});
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
            }
        } else if (i == 2) {
            if (bluetoothGattCharacteristic == null) {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic not found");
                r0 = false;
            } else if (this.jRy.readCharacteristic(bluetoothGattCharacteristic)) {
                r0 = true;
            } else {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.readCharacteristic Failed!!!");
                r0 = false;
            }
            str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            str2 = "readCharacteristic state: %s";
            Object[] objArr2 = new Object[1];
            objArr2[0] = r0 ? "true" : "false";
            w.d(str3, str2, objArr2);
            if (this.jSa == null) {
                return;
            }
            if (r0) {
                this.jSa.f(this.jRv, true);
            } else {
                this.jSa.f(this.jRv, false);
            }
        } else {
            if (this.jRy != null) {
                r0 = true;
            } else {
                r0 = false;
            }
            Assert.assertTrue(r0);
            this.jRH.add(bArr);
            if (!this.jRI) {
                if (1 != this.jRH.size()) {
                    z = false;
                }
                Assert.assertTrue(z);
                ada();
            }
        }
    }

    final void acZ() {
        this.jRI = false;
        this.jRH.clear();
    }

    final void adg() {
        if (this.jSa == null) {
            w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
            return;
        }
        w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
        if (this.jSa != null) {
            this.jSa.a(this.jRv, false, this.jSe);
        }
        this.jSa = null;
    }

    public final void ada() {
        if (this.jRH.isEmpty()) {
            this.jRI = false;
            return;
        }
        com.tencent.mm.plugin.h.a.b.a.a Y = com.tencent.mm.plugin.h.a.b.a.a.Y((byte[]) this.jRH.pop());
        byte[] adj = Y.adj();
        String str = Y.jSL;
        int i = Y.jSM;
        HashMap hashMap = (HashMap) this.jSd.get(c.aJ(Y.jSe));
        if (hashMap == null) {
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[]{r4, com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        if (bluetoothGattCharacteristic == null) {
            String str2;
            String str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            String str4 = "characteristic(%s) not found, mac=%s, name=%s";
            Object[] objArr = new Object[3];
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            objArr[0] = str2;
            objArr[1] = com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv);
            objArr[2] = this.jRw.getName();
            w.e(str3, str4, objArr);
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
            }
        } else if (i == 8) {
            this.jRC.jRb = bluetoothGattCharacteristic;
            this.jRC.setData(adj);
            w.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.aj(this.jRC.acU()), str, com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
            bluetoothGattCharacteristic.setValue(adj);
            this.mHandler.postDelayed(this.jRD, 5000);
            if (this.jRy.writeCharacteristic(bluetoothGattCharacteristic)) {
                this.jRI = true;
                return;
            }
            w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
            }
        } else {
            w.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.bG(this.jRv), this.jRw.getName()});
            if (this.jSa != null) {
                this.jSa.f(this.jRv, false);
            }
        }
    }

    public final void adh() {
        while (this.jSf.size() > 0) {
            int i;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) this.jSf.remove(0);
            f fVar = this.jSc;
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 48) == 0) {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "no indicate and notify");
                i = 0;
            } else if (fVar.jRy.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.jSp));
                if (descriptor == null) {
                    w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not get configure descriptor");
                    i = 0;
                } else {
                    w.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Configure descriptor permissions: " + descriptor.getPermissions());
                    byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                    if ((properties & 32) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1]);
                    }
                    if ((properties & 16) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[1]);
                    }
                    if (!descriptor.setValue(bArr)) {
                        w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not set configure descriptor value");
                        i = 0;
                    } else if (fVar.jRy.writeDescriptor(descriptor)) {
                        boolean z = true;
                    } else {
                        w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not write configure descriptor value");
                        i = 0;
                    }
                }
            } else {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Unable to set indicator for read characteristic");
                i = 0;
            }
            if (i == 0) {
                w.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mSelfSession.setCharacteristicNotification Failed!!!. uuid = %s, properties = %d", new Object[]{bluetoothGattCharacteristic.getUuid().toString(), Integer.valueOf(bluetoothGattCharacteristic.getProperties())});
            } else {
                return;
            }
        }
        w.d("MicroMsg.exdevice.BluetoothLESimpleSession", "onConnected = true");
        this.jRK = 1;
        this.mHandler.removeCallbacks(this.jRF);
        if (this.jSa != null) {
            this.jSa.a(this.jRv, true, this.jSe);
        }
    }
}
