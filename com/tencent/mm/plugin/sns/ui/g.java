package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g extends d<alh> {
    private List<alh> fRK = new ArrayList();
    private String naR = "";
    private String path = "";
    private int qoX = 0;
    private int qoY = 0;
    private dl qpo;
    private cc qpp;
    private a qpq;

    public interface a {
        void a(List<alh> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, dl dlVar);

        void bib();
    }

    public g(a aVar) {
        this.qpq = aVar;
    }

    public final void by(List<alh> list) {
        if (this.qpq == null) {
            return;
        }
        if (list != null) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap.clear();
            hashMap2.clear();
            int size = list.size();
            w.d("MicroMsg.ArtistAdapterHelper", "initFixType " + size);
            int i = 0;
            int i2 = 0;
            int i3;
            for (int i4 = 0; i4 < size; i4 = i3 + i4) {
                String str = ((alh) list.get(i4)).msk;
                i3 = i4 + 1 < size ? !str.equals(((alh) list.get(i4 + 1)).msk) ? 1 : i4 + 2 < size ? !str.equals(((alh) list.get(i4 + 2)).msk) ? 2 : 3 : 2 : 1;
                hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                hashMap2.put(Integer.valueOf(i), Integer.valueOf(i3));
                i2 += i3;
                i++;
            }
            this.qoX = i + 1;
            this.qoY = list.size();
            w.d("MicroMsg.ArtistAdapterHelper", "icount " + this.qoX);
            this.fRK = list;
            this.qpq.a(this.fRK, hashMap, hashMap2, this.qoY, this.qoX, this.qpo);
            return;
        }
        this.qpq.bib();
    }

    public final List<alh> bia() {
        List<alh> arrayList = new ArrayList();
        try {
            arrayList.clear();
            this.qpp = null;
            String str = this.path + this.naR + "_ARTISTF.mm";
            if (FileOp.aO(str)) {
                this.qpp = (cc) new cc().aD(FileOp.c(str, 0, -1));
            }
            if (this.qpp == null) {
                String str2 = this.path + this.naR + "_ARTIST.mm";
                this.qpp = com.tencent.mm.plugin.sns.g.a.FP(new String(FileOp.c(str2, 0, (int) FileOp.ki(str2))));
                if (this.qpp == null) {
                    FileOp.deleteFile(str2);
                    return null;
                }
                FileOp.deleteFile(str);
                FileOp.k(str, this.qpp.toByteArray());
            }
            if (this.qpp == null) {
                return null;
            }
            Iterator it = this.qpp.tfz.iterator();
            while (it.hasNext()) {
                aeg com_tencent_mm_protocal_c_aeg = (aeg) it.next();
                String str3 = com_tencent_mm_protocal_c_aeg.msj;
                Iterator it2 = com_tencent_mm_protocal_c_aeg.tsO.iterator();
                while (it2.hasNext()) {
                    alh com_tencent_mm_protocal_c_alh = (alh) it2.next();
                    com_tencent_mm_protocal_c_alh.msk = str3;
                    arrayList.add(com_tencent_mm_protocal_c_alh);
                }
            }
            this.qpo = this.qpp.tfy;
            return arrayList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ArtistAdapterHelper", e, "loadData failed.", new Object[0]);
            return null;
        }
    }

    public final void dE(String str, String str2) {
        this.naR = str;
        this.path = str2;
        fu(true);
    }
}
