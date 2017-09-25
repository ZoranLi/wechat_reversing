package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa extends com.tencent.mm.plugin.exdevice.service.j.a implements e {
    static Object hvG = new Object();
    private static final byte[] ldJ = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static aa ldK;
    static LinkedList<String> ldO = new LinkedList();
    private static HashMap<String, fm> ldP = new HashMap(32);
    final aj iUX = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ aa ldQ;

        {
            this.ldQ = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
            ad.apA().a(0, this.ldQ);
            return true;
        }
    }, true);
    boolean lcX = false;
    volatile String lcq;
    a ldL;
    HashMap<String, byte[]> ldM = new HashMap();
    LinkedList<k> ldN = new LinkedList();

    public interface a {
        void a(String str, byte[] bArr, boolean z);
    }

    public static aa apq() {
        if (ldK != null) {
            return ldK;
        }
        aa aaVar = new aa();
        ldK = aaVar;
        return aaVar;
    }

    private aa() {
    }

    public final void lP(int i) {
        w.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[]{Integer.valueOf(i)});
        this.iUX.KH();
        if (this.lcX) {
            d apA = ad.apA();
            w.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            if (this == null) {
                w.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            } else if (apA.lba == null) {
                w.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.apV().laU == null) {
                w.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.apV().laU.c(i, apA.lbg)) {
                w.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.lcX = false;
            this.lcq = null;
            this.ldM.clear();
            ap.vd().b(542, this);
            Iterator it = this.ldN.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar != null) {
                    ap.vd().c(kVar);
                }
            }
            this.ldN.clear();
            if (this.ldL != null) {
                this.ldL.a(null, null, true);
            }
            this.ldL = null;
        } else {
            w.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
        }
        synchronized (hvG) {
            ldO.clear();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, byte[] r14) {
        /*
        r7 = this;
        r0 = r7.ldM;
        r0 = r0.containsKey(r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        if (r11 != 0) goto L_0x0015;
    L_0x000b:
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r1 = "deviceMac is null";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        goto L_0x0008;
    L_0x0015:
        r0 = ":";
        r1 = "";
        r1 = r11.replaceAll(r0, r1);
        r2 = ldJ;
        r0 = com.tencent.mm.sdk.platformtools.bg.bm(r14);
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = com.tencent.mm.sdk.platformtools.bg.bm(r2);
        if (r0 != 0) goto L_0x0031;
    L_0x002d:
        r0 = r2.length;
        r3 = r14.length;
        if (r0 <= r3) goto L_0x009b;
    L_0x0031:
        r0 = -1;
    L_0x0032:
        r2 = -1;
        if (r0 == r2) goto L_0x00b1;
    L_0x0035:
        r2 = r0 + 9;
        r3 = r14.length;
        if (r2 > r3) goto L_0x00aa;
    L_0x003a:
        r0 = r0 + 9;
        r0 = new byte[r0];
        r2 = 0;
        r3 = 0;
        r4 = r0.length;
        java.lang.System.arraycopy(r14, r2, r0, r3, r4);
        r2 = "MicroMsg.exdevice.ScanDeviceLogic";
        r3 = "hakon, scanFound mac:%s, realAd:%s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r1;
        r5 = 1;
        r6 = com.tencent.mm.plugin.exdevice.j.b.aj(r0);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r2 = r7.ldM;
        r2.put(r1, r0);
    L_0x005f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r7.lcq;
        r0 = r0.append(r1);
        r1 = "_";
        r0 = r0.append(r1);
        r0 = r0.append(r11);
        r0 = r0.toString();
        r1 = ldP;
        r1 = r1.containsKey(r0);
        if (r1 != 0) goto L_0x00ed;
    L_0x0081:
        r1 = hvG;
        monitor-enter(r1);
        r2 = ldO;	 Catch:{ all -> 0x0098 }
        r2 = r2.contains(r0);	 Catch:{ all -> 0x0098 }
        if (r2 == 0) goto L_0x00b8;
    L_0x008c:
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r2 = "hakon, already doing";
        com.tencent.mm.sdk.platformtools.w.d(r0, r2);	 Catch:{ all -> 0x0098 }
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        goto L_0x0008;
    L_0x0098:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        throw r0;
    L_0x009b:
        r0 = 0;
    L_0x009c:
        r3 = r14.length;
        if (r0 >= r3) goto L_0x00a8;
    L_0x009f:
        r3 = com.tencent.mm.plugin.exdevice.j.b.a(r14, r0, r2);
        if (r3 != 0) goto L_0x0032;
    L_0x00a5:
        r0 = r0 + 1;
        goto L_0x009c;
    L_0x00a8:
        r0 = -1;
        goto L_0x0032;
    L_0x00aa:
        r0 = r7.ldM;
        r2 = 0;
        r0.put(r1, r2);
        goto L_0x005f;
    L_0x00b1:
        r0 = r7.ldM;
        r2 = 0;
        r0.put(r1, r2);
        goto L_0x005f;
    L_0x00b8:
        r2 = ldO;	 Catch:{ all -> 0x0098 }
        r2.add(r0);	 Catch:{ all -> 0x0098 }
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        r1 = new com.tencent.mm.plugin.exdevice.model.k;
        r2 = 1;
        r2 = new java.lang.String[r2];
        r3 = 0;
        r2[r3] = r11;
        r3 = r7.lcq;
        r1.<init>(r2, r3);
        r2 = com.tencent.mm.u.ap.vd();
        r3 = 0;
        r2 = r2.a(r1, r3);
        if (r2 == 0) goto L_0x00dd;
    L_0x00d6:
        r0 = r7.ldN;
        r0.add(r1);
        goto L_0x0008;
    L_0x00dd:
        r1 = ldO;
        r1.remove(r0);
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r1 = "MMCore.getNetSceneQueue().doScene failed!!!";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x0008;
    L_0x00ed:
        r1 = "MicroMsg.exdevice.ScanDeviceLogic";
        r2 = "hakon, hit cache %s, %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r7.lcq;
        r3[r4] = r5;
        r4 = 1;
        r3[r4] = r11;
        com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);
        r1 = ldP;
        r0 = r1.get(r0);
        r0 = (com.tencent.mm.protocal.c.fm) r0;
        r7.a(r0);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.aa.a(int, int, java.lang.String, java.lang.String, java.lang.String, int, byte[]):void");
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.exdevice.ScanDeviceLogic";
        String str3 = "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s";
        Object[] objArr = new Object[4];
        objArr[0] = kVar == null ? "" : Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        w.i(str2, str3, objArr);
        this.ldN.remove(kVar);
        if (i != 0 || i2 != 0 || kVar == null) {
            w.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
        } else if (542 == kVar.getType()) {
            Iterator it = ((k) kVar).apl().tiY.iterator();
            while (it.hasNext()) {
                fm fmVar = (fm) it.next();
                if (bg.mA(fmVar.tiU)) {
                    w.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
                } else {
                    str3 = this.lcq + "_" + fmVar.tiU;
                    synchronized (hvG) {
                        if (ldO.contains(str3)) {
                            ldO.remove(str3);
                        }
                    }
                    if (!ldP.containsKey(str3)) {
                        w.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[]{str3});
                        ldP.put(str3, fmVar);
                    }
                    a(fmVar);
                }
            }
        }
    }

    private void a(fm fmVar) {
        if (fmVar == null) {
            w.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
        } else if (bg.mA(fmVar.tiU)) {
            w.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        } else if (fmVar.thX != 0) {
            w.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[]{fmVar.tiU});
        } else if (fmVar.tjb == null || bg.mA(fmVar.tjb.jNm)) {
            w.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[]{fmVar.tiU});
        } else if (bg.mA(fmVar.tjb.thD) || !fmVar.tjb.thD.equals(this.lcq)) {
            w.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[]{fmVar.jNn, this.lcq});
        } else {
            byte[] bArr = (byte[]) this.ldM.get(fmVar.tiU);
            String str = "MicroMsg.exdevice.ScanDeviceLogic";
            String str2 = "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s";
            Object[] objArr = new Object[5];
            objArr[0] = fmVar.tiU;
            objArr[1] = fmVar.tjb.thD;
            objArr[2] = fmVar.tjb.jNm;
            objArr[3] = fmVar.jNn;
            objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            w.i(str, str2, objArr);
            if (this.ldL != null) {
                if (bArr != null) {
                    bArr = ai(bArr);
                } else {
                    bArr = null;
                }
                this.ldL.a(fmVar.tjb.jNm, bArr, false);
                return;
            }
            w.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
        }
    }

    private static byte[] ai(byte[] bArr) {
        byte[] bArr2 = null;
        int i = 0;
        int i2 = 0;
        while (i < bArr.length - 2) {
            try {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b != (byte) 0) {
                    int i4 = i3 + 1;
                    switch (bArr[i3]) {
                        case (byte) -1:
                            w.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[]{Integer.valueOf(b)});
                            byte[] bArr3 = new byte[(b - 1)];
                            int i5 = b;
                            i = i4;
                            while (i5 > 1) {
                                int i6;
                                if (i2 >= 32 || i2 >= bArr3.length) {
                                    i6 = i;
                                    i = i2;
                                } else {
                                    i4 = i2 + 1;
                                    i6 = i + 1;
                                    bArr3[i2] = bArr[i];
                                    i = i4;
                                }
                                i5--;
                                i2 = i;
                                i = i6;
                            }
                            w.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.aj(bArr3));
                            bArr2 = bArr3;
                            break;
                        default:
                            i = (b - 1) + i4;
                            break;
                    }
                }
                return bArr2;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", e, "", new Object[0]);
                w.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[]{e.getMessage()});
                return null;
            }
        }
        return bArr2;
    }
}
