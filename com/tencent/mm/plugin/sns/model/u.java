package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.protocal.c.bcg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u extends k implements j {
    private String fFW;
    private int fJA;
    private b gUA;
    public e gUD;
    public LinkedList<bce> pUC = null;
    public int pUD;

    public u(int i) {
        String str;
        this.fJA = i;
        a aVar = new a();
        aVar.hsm = new bcf();
        aVar.hsn = new bcg();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
        aVar.hsl = 292;
        aVar.hso = 116;
        aVar.hsp = 1000000116;
        this.gUA = aVar.BE();
        String str2 = ae.beO().Gk("@__weixintsnstag").field_md5;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        this.fFW = str;
        bcf com_tencent_mm_protocal_c_bcf = (bcf) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bcf.tce = i;
        com_tencent_mm_protocal_c_bcf.udr = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 292;
    }

    public static s a(s sVar, bce com_tencent_mm_protocal_c_bce) {
        sVar.field_tagId = com_tencent_mm_protocal_c_bce.udq;
        sVar.field_tagName = bg.ap(com_tencent_mm_protocal_c_bce.muQ, "");
        sVar.field_count = com_tencent_mm_protocal_c_bce.jNd;
        sVar.bw(com_tencent_mm_protocal_c_bce.jNe);
        w.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + com_tencent_mm_protocal_c_bce.toString());
        return sVar;
    }

    private static boolean a(List<Long> list, Long l) {
        for (Long longValue : list) {
            if (longValue.longValue() == l.longValue()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> dq(long j) {
        List<String> linkedList = new LinkedList();
        if (this.pUC == null) {
            return linkedList;
        }
        Iterator it = this.pUC.iterator();
        while (it.hasNext()) {
            bce com_tencent_mm_protocal_c_bce = (bce) it.next();
            if (com_tencent_mm_protocal_c_bce.udq == j) {
                it = com_tencent_mm_protocal_c_bce.jNe.iterator();
                while (it.hasNext()) {
                    linkedList.add(((avx) it.next()).tZr);
                }
                return linkedList;
            }
        }
        return linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSnsTagList", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bcg com_tencent_mm_protocal_c_bcg = (bcg) ((b) pVar).hsk.hsr;
            w.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[]{Integer.valueOf(this.pUD)});
            this.pUD = com_tencent_mm_protocal_c_bcg.pUD;
            this.pUC = com_tencent_mm_protocal_c_bcg.jNe;
            String str2 = com_tencent_mm_protocal_c_bcg.udr;
            if (this.fFW.equals(str2)) {
                this.gUD.a(i2, i3, str, this);
                return;
            }
            List bhZ = ae.beQ().bhZ();
            if (this.fJA != 3) {
                Iterator it = bhZ.iterator();
                while (it.hasNext()) {
                    Object obj;
                    Long l = (Long) it.next();
                    Iterator it2 = com_tencent_mm_protocal_c_bcg.jNe.iterator();
                    while (it2.hasNext()) {
                        if (l.longValue() == ((bce) it2.next()).udq) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        it.remove();
                        ae.beQ().dJ(l.longValue());
                    }
                }
            }
            Iterator it3 = com_tencent_mm_protocal_c_bcg.jNe.iterator();
            while (it3.hasNext()) {
                bce com_tencent_mm_protocal_c_bce = (bce) it3.next();
                s dI;
                if (a(bhZ, Long.valueOf(com_tencent_mm_protocal_c_bce.udq))) {
                    dI = ae.beQ().dI(com_tencent_mm_protocal_c_bce.udq);
                    if ((dI.field_tagName != null && !dI.field_tagName.equals(com_tencent_mm_protocal_c_bce.muQ)) || dI.field_count != com_tencent_mm_protocal_c_bce.jNd || b(dI, com_tencent_mm_protocal_c_bce)) {
                        a(dI, com_tencent_mm_protocal_c_bce);
                        ae.beQ().a(dI);
                    }
                } else {
                    dI = new s();
                    a(dI, com_tencent_mm_protocal_c_bce);
                    ae.beQ().a(dI);
                }
            }
            com.tencent.mm.plugin.sns.storage.k Gk = ae.beO().Gk("@__weixintsnstag");
            Gk.field_md5 = str2;
            ae.beO().a(Gk);
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    private static boolean b(s sVar, bce com_tencent_mm_protocal_c_bce) {
        String[] split = sVar.field_memberList.split(",");
        Iterator it = com_tencent_mm_protocal_c_bce.jNe.iterator();
        while (it.hasNext()) {
            boolean z;
            avx com_tencent_mm_protocal_c_avx = (avx) it.next();
            for (String equals : split) {
                if (equals.equals(com_tencent_mm_protocal_c_avx)) {
                    z = true;
                    continue;
                    break;
                }
            }
            z = false;
            continue;
            if (!z) {
                return true;
            }
        }
        return false;
    }
}
