package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acl;
import com.tencent.mm.protocal.c.acm;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.FileOutputStream;

public final class a extends k implements j {
    public final b gUA;
    private e gUD;
    private aj hqQ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ a qSP;

        {
            this.qSP = r1;
        }

        public final boolean oQ() {
            if (this.qSP.qSO < 0) {
                return false;
            }
            bit com_tencent_mm_protocal_c_bit;
            acm com_tencent_mm_protocal_c_acm = (acm) this.qSP.gUA.hsk.hsr;
            try {
                com_tencent_mm_protocal_c_bit = (bit) com_tencent_mm_protocal_c_acm.tIl.get(this.qSP.qSO);
            } catch (Exception e) {
                w.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + this.qSP.qSO + " not Found");
                com_tencent_mm_protocal_c_bit = null;
            }
            if (!(com_tencent_mm_protocal_c_bit == null || com_tencent_mm_protocal_c_bit.uiz == null || com_tencent_mm_protocal_c_bit.uiy == null)) {
                w.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + com_tencent_mm_protocal_c_acm.jOb + " idx:" + this.qSP.qSO + " id:" + Integer.toHexString(com_tencent_mm_protocal_c_bit.fxo) + " size:" + com_tencent_mm_protocal_c_bit.uiy.tZn + " hdsize:" + com_tencent_mm_protocal_c_bit.uiz.tZn);
                a.a(com_tencent_mm_protocal_c_bit.fxo, true, com_tencent_mm_protocal_c_bit.uiz.tZp.toByteArray());
                a.a(com_tencent_mm_protocal_c_bit.fxo, false, com_tencent_mm_protocal_c_bit.uiy.tZp.toByteArray());
            }
            a aVar = this.qSP;
            aVar.qSO--;
            return true;
        }
    }, true);
    public int qSO = 0;

    public a() {
        int i = 0;
        ap.yY();
        int f = bg.f((Integer) c.vr().get(66052, null));
        if (com.tencent.mm.u.ag.a.hlU.fa(f)) {
            ap.yY();
            i = bg.f((Integer) c.vr().get(66053, null));
        }
        StringBuilder append = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(f)).append(" inver:");
        ap.yY();
        w.d("MicroMsg.NetSceneGetVUserInfo", append.append(bg.f((Integer) c.vr().get(66053, null))).append(" reqver:").append(i).toString());
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new acl();
        aVar.hsn = new acm();
        aVar.uri = "/cgi-bin/micromsg-bin/getvuserinfo";
        aVar.hsl = 167;
        aVar.hso = 60;
        aVar.hsp = 1000000060;
        this.gUA = aVar.BE();
        ((acl) this.gUA.hsj.hsr).jOb = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 167;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            acm com_tencent_mm_protocal_c_acm = (acm) ((b) pVar).hsk.hsr;
            StringBuilder append = new StringBuilder("onGYNetEnd new version:").append(com_tencent_mm_protocal_c_acm.jOb).append(" old version:");
            ap.yY();
            w.d("MicroMsg.NetSceneGetVUserInfo", append.append(bg.f((Integer) c.vr().get(66053, null))).append(" Count:").append(com_tencent_mm_protocal_c_acm.tIl.size()).toString());
            ap.yY();
            c.vr().set(66053, Integer.valueOf(com_tencent_mm_protocal_c_acm.jOb));
            if (com_tencent_mm_protocal_c_acm.tIl.size() <= 0) {
                this.gUD.a(i2, i3, str, this);
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < com_tencent_mm_protocal_c_acm.tIl.size(); i5++) {
                i4 |= ((bit) com_tencent_mm_protocal_c_acm.tIl.get(i5)).fxo;
            }
            ap.yY();
            c.vr().set(66052, Integer.valueOf(i4));
            this.gUD.a(i2, i3, str, this);
            this.qSO = com_tencent_mm_protocal_c_acm.tIl.size() - 1;
            this.hqQ.v(50, 50);
            return;
        }
        w.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public static boolean a(int i, boolean z, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(com.tencent.mm.u.ag.a.hlU.u(i, z));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    w.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            w.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
