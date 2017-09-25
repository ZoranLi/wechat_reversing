package com.tencent.mm.booter;

import com.tencent.mm.a.g;
import com.tencent.mm.a.n;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.gx;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.network.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public final class f {
    public static boolean a(int i, int i2, byte[] bArr, byte[] bArr2, long j) {
        w.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            D(2);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            switch (i2) {
                case 138:
                    D(bArr == null ? 7 : (long) n.c(bArr, 0));
                    break;
                case 268369921:
                    if (bg.bm(bArr) || bArr.length <= 8) {
                        w.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
                        break;
                    }
                    int c = n.c(bArr, 0);
                    int c2 = n.c(bArr, 4);
                    w.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + c + " bufLen:" + c2 + " dump:" + bg.A(bArr, 8));
                    if (c2 != bArr.length - 8) {
                        w.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + bArr.length);
                        break;
                    }
                    Object obj = new byte[c2];
                    System.arraycopy(bArr, 8, obj, 0, c2);
                    e bVar = new b();
                    PByteArray pByteArray = new PByteArray();
                    PByteArray pByteArray2 = new PByteArray();
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    PInt pInt3 = new PInt(0);
                    try {
                        boolean unpack = MMProtocalJni.unpack(pByteArray2, obj, bArr2, pByteArray, pInt, pInt2, pInt3);
                        if (pInt3.value != 0) {
                            com.tencent.mm.sdk.b.b gxVar = new gx();
                            gxVar.fMk.fMl = pInt3.value;
                            boolean m = a.urY.m(gxVar);
                            w.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                            pInt3.value = 0;
                        }
                        if (unpack) {
                            if (pInt.value != -13) {
                                c2 = bVar.y(pByteArray2.value);
                                w.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
                                bVar.sZC = c2;
                                bVar.sZB = (long) obj.length;
                                byte[] PT = bg.PT(ab.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
                                byte[] a = com.tencent.mm.platformtools.n.a(bVar.tad.tob);
                                if (!bg.bm(a) && ad.h(PT, a)) {
                                    new d(bVar, c, j).a(z.MO(), new com.tencent.mm.y.e() {
                                        public final void a(int i, int i2, String str, k kVar) {
                                            w.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
                                        }
                                    });
                                    if (pInt3.value != 0) {
                                        com.tencent.mm.sdk.b.b gxVar2 = new gx();
                                        gxVar2.fMk.fMl = pInt3.value;
                                        boolean m2 = a.urY.m(gxVar2);
                                        w.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m2));
                                        pInt3.value = 0;
                                        break;
                                    }
                                }
                                w.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
                                break;
                            }
                            bVar.sZC = pInt.value;
                            w.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
                            break;
                        }
                        w.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
                        break;
                    } catch (Throwable e) {
                        w.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", e);
                        w.printErrStackTrace("MicroMsg.NotifySyncMgr", e, "", new Object[0]);
                    }
                    break;
                case 1000000205:
                    aa.b bVar2 = new aa.b();
                    try {
                        bVar2.y(bArr);
                        D(bVar2.taj);
                        break;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.NotifySyncMgr", e2, "", new Object[0]);
                        break;
                    }
                case 2147480001:
                    D(7);
                    break;
            }
            return true;
        }
    }

    private static void D(long j) {
        w.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = " + j);
        if ((256 & j) != 0) {
            a.urY.m(new pi());
        }
        if (((-257 & j) & 2) != 0) {
            new d().a(z.MO(), new com.tencent.mm.y.e() {
                public final void a(int i, int i2, String str, k kVar) {
                    w.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
                }
            });
        }
    }

    public static byte[] a(PInt pInt, int i) {
        String dM = dM(i);
        int cU = cU(dM);
        for (int i2 = 1; i2 <= cU; i2++) {
            String str = dM + "/syncResp.bin" + i2;
            if (com.tencent.mm.a.e.aO(str)) {
                byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
                if (bg.bm(d)) {
                    w.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
                    d = com.tencent.mm.a.e.d(str, 0, -1);
                }
                byte[] a = com.tencent.mm.a.k.a(d, g.n((p.rA() + i).getBytes()).getBytes());
                w.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", Integer.valueOf(i2), Integer.valueOf(cU), v(d), v(a), v(r6.getBytes()));
                if (!bg.bm(a)) {
                    pInt.value = i2;
                    return a;
                }
            }
        }
        return null;
    }

    public static void ay(int i, int i2) {
        String dM = dM(i2);
        int cU = cU(dM);
        com.tencent.mm.loader.stub.b.deleteFile(dM + "/syncResp.bin" + i);
        w.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", Integer.valueOf(i), Integer.valueOf(cU));
        if (i == cU) {
            com.tencent.mm.loader.stub.b.deleteFile(dM + "/syncResp.ini");
            w.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
        }
    }

    public static int cU(String str) {
        int i = 0;
        byte[] d = com.tencent.mm.a.e.d(str + "/syncResp.ini", i, -1);
        if (!bg.bm(d)) {
            try {
                i = Integer.parseInt(new String(d));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public static String dM(int i) {
        String str = com.tencent.mm.storage.w.hgq + g.n(("mm" + i).getBytes()) + "/pushSyncResp";
        com.tencent.mm.a.e.aS(str);
        return str;
    }

    public static String v(byte[] bArr) {
        if (bg.bm(bArr)) {
            return "buf is nullOrNil";
        }
        if (bArr.length == 1) {
            return "buf.len is 1: " + Integer.toHexString(bArr[0]);
        }
        return "buf last two[len:" + bArr.length + "]: %s, %s" + Integer.toHexString(bArr[bArr.length - 2] & 255) + ", " + Integer.toHexString(bArr[bArr.length - 1] & 255);
    }
}
