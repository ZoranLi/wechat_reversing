package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.contact.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends a {
    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11008));
        arrayList.add(Integer.valueOf(11009));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        int i2 = 5;
        if (i == 11008) {
            a.vJ(6);
            boh com_tencent_mm_protocal_c_boh = new boh();
            try {
                com_tencent_mm_protocal_c_boh.aD(bArr);
                List linkedList = new LinkedList();
                linkedList.addAll(s.bYl());
                linkedList.addAll(s.bYm());
                ap.yY();
                Cursor j = com.tencent.mm.u.c.wW().j(linkedList, com_tencent_mm_protocal_c_boh.tll);
                if (com_tencent_mm_protocal_c_boh.tll != 0) {
                    i2 = 20;
                }
                boi com_tencent_mm_protocal_c_boi = new boi();
                com_tencent_mm_protocal_c_boi.tll = com_tencent_mm_protocal_c_boh.tll;
                while (j != null && j.moveToNext()) {
                    String string = j.getString(j.getColumnIndex("username"));
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(string);
                    com_tencent_mm_protocal_c_boi.tll++;
                    if (!(Rc.bLe() || Rc.tA())) {
                        bne com_tencent_mm_protocal_c_bne = new bne();
                        com_tencent_mm_protocal_c_bne.jOp = n.c(Rc);
                        com_tencent_mm_protocal_c_bne.jNj = Rc.field_username;
                        com_tencent_mm_protocal_c_boi.tDS.add(com_tencent_mm_protocal_c_bne);
                        if (com_tencent_mm_protocal_c_boi.tDS.size() >= i2) {
                            com_tencent_mm_protocal_c_boi.umy = j.moveToNext();
                            break;
                        }
                    }
                }
                w.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_boh.tll), Integer.valueOf(com_tencent_mm_protocal_c_boi.tll), Integer.valueOf(com_tencent_mm_protocal_c_boi.tDS.size())});
                if (j != null) {
                    j.close();
                }
                try {
                    return com_tencent_mm_protocal_c_boi.toByteArray();
                } catch (IOException e) {
                    return null;
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e2, "", new Object[0]);
                return null;
            }
        } else if (i != 11009) {
            return null;
        } else {
            a.vJ(7);
            bnk com_tencent_mm_protocal_c_bnk = new bnk();
            try {
                com_tencent_mm_protocal_c_bnk.aD(bArr);
                bnl com_tencent_mm_protocal_c_bnl = new bnl();
                ap.yY();
                Cursor cj = com.tencent.mm.u.c.wR().cj(null);
                int i3 = com_tencent_mm_protocal_c_bnk.tll;
                while (cj != null && cj.moveToNext()) {
                    if (i3 > 0) {
                        i3--;
                    } else {
                        String string2 = cj.getString(0);
                        ap.yY();
                        af Rc2 = com.tencent.mm.u.c.wR().Rc(string2);
                        bne com_tencent_mm_protocal_c_bne2 = new bne();
                        com_tencent_mm_protocal_c_bne2.jOp = n.c(Rc2);
                        com_tencent_mm_protocal_c_bne2.jNj = Rc2.field_username;
                        com_tencent_mm_protocal_c_bnl.tDS.add(com_tencent_mm_protocal_c_bne2);
                        if (com_tencent_mm_protocal_c_bnl.tDS.size() >= 5) {
                            com_tencent_mm_protocal_c_bnl.umy = cj.moveToNext();
                            break;
                        }
                    }
                }
                if (cj != null) {
                    cj.close();
                }
                com_tencent_mm_protocal_c_bnl.tll = com_tencent_mm_protocal_c_bnk.tll + com_tencent_mm_protocal_c_bnl.tDS.size();
                try {
                    return com_tencent_mm_protocal_c_bnl.toByteArray();
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e22, "", new Object[0]);
                    return null;
                }
            } catch (Throwable e222) {
                w.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e222, "", new Object[0]);
                return null;
            }
        }
    }

    protected final boolean vL(int i) {
        if (i == 11008 || i == 11009) {
            return true;
        }
        return super.vL(i);
    }

    protected final boolean vK(int i) {
        if (i == 11008 || i == 11009) {
            return true;
        }
        return super.vK(i);
    }
}
