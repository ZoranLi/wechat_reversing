package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.protocal.c.bbm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;
import java.util.Vector;

public final class p extends k implements j {
    public static List<Long> pTM = new Vector();
    public b gUA;
    public e gUD;
    private long pQL;

    public static boolean dk(long j) {
        if (pTM.contains(Long.valueOf(j))) {
            return false;
        }
        pTM.add(Long.valueOf(j));
        return true;
    }

    private static boolean dl(long j) {
        pTM.remove(Long.valueOf(j));
        return true;
    }

    public p(long j) {
        this.pQL = j;
        a aVar = new a();
        aVar.hsm = new bbl();
        aVar.hsn = new bbm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
        aVar.hsl = h.CTRL_INDEX;
        aVar.hso = 101;
        aVar.hsp = 1000000101;
        this.gUA = aVar.BE();
        ((bbl) this.gUA.hsj.hsr).tmx = j;
        w.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId " + j);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return h.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bbk com_tencent_mm_protocal_c_bbk = ((bbm) this.gUA.hsk.hsr).ucF;
            if (com_tencent_mm_protocal_c_bbk != null) {
                w.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + n.b(com_tencent_mm_protocal_c_bbk.ucj));
            }
            ai.d(com_tencent_mm_protocal_c_bbk);
            this.gUD.a(i2, i3, str, this);
            dl(this.pQL);
            return;
        }
        this.gUD.a(i2, i3, str, this);
        dl(this.pQL);
    }
}
