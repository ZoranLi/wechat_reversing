package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class f {
    public HashMap<Long, a> lgI = new HashMap();

    public static class a {
        public byte[] aMt;
        public String fGs;
        public int fHm;
        public long jSe;
        public long lgJ;
        public byte[] lgK;
        public byte[] lgL;
        public boolean lgM;
        public String mURL;
    }

    public final boolean bt(long j) {
        if (bu(j) == 2) {
            return true;
        }
        return false;
    }

    public final int bu(long j) {
        if (this.lgI.containsKey(Long.valueOf(j))) {
            return ((a) this.lgI.get(Long.valueOf(j))).fHm;
        }
        return 0;
    }

    public final a bv(long j) {
        if (!this.lgI.containsKey(Long.valueOf(j))) {
            bA(j);
        }
        return (a) this.lgI.get(Long.valueOf(j));
    }

    public final a bw(long j) {
        if (this.lgI.containsKey(Long.valueOf(j))) {
            return (a) this.lgI.get(Long.valueOf(j));
        }
        a aVar = new a();
        aVar.lgJ = j;
        aVar.lgL = null;
        aVar.aMt = null;
        aVar.lgK = null;
        aVar.fGs = null;
        aVar.mURL = null;
        aVar.fHm = 0;
        aVar.lgM = false;
        aVar.jSe = 0;
        this.lgI.put(Long.valueOf(j), aVar);
        return aVar;
    }

    public final boolean bx(long j) {
        w.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[]{Long.valueOf(j)});
        a bv = bv(j);
        if (bv == null) {
            w.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            return false;
        }
        bv.lgM = true;
        return true;
    }

    public final boolean by(long j) {
        w.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[]{Long.valueOf(j)});
        a bv = bv(j);
        if (bv == null) {
            w.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            return false;
        }
        bv.lgM = false;
        return true;
    }

    public final boolean bz(long j) {
        w.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[]{Long.valueOf(j)});
        a bv = bv(j);
        if (bv != null) {
            return bv.lgM;
        }
        w.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
        return false;
    }

    private void bA(long j) {
        b vi = ad.apt().vi(String.valueOf(j));
        if (vi == null) {
            w.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[]{Long.valueOf(j)});
            return;
        }
        a aVar = new a();
        aVar.lgJ = j;
        aVar.lgL = vi.field_authBuf;
        aVar.aMt = vi.field_sessionKey;
        aVar.lgK = vi.field_sessionBuf;
        aVar.fGs = vi.field_brandName;
        aVar.mURL = vi.field_url;
        aVar.fHm = 0;
        aVar.lgM = false;
        this.lgI.put(Long.valueOf(j), aVar);
        w.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[]{Long.valueOf(j)});
    }

    public final byte[] l(long j, int i) {
        if (j < 0) {
            w.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
            return null;
        }
        a aVar = (a) this.lgI.get(Long.valueOf(j));
        if (aVar == null) {
            bA(j);
            aVar = (a) this.lgI.get(Long.valueOf(j));
        }
        if (aVar == null) {
            return null;
        }
        byte[] bArr;
        switch (i) {
            case 1:
                bArr = aVar.lgL;
                break;
            case 2:
                bArr = aVar.aMt;
                break;
            case 3:
                bArr = aVar.lgK;
                break;
            default:
                bArr = null;
                break;
        }
        return bArr;
    }

    public final void a(long j, byte[] bArr, int i) {
        if (j < 0 || bArr == null || bArr.length == 0) {
            boolean z;
            int i2;
            String str = "MicroMsg.exdevice.ExdeviceInfoManager";
            String str2 = "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j);
            if (bArr == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (bArr == null) {
                i2 = -1;
            } else {
                i2 = bArr.length;
            }
            objArr[2] = Integer.valueOf(i2);
            w.e(str, str2, objArr);
            return;
        }
        a aVar = (a) this.lgI.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = new a();
            aVar.lgJ = j;
        }
        switch (i) {
            case 1:
                aVar.lgL = bArr;
                break;
            case 2:
                aVar.aMt = bArr;
                break;
            case 3:
                aVar.lgK = bArr;
                break;
            default:
                w.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        this.lgI.put(Long.valueOf(j), aVar);
    }
}
