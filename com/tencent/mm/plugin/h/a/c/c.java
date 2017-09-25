package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import junit.framework.Assert;

public final class c {

    public static final class a {
        private final HandlerThread jRJ;
        BluetoothSocket jUr;
        final boolean jUs = true;
        public final b jUt;
        public final a jUu;
        boolean jUv = false;
        final BluetoothDevice jUw;
        public final ae mHandler;

        private static class a extends ae {
            private WeakReference<a> jRN = null;

            public a(Looper looper, a aVar) {
                super(looper);
                this.jRN = new WeakReference(aVar);
            }

            public final void handleMessage(Message message) {
                a aVar = (a) this.jRN.get();
                if (aVar == null) {
                    w.e("MicroMsg.exdevice.BluetoothChatThreads", "null == connectTread");
                    return;
                }
                switch (message.what) {
                    case 0:
                        w.i("MicroMsg.exdevice.ConnectThread", "------connectImp------");
                        if (aVar.jUv) {
                            w.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready connect, just leave");
                            return;
                        }
                        try {
                            if (aVar.jUs) {
                                aVar.jUr = aVar.jUw.createRfcommSocketToServiceRecord(a.jUi);
                            } else {
                                aVar.jUr = aVar.jUw.createInsecureRfcommSocketToServiceRecord(a.jUj);
                            }
                            try {
                                aVar.jUr.connect();
                                aVar.jUv = true;
                                b bVar = aVar.jUt;
                                a aVar2 = aVar.jUu;
                                BluetoothSocket bluetoothSocket = aVar.jUr;
                                w.i("MicroMsg.exdevice.BluetoothChatSession", "connected");
                                bVar.mState = 3;
                                if (bVar.jUp != null) {
                                    bVar.jUp.cancel();
                                    bVar.jUp = null;
                                }
                                if (bVar.jUq != null) {
                                    bVar.jUq.cancel();
                                    bVar.jUq = null;
                                }
                                bVar.jUp = new b(bVar, aVar2, bluetoothSocket);
                                e.b(bVar.jUp, "BluetoothChatSession_recv").start();
                                bVar.jUq = new c(bVar, aVar2, bluetoothSocket);
                                e.b(bVar.jUq, "BluetoothChatSession_send").start();
                                if (aVar.jUu != null) {
                                    aVar.jUu.jUk.e(aVar.jUt.jRv, true);
                                    return;
                                }
                                return;
                            } catch (IOException e) {
                                w.e("MicroMsg.exdevice.ConnectThread", "socket connect failed (%s)", new Object[]{e.toString()});
                                try {
                                    aVar.jUr.close();
                                } catch (IOException e2) {
                                    w.e("MicroMsg.exdevice.ConnectThread", "Close socket failed!!! (%s)", new Object[]{e2.toString()});
                                }
                                if (aVar.jUu != null) {
                                    aVar.jUu.jUk.e(aVar.jUt.jRv, false);
                                    return;
                                }
                                return;
                            }
                        } catch (IOException e22) {
                            aVar.jUr = null;
                            w.e("MicroMsg.exdevice.ConnectThread", "createRfcommSocket Failed!!! (%s)", new Object[]{e22.toString()});
                            if (aVar.jUu != null) {
                                aVar.jUu.jUk.e(aVar.jUt.jRv, false);
                                return;
                            }
                            return;
                        }
                    case 1:
                        if (aVar.jUv) {
                            try {
                                aVar.jUr.close();
                                return;
                            } catch (IOException e3) {
                                w.e("MicroMsg.exdevice.ConnectThread", "socket close failed (%s)", new Object[]{e3.toString()});
                                return;
                            }
                        }
                        w.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready disconnect, just leave");
                        return;
                    default:
                        return;
                }
            }
        }

        public a(b bVar, a aVar, BluetoothDevice bluetoothDevice, boolean z) {
            this.jUu = aVar;
            this.jUt = bVar;
            this.jUw = bluetoothDevice;
            this.jRJ = e.Qu("BluetoothChatThreads_handlerThread");
            this.jRJ.start();
            this.mHandler = new a(this.jRJ.getLooper(), this);
        }

