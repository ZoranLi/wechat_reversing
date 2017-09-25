package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.model.g.AnonymousClass2;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public final class i extends h<String, Integer, Boolean> {
    private String arH = "";
    private n hha = null;
    private String nif;
    private int pTG;
    private String pTH;
    private List<alh> pTI;

    public final /* synthetic */ Object bed() {
        String EB = com.tencent.mm.plugin.sns.data.i.EB(this.nif);
        String du = am.du(this.pTH, this.nif);
        if (!FileOp.aO(du + EB)) {
            b(this.nif, EB, this.pTI);
        }
        this.hha = com.tencent.mm.plugin.sns.data.i.EK(du + EB);
        ae.ayz().post(new AnonymousClass2(ae.beI(), 0, this.nif, this.hha));
        w.i("MicroMsg.MutiImageLoader", "deocde done bm " + this.hha + " requestid " + this.nif + " " + du + EB);
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        ae.beI().pTl.remove(this.arH);
        ae.beI().b(this.arH, this.hha);
    }

    public i(String str, String str2, List<alh> list) {
        ae.beI().pTl.add(str);
        this.nif = str2;
        this.pTH = ae.getAccSnsPath();
        this.pTG = ae.beS();
        this.pTI = list;
        this.arH = str;
    }

    public final ae bec() {
        return ae.ayx();
    }

    private boolean b(String str, String str2, List<alh> list) {
        w.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + str + " " + str2);
        List linkedList = new LinkedList();
        int i = 0;
        for (alh com_tencent_mm_protocal_c_alh : list) {
            String str3;
            String f = com.tencent.mm.plugin.sns.data.i.f(com_tencent_mm_protocal_c_alh);
            String e = com.tencent.mm.plugin.sns.data.i.e(com_tencent_mm_protocal_c_alh);
            String du = am.du(this.pTH, com_tencent_mm_protocal_c_alh.mQY);
            if (!FileOp.aO(du + f)) {
                if (!FileOp.aO(du + e)) {
                    String l = com.tencent.mm.plugin.sns.data.i.l(com_tencent_mm_protocal_c_alh);
                    if (FileOp.aO(du + l)) {
                        str3 = l;
                    } else {
                        str3 = com.tencent.mm.plugin.sns.data.i.m(com_tencent_mm_protocal_c_alh);
                    }
                    r.a(du, str3, e, (float) ae.beT());
                }
                r.b(du, e, f, (float) ae.beS());
            }
            n EK = com.tencent.mm.plugin.sns.data.i.EK(du + f);
            if (EK == null) {
                FileOp.deleteFile(du + f);
                w.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! " + f);
                return false;
            }
            linkedList.add(EK);
            w.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + EK + " " + du + f);
            int i2 = i + 1;
            if (i2 < 4) {
                i = i2;
            }
        }
        try {
            str3 = am.du(this.pTH, str);
            FileOp.kl(str3);
            d.a(com.tencent.mm.plugin.sns.data.i.h(linkedList, this.pTG), 100, CompressFormat.JPEG, str3 + str2, false);
            return true;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.MutiImageLoader", e2, "makeMutilMedia failed: " + str2, new Object[0]);
            return false;
        }
    }
}
