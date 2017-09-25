package com.tencent.mm.modelmulti;

import com.tencent.mm.e.a.gx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class m {
    public static boolean Hv() {
        boolean z;
        h.vJ();
        if (bg.mz((String) h.vI().vr().get(8195, null)).length() > 0) {
            h.vJ();
            if (bg.f((Integer) h.vI().vr().get(15, null)) != 0) {
                z = false;
                w.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
                return z;
            }
        }
        z = true;
        w.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
        return z;
    }

    public static void a(int i, byte[] bArr, byte[] bArr2, long j) {
        b bVar = new b();
        PByteArray pByteArray = new PByteArray();
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt(0);
        try {
            w.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret[%b], noticeid[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3)), Integer.valueOf(pInt3.value));
            if (pInt3.value != 0) {
                com.tencent.mm.sdk.b.b gxVar = new gx();
                gxVar.fMk.fMl = pInt3.value;
                boolean m = a.urY.m(gxVar);
                w.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                pInt3.value = 0;
            }
            if (!r1) {
                w.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
            } else if (pInt.value == -13) {
                bVar.sZC = pInt.value;
                w.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
            } else {
                int y = bVar.y(pByteArray2.value);
                w.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
                bVar.sZC = y;
                bVar.sZB = (long) bArr.length;
                h.vJ();
                byte[] PT = bg.PT(bg.mz((String) h.vI().vr().get(8195, null)));
                byte[] a = n.a(bVar.tad.tob);
                h.vJ();
                h.vG().aF(bVar.tad.jNB, bVar.tad.tSU);
                com.tencent.mm.kernel.a.eM(bVar.tad.jNB);
                if (bg.bm(a) || !ad.h(PT, a)) {
                    w.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
                    return;
                }
                ((com.tencent.mm.plugin.zero.b.b) h.h(com.tencent.mm.plugin.zero.b.b.class)).Hy().a(bVar, i, j);
                if (pInt3.value != 0) {
                    com.tencent.mm.sdk.b.b gxVar2 = new gx();
                    gxVar2.fMk.fMl = pInt3.value;
                    boolean m2 = a.urY.m(gxVar2);
                    w.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m2));
                    pInt3.value = 0;
                }
            }
        } catch (Throwable e) {
            w.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", e);
            w.printErrStackTrace("MicroMsg.NewSyncMgr", e, "", new Object[0]);
        }
    }
}
