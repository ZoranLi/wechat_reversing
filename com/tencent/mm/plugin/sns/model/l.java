package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l extends k implements j {
    public static List<Long> pTM = Collections.synchronizedList(new LinkedList());
    private b gUA;
    public e gUD;
    private String hYd;
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

    public l(long j, int i) {
        boolean z;
        this.pQL = j;
        a aVar = new a();
        aVar.hsm = new bar();
        aVar.hsn = new bas();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
        aVar.hsl = 683;
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        this.hYd = stringBuilder.append(h.vI().cachePath).append("ad_detail_session").toString();
        byte[] c = FileOp.c(this.hYd, 0, -1);
        this.gUA = aVar.BE();
        ((bar) this.gUA.hsj.hsr).tmx = j;
        ((bar) this.gUA.hsj.hsr).ubE = n.G(c);
        ((bar) this.gUA.hsj.hsr).tdM = i;
        String str = "MicroMsg.NetSceneSnsAdObjectDetial";
        StringBuilder append = new StringBuilder("req snsId ").append(j).append(" ").append(i.df(j)).append(" scene ").append(i).append(" buf is null? ");
        if (c == null) {
            z = true;
        } else {
            z = false;
        }
        w.d(str, append.append(z).toString());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 683;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        byte[] a;
        Object obj = 1;
        w.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + i2 + " errCode " + i3);
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 4 && i3 == 1) {
                a = n.a(((bas) this.gUA.hsk.hsr).ubE);
                if (a != null) {
                    FileOp.deleteFile(this.hYd);
                    FileOp.b(this.hYd, a, a.length);
                }
                obj = null;
            } else {
                obj = null;
            }
        }
        if (obj == null) {
            this.gUD.a(i2, i3, str, this);
            dl(this.pQL);
            return;
        }
        a = n.a(((bas) this.gUA.hsk.hsr).ubE);
        FileOp.deleteFile(this.hYd);
        FileOp.b(this.hYd, a, a.length);
        baq com_tencent_mm_protocal_c_baq = ((bas) this.gUA.hsk.hsr).ubF;
        if (com_tencent_mm_protocal_c_baq != null) {
            w.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + n.b(com_tencent_mm_protocal_c_baq.ubC.ucj));
            w.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + com_tencent_mm_protocal_c_baq.ubD);
        }
        if (com_tencent_mm_protocal_c_baq == null || com_tencent_mm_protocal_c_baq.ubC == null || com_tencent_mm_protocal_c_baq.ubC.tQU <= 0) {
            if (!(com_tencent_mm_protocal_c_baq == null || com_tencent_mm_protocal_c_baq.ubC == null)) {
                w.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + com_tencent_mm_protocal_c_baq.ubC.ucq.size() + " like: " + com_tencent_mm_protocal_c_baq.ubC.ucn.size());
            }
            a.a(com_tencent_mm_protocal_c_baq);
            this.gUD.a(i2, i3, str, this);
            dl(this.pQL);
            return;
        }
        w.i("MicroMsg.NetSceneSnsAdObjectDetial", com_tencent_mm_protocal_c_baq.ubC.tmx + " will remove by get detail ");
        dl(this.pQL);
        ae.beN().delete(com_tencent_mm_protocal_c_baq.ubC.tmx);
        ae.beP().dB(com_tencent_mm_protocal_c_baq.ubC.tmx);
        this.gUD.a(i2, i3, str, this);
    }
}
