package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.er;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public final class b extends c<er> {
    public b() {
        this.usg = er.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        er erVar = (er) bVar;
        if (!(erVar instanceof er)) {
            w.f("MicroMsg.ExtGetSnsDataEventListener", "mismatched event");
            return false;
        } else if (erVar.fIE.fIG == null) {
            return false;
        } else {
            m mVar = new m();
            mVar.b(erVar.fIE.fIG);
            if (mVar.qnk <= 0) {
                w.e("MicroMsg.ExtGetSnsDataEventListener", "sns == null || sns.getLocalid()<=0");
                return false;
            }
            bfc bhd = mVar.bhd();
            erVar.fIF.fIL = 0;
            erVar.fIF.fIP = 0;
            erVar.fIF.fIQ = 0;
            erVar.fIF.fIN = new LinkedList();
            erVar.fIF.fIO = new LinkedList();
            if (bhd.ufB != null) {
                erVar.fIF.fIL = bhd.ufB.tsN;
                if (bhd.ufB.tsN != 1 && bhd.ufB.tsN != 7 && bhd.ufB.tsN != 8) {
                    erVar.fIF.fIN.add(bhd.ufB.msN);
                } else if (bhd.ufB.tsO != null) {
                    int i = 0;
                    while (i < bhd.ufB.tsO.size()) {
                        List list = erVar.fIF.fIN;
                        ae.beI();
                        list.add(g.r((alh) bhd.ufB.tsO.get(i)));
                        list = erVar.fIF.fIO;
                        ae.beI();
                        list.add(g.s((alh) bhd.ufB.tsO.get(i)));
                        if (i == 0 && bhd.ufB.tsO.get(i) != null) {
                            erVar.fIF.fIP = (int) ((alh) bhd.ufB.tsO.get(i)).tPl.tPY;
                            erVar.fIF.fIQ = (int) ((alh) bhd.ufB.tsO.get(i)).tPl.tPZ;
                        }
                        i++;
                    }
                }
            }
            erVar.fIF.fIM = erVar.fIF.fIN.size();
            erVar.fIF.fII = mVar.qnk;
            erVar.fIF.fIH = mVar.field_userName;
            erVar.fIF.fIJ = bhd.ufy;
            erVar.fIF.fIK = (long) bhd.ogM;
            return true;
        }
    }
}
