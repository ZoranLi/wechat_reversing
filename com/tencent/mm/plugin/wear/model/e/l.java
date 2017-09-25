package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.si;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.boe;
import com.tencent.mm.protocal.c.bop;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class l extends a {
    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11032));
        arrayList.add(Integer.valueOf(11034));
        return arrayList;
    }

    protected final boolean vK(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11032:
                boe com_tencent_mm_protocal_c_boe = new boe();
                if (g.sV().getInt("WearPayBlock", 0) == 0) {
                    a.dv(13, 0);
                    a.vJ(15);
                    b siVar = new si();
                    siVar.fZQ.action = 3;
                    com.tencent.mm.sdk.b.a.urY.m(siVar);
                    switch (siVar.fZR.fZS) {
                        case 1:
                            com_tencent_mm_protocal_c_boe.ueH = 0;
                            com_tencent_mm_protocal_c_boe.ulM = "";
                            com_tencent_mm_protocal_c_boe.umX = new com.tencent.mm.bd.b(siVar.fZR.fZW);
                            com_tencent_mm_protocal_c_boe.umY = new com.tencent.mm.bd.b(siVar.fZR.fZX);
                            com_tencent_mm_protocal_c_boe.umZ = siVar.fZR.fZY;
                            com_tencent_mm_protocal_c_boe.una = siVar.fZR.fZZ;
                            break;
                        case 2:
                            com_tencent_mm_protocal_c_boe.ueH = 196611;
                            com_tencent_mm_protocal_c_boe.ulM = ab.getContext().getString(R.l.flK);
                            break;
                        case 3:
                            com_tencent_mm_protocal_c_boe.ueH = 196609;
                            com_tencent_mm_protocal_c_boe.ulM = ab.getContext().getString(R.l.flJ);
                            break;
                        case 4:
                            com_tencent_mm_protocal_c_boe.ueH = 196610;
                            com_tencent_mm_protocal_c_boe.ulM = ab.getContext().getString(R.l.flN);
                            break;
                        case 5:
                            com_tencent_mm_protocal_c_boe.ueH = 196612;
                            com_tencent_mm_protocal_c_boe.ulM = ab.getContext().getString(R.l.flL);
                            break;
                        default:
                            break;
                    }
                }
                com_tencent_mm_protocal_c_boe.ueH = 16777215;
                com_tencent_mm_protocal_c_boe.ulM = ab.getContext().getString(R.l.flM);
                try {
                    return com_tencent_mm_protocal_c_boe.toByteArray();
                } catch (IOException e) {
                    break;
                }
            case 11034:
                bop com_tencent_mm_protocal_c_bop = new bop();
                try {
                    com_tencent_mm_protocal_c_bop.aD(bArr);
                } catch (IOException e2) {
                }
                d.w(ab.getContext(), com_tencent_mm_protocal_c_bop.une, com_tencent_mm_protocal_c_bop.unf);
                break;
        }
        return new byte[0];
    }

    public final boolean vM(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }
}
