package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.e.a.ed;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.d.AnonymousClass3;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public class h extends com.tencent.mm.plugin.exdevice.service.s.a {
    protected static final String TAG = h.class.getName();
    private boolean lcX = false;
    f lcY = new f();
    private com.tencent.mm.plugin.exdevice.service.j.a lcZ = new com.tencent.mm.plugin.exdevice.service.j.a(this) {
        final /* synthetic */ h lda;

        {
            this.lda = r1;
        }

        public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
            w.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), b.aj(bArr)});
            if (1 == i) {
                ad.apE().h(str3, str2, false);
            } else if (2 == i) {
                ad.apE().h(str3, str2, true);
            } else {
                w.e(h.TAG, "unknown message type %d", new Object[]{Integer.valueOf(i)});
            }
            if (ad.apt().bF(b.vx(str2)) != null) {
                w.d(h.TAG, "the founded device hasn't been binded");
            }
        }
    };

    public interface a {
        void a(long j, int i, int i2, int i3, long j2);
    }

    public final void apj() {
        if (this.lcX) {
            w.d(TAG, "still scanning. return");
            return;
        }
        d apA = ad.apA();
        j jVar = this.lcZ;
        w.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
        if (apA.lba == null) {
            apA.lba = new c();
            apA.lba.lgD = new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass2(apA, jVar);
            apA.lba.bT(ab.getContext());
        } else if (u.apV().laU == null) {
            w.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else {
            w.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
            if (!u.apV().laU.a(jVar)) {
                w.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
        this.lcX = true;
    }

    public final void acS() {
        if (this.lcX) {
            d apA = ad.apA();
            j jVar = this.lcZ;
            w.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
            if (apA.lba == null) {
                w.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.apV().laU == null) {
                w.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.apV().laU.b(jVar)) {
                w.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.lcX = false;
            return;
        }
        w.d(TAG, "not yet scan. return");
    }

    public final void a(long j, final a aVar) {
        com.tencent.mm.plugin.exdevice.service.f.a bw = this.lcY.bw(j);
        if (bw == null || 2 != bw.fHm) {
            d apA = ad.apA();
            k anonymousClass2 = new com.tencent.mm.plugin.exdevice.service.k.a(this) {
                final /* synthetic */ h lda;

                public final void a(long j, int i, int i2, int i3, long j2) {
                    w.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)});
                    com.tencent.mm.plugin.exdevice.service.f.a bw = this.lda.lcY.bw(j);
                    if (bw != null) {
                        bw.fHm = i2;
                        bw.jSe = j2;
                    } else {
                        w.i(h.TAG, "get connect state faild : %d", new Object[]{Long.valueOf(j)});
                    }
                    aVar.a(j, i, i2, i3, j2);
                }
            };
            w.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
            if (apA.lba == null) {
                apA.lba = new c();
                apA.lba.lgD = new AnonymousClass3(apA, j, anonymousClass2);
                apA.lba.bT(ab.getContext());
                return;
            }
            w.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
            m mVar = u.apV().laU;
            if (mVar == null || !mVar.a(j, anonymousClass2)) {
                w.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
                return;
            }
            return;
        }
        w.d(TAG, "device(" + j + ") has been connected");
        aVar.a(j, 2, 2, 0, bw.jSe);
    }

    public static void bj(long j) {
        d apA = ad.apA();
        w.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
        if (apA.lba == null) {
            w.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
        } else if (u.apV().laU == null) {
            w.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.apV().laU.bE(j)) {
            w.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
        }
    }

    public static boolean a(long j, byte[] bArr, t tVar) {
        boolean z = false;
        if (bArr == null || bArr.length <= 0) {
            w.e(TAG, "no data for transmit");
        } else if (u.apV().laU == null) {
            w.e(TAG, "can not send data");
        } else {
            z = u.apV().laU.b(j, bArr, tVar);
            if (!z) {
                w.e(TAG, "simpleBluetoothSendData error");
            }
        }
        return z;
    }

    public final void c(long j, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            w.e(TAG, "data is null or nil");
            return;
        }
        List<e.b> linkedList;
        w.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[]{Long.valueOf(j), b.aj(bArr)});
        e apE = ad.apE();
        String bG = b.bG(j);
        synchronized (apE.lbt) {
            linkedList = new LinkedList(apE.lbt);
        }
        for (e.b b : linkedList) {
            b.b(bG, bArr, true);
        }
        linkedList.clear();
        for (e.b b2 : apE.lbu.values()) {
            b2.b(bG, bArr, true);
        }
        com.tencent.mm.sdk.b.b edVar = new ed();
        edVar.fIc.mac = bG;
        edVar.fIc.data = bArr;
        com.tencent.mm.sdk.b.a.urY.a(edVar, Looper.getMainLooper());
    }
}
