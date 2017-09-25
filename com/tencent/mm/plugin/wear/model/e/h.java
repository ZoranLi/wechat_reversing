package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.bno;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h extends a {
    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11000));
        arrayList.add(Integer.valueOf(11003));
        arrayList.add(Integer.valueOf(11035));
        return arrayList;
    }

    public final boolean bvX() {
        return false;
    }

    protected final byte[] l(int i, byte[] bArr) {
        int i2 = 0;
        String str;
        String str2;
        if (i == 11000) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = FileOp.aT(str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e, "handleData", new Object[0]);
            }
            String[] split = str2.split("​​");
            List arrayList = new ArrayList();
            for (int i3 = 0; i3 < split.length; i3++) {
                arrayList.add(split[i3]);
                if (i3 % 50 == 9) {
                    g gVar = g.oUh;
                    g.i("WearCrash", arrayList);
                    arrayList.clear();
                }
            }
            if (arrayList.size() > 0) {
                g gVar2 = g.oUh;
                g.i("WearCrash", arrayList);
                arrayList.clear();
            }
            new File(str).delete();
        } else if (i == 11003) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = FileOp.aT(str);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e2, "handleData", new Object[0]);
            }
            String[] split2 = str2.split("​​");
            int length = split2.length;
            while (i2 < length) {
                w.i("MicroMsg.Wear.LOG", split2[i2]);
                i2++;
            }
            new File(str).delete();
        } else if (i == 11035) {
            bno com_tencent_mm_protocal_c_bno = new bno();
            try {
                com_tencent_mm_protocal_c_bno.aD(bArr);
            } catch (IOException e3) {
            }
            if (a.bvG().rTo.rTF.rUt != null) {
                w.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bno.mvT), a.bvG().rTo.rTF.rUt.jNo, a.bvG().rTo.rTF.rUt.umA, Integer.valueOf(a.bvG().rTo.rTF.rUt.tfT), a.bvG().rTo.rTF.rUt.umB, com_tencent_mm_protocal_c_bno.ukg});
                g.oUh.i(com_tencent_mm_protocal_c_bno.mvT, new Object[]{r2.jNo, r2.umA, Integer.valueOf(r2.tfT), r2.umB, com_tencent_mm_protocal_c_bno.ukg});
            }
        }
        return null;
    }
}
