package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.w;

public final class x implements m {
    private h lgS;

    public x(h hVar) {
        this.lgS = hVar;
    }

    public final boolean b(int i, j jVar) {
        boolean z = false;
        try {
            z = this.lgS.b(i, jVar);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean c(int i, j jVar) {
        boolean z = false;
        try {
            z = this.lgS.c(i, jVar);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final long[] apI() {
        try {
            return this.lgS.apI();
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return null;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        boolean z = false;
        u.apU().by(j);
        try {
            z = this.lgS.a(j, i, kVar);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean bB(long j) {
        boolean z = false;
        u.apU().by(j);
        try {
            z = this.lgS.bB(j);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final long a(p pVar) {
        try {
            return this.lgS.a(pVar);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return -1;
        }
    }

    public final boolean a(i iVar) {
        boolean z = false;
        try {
            z = this.lgS.a(iVar);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        w.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", new Object[]{Long.valueOf(j)});
        try {
            this.lgS.setChannelSessionKey(j, bArr);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
        }
    }

    public final boolean a(String str, boolean z, q qVar) {
        boolean z2 = false;
        w.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        try {
            z2 = this.lgS.a(str, z, qVar);
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z2]);
        }
        return z2;
    }

    public final boolean b(n nVar) {
        try {
            this.lgS.a(nVar);
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean a(j jVar) {
        boolean z = false;
        try {
            z = this.lgS.d(0, jVar);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean b(j jVar) {
        boolean z = false;
        try {
            z = this.lgS.e(0, jVar);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean a(long j, k kVar) {
        boolean z = false;
        try {
            z = this.lgS.b(j, 0, kVar);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean bE(long j) {
        boolean z = false;
        try {
            z = this.lgS.bE(j);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean a(s sVar) {
        boolean z = false;
        try {
            z = this.lgS.a(sVar);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        boolean z = false;
        try {
            z = this.lgS.b(j, bArr, tVar);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }
}
