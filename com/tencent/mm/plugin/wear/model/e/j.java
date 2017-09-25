package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.bd.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bnx;
import com.tencent.mm.protocal.c.bny;
import com.tencent.mm.protocal.c.boc;
import com.tencent.mm.protocal.c.bod;
import com.tencent.mm.protocal.c.bof;
import com.tencent.mm.protocal.c.bog;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends a {
    public String rUu = "";

    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11019));
        arrayList.add(Integer.valueOf(11020));
        arrayList.add(Integer.valueOf(11021));
        arrayList.add(Integer.valueOf(11031));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        boolean z = true;
        switch (i) {
            case 11019:
                List B;
                boolean z2;
                bnx com_tencent_mm_protocal_c_bnx = new bnx();
                try {
                    com_tencent_mm_protocal_c_bnx.aD(bArr);
                } catch (IOException e) {
                }
                bny com_tencent_mm_protocal_c_bny = new bny();
                com_tencent_mm_protocal_c_bny.umQ = com_tencent_mm_protocal_c_bnx.umQ;
                if (com_tencent_mm_protocal_c_bny.umQ) {
                    ap.yY();
                    B = c.wT().B(com_tencent_mm_protocal_c_bnx.tgG, com_tencent_mm_protocal_c_bnx.tVW);
                } else {
                    ap.yY();
                    B = c.wT().A(com_tencent_mm_protocal_c_bnx.tgG, com_tencent_mm_protocal_c_bnx.tVW);
                }
                int i2 = 0;
                while (i2 < 10 && i2 < B.size()) {
                    com_tencent_mm_protocal_c_bny.tHv.add(h.R((au) B.get(i2)));
                    i2++;
                }
                if (B.size() > 10) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com_tencent_mm_protocal_c_bny.umy = z2;
                try {
                    return com_tencent_mm_protocal_c_bny.toByteArray();
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e2, "", new Object[0]);
                    break;
                }
            case 11020:
                a.dv(9, 0);
                a.vJ(8);
                boc com_tencent_mm_protocal_c_boc = new boc();
                try {
                    com_tencent_mm_protocal_c_boc.aD(bArr);
                    this.rUu = com_tencent_mm_protocal_c_boc.tgG;
                    bod com_tencent_mm_protocal_c_bod = new bod();
                    ap.yY();
                    List A = c.wT().A(com_tencent_mm_protocal_c_boc.tgG, com_tencent_mm_protocal_c_boc.tVW);
                    int i3 = 0;
                    while (i3 < 10 && i3 < A.size()) {
                        com_tencent_mm_protocal_c_bod.tHv.add(h.R((au) A.get(i3)));
                        i3++;
                    }
                    if (A.size() <= 10) {
                        z = false;
                    }
                    com_tencent_mm_protocal_c_bod.umy = z;
                    try {
                        return com_tencent_mm_protocal_c_bod.toByteArray();
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e22, "", new Object[0]);
                        break;
                    }
                } catch (IOException e3) {
                    return null;
                }
                break;
            case 11021:
                this.rUu = "";
                break;
            case 11031:
                a.dv(12, 0);
                a.vJ(14);
                bof com_tencent_mm_protocal_c_bof = new bof();
                try {
                    com_tencent_mm_protocal_c_bof.aD(bArr);
                } catch (IOException e4) {
                }
                ap.yY();
                ce cA = c.wT().cA(com_tencent_mm_protocal_c_bof.umI);
                bog com_tencent_mm_protocal_c_bog = new bog();
                String js = q.js(cA.field_imgPath);
                com_tencent_mm_protocal_c_bog.unb = o.e(js, 0, true);
                com_tencent_mm_protocal_c_bog.umI = com_tencent_mm_protocal_c_bof.umI;
                com_tencent_mm_protocal_c_bog.tgI = new b(FileOp.c(js, 0, -1));
                q.E(cA);
                try {
                    return com_tencent_mm_protocal_c_bog.toByteArray();
                } catch (IOException e5) {
                    return null;
                }
        }
        return null;
    }

    protected final boolean vL(int i) {
        switch (i) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }

    protected final boolean vK(int i) {
        switch (i) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }
}
