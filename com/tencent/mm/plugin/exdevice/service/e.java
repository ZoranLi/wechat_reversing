package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.e.a.dg;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.model.d.AnonymousClass4;
import com.tencent.mm.plugin.exdevice.service.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends a {
    private static e lgG = new e();

    private e() {
    }

    public static e apL() {
        return lgG;
    }

    public final boolean V(final String str, final boolean z) {
        w.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        if (str == null) {
            w.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
            return false;
        } else if (u.apV().laU != null) {
            return u.apV().laU.a(str, z, (q) this);
        } else {
            w.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
            d apA = ad.apA();
            Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ e lgH;

                public final void run() {
                    if (u.apV().laU != null) {
                        u.apV().laU.a(str, z, this.lgH);
                    }
                }
            };
            w.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
            if (apA.lba == null) {
                apA.lba = new c();
                apA.lba.lgD = new AnonymousClass4(apA, anonymousClass1);
                apA.lba.bT(ab.getContext());
                return false;
            }
            apA.lba.s(anonymousClass1);
            return false;
        }
    }

    public final void a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
        w.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[]{Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), b.aj(bArr), Double.valueOf(d2), str, Integer.valueOf(i3)});
        com.tencent.mm.sdk.b.b dgVar = new dg();
        String aj = b.aj(bArr);
        if (aj.length() >= 32) {
            aj = aj.substring(0, 8) + "-" + aj.substring(8, 12) + "-" + aj.substring(12, 16) + "-" + aj.substring(16, 20) + "-" + aj.substring(20);
        }
        dgVar.fHe.fHc = aj;
        dgVar.fHe.fHh = d;
        dgVar.fHe.fHf = i;
        dgVar.fHe.fHg = i2;
        dgVar.fHe.fHi = d2;
        dgVar.fHe.fHj = str;
        dgVar.fHe.fHk = i3;
        com.tencent.mm.sdk.b.a.urY.m(dgVar);
    }
}
