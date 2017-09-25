package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.exdevice.e.f;
import com.tencent.mm.plugin.exdevice.e.g;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.CRC32;

public final class e extends d {
    public e(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        w.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    protected final a ah(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            w.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
            return null;
        }
        a fVar = new f();
        try {
            fVar.aD(bArr);
            w.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
            this.laA = fVar;
            return fVar;
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + e.getMessage());
            w.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        int[] iArr;
        int i4;
        int rawOffset;
        w.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", new Object[]{Integer.valueOf(i), str, b.aj(bArr), b.aj(bArr2), Integer.valueOf(i2), Integer.valueOf(i3)});
        a gVar = new g();
        gVar.lfi = J(0, "ok");
        String xL = m.xL();
        if (bg.mA(xL)) {
            iArr = null;
        } else {
            long j;
            String toLowerCase = aa.Pq(xL).toLowerCase();
            w.i("MicroMsg.exdevice.Util", "user md5 : [%s]", new Object[]{toLowerCase});
            if (bg.mA(toLowerCase)) {
                w.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
                j = 0;
            } else {
                i4 = 0;
                char[] toCharArray = toLowerCase.toCharArray();
                if (toCharArray.length > 0) {
                    for (char c : toCharArray) {
                        i4 = (i4 * 31) + c;
                    }
                }
                w.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", new Object[]{Integer.valueOf(i4), Long.valueOf(((long) i4) & 4294967295L)});
                j = r4;
            }
            iArr = new int[]{(int) ((j >> 32) & 4294967295L), (int) (j & 4294967295L)};
        }
        gVar.leV = iArr[0];
        gVar.leW = iArr[1];
        if (!bg.bm(bArr2)) {
            if (bArr2 == null || bArr2.length == 0) {
                i4 = 0;
            } else {
                CRC32 crc32 = new CRC32();
                crc32.update(bArr2);
                i4 = (int) crc32.getValue();
            }
            gVar.leX = i4;
        }
        if (!bg.bm(bArr)) {
            if ((bArr[0] & 4) != 0) {
                gVar.jNo = d.sYH;
            }
            if ((bArr[0] & 8) != 0) {
                gVar.lfc = d.sYK;
            }
            if ((bArr[0] & 2) != 0) {
                gVar.lfb = 2;
            }
            if ((bArr[0] & 16) != 0) {
                gVar.lfd = (int) bg.Ny();
            }
            if ((bArr[0] & 32) != 0) {
                TimeZone timeZone = TimeZone.getDefault();
                rawOffset = timeZone.getRawOffset() / 1000;
                i4 = (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) ? 1 : 0;
                w.i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", new Object[]{Integer.valueOf(rawOffset), Integer.valueOf(i4), Integer.valueOf((rawOffset / 3600) + i4)});
                gVar.lfe = r4;
            }
            if ((bArr[0] & 64) != 0) {
                gVar.lff = b.aqH();
            }
            if ((bArr[0] & 1) != 0) {
                gVar.lfa = m.xN();
            }
        }
        gVar.leY = i2;
        gVar.leZ = i3;
        this.laz = gVar;
        this.lax = (short) 20003;
    }
}