        public final void disconnect() {
            w.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
            if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
                w.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[]{Integer.valueOf(1)});
            }
            if (f.eo(18)) {
                this.jRJ.quitSafely();
            } else {
                this.jRJ.quit();
            }
        }
    }

    public static final class b implements Runnable {
        private final BluetoothSocket jUr;
        private b jUt;
        a jUu;
        private InputStream jUx = null;
        private volatile boolean jUy = false;

        public b(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            this.jUr = bluetoothSocket;
            this.jUt = bVar;
            this.jUu = aVar;
            try {
                this.jUx = bluetoothSocket.getInputStream();
            } catch (IOException e) {
                this.jUx = null;
                w.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", new Object[]{e.toString()});
            }
        }

        public final void run() {
            w.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
            if (this.jUx == null) {
                w.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
                return;
            }
            Object obj = new byte[2048];
            while (!this.jUy) {
                try {
                    int read = this.jUx.read(obj);
                    if (read > 0) {
                        w.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", new Object[]{Integer.valueOf(read)});
                        w.d("MicroMsg.exdevice.RecvThread", "data dump = %s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.w(obj, read)});
                        Object obj2 = new byte[read];
                        System.arraycopy(obj, 0, obj2, 0, read);
                        if (this.jUu != null) {
                            this.jUu.jUk.b(this.jUt.jRv, obj2);
                        }
                    }
                } catch (IOException e) {
                    w.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", new Object[]{e.toString()});
                    try {
                        this.jUr.close();
                        return;
                    } catch (IOException e2) {
                        w.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", new Object[]{e2.toString()});
                        return;
                    }
                }
            }
            w.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        }

        public final void cancel() {
            w.i("MicroMsg.exdevice.RecvThread", "------cancel------");
            if (this.jUy) {
                w.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
                return;
            }
            this.jUy = true;
            e.O(this);
            try {
                this.jUr.close();
            } catch (IOException e) {
                w.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", new Object[]{e});
            }
        }
    }

    public static final class c implements Runnable {
        private OutputStream jUA = null;
        private final LinkedList<byte[]> jUB = new LinkedList();
        private final LinkedList<byte[]> jUC = new LinkedList();
        private b jUt = null;
        private a jUu = null;
        private volatile boolean jUy = false;
        private volatile Runnable jUz = null;

        public c(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            this.jUt = bVar;
            this.jUu = aVar;
            try {
                OutputStream outputStream = bluetoothSocket.getOutputStream();
                this.jUz = this;
                this.jUA = outputStream;
            } catch (IOException e) {
                w.e("MicroMsg.exdevice.SendThread", "temp sockets not created", new Object[]{e});
                this.jUA = null;
                if (this.jUu != null) {
                    this.jUu.jUk.b(this.jUt.jRv, 11, "Can not get write stream");
                }
            }
        }

        public final void run() {
            w.i("MicroMsg.exdevice.SendThread", "BEGIN SendThread");
            if (this.jUA != null) {
                while (!this.jUy) {
                    if (this.jUz == null) {
                        w.w("MicroMsg.exdevice.SendThread", "Send thread has been close. just leave");
                        return;
                    } else if (!this.jUC.isEmpty()) {
                        try {
                            this.jUA.write((byte[]) this.jUC.pop());
                            if (this.jUu != null) {
                                this.jUu.jUk.f(this.jUt.jRv, true);
                            }
                        } catch (IOException e) {
                            if (this.jUu != null) {
                                this.jUu.jUk.f(this.jUt.jRv, false);
                            }
                        }
                    } else if (this.jUB.isEmpty()) {
                        synchronized (this) {
                            try {
                                wait();
                            } catch (Throwable e2) {
                                w.printErrStackTrace("MicroMsg.exdevice.SendThread", e2, "", new Object[0]);
                                w.w("MicroMsg.exdevice.SendThread", "BluetoothChatThread_SendRunnable InterruptedException...");
                            }
                        }
                    } else {
                        synchronized (this.jUB) {
                            Assert.assertTrue(this.jUC.addAll(this.jUB));
                            this.jUB.clear();
                        }
                    }
                }
            }
        }

        public final boolean aa(byte[] bArr) {
            w.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", new Object[]{Integer.valueOf(bArr.length)});
            if (this.jUz == null) {
                w.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
                return false;
            }
            synchronized (this) {
                this.jUB.add(bArr);
                notify();
            }
            return true;
        }

        public final void cancel() {
            this.jUz = null;
            this.jUy = true;
            synchronized (this) {
                notify();
            }
            this.jUC.clear();
            this.jUB.clear();
        }
    }
}
