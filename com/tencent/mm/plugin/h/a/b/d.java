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
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d {
    private int hEV;
    private BluetoothAdapter jQw;
    BluetoothGattCharacteristic jRA;
    BluetoothGattCharacteristic jRB;
    a jRC;
    Runnable jRD;
    public Runnable jRE;
    public Runnable jRF;
    d jRG;
    final LinkedList<byte[]> jRH;
    volatile boolean jRI;
    private HandlerThread jRJ;
    public int jRK;
    final BluetoothGattCallback jRL;
    public long jRv;
    BluetoothDevice jRw;
    Context jRx;
    BluetoothGatt jRy;
    public b jRz;
    public ae mHandler;

    private static class a extends ae {
        private final WeakReference<d> jRN;

        public a(Looper looper, d dVar) {
            super(looper);
            this.jRN = new WeakReference(dVar);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            d dVar = (d) this.jRN.get();
            if (dVar == null) {
                w.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
                return;
            }
            byte[] acU;
            int i;
            int i2;
            switch (message.what) {
                case 0:
                    w.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                    if (1 == dVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                        return;
                    } else if (dVar.jRK == 0) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                        return;
                    } else {
                        dVar.acZ();
                        if (dVar.jRy == null) {
                            dVar.jRy = dVar.jRw.connectGatt(dVar.jRx, false, dVar.jRL);
                            if (dVar.jRy == null) {
                                w.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                                if (dVar.jRz != null) {
                                    dVar.jRz.jRc.e(dVar.jRv, false);
                                    return;
                                }
                                return;
                            }
                            dVar.jRK = 0;
                            dVar.mHandler.postDelayed(dVar.jRF, 10000);
                            return;
                        } else if (dVar.jRy.connect()) {
                            dVar.jRK = 0;
                            dVar.mHandler.postDelayed(dVar.jRF, 10000);
                            return;
                        } else {
                            w.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                            if (dVar.jRz != null) {
                                dVar.jRz.jRc.e(dVar.jRv, false);
                                return;
                            }
                            return;
                        }
                    }
                case 1:
                    w.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
                    if (3 == dVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
                        return;
                    }
                    dVar.acZ();
                    if (dVar.jRy == null) {
                        w.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
                        return;
                    }
                    dVar.jRK = 3;
                    dVar.mHandler.removeCallbacks(dVar.jRF);
                    dVar.mHandler.removeCallbacks(dVar.jRE);
                    dVar.jRy.disconnect();
                    return;
                case 2:
                    w.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
                    if (3 == dVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
                        return;
                    }
                    dVar.acZ();
                    if (dVar.jRy == null) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
                        return;
                    }
                    dVar.jRK = 3;
                    dVar.jRy.disconnect();
                    dVar.jRy.close();
                    dVar.jRy = null;
                    return;
                case 3:
                    w.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[]{Integer.valueOf(((byte[]) message.obj).length)});
                    if (1 != dVar.jRK) {
                        w.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[]{Integer.valueOf(dVar.jRK)});
                        if (dVar.jRz != null) {
                            dVar.jRz.jRc.f(dVar.jRv, false);
                            return;
                        }
                        return;
                    }
                    boolean z2 = (dVar.jRy == null || dVar.jRB == null) ? false : true;
                    Assert.assertTrue(z2);
                    dVar.jRH.add(acU);
                    if (!dVar.jRI) {
                        if (1 != dVar.jRH.size()) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        dVar.ada();
                        return;
                    }
                    return;
                case 4:
                    i = message.arg1;
                    String str = "MicroMsg.exdevice.BluetoothLESession";
                    String str2 = "------onConnectionStateChangeImp------ aState = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = i == 2 ? "Connected" : "Disconnected";
                    w.i(str, str2, objArr);
                    if (i == 2) {
                        w.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[]{Integer.valueOf(dVar.jRK)});
                        if (3 == dVar.jRK) {
                            w.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.jRF);
                            return;
                        } else if (1 == dVar.jRK) {
                            w.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.jRF);
                            return;
                        } else if (dVar.jRy.discoverServices()) {
                            w.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                            return;
                        } else {
                            w.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                            dVar.jRK = 2;
                            dVar.mHandler.removeCallbacks(dVar.jRF);
                            if (dVar.jRz != null) {
                                dVar.jRz.jRc.e(dVar.jRv, false);
                                return;
                            }
                            return;
                        }
                    } else if (i == 0) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                        dVar.jRK = 2;
                        dVar.mHandler.removeCallbacks(dVar.jRF);
                        if (dVar.jRz != null) {
                            dVar.jRz.jRc.e(dVar.jRv, false);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 5:
                    BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                    w.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[]{Integer.valueOf(message.arg1)});
                    if (3 == dVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.jRF);
                        return;
                    } else if (1 == dVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.jRF);
                        return;
                    } else if (i != 0) {
                        w.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                        dVar.jRK = 2;
                        dVar.mHandler.removeCallbacks(dVar.jRF);
                        if (dVar.jRz != null) {
                            dVar.jRz.jRc.e(dVar.jRv, false);
                            return;
                        }
                        return;
                    } else {
                        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(h.jSq));
                        if (service == null) {
                            w.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                            dVar.jRK = 2;
                            dVar.mHandler.removeCallbacks(dVar.jRF);
                            if (dVar.jRz != null) {
                                dVar.jRz.jRc.e(dVar.jRv, false);
                                return;
                            }
                            return;
                        }
                        dVar.jRA = service.getCharacteristic(UUID.fromString(h.jSs));
                        if (dVar.jRA == null) {
                            w.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                            dVar.jRK = 2;
                            dVar.mHandler.removeCallbacks(dVar.jRF);
                            if (dVar.jRz != null) {
                                dVar.jRz.jRc.e(dVar.jRv, false);
                                return;
                            }
                            return;
                        }
                        dVar.jRB = service.getCharacteristic(UUID.fromString(h.jSr));
                        if (dVar.jRB == null) {
                            w.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                            dVar.jRK = 2;
                            dVar.mHandler.removeCallbacks(dVar.jRF);
                            if (dVar.jRz != null) {
                                dVar.jRz.jRc.e(dVar.jRv, false);
                                return;
                            }
                            return;
                        }
                        w.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[]{Integer.valueOf(dVar.jRA.getProperties())});
                        if ((dVar.jRA.getProperties() & 32) == 0) {
                            w.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
                            dVar.jRK = 2;
                            dVar.mHandler.removeCallbacks(dVar.jRF);
                            if (dVar.jRz != null) {
                                dVar.jRz.jRc.e(dVar.jRv, false);
                                return;
                            }
                            return;
                        }
                        w.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
                        d dVar2 = dVar.jRG;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = dVar.jRA;
                        if (dVar2.jRy.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.jSp));
                            if (descriptor == null) {
                                w.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                                z = false;
                            } else {
                                w.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + descriptor.getPermissions());
                                if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
                                    w.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                                    z = false;
                                } else if (dVar2.jRy.writeDescriptor(descriptor)) {
                                    dVar2.mHandler.postDelayed(dVar2.jRE, 5000);
                                } else {
                                    w.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                                    z = false;
                                }
                            }
                        } else {
                            w.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
                            z = false;
                        }
                        if (!z) {
                            w.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
                            dVar.jRK = 2;
                            dVar.mHandler.removeCallbacks(dVar.jRF);
                            if (dVar.jRz != null) {
                                dVar.jRz.jRc.e(dVar.jRv, false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                case 6:
                    Object obj = message.obj;
                    w.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[]{Integer.valueOf(message.arg1)});
                    dVar.mHandler.removeCallbacks(dVar.jRE);
                    dVar.mHandler.removeCallbacks(dVar.jRF);
                    if (3 == dVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        return;
                    } else if (1 == dVar.jRK) {
                        w.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        return;
                    } else if (i2 != 0) {
                        w.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
                        dVar.jRK = 2;
                        if (dVar.jRz != null) {
                            dVar.jRz.jRc.e(dVar.jRv, false);
                            return;
                        }
                        return;
                    } else {
                        dVar.jRK = 1;
                        if (dVar.jRz != null) {
                            dVar.jRz.jRc.e(dVar.jRv, true);
                        }
                        w.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[]{Integer.valueOf(dVar.jRK)});
                        return;
                    }
                case 7:
                    i2 = message.arg1;
                    w.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[]{Integer.valueOf(i2)});
                    dVar.mHandler.removeCallbacks(dVar.jRD);
                    if (i2 != 0) {
                        w.e("MicroMsg.exdevice.BluetoothLESession", "write data error: " + i2);
                        if (dVar.jRz != null) {
                            dVar.jRz.jRc.f(dVar.jRv, false);
                        }
                        dVar.ada();
                        return;
                    }
                    acU = dVar.jRC.acU();
                    w.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[]{b.aj(acU)});
                    if (acU == null) {
                        w.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
                        if (dVar.jRz != null) {
                            dVar.jRz.jRc.f(dVar.jRv, true);
                        }
                        dVar.ada();
                        return;
                    }
                    w.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
                    dVar.jRB.setValue(acU);
                    dVar.jRy.writeCharacteristic(dVar.jRB);
                    dVar.mHandler.postDelayed(dVar.jRD, 5000);
                    return;
                case 8:
                    acU = (byte[]) message.obj;
                    w.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
                    if (bg.bm(acU)) {
                        w.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
                        return;
                    }
                    String w = b.w(acU, acU.length);
                    w.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[]{Integer.valueOf(acU.length)});
                    w.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[]{w});
                    if (dVar.jRz != null) {
                        dVar.jRz.jRc.b(dVar.jRv, acU);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @TargetApi(18)
    public d(long j, Context context, b bVar) {
        this.jRH = new LinkedList();
        this.jRI = false;
        this.jRL = new BluetoothGattCallback(this) {
            final /* synthetic */ d jRM;

            {
                this.jRM = r1;
            }

            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                w.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.jRM.jRK)});
                if (!this.jRM.mHandler.sendMessage(this.jRM.mHandler.obtainMessage(4, i2, 0))) {
                    w.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(4)});
                }
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                w.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.jRM.mHandler.sendMessage(this.jRM.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    w.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(5)});
                }
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                w.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.jRM.mHandler.sendMessage(this.jRM.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    w.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(6)});
                }
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                w.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
                if (!this.jRM.mHandler.sendMessage(this.jRM.mHandler.obtainMessage(8, bluetoothGattCharacteristic.getValue()))) {
                    w.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
                }
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                w.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[]{Integer.valueOf(i)});
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                w.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.jRM.mHandler.sendMessage(this.jRM.mHandler.obtainMessage(7, i, 0))) {
                    w.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(7)});
                }
            }
        };
        this.hEV = -1;
        this.hEV = hashCode();
        this.jRG = this;
        this.jRz = bVar;
        this.jRx = context;
        this.jQw = ((BluetoothManager) this.jRx.getSystemService("bluetooth")).getAdapter();
        this.jRv = j;
        this.jRK = 3;
        this.jRw = this.jQw.getRemoteDevice(com.tencent.mm.plugin.h.a.e.a.aL(j));
        this.jRA = null;
        this.jRB = null;
        this.jRC = new a();
        this.jRJ = e.Qu("BluetoothLESession_handlerThread");
        this.jRJ.start();
        this.mHandler = new a(this.jRJ.getLooper(), this);
        this.jRD = new Runnable(this) {
            final /* synthetic */ d jRM;

            {
                this.jRM = r1;
            }

            public final void run() {
                w.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
                if (this.jRM.jRz != null) {
                    this.jRM.jRz.jRc.f(this.jRM.jRv, false);
                }
                this.jRM.ada();
            }
        };
        this.jRE = new Runnable(this) {
            final /* synthetic */ d jRM;

            {
                this.jRM = r1;
            }

            public final void run() {
                w.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
                if (3 == this.jRM.jRK) {
                    w.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    return;
                }
                this.jRM.mHandler.removeCallbacks(this.jRM.jRF);
                this.jRM.jRK = 2;
                if (this.jRM.jRz != null) {
                    this.jRM.jRz.jRc.e(this.jRM.jRv, false);
                }
            }
        };
        this.jRF = new Runnable(this) {
            final /* synthetic */ d jRM;

            {
                this.jRM = r1;
            }

            public final void run() {
                w.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
                if (3 == this.jRM.jRK) {
                    w.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    return;
                }
                this.jRM.mHandler.removeCallbacks(this.jRM.jRE);
                this.jRM.jRK = 2;
                if (this.jRM.jRz != null) {
                    this.jRM.jRz.jRc.e(this.jRM.jRv, false);
                }
            }
        };
    }

    public final boolean connect() {
        w.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    public final void close() {
        w.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
            w.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(2)});
        }
        this.jRJ.quitSafely();
    }

    final void acZ() {
        this.jRI = false;
        this.jRH.clear();
    }

    public final void ada() {
        if (this.jRH.isEmpty()) {
            this.jRI = false;
            return;
        }
        this.jRC.setData((byte[]) this.jRH.pop());
        w.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[]{b.aj(this.jRC.acU())});
        this.jRB.setValue(r0);
        this.mHandler.postDelayed(this.jRD, 5000);
        if (!this.jRy.writeCharacteristic(this.jRB)) {
            w.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
        }
        this.jRI = true;
    }
}
